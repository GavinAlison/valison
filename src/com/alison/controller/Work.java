package com.alison.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Work {
	@RequestMapping("/fileupload.dd")
	public ModelAndView home(){
		ModelAndView mv = new ModelAndView("com/alison/controller/page/fileupload.jsp");
		return mv;
	}
	
	
	@RequestMapping("/file/upload.dd")
	public ModelAndView upload(HttpServletRequest request, @RequestParam(value="myFile", required = false)  MultipartFile[] files ){
		System.out.println(files);
		try{
			for(int i = 0; i < files.length; i++){
				FileUploadUtils.upload(request, files[i]);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		ModelAndView mv = new ModelAndView("com/alison/controller/page/success.jsp");
		return mv;
	}
	
	
}
