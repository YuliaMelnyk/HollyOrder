package services;

import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 * The type Register service.
 *
 * @author yuliiamelnyk on 1/25/21
 * @project HollyOrder
 */
public class RegisterService {

    /**
     * Save long.
     *
     * @param user the user
     * @return the long
     */
    public long save(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        long id = (long) session.save(user);
        transaction.commit();
        session.close();
        return id;
    }
}
