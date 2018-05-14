package com.ssm.controller.mymusic;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONArray;
import com.ssm.config.constant.Constant;
import com.ssm.dto.basedata.Basedata;
import com.ssm.dto.category.PlayType;
import com.ssm.dto.playlist.Playlist;
import com.ssm.dto.playlisttosongs.PlaylistToSongs;
import com.ssm.dto.singletoplaylist.SingleToPlaylists;
import com.ssm.dto.song.Song;
import com.ssm.dto.user.User;
import com.ssm.dto.singleplaylist.SinglePlaylist;
import com.ssm.service.basedata.IBasedataService;
import com.ssm.service.playlist.IPlaylistService;
import com.ssm.service.playlisttosongs.IPlaylistToSongsService;
import com.ssm.service.playtype.IPlayTypeService;
import com.ssm.service.singleplaylist.ISinglePlaylistService;
import com.ssm.service.singtoplaylists.ISingleToPlaylistsService;
import com.ssm.service.song.ISongService;
import com.ssm.util.StringUtil;

@Controller
public class MyMusicController {
	
	@Resource
	private IPlaylistService playlistService;
	
	@Resource
	private ISongService songService;
	
	@Resource
	private IPlaylistToSongsService playlistToSongsService;
	
	@Resource
	private ISongService songServie;
	
	@Resource
	private IBasedataService basedataService;
	
	@Resource
	private IPlayTypeService playTypeService;
	
	@Resource
	private ISingleToPlaylistsService singleToPlaylistsService;
	
	@Resource
	private ISinglePlaylistService singlePlaylistService;
	
	@RequestMapping("/updateMyMusicPlayNum")
	public String updatePlayNum(HttpServletRequest request, @RequestBody String arr, Model model) {
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
		rows = playlistService.updatePlayNum(pid);
		return "front/MyMusic/myMusic";
	}
	
	@RequestMapping("/updateSingleSongInfo")
	public String updateSingleSongInfo(HttpServletRequest request, @RequestBody String arr, Model model) {
		JSONArray arr2=(JSONArray) JSONArray.parse(arr);
		List<Song> songs = songService.querySongByBatch(Arrays.asList(Long.parseLong(arr2.getString(3))));
		Basedata basedata = basedataService.findBySingerAndTitle(arr2.getString(1), arr2.getString(0));
		Song song = songs.get(0);
		song.setStitle(arr2.getString(0));
		song.setSinger(arr2.getString(1));
		song.setStime(arr2.getString(2));
		song.setAlbumName(arr2.getString(4));
		if(basedata != null) {
			song.setAlbumPic(basedata.getAlbumPic());
		}
		int nCount = songService.update(song);
		return "front/MyMusic/myMusic";
	}
	
