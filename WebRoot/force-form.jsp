<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String app = "localhost:8080/valison/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'force-form.jsp' starting page</title>
    
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
   <p style="color: red;">由于不支持断点续传及Flash技术限制，Form表单上传请控制在2G大小以内文件。<br>（传统Flash上传文件最大2G，现代浏览器没有限制。互联网用户最好控制在100M以下）。</p>

<div id="i_select_files">
</div>

<div id="i_stream_files_queue">
</div>
<button onclick="javascript:_t.upload();">开始上传</button>
|
<button onclick="javascript:_t.stop();">停止上传</button>
|
<button onclick="javascript:_t.cancel();">取消</button>
|
<button onclick="javascript:_t.disable();">禁用文件选择</button>
|
<button onclick="javascript:_t.enable();">启用文件选择</button>
|
<button onclick="javascript:_t.hideBrowseBlock();">隐藏文件选择按钮</button>
|
<button onclick="javascript:_t.showBrowseBlock();">显示文件选择按钮</button>
<br>
Messages:
<div id="i_stream_message_container" class="stream-main-upload-box" style="overflow: auto;height:200px;">
</div>
<br>


<script type="text/javascript" src="uploadStream/js/stream-v1.js"></script>
<script type="text/javascript">
    /**
     * 配置文件（如果没有默认字样，说明默认值就是注释下的值）
     * 但是，on*（onSelect， onMaxSizeExceed...）等函数的默认行为
     * 是在ID为i_stream_message_container的页面元素中写日志
     */
    var config = {
    	tokenURL: 'tk',
        formed: true, /** 强制form表单的方式传输(此种方式不支持断点续传) */
        browseFileId: "i_select_files", /** 选择文件的ID, 默认: i_select_files */
        browseFileBtn: "<div>请选择文件</div>", /** 显示选择文件的样式, 默认: `<div>请选择文件</div>` */	
        dragAndDropArea: "i_select_files", /** 拖拽上传区域，Id（字符类型"i_select_files"）或者DOM对象, 默认: `i_select_files` */
        dragAndDropTips: "<span>把文件(文件夹)拖拽到这里</span>", /** 拖拽提示, 默认: `<span>把文件(文件夹)拖拽到这里</span>` */
        filesQueueId: "i_stream_files_queue", /** 文件上传容器的ID, 默认: i_stream_files_queue */
        filesQueueHeight: 200, /** 文件上传容器的高度（px）, 默认: 450 */
        multipleFiles: true,
        maxSize: 2 * 1024 * 1024 * 1024, /** 2G */
        messagerId: "i_stream_message_container", /** 消息显示容器的ID, 默认: i_stream_message_container */
        frmUploadURL: 'fd',
<%--        extFilters: ['.png', '.PNG', '.jpg', '.JPG', '.jpeg', '.JPEG'],--%>
    };
    var _t = new Stream(config);
</script>

  </body>
</html>
