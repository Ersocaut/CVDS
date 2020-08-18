import edu.eci.arsw.gof.chainofrep.loanapproval.model.*;

import static org.junit.Assert.*;
import java.text.ParseException;
import org.junit.Test;

/**
 *@author Camilo Rincon
 *@author Leonardo Galeno
 *@author hcadavid
 *
 *Testing class 
 */
public class LoanEvaluatorTest {
	private AutomatedLoanEvaluator ale;
	private ApplicationDetails ad;
	private String[] outcome;
	
	private void simulateRequest(String first_Name, String middle_Name, String last_Name, String dob, String marital_Status, String ssn, long loan_Amount, String loan_Purpose, String home_Add_Line1, String home_Add_Line2, String home_City, String home_State, int home_Zip, long ph_Home, long ph_Office, long mobile, String email, String description, String emp_Name, long ann_Sal, int work_Ex_Year, int work_Ex_Mon, String designation, String emp_Add_Line1, String emp_Add_Line2, String emp_City, String emp_State, int emp_Zip){
		ale = new AutomatedLoanEvaluator();
			
        ad = new ApplicationDetails(first_Name, middle_Name, last_Name, dob,
        		marital_Status,ssn, loan_Amount, loan_Purpose,home_Add_Line1, 
        		home_Add_Line2, home_City, home_State, home_Zip, ph_Home, ph_Office, mobile, email, 
        		description, emp_Name, ann_Sal, work_Ex_Year, work_Ex_Mon, 
        		designation, emp_Add_Line1, emp_Add_Line2, emp_City, 
        		emp_State, emp_Zip);
        outcome =new String[1];
        
        
	}
    
	@Test
	public void shouldDeclineTooYoung() throws ParseException {
		simulateRequest("John", "", "Connor", "2003-01-01",
                "Single", "11101", 1000, "Home Improvement Loan", "742 de Evergreen Terrace", 
                "", "Springfield", "CA", 0, 0, 0, 0, "john123@hotmail.com", 
                "Loan description", "IBM", 30000, 10, 2, 
                "Officer", "342 SouthLake Av", "", "Yorktown", 
                "VA", 3242323);
	
		assertTrue( ale.isApplicationDeclined(ad, outcome) );
		assertEquals(outcome[0], "Too young or too old");
	}
	
	@Test
	public void shouldPassOnAge() throws ParseException {
		simulateRequest("John", "", "Connor", "1980-01-01",
                "Single", "11101", 1000, "home Improvement Loan", "742 de Evergreen Terrace", 
                "", "Springfield", "CA", 0, 0, 0, 0, "john123@hotmail.com", 
                "Loan description", "IBM", 30000, 10, 2, 
                "Officer", "342 SouthLake Av", "", "Yorktown", 
                "VA", 3242323);

		assertFalse( ale.isApplicationDeclined(ad, outcome)  );
		assertTrue(outcome[0] == null );
		
	}
	
	@Test
	public void shouldDeclineTooOld() throws ParseException {
		simulateRequest("John", "", "Connor", "1930-01-01",
                "Single", "11101", 1000, "Home Improvement Loan", "742 de Evergreen Terrace", 
                "", "Springfield", "CA", 0, 0, 0, 0, "john123@hotmail.com", 
                "Loan description", "IBM", 30000, 10, 2, 
                "Officer", "342 SouthLake Av", "", "Yorktown", 
                "VA", 3242323);
	
		assertTrue( ale.isApplicationDeclined(ad, outcome)  );
		assertEquals(outcome[0], "Too young or too old");
		
	}
    
	@Test
	public void shouldDeclineNotEnoughtExperience( ) throws ParseException {
		simulateRequest("Camilo", "", "Rincon", "1999-01-01",
                "Single", "11101", 1000, "Home Improvement Loan", "742 de Evergreen Terrace", 
                "", "Bogota", "CA", 0, 0, 0, 0, "camilo@hotmail.com", 
                "Loan description", "IBM", 30000, 0, 2, 
                "Officer", "342 SouthLake Av", "", "Yorktown", 
                "VA", 3242323);
		
		assertFalse( !ale.isApplicationDeclined(ad, outcome)  );
		assertEquals(outcome[0], "Too little working experience");
		

	}
	
	@Test
	public void shouldPassWithExperience( ) throws ParseException {
		simulateRequest("Camilo", "", "Rincon", "1999-01-01",
                "Single", "11101", 1000, "Home Improvement Loan", "742 de Evergreen Terrace", 
                "", "Bogota", "CA", 0, 0, 0, 0, "camilo@hotmail.com", 
                "Loan description", "IBM", 30000, 12, 2, 
                "Officer", "342 SouthLake Av", "", "Yorktown", 
                "VA", 3242323);
	
		assertFalse( ale.isApplicationDeclined(ad, outcome)  );
		assertTrue(outcome[0] == null );

	}
	
