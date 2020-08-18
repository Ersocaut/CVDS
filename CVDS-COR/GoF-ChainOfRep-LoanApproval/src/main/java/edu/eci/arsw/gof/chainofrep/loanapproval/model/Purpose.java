package edu.eci.arsw.gof.chainofrep.loanapproval.model;

public interface Purpose{
	public final static String package_="edu.eci.arsw.gof.chainofrep.loanapproval.model.loanpurpose.";
	public final static String[] loans= {"CarLoan","CreditCard","DebtConsolidation","EducationalLoan","HomeImprovementLoan","HouseLoan"};
	public void setNextPurpose(Purpose next);
	public  double getScore(ApplicationDetails ap);
	
}
