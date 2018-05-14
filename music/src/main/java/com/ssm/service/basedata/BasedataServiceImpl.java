package com.ssm.service.basedata;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.dao.basedata.IBasedataDao;
import com.ssm.dto.basedata.Basedata;

@Service("basedataService")
public class BasedataServiceImpl implements IBasedataService{
	
	@Resource
	IBasedataDao dao;
	
	public List<Basedata> findAll(){
		return dao.findAll();
	}
	
	public List<Basedata> findByName(String name){
		return dao.findByName(name);
	}
	
	public int deleteByPrimaryKey(int id) {
		return dao.deleteByPrimaryKey(id);
	}
	
	public Basedata findById(int id) {
		return dao.findById(id);
	}
	
	public int updateById(Basedata basedata) {
		return dao.updateById(basedata);
	}
	
	public int add(Basedata basedata) {
		return dao.add(basedata);
	}
	
	public Basedata findBySingerAndTitle(String singer, String songName) {
		return dao.findBySingerAndTitle(singer, songName);
	}
	
	public int queryCount() {
		return dao.queryCount();
	}
}
