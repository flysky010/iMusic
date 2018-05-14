package com.ssm.service.singtoplaylists;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.dao.singletoplaylists.ISingleToPlaylistsDao;
import com.ssm.dto.singletoplaylist.SingleToPlaylists;

@Service("singleToPlaylistsService")
public class SingleToPlaylistsServiceImpl implements ISingleToPlaylistsService{

	@Resource
	ISingleToPlaylistsDao dao;
	
	public List<SingleToPlaylists> findByPid(int pid) {
		return dao.findByPid(pid);
	}
	
	public int add(SingleToPlaylists singleToPlaylists) {
		return dao.add(singleToPlaylists);
	}
	
	public int removeByPId(int id) {
		return dao.removeByPId(id);
	}
	
	public List<SingleToPlaylists> findByCatId(int catId){
		return dao.findByCatId(catId);
	}
	
	public int findCountByCatId(int catId) {
		return dao.findCountByCatId(catId);
	}
	
	public List<SingleToPlaylists> findByCatName(String catName){
		return dao.findByCatName(catName);
	}
	
	public int findCountByCatName(String catName) {
		return dao.findCountByCatName(catName);
	}
}
