package gold.student.questionnaire.model;

import java.util.List;

public class PaginatedList<T> {
	//list items eg. list<Questionnaire>
	private List<T> items;
	
	//returns from count expression in database
	private int totalRecordCount;
	private int start;
	private int end;
	private int pageSize;
	private int pageNumber;	
	private int totalPages = (totalRecordCount % pageSize == 0) ? totalRecordCount / pageSize : totalRecordCount / pageSize + 1;
	
	public PaginatedList(List<T> items, int totalRecordCount, int start, int end, int pageSize) {
		super();
		this.items = items;
		this.totalRecordCount = totalRecordCount;
		this.start = start;
		this.end = end;
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.totalPages = totalPages;
	}
	
}
