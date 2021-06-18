package dao.DAO;

import dao.entity.CartDao;
import model.Cart;
import model.Product;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

import javax.swing.*;
import java.util.List;

/**
 * The type Cart dao.
 * class CartDAO to make CRUD operations
 *
 * @author sergeymelnik on 11/2/21
 * @project HollyOrder
 */

public class CartDAO extends AbstractDAO<Cart> implements CartDao {

    // delete Cart from database
    @Override
    public void delete(int id) {
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            Query query = session.createQuery("delete from Cart where id =: id");
            query.setParameter("id", id);

            session.getTransaction().commit();
        } catch(Exception e) {
            session.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error in delete", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    /**
     * Delete.
     * delete Product from Cart
     *
     * @param product the product
     */

    public void delete(Product product) {

        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(product);
            session.getTransaction().commit();
        } catch(Exception e) {
            session.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error in delete", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
    // get List of Carts from database
    @Override
    public List<Cart> getAll() {
//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//        Session session = sessionFactory.openSession();
        Session session = null;
        List<Cart> carts = null;

        try{
            session = HibernateUtil.getSessionFactory().openSession();
            carts = session.createCriteria(Cart.class).list();
        } catch(Exception e) {
            session.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error 'getAll'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return carts;
    }
    // get Cart from database
    @Override
    public Cart getByName(String name) {

        Session session = null;
        Cart cart = null;

        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            Criteria userCriteria = session.createCriteria(Cart.class);
            userCriteria.add(Restrictions.eq("id", name));
            cart = (Cart) userCriteria.uniqueResult();

            session.getTransaction().commit();

        } catch(Exception e) {
            session.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error 'findById'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return cart;
    }
    // insert Cart into database
    @Override
    public int insert(Cart cart) {
        Session session = null;
        int resultId = 0;

        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            session.save(cart);

            session.getTransaction().commit();
        } catch(Exception e) {
            session.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error in insert", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return resultId;
    }
    // update Cart in database
    @Override
    public void update(Cart cart) {

        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(cart);
            session.getTransaction().commit();
        } catch(Exception e) {
            session.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error in update", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
