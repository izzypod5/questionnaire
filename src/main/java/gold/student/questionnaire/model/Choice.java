package gold.student.questionnaire.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "Choice")
/*
 * @XmlRootElement(name = "Choice")
 * 
 * @XmlType(propOrder = { "choiceId", "description, value"})
 */
public class Choice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "choice_id", unique = true)
	private long choiceId;
	@Column(name = "description", nullable = false)
	private String description;
	@Column(name = "value", nullable = false)
	private String value;
	@CreationTimestamp
	@Column(name = "date_created", updatable=false)
	private LocalDateTime dateCreated;
	@UpdateTimestamp
	@Column(name = "date_updated")
	private LocalDateTime dateUpdated;

	public long getChoiceId() {
		return choiceId;
	}

	public void setChoiceId(long choiceId) {
		this.choiceId = choiceId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (choiceId ^ (choiceId >>> 32));
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		Choice other = (Choice) obj;
		if (choiceId != other.choiceId)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Choice [choiceId=" + choiceId + ", description=" + description + ", value=" + value + "]";
	}

}
