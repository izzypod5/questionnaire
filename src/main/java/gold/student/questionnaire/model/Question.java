package gold.student.questionnaire.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Question")
/*
 * @XmlRootElement(name = "Question")
 * 
 * @XmlType(propOrder = { "questionId", "description, type", "itemList",
 * "answer"})
 */
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "question_id")
	private long questionId;
	@Column(name = "description")
	private String description;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "typeId")
	private QuestionType type;
	@Temporal(TemporalType.DATE)
	@Column(name = "dateCreated", unique = true, nullable = false, length = 10)
	private Date dateCreated;
	@Column(name = "required")
	private boolean required;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "question")
	private Set<QuestionnaireQuestion> questionnaireQuestions;

	public Set<QuestionnaireQuestion> getQuestionnaireQuestions() {
		return questionnaireQuestions;
	}

	public void setQuestionnaireQuestions(Set<QuestionnaireQuestion> questionnaireQuestions) {
		this.questionnaireQuestions = questionnaireQuestions;
	}

	public long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public QuestionType getType() {
		return type;
	}

	public void setType(QuestionType type) {
		this.type = type;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateCreated == null) ? 0 : dateCreated.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + (int) (questionId ^ (questionId >>> 32));
		result = prime * result + ((questionnaireQuestions == null) ? 0 : questionnaireQuestions.hashCode());
		result = prime * result + (required ? 1231 : 1237);
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Question other = (Question) obj;
		if (dateCreated == null) {
			if (other.dateCreated != null)
				return false;
		} else if (!dateCreated.equals(other.dateCreated))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (questionId != other.questionId)
			return false;
		if (questionnaireQuestions == null) {
			if (other.questionnaireQuestions != null)
				return false;
		} else if (!questionnaireQuestions.equals(other.questionnaireQuestions))
			return false;
		if (required != other.required)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", description=" + description + ", type=" + type
				+ ", dateCreated=" + dateCreated + ", required=" + required + ", questionnaireQuestions="
				+ questionnaireQuestions + "]";
	}

}
