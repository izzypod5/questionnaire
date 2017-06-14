package gold.student.questionnaire.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "QuestionDependency")
public class QuestionDependency {
	//@PrimaryKeyJoinColumn used to create a composite primary key from foreign keys
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "qqId", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn(name="qqId")
	private QuestionnaireQuestion question;
	@Column(name = "answer")
	private String answer;
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "qqId", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn(name="qqId")
	private QuestionnaireQuestion nextQuestion;

	public QuestionnaireQuestion getQuestion() {
		return question;
	}

	public void setQuestion(QuestionnaireQuestion question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public QuestionnaireQuestion getNextQuestion() {
		return nextQuestion;
	}

	public void setNextQuestion(QuestionnaireQuestion nextQuestion) {
		this.nextQuestion = nextQuestion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answer == null) ? 0 : answer.hashCode());
		result = prime * result + ((nextQuestion == null) ? 0 : nextQuestion.hashCode());
		result = prime * result + ((question == null) ? 0 : question.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QuestionDependency other = (QuestionDependency) obj;
		if (answer == null) {
			if (other.answer != null)
				return false;
		} else if (!answer.equals(other.answer))
			return false;
		if (nextQuestion == null) {
			if (other.nextQuestion != null)
				return false;
		} else if (!nextQuestion.equals(other.nextQuestion))
			return false;
		if (question == null) {
			if (other.question != null)
				return false;
		} else if (!question.equals(other.question))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "QuestionDependency [question=" + question + ", answer=" + answer + ", nextQuestion=" + nextQuestion
				+ "]";
	}

}
