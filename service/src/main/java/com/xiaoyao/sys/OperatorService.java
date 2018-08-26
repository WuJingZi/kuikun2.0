package com.xiaoyao.sys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
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
