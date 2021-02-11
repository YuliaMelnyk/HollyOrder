package dao.DAO;

import dao.entity.CartDao;
import dao.entity.ProductDao;
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
 * @author sergeymelnik on 11/2/21
 * @project HollyOrder
 */
public class CartDAO extends AbstractDAO<Cart> implements CartDao {

    @Override
    public void delete(int id) {
//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//        Session session = sessionFactory.openSession();
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            Query query = session.createQuery("delete from Order where id =: id");
            query.setParameter("id", id);
//            int result = query.executeUpdate();


            session.getTransaction().commit();
        } catch(Exception e) {
            session.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при удалении", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
    public void delete(Product product) {

        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(product);
            session.getTransaction().commit();
        } catch(Exception e) {
            session.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при удалении", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

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
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'getAll'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return carts;
    }

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
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'findById'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return cart;
    }

    @Override
    public int insert(Cart cart) {
//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//        Session session = sessionFactory.openSession();
        Session session = null;
        int resultId = 0;


        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            session.save(cart);

//            Query query = session.createQuery("from Order");
//            resultId = query.list().size();

            session.getTransaction().commit();
        } catch(Exception e) {
            session.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return resultId;
    }

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
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
