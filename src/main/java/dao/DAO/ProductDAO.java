package dao.DAO;

import model.Product;
import dao.entity.ProductDao;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.List;

/**
 * The type Product dao.
 * Class DAO to get data of Product from dataBase
 *
 * @author yuliiamelnik on 11/2/21
 * @project HollyOrder
 */

public class ProductDAO extends AbstractDAO<Product> implements ProductDao {


    //Method to delete Product from Cart
    @Override
    public void delete(int id) {

        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            Query query = session.createQuery("delete from Product where id =: id");
            query.setParameter("id", id);
//            int result = query.executeUpdate();

            session.getTransaction().commit();
        } catch(Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    //method to get all Products in List in Cart
    @Override
    public List<Product> getAll() {

        Session session = null;
        List<Product> product = null;

        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            Query query = session.createQuery("from Product");
            product = query.list();

            session.getTransaction().commit();
        } catch(Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return product;
    }

    /**
     * Gets all.
     *
     * @param category the category
     * @return the all
     */
    public List<Product> getAll(int category) {

        Session session = null;
        List<Product> product = null;

        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            Query query = session.createQuery("from Product where product_category_id = :productCategoryId");
            query.setParameter("productCategoryId", category);
            product = query.list();

            session.getTransaction().commit();

        } catch(Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return product;
    }

    //method to get Product by its Name from DataBase in moment to put in Cart
    @Override
    public Product getByName(String name) {

        Product product = null;
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            Query query = session.createQuery("FROM Product P WHERE P.name = :name");
            query.setString("name", name);
            product =(Product) query.uniqueResult();

            session.getTransaction().commit();
        } catch(Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return product;
    }

    //method to add new Product in DataBase
    @Override
    public int insert(Product product) {

        Session session = null;
        int resultId = 0;

        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            session.save(product);

            Query query = session.createQuery("from Product");
            resultId = query.list().size();

            session.getTransaction().commit();
        } catch(Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return resultId;
    }
}
