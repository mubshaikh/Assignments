package com.mediaocean.shoppingcart.dao;

import java.util.List;

import com.mediaocean.shopping.model.BaseDO;

public interface BaseDAO<T extends BaseDO> {

    public T insert(T item);

    public T getById(String id);

    public List<T> list();

    T saveOrUpdate(T item);
}