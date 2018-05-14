package com.ssm.dao.playlist;

import java.util.List;

import com.ssm.dto.playlist.Playlist;

public interface IPlaylistDao {
	public List<Playlist> findListByType(Integer type);
	
	public List<Playlist> findByName(String name);
	
	public List<Playlist> findAll();
	
	public List<Playlist> findByUserId(int id);
	
	public int updatePlayNum(int pid);
	
	public int addPlaylist(Playlist playlist);
	
	public Playlist findById(int id);
	
	public int removeById(int id);
	
	public int updateByElement(Playlist playlist);
	
	public List<Playlist>findOfCarousel(int isCarousel);
	
	public int findCountByType(int type);
	
	public int findCountByTypeName(String typeName);
	
	public Playlist findByUUId(long uuid);
	
	public List<Playlist> findAll2();
	
	public int queryCount();
}
