package gold.student.dao;

import java.util.List;

import gold.student.questionnaire.model.Question;

public interface QuestionDAO {

	Question getQuestionByID();

	void addQuestion(Question question);

	void updateQuestion(Question question);

	void deleteQuestion(Question question);

	List<Question> getQuestions() throws Exception;
}