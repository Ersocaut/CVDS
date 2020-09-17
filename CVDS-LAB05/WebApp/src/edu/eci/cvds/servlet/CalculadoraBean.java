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
    

    
    public void restart(){
    	numbers= null;
    	mode=0;
    	mean=0;
    	variance=0;
    	standar=0;
    	length = 0;
    }

    public void calculate(String list) {
    	System.out.print("enterrerer");
    	numbers = new ArrayList<Double>();
    	String[] array = list.split(";");
    	for( String string: array) {
    		numbers.add( Double.parseDouble(string) );
    	}
    	setNumbers(numbers);
    	calculateMean(numbers);
    	calculateMode(numbers);
    	calculateStandardDeviation(numbers);
    	calculateVariance(numbers);
    }
    
    public double calculateMean(ArrayList<Double> list){
        setNumbers(list);
        int prom = 0;
        for (int i = 0; i < length; i++){
            prom += numbers.get(i);
        }
        return prom/ length;
    }
    public double calculateStandardDeviation(ArrayList<Double> list){
        return sqrt(calculateVariance(list));
    }
    public double calculateVariance(ArrayList<Double> list){
        double media = calculateMean(list);
        double act = 0;
        for (int index = 0; index < length; index++){
            double temp = (media - numbers.get(index)) * (media - numbers.get(index) ) ;
            act += temp;
        }
        return act/media;
    }
    public double calculateMode(ArrayList<Double> list){
        setNumbers(list);
        int times = -1,count;
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
        return mode;
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
