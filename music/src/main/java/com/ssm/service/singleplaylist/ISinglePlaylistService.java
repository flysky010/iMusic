package com.ssm.service.singleplaylist;

import com.ssm.dto.singleplaylist.SinglePlaylist;
import com.ssm.dto.singletoplaylist.SingleToPlaylists;

public interface ISinglePlaylistService {
	
	public SinglePlaylist findById(int id);
	
	public int updatePlayNum(int pid);

	public int add(SinglePlaylist singlePlaylist);
	
	public int updateByPid(SinglePlaylist singlePlaylist);
}
