package com.demo;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestHandlerAction {
	
	@RequestMapping("/web/json.dd")
	public void test(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String result = "callback({\"name\":\"zhangsan\", \"date\": \"2017-05-10\"})";
		response.flushBuffer();
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=UTF-8");
		out.print(result);
		out.flush();
//		ServletUtils.print(response, result);
		
	}
	@RequestMapping("/web1/json.dd")
	public void test1(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String callback = (String)request.getParameter("jsoncallback");
		String result = callback + "({\"name\":\"zhangsan\", \"date\": \"2017-05-10\"})";
		response.flushBuffer();	
		PrintWriter out = response.getWriter();
		response.setContentType("application/json;charset=UTF-8");
		out.print(result);
		out.flush();
//		ServletUtils.print(response, result);
		
	}
}
