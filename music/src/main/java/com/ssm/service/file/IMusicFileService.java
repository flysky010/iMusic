package com.ssm.service.file;

import java.util.List;

import com.ssm.dto.file.MusicFile;

public interface IMusicFileService {
	public List<MusicFile> getAllFile();
	
	public void addFile(MusicFile file);
	
	public MusicFile getFileById(Integer id);
	
	public void updateByPrimaryKey(MusicFile file);
	
	public void deleteByPrimaryKey(Integer id);
	
	public MusicFile findById(Integer id);
	
	public List<MusicFile> findByFilename(String song);
	
	public int queryCount();
}
