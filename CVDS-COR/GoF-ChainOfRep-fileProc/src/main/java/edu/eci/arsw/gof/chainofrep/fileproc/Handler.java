package edu.eci.arsw.gof.chainofrep.fileproc;

import java.util.logging.Logger;
import org.apache.commons.io.FilenameUtils;

/**
 *Controller interface, this is the one in charge of saying how the objects are going to yield or attend a request
 *
 *@author Camilo Rincon 
 *@author Leonardo Galeano 
*/
public interface Handler  {
	public static final Logger LOG = Logger.getLogger(DataProcessor.class.getName());
	
	public void setNext( Handler  handler);
	public void loadAndProcessData(String fileName) throws DataLoadException;
	public Handler  getNext();
	
	default String extension(String fileName){
        return FilenameUtils.getExtension(fileName);
    }
	
	

}
