package com.xiaoyao.sys;

import com.xiaoyao.hy.User;

import com.xiaoyao.hy.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.xiaoyao.sys.OperatorDao;

import java.util.List;

@Component
public class OperatorService {
	
	@Autowired
	private OperatorDao operatorDao;


	public List<Operator> findAll(){
		List<Operator> list= operatorDao.findAll();
		return list;
	}
	
	public Operator findByOperatorName(String operatorName){
		return operatorDao.findBySoperatorname(operatorName);
	}
}
