package com.ssm.controller.Default;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.ssm.config.constant.Constant;
import com.ssm.dto.category.PlayType;
import com.ssm.dto.playlist.Playlist;
import com.ssm.dto.ranklist.Ranklist;
import com.ssm.dto.ranklisttosongs.RanklistToSongs;
import com.ssm.dto.song.Song;
import com.ssm.service.playlist.IPlaylistService;
import com.ssm.service.playtype.IPlayTypeService;
import com.ssm.service.ranklist.IRanklistService;
import com.ssm.service.ranklistToSongs.IRanklistToSongsService;
import com.ssm.service.song.ISongService;

@Controller    
public class HomePageController {

	@Resource
	private IPlaylistService playlistService;
	
	@Resource
	private ISongService songService;
	
	@Resource
	private IPlayTypeService playtypeService;
	
	@Resource
	private IRanklistService ranklistService;
	
	@Resource
	private IRanklistToSongsService ranklistToSongsService;
	
	@RequestMapping("/home")    
    public String homePage(HttpServletRequest request,Model model) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<Playlist>playlists = playlistService.findOfCarousel(1);
		List<PlayType>playTypes = playtypeService.findAll();
		List<Playlist>hotPlaylists = playlistService.findListByType(1);//首页显示热门歌曲歌单
		Ranklist rkHot = ranklistService.findByRid(Constant.RANKLIST_TYPE_HOT);
		List<Song> songs = songService.findTop(Constant.RANKLIST_SHOW_OF_HOMEPAGE);
		for(int i=0;i<songs.size();i++){//临时改变id的值，以后这里要改
			songs.get(i).setId(i+1);
		}
		rkHot.setSonglists(songs);
		boolean bNeedUpdate = false;
		Ranklist rkUp = ranklistService.findByRid(Constant.RANKLIST_TYPE_UP);
		List<Song> songsOfRkUp = songService.findAll();//查找飙升榜歌曲
		for (Song song : songsOfRkUp) {
			Date date1 = (Date) sdf.parse(song.getLastUpdateTime());
			Date date2 = new Date();   
			int days = (int) ((date2.getTime() - date1.getTime()) / (1000*3600*24));
			if(days >= 7) {
				bNeedUpdate = true;
				break;
			}
		}
		if(bNeedUpdate) {
			for (Song song : songsOfRkUp) {
				long increaseNum = song.getPlayNum()-song.getLastWeekendPlayNum();
				song.setIncreaseNum(increaseNum);
				song.setLastWeekendPlayNum(song.getPlayNum());
				song.setLastUpdateTime(sdf.format(new Date()));
				songService.update(song);
			}
		}
		songsOfRkUp = songService.findTopOfUp(Constant.RANKLIST_SHOW_OF_HOMEPAGE);//查找飙升榜歌曲
		rkUp.setSonglists(songsOfRkUp);
		for(int i=0;i<songsOfRkUp.size();i++){//临时改变id的值，以后这里要改
			songsOfRkUp.get(i).setId(i+1);
		}
		Ranklist rkNew = ranklistService.findByRid(Constant.RANKLIST_TYPE_NEW);//查找新歌榜歌曲
		List<Song> songsOfRkNew = songService.findTopOfNew(Constant.RANKLIST_SHOW_OF_HOMEPAGE);
		for(int i=0;i<songsOfRkNew.size();i++){//临时改变id的值，以后这里要改
			songsOfRkNew.get(i).setId(i+1);
		}
		rkNew.setSonglists(songsOfRkNew);
		
		model.addAttribute("playlists", playlists);
		model.addAttribute("playTypes", playTypes);
		model.addAttribute("hotPlaylists", hotPlaylists);
		model.addAttribute("rkUp", rkUp);
		model.addAttribute("rkHot", rkHot);
		model.addAttribute("rkNew", rkNew);
        return "front/Default/home";    
    }
	
	@RequestMapping("/ranklist")    
    public String rankList(HttpServletRequest request,Model model){
		model.addAttribute("id", 1);
		return "redirect:c_ranklist";    
    }
	
	@RequestMapping("/playlist")    
    public String playList(HttpServletRequest request,Model model){
	    
	    int count = playlistService.findCountByType(Constant.PLAYLIST_TYPE_HOT);
	    int pages = count/Constant.SINGLE_PAGE_OF_MUSIC;
		if(count % Constant.SINGLE_PAGE_OF_MUSIC != 0){
			pages++;
		}
	    com.github.pagehelper.PageHelper.startPage(1, Constant.SINGLE_PAGE_OF_MUSIC);  //startPage是告诉拦截器说我要开始分页了
	    List<Playlist> playlists = playlistService.findListByType(Constant.PLAYLIST_TYPE_HOT);
//	    PageInfo<Playlist> pInfo = new PageInfo<Playlist>(playlists);
	    List<com.ssm.dto.pagehelper.PageHelper> listPage = new ArrayList<com.ssm.dto.pagehelper.PageHelper>();
	    for (int i = 0; i < pages; i++) {
	    	com.ssm.dto.pagehelper.PageHelper pHelper = new com.ssm.dto.pagehelper.PageHelper();
			pHelper.setSerNum(i+1);
			listPage.add(pHelper);
		}
		
		PlayType pType = playtypeService.findById(Constant.PLAYLIST_TYPE_HOT);
		model.addAttribute("playlists",playlists);
		model.addAttribute("listPage", listPage);
		model.addAttribute("name", pType.getCatName());
		model.addAttribute("curNum", 1);
		return "front/List/playlist";    
    }
	
	@RequestMapping("/search")
	public String search(HttpServletRequest request,Model model){
		String text = request.getParameter("searchInput");
		if(text.isEmpty()) {
			return "front/Search/searchResult";
		}
		List<Song> songs = songService.querySongByName(text);
		model.addAttribute("snum", songs.size());
		model.addAttribute("songs", songs);
		model.addAttribute("sname", text);
		return "front/Search/searchResult";
	}
	
//	@RequestMapping("/mymusic")
//	public String mymusic(HttpServletRequest request,Model model){
//		
//		return "front/MyMusic/myMusic";
//	}
}
