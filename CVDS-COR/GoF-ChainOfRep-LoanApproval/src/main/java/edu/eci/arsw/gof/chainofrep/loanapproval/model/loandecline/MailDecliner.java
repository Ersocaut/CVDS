package edu.eci.arsw.gof.chainofrep.loanapproval.model.loandecline;

import java.text.ParseException;

import edu.eci.arsw.gof.chainofrep.loanapproval.model.ApplicationDetails;
import edu.eci.arsw.gof.chainofrep.loanapproval.model.LoanDecliner;

public class MailDecliner implements LoanDecliner {
	private LoanDecliner next;


	/**
	 * Method that defines who is responsible if the current LoanDecliner is unable to do the action
	 * @Param l LoanDecliner , that is going to be assignet like "next"   
	 * */
	@Override
	public void setNext( LoanDecliner l ) {
		if( next == null ) {
			next = l;
		}
		else {
			next.setNext(l);
		}
	}
	
	@Override
	public boolean isApplicationDeclined(ApplicationDetails application, String[] outcome) throws ParseException {
		String email = application.getEmail();
        if (!(email.contains("@"))){
        	outcome[0]="email not contains the character @";
        	return true;
        }
        if (email.endsWith("edu.co") || email.endsWith("gov.co") ) {
        	outcome[0]="invalid email format";
        	return true;
        }
        
        return next.isApplicationDeclined(application,outcome);
	}
}
