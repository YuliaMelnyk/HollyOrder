package dao.DAO;

import dao.entity.GenericDao;

import java.util.List;

/**
 * The type Abstract dao.
 * abstract class with using generics
 *
 * @param <T> the type parameter
 * @author sergeymelnik on 9/2/21
 * @project HollyOrder
 */

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
