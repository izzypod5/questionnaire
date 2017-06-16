package gold.student.main;

import java.sql.Connection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	private static final Logger logger = LogManager.getLogger(App.class.getName());
	private static Connection connection = null;

	// params added to sort a mysql timezone issue
	/*
	 * final private static String url =
	 * "jdbc:mysql://localhost:3306/questionnaire?useLegacyDatetimeCode=false&serverTimezone=UTC";
	 * final private static String user = "root"; final private static String
	 * passwd = "root";
	 * 
	 * public static void main(String[] args) { try { connection =
	 * getConnection(); } catch (Exception e) { logger.error(e.getMessage()); }
	 * if (connection != null) {
	 * logger.info("Database, database, just living in the database woaaaaah!");
	 * } else { logger.info("Failed to make connection!"); } QuestionDAOImpl
	 * test = new QuestionDAOImpl(); try { List<Question> questions =
	 * test.getQuestions(); logger.debug(questions); } catch (Exception e) {
	 * logger.error(e.getMessage()); } }
	 * 
	 * public static Connection getConnection() throws Exception { Connection
	 * conn = null; try { // This will load the MySQL driver
	 * Class.forName("com.mysql.cj.jdbc.Driver"); // Setup the connection with
	 * the DB conn = DriverManager.getConnection(url, user, passwd); } catch
	 * (Exception e) { throw e; } return conn; }
	 */
	public static void main(String[] args) {
		try (SessionFactory factory = HibernateUtil.getSessionFactory(); 
			Session session = factory.openSession()) {
			// creating session object
			// Session session = factory.openSession();

			// creating transaction object
			// Transaction t = session.beginTransaction();

			/*
			 * Employee e1 = new Employee(); e1.setId(115);
			 * e1.setFirstName("sonoo"); e1.setLastName("jaiswal");
			 */

			// session.persist(e1);// persisting the object

			// t.commit();// transaction is commited

			logger.info("successfully saved");
		} catch(Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
	}
}
