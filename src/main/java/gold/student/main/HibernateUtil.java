package gold.student.main;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import gold.student.questionnaire.model.Questionnaire;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    private static final String HIBERNATE_CFG = "hibernate.cfg.xml";
    
    private HibernateUtil(){}

    public static SessionFactory getSessionFactory() {

        Configuration cfg = new Configuration();
        cfg.configure(HIBERNATE_CFG);
        cfg.addAnnotatedClass(Questionnaire.class);      
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties())
                .build();

        // builds a session factory from the service registry
        sessionFactory = cfg.buildSessionFactory(serviceRegistry);

        return sessionFactory;
    }
}