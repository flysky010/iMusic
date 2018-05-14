package com.ssm.service.ranklist;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.dao.ranklist.IRanklistDao;
import com.ssm.dto.ranklist.Ranklist;

@Service("ranklistService")
public class RanklistServiceImpl implements IRanklistService{

	@Resource
	private IRanklistDao dao;
	
	public Ranklist findByRid(int id){
		return dao.findByRid(id);
	}
	
	public int updatePlayNum(int rid){
		return dao.updatePlayNum(rid);
	}
	
	public List<Ranklist> findAll(){
		return dao.findAll();
	}
}
