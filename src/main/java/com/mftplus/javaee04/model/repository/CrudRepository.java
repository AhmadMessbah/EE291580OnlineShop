package com.mftplus.javaee04.model.repository;


import com.mftplus.javaee04.model.utils.JpaProvider;

import javax.persistence.*;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class CrudRepository<T, I> implements AutoCloseable {
    protected EntityManager entityManager;

    public CrudRepository() {
        entityManager = JpaProvider.getJpa().getEntityManager();
    }

    public T save(T t) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(t);
        entityTransaction.commit();
        return t;
    }

    public T edit(T t) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.merge(t);
        entityTransaction.commit();
        return t;
    }

    public T remove(Class<T> tClass, I id) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        T t = (T) entityManager.find(tClass, id);
        entityManager.remove(t);
        entityTransaction.commit();
        return t;
    }

    public T findById(Class<T> tClass, I id) {
        return (T) entityManager.find(tClass, id);
    }


    public List<T> findAll(Class<T> tClass) {
        Query query = entityManager.createQuery("SELECT oo FROM " +  tClass.getAnnotation(Entity.class).name() + " oo");
        return (List<T>) query.getResultList();
    }

    public List<T> findBy(String queryName, Map<String, Object> params){
        Query query = entityManager.createNamedQuery(queryName);
        for(String key: params.keySet()) {
            query.setParameter(key, params.get(key));
        }
        return query.getResultList();
    }


    @Override
    public void close() throws Exception {
        entityManager.close();
    }
}
