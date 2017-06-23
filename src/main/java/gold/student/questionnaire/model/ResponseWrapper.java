package gold.student.questionnaire.model;

import java.util.List;

public class ResponseWrapper<T> {
	private List<T> entityList;
	private Long count;

	public ResponseWrapper(List<T> entityList, Long count) {
		this.entityList = entityList;
		this.count = count;
	}

	public List<T> getEntityList() {
		return entityList;
	}

	public void setEntityList(List<T> entityList) {
		this.entityList = entityList;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

}