package gold.student.main.dao;

import java.util.List;

import gold.student.questionnaire.Question;

public interface QuestionDAO {

	List<Question> getQuestions();

	Question getQuestionByID();

	void addQuestion(Question question);

	void updateQuestion(Question question);

	void deleteQuestion(Question question);
}