package org.bqj.shopping.dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public interface BaseDAO<T> {
	public T loadById(Integer id) throws SQLException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException;
	
	public List<T> findAll();
	
	public void save(T t);
	
	public void removeOne(Integer id);
	
	public void removeAll();
	
	public void modify(T t);
	
<<<<<<< HEAD
	public int findCount();

	
	public List<T> find(int begin, int pageSize);

=======
	public int findCount();
	
	public List<T> find(int begin, int pageSize);
>>>>>>> remotes/origin/branch1
}
