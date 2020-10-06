package edu.eci.cvds.test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.ItemRentado;
import edu.eci.cvds.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquilerFactory;
import org.apache.ibatis.session.SqlSession;
import org.checkerframework.dataflow.qual.TerminatesExecution;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class ServiciosAlquilerTest {
    @Inject
    private SqlSession sqlSession;
    @Inject
    private ServiciosAlquiler serviciosAlquiler;

    private long idCliente;
    private long tarifa;
    private int idItem;
    private int idTipoItem;
    private int numDias;
    private boolean vetado;


    public ServiciosAlquilerTest() {
        serviciosAlquiler = ServiciosAlquilerFactory.getInstance().getServiciosAlquilerTesting();
    }

    @Before
    public void setUp() {
    }


    @Test
    public void emptyDB() {
        for(int i = 1; i < 100; i += 10) {
            boolean r = false;
            try {
                Cliente cliente = serviciosAlquiler.consultarCliente(6869 + i);
            } catch(ExcepcionServiciosAlquiler e) {
                r = true;
            } catch(IndexOutOfBoundsException e) {
                r = true;
            }
            // Validate no Client was found;
            Assert.assertTrue(r);
        };
    }


    @Test
    public void consultandoUnCliente() throws ExcepcionServiciosAlquiler {
        try {
            Cliente cliente = serviciosAlquiler.consultarCliente(2160666);
            Assert.assertEquals("Javier López",cliente.getNombre());
        } catch(ExcepcionServiciosAlquiler e) {
            throw new ExcepcionServiciosAlquiler("Error Prueba Consultar Cliente.",e);
        }
    }

    @Test
    public void itemNoFound(){
        boolean found = false;
        try{
            Item item = serviciosAlquiler.consultarItem(526341);
        }
        catch (ExcepcionServiciosAlquiler e){
            found = true;
        }
        catch (IndexOutOfBoundsException e){
            found = true;
        }
        finally{
            Assert.assertTrue(found);
        }
    }

    @Test
    public void insertarItemRentado() throws ExcepcionServiciosAlquiler {
        boolean insert = true;
        try{
            Item item = serviciosAlquiler.consultarItem(102);
            serviciosAlquiler.registrarAlquilerCliente(Date.valueOf("2019-02-01"),999,item,5);
        }
        catch(ExcepcionServiciosAlquiler e){
            insert = false;
        }
        finally{
            Assert.assertTrue(insert);
        }
    }
    /*
    @Test
    public void consultarMultaAlquilerValido() throws ExcepcionServiciosAlquiler {
        idItem = 4;
        Date date = java.sql.Date.valueOf("2013-05-05");
        System.out.println( ( serviciosAlquiler.consultarItemsRentados(idItem));
        System.out.println( serviciosAlquiler.consultarMultaAlquiler(idItem,date ));
    }
**/

    @Test
    public void consultarCostoAlquilerValido() throws ExcepcionServiciosAlquiler{
        long answer = -1;
        idItem = 2;
        numDias = 20;
        answer = serviciosAlquiler.consultarCostoAlquiler(idItem, numDias );
        Assert.assertEquals( answer ,serviciosAlquiler.consultarItem(idItem).getTarifaxDia() * numDias );
    }

    @Test
    public void consultarCostoAlquilExcepcionDia(){
        long answer = -1;
        idItem = 2;
        numDias = -20;
        try {
            answer = serviciosAlquiler.consultarCostoAlquiler(idItem, numDias );
        } catch (ExcepcionServiciosAlquiler excepcionServiciosAlquiler) {
            Assert.assertEquals(ExcepcionServiciosAlquiler.DIAS_INVALIDOS,excepcionServiciosAlquiler.getMessage());
        }
    }

    @Test
    public void consultarCostoAlquilExcepcionItem(){
        long answer = -1;
        idItem = -2;
        numDias = 20;
        try {
            answer = serviciosAlquiler.consultarCostoAlquiler(idItem, numDias );
        } catch (ExcepcionServiciosAlquiler excepcionServiciosAlquiler) {
            Assert.assertEquals(ExcepcionServiciosAlquiler.NO_ITEM,excepcionServiciosAlquiler.getMessage());
        }
    }


    @Test
    public void actualizarTarifaItemValido() throws ExcepcionServiciosAlquiler {
        tarifa = 30000;
        idItem = 2;

        long currentTarifa = serviciosAlquiler.consultarItem(idItem).getTarifaxDia();
        serviciosAlquiler.actualizarTarifaItem( idItem, tarifa);
        currentTarifa = serviciosAlquiler.consultarItem(idItem).getTarifaxDia();
        Assert.assertEquals( tarifa,currentTarifa );
    }

    @Test
    public void actualizarTarifaItemExcepcionItem(){
        tarifa = 30000;
        idItem = -1100;
        try {
            serviciosAlquiler.actualizarTarifaItem( idItem, tarifa);
        } catch (ExcepcionServiciosAlquiler excepcionServiciosAlquiler) {
            Assert.assertEquals( excepcionServiciosAlquiler.getMessage(),ExcepcionServiciosAlquiler.NO_ITEM);
        }


    }
    @Test
    public void actualizarTarifaItemExcepcionTarifa(){
        tarifa = -151515;
        idItem = 2;
        try {
            serviciosAlquiler.actualizarTarifaItem( idItem, tarifa);
        } catch (ExcepcionServiciosAlquiler excepcionServiciosAlquiler) {
            Assert.assertEquals( excepcionServiciosAlquiler.getMessage(),ExcepcionServiciosAlquiler.TARIFA_INVALIDA);
        }
    }



    @Test
    public void vetarClienteValido(){
        Cliente cliente = null;
        vetado = true;
        idCliente = 3146879;
        try {
            serviciosAlquiler.vetarCliente(idCliente, vetado );
            cliente = serviciosAlquiler.consultarCliente(idCliente);
            Assert.assertEquals(cliente.isVetado(),vetado );
        } catch (ExcepcionServiciosAlquiler excepcionServiciosAlquiler) {
        }
    }


    @Test
    public void vetarClienteExcepcionCliente(){
        long answer = -1;
        vetado = true;
        idCliente = 3146879;
        String error = "Error al vetar al cliente con id: "+idCliente;
        try {
            serviciosAlquiler.vetarCliente(idCliente, vetado );
        } catch (ExcepcionServiciosAlquiler excepcionServiciosAlquiler) {
            Assert.assertEquals(error,excepcionServiciosAlquiler.getMessage());
        }
    }

}