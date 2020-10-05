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
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class ServiciosAlquilerTest {

    @Inject
    private SqlSession sqlSession;

    ServiciosAlquiler serviciosAlquiler;

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

}