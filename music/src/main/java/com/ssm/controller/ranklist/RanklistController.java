package com.ssm.controller.ranklist;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;

import javax.annotation.Resource;
import javax.mail.internet.MimeUtility;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONArray;
import com.ssm.config.constant.Constant;
import com.ssm.dto.ranklist.Ranklist;
import com.ssm.dto.song.Song;
import com.ssm.service.ranklist.IRanklistService;
import com.ssm.service.ranklistToSongs.IRanklistToSongsService;
import com.ssm.service.song.ISongService;
import com.ssm.util.StringUtil;

import eu.bitwalker.useragentutils.UserAgent;

@Controller
public class RanklistController {

	@Resource
	IRanklistService ranklistService;
	
	@Resource
	IRanklistToSongsService ranklistToSongsService;
	
	@Resource
	ISongService songService;
	
	@RequestMapping("/c_ranklist")
	public String ChangeRanklist(HttpServletRequest request, Model model) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		int id = Integer.parseInt(request.getParameter("id"));
		Ranklist rk = ranklistService.findByRid(id);
		List<Song> songs = new ArrayList<Song>();
		if(id == Constant.RANKLIST_TYPE_HOT) {
			songs = songService.findTop(Constant.RANKLIST_SHOW_OF_RANKPAGE);
		}else if(id == Constant.RANKLIST_TYPE_UP) {
			boolean bNeedUpdate = false;
			songs = songService.findAll();//查找飙升榜歌曲
			for (Song song : songs) {
				Date date1 = (Date) sdf.parse(song.getLastUpdateTime());
				Date date2 = new Date();   
				int days = (int) ((date2.getTime() - date1.getTime()) / (1000*3600*24));
				if(days >= 7) {
					bNeedUpdate = true;
					break;
				}
			}
			if(bNeedUpdate) {
				for (Song song : songs) {
					long increaseNum = song.getPlayNum()-song.getLastWeekendPlayNum();
					song.setIncreaseNum(increaseNum);
					song.setLastWeekendPlayNum(song.getPlayNum());
					song.setLastUpdateTime(sdf.format(new Date()));
					songService.update(song);
				}
			}
			songs = songService.findTopOfUp(Constant.RANKLIST_SHOW_OF_RANKPAGE);//查找飙升榜歌曲
		}else if(id ==  Constant.RANKLIST_TYPE_NEW) {
			songs = songService.findTopOfNew(Constant.RANKLIST_SHOW_OF_RANKPAGE);//查找新歌榜歌曲
		}
		
