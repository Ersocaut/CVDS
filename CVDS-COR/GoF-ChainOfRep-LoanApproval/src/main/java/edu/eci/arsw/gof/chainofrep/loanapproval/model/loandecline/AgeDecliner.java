package edu.eci.arsw.gof.chainofrep.loanapproval.model.loandecline;

import java.text.ParseException;
import java.util.Calendar;

import edu.eci.arsw.gof.chainofrep.loanapproval.model.*;


public class AgeDecliner implements LoanDecliner {
	private LoanDecliner next;
	private int curYear = Calendar.getInstance().get(Calendar.YEAR);

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
		
        String dobYear = application.getDob();
        int age = curYear - Integer.parseInt(dobYear.substring(0, 4));
 
        if (age > 65 || age < 18) {
            outcome[0]="Too young or too old";
            return true;
        }
        return next.isApplicationDeclined(application,outcome);
	}

}
