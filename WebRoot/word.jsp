<%@ page language="java"
	import="java.util.*,com.zhuozhengsoft.pageoffice.*,com.zhuozhengsoft.pageoffice.wordwriter.*"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.pageoffice.cn" prefix="po"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title>测试pageoffice控件</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<link rel="stylesheet" type="text/css"
			href="uploadStream/css/stream-v1.css" />
	</head>

	<body>
<%
	//PageOfficeCtrl poCtrl = (PageOfficeCtrl)request.getAttribute("office1")
	PageOfficeCtrl poCtrl1 = new PageOfficeCtrl(request);
	poCtrl1.setServerPage("poserver.do");//此行必须
	poCtrl1.setSaveFilePage("saveFile.jsp");//如要保存文件，此行必须
	poCtrl1.addCustomToolButton("保存", "save()", 1);//添加自定义工具按钮
	//open file ,webopen()方法有三个参数，分别为：要打开的文件路径、打开模式、打开的操作人，其中文件路径即可是相对路径，也可是绝对路径
	//绝对路径
	//String filePath = request.getSession().getServletContext()
	//		.getRealPath("doc/template.doc");
	//相对路径
	String filePath = "doc/template.doc";
	poCtrl1.webOpen(filePath, OpenModeType.docNormalEdit, "liu");
	poCtrl1.setTagId("office1"); //此行必须
%>
		<div>
			<po:PageOfficeCtrl id="office1"></po:PageOfficeCtrl>
		</div>
		<script>
			function save(){
				document.getElementById("office1").WebSave();
			}
		</script>
	</body>
</html>
