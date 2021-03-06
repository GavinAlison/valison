<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="uploadStream/css/stream-v1.css"/>
  </head>
  
  <body>
	<a href="./force-form.jsp" >表单上传</a>
	<a href="./upyun-form.jsp">又拍云 - 表单上传</a>
	<div id="i_select_files"></div>
	<div id="i_stream_files_queue"></div>
	<button onclick="javascript:_t.upload();">开始上传</button>|
	<button onclick="javascript:_t.stop">停止上传</button>|
	<button onclick="javascript:_t.cancel();">取消</button>|
	<button onclick="javascript:_t.disable();">禁用文件选择</button>|
	<button onclick="javascript:_t.enable();">启用文件选择</button>|
	<button onclick="javascript:_t.hideBrowseBlock();">隐藏文件选择按钮</button>|
	<button onclick="javascript:_t.showBrowseBlock();">显示文件选择按钮</button>|
	<button onclick="javascript:_t.destroy();_t = null; _t = new Stream(config);">销毁重新生成按钮</button>
	<br />
	Messages:
	<div id="i_stream_message_container" class="stream-main-upload-box" style="overflow: auto; height: 200px;"></div>
	
	<br />
	
	<script type="text/javascript" src="uploadStream/js/stream-v1.js"></script>
	<script type="text/javascript">
/**
 * 配置文件（如果没有默认字样，说明默认值就是注释下的值）
 * 但是，on*（onSelect， onMaxSizeExceed...）等函数的默认行为
 * 是在ID为i_stream_message_container的页面元素中写日志
 */
	var config = {
		browseFileId : "i_select_files", /** 选择文件的ID, 默认: i_select_files */
		browseFileBtn : "<div>请选择文件</div>", /** 显示选择文件的样式, 默认: `<div>请选择文件</div>` */
		dragAndDropArea: "i_select_files", /** 拖拽上传区域，Id（字符类型"i_select_files"）或者DOM对象, 默认: `i_select_files` */
		dragAndDropTips: "<span>把文件(文件夹)拖拽到这里</span>", /** 拖拽提示, 默认: `<span>把文件(文件夹)拖拽到这里</span>` */
		filesQueueId : "i_stream_files_queue", /** 文件上传容器的ID, 默认: i_stream_files_queue */
		filesQueueHeight : 200, /** 文件上传容器的高度（px）, 默认: 450 */
		messagerId : "i_stream_message_container", /** 消息显示容器的ID, 默认: i_stream_message_container */
		multipleFiles: true, /** 多个文件一起上传, 默认: false */
		onRepeatedFile: function(f) {
			alert("文件："+f.name +" 大小："+f.size + " 已存在于上传队列中。");
			return false;	
		},
//		autoUploading: false, /** 选择文件后是否自动上传, 默认: true */
//		autoRemoveCompleted : true, /** 是否自动删除容器中已上传完毕的文件, 默认: false */
//		maxSize: 104857600//, /** 单个文件的最大大小，默认:2G */
//		retryCount : 5, /** HTML5上传失败的重试次数 */
//		postVarsPerFile : { /** 上传文件时传入的参数，默认: {} */
//			param1: "val1",
//			param2: "val2"
//		},
//		swfURL : "/swf/FlashUploader.swf", /** SWF文件的位置 */
		tokenURL : "tk", /** 根据文件名、大小等信息获取Token的URI（用于生成断点续传、跨域的令牌） */
//		frmUploadURL : "/fd;", /** Flash上传的URI */
//		uploadURL : "/upload", /** HTML5上传的URI */
//		simLimit: 200, /** 单次最大上传文件个数 */
//		extFilters: [".txt", ".rpm", ".rmvb", ".gz", ".rar", ".zip", ".avi", ".mkv", ".mp3"], /** 允许的文件扩展名, 默认: [] */
//		onSelect: function(list) {alert('onSelect')}, /** 选择文件后的响应事件 */
//		onMaxSizeExceed: function(size, limited, name) {alert('onMaxSizeExceed')}, /** 文件大小超出的响应事件 */
//		onFileCountExceed: function(selected, limit) {alert('onFileCountExceed')}, /** 文件数量超出的响应事件 */
//		onExtNameMismatch: function(name, filters) {alert('onExtNameMismatch')}, /** 文件的扩展名不匹配的响应事件 */
//		onCancel : function(file) {alert('Canceled:  ' + file.name)}, /** 取消上传文件的响应事件 */
//		onComplete: function(file) {alert('onComplete')}, /** 单个文件上传完毕的响应事件 */
//		onQueueComplete: function() {alert('onQueueComplete')}, /** 所以文件上传完毕的响应事件 */
//		onUploadError: function(status, msg) {alert('onUploadError')} /** 文件上传出错的响应事件 */
//		onDestroy: function() {alert('onDestroy')} /** 文件上传出错的响应事件 */
	};
	var _t = new Stream(config);
	</script>
	
	
  </body>
</html>
