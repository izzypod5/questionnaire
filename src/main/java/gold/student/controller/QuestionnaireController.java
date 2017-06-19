package gold.student.controller;

import java.time.LocalDate;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gold.student.questionnaire.model.Questionnaire;
import gold.student.service.QuestionnaireService;

@RestController
public class QuestionnaireController {

	@Autowired
	QuestionnaireService questionnaireService;
	static final Logger logger = LogManager.getLogger(RestController.class);

	@RequestMapping(method = RequestMethod.GET, value = "/questionnaires")
	public List<Questionnaire> getQuestionnaires(@RequestParam(value = "tag", required = false) String tag,
			@RequestParam(value = "date", required = false) LocalDate date,
			@RequestParam(value = "start", required = false, defaultValue = "0") int start,
			@RequestParam(value = "end", required = false, defaultValue = "10") int end) {
		List<Questionnaire> questionnaireList = null;
		try {
			questionnaireList = questionnaireService.getQuestionnaires();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return questionnaireList;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/create-questionnaire")
	public Questionnaire createQuestionnaire(){
		return null;
		
	}
}
