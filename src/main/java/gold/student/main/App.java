package gold.student.main;

import java.sql.Connection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import gold.student.questionnaire.model.Questionnaire;

/**
 * Hello world!
 *
 */
public class App {
	private static final Logger logger = LogManager.getLogger(App.class.getName());

	public static void main(String[] args) {
		try (SessionFactory factory = HibernateUtil.getSessionFactory(); Session session = factory.openSession()) {

			// creating transaction object
			Transaction t = session.beginTransaction();
			
			Questionnaire q1 = new Questionnaire();
			q1.setName("Test Questionnaire");
			q1.setDescription("questionnaire used for testing");

			session.persist(q1);// persisting the object

			t.commit();// transaction is commited

			logger.info("successfully saved");
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
	}
}