	@Test
	public void shouldDeclineNotEnoughtSal( )  throws ParseException{
		simulateRequest("Camilo", "", "Rincon", "1999-01-01",
                "Single", "11101", 1000, "Home Improvement Loan", "742 de Evergreen Terrace", 
                "", "Bogota", "CA", 0, 0, 0, 0, "camilo@hotmail.com", 
                "Loan description", "IBM", 800, 12, 2, 
                "Officer", "342 SouthLake Av", "", "Yorktown", 
                "VA", 3242323);
	
		assertFalse( !ale.isApplicationDeclined(ad, outcome)  );
		assertTrue( "Too little income".equals(outcome[0] )   );

	}
	
	@Test
	public void shouldPassSal( ) throws ParseException{
		simulateRequest("Camilo", "", "Rincon", "1999-01-01",
                "Single", "11101", 1000, "Home Improvement Loan", "742 de Evergreen Terrace", 
                "", "Bogota", "CA", 0, 0, 0, 0, "camilo@hotmail.com", 
                "Loan description", "IBM", 10001, 12, 2, 
                "Officer", "342 SouthLake Av", "", "Yorktown", 
                "VA", 3242323);
	
		assertFalse( ale.isApplicationDeclined(ad, outcome)  );
		assertTrue( null ==   outcome[0]  );

	}
	
	
	@Test
	public void shouldGetScoreCreditCard( ) throws ParseException{
		simulateRequest("Ivan", "Camilo", "Rincon", "2001-01-01",
        "Single", "11101", 1000, "Credit Card", "742 de Evergreen Terrace", 
        "", "Springfield", "CA", 0, 0, 0, 0, "camilorincon@hotmail.com", 
        "Loan description", "IBM", 100000, 13, 2, 
        "Officer", "342 SouthLake Av", "", "Yorktown", 
        "VA", 3242323);
		
		assertTrue("278.7114400208519".equals( ale.getScore(ad)+"" ) );	
	}
	
	@Test
	public void shouldGetScoreCarLoan( ) throws ParseException{
		simulateRequest("Jeisson", "", "Stiven", "1998-01-01",
        "Single", "11101", 1000, "car Loan", "742 de Evergreen Terrace", 
        "", "Springfield", "CA", 0, 0, 0, 0, "jeisson1998@hotmail.com", 
        "Loan description", "IBM", 70000, 14, 2, 
        "Officer", "342 SouthLake Av", "", "Yorktown", 
        "VA", 3242323);
		
		assertTrue("274.7654456713823".equals( ale.getScore(ad)+"" ) );
	}
	
	
	
	@Test
	public void shouldGetScoreHouseLoan( ) throws ParseException{
		simulateRequest("Juan", "", "Bernal", "2000-01-01",
        "Single", "11101", 1000, "House Loan", "742 de Evergreen Terrace", 
        "", "Springfield", "CA", 0, 0, 0, 0, "juanbrdi@hotmail.com", 
        "Loan description", "IBM", 80000, 9, 2, 
        "Officer", "342 SouthLake Av", "", "Yorktown", 
        "VA", 3242323);
		
		assertTrue("287.20376536385976".equals( ale.getScore(ad)+"" ) );
	}
	
	@Test
	public void shouldGetScoreEducationalLoan( ) throws ParseException{
		simulateRequest("John", "", "Connor", "1980-01-01",
        "Single", "11101", 1000, "Educational Loan", "742 de Evergreen Terrace", 
        "", "Springfield", "CA", 0, 0, 0, 0, "john123@hotmail.com", 
        "Loan description", "IBM", 60000, 14, 2, 
        "Officer", "342 SouthLake Av", "", "Yorktown", 
        "VA", 3242323);
		
		System.out.println(ale.getScore(ad));
		
		assertTrue("273.80715401885294".equals( ale.getScore(ad)+"" ) );
	}

	@Test
	public void shouldDeclineEmail() throws ParseException{
		simulateRequest("John", "", "Connor", "1980-01-01",
				"Single", "11101", 1000, "Educational Loan", "742 de Evergreen Terrace",
				"", "Springfield", "CA", 0, 0, 0, 0, "john123_hotmail.com",
				"Loan description", "IBM", 60000, 14, 2,
				"Officer", "342 SouthLake Av", "", "Yorktown",
				"VA", 3242323);
		assertFalse( !ale.isApplicationDeclined(ad, outcome)  );
		assertTrue("email not contains the character @".equals(outcome[0]));
	}
	@Test
	public void shouldDeclineDomain() throws ParseException{
		simulateRequest("John", "", "Connor", "1980-01-01",
				"Single", "11101", 1000, "Educational Loan", "742 de Evergreen Terrace",
				"", "Springfield", "CA", 0, 0, 0, 0, "john123@escuelaing.edu.co",
				"Loan description", "IBM", 60000, 14, 2,
				"Officer", "342 SouthLake Av", "", "Yorktown",
				"VA", 3242323);
		assertFalse( !ale.isApplicationDeclined(ad, outcome)  );
		assertTrue("invalid email format".equals(outcome[0]));
	}
}
