package com.ssm.controller.playlist;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.config.constant.Constant;
import com.ssm.dto.basedata.Basedata;
import com.ssm.dto.category.PlayType;
import com.ssm.dto.playlist.Playlist;
import com.ssm.dto.playlisttosongs.PlaylistToSongs;
import com.ssm.dto.singleplaylist.SinglePlaylist;
import com.ssm.dto.singletoplaylist.SingleToPlaylists;
import com.ssm.dto.song.Song;
import com.ssm.service.playlist.IPlaylistService;
import com.ssm.service.playlisttosongs.IPlaylistToSongsService;
import com.ssm.service.playtype.IPlayTypeService;
import com.ssm.service.singleplaylist.ISinglePlaylistService;
import com.ssm.service.singtoplaylists.ISingleToPlaylistsService;
import com.ssm.service.song.ISongService;

@Controller
public class PlaylistController {

	@Resource
	private IPlaylistService playlistService;
	
	@Resource
	private ISinglePlaylistService singlePlaylistService;
	
	@Resource
	private ISingleToPlaylistsService singleToPlaylistsService;
	
	@Resource
	private IPlaylistToSongsService playlistToSongsService;
	
	@Resource
	private ISongService songService;
	
	@Resource
	private IPlayTypeService playTypeService;
	
	@RequestMapping("/c_playlist")
	public String findPlaylistByType(HttpServletRequest request,Model model){
		String type = request.getParameter("type");
		if(type != null && !type.isEmpty()){
			int pageSize = Constant.SINGLE_PAGE_OF_MUSIC;  
		    PageHelper.startPage(1, pageSize);  //startPage是告诉拦截器说我要开始分页了
		    List<SingleToPlaylists> singleToPlaylists = singleToPlaylistsService.findByCatId(Integer.parseInt(type));
		    List<Playlist> playlists = new ArrayList<Playlist>();
			for (SingleToPlaylists stpl : singleToPlaylists) {
				Playlist playlist = playlistService.findById(stpl.getPid());
				playlists.add(playlist);
			}
			String name = "";
			PlayType playType = playTypeService.findById(Integer.parseInt(type));
			name = playType.getCatName();
			int count = singleToPlaylistsService.findCountByCatId(Integer.parseInt(type));
		    int pages = count/Constant.SINGLE_PAGE_OF_MUSIC;
			if(count % Constant.SINGLE_PAGE_OF_MUSIC != 0){
				pages++;
			}
//			PageInfo<Playlist> pInfo = new PageInfo<Playlist>(playlists);
		    List<com.ssm.dto.pagehelper.PageHelper> listPage = new ArrayList<com.ssm.dto.pagehelper.PageHelper>();
		    for (int i = 0; i < pages; i++) {
		    	com.ssm.dto.pagehelper.PageHelper pHelper = new com.ssm.dto.pagehelper.PageHelper();
				pHelper.setSerNum(i+1);
				listPage.add(pHelper);
			}
			model.addAttribute("name", name);
			model.addAttribute("playlists", playlists);
			model.addAttribute("listPage", listPage);
		    model.addAttribute("curNum", 1);//切换标签时，从第一页开始
		}else{//上一页，下一页跳转
			String num = request.getParameter("num");
			String catName = request.getParameter("catName");
			if(!num.isEmpty()){
				int pageNo = Integer.parseInt(num);  
				if(pageNo == 0){
					pageNo = 1;
				}
			    int pageSize = Constant.SINGLE_PAGE_OF_MUSIC;  
			    PageHelper.startPage(pageNo, pageSize);  //startPage是告诉拦截器说我要开始分页了
			    List<SingleToPlaylists> singleToPlaylists = singleToPlaylistsService.findByCatName(catName);
			    List<Playlist> playlists = new ArrayList<Playlist>();
			    if(singleToPlaylists.size() == 0 && pageNo > 0){
			    	pageNo--;
			    	PageHelper.startPage(pageNo, pageSize);  //startPage是告诉拦截器说我要开始分页了
			    	singleToPlaylists = singleToPlaylistsService.findByCatName(catName);
			    	for (SingleToPlaylists stpl : singleToPlaylists) {
						Playlist playlist = playlistService.findById(stpl.getPid());
						playlists.add(playlist);
					}
			    }else {
			    	for (SingleToPlaylists stpl : singleToPlaylists) {
						Playlist playlist = playlistService.findById(stpl.getPid());
						playlists.add(playlist);
					}
			    }
			    int count = singleToPlaylistsService.findCountByCatName(catName);
			    int pages = count/Constant.SINGLE_PAGE_OF_MUSIC;
				if(count % Constant.SINGLE_PAGE_OF_MUSIC != 0){
					pages++;
				}
			    List<com.ssm.dto.pagehelper.PageHelper> listPage = new ArrayList<com.ssm.dto.pagehelper.PageHelper>();
			    for (int i = 0; i < pages; i++) {
			    	com.ssm.dto.pagehelper.PageHelper pHelper = new com.ssm.dto.pagehelper.PageHelper();
					pHelper.setSerNum(i+1);
					listPage.add(pHelper);
				}
			    model.addAttribute("name", catName);
			    model.addAttribute("playlists", playlists);
			    model.addAttribute("listPage", listPage);
			    model.addAttribute("curNum", pageNo);
			}
		}
		return "front/List/playlist";
		
	}
	
