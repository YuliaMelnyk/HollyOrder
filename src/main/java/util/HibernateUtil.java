package util;
import java.util.Objects;

import model.Product;
import model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * The type Hibernate util.
 *
 * @author yuliiamelnyk on 1/25/21
 * @project HollyOrder
 */


public class HibernateUtil {

    private static SessionFactory sessionFactory;

    private static SessionFactory buildSessionFactory() {
        // Creating Configuration Instance & Passing Hibernate Configuration File
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Product.class);
        configuration.configure("hibernate.cfg.xml");

        // Since Hibernate Version 4.x, ServiceRegistry Is Being Used
        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties())
                .build();
        // Creating Hibernate SessionFactory Instance
        SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
        return sessionFactory;
    }

    /**
     * Gets session factory.
     *
     * @return the session factory
     */
    public static SessionFactory getSessionFactory() {
        if (Objects.isNull(sessionFactory)) {
            sessionFactory = buildSessionFactory();
        }
        return sessionFactory;
    }

}
