package edu.eci.cvds.servlet;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.lang.Math;
import java.util.ArrayList;
import static java.lang.Math.sqrt;


@ManagedBean(name = "calculadoraBean")
@ApplicationScoped
public class CalculadoraBean {
    private ArrayList<Double> numbers;
    private double mode;
    private double mean;
    private double variance;
    private double standar;
    private int length;
    

    public void calculate(String list) {
    	try {
    		numbers = new ArrayList<Double>();
        	String[] array = list.split(";");
        	for( String string: array) {
        		numbers.add( Double.parseDouble(string) );
        	}
        	calculateAll();
    	}
    	catch(Exception e) {
    		restart();
    	}
    	
    }
    public void restart(){
    	numbers= new ArrayList<Double>();
    	numbers.add(0.0);
    	calculateAll();
    }

    public void calculateMean(ArrayList<Double> list){
    	mean = 0;
        for (Double number:list){
        	mean += number;
        }
        mean/= length;
    }
    public void calculateStandardDeviation(ArrayList<Double> list){
        standar = Math.sqrt(calculateVariance(list));
    }
    /**
     * 
     * @param list
     * @return
     */
    public double calculateVariance(ArrayList<Double> list){
        double act = 0;
        variance =0;
        for (Double number:list){
            act +=  Math.pow(mean - number,2f);
        }
        variance = act/(length-1);
        return variance;
    }
    
    public void calculateMode(ArrayList<Double> list){
        int times = -1;
		int count;
        mode = 0;
        for(int i = 0; i < length; i++){
            double act = numbers.get(i);
            count = 0;
            for (int j = i; j < length; j++){
                if (list.get(j) == act ){
                    count++;
                }
            }
            if (count > times){
                mode = act;
                times = count;
            }
        }
    }
    
    private void calculateAll() {
    	setNumbers(numbers);
    	calculateMean(numbers);
    	calculateMode(numbers);
    	calculateVariance(numbers);
    	calculateStandardDeviation(numbers);
    	
    }

    public ArrayList<Double> getNumbers() {
        return numbers;
    }

    public void setNumbers(ArrayList<Double> numbers) {
        this.numbers = numbers;
        setLength(numbers.size());
    }

    public double getMode() {
        return mode;
    }

    public void setMode(double mode) {
        this.mode = mode;
    }

    public double getMean() {
        return mean;
    }

    public void setMean(double mean) {
        this.mean = mean;
    }

    public double getVariance() {
        return variance;
    }

    public void setVariance(double variance) {
        this.variance = variance;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
    
    public double getStandar() {
        return standar;
    }

    public void setStandar(double standar) {
        this.standar = standar;
    }
}
