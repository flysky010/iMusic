package com.ssm.dao.ranklist;

import java.util.List;

import com.ssm.dto.ranklist.Ranklist;

public interface IRanklistDao {

	public Ranklist findByRid(int id);
	
	public int updatePlayNum(int rid);
	
	public List<Ranklist> findAll();
}
