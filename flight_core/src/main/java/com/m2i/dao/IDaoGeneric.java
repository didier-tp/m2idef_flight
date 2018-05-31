package com.m2i.dao;

import java.io.Serializable;
import java.util.List;

//il existe un equivalent predéfini CrudRepository<T,K>
//dans l'extension facultative SpringData de spring 4
public interface IDaoGeneric<T, K extends Serializable> {

	public T insert(T obj);

	public T update(T obj);

	public void delete(T obj);

	public T findByKey(K key);

	public List<T> findAll();
}
