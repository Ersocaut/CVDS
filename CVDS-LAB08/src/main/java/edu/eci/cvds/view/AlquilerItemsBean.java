package edu.eci.cvds.view;

import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquiler;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.BaseStream;

/**
 * @author Iván Camilo Rincón Saavedra
 * @version 10/5/2020
 */
@ManagedBean(name = "Alquiler")
@ApplicationScoped
public class AlquilerItemsBean extends BasePageBean {
    @Inject
    private ServiciosAlquiler serviciosAlquiler;
    private List<Cliente>clientes;

    public void consultarClientes(){
        try {
            clientes = serviciosAlquiler.consultarClientes();
        } catch (ExcepcionServiciosAlquiler excepcionServiciosAlquiler) {
            excepcionServiciosAlquiler.printStackTrace();
        }

    }

}
