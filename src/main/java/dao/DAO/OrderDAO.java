package dao.DAO;

import dao.entity.OrderDao;
import model.Order;
import model.Product;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

import javax.swing.*;
import java.util.List;

/**
 * The type Order dao.
 * class OrderDAO to make CRUD operations
 *
 * @author yuliiamelnyk on 16/2/21
 * @project HollyOrder
 */

public class OrderDAO extends AbstractDAO<Order> implements OrderDao {

    @Override
    public void delete(int id) {
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            Query query = session.createQuery("delete from Order where id =: id");
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

    @Override
    public List<Order> getAll() {
        Session session = null;
        List<Order> orders = null;

        try{
            session = HibernateUtil.getSessionFactory().openSession();
            orders = session.createCriteria(Order.class).list();
        } catch(Exception e) {
            session.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error 'getAll'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return orders;
    }

    @Override
    public Order getByName(String name) {

        Session session = null;
        Order order = null;

        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            Criteria userCriteria = session.createCriteria(Order.class);
            userCriteria.add(Restrictions.eq("id", name));
            order = (Order) userCriteria.uniqueResult();

            session.getTransaction().commit();

        } catch(Exception e) {
            session.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error 'findById'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return order;
    }

    @Override
    public int insert(Order order) {

        Session session = null;
        int resultId = 0;


        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            session.save(order);

           Query query = session.createQuery("from Order");
            resultId = query.list().size();

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

    @Override
    public void update(Order order) {

        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(order);
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
