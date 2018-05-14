package com.ssm.controller.basedata;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.StringUtil;
import com.ssm.config.constant.Constant;
import com.ssm.dto.basedata.Basedata;
import com.ssm.dto.playlist.Playlist;
import com.ssm.dto.user.User;
import com.ssm.service.basedata.IBasedataService;

@Controller
public class BasedataController {

	@Resource
	IBasedataService basedataService;
	
	@RequestMapping("/basedataList")    
    public String showBasedata(HttpServletRequest request,Model model){ 
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
        List<Basedata> datalist = basedataService.findAll(); 
        if(datalist.size() == 0 && pageNo > 0){
	    	pageNo--;
	    	PageHelper.startPage(pageNo, pageSize);  //startPage是告诉拦截器说我要开始分页了
	    	datalist = basedataService.findAll();
	    }
        int count = basedataService.queryCount();
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
	    model.addAttribute("listPage", listPage);
	    model.addAttribute("curNum", pageNo);
        model.addAttribute("datalist", datalist);    
        return "systemManagement/Basedata/basedataInfo";    
    } 
	
	@RequestMapping("/toBasedataQuery")
    public String toBasedataQuery(HttpServletRequest request, Model model){
    	String singer = request.getParameter("singer");
    	List<Basedata> datalist = basedataService.findByName(singer);    
        model.addAttribute("datalist", datalist);    
        return "systemManagement/Basedata/basedataInfo";
    }
	
	@RequestMapping("/basedataDelete")    
    public String basedataDelete(HttpServletRequest request,Model model){  
    	int id = Integer.parseInt(request.getParameter("id"));    
    	basedataService.deleteByPrimaryKey(id);            
        return "redirect:/basedataList";     
    }
	
	@RequestMapping("/toBasedataEdit")    
    public String toBasedataEdit(HttpServletRequest request,Model model){    
        int id = Integer.parseInt(request.getParameter("id"));    
        Basedata basedata = basedataService.findById(id);    
        model.addAttribute("basedata", basedata);    
        return "systemManagement/Basedata/basedataEdit";    
    }
	
	@RequestMapping("/updateBasedata")
	public @ResponseBody String updateBasedata(@RequestParam("singer") String singer,
			@RequestParam("albumName")String albumName, 
			@RequestParam("songName")String songName, @RequestParam("songTime")String songTime,
			@RequestParam("files") MultipartFile[] files, @RequestParam("image")String image,
			@RequestParam("bid")Integer bid,
			HttpServletRequest request){  
		try {
			Basedata basedata = basedataService.findById(bid);
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
			basedata.setSinger(singer);
			basedata.setAlbumName(albumName);
			basedata.setSongName(songName);
			basedata.setSongTime(songTime);
			basedata.setAlbumPic(path);
			basedataService.updateById(basedata);
		}catch (Exception ex) {
			return ex.getMessage();
		}
    	return "success";   
    }
	
//	@RequestMapping("/updateBasedata")
//	public String updateBasedata(HttpServletRequest request,Model model,Basedata basedata){  
//		basedataService.updateById(basedata);
//    	return "redirect:/basedataList";   
//    }
	
	@RequestMapping("/toBasedataAdd")
    public String toBasedataAdd(HttpServletRequest request,Model model){
    	return "systemManagement/Basedata/basedataAdd";
    }
	
	@RequestMapping("/addBasedata")
    public @ResponseBody String addBasedata(@RequestParam("singer") String singer,
			@RequestParam("albumName")String albumName, 
			@RequestParam("songName")String songName, @RequestParam("songTime")String songTime,
			@RequestParam("files") MultipartFile[] files, @RequestParam("image")String image,
			HttpServletRequest request){
		try {
			Basedata basedata = new Basedata();
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
	    	if(songName.indexOf("-") > -1) {
	    		List<String>songNames = com.ssm.util.StringUtil.splitSongName(songName);
	    		if(songNames != null) {
	    			for (String item : songNames) {
	    				basedata.setSinger(singer);
	    				basedata.setAlbumName(albumName);
	    				basedata.setSongName(songName);
	    				basedata.setSongTime(songTime);
	    				basedata.setAlbumPic(path);
	    				basedata.setSingerId(com.ssm.util.StringUtil.getAtomicCounter());
	    		    	basedata.setAlbumId(com.ssm.util.StringUtil.getAtomicCounter());
	    		    	basedata.setSongId(com.ssm.util.StringUtil.getAtomicCounter());
	    		    	basedata.setSongName(item);
	    		    	basedataService.add(basedata);
					}
	    		}
	    	}else {
    			basedata.setSinger(singer);
				basedata.setAlbumName(albumName);
				basedata.setSongName(songName);
				basedata.setSongTime(songTime);
				basedata.setAlbumPic(path);
    			basedata.setSingerId(com.ssm.util.StringUtil.getAtomicCounter());
    	    	basedata.setAlbumId(com.ssm.util.StringUtil.getAtomicCounter());
    	    	basedata.setSongId(com.ssm.util.StringUtil.getAtomicCounter());
    	    	basedataService.add(basedata); 
    		}
		}catch (Exception ex) {
			return ex.getMessage();
		}
        return "redirect:/basedataList";
    }
    
//    @RequestMapping("/addBasedata")
//    public String addUser(HttpServletRequest request,Model model, Basedata basedata){
//    	if(basedata.getSongName().indexOf("-") > -1) {
//    		List<String>songName = com.ssm.util.StringUtil.splitSongName(basedata.getSongName());
//    		if(songName != null) {
//    			for (String item : songName) {
//    				basedata.setSingerId(com.ssm.util.StringUtil.getAtomicCounter());
//    		    	basedata.setAlbumId(com.ssm.util.StringUtil.getAtomicCounter());
//    		    	basedata.setSongId(com.ssm.util.StringUtil.getAtomicCounter());
//    		    	basedata.setSongName(item);
//    		    	basedataService.add(basedata);
//				}
//    		}else {
//    			basedata.setSingerId(com.ssm.util.StringUtil.getAtomicCounter());
//    	    	basedata.setAlbumId(com.ssm.util.StringUtil.getAtomicCounter());
//    	    	basedata.setSongId(com.ssm.util.StringUtil.getAtomicCounter());
//    	    	basedataService.add(basedata); 
//    		}
//    	}
//        return "redirect:/basedataList";
//    }
}
