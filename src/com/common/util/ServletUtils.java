package com.common.util;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;


public abstract class ServletUtils {
	/**
	 * 中文文件名编码
	 * 
	 * @param request
	 * @param fileName
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String encodeFileName(HttpServletRequest request, String fileName) throws UnsupportedEncodingException{
		String returnName = "";
		String agent = request.getHeader("USER-AGENT");
		if(null != agent && -1 != agent.indexOf("MSIE")){
			if(agent.indexOf("7.0") != -1){//IE7
				returnName = new String(fileName.getBytes("GBK"), "ISO-8859-1");
			}else{//IE6
				returnName = URLEncoder.encode(fileName, "UTF-8");
			}
		}else if(null != agent && -1 != agent.indexOf("firefox")){ //firefox
			returnName = "?UTF-8?B" + (new String(Base64.encodeBase64(fileName.getBytes("UTF-8")))) + "?="; 
		}else if(null != agent && agent.indexOf("Chrome") != -1){ //Chrome
			returnName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
		}
		return returnName;
	}
	
	/**
	 * 输出信息
	 * 
	 * @param response
	 * @param message
	 * @throws Exception
	 */
	public static  void print(HttpServletResponse response, String message) throws Exception{
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=UTF-8");
		out.print(message);
	};
	
	
	/**
	 * 向url串中添加键值
	 * 
	 * @param url
	 * @param key
	 * @param value
	 * @return
	 */
	public static String addUrlParameter(String url, String key, String value) {
		if (!StaticMethod.isEmpty(url) && !StaticMethod.isEmpty(key)
				&& !StaticMethod.isEmpty(value)) {
			try {
				if (url.indexOf("?") == -1) {
					return url + "?" + key + "="
							+ java.net.URLEncoder.encode(value, "utf-8");

				} else {
					return url + "&" + key + "="
							+ java.net.URLEncoder.encode(value, "utf-8");
				}
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				return url;
			}
		} else {
			return url;
		}

	}
	
	
}
