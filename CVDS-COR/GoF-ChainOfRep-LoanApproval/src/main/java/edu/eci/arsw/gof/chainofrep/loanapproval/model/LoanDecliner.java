package edu.eci.arsw.gof.chainofrep.loanapproval.model;

import java.text.ParseException;

public interface LoanDecliner {
	public static final String package_  = "edu.eci.arsw.gof.chainofrep.loanapproval.model.loandecline.";
	public static final String[] reasons= {"AgeDecliner","WorkExpDecliner","SalaryDecliner","MailDecliner","AmountDecliner"};
	public  boolean isApplicationDeclined(ApplicationDetails application,String[] outcome) throws ParseException;
	public void setNext(LoanDecliner next);
}
