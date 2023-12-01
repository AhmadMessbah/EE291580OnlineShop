package com.mftplus.javaee04.model.service.impl;

import java.util.List;

public interface Service<T,I> {
    T save(T t) throws Exception;
    T edit(T t) throws Exception;
    T remove(I id) throws Exception;
    List<T> findAll() throws  Exception;
    T findById(I id) throws  Exception;
}
