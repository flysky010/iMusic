package com.ssm.dto.playlist;

public class Playlist {
	
	private int id;
	
	private int type;
	
	private String path;//歌单图片路径
	
	private String title;
	
	private int authorId;
	
	private String authorName;
	
	private String typeName;
	
	private int userId;
	
	private String modifyTime;
	
	private int playnum;
	
	private int isShow;
	
	private int songnum;
	
	private int isCarousel;
	
	private long uuid;
	
	private String pdesc;//歌单描述

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}
	
	public int getIsShow() {
		return isShow;
	}

	public void setIsShow(int isShow) {
		this.isShow = isShow;
	}

	public int getPlaynum() {
		return playnum;
	}

	public void setPlaynum(int playnum) {
		this.playnum = playnum;
	}

	public int getSongnum() {
		return songnum;
	}

	public void setSongnum(int songnum) {
		this.songnum = songnum;
	}

	public int getIsCarousel() {
		return isCarousel;
	}

	public void setIsCarousel(int isCarousel) {
		this.isCarousel = isCarousel;
	}

	public long getUuid() {
		return uuid;
	}

	public void setUuid(long uuid) {
		this.uuid = uuid;
	}

	public String getPdesc() {
		return pdesc;
	}

	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}
	
	
}
