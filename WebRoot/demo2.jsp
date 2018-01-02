<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'demo2.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="jquery/jquery-1.12.3.js"></script>
  </head>
  <body>
  <div align="center" style="margin-top: 30px;">
<%--  form表单上传只是简单地 实现上传的功能  --%>
<%--  希望实现组件式的与后端整合--%>
    <form id="upload-form" action="upload.dd"  method="post" enctype="multipart/form-data">
    	上传用户: <input type="text" name="name"/><br/>
    	文件1: <input type="file" name="upload" id="upload"/><br/>
		<progress id="uploadprogress" min="0" max="100" value="0">0</progress><br/>
    	<input type="submit" value="Upload" />
    </form>
    </div>
    <script>
    (function(){
    	function uploader(){
    		
    	}
    	uploader.prototype = {
    		onselect: function(){
    			alert(1);
    		}
    	}
    	var StreamUploader = document.getElementById('upload');
    	StreamUploader.selected = function(){
    		alert(1);
    	};
    })();
    
    </script>
  </body>
</html>
