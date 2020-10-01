package edu.eci.cvds.sampleprj.dao.mybatis;

import edu.eci.cvds.sampleprj.dao.ClienteDAO;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.ItemRentado;
import edu.eci.cvds.samples.services.ExcepcionServiciosAlquiler;

import javax.inject.Inject;
import java.sql.Date;
import java.util.List;

public class MyBATISClienteDAO implements ClienteDAO {
    @Inject
    private ClienteMapper ClienteMapper;

    @Override
    public Cliente load(long id) throws PersistenceException {
        Cliente cliente = null;
        try{
            cliente = ClienteMapper.consultarCliente(id);
        }
        catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar cliente con id " + id,e);
        }
        return cliente;
    }

    @Override
    public void save(Cliente cli) throws PersistenceException {
        try{
            ClienteMapper.agregarCliente(cli);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al agregar cliente.",e);
        }
    }

    @Override
    public void agregarItemRentado(long docu, Item item, Date fechaini, Date fechafin) throws PersistenceException {

    }

    @Override
    public List<Cliente> consultarClientes() throws PersistenceException {
        return null;
    }

    @Override
    public List<ItemRentado> consultarItemsRentados(long id) throws PersistenceException {
        return null;
    }
}
