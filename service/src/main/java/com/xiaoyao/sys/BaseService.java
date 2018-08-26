package com.xiaoyao.sys;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.*;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import sys.Log;
import sys.ServiceException;

import java.util.List;

@Component
public abstract class BaseService<T> {


    protected abstract BaseDao<T, String> getBaseDao();

    public T findOne(String id) {
        return getBaseDao().findById(id).orElse(null);
    }
    public T findOne(@NonNull T searchVo) {
        return getBaseDao().findOne(Example.of(searchVo)).orElse(null);
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

    public List<T> findAllLimit(int size){
        return getBaseDao().findAll(PageRequest.of(0,size)).getContent();
    }

    public List<T> findAllLimit(@NonNull T searchVo,int size){
        return getBaseDao().findAll(Example.of(searchVo),PageRequest.of(0,size)).getContent();
    }

    public Page<T> findAll(@NonNull Pageable pageable){
        return getBaseDao().findAll(pageable);
    };

    public Page<T> findAll(@NonNull T searchVo, Pageable pageable){
        return getBaseDao().findAll(Example.of(searchVo),pageable);
    };

    public List<T> findAllById(List<String> ids){
        return getBaseDao().findAllById(ids);
    }

    public List<T> findAll(@NonNull T searchVo,@NonNull Sort sort){
        return getBaseDao().findAll(Example.of(searchVo),sort);
    }


    public void delete(String id){
        try {
            getBaseDao().deleteById(id);
        }catch (EmptyResultDataAccessException e) {
            Log.info("id为" + id + "记录不存在", this.getClass());
            throw new ServiceException("记录不存在");
        }
    }





}
