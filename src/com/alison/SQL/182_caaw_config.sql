/*配置更新*/
/*整机条款负责人 点击弹框选择人员*/
update ws_dataitem t
   set t.onclick = 'reportSingleSelectLists(this,''150001'',''v_ws_user'',''选择子系统负责人'',''single'',''singleReport'',''user_realname,dept_name,user_duty'',''姓名,部门,职务'',''user_name'',''string_2912-user_realname,string_2910-user_id'', ''100'',20,'''', '''', ''user_id'','''', '''', '''', '''');'
 where t.dataitem_id = 2912;

/*子系统定义中的子系统负责人id设为列表隐藏列*/
update ws_dataitem t set t.list_hidden='listHidden' where t.dataitem_id=2682;

/*子系统列表按照排序字段排序*/
update ws_rep_table t set t.common_orderby='caaw602_TDD_2692' where t.rep_table_id=564;

/*添加模块：子系统文件状态和子系统符合性检查清单  
  待配置：两个模块的具体权限
*/
insert into ws_module (ID, MODULE_ID, ORG_CODE, PARENT_MODULE_ID, MODULE_TYPE, MODULE_URL, MODULE_NAME, MODULE_PARAM, MODULE_EXPANDED, COMMON_ORDERBY, COMMON_REMARK, COMMON_AUTHOR_ID, COMMON_AUTHOR_NAME, COMMON_CREATE_TIME, COMMON_MODIFYER_NAME, COMMON_MODIFIER_ID, COMMON_MODIFY_TIME, COMMON_DISPLAY, COMMON_EXTEND_1, COMMON_EXTEND_2, COMMON_DATA_SCOPE_ID, COMMON_RECORD_STATUS, COMMON_YEAR_ON, COMMON_MONTH_ON, VIEW_ID, TABLE_ID, CHILDRENTREE_CLASS, CHILDRENTREE_METHOD, CHILDRENTREE_PARAM1, CHILDRENTREE_PARAM2, CHILDRENTREE_PARAM3, MODULE_OPEN_TYPE, MODULE_ICON, OTHER_PARAM, MODULE_NAME_ENG)
values (823, '1666', '000', '100029', 1, 'singlereportext/list.dd', '适航审定计划-子系统文件状态表', '', 'false', '0072', '', '', '', '', '', '', '2016-10-04 17:09:59', 0, '', '', 0, 0, '', '', '', '', '', '', '', '', '', 0, '', '', '');

insert into ws_module (ID, MODULE_ID, ORG_CODE, PARENT_MODULE_ID, MODULE_TYPE, MODULE_URL, MODULE_NAME, MODULE_PARAM, MODULE_EXPANDED, COMMON_ORDERBY, COMMON_REMARK, COMMON_AUTHOR_ID, COMMON_AUTHOR_NAME, COMMON_CREATE_TIME, COMMON_MODIFYER_NAME, COMMON_MODIFIER_ID, COMMON_MODIFY_TIME, COMMON_DISPLAY, COMMON_EXTEND_1, COMMON_EXTEND_2, COMMON_DATA_SCOPE_ID, COMMON_RECORD_STATUS, COMMON_YEAR_ON, COMMON_MONTH_ON, VIEW_ID, TABLE_ID, CHILDRENTREE_CLASS, CHILDRENTREE_METHOD, CHILDRENTREE_PARAM1, CHILDRENTREE_PARAM2, CHILDRENTREE_PARAM3, MODULE_OPEN_TYPE, MODULE_ICON, OTHER_PARAM, MODULE_NAME_ENG)
values (843, '98989', '000', '100029', 1, 'caaw/caaw_configurable_treetable/viewTreeTable.dd', '适航审定计划-子系统符合性检查清单', '', 'false', '0073', '', '', '', '', '', '', '2016-10-07 10:27:43', 0, '', '', 0, 0, '', '', '', '', '', '', '', '', '', 0, '', '', '');

/*隐掉子系统基本信息表的型号资料批准表按钮(已配置到xml中)*/
update ws_template t set t.dis=1 where t.dataitem_id=3286;

/*试验项目清单 数据项点击事件*/
/*Mc方法下拉列表*/
update ws_dataitem t set t.onclick='showEnumByTableValue(this,''ws_report_input_desc_526'',''d2592'')',t.onblur='hideEnum(this);' where t.dataitem_id=2710;
/*适航负责人*/
update ws_dataitem t set t.onclick='reportSingleSelectLists(this,''2022'',''v_ws_user'',''选择适航负责人'',''single'',''singleReport'',''user_realname,dept_name,user_duty'',''姓名,部门,职务'',''user_name'',''string_2706-user_realname'', ''100'',20,'''', '''',''user_id'','''', '''', '''', '''');' where t.dataitem_id=2706;
/*试验名称*/
update ws_dataitem t set t.onclick='reportSingleSelectLists(this,''2022'', ''WS_REPORT_INPUT_DESC_666'', ''选择试验列表'', ''single'', ''singleReport'', ''d3476'',''试验名称'',''common_orderby'',''string_2704-d3476'',''100'', ''20'');' where t.dataitem_id=2704;
/*是否审定试飞*/
update ws_dataitem t set t.onclick='showEnum(this,142);',t.onblur='hideEnum(this);' where t.dataitem_id=2708;
/*文件清单 数据项点击事件*/
/*适航负责人*/
update ws_dataitem t set t.onclick='reportSingleSelectLists(this,''2021'',''v_ws_user'',''选择适航负责人'',''single'',''singleReport'',''user_realname,dept_name,user_duty'',''姓名,部门,职务'',''user_name'',''string_1344-user_realname,string_1342-user_id'', ''100'',20,'''', '''', ''user_id'','''', '''', '''', '''');' where t.dataitem_id=1344;
/*文件名称*/
update ws_dataitem t set t.onclick='reportSingleSelectLists(this,''2021'', ''WS_REPORT_INPUT_DESC_664'', ''选择文件列表'', ''single'', ''singleReport'', ''d3472'',''文件名称'',''common_orderby'',''string_1338-d3472'',''100'', ''20'');' where t.dataitem_id=1338;

/*更新当前库脚本编号*/
 update ws_sys set par_value='182', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
commit;
