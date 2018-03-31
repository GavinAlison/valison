﻿<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%--<%@ include file="/page/common/taglibs.jsp"%>,com.avicinfo.pms.common.config.ConstantPms--%>
<%--	request.setAttribute("LineStatus_Readonly", ConstantPms.LineStatus.Readonly);--%>
<%--	request.setAttribute("LineStatus_Writable", ConstantPms.LineStatus.Writable);--%>
<%--	request.setAttribute("LineStatus_Lock", ConstantPms.LineStatus.Lock);--%>
<%
	request.setAttribute("LineStatus_Readonly", "0");
	request.setAttribute("LineStatus_Writable", "1");
	request.setAttribute("LineStatus_Lock", "2");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>工艺路线表列表</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
<%--		<%@ include file="/page/common/scripts.jsp"%>--%>
		<c:set var="orgcodedept"><avic:SystemProperty key="system.process.logic"/></c:set> 
	</head>
	
	<body>
		<form id="theForm" action="" method="POST">
			<input type="hidden" id="id" name="id" value="" />
			<input type="hidden" id="moduleid" name="moduleid" value="${pms_schedule_lineListObject.moduleid}" />
			<input type="hidden" id="meth" name="meth" value="${pms_schedule_lineListObject.meth}" />
			<input type="hidden" id="item_rec_id" name="item_rec_id" value="" />
			<input type="submit" id="submitButton" value="Submit" style="display:none;" />
			<table cellspacing="3" width="100%">
				<tr>
					<td>
						<table id="searchTr" width='100%' border='0' cellpadding='2' cellspacing='0' class='panel_bg' style="border:0px;">
							<tr>
								<td>
									<table class="table_blue" cellspacing="0" cellpadding="0">
										<tr class="tr_gray">
											<td align="right">零组件代号</td>
											<td align="left" >
												<input type="text" id="item_id" name="item_id" 
													value="${pms_schedule_lineListObject.item_id}" />
											</td>
											<td align="right">零组件名称</td>
											<td align="left" >
												<input type="text" id="item_name" name="item_name" 
													value="${pms_schedule_lineListObject.item_name}" />
											</td>
											<td align="right">工艺路线版本号</td>
											<td align="left" >
												<input type="text" id="line_id" name="line_id" 
													value="${pms_schedule_lineListObject.line_id}" />
											</td>
										</tr>
										<tr class="tr_gray">
											<td align=right>产品型号：</td>
											<td align="left">
												<input type="text" id="product_id" name="product_id"
													value="${product_id}" />
											</td>
											<td align="right">工艺路线状态</td>
											<td align="left" >
												<avic:XMLDictTag id="line_status" name="line_status" 
													dictId="line_status" fileName="dic-pms" showFlag="FILTER" 
													value="${pms_schedule_lineListObject.line_status}" />
											</td>
											<td align="right">工时信息状态</td>
											<td align="left" >
												<avic:XMLDictTag id="man_hour_status" name="man_hour_status" 
													dictId="line_status" fileName="dic-pms" showFlag="FILTER" 
													value="${pms_schedule_lineListObject.man_hour_status}" />
											</td>
										</tr>
										<tr class="tr_gray" style="display: none;">
											<td align="right">材料名称</td>
											<td align="left" >
												<input type="text" id="material_name" name="material_name" 
													value="${pms_schedule_lineListObject.material_name}" />
											</td>
											<td align="right">材料牌号</td>
											<td align="left" >
												<input type="text" id="material_number" name="material_number" 
													value="${pms_schedule_lineListObject.material_number}" />
											</td>
											<td align="right">材料规格</td>
											<td align="left" >
												<input type="text" id="material_spec" name="material_spec" 
													value="${pms_schedule_lineListObject.material_spec}" />
											</td>
											<td align="right">材料技术条件</td>
											<td align="left" >
												<input type="text" id="material_status" name="material_status"
													value="${pms_schedule_lineListObject.material_status}" />
											</td>
										</tr>
										<tr class="tr_gray" ${ctlUseDept}>
											<td align="right">使用车间</td>
											<td align="left" colspan="5">
												<input type="text" id="use_dept_name" name="use_dept_name" 
													value="${pms_schedule_lineListObject.use_dept_name}" />
											</td>
										</tr>
										<tr class="tr_gray">
											<td colspan="6" align="center">
												<input class="button" type="button" onclick="search()" value="查询" />&nbsp;&nbsp;
												<input class="button" type="button" onclick="showall()" value="显示全部" />
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td>
						<table width="100%" border="0" cellspacing="1" class="table_list">
							<tr>
								<td class="td_field">选择</td>
								<td class="td_field">物料代号</td>
								<td class="td_field">物料名称</td>
								<td class="td_field">物料编码</td>
								<td class="td_field">技术状态</td>
								<td class="td_field">工艺路线版本号</td>
								<td class="td_field">工艺路线状态</td>
								<td class="td_field">工时信息状态</td>
								<td class="td_field" ${ctlUseDept}>使用车间</td>
								<td class="td_field">材料名称</td>
								<td class="td_field">材料牌号</td>
								<td class="td_field">材料规格</td>
								<td class="td_field">材料技术条件</td>
								<td class="td_field">创建人</td>
								<td class="td_field">创建时间</td>
								<td class="td_field">修改人</td>
								<td class="td_field">修改时间</td>
							</tr>
							<logic:iterate id="it" name="pms_schedule_lineListObject"
								property="formList" indexId="i">
							<tr>
								<td class="td_content content_a" nowrap>
									<c:if test="${empty pms_schedule_lineListObject.meth}">
										<avic:authshow auth="creating,modifying">
										<input type="checkbox" name="checked" title="选中删除" value="${it.id}" deletable="${it.deletable}" />
										</avic:authshow>
										<a href="javascript:view_schedule('${it.id}', '查看工序详情')">工序详情</a>&nbsp;&nbsp;
										<a href="javascript:view('${it.id}')">${pms_schedule_lineListObject.rowCount*(pms_schedule_lineListObject.current-1)+i+1}</a>
									</c:if>
									<c:if test="${pms_schedule_lineListObject.meth=='hour'}">
										<avic:authshow auth="creating,modifying">
										<a href="javascript:view_schedule('${it.id}', '工时登记')">工时登记</a>
										</avic:authshow>
										<avic:authhidden auth="creating,modifying">
										${pms_schedule_lineListObject.rowCount*(pms_schedule_lineListObject.current-1)+i+1}
										</avic:authhidden>
									</c:if>
								</td>
								<td class="td_content" nowrap>
									<avic:substr srcstr="${it.item_id}" subnum="20" />
								</td>
								<td class="td_content" nowrap>
									<avic:substr srcstr="${it.item_name}" subnum="20" />
								</td>
								<td class="td_content" nowrap>
									<avic:substr srcstr="${it.item_code}" subnum="20" />
								</td>
								<td class="td_content" nowrap>
									<avic:substr srcstr="${it.develop_status}" subnum="20" />
								</td>
								<td class="td_content" nowrap>
									<avic:substr srcstr="${it.line_id}" subnum="20" />
								</td>
								<td class="td_content" nowrap>
									<avic:XMLDictTag id="line_statusShow" name="line_statusShow"
										dictId="line_status" fileName="dic-pms" showFlag="VIEW"
										value="${it.line_status}" />
								</td>
								<td class="td_content" nowrap>
									<avic:XMLDictTag id="man_hour_statusShow" name="man_hour_statusShow"
										dictId="line_status" fileName="dic-pms" showFlag="VIEW"
										value="${it.man_hour_status}" />
								</td>
								<td class="td_content" nowrap ${ctlUseDept}>
									<avic:substr srcstr="${it.use_dept_name}" subnum="20" />
								</td>
								<td class="td_content" nowrap>
									<avic:substr srcstr="${it.material_name}" subnum="20" />
								</td>
								<td class="td_content" nowrap>
									<avic:substr srcstr="${it.material_number}" subnum="20" />
								</td>
								<td class="td_content" nowrap>
									<avic:substr srcstr="${it.material_spec}" subnum="20" />
								</td>
								<td class="td_content" nowrap>
									<avic:substr srcstr="${it.material_status}" subnum="20" />
								</td>
								<td class="td_content" nowrap>
									<avic:substr srcstr="${it.authorName}" subnum="20" />
								</td>
								<td class="td_content" nowrap>
									<fmt:formatDate value="${it.authorTime}" pattern="yyyy-MM-dd HH:mm:ss" />
								</td>
								<td class="td_content" nowrap>
									<avic:substr srcstr="${it.modifyerName}" subnum="20" />
								</td>
								<td class="td_content" nowrap>
									<fmt:formatDate value="${it.modifyTime}" pattern="yyyy-MM-dd HH:mm:ss" />
								</td>
							</tr>
							</logic:iterate>
						</table>
					</td>
				</tr>
				<tr>
					<td>
						<avic:paging showcount="5" listObject="pms_schedule_lineListObject" />
					</td>
				</tr>
			</table>
			<script type="text/javascript">
			function b_click(){
				alert(result.name);
			} 
			</script>
		<button id="asd" type="button" onclick="b_click();">11111</button>
		</form>
	</body>
