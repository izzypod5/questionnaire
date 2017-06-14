package gold.student.main.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import gold.student.questionnaire.model.Question;

public interface QuestionDAO {

	Question getQuestionByID();

	void addQuestion(Question question);

	void updateQuestion(Question question);

	void deleteQuestion(Question question);

	List<Question> getQuestions() throws Exception;
}