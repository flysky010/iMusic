package com.ssm.dao.singleplaylist;

import com.ssm.dto.singleplaylist.SinglePlaylist;
import com.ssm.dto.singletoplaylist.SingleToPlaylists;

public interface ISinglePlaylistDao {
	
	public SinglePlaylist findById(int pid);
	
	public int updatePlayNum(int pid);
	
	public int add(SinglePlaylist singlePlaylist);
	
	public int updateByPid(SinglePlaylist singlePlaylist);
}
