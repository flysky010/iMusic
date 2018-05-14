package com.ssm.dao.ranklisttosongs;

import java.util.List;

import com.ssm.dto.ranklisttosongs.RanklistToSongs;

public interface IRanklistToSongsDao {

	public List<RanklistToSongs> findByRid(int rid);
}
