package gold.student.service;

import java.util.List;

import gold.student.questionnaire.model.Questionnaire;

public interface QuestionnaireService {

	List<Questionnaire> getQuestionnaires();

	void insertQuestionnaire(Questionnaire questionnaire);

	/*
	 * List<Questionnaire> getQuestionnaireByName();
	 * 
	 * Questionnaire getQuestionnaireByID();
	 * 
	 *
	 * 
	 * void saveQuestionnaire(Questionnaire questionnaire);
	 * 
	 * void deleteQuestionnaire(Questionnaire questionnaire);
	 */

}
