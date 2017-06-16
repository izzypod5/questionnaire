package gold.student.questionnaire.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Questionnaire")
/*
 * @XmlRootElement(name = "Questionnaire")
 * 
 * @XmlType(propOrder = { "questionnaireId", "name", "questions" })
 */
public class Questionnaire {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "questionnaire_id")
	private long questionnaireId;
	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "questionnaire")
	private Set<QuestionnaireQuestion> questionnaireQuestions;

	public Set<QuestionnaireQuestion> getQuestionnaireQuestions() {
		return questionnaireQuestions;
	}

	public void setQuestionnaireQuestions(Set<QuestionnaireQuestion> questionnaireQuestions) {
		this.questionnaireQuestions = questionnaireQuestions;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dateCreated", unique = true, nullable = false, length = 10)
	private Date dateCreated;

	public long getQuestionnaireId() {
		return questionnaireId;
	}

	public void setQuestionnaireId(long questionnaireId) {
		this.questionnaireId = questionnaireId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateCreated == null) ? 0 : dateCreated.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (int) (questionnaireId ^ (questionnaireId >>> 32));
		result = prime * result + ((questionnaireQuestions == null) ? 0 : questionnaireQuestions.hashCode());
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
		Questionnaire other = (Questionnaire) obj;
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
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (questionnaireId != other.questionnaireId)
			return false;
		if (questionnaireQuestions == null) {
			if (other.questionnaireQuestions != null)
				return false;
		} else if (!questionnaireQuestions.equals(other.questionnaireQuestions))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Questionnaire [questionnaireId=" + questionnaireId + ", name=" + name + ", description=" + description
				+ ", questionnaireQuestions=" + questionnaireQuestions + ", dateCreated=" + dateCreated + "]";
	}

}
