package com.ssm.controller.song;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.dto.song.Song;
import com.ssm.service.song.ISongService;

@Controller
public class SongController {
	
	@Resource
	ISongService songService;
	
	@RequestMapping("/toSingleSong")
	public String toSingleSong(HttpServletRequest request, Model model) {
		String sid = request.getParameter("sid");
		List<Song> song = new ArrayList<>();
		if(!sid.isEmpty()) {
			song = songService.querySongByBatch(Arrays.asList(Long.parseLong(sid)));
		}
		model.addAttribute("song", song.get(0));
		model.addAttribute("songs", song);
		return "front/SingleSong/singlesong";
	}

}
