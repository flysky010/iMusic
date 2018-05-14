package com.ssm.controller.user;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;    
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;    
import org.springframework.ui.Model;    
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.ssm.config.constant.Constant;
import com.ssm.dto.basedata.Basedata;
import com.ssm.dto.user.User;
import com.ssm.service.user.IUserService;

    
@Controller    
@RequestMapping("/user")    
public class UserController {    
    @Resource    
    private IUserService userService;    
        
    @RequestMapping("/userList")    
    public String userList(HttpServletRequest request,Model model){    
        String num = request.getParameter("num");
		int pageNo = 1;
		if(num != null && !num.isEmpty()) {
			pageNo = Integer.parseInt(num);  
			if(pageNo == 0){
				pageNo = 1;
			}
		}
		int pageSize = Constant.SINGLE_PAGE_OF_USER;  
	    PageHelper.startPage(pageNo, pageSize);  //startPage是告诉拦截器说我要开始分页了
	    List<User> uList = userService.getAllUser(); 
        if(uList.size() == 0 && pageNo > 0){
	    	pageNo--;
	    	PageHelper.startPage(pageNo, pageSize);  //startPage是告诉拦截器说我要开始分页了
	    	uList = userService.getAllUser();
	    }
        int count = userService.queryCount();
	    int pages = count/Constant.SINGLE_PAGE_OF_USER;
		if(count % Constant.SINGLE_PAGE_OF_USER != 0){
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
        model.addAttribute("uList", uList);    
        return "systemManagement/User/userInfoList";    
    }    
        
    @RequestMapping("/userEdit")    
    public String toUserEdit(HttpServletRequest request,Model model){    
        int userId = Integer.parseInt(request.getParameter("id"));    
        User user = userService.getUserById(userId);    
        model.addAttribute("user", user);    
        return "systemManagement/User/userEdit";    
    }
    
    @RequestMapping("/updateUserInfo")    
    public String userEdit(HttpServletRequest request,Model model,User user){  
    	userService.updateByPrimaryKey(user);
    	return "redirect:/user/userList";   
    }
    
    @RequestMapping("/userDelete")    
    public String userDelete(HttpServletRequest request,Model model){  
    	int userId = Integer.parseInt(request.getParameter("id"));    
        userService.deleteByPrimaryKey(userId);            
        return "redirect:/user/userList";     
    }
    
    @RequestMapping("/toUserAdd")
    public String toUserAdd(HttpServletRequest request,Model model){
    	return "systemManagement/User/userAdd";
    }
    
    @RequestMapping("/addUser")
    public String addUser(HttpServletRequest request,Model model, User user){
    	userService.addUser(user);    
        return "redirect:/user/userList";
    }
    
    @RequestMapping("/toUserQuery")
    public String toUserQuery(HttpServletRequest request, Model model){
    	String username = request.getParameter("username");
    	List<User> uList = userService.getUserByUsername(username);    
        model.addAttribute("uList", uList);    
        return "systemManagement/User/userInfoList";
    }
    
    @RequestMapping("/toUpdateUserInfo")
    public String toUpdateUserInfo(HttpServletRequest request, Model model) {
    	HttpSession session = request.getSession();
		User user = (User)session.getAttribute(Constant.LOGIN_SYSTEM_USER);
		if(user == null){
		    return "redirect:/login";
		}
		model.addAttribute("user", user);
    	return "front/UserInfo/userInfoEdit";
    }
    
    @RequestMapping("/updateUserInfoOfFront")
    public @ResponseBody String updateUserInfo(@RequestParam("files") MultipartFile[] files,
    		@RequestParam("uid")Integer uid,
    		@RequestParam("image")String image,
    		@RequestParam("username")String username,
    		HttpServletRequest request) {
    	User user = userService.getUserById(uid);
    	user.setName(username);
    	String path = "";
    	if(!image.isEmpty() && (files.length==0)) {
    		path = image;
    	}else {
    		String newFilename = files[0].getOriginalFilename();
            String filePath = request.getSession().getServletContext().getRealPath(Constant.PATH_OF_IMAGE) + "/" + newFilename;  
            // 转存文件  
            try {
    			files[0].transferTo(new File(filePath));
    		} catch (IllegalStateException e) {
    			e.printStackTrace();
    			return "false";
    		} catch (IOException e) {
    			e.printStackTrace();
    			return "false";
    		}
            path = Constant.PATH_OF_IMAGE+"/"+newFilename;
    	}
    	user.setPic(path);
    	userService.updateByPrimaryKey(user);
    	
    	return "success";
    }
}    