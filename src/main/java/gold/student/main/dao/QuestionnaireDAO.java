package gold.student.main.dao;

import java.util.List;

import gold.student.questionnaire.Questionnaire;

public interface QuestionnaireDAO {

	List<Questionnaire> getQuestionnaires();

	List<Questionnaire> getQuestionnaireByName();

	Questionnaire getQuestionnaireByID();

	void insertQuestionnaire(Questionnaire questionnaire);

	void saveQuestionnaire(Questionnaire questionnaire);

	void deleteQuestionnaire(Questionnaire questionnaire);

}
