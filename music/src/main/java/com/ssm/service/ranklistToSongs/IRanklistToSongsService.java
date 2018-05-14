package com.ssm.service.ranklistToSongs;

import java.util.List;

import com.ssm.dto.ranklisttosongs.RanklistToSongs;

public interface IRanklistToSongsService {

	public List<RanklistToSongs> findByRid(int rid);
}
