/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.gof.chainofrep.fileproc;

/**
 *data processing class 
 *@author hcadavid
 *@author Camilo Rincon  
 *@author Leonardo Galeano
*/

public class DataProcessor implements Handler {
	private Handler next; 
	private final String package_ = "edu.eci.arsw.gof.chainofrep.fileproc.";
	private final String name = "DataProcessor";
	
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
    public void loadAndProcessData(String fileName)  throws DataLoadException {
    	LOG.info("Loading data...");
        try {
    		Class class_ = Class.forName(package_+name+extension(fileName).toUpperCase() );
    		Handler h = (Handler) class_.getDeclaredConstructor().newInstance();
    		this.setNext(h);
        }
        catch(Exception e) {
        	throw new DataLoadException("Format not supported:"+extension(fileName));
        }
        /**
        DATA PROCESSING CORE
        */
        LOG.info("Processing data...");
        next.loadAndProcessData(fileName);
        LOG.info("Done. Execution finished.");
    }
     

}


