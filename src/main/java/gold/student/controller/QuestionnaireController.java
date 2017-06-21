package gold.student.controller;

import java.time.LocalDate;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
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
	@RequestMapping(method = RequestMethod.GET, value = "/questionnaires", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Questionnaire>> getQuestionnaires(
			@RequestParam(value = "tag", required = false) String tag,
			@RequestParam(value = "date", required = false) LocalDate date,
			@RequestParam(value = "start", required = false, defaultValue = "0") int start,
			@RequestParam(value = "end", required = false, defaultValue = "10") int end) {
		List<Questionnaire> questionnaireList = null;
		try {
			questionnaireList = questionnaireService.getQuestionnaires();
			if (questionnaireList.isEmpty()) {
				logger.debug("Questionnaires do not exist");
				return new ResponseEntity<List<Questionnaire>>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return ResponseEntity.ok(questionnaireList);
	}

	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(method = RequestMethod.POST, value = "/create-questionnaire", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<Questionnaire> createQuestionnaire(Questionnaire questionnaire) {
		questionnaireService.insertQuestionnaire(questionnaire);
		return new ResponseEntity<>(questionnaire, HttpStatus.CREATED);
	}
	
	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(method = RequestMethod.PUT, value = "/questionnaire", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<Void> updateQuestionnaire(Questionnaire questionnaire) {
		logger.info("Questionnaire: " + questionnaire);
		questionnaireService.updateQuestionnaire(questionnaire);
		return ResponseEntity.ok().build();
	}	

	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(method = RequestMethod.DELETE, value = "/questionnaire/{id}")
	public ResponseEntity<Void> deleteQuestionnaire(@PathVariable("id") long id) {
		logger.info("ID received is: " + id);
		try {
			questionnaireService.deleteQuestionnaire(id);
			return ResponseEntity.noContent().build();
		} catch (ResourceNotFoundException e) {
			logger.info(e.getMessage());
			return ResponseEntity.notFound().build();
		}
	}
}
