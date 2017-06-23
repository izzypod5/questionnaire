package gold.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import gold.student.dao.QuestionnaireDAO;
import gold.student.questionnaire.model.Questionnaire;

@Service
public class QuestionnaireServiceImpl implements QuestionnaireService {
	@Autowired
	QuestionnaireDAO questionnaireDAO;

	@Override
	public Long getRowCount() {
		return questionnaireDAO.getRowCount();
	}

	@Override
	public List<Questionnaire> findAll(Pageable pageable) {
		return questionnaireDAO.findAll(pageable);
	}

	@Override
	public void insert(Questionnaire entity) {
		questionnaireDAO.insert(entity);

	}

	@Override
	public void delete(long id) {
		questionnaireDAO.delete(id);

	}

	@Override
	public void update(Questionnaire entity) {
		questionnaireDAO.update(entity);
	}

}
