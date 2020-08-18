package edu.eci.arsw.gof.chainofrep.loanapproval.model.loandecline;

import java.text.ParseException;
import edu.eci.arsw.gof.chainofrep.loanapproval.model.*;


public class WorkExpDecliner implements LoanDecliner {
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
		int WorkExp = application.getWork_Ex_Year() * 12 + application.getWork_Ex_Mon();
		 
        if (WorkExp < 6) {
            outcome[0]="Too little working experience";
            return true;
        }
        return next.isApplicationDeclined(application,outcome);
	}

}
