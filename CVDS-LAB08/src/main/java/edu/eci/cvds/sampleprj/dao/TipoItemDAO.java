package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.samples.entities.TipoItem;

import java.util.List;

public interface TipoItemDAO {

    void save(TipoItem ti) throws PersistenceException;

    TipoItem load(int id) throws PersistenceException;

    List<TipoItem> loadTiposItems() throws PersistenceException;
}
