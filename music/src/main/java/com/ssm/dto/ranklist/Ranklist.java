package com.ssm.dto.ranklist;

import java.util.List;

import com.ssm.dto.song.Song;

public class Ranklist {
	private int id;
	
	private int rid;
	
	private String rname;
	
	private String rmodifytime;
	
	private int rsongnum;
	
	private int rplaynum;
	
	private String rpic;
	
	private List<Song> songlists;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getRmodifytime() {
		return rmodifytime;
	}

	public void setRmodifytime(String rmodifytime) {
		this.rmodifytime = rmodifytime;
	}

	public int getRsongnum() {
		return rsongnum;
	}

	public void setRsongnum(int rsongnum) {
		this.rsongnum = rsongnum;
	}

	public int getRplaynum() {
		return rplaynum;
	}

	public void setRplaynum(int rplaynum) {
		this.rplaynum = rplaynum;
	}

	public String getRpic() {
		return rpic;
	}

	public void setRpic(String rpic) {
		this.rpic = rpic;
	}

	public List<Song> getSonglists() {
		return songlists;
	}

	public void setSonglists(List<Song> songlists) {
		this.songlists = songlists;
	}
	
}
