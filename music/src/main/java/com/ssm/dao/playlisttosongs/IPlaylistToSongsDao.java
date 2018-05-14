package com.ssm.dao.playlisttosongs;

import java.util.List;

import com.ssm.dto.playlisttosongs.PlaylistToSongs;

public interface IPlaylistToSongsDao {

	public List<PlaylistToSongs> findByPid(int pid);
	
	public int add(PlaylistToSongs pSongs);
	
	public int removeByPidAndSid(int pid, long sid);
	
	public int findIsExistByPidAndSid(int pid, long sid);
	
	public int removeByPid(int pid);
	
	public int removeBySid(long sid);
}
