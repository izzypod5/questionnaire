package gold.student.main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gold.student.questionnaire.Question;
import gold.student.questionnaire.enums.QuestionType;

public class QuestionDAOImpl implements QuestionDAO {

	@Override
	public List<Question> getQuestions(Connection connection) throws SQLException {
		List<Question> questions = new ArrayList<Question>();
		String selectQuestionsQuery = "SELECT question_id,description,type FROM questions";
		try (PreparedStatement ps = connection.prepareStatement(selectQuestionsQuery);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				Question question = new Question();
				question.setQuestionID(rs.getInt("question_id"));
				question.setText(rs.getString("description"));
				question.setType(QuestionType.forId(rs.getString("type")));
				questions.add(question);
			}
		}
		return questions;
	}

	@Override
	public Question getQuestionByID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addQuestion(Question question) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateQuestion(Question question) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteQuestion(Question question) {
		// TODO Auto-generated method stub

	}

}
