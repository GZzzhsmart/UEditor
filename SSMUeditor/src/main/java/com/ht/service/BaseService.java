package com.ht.service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/6.
 */
public interface BaseService<PK,T> {
    public T queryById(PK id);

    public void update(T t);

    public void add(T t);

    public void delete(String id);

    public List<T> pagelist();

    public int count();
}
