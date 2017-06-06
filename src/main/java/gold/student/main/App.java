package gold.student.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import gold.student.main.dao.QuestionDAOImpl;
import gold.student.questionnaire.Question;

/**
 * Hello world!
 *
 */
public class App {
	private static final Logger logger = LogManager.getLogger(App.class.getName());
	private static Connection connection = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	//params added to sort a mysql timezone issue
	final private static String url = "jdbc:mysql://localhost:3306/questionnaire?useLegacyDatetimeCode=false&serverTimezone=UTC";
	final private static String user = "root";
	final private static String passwd = "root";

	public static void main(String[] args) {
		try {
			connection = getConnection();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		if (connection != null) {
			logger.info("Database, database, just living in the database woaaaaah!");
		} else {
			logger.info("Failed to make connection!");
		}
		QuestionDAOImpl test = new QuestionDAOImpl();
		try {
			List<Question> questions = test.getQuestions(connection);
			System.out.println(questions);
			logger.debug(questions);
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
	}

	public static Connection getConnection() throws Exception {
		Connection conn = null;
		try {
			// This will load the MySQL driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Setup the connection with the DB
			conn = DriverManager.getConnection(url, user, passwd);
		} catch (Exception e) {
			throw e;
		}
		return conn;
	}
}
