package gold.student.questionnaire.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "QuestionType")
/*
 * @XmlRootElement(name = "QuestionType")
 * 
 * @XmlType(propOrder = { "typeId", "code", "description"})
 */
public class QuestionType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private long typeId;
	@Column(name = "code")
	private String code;
	@Column(name = "description")
	private String description;
	@OneToOne(fetch = FetchType.LAZY, mappedBy="type", cascade = CascadeType.ALL)
	private Question question;

	public long getTypeId() {
		return typeId;
	}

	public void setTypeId(long typeId) {
		this.typeId = typeId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((question == null) ? 0 : question.hashCode());
		result = prime * result + (int) (typeId ^ (typeId >>> 32));
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
		QuestionType other = (QuestionType) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (question == null) {
			if (other.question != null)
				return false;
		} else if (!question.equals(other.question))
			return false;
		if (typeId != other.typeId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "QuestionType [typeId=" + typeId + ", code=" + code + ", description=" + description + ", question="
				+ question + "]";
	}

}
