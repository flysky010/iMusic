package com.ssm.service.playlisttosongs;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.dao.playlisttosongs.IPlaylistToSongsDao;
import com.ssm.dto.playlisttosongs.PlaylistToSongs;

@Service("playlistToSongsService")
public class PlaylistToSongsServiceImpl implements IPlaylistToSongsService{

	@Resource
	IPlaylistToSongsDao dao;
	
	public List<PlaylistToSongs> findByPid(int pid){
		return dao.findByPid(pid);
	}
	
	public int add(PlaylistToSongs pSongs) {
		return dao.add(pSongs);
	}
	
	public int removeByPidAndSid(int pid, long sid) {
		return dao.removeByPidAndSid(pid, sid);
	}
	
	public int findIsExistByPidAndSid(int pid, long sid) {
		return dao.findIsExistByPidAndSid(pid, sid);
	}
	
	public int removeByPid(int pid) {
		return dao.removeByPid(pid);
	}
	
	public int removeBySid(long sid) {
		return dao.removeBySid(sid);
	}
}
