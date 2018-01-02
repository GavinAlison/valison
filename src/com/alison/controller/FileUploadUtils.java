package com.alison.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtils {

	public static final long DEFAULT_MAX_SIZE = 52428800l;

	public static String defaultBaseDir = "upload";

	public static String upload(HttpServletRequest request,
			MultipartFile file) throws Exception {
		String fileName = extractFilename(file, defaultBaseDir);
		File desc = getAbsoluteFile(extractUploadDir(request), fileName);
		file.transferTo(desc);
		return fileName;
		
	}
	
	private static File getAbsoluteFile(String uploadDir, String fileName) throws IOException {
		if(uploadDir.endsWith("/")){
			uploadDir = uploadDir.substring(0, uploadDir.length() -1 );
		}
		if(uploadDir.startsWith("/")){
			uploadDir = uploadDir.substring(0, uploadDir.length() -1 );
		}
		File desc = new File(uploadDir + "/" + fileName);
		if(!desc.getParentFile().exists()){
			desc.getParentFile().mkdirs();
		}
		if(!desc.exists()){
			desc.createNewFile();
		}
		return desc;
	}

	public static final String extractFilename(MultipartFile file, String baseDir) throws UnsupportedEncodingException{
		String fileName = file.getOriginalFilename();
		int slashIndex = fileName.indexOf("/");
		if(slashIndex != -1){
			fileName = fileName.substring(0, slashIndex+1);
		}
		fileName = baseDir + "/" +fileName;
		return fileName;
	}
	
	public static String extractUploadDir(HttpServletRequest request){
		return request.getSession().getServletContext().getRealPath("/");
	}
	
}
