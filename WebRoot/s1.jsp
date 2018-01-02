<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 's1.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
		<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet"  type="text/css" href="uploadStream/css/stream-v1.css"/>
  </head>
  
  <body>
  	<div style="min-height: 900px; position:absolute; top: auto; left: 60px;">
  	<div id="i_select_files">
	</div>

	<div id="i_stream_files_queue">
	</div>
	<button onclick="javascript:_t.upload();">开始上传</button>|<button onclick="javascript:_t.stop();">停止上传</button>|<button onclick="javascript:_t.cancel();">取消</button>
	|<button onclick="javascript:_t.disable();">禁用文件选择</button>|<button onclick="javascript:_t.enable();">启用文件选择</button>
	|<button onclick="javascript:_t.hideBrowseBlock();">隐藏文件选择按钮</button>|<button onclick="javascript:_t.showBrowseBlock();">显示文件选择按钮</button>
	<br>
	Messages:
	<div id="i_stream_message_container" class="stream-main-upload-box" style="overflow: auto;height:200px;">
	</div>
	<br>
	</div>
	
	
	<script type="text/javascript" src="uploadStream/js/stream-v1.js"></script>
	<script type="text/javascript">
	/**
	 * 配置文件（如果没有默认字样，说明默认值就是注释下的值）
	 * 但是，on*（onSelect， onMaxSizeExceed...）等函数的默认行为
	 * 是在ID为i_stream_message_container的页面元素中写日志
	 */
		var config = {
			multipleFiles: false /** 多个文件一起上传, 默认: false */
		};
		var _t = new Stream(config);
	</script>
  </body>
</html>
