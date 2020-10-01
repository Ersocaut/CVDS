package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.ItemRentado;

import java.util.List;

/**
 * @author Iván Camilo Rincón Saavedra
 * @author Leonardo Galeano
 * @version 10/1/2020
 */
public interface ItemRentadoDAO {
    /**
     * Metodo que consulta todos los Items rentados de la base de datos
     * @return Lista de todos los item rentados
     */
    public List<ItemRentado> load()throws PersistenceException;

    /**
     * Metodo que consulta los items rentados por un cliente especifico
     * @param idCliente, id del cliente sobre el cual se va a consultar
     * @return List<ItemRentado> lista de los items rentados por un cliente
     * @throws PersistenceException
     */
    public List<ItemRentado> consultarItemsRentados(long idCliente) throws PersistenceException;


}
