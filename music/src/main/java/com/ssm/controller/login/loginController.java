package com.ssm.controller.login;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.config.constant.Constant;
import com.ssm.dto.playlist.Playlist;
import com.ssm.dto.playlisttosongs.PlaylistToSongs;
import com.ssm.dto.song.Song;
import com.ssm.dto.user.User;
import com.ssm.service.playlist.IPlaylistService;
import com.ssm.service.playlisttosongs.IPlaylistToSongsService;
import com.ssm.service.song.ISongService;
import com.ssm.service.user.IUserService;


@Controller
public class loginController {
	
	@Resource
	private IUserService userService;
	
	@Resource
	private IPlaylistService playlistService;
	
	@Resource
	private IPlaylistToSongsService playlistToSongsService;
	
	@Resource
	private ISongService songServie;
	
	@RequestMapping("/login")    
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response){    
		 //校验用户是否已登录
        HttpSession session = request.getSession();
        User systemUser = (User)session.getAttribute(Constant.LOGIN_SYSTEM_USER);
        if(systemUser != null){
    		if(systemUser.getIsAdmin()==1){
        		return new ModelAndView("redirect:mainFrame.do");
        	}else {
        		return new ModelAndView("redirect:myMusic.do");
        	}
        }
		
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        ModelAndView mv =  new ModelAndView();
        User user = new User();
        user.setName(username);
        user.setPassword(password);
        if(username == null || password==null) {
        	
        	return new ModelAndView("systemManagement/Login/login");
        }
        
        User sysUser = userService.findUserByPwd(user);
        if(sysUser != null){
        	if(sysUser.getIsAdmin()==1){
        		mv.setViewName("redirect:mainFrame.do");
        	}else{
        		mv.setViewName("redirect:myMusic.do");
        	}
        	session.setAttribute(Constant.LOGIN_SYSTEM_USER, sysUser);
            int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
    		session.setAttribute("hour", hour);
        }else {
			mv.setViewName("systemManagement/Login/login");
		}
        return mv;    
    } 
	
	@RequestMapping("/mainFrame")
	public ModelAndView mainFrame(HttpServletRequest request, 
			HttpServletResponse response){
		
		HttpSession session = request.getSession();
		User systemUser = (User)session.getAttribute(Constant.LOGIN_SYSTEM_USER);
		
		if(systemUser == null){
		    return new ModelAndView("redirect:login");
		}
		return new ModelAndView("systemManagement/MainFrame/productFrame");
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request,
			HttpServletResponse response){
		HttpSession session = request.getSession();
		session.removeAttribute(Constant.LOGIN_SYSTEM_USER);
		return new ModelAndView("systemManagement/Login/login");
	}
	
	@RequestMapping("/myMusic")
	public String myMusic(HttpServletRequest request, Model model){
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute(Constant.LOGIN_SYSTEM_USER);
		if(user == null){
		    return "redirect:login";
		}
		List<Playlist>playlists = playlistService.findByUserId(user.getId());
		
		for (Playlist playlist : playlists) {
//			if(playlist.getTitle().equals(Constant.I_LIKE_MUSIC)){
			List<PlaylistToSongs> plSongs = playlistToSongsService.findByPid(playlist.getId());
			if(plSongs.size() == 0) {
				playlist.setSongnum(0);
			}else {
				playlist.setSongnum(plSongs.size());
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
			model.addAttribute("playlist", playlist);//登录后，随机展示一个歌单
			break;
//			}
		}
		model.addAttribute("plTotal", playlists.size());
		model.addAttribute("playlists", playlists);
		
		return "front/MyMusic/myMusic";
	}
	
	
}
