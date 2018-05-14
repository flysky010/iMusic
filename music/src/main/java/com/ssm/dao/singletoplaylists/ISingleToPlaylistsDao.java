package com.ssm.dao.singletoplaylists;

import java.util.List;

import com.ssm.dto.singletoplaylist.SingleToPlaylists;

public interface ISingleToPlaylistsDao {
	
	public List<SingleToPlaylists> findByPid(int pid);
	
	public int add(SingleToPlaylists singleToPlaylists);

	public int removeByPId(int id);
	
	public List<SingleToPlaylists> findByCatId(int catId);
	
	public int findCountByCatId(int catId);
	
	public List<SingleToPlaylists> findByCatName(String catName);
	
	public int findCountByCatName(String catName);
}