	@RequestMapping("/uploadfileFront")    
    public String uploadFile(@RequestParam("files") MultipartFile[] files,@RequestParam("pid")Integer pid, HttpServletRequest request){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//判断file数组不能为空并且长度大于0  
        if(files!=null && files.length>0){  
            //循环获取file数组中得文件  
            for(int i = 0;i<files.length;i++){  
                MultipartFile file = files[i];  
                try {
                    //获取存取路径
//                	String newFilename = file.getOriginalFilename()+"_"+RandomStringUtils.randomAlphanumeric(10);
                	String newFilename = file.getOriginalFilename();
                    String filePath = request.getSession().getServletContext().getRealPath(Constant.PATH_OF_MUSIC) + "/" + newFilename;  
                    //判断文件是否存在
                    File file2 = new File(filePath);
                    if(!file2.exists()) {
                    	file.transferTo(new File(filePath));// 转存文件  
                    }
                    List<String>dst = new ArrayList<String>();
                    dst = StringUtil.SplitMP3File(newFilename);
                    
                    Song song = new Song();
                    song.setSid(StringUtil.getAtomicCounter());
                    song.setPath(Constant.PATH_OF_MUSIC+ "/" + newFilename);
                    if(dst.size() > 1){
                    	song.setStitle(dst.get(1));//歌曲名
                    	song.setSinger(dst.get(0));//歌手名
                    	song.setLastUpdateTime(sdf.format(new Date()));
                    	song.setCreateTime(sdf.format(new Date()));
                    	String singer = dst.get(0).trim();
                    	String songName=StringUtil.GetFilenameWithoutSuffix(dst.get(1)).trim();
                    	Basedata basedata = basedataService.findBySingerAndTitle(singer, songName);
                    	if(basedata != null) {
                    		song.setAlbumID(basedata.getAlbumId());
                    		song.setAlbumName(basedata.getAlbumName());
                    		song.setSingerID(basedata.getSingerId());
                    		song.setSinger(basedata.getSinger());
                    		song.setSid(basedata.getSongId());
                    		song.setAlbumPic(basedata.getAlbumPic());
                    	}
                    	songService.removeBySingerAndTitle(singer, dst.get(1));//去除重复的歌曲
                    }else {
                    	song.setStitle(newFilename);//歌曲名
                    	song.setSinger(newFilename);//歌手名
                    	song.setLastUpdateTime(sdf.format(new Date()));
                    	song.setCreateTime(sdf.format(new Date()));
                    	String singer = newFilename;
                    	String songName=StringUtil.GetFilenameWithoutSuffix(newFilename).trim();
                    	Basedata basedata = basedataService.findBySingerAndTitle(singer, songName);
                    	if(basedata != null) {
                    		song.setAlbumID(basedata.getAlbumId());
                    		song.setAlbumName(basedata.getAlbumName());
                    		song.setSingerID(basedata.getSingerId());
                    		song.setSinger(basedata.getSinger());
                    		song.setSid(basedata.getSongId());
                    		song.setAlbumPic(basedata.getAlbumPic());
                    	}
                    	songService.removeBySingerAndTitle(newFilename, newFilename);//去除重复的歌曲
                    }
                    song.setSize(file.getSize()/Constant.MB);
                    songService.add(song);
                    PlaylistToSongs pSongs = new PlaylistToSongs();
                    pSongs.setPid(pid);
                    pSongs.setSid(song.getSid());
                    playlistToSongsService.removeByPidAndSid(pid, song.getSid());//去除歌单中重复包含的歌曲
                    playlistToSongsService.add(pSongs);
                    
                } catch (IOException e) {
                    e.printStackTrace();
                }  
            }
             
        }
        return "front/MyMusic/myMusic";
    }
	
	@RequestMapping("/addPlaylist")
	public @ResponseBody Playlist addPlaylist(HttpServletRequest request,Model model) {
		String name = request.getParameter("name");
		HttpSession session = request.getSession();
        User user = (User)session.getAttribute(Constant.LOGIN_SYSTEM_USER);
        Playlist playlist = new Playlist();
        playlist.setTitle(name);
        playlist.setAuthorName(user.getName());
        playlist.setAuthorId(user.getId());
        playlist.setUserId(user.getId());
        StringBuilder sb = new StringBuilder();  
        sb.append("MM月dd日");
        SimpleDateFormat sdf = new SimpleDateFormat(sb.toString());  
        String dateString = sdf.format(new Date()); 
        playlist.setModifyTime(dateString);
        playlist.setPlaynum(0);
        playlist.setSongnum(0);
        playlist.setType(Constant.PLAYLIST_TYPE_HOT);//默认值
        playlist.setTypeName("热门");//默认值
        playlist.setUuid(StringUtil.getAtomicCounter());
		int rows = playlistService.addPlaylist(playlist);
		
		if(rows > 0) {
			Playlist result = playlistService.findByUUId(playlist.getUuid());
			SinglePlaylist singlePlaylist = new SinglePlaylist();
			singlePlaylist.setAuthor(user.getName());
			singlePlaylist.setAuthorId(user.getId());
			singlePlaylist.setAuthorPic(user.getPic());
			singlePlaylist.setCreateTime(dateString);
			singlePlaylist.setPath("");
			singlePlaylist.setPdesc("");
			singlePlaylist.setPid(result.getId());
			singlePlaylist.setPlayNum(0);
			singlePlaylist.setTitle(name);
			singlePlaylistService.add(singlePlaylist);
			return result;
		}else {
			return null;
		}
	}
	