	@RequestMapping("/singleplaylist")
	public String findPlaylistById(HttpServletRequest request,Model model){
		String pid = request.getParameter("pid");
		int pid_int = Integer.parseInt(pid);
		SinglePlaylist singlePlaylist = singlePlaylistService.findById(pid_int);
		List<SingleToPlaylists> sToPl = singleToPlaylistsService.findByPid(pid_int);
		List<PlaylistToSongs> plToSongs = playlistToSongsService.findByPid(pid_int);
		List<Long>idList = new ArrayList<Long>();
		for (PlaylistToSongs pItem : plToSongs) {
			idList.add(pItem.getSid());
		}
		List<Song> songs = null;
		if(idList.size() > 0) {
			songs = songService.querySongByBatch(idList);
		}
		model.addAttribute("singlePlaylist", singlePlaylist);
		model.addAttribute("categorys", sToPl);
		model.addAttribute("total", plToSongs.size());
		model.addAttribute("songs", songs);
		return "front/Singleplaylist/singleplaylist";
	}
	
	@RequestMapping("/showPlaylist")
	public String showPlaylist(HttpServletRequest request,Model model){
		String num = request.getParameter("num");
		int pageNo = 1;
		if(num != null && !num.isEmpty()) {
			pageNo = Integer.parseInt(num);  
			if(pageNo == 0){
				pageNo = 1;
			}
		}
		int pageSize = Constant.SINGLE_PAGE_OF_BASEDATA;  
	    PageHelper.startPage(pageNo, pageSize);  //startPage是告诉拦截器说我要开始分页了
	    List<Playlist>playlists = playlistService.findAll2(); 
        if(playlists.size() == 0 && pageNo > 0){
	    	pageNo--;
	    	PageHelper.startPage(pageNo, pageSize);  //startPage是告诉拦截器说我要开始分页了
	    	playlists = playlistService.findAll2();
	    }
        int count = playlistService.queryCount();
	    int pages = count/Constant.SINGLE_PAGE_OF_BASEDATA;
		if(count % Constant.SINGLE_PAGE_OF_BASEDATA != 0){
			pages++;
		}
	    List<com.ssm.dto.pagehelper.PageHelper> listPage = new ArrayList<com.ssm.dto.pagehelper.PageHelper>();
	    for (int i = 0; i < pages; i++) {
	    	com.ssm.dto.pagehelper.PageHelper pHelper = new com.ssm.dto.pagehelper.PageHelper();
			pHelper.setSerNum(i+1);
			listPage.add(pHelper);
		}
		for (Playlist playlist : playlists) {
			List<PlaylistToSongs> plToSongs = playlistToSongsService.findByPid(playlist.getId());
			playlist.setPlaynum(plToSongs.size());
		}
		model.addAttribute("listPage", listPage);
		model.addAttribute("curNum", pageNo);
		model.addAttribute("playlists", playlists);
		return "systemManagement/Playlist/playlist";
	}
	
	@RequestMapping("toPlaylistDelete")
	public String removePlaylist(HttpServletRequest request,Model model){
		String id = request.getParameter("id");
		int rows = playlistService.removeById(Integer.parseInt(id));
		rows = playlistToSongsService.removeByPid(Integer.parseInt(id));
		rows = singleToPlaylistsService.removeByPId(Integer.parseInt(id));
		return "redirect:showPlaylist";
	}
	
	@RequestMapping("/toPlaylistMgEdit")    
    public String toBasedataEdit(HttpServletRequest request,Model model){    
        int id = Integer.parseInt(request.getParameter("id"));    
        Playlist playlist = playlistService.findById(id);
        List<PlayType> pts = playTypeService.findAll();
        model.addAttribute("playlist", playlist);
        model.addAttribute("pts", pts); 
        return "systemManagement/Playlist/playlistEdit";    
    }
	
	@RequestMapping("/updatePlaylistMg")
	public String updatePlaylistMg(HttpServletRequest request,Model model,Playlist playlist){  
		String typeName = request.getParameter("typeName");
		switch (typeName) {
			case "热门":
				playlist.setType(Constant.PLAYLIST_TYPE_HOT);
				break;
			case "流行":
				playlist.setType(Constant.PLAYLIST_TYPE_POPULAR);
				break;
			case "摇滚":
				playlist.setType(Constant.PLAYLIST_TYPE_ROCK);
				break;
			case "民谣":
				playlist.setType(Constant.PLAYLIST_TYPE_BALLAD);
				break;
			case "华语":
				playlist.setType(Constant.PLAYLIST_TYPE_CHINESE);
				break;
			default:
				break;
		}
		playlistService.updateByElement(playlist);
    	return "redirect:showPlaylist";   
    }
}
