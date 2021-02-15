package dao.DAO;

import dao.entity.GenericDao;

import java.util.List;

/**
 * @author sergeymelnik on 9/2/21
 * @project HollyOrder
 */

//abstract class with using generics
public class AbstractDAO<T> implements GenericDao<T> {
    @Override
    public int insert(T t) {
        return 0;
    }

    @Override
    public void update(T t) {

    }

    @Override
    public List<T> getAll() {
        return null;
    }

    @Override
    public T getByName(String id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
