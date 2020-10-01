package edu.eci.cvds.sampleprj.dao.mybatis;

import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.sampleprj.dao.TipoItemDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.TipoItemMapper;
import edu.eci.cvds.samples.entities.TipoItem;

import javax.inject.Inject;
import java.util.List;

public class MyBATISTipoItemDAO implements TipoItemDAO {
    @Inject
    private TipoItemMapper TipoItemMapper;

    @Override
    public void save(TipoItem ti) throws PersistenceException {
        try{
            TipoItemMapper.addTipoItem(ti);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al agregar.",e);
        }
    }

    @Override
    public TipoItem load(int id) throws PersistenceException {
        return null;
    }

    @Override
    public List<TipoItem> loadTiposItems() throws PersistenceException {
        return null;
    }
}
