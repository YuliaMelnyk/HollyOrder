package services;
import java.util.List;

import model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 * @author yuliiamelnyk on 1/25/21
 * @project HollyOrder
 */





public class UserService {


    public boolean login(String login, String password) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trx = session.beginTransaction();

        Query query = session.createQuery("FROM User WHERE login=:login and password=:pass");
        query.setString("login", login);
        query.setString("pass", password);

        List<User> list = query.list();
        trx.commit();
        session.close();

        if (list.isEmpty()) {
            return false;
        }
        User user = list.get(0);
        System.out.println(user);
        System.out.println("Zalogowano: " + user.getName() + " " + user.getSurname());
        return true;
    }

    public User takeDataBylogin(String login, String password) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trx = session.beginTransaction();

        Query query = session.createQuery("FROM User WHERE login=:login and password=:pass");
        query.setString("login", login);
        query.setString("pass", password);

        List<User> list = query.list();
        trx.commit();
        session.close();

        User user = list.get(0);
        System.out.println(user);
        return user;

    }

}

