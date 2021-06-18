package dao.entity;

import java.util.List;

/**
 * The interface Generic dao.
 * generic Interface for DAO with CRUD operations
 *
 * @param <T> the type parameter
 * @author yuliiamelnyk on 2/9/21
 * @project HollyOrder
 */


public interface GenericDao<T> {
    /**
     * Insert int.
     *
     * @param t the t
     * @return the int
     */
    int insert(T t);

    /**
     * Update.
     *
     * @param t the t
     */
    void update(T t);

    /**
     * Gets all.
     *
     * @return the all
     */
    List<T> getAll();

    /**
     * Gets by name.
     *
     * @param name the name
     * @return the by name
     */
    T getByName(String name);

    /**
     * Delete.
     *
     * @param id the id
     */
    void delete(int id);
}
