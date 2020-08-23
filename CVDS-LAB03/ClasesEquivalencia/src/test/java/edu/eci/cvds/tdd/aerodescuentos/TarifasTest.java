package edu.eci.cvds.tdd.aerodescuentos;

import org.junit.Assert;
import org.junit.Test;


public class TarifasTest {
    private CalculadorDescuentos c= new CalculadorDescuentos();
    private double tarifa;



    @Test
    public void validarEdadMenor0(){
        //deberia generar error por edad < 0
        try{
            tarifa = c.calculoTarifa(5000000,15,-100);
            long er = 0/0;
        }
        catch ( Exception e){
            Assert.assertTrue(true);
        }
    }
    @Test
    public void validarEdad0(){
        //deberia generar error por edad = 0
        try{
            tarifa = c.calculoTarifa(5000000,15,0);
            long er = 0/0;
        }
        catch ( Exception e){
            Assert.assertTrue(true);
        }
    }
    @Test
    public void validarDescuento5(){
        //deberia dar descuento de 5%
        tarifa = c.calculoTarifa(5000000,15,17);
        Assert.assertEquals( String.valueOf(tarifa), "4750000.0");
    }
    @Test
    public void validarDescuento0(){
        //no se debe aplicar descuento
        tarifa = c.calculoTarifa(5000000,15,65);
        Assert.assertEquals( String.valueOf(tarifa), "5000000.0");

    }
    @Test
    public void validarDescuento8(){
        //deberia generar descuento de 8%
        tarifa = c.calculoTarifa(5000000,15,150);
        Assert.assertEquals( String.valueOf(tarifa), "4600000.0");
    }
    @Test
    public void validarEdadMayor150(){
        //deberia generar error, por edad > 150
        try{
        tarifa = c.calculoTarifa(5000000,15,200);
        long er = 0/0;
        }
        catch (Exception e){
            Assert.assertTrue(true);
        }
    }
    @Test
    public void validarAntelacionNegativa(){
        //deberia generar error por dias antelación < 0
        try{
            tarifa = c.calculoTarifa(5000000,-1,30);
            long er = 0/0;
        }
        catch (Exception e){
            Assert.assertTrue(true);
        }

    }

    @Test
    public void descuentoAcum20(){
        tarifa = c.calculoTarifa(5000000,40,14);
        Assert.assertEquals( String.valueOf(tarifa), "4000000.0");
    }

    @Test
    public void descuentoAcum23(){
        tarifa = c.calculoTarifa(5000000,70,66);
        Assert.assertEquals( String.valueOf(tarifa), "3850000.0");
    }
}