package com.xiaoyao.sys;

import org.springframework.stereotype.Component;

@Component
public abstract class BaseService<T> {


    protected abstract BaseDao<T, String> getBaseDao();

    public T findOne(String id) {
        return getBaseDao().findById(id).orElse(null);
    }



}
