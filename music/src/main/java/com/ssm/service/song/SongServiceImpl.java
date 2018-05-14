package com.ssm.service.song;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.dao.song.ISongDao;
import com.ssm.dto.song.Song;

@Service("songService")
public class SongServiceImpl implements ISongService{

	@Resource
	ISongDao dao;
	
	public List<Song> querySongByBatch(List<Long>idList) {
		return dao.querySongByBatch(idList);
	}
	
	public List<Song> querySongByName(String name){
		return dao.querySongByName(name);
	}
	
	public int add(Song song) {
		return dao.add(song);
	}

	@Override
	public int removeBySingerAndTitle(String singer, String songName) {
		return dao.removeBySingerAndTitle(singer, songName);
	}
	
	public int update(Song song) {
		return dao.update(song);
	}
	
	public List<Song> findTop(int num){
		return dao.findTop(num);
	}

	public List<Song> findTopOfUp(int num){
		return dao.findTopOfUp(num);
	}
	
	public List<Song> findAll(){
		return dao.findAll();
	}
	
	public List<Song> findTopOfNew(int num){
		return dao.findTopOfNew(num);
	}
	
	public int queryCount() {
		return dao.queryCount();
	}
	
	public int removeBySid(long sid) {
		return dao.removeBySid(sid);
	}
	
	public int queryCountByName(String name) {
		return dao.queryCountByName(name);
	}
}
