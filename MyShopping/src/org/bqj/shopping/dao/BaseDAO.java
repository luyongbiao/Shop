package org.bqj.shopping.dao;


import java.util.List;

public interface BaseDAO<T> {
	public T loadById(Integer id);
	
	public List<T> findAll();
	
	public void save(T t);
	
	public void removeOne(Integer id);
	
	public void removeAll();
	
	public void modify(T t);
	public int findCount();

	public List<T> find(int begin, int pageSize);
==
	public List<T> find(int begin, int pageSize);}
