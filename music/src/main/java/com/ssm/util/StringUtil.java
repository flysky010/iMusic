package com.ssm.util;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class StringUtil {

	public static int Guid=100;
	
	private static AtomicInteger counter = new AtomicInteger(0);
	/**
	 * @param src 分割前原字符串
	 * @param dst 0-歌手名；1-歌曲名
	 */
	public static List<String> SplitMP3File(String src){
		if(src.isEmpty()){
			return null;
		}
		String[] file = src.split("-");
		return Arrays.asList(file);
	}
	
	public static String GetFilenameWithoutSuffix(String filename) {
		String name = filename.substring(0,filename .lastIndexOf("."));//获取除后缀1位的名称
		return name;
	}
	
	/**
	 * @param src 分割前完整路径的文件名
	 */
	public static String SubFilename(String src){
		if(src.isEmpty()){
			return null;
		}
		int pos = src.indexOf("upload/");
		String tmp = src.substring(pos+7);
		return tmp;
	}
	
	public static String getUUID() {   
        return UUID.randomUUID().toString().replace("-", "");  
    }  
	
	/**
	 * 20位末尾的数字id
	 */
	public static String getGuid() {
		
		Guid+=1;

		long now = System.currentTimeMillis();  
		//获取4位年份数字  
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy");  
		//获取时间戳  
		String time=dateFormat.format(now);
		String info=now+"";
		//获取三位随机数  
		//int ran=(int) ((Math.random()*9+1)*100); 
		//要是一段时间内的数据连过大会有重复的情况，所以做以下修改
		int ran=0;
		if(Guid>999){
			Guid=100;    	
		}
		ran=Guid;
				
		return time+info.substring(2, info.length())+ran;  
	}
	
	public static long getAtomicCounter() {
        if (counter.get() > 999999) {
            counter.set(1);
        }
        long time = System.currentTimeMillis();
        long returnValue = time * 100 + counter.incrementAndGet();
        return returnValue;
    }

    private static long incrementAndGet() {
        return counter.incrementAndGet();
    }
    
    public static List<String> splitSongName(String src){
    	String [] dst = src.split("-");
    	if(dst.length > 0) {
    		return Arrays.asList(dst);
    	}
    	return null;
    }

}
