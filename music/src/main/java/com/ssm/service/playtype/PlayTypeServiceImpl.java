package com.ssm.service.playtype;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.dao.playtype.IPlayTypeDao;
import com.ssm.dto.category.PlayType;

@Service("playTypeService")
public class PlayTypeServiceImpl implements IPlayTypeService{
	
	@Resource
	IPlayTypeDao dao;
	
	public List<PlayType> findAll(){
		return dao.findAll();
	}
	
	public PlayType findById(int catId) {
		return dao.findById(catId);
	}
	
	public PlayType findByName(String name) {
		return dao.findByName(name);
	}
}
