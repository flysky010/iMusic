package com.ssm.service.playlist;

import java.util.List;
import javax.annotation.Resource;

import org.springframework.dao.support.DaoSupport;
import org.springframework.stereotype.Service;
import com.ssm.dao.playlist.IPlaylistDao;
import com.ssm.dto.playlist.Playlist;

@Service("playlistService")
public class PlaylistServiceImpl implements IPlaylistService{
	
	@Resource
	private IPlaylistDao playlistDao;
	
	public List<Playlist> findListByType(Integer type){
		return playlistDao.findListByType(type);
	}
	
	public List<Playlist> findByName(String name){
		return playlistDao.findByName(name);
	}
	
	public List<Playlist> findAll(){
		return playlistDao.findAll();
	}
	
	public List<Playlist> findByUserId(int id){
		return playlistDao.findByUserId(id);
	}
	
	public int updatePlayNum(int pid) {
		return playlistDao.updatePlayNum(pid);
	}
	
	public int addPlaylist(Playlist playlist) {
		return playlistDao.addPlaylist(playlist);
	}
	
	public Playlist findById(int id) {
		return playlistDao.findById(id);
	}
	
	public int removeById(int id){
		return playlistDao.removeById(id);
	}
	
	public int updateByElement(Playlist playlist) {
		return playlistDao.updateByElement(playlist);
	}
	
	public List<Playlist>findOfCarousel(int isCarousel){
		return playlistDao.findOfCarousel(isCarousel);
	}
	
	public int findCountByType(int type) {
		return playlistDao.findCountByType(type);
	}
	
	public int findCountByTypeName(String typeName) {
		return playlistDao.findCountByTypeName(typeName);
	}
	
	public Playlist findByUUId(long uuid) {
		return playlistDao.findByUUId(uuid);
	}
	
	public List<Playlist> findAll2(){
		return playlistDao.findAll2();
	}
	
	public int queryCount() {
		return playlistDao.queryCount();
	}
}
