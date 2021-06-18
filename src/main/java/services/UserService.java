package services;
import java.util.List;

import model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 * The type User service.
 *
 * @author yuliiamelnyk on 1/25/21
 * @project HollyOrder
 */


public class UserService {


    /**
     * Login boolean.
     *
     * @param email    the email
     * @param password the password
     * @return the boolean
     */
    public boolean login(String email, String password) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trx = session.beginTransaction();

        Query query = (Query) session.createQuery("FROM User WHERE email=:email and password=:password");
        query.setString("email", email);
        query.setString("password", password);

        List<User> list = query.list();
        trx.commit();
        session.close();

        if (list.isEmpty()) {
            return false;
        }
        User user = list.get(0);
        System.out.println(user);
        System.out.println("Login success: " + user.getName() + " " + user.getSurname());
        return true;
    }

    /**
     * Take data bylogin user.
     *
     * @param email    the email
     * @param password the password
     * @return the user
     */
    public User takeDataBylogin(String email, String password) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trx = session.beginTransaction();

        Query query = (Query) session.createQuery("FROM User WHERE email=:email and password=:password");
        query.setString("email", email);
        query.setString("password", password);

        List<User> list = query.list();
        trx.commit();
        session.close();

        User user = list.get(0);
        System.out.println(user);
        return user;

    }

}

