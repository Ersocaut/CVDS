package edu.eci.arsw.gof.chainofrep.loanapproval.model.loanpurpose;
import edu.eci.arsw.gof.chainofrep.loanapproval.model.*;

public class HouseLoan implements Purpose {
	private Purpose next;
	
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
	
	@Override
	public double getScore(ApplicationDetails ap) {
		String purp = ap.getLoan_Purpose();
		
		if (purp.equalsIgnoreCase("House Loan")) {
            return 0.819;
       }
		else {
			return  next.getScore(ap);
		}
		
	}


}
