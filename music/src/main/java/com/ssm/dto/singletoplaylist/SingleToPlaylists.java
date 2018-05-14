package com.ssm.dto.singletoplaylist;

public class SingleToPlaylists {
	
	private int id;
	
	private int pid;//歌单ID
	
	private int catId;
	
	private String catName;//歌单分类名
	
	private String catLink;//歌单分类链接

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public String getCatLink() {
		return catLink;
	}

	public void setCatLink(String catLink) {
		this.catLink = catLink;
	}
	
	
}
