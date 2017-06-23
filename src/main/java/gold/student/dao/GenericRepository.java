package gold.student.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;

public interface GenericRepository<T> {
	Long getRowCount();
	List<T> findAll(Pageable pageable);
	void insert(T entity);
	void delete(long id);
	void update(T entity);
}