	@RequestMapping("/changePlaylist")
	public String changePlaylist(HttpServletRequest request,Model model) {
		
		String id = request.getParameter("id");
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute(Constant.LOGIN_SYSTEM_USER);
		if(user == null){
		    return "redirect:login";
		}
		List<Playlist>playlists = playlistService.findByUserId(user.getId());
		Playlist playlist = playlistService.findById(Integer.parseInt(id));
		
		//被选中的歌单歌曲数
		List<PlaylistToSongs> plSongs = playlistToSongsService.findByPid(playlist.getId());
		if(plSongs.size() == 0) {
			playlist.setSongnum(0);
		}else {
			playlist.setSongnum(plSongs.size());
		}
		
		//每个歌单的歌曲数
		for (Playlist pl : playlists) {
			List<PlaylistToSongs> ps = playlistToSongsService.findByPid(pl.getId());
			if(ps.size() == 0) {
				pl.setSongnum(0);
			}else {
				pl.setSongnum(ps.size());
			}
		}
		
		List<Long>idList = new ArrayList<Long>();
		for (PlaylistToSongs item : plSongs) {
			idList.add(item.getSid());
		}
		if(idList.size() > 0){
			List<Song> songs = songServie.querySongByBatch(idList);
			if(songs.size() > 0) {
				for (int i = 0; i < songs.size(); i++) {
					songs.get(i).setId(i+1);
				}
			}
			model.addAttribute("songs", songs);
			model.addAttribute("total", idList.size());
		}
		model.addAttribute("playlist", playlist);//登录后，默认展示我喜欢的音乐歌单
		model.addAttribute("plTotal", playlists.size());
		model.addAttribute("playlists", playlists);
		
		return "front/MyMusic/myMusic";
	}
	
	@RequestMapping("/delPlaylist")
	public @ResponseBody String delPlaylist(HttpServletRequest request,Model model) {
		String id = request.getParameter("id");
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute(Constant.LOGIN_SYSTEM_USER);
		if(user == null){
		    return "false";
		}
		int nRows = playlistService.removeById(Integer.parseInt(id));
		if(nRows > 0) {
			return "success";
		}else {
			return "false";
		}
	}
	
	@RequestMapping("/toEditPlaylist")
	public @ResponseBody JSONArray toEditPlaylist(HttpServletRequest request,Model model) {
		JSONArray jArray = new JSONArray();
		String id = request.getParameter("id");
		List<PlayType> pTypes = playTypeService.findAll();
		Playlist playlist = playlistService.findById(Integer.parseInt(id));
		List<SingleToPlaylists> singleToPlaylists = 
				singleToPlaylistsService.findByPid(Integer.parseInt(id));
		jArray.add(0, pTypes);
		jArray.add(1,playlist);
		jArray.add(2,singleToPlaylists);
		return jArray;
	}
	
	//修改歌单
	@RequestMapping("/uploadPlaylistOfMyMusic")
	public @ResponseBody String uploadPlaylistOfMyMusic(@RequestParam("playlistName") String playlistName,
			@RequestParam("textarea")String textarea, @RequestParam("files") MultipartFile[] files,
			@RequestParam("playTypes")String[] playTypes,@RequestParam("pid")Integer pid,
			@RequestParam("image")String image,
			HttpServletRequest request) {
		try {
			int nCount = 0;
			String path = "";
			if(!image.isEmpty() && (files.length==0)) {
				path = image;
			}else {
				String newFilename = files[0].getOriginalFilename();
		        String filePath = request.getSession().getServletContext().getRealPath(Constant.PATH_OF_IMAGE) + "/" + newFilename;  
		        // 转存文件  
		        files[0].transferTo(new File(filePath));
		        path = Constant.PATH_OF_IMAGE+"/"+newFilename;
			}
			Playlist playlist = playlistService.findById(pid);
			playlist.setTitle(playlistName);
			playlist.setPdesc(textarea);
			playlist.setPath(path);
			List<SingleToPlaylists>sTPls = new ArrayList<SingleToPlaylists>();
			for(int i = 0; i< playTypes.length; i++) {
				PlayType pType = playTypeService.findByName(playTypes[i]);
				SingleToPlaylists sTPl = new SingleToPlaylists();
				sTPl.setCatId(pType.getCatId());
				sTPl.setCatLink(pType.getCatLink());
				sTPl.setCatName(pType.getCatName());
				sTPl.setPid(pid);
				sTPls.add(sTPl);
			}
			playlistService.updateByElement(playlist);
			singleToPlaylistsService.removeByPId(pid);
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute(Constant.LOGIN_SYSTEM_USER);
			SinglePlaylist singlePlaylist = singlePlaylistService.findById(pid);
			singlePlaylist.setPath(path);
			singlePlaylist.setPdesc(textarea);
			singlePlaylist.setTitle(playlistName);
			singlePlaylist.setAuthorPic(user.getPic());
			singlePlaylist.setPlayNum(playlist.getPlaynum());
			nCount = singlePlaylistService.updateByPid(singlePlaylist);
			nCount = singleToPlaylistsService.removeByPId(pid);
			for (SingleToPlaylists temp : sTPls) {
				nCount = singleToPlaylistsService.add(temp);
			}
		}catch (Exception ex) {
			return ex.getMessage();
		}

		return "success";
	}
	
}
