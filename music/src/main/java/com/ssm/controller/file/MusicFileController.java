package com.ssm.controller.file;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.github.pagehelper.PageHelper;
import com.ssm.config.constant.Constant;
import com.ssm.dto.basedata.Basedata;
import com.ssm.dto.song.Song;
import com.ssm.service.basedata.IBasedataService;
import com.ssm.service.file.IMusicFileService;
import com.ssm.service.playlist.IPlaylistService;
import com.ssm.service.playlisttosongs.IPlaylistToSongsService;
import com.ssm.service.song.ISongService;
import com.ssm.util.StringUtil;


@Controller    
@RequestMapping("/file") 
public class MusicFileController {

	@Resource
	private IMusicFileService fileService;
	
	@Resource
	private ISongService songService;
	
	@Resource
	private IBasedataService basedataService;
	
	@Resource
	private IPlaylistService playlistService;
	
	@Resource
	private IPlaylistToSongsService playlistToSongsService;
	
	@RequestMapping("/fileList")    
    public String fileList(HttpServletRequest request,Model model){
		String num = request.getParameter("num");
		int pageNo = 1;
		if(num != null && !num.isEmpty()) {
			pageNo = Integer.parseInt(num);  
			if(pageNo == 0){
				pageNo = 1;
			}
		}
		int pageSize = Constant.SINGLE_PAGE_OF_MUSICFILE;  
	    PageHelper.startPage(pageNo, pageSize);  //startPage是告诉拦截器说我要开始分页了
	    List<Song> songs = songService.findAll();
        if(songs.size() == 0 && pageNo > 0){
	    	pageNo--;
	    	PageHelper.startPage(pageNo, pageSize);  //startPage是告诉拦截器说我要开始分页了
	    	songs = songService.findAll();
	    }
        int count = songService.queryCount();
	    int pages = count/Constant.SINGLE_PAGE_OF_MUSICFILE;
		if(count % Constant.SINGLE_PAGE_OF_MUSICFILE != 0){
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
		model.addAttribute("songs",songs);   
        return "systemManagement/File/musicFileList";    
    }
	
	@RequestMapping("/uploadMusicFile")    
    public String uploadFile(@RequestParam("files") MultipartFile[] files,HttpServletRequest request){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//判断file数组不能为空并且长度大于0  
        if(files!=null && files.length>0){  
            //循环获取file数组中得文件  
            for(int i = 0;i<files.length;i++){  
                MultipartFile file = files[i];  
                try {
                    //获取存取路径
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
                } catch (IOException e) {
                    e.printStackTrace();
                }  
            }
             
        }
        return "redirect:/file/fileList";
    }
	
	@RequestMapping("/toFileEdit")    
    public String toFileEdit(HttpServletRequest request,Model model){    
        long fileId = Long.parseLong(request.getParameter("id"));    
        List<Song> songs = songService.querySongByBatch(Arrays.asList(fileId));// fileService.getFileById(fileId);    
        model.addAttribute("song", songs.get(0));    
        return "systemManagement/File/fileEdit";    
    }
	
	@RequestMapping("/updateFileInfo")    
    public String updateFileInfo(HttpServletRequest request,Model model,Song song){  
		songService.update(song);
    	return "redirect:/file/fileList";   
    }
	
	@RequestMapping("/fileDelete")    
    public String fileDelete(HttpServletRequest request,Model model){
		int nCount = 0;
    	long fileId = Long.parseLong(request.getParameter("id"));
//    	MusicFile music = fileService.getFileById(fileId);
    	List<Song>songs = songService.querySongByBatch(Arrays.asList(fileId));
    	String path = request.getSession().getServletContext().getRealPath(Constant.PATH_OF_MUSIC) + "/" + songs.get(0).getStitle();
    	File file = new File(path);
    	if(file.exists()){
    		file.delete();
    	}
    	nCount = songService.removeBySid(fileId);
    	nCount = playlistToSongsService.removeBySid(fileId);
//    	fileService.deleteByPrimaryKey(fileId);            
        return "redirect:/file/fileList";     
    }
	
	@RequestMapping("/toFileQuery")
    public String toUserQuery(HttpServletRequest request, Model model){
		String num = request.getParameter("num");
		int pageNo = 1;
		if(num != null && !num.isEmpty()) {
			pageNo = Integer.parseInt(num);  
			if(pageNo == 0){
				pageNo = 1;
			}
		}
    	String name = request.getParameter("filename");
    	int pageSize = Constant.SINGLE_PAGE_OF_MUSICFILE;  
	    PageHelper.startPage(pageNo, pageSize);  //startPage是告诉拦截器说我要开始分页了
    	List<Song>songs = songService.querySongByName(name); 
    	if(songs.size() == 0 && pageNo > 0){
	    	pageNo--;
	    	PageHelper.startPage(pageNo, pageSize);  //startPage是告诉拦截器说我要开始分页了
	    	songs = songService.querySongByName(name);
	    }
        int count = songService.queryCountByName(name);
	    int pages = count/Constant.SINGLE_PAGE_OF_MUSICFILE;
		if(count % Constant.SINGLE_PAGE_OF_MUSICFILE != 0){
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
        model.addAttribute("songs", songs);    
        return "systemManagement/File/musicFileList";
    }
}
