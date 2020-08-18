package edu.eci.arsw.gof.chainofrep.loanapproval.model.loandecline;

import java.text.ParseException;
import edu.eci.arsw.gof.chainofrep.loanapproval.model.*;

public class AmountDecliner implements LoanDecliner{
	private final long maxloan_Amount = 450000;
    private final long minLoan_Amount = 500;
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
		long amount = application.getLoan_Amount();
				
        if ((amount < minLoan_Amount)||(amount > maxloan_Amount)){
        	outcome[0] = "the requested quantity is not enough or exceeds the limit";
            return true;
        }
        return next.isApplicationDeclined(application,outcome);
	}
}
