package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.samples.entities.Item;

/**
 * @author Iván Camilo Rincón Saavedra
 * @version 10/1/2020
 */
public interface ItemDAO {

    public void save(Item it) throws PersistenceException;

    public Item load(int id) throws PersistenceException;

}
