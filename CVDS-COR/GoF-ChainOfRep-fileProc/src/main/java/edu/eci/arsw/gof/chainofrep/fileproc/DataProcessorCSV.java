/**
 * 
 */
package edu.eci.arsw.gof.chainofrep.fileproc;

/**
 *CSV data processing class 
 *@author Camilo Rincon  
 *@author Leonardo Galeano
 */
public class DataProcessorCSV implements Handler {
	private Handler next; 
	
	/**
	 * Method that defines who is responsible if the current handler is unable to do the action
	 * @Param handler Handler,handler that is going to be assignet like "next"   
	 * */
	@Override
	public void setNext(Handler handler) {
		boolean valid = handler.getClass() != this.getClass();
		if( next  == null && valid ) {
			next = handler;			
		}
		else if( valid && next.getClass()!= handler.getClass()){
			next.setNext(handler);
		}
	}

	@Override
	public  Handler getNext() {	
		return next;
	}
	
	/**
	 * Method that process the csv Data
	 * @param fileName, String fileName  
	 * @throws DataLoadException, if something went wrong with the extension
	 * */
	@Override
	public void loadAndProcessData(String fileName) throws DataLoadException {
		// TODO Auto-generated method stub
		
		if (extension(fileName).equals("csv")){
            processCSV(fileName);                
        }
		else {
			next.loadAndProcessData(fileName);
		}

	}
	
	
	private void processCSV(String fileName) {
	        LOG.info("Processing CVS...");
	    }
}
