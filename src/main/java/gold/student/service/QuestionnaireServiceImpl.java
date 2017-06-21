package gold.student.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gold.student.dao.QuestionnaireDAO;
import gold.student.questionnaire.model.Questionnaire;

@Service
public class QuestionnaireServiceImpl implements QuestionnaireService {
	@Autowired
    QuestionnaireDAO questionnaireDAO;

	@Override
	public List<Questionnaire> getQuestionnaires() {
		  return questionnaireDAO.getQuestionnaires();
	}

	@Override
	public void insertQuestionnaire(Questionnaire questionnaire) {
		questionnaireDAO.insertQuestionnaire(questionnaire);
	}

	/*
	 * TODO:
	 * @Override public List<Questionnaire> getQuestionnaireByName() { // TODO
	 * Auto-generated method stub return null; }
	 * 
	 * @Override public Questionnaire getQuestionnaireByID() { // TODO
	 * Auto-generated method stub return null; }
	 * 
	 * @Override public void insertQuestionnaire(Questionnaire questionnaire) {
	 * // TODO Auto-generated method stub
	 * 
	 * }
	 */

/*	@Override
	public void saveQuestionnaire(Questionnaire questionnaire) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteQuestionnaire(Questionnaire questionnaire) {
		// TODO Auto-generated method stub

	}*/

}
