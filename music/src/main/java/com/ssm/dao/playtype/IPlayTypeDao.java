package com.ssm.dao.playtype;

import java.util.List;

import com.ssm.dto.category.PlayType;

public interface IPlayTypeDao {

	public List<PlayType> findAll();
	
	public PlayType findById(int catId);
	
	public PlayType findByName(String name);
}
