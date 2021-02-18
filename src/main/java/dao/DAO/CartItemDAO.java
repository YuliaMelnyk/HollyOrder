package dao.DAO;

import dao.entity.CartItemDao;
import model.CartItem;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

import javax.swing.*;
import java.util.List;

/**
 * @author yuliiamelnyk on 16/2/21
 * @project HollyOrder
 */
public class CartItemDAO extends AbstractDAO<CartItem> implements CartItemDao {

    @Override
    public List<CartItem> getAll() {
        Session session = null;
        List<CartItem> cartItems = null;

        try{
            session = HibernateUtil.getSessionFactory().openSession();
            cartItems = session.createCriteria(CartItem.class).list();
        } catch(Exception e) {
            session.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error 'getAll'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return cartItems;
    }

    @Override
    public int insert(CartItem cartItem) {

        Session session = null;
        int resultId = 0;

        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            session.save(cartItem);

            Query query = session.createQuery("from CartItem");
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

}
