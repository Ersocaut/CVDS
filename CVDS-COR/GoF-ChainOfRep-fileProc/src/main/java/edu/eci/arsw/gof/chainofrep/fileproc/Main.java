/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.gof.chainofrep.fileproc;

/**
 *
 * @author hcadavid
 */
public class Main {
   
    public static void main(String args[]) throws DataLoadException{
        DataProcessor dp=new DataProcessor();
        
        
    	dp.loadAndProcessData("mistados.xml");
    	dp.loadAndProcessData("mistados.xml");
    	dp.loadAndProcessData("mistados.xml");
    	dp.loadAndProcessData("mistados.txt");
    	dp.loadAndProcessData("mistados.xml");
    	dp.loadAndProcessData("mistados.xml");
    	dp.loadAndProcessData("mistados.txt");
    	dp.loadAndProcessData("mistados.json");
    	dp.loadAndProcessData("mistados.xml");
    	dp.loadAndProcessData("mistados.xml");
    	dp.loadAndProcessData("mistados.txt");
    	dp.loadAndProcessData("mistados.txt");
    	dp.loadAndProcessData("mistados.csv");
        dp.loadAndProcessData("mistados.sss");

    }
    
}