</html>
<script type="text/javascript">
<logic:notEmpty name="message">
window.parent.Ext.Msg.show({
	title: "${message.title}",
	msg: "${message.msg}",
	buttons: Ext.Msg.OK,
	icon: "ext-mb-${message.id}",
	fn: function(btn){
		eval("${message.callback}");
	}
});
function statusSuccess(ids){
	url = "${appPath}pms_schedule_line/notice.dd?moduleid=${pms_schedule_lineListObject.moduleid}&ids="+ids;
	window.open(url, "_blank", "width=800,height=525,scrollbars=yes");
}
</logic:notEmpty>

Ext.onReady(function(){
	var tbar = [];
	<c:if test="${empty pms_schedule_lineListObject.meth}">
	<avic:authshow auth="creating,modifying">
	tbar.push("-", {
		text: "新建",
		iconCls: "btn-add",
		handler: function() {
			create();
		}
	}, "-", {
		text: "删除",
		iconCls: "btn-delete",
		handler: function() {
			del();
		}
	});
	tbar.push("-",{
		text: "生效",
		iconCls: "btn-unlockTask",
		handler: function(){
			changeStatus('R');
		}
	},"-",{
		text: "置编辑",
		iconCls: "btn-flow-design",
		handler: function(){
			changeStatus('W');
		}
	},"-",{
		text: "冻结",
		iconCls: "btn-lockTask",
		handler: function(){
			changeStatus('L');
		}
	});
	</avic:authshow>
	<avic:authshow auth="exporting">
	tbar.push("-", {
		text: "导出",
		iconCls: "btn-xls",
		handler: function() {
			exportExcel();
		}
	});
	</avic:authshow>
	</c:if>
	tbar.push("-", {
		text: "查询面板",
		iconCls: "btn-search",
		handler: function() {
			filter();
		}
	});
	new Ext.Viewport({
		layout: "border",
		items: [{
			region: "center",
			autoScroll: true,
			tbar: tbar,
			contentEl: "theForm"
		}]
	});
	v = new avicinfo.form.Validation({form: "theForm"});
	v.custom = function(){ return true; }
	initSelect();
	jQuery("#searchTr").hide();
});
function initSelect(){
<%--	cb_use_dept = new Ext.form.ComboBox({--%>
<%--		store: new Ext.data.JsonStore({--%>
<%--			url: "${appPath}manage/organization/deptJson.dd",--%>
<%--			autoLoad: true,--%>
<%--			fields: ["id", "text", "value"],--%>
<%--			baseParams: {node : "node_1"}--%>
<%--		}),--%>
<%--		applyTo: "use_dept_name",--%>
<%--		fieldLabel: "使用车间",--%>
<%--		valueField: "text",--%>
<%--		displayField: "text",--%>
<%--		typeAhead: false,--%>
<%--		mode: "local",--%>
<%--		triggerAction: "all",--%>
<%--		editable: false--%>
<%--	});--%>
}

