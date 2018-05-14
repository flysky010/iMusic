package com.ssm.dto.song;

public class Song {

	private int id;
	
	private long sid;
	
	private String stitle;
	
	private String stime;
	
	private String singer;
	
	private long singerID;
	
	private long albumID;
	
	private String albumName;
	
	private String path;//歌曲文件路径
	
	private double size;
	
	private String albumPic;//专辑图片路径
	
	private String lyric;//歌词
	
	private long playNum;//歌曲播放次数
	
	private long lastWeekendPlayNum;//截止上周总播放次数
	
	private long increaseNum;
	
	private String lastUpdateTime;
	
	private String createTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getSid() {
		return sid;
	}

	public void setSid(long sid) {
		this.sid = sid;
	}

	public String getStitle() {
		return stitle;
	}

	public void setStitle(String stitle) {
		this.stitle = stitle;
	}

	public String getStime() {
		return stime;
	}

	public void setStime(String stime) {
		this.stime = stime;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	public long getSingerID() {
		return singerID;
	}

	public void setSingerID(long singerID) {
		this.singerID = singerID;
	}

	public long getAlbumID() {
		return albumID;
	}

	public void setAlbumID(Long albumID) {
		this.albumID = albumID;
	}

	public void setAlbumID(long albumID) {
		this.albumID = albumID;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public String getAlbumPic() {
		return albumPic;
	}

	public void setAlbumPic(String albumPic) {
		this.albumPic = albumPic;
	}

	public String getLyric() {
		return lyric;
	}

	public void setLyric(String lyric) {
		this.lyric = lyric;
	}

	public long getPlayNum() {
		return playNum;
	}

	public void setPlayNum(long playNum) {
		this.playNum = playNum;
	}

	public long getLastWeekendPlayNum() {
		return lastWeekendPlayNum;
	}

	public void setLastWeekendPlayNum(long lastWeekendPlayNum) {
		this.lastWeekendPlayNum = lastWeekendPlayNum;
	}

	public long getIncreaseNum() {
		return increaseNum;
	}

	public void setIncreaseNum(long increaseNum) {
		this.increaseNum = increaseNum;
	}

	public String getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(String lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	
}
