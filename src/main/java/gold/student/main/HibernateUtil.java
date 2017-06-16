package gold.student.main;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import gold.student.questionnaire.model.Answer;
import gold.student.questionnaire.model.Choice;
import gold.student.questionnaire.model.Question;
import gold.student.questionnaire.model.QuestionDependency;
import gold.student.questionnaire.model.QuestionDependencyId;
import gold.student.questionnaire.model.QuestionType;
import gold.student.questionnaire.model.Questionnaire;
import gold.student.questionnaire.model.QuestionnaireQuestion;
import gold.student.questionnaire.model.User;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    private static final String HIBERNATE_CFG = "hibernate.cfg.xml";
    
    private HibernateUtil(){}

    public static SessionFactory getSessionFactory() {

        Configuration cfg = new Configuration();
        cfg.configure(HIBERNATE_CFG);
        cfg.addAnnotatedClass(Questionnaire.class);  
        cfg.addAnnotatedClass(QuestionType.class);  
        cfg.addAnnotatedClass(Question.class);  
        cfg.addAnnotatedClass(Choice.class);  
        cfg.addAnnotatedClass(QuestionnaireQuestion.class);  
        cfg.addAnnotatedClass(User.class);  
        cfg.addAnnotatedClass(Answer.class);  
        cfg.addAnnotatedClass(QuestionDependencyId.class); 
        cfg.addAnnotatedClass(QuestionDependency.class);  
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties())
                .build();

        // builds a session factory from the service registry
        sessionFactory = cfg.buildSessionFactory(serviceRegistry);

        return sessionFactory;
    }
}