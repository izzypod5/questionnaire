package gold.student.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gold.student.questionnaire.model.Questionnaire;

@Repository("questionnaireDAO")
public class QuestionnaireDAOImpl implements QuestionnaireDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Questionnaire> getQuestionnaires() {
		Session session = sessionFactory.openSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Questionnaire> query = cb.createQuery(Questionnaire.class);
		Root<Questionnaire> root = query.from(Questionnaire.class);
		query.select(root);
		List<Questionnaire> questionnaireList = session.createQuery(query).getResultList();
		session.close();
		return questionnaireList;
	}

	@Override
	@Transactional
	public void insertQuestionnaire(Questionnaire questionnaire) {
		// TODO Auto-generated method stub

	}

	/*
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

	/*
	 * @Override public void saveQuestionnaire(Questionnaire questionnaire) { //
	 * TODO Auto-generated method stub
	 * 
	 * }
	 * 
	 * @Override public void deleteQuestionnaire(Questionnaire questionnaire) {
	 * // TODO Auto-generated method stub
	 * 
	 * }
	 */

}