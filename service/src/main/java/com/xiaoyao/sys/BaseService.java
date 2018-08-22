package com.xiaoyao.sys;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public abstract class BaseService<T> {


    protected abstract BaseDao<T, String> getBaseDao();

    public T findOne(String id) {
        return getBaseDao().findById(id).orElse(null);
    }

    public List<T> findAll(){
        return getBaseDao().findAll();
    };

    public List<T> findAll(Sort sort){
        return getBaseDao().findAll(sort);
    }


    public List<T> findAll(@NonNull T searchVo){
        return getBaseDao().findAll(Example.of(searchVo));
    };

    public Page<T> findAll(@NonNull Pageable pageable){
        return getBaseDao().findAll(pageable);
    };

    public Page<T> findAll(@NonNull T searchVo, Pageable pageable){
        return getBaseDao().findAll(Example.of(searchVo),pageable);
    };

    public List<T> findAllById(List<String> ids){
        return getBaseDao().findAllById(ids);
    }

    public List<T> findAllById(@NonNull T searchVo,@NonNull Sort sort){
        return getBaseDao().findAll(Example.of(searchVo),sort);
    }





}
