package gold.student.dao;

import java.util.List;

import gold.student.questionnaire.model.Questionnaire;

public interface QuestionnaireDAO {

	List<Questionnaire> getQuestionnaires();

	void insertQuestionnaire(Questionnaire questionnaire);
	
	void deleteQuestionnaire(long questionnaireId);
	
	void updateQuestionnaire(Questionnaire questionnaire);
/*	List<Questionnaire> getQuestionnaireByName();

	Questionnaire getQuestionnaireByID();

	

	*/

}
