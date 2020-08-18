/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.gof.chainofrep.loanapproval.model;
import java.text.ParseException;
import java.util.Calendar;


/**
 *
 * @author hcadavid
 */
public class AutomatedLoanEvaluator implements LoanDecliner, Purpose{
	private Purpose next;
	private LoanDecliner loanDecliner;
	
	
	/**
	 * AutomatedLoanEvaluator class constructor  
	 * */
	public AutomatedLoanEvaluator( ) {
		setLoansReasons();
		setLoanDecliners();
	}
	
	/**
	 * method that defines the loans 
	 * */
	private void setLoansReasons() {
		try {
			for( String element : Purpose.loans ) {
				Class class_ = Class.forName(Purpose.package_+element);
				Purpose p = (Purpose) class_.getConstructor().newInstance();
				this.setNextPurpose(p);
			}
			
		}
		catch( Exception e) {
		}
		
	}
	
	/**
	 * the method that defines the reasons why a loan could be rejected 
	 * */
	private void setLoanDecliners() {
		try {
			for( String element : LoanDecliner.reasons ) {
				Class class_ = Class.forName(LoanDecliner.package_+element);
				LoanDecliner  l = (LoanDecliner) class_.getConstructor().newInstance();
				this.setNext(l);
			}
		}
		catch( Exception e) {
		}
		
	}
	
	/**
	 * Method that defines who is responsible if the current LoanDecliner is unable to do the action
	 * @Param l LoanDecliner , that is going to be assignet like "next"   
	 * */
	@Override
	public void setNext( LoanDecliner l ) {
		if( loanDecliner == null ) {
			loanDecliner = l;
		}
		else {
			loanDecliner.setNext(l);
		}
	}
	
	/**
	 * Method that defines who is responsible if the current Purpose is unable to do the action
	 * @Param p Purpose, that is going to be assignet like "next"   
	 * */
	@Override
	public void setNextPurpose( Purpose p ) {
		if( next == null ) {
			next = p;
		}
		else {
			next.setNextPurpose(p);
		}
	}
	
	
    public double getScore(ApplicationDetails ap) {
        double p;
        double loaninc_ratio = (ap.getLoan_Amount()) / (ap.getAnn_Sal());
        
        try {
    		p = next.getScore(ap);
        }
        catch( Exception e) {
        	System.out.println("entreErrorx2");
        	p = 0.815;
        }

        double x = -0.30720295 - 
        		(2.42709152 * loaninc_ratio) - (1.61109691 * 0.01 * ap.getWork_Ex_Year())+p*0.212 ;
        double probability = 1 / (1 + Math.exp(-1 * x));
        double score = probability * 666.67;
        return score;
    }

    public boolean isApplicationDeclined(ApplicationDetails application,String[] outcome) throws ParseException {
        boolean isDecline = false;

        try{
        	isDecline = loanDecliner.isApplicationDeclined(application,outcome);
        }
        catch(Exception e) {
        }
        return isDecline;
    }

}
