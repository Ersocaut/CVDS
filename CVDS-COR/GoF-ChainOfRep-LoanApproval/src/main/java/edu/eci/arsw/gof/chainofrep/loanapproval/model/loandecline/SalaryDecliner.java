package edu.eci.arsw.gof.chainofrep.loanapproval.model.loandecline;

import java.text.ParseException;
import edu.eci.arsw.gof.chainofrep.loanapproval.model.*;

public class SalaryDecliner implements LoanDecliner {
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
		if (application.getAnn_Sal() < 10000) {
            outcome[0]="Too little income";
            return true;
        }
        return next.isApplicationDeclined(application,outcome);
	}
}
