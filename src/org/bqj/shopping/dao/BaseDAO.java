package org.bqj.shopping.dao;

import java.util.List;
import java.util.Set;

public interface BaseDAO<T> {
	public T loadById(Integer id);
	
	public List<T> findAll();
	
	public void save(T t);
	
	public void removeOne(Integer id);
	
	public void removeAll();
	
	public void modify(T t);
	
	public int findCount();

	public Set<T> find(int begin, int pageSize);

}