		List<Ranklist> ranklists = ranklistService.findAll();
		model.addAttribute("ranklist", rk);//需要展示的某一个榜单的详细信息
		model.addAttribute("songs", songs);
		model.addAttribute("ranklists", ranklists);
		for(int i=0;i<songs.size();i++){//临时改变id的值，以后这里要改
			songs.get(i).setId(i+1);
		}
		model.addAttribute("total", songs.size());
		return "front/Ranklist/ranklist";
	}
	
	/**
     * 文件下载
	 * @throws Exception 
     */
	@RequestMapping(value = "/batchDownload")
    public String downloadFile(HttpServletRequest request,HttpServletResponse response) throws Exception {
		JSONArray arr=(JSONArray) JSONArray.parse(request.getParameter("rows"));
		List<File> files = new ArrayList<File>();
		for(int j = 0; j <arr.size();j++){
			String fileName = arr.getString(j);
			fileName = StringUtil.SubFilename(fileName);
	        if (fileName != null) {
	            String realPath = request.getSession().getServletContext().getRealPath(Constant.PATH_OF_MUSIC);
	            File file = new File(realPath, fileName);
	            if (file.exists()) {
	                files.add(file);
	            }
	        }
		}
		
		String fileName = UUID.randomUUID().toString() + ".zip";
        // 在服务器端创建打包下载的临时文件
        String outFilePath = request.getSession().getServletContext().getRealPath(Constant.PATH_OF_MUSIC)+"/";

        File fileZip = new File(outFilePath + fileName);
        // 文件输出流
        FileOutputStream outStream = new FileOutputStream(fileZip);
        // 压缩流
        ZipOutputStream toClient = new ZipOutputStream(outStream);
        toClient.setEncoding("gbk");
        zipFile(files, toClient);
        toClient.close();
        outStream.close();
        this.downloadFile(fileZip, response, true , request);
        return null;
    }
	
	private static void zipFile(List<File> files, ZipOutputStream outputStream) throws Exception {
        try {
            int size = files.size();
            // 压缩列表中的文件
            for (int i = 0; i < size; i++) {
                File file = (File) files.get(i);
                zipFile(file, outputStream);
            }
        } catch (IOException e) {
            throw e;
        }
    }
	
	private static void zipFile(File inputFile, ZipOutputStream outputstream) throws Exception {
        try {
            if (inputFile.exists()) {
                if (inputFile.isFile()) {
                    FileInputStream inStream = new FileInputStream(inputFile);
                    BufferedInputStream bInStream = new BufferedInputStream(inStream);
                    ZipEntry entry = new ZipEntry(inputFile.getName());
                    outputstream.putNextEntry(entry);

                    final int MAX_BYTE = 10 * 1024 * 1024; // 最大的流为10M
                    long streamTotal = 0; // 接受流的容量
                    int streamNum = 0; // 流需要分开的数量
                    int leaveByte = 0; // 文件剩下的字符数
                    byte[] inOutbyte; // byte数组接受文件的数据

                    streamTotal = bInStream.available(); // 通过available方法取得流的最大字符数
                    streamNum = (int) Math.floor(streamTotal / MAX_BYTE); // 取得流文件需要分开的数量
                    leaveByte = (int) streamTotal % MAX_BYTE; // 分开文件之后,剩余的数量

                    if (streamNum > 0) {
                        for (int j = 0; j < streamNum; ++j) {
                            inOutbyte = new byte[MAX_BYTE];
                            // 读入流,保存在byte数组
                            bInStream.read(inOutbyte, 0, MAX_BYTE);
                            outputstream.write(inOutbyte, 0, MAX_BYTE); // 写出流
                        }
                    }
                    // 写出剩下的流数据
                    inOutbyte = new byte[leaveByte];
                    bInStream.read(inOutbyte, 0, leaveByte);
                    outputstream.write(inOutbyte);
                    outputstream.closeEntry(); // Closes the current ZIP entry
                    // and positions the stream for
                    // writing the next entry
                    bInStream.close(); // 关闭
                    inStream.close();
                }
            } else {
                throw new Exception("文件不存在！");
            }
        } catch (IOException e) {
            throw e;
        }
    }
	
	 @SuppressWarnings("restriction")
	private void downloadFile(File file,HttpServletResponse response,boolean isDelete, HttpServletRequest request) {
         try {
             // 以流的形式下载文件。
             BufferedInputStream fis = new BufferedInputStream(new FileInputStream(file.getPath()));
             byte[] buffer = new byte[fis.available()];
             fis.read(buffer);
             fis.close();
             // 清空response
             response.reset();
             OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
             response.setContentType("application/octet-stream");
             
             //文件名编码，解决乱码问题
             String fileName = file.getName();
             String encodedFileName = null;
             String userAgentString = request.getHeader("User-Agent");
             String browser = UserAgent.parseUserAgentString(userAgentString).getBrowser().getGroup().getName();
             if(browser.equals("Chrome") || browser.equals("Internet Exploer") || browser.equals("Safari")) {
                 encodedFileName = URLEncoder.encode(fileName,"utf-8").replaceAll("\\+", "%20");
             } else {
                 encodedFileName = MimeUtility.encodeWord(fileName);
             }
             
             response.setHeader("Content-Disposition", "attachment;filename=" + encodedFileName);//new String(file.getName().getBytes("UTF-8"),"ISO-8859-1"));
             toClient.write(buffer);
             toClient.flush();
             toClient.close();
             if(isDelete)
             {
                 file.delete();        //是否将生成的服务器端文件删除
             }
          } 
          catch (IOException ex) {
             ex.printStackTrace();
         }
     } 
	
	 @RequestMapping("/updatePlayNum")
	 public String updatePlayNum(HttpServletRequest request, @RequestBody String arr, Model model){
		 JSONArray arr2=(JSONArray) JSONArray.parse(arr);
		 int rid = Integer.parseInt(arr2.getString(0));
		 int rows = ranklistService.updatePlayNum(rid);
		 return "front/Ranklist/ranklist";
	 }
}
