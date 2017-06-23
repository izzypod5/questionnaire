package gold.student.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gold.student.questionnaire.model.Questionnaire;

@Repository("questionnaireDAO")
public class QuestionnaireDAOImpl implements QuestionnaireDAO {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	@Transactional(readOnly = true)
	public Long getRowCount() {
		Session session = entityManager.unwrap(Session.class);
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		cq.select(cb.count(cq.from(Questionnaire.class)));
		return entityManager.createQuery(cq).getSingleResult();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Questionnaire> findAll(Pageable pageable) {
		Session session = entityManager.unwrap(Session.class);
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Questionnaire> query = cb.createQuery(Questionnaire.class);
		Root<Questionnaire> root = query.from(Questionnaire.class);
		query.select(root);
		TypedQuery<Questionnaire> tQuery = entityManager.createQuery(query);

		return tQuery.setFirstResult(pageable.getOffset())// offset
				.setMaxResults(pageable.getPageSize())// pagesize
				.getResultList();
	}

	@Override
	@Transactional
	public void insert(Questionnaire entity) {
		Session session = entityManager.unwrap(Session.class);
		session.save(entity);
	}

	@Override
	@Transactional
	public void delete(long id) {
		Session session = entityManager.unwrap(Session.class);
		Questionnaire questionnaire = session.load(Questionnaire.class, id);
		if (questionnaire != null) {
			session.delete(questionnaire);
		}
	}

	@Override
	@Transactional
	public void update(Questionnaire entity) {
		Session session = entityManager.unwrap(Session.class);
		session.update(entity);
	}

}
