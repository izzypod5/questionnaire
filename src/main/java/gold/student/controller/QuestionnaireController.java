package gold.student.controller;

import java.time.LocalDate;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
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

	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(method = RequestMethod.GET, value = "/questionnaires")
	public ResponseEntity<List<Questionnaire>> getQuestionnaires(
			@RequestParam(value = "tag", required = false) String tag,
			@RequestParam(value = "date", required = false) LocalDate date,
			@RequestParam(value = "start", required = false, defaultValue = "0") int start,
			@RequestParam(value = "end", required = false, defaultValue = "10") int end) {
		List<Questionnaire> questionnaireList = null;
		try {
			questionnaireList = questionnaireService.getQuestionnaires();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(questionnaireList);
	}

	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(method = RequestMethod.POST, value = "/create-questionnaire", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<Questionnaire> createQuestionnaire(Questionnaire questionnaire) {
		questionnaireService.insertQuestionnaire(questionnaire);
		return new ResponseEntity<>(questionnaire, HttpStatus.CREATED);
	}
}