function create(){
	var url = "${appPath}pms_schedule_line/preadd.dd?moduleid=${pms_schedule_lineListObject.moduleid}";
	var checked = jQuery(".content_a input:checked").first().val()
	if(checked) url += "&checked=" + checked;
	window.createFullScreenWindow(url);
}
function view(id){
	var url = "${appPath}pms_schedule_line/view.dd?moduleid=${pms_schedule_lineListObject.moduleid}";
	url += "&id=" + id;
	window.createFullScreenWindow(url);
}
function view_schedule(id, title){
	window.openChildWin("${app}pms_schedule_step/list.dd?moduleid=${pms_schedule_lineListObject.moduleid}&meth=${pms_schedule_lineListObject.meth}&line_rec_id="+id, title);
}
function locationSearch() {
	$("id").value = "" ;
	$("theForm").action = "${appPath}pms_schedule_line/list.dd";
	$("theForm").target = "_self";
	$("submitButton").click(); 
}

//分页
function pagenum(currents) {
	if(currents==""){
		currents = 1;
	}
	$("current").value = currents;
	locationSearch();
}
//分页
function filterPage(currents){
	var evt = window.event || arguments.callee.caller.arguments[0]; 
	if(evt.keyCode==13){
		pagenum(1);
	}
}

//显示查询面板
function filter(){
	jQuery("#searchTr").toggle();
}
//导出
function exportExcel(){
	$("theForm").action = "${appPath}pms_schedule_line/excel.dd";
	$("theForm").target = "_blank";
	$("submitButton").click();
	Ext.get("theForm").unmask();
	Ext.getBody().unmask();
}
//显示全部
function showall(){
	searchClean();
	locationSearch();
}
function searchClean(){
	$("id").value = "";
	$("item_id").value = "";
	$("item_name").value = "";
	$("line_id").value = "";
	$("line_status").value = "";
	$("material_name").value = "";
	$("material_number").value = "";
	$("material_spec").value = "";
	$("material_status").value = "";
}
//查询
function search(){
	try{
		$("current").value = "1";
	}catch(e){}
	locationSearch();
}
//根据产品型号查询
function searchByProduct(){
	product_id = $('product_id').value;
	if(product_id==""){
		alert("请输入产品型号");
		return;
	}
	searchClean();
	$('product_id').value = product_id;
	$("id").value = "" 
	$("theForm").action = "${appPath}pms_schedule_line/searchByPro.dd";
	$("theForm").target = "_self";
	$("submitButton").click(); 
}
//修改状态
function changeStatus(status){
	if(jQuery(".content_a input:checked").length==0){
		alert("请选择要修改状态的记录!");
		return;
	}
	$("line_status").value = status;
	if(confirm('确定修改所选数据记录的状态信息吗？')){
		$('theForm').action = "${appPath}pms_schedule_line/status.dd";
		$('theForm').target = "_self";
		$('submitButton').click();
	}
}
//删除
function del(){
	if(jQuery(".content_a input:checked").length==0){
		alert("请选择要删除的记录");
		return;
	}
	if(confirm("确定删除所选数据项信息及其级联信息吗？")){
		$("theForm").action = "${appPath}pms_schedule_line/batchremove.dd";
		$("theForm").target = "_self";
		$("submitButton").click();
	}
} 
var result = undefined;
window.onload = function(){
	var script  =document.createElement("script");
	script.type="text/javascript";
	script.src="http://localhost:8081/cqmis615/web/json.dd";
	var head = document.getElementsByTagName("head")[0];
	head.insertBefore(script, head.firstChild); 
};
function callback(data){
		result = data;
};
Ext.onReady(function(){
	jQuery.ajax({
		async: false,
		url: "http://localhost:8081/cqmis615/web1/json.dd",
		type: "GET",
		dataType: "jsonp",
		//jsonp的值自定义,如果使用jsoncallback,那么服务器端,要返回一个jsoncallback的值对应的对象.
		jsonp: "jsoncallback",
		data: null,
		timeout: 5000,
		//返回Json类型 
		contentType: 'application/json;utf-8',
		//服务器段返回的对象包含name,data属性. 
		success: function(result){
			alert(result.date);
		},
	   	error: function (jqXHR, textStatus, errorThrown) { 
             alert(textStatus); 
        } 
		
	});
});
</script>