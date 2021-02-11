package dao.DAO;

import dao.entity.GenericDao;

import java.util.List;

/**
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
    public T getById(int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
