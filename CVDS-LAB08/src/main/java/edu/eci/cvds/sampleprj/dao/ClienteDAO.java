package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.ItemRentado;
import edu.eci.cvds.samples.services.ExcepcionServiciosAlquiler;

import java.util.List;
import java.sql.Date;

public interface ClienteDAO {

    public Cliente load(long id) throws ExcepcionServiciosAlquiler;

    void save(Cliente cli) throws PersistenceException;

    void agregarItemRentado(long docu, Item item, Date fechaini, Date fechafin);

    public List<Cliente> consultarClientes() throws ExcepcionServiciosAlquiler;

    public List<ItemRentado> consultarItemsRentados(long id) throws ExcepcionServiciosAlquiler;
}
