package gold.student.questionnaire.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "QuestionnaireQuestion")
/*
 * @XmlRootElement(name = "QuestionnaireQuestion")
 * 
 * @XmlType(propOrder = { "qqId", "questionnaire", "question", "ordinal",
 * "choiceId"})
 */
public class QuestionnaireQuestion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "qq_id")
	private long qqId;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "questionnaire_id")
	private Questionnaire questionnaire;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "question_id")
	private Question question;

	@Column(name = "ordinal")
	private int ordinal;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "choice_id")
	private Choice choice;

	public long getQqId() {
		return qqId;
	}

	public void setQqId(long qqId) {
		this.qqId = qqId;
	}

	public Questionnaire getQuestionnaire() {
		return questionnaire;
	}

	public void setQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public int getOrdinal() {
		return ordinal;
	}

	public void setOrdinal(int ordinal) {
		this.ordinal = ordinal;
	}

	public Choice getChoice() {
		return choice;
	}

	public void setChoice(Choice choice) {
		this.choice = choice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((choice == null) ? 0 : choice.hashCode());
		result = prime * result + ordinal;
		result = prime * result + (int) (qqId ^ (qqId >>> 32));
		result = prime * result + ((question == null) ? 0 : question.hashCode());
		result = prime * result + ((questionnaire == null) ? 0 : questionnaire.hashCode());
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
		QuestionnaireQuestion other = (QuestionnaireQuestion) obj;
		if (choice == null) {
			if (other.choice != null)
				return false;
		} else if (!choice.equals(other.choice))
			return false;
		if (ordinal != other.ordinal)
			return false;
		if (qqId != other.qqId)
			return false;
		if (question == null) {
			if (other.question != null)
				return false;
		} else if (!question.equals(other.question))
			return false;
		if (questionnaire == null) {
			if (other.questionnaire != null)
				return false;
		} else if (!questionnaire.equals(other.questionnaire))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "QuestionnaireQuestion [qqId=" + qqId + ", questionnaire=" + questionnaire + ", question=" + question
				+ ", ordinal=" + ordinal + ", choice=" + choice + "]";
	}

}
