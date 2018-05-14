package com.ssm.service.ranklistToSongs;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.dao.ranklisttosongs.IRanklistToSongsDao;
import com.ssm.dto.ranklisttosongs.RanklistToSongs;

@Service("ranklistToSongsService")
public class RanklistToSongsServiceImpl implements IRanklistToSongsService{

	@Resource
	IRanklistToSongsDao dao;
	
	public List<RanklistToSongs> findByRid(int rid){
		return dao.findByRid(rid);
	}
}
