package com.ssm.dao.basedata;

import java.util.List;

import com.ssm.dto.basedata.Basedata;

public interface IBasedataDao {
	
	public List<Basedata> findAll();
	
	public List<Basedata> findByName(String name);
	
	public int deleteByPrimaryKey(int id);
	
	public Basedata findById(int id);
	
	public int updateById(Basedata basedata);
	
	public int add(Basedata basedata);
	
	public Basedata findBySingerAndTitle(String singer, String songName);
	
	public int queryCount();
}
