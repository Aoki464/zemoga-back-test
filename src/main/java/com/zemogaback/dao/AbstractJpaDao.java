package com.zemogaback.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.Path;

import org.springframework.data.domain.Pageable;

public abstract class AbstractJpaDao<T extends Serializable>{


	private Class<T> clazz;

    @PersistenceContext
    private EntityManager entityManager;
    
    public void setClazz(final Class<T> clazzToSet) {
        this.clazz = clazzToSet;
    }

    public T findOne(final long id) {
        return entityManager.find(clazz, id);
    }
    
    public T findOne(final Object id) {
        return entityManager.find(clazz, id);
    }

    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        return entityManager.createQuery("from " + clazz.getName()).getResultList();
    }
    
    public Long count() {
    	Query query = entityManager.createQuery("select count(*) from " + clazz.getName());
        return (Long) query.getSingleResult();
    }
    
    public Long findAnyOne(String stringQuery) {
    	Query query = entityManager.createQuery(stringQuery);
        return (Long) query.getSingleResult();
    }
    
    @SuppressWarnings("unchecked")
	public <D extends Serializable> List<D> findByNativeQuery(String query) {
    	return (List<D>)entityManager.createNativeQuery(query).getResultList();
    }
    
    @SuppressWarnings("unchecked")
    public List<T> findAll(Pageable page) {
        return entityManager.createQuery("from " + clazz.getName())
        		.setFirstResult((int) page.getOffset())
        		.setMaxResults(page.getPageSize()).getResultList();
    }
    
    public <D extends Serializable> List<D> findByQuery(Class<D> clazz, String stringQuery, Pageable page, List<String> names, Object... params){
		TypedQuery<D> query =  entityManager.createQuery(stringQuery,clazz);
		if(page != null) {
			query.setFirstResult((int) page.getOffset())
			.setMaxResults(page.getPageSize());
		}
		if(params != null) {
			int idx = 0;
			for(Object obj : params) {
				if(obj != null) {
					query.setParameter(names.get(idx), obj);
					idx++;
				}
	    	}
		}
    	return query.getResultList();
    } 
    
    public <D extends Serializable> List<D> findByNamedQuery(Class<D> clazz, String namedQuery, List<String> names, Pageable page, Object... params){
		TypedQuery<D> query =  entityManager.createNamedQuery(namedQuery,clazz);
		if(page != null) {
			query.setFirstResult((int) page.getOffset())
			.setMaxResults(page.getPageSize());
		}
				
		if(params != null) {
			int idx = 0;
			for(Object obj : params) {
				if(obj != null) {
					query.setParameter(names.get(idx), obj);
					idx++;
				}
	    	}
		}
    	return query.getResultList();
    }
    
    public <D extends Serializable> Integer deleteOrUpdateNamedQuery(String namedQuery, List<String> names, Object... params){
		Query query =  entityManager.createNamedQuery(namedQuery);
		if(params != null) {
			int idx = 0;
			for(Object obj : params) {
				if(obj != null) {
					query.setParameter(names.get(idx), obj);
					idx++;
				}
	    	}
		}
		return query.executeUpdate();
    } 
    
	@SuppressWarnings("unchecked")
	public <D extends Serializable> List<D> findByNamedNativeQuery(String stringQuery, List<String> names, Object... params){
		Query query =  entityManager.createNamedQuery(stringQuery);
		int idx = 0;
		if(params != null) {
			for(Object obj : params) {
				if(obj != null) {
					query.setParameter(names.get(idx), obj);
					idx++;
				}
	    	}
		}
    	return (List<D>)query.getResultList();
    } 
	
	@SuppressWarnings("unchecked")
	public <D extends Serializable> List<D> findByNativeQuery(String stringQuery,String result,List<String> names, Object... params){
		Query query =  entityManager.createNativeQuery(stringQuery, result);
		
		int idx = 0;
		if(params != null) {
			for(Object obj : params) {
				if(obj != null) {
					query.setParameter(names.get(idx), obj);
					idx++;
				}
	    	}
		}
    	return (List<D>)query.getResultList();
    }
	
	@SuppressWarnings("unchecked")
	public <D> List<D> findByNativeQuery(String stringQuery,List<String> names, Object... params){
		Query query =  entityManager.createNativeQuery(stringQuery);
		int idx = 0;
		if(params != null) {
			for(Object obj : params) {
				if(obj != null) {
					query.setParameter(names.get(idx), obj);
					idx++;
				}
	    	}
		}
    	return (List<D>)query.getResultList();
    }

    public T save(final T entity) {
        entityManager.persist(entity);
        return entity;
    }  
    
    public void refresh(final T entity) {
    	entityManager.refresh(entity);
    }  
    
    
    public void flush() {
    	entityManager.flush();
    }

    public T update(final T entity) {
        return entityManager.merge(entity);
    }

    public void delete(final T entity) {
        entityManager.remove(entity);
    }

    public void deleteById(final long entityId) {
        final T entity = findOne(entityId);
        delete(entity);
    }
    
    public Path<T> getAttribute(Path<T> path, int actual, int times, String[] attributes){
    	if (actual >= times) {
    		return path;
    	}else {
    		return getAttribute(path.get(attributes[actual]), actual+1, times, attributes);
    	}
    	
    }
    
    public Path<String>	 getAttributeValue(Path<T> path, int actual, int times, String[] attributes){
    	if (actual == times-1) {
    		return path.<String>get(attributes[actual]);
    	}else {
    		return getAttributeValue(path.get(attributes[actual]), actual+1, times, attributes);
    	}
    	
    }

}
