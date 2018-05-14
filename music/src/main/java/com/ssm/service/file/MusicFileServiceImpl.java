package com.ssm.service.file;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.dao.file.IMusicFileDao;
import com.ssm.dto.file.MusicFile;

@Service("fileService")
public class MusicFileServiceImpl implements IMusicFileService{
	@Resource
	private IMusicFileDao musicFileDao;
	
	public List<MusicFile> getAllFile() {
		return musicFileDao.getAllFile();
	}
	
	public void addFile(MusicFile file){
		musicFileDao.addFile(file);
	}
	
	public MusicFile getFileById(Integer id){
		return musicFileDao.getFileById(id);
	}
	
	public void updateByPrimaryKey(MusicFile file){
		musicFileDao.updateByPrimaryKey(file);
	}
	
	public void deleteByPrimaryKey(Integer id){
		musicFileDao.deleteByPrimaryKey(id);
	}
	
	public MusicFile findById(Integer id){
		return musicFileDao.findById(id);
	}
	
	public List<MusicFile> findByFilename(String song){
		return musicFileDao.findByFilename(song);
	}
	
	public int queryCount() {
		return musicFileDao.queryCount();
	}
}
