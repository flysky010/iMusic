package com.ssm.controller.singleplaylist;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.ssm.config.constant.Constant;
import com.ssm.dto.playlist.Playlist;
import com.ssm.dto.playlisttosongs.PlaylistToSongs;
import com.ssm.dto.song.Song;
import com.ssm.dto.user.User;
import com.ssm.service.playlist.IPlaylistService;
import com.ssm.service.playlisttosongs.IPlaylistToSongsService;
import com.ssm.service.singleplaylist.ISinglePlaylistService;
import com.ssm.service.song.ISongService;

@Controller
public class SinglePlaylistController {

	@Resource
	ISinglePlaylistService singlePlaylistService;
	
	@Resource
	IPlaylistService playlistService;
	
	@Resource
	private IPlaylistToSongsService playlistToSongsService;
	
	@Resource
	private ISongService songService;
	
	@RequestMapping("/updatePlaylistTimes")
	 public String updatePlayNum(HttpServletRequest request, @RequestBody String arr, Model model){
		 JSONArray arr2=(JSONArray) JSONArray.parse(arr);
		 int pid = Integer.parseInt(arr2.getString(0));
		 long sid = Long.parseLong(arr2.getString(1));
		 int rows = singlePlaylistService.updatePlayNum(pid);
		 List<Song> songs = songService.querySongByBatch(Arrays.asList(sid));
		 if(songs.size() > 0) {
			 Song song = songs.get(0);
			 long playNum = song.getPlayNum();
			 song.setPlayNum(playNum+1);
			 rows = songService.update(song);
		 }
		 return "front/Singleplaylist/singleplaylist";
	 }
	
	@RequestMapping("/addToPlaylist")
	public @ResponseBody List<Playlist> addToPlaylist(HttpServletRequest request,Model model) {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute(Constant.LOGIN_SYSTEM_USER);
		if(user == null) {
			return null;
		}
		List<Playlist>playlists = playlistService.findByUserId(user.getId());
		for(int i = 0; i< playlists.size(); i++) {
			List<PlaylistToSongs> plSongs = playlistToSongsService.findByPid(playlists.get(i).getId());
			if(plSongs.size() == 0) {
				playlists.get(i).setSongnum(0);
			}else {
				playlists.get(i).setSongnum(plSongs.size());
			}
		}
		
		return playlists;
	}
	
	@RequestMapping("/addSongsToPlaylist")
	public @ResponseBody String addSongsToPlaylist(HttpServletRequest request,Model model) {
		String pid = request.getParameter("pid");
		String sid = request.getParameter("sid");
		PlaylistToSongs pSongs = new PlaylistToSongs();
		
		pSongs.setPid(Integer.parseInt(pid));
		pSongs.setSid(Long.parseLong(sid));
		int nCount = playlistToSongsService.findIsExistByPidAndSid(pSongs.getPid(), pSongs.getSid());
		int nRows = 0;
		if(nCount <= 0) {//歌曲尚未添加到歌单中
			nRows = playlistToSongsService.add(pSongs);
		}
		if(nRows == 1) {
			return "success";
		}else if(nCount > 0){
			return "repeat";
		}else {
			return "false";
		}
	}
}
