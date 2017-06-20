package gold.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

/**
 * Hello world!
 *
 */
/* @ComponentScan */
@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@ImportResource("classpath:ApplicationContext.xml")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
/*
 * public class App { private static final Logger logger =
 * LogManager.getLogger(App.class.getName());
 * 
 * public static void main(String[] args) { try (SessionFactory factory =
 * HibernateUtil.getSessionFactory(); Session session = factory.openSession()) {
 * 
 * // creating transaction object Transaction t = session.beginTransaction();
 * 
 * Questionnaire q1 = new Questionnaire(); q1.setName("Test Questionnaire");
 * q1.setDescription("questionnaire used for testing");
 * 
 * session.persist(q1);// persisting the object
 * 
 * t.commit();// transaction is commited
 * 
 * logger.info("successfully saved"); } catch (Exception e) {
 * logger.error(e.getMessage()); e.printStackTrace(); } } }
 */
