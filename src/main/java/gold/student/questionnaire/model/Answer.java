package gold.student.questionnaire.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Answer")
/*
 * @XmlRootElement(name = "Answer")
 * 
 * @XmlType(propOrder = { "answerId", "description, dateCreated", "dateUpdated",
 * "qqId", "userId"})
 */
public class Answer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "answer_id")
	private long answerId;
	@Column(name = "description")
	private String description;
	@Temporal(TemporalType.DATE)
	@Column(name = "dateCreated", unique = true, nullable = false, length = 10)
	private Date dateCreated;
	@Temporal(TemporalType.DATE)
	@Column(name = "dateUpdated", unique = true, nullable = false, length = 10)
	private Date dateUpdated;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "questionId")
	private QuestionnaireQuestion question;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")
	private User user;

	public long getAnswerId() {
		return answerId;
	}

	public void setAnswerId(long answerId) {
		this.answerId = answerId;
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

	public Date getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public QuestionnaireQuestion getQuestion() {
		return question;
	}

	public void setQuestion(QuestionnaireQuestion question) {
		this.question = question;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (answerId ^ (answerId >>> 32));
		result = prime * result + ((dateCreated == null) ? 0 : dateCreated.hashCode());
		result = prime * result + ((dateUpdated == null) ? 0 : dateUpdated.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((question == null) ? 0 : question.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Answer other = (Answer) obj;
		if (answerId != other.answerId)
			return false;
		if (dateCreated == null) {
			if (other.dateCreated != null)
				return false;
		} else if (!dateCreated.equals(other.dateCreated))
			return false;
		if (dateUpdated == null) {
			if (other.dateUpdated != null)
				return false;
		} else if (!dateUpdated.equals(other.dateUpdated))
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
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Answer [answerId=" + answerId + ", description=" + description + ", dateCreated=" + dateCreated
				+ ", dateUpdated=" + dateUpdated + ", question=" + question + ", user=" + user + "]";
	}

}