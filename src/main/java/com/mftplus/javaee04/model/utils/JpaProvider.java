package com.mftplus.javaee04.model.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaProvider {
    private static JpaProvider jpaProvider = new JpaProvider();
    private static EntityManagerFactory  factory = Persistence.createEntityManagerFactory("mft");

    private JpaProvider() {
    }

    public static JpaProvider getJpa() {
        return jpaProvider;
    }

    public EntityManager getEntityManager(){
        return factory.createEntityManager();
    }
}
