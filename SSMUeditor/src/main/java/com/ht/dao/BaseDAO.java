package com.ht.dao;

import java.util.List;
import java.util.Map;

/**
 *
 * @param <PK>
 * @param <T>
 */
public interface BaseDAO<PK,T> {

    public T queryById(PK id);

    public void update(T t);

    public void add(T t);

    public void delete(String id);

    public List<T> pagelist();

    public int count();

}
