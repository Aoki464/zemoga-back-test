package com.zemogaback.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Pageable;


public interface IGenericDao<T extends Serializable> {
	 
		void setClazz(Class<T> classToSet);
	
		T findOne(long id);
		
		T findOne(final Object id);
	
	    List<T> findAll();
	    
	    List<T> findAll(Pageable page);
	    
	    Long count();
	
	    T save(T entity);
	    
	    void refresh(final T entity);
	    
	    void flush();
	
	    T update(T entity);
	
	    void delete(T entity);
	
	    void deleteById(long entityId);
	    
	    <D extends Serializable> List<D> findByQuery(Class<D> clazz, String query, Pageable page, List<String> names, Object... params);
	    
	    <D extends Serializable> List<D> findByNativeQuery(String query);
	    
	    <D extends Serializable> List<D> findByNamedNativeQuery(String query, List<String> names, Object... params);
	    
	    <D extends Serializable> List<D> findByNamedQuery(Class<D> clazz, String namedQuery, List<String> names, Pageable page, Object... params);
	    
	    <D extends Serializable> List<D> findByNativeQuery(String stringQuery,String result,List<String> names, Object... params);
	    
	    <D> List<D> findByNativeQuery(String stringQuery,List<String> names, Object... params);
	    
	    <D extends Serializable> Integer deleteOrUpdateNamedQuery(String namedQuery, List<String> names,Object... params);
	    
	    Long findAnyOne(String stringQuery);
	}
