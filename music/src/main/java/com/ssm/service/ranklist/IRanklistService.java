package com.ssm.service.ranklist;

import java.util.List;

import com.ssm.dto.ranklist.Ranklist;

public interface IRanklistService {

	public Ranklist findByRid(int id);
	
	public int updatePlayNum(int rid);
	
	public List<Ranklist> findAll();
}
