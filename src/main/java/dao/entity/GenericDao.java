package dao.entity;

import java.util.List;

/**
 * @author yuliiamelnyk on 2/9/21
 * @project HollyOrder
 */
// generic Interface for DAO
public interface GenericDao<T> {
    int insert(T t);
    void update(T t);
    List<T> getAll();
    T getById(int id);
    void delete(int id);
}
