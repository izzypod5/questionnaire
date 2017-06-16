package gold.student.questionnaire.model;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "QuestionDependency")
public class QuestionDependency {

	@EmbeddedId
	private QuestionDependencyId id;

	@MapsId("questionId")
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "qq_id")
	private QuestionnaireQuestion question;

	@MapsId("nextQuestionId")
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "next_qq_id")
	private QuestionnaireQuestion nextQuestion;

	public QuestionDependencyId getId() {
		return id;
	}

	public void setId(QuestionDependencyId id) {
		this.id = id;
	}

	public QuestionnaireQuestion getQuestion() {
		return question;
	}

	public void setQuestion(QuestionnaireQuestion question) {
		this.question = question;
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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
		return "QuestionDependency [id=" + id + ", question=" + question + ", nextQuestion=" + nextQuestion + "]";
	}

}
