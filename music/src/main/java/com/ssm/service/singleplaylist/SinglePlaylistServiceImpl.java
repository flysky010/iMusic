package com.ssm.service.singleplaylist;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.dao.singleplaylist.ISinglePlaylistDao;
import com.ssm.dto.singleplaylist.SinglePlaylist;
import com.ssm.dto.singletoplaylist.SingleToPlaylists;

@Service("singlePlaylistService")
public class SinglePlaylistServiceImpl implements ISinglePlaylistService{
	
	@Resource
	ISinglePlaylistDao singlePlaylistDao;
	
	public SinglePlaylist findById(int id){
		return singlePlaylistDao.findById(id);
	}

	@Override
	public int updatePlayNum(int pid) {
		return singlePlaylistDao.updatePlayNum(pid);
	}
	
	public int add(SinglePlaylist singlePlaylist) {
		return singlePlaylistDao.add(singlePlaylist);
	}
	
	public int updateByPid(SinglePlaylist singlePlaylist) {
		return singlePlaylistDao.updateByPid(singlePlaylist);
	}
}
