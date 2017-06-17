package gold.student.questionnaire.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class QuestionDependencyId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "qq_id", nullable = false)
	private long questionId;
	@Column(name = "answer", nullable = false)
	private String answer;
	@Column(name = "next_qq_id", nullable = false)
	private long nextQuestionId;

	public long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public long getNextQuestionId() {
		return nextQuestionId;
	}

	public void setNextQuestionId(long nextQuestionId) {
		this.nextQuestionId = nextQuestionId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answer == null) ? 0 : answer.hashCode());
		result = prime * result + (int) (nextQuestionId ^ (nextQuestionId >>> 32));
		result = prime * result + (int) (questionId ^ (questionId >>> 32));
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
		QuestionDependencyId other = (QuestionDependencyId) obj;
		if (answer == null) {
			if (other.answer != null)
				return false;
		} else if (!answer.equals(other.answer))
			return false;
		if (nextQuestionId != other.nextQuestionId)
			return false;
		if (questionId != other.questionId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "QuestionDependencyId [questionId=" + questionId + ", answer=" + answer + ", nextQuestionId="
				+ nextQuestionId + "]";
	}

}
