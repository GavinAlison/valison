/*���ø���*/
/*����������� �������ѡ����Ա*/
update ws_dataitem t
   set t.onclick = 'reportSingleSelectLists(this,''150001'',''v_ws_user'',''ѡ����ϵͳ������'',''single'',''singleReport'',''user_realname,dept_name,user_duty'',''����,����,ְ��'',''user_name'',''string_2912-user_realname,string_2910-user_id'', ''100'',20,'''', '''', ''user_id'','''', '''', '''', '''');'
 where t.dataitem_id = 2912;

/*��ϵͳ�����е���ϵͳ������id��Ϊ�б�������*/
update ws_dataitem t set t.list_hidden='listHidden' where t.dataitem_id=2682;

/*��ϵͳ�б��������ֶ�����*/
update ws_rep_table t set t.common_orderby='caaw602_TDD_2692' where t.rep_table_id=564;

/*���ģ�飺��ϵͳ�ļ�״̬����ϵͳ�����Լ���嵥  
  �����ã�����ģ��ľ���Ȩ��
*/
insert into ws_module (ID, MODULE_ID, ORG_CODE, PARENT_MODULE_ID, MODULE_TYPE, MODULE_URL, MODULE_NAME, MODULE_PARAM, MODULE_EXPANDED, COMMON_ORDERBY, COMMON_REMARK, COMMON_AUTHOR_ID, COMMON_AUTHOR_NAME, COMMON_CREATE_TIME, COMMON_MODIFYER_NAME, COMMON_MODIFIER_ID, COMMON_MODIFY_TIME, COMMON_DISPLAY, COMMON_EXTEND_1, COMMON_EXTEND_2, COMMON_DATA_SCOPE_ID, COMMON_RECORD_STATUS, COMMON_YEAR_ON, COMMON_MONTH_ON, VIEW_ID, TABLE_ID, CHILDRENTREE_CLASS, CHILDRENTREE_METHOD, CHILDRENTREE_PARAM1, CHILDRENTREE_PARAM2, CHILDRENTREE_PARAM3, MODULE_OPEN_TYPE, MODULE_ICON, OTHER_PARAM, MODULE_NAME_ENG)
values (823, '1666', '000', '100029', 1, 'singlereportext/list.dd', '�ʺ��󶨼ƻ�-��ϵͳ�ļ�״̬��', '', 'false', '0072', '', '', '', '', '', '', '2016-10-04 17:09:59', 0, '', '', 0, 0, '', '', '', '', '', '', '', '', '', 0, '', '', '');

insert into ws_module (ID, MODULE_ID, ORG_CODE, PARENT_MODULE_ID, MODULE_TYPE, MODULE_URL, MODULE_NAME, MODULE_PARAM, MODULE_EXPANDED, COMMON_ORDERBY, COMMON_REMARK, COMMON_AUTHOR_ID, COMMON_AUTHOR_NAME, COMMON_CREATE_TIME, COMMON_MODIFYER_NAME, COMMON_MODIFIER_ID, COMMON_MODIFY_TIME, COMMON_DISPLAY, COMMON_EXTEND_1, COMMON_EXTEND_2, COMMON_DATA_SCOPE_ID, COMMON_RECORD_STATUS, COMMON_YEAR_ON, COMMON_MONTH_ON, VIEW_ID, TABLE_ID, CHILDRENTREE_CLASS, CHILDRENTREE_METHOD, CHILDRENTREE_PARAM1, CHILDRENTREE_PARAM2, CHILDRENTREE_PARAM3, MODULE_OPEN_TYPE, MODULE_ICON, OTHER_PARAM, MODULE_NAME_ENG)
values (843, '98989', '000', '100029', 1, 'caaw/caaw_configurable_treetable/viewTreeTable.dd', '�ʺ��󶨼ƻ�-��ϵͳ�����Լ���嵥', '', 'false', '0073', '', '', '', '', '', '', '2016-10-07 10:27:43', 0, '', '', 0, 0, '', '', '', '', '', '', '', '', '', 0, '', '', '');

/*������ϵͳ������Ϣ����ͺ�������׼��ť(�����õ�xml��)*/
update ws_template t set t.dis=1 where t.dataitem_id=3286;

/*������Ŀ�嵥 ���������¼�*/
/*Mc���������б�*/
update ws_dataitem t set t.onclick='showEnumByTableValue(this,''ws_report_input_desc_526'',''d2592'')',t.onblur='hideEnum(this);' where t.dataitem_id=2710;
/*�ʺ�������*/
update ws_dataitem t set t.onclick='reportSingleSelectLists(this,''2022'',''v_ws_user'',''ѡ���ʺ�������'',''single'',''singleReport'',''user_realname,dept_name,user_duty'',''����,����,ְ��'',''user_name'',''string_2706-user_realname'', ''100'',20,'''', '''',''user_id'','''', '''', '''', '''');' where t.dataitem_id=2706;
/*��������*/
update ws_dataitem t set t.onclick='reportSingleSelectLists(this,''2022'', ''WS_REPORT_INPUT_DESC_666'', ''ѡ�������б�'', ''single'', ''singleReport'', ''d3476'',''��������'',''common_orderby'',''string_2704-d3476'',''100'', ''20'');' where t.dataitem_id=2704;
/*�Ƿ����Է�*/
update ws_dataitem t set t.onclick='showEnum(this,142);',t.onblur='hideEnum(this);' where t.dataitem_id=2708;
/*�ļ��嵥 ���������¼�*/
/*�ʺ�������*/
update ws_dataitem t set t.onclick='reportSingleSelectLists(this,''2021'',''v_ws_user'',''ѡ���ʺ�������'',''single'',''singleReport'',''user_realname,dept_name,user_duty'',''����,����,ְ��'',''user_name'',''string_1344-user_realname,string_1342-user_id'', ''100'',20,'''', '''', ''user_id'','''', '''', '''', '''');' where t.dataitem_id=1344;
/*�ļ�����*/
update ws_dataitem t set t.onclick='reportSingleSelectLists(this,''2021'', ''WS_REPORT_INPUT_DESC_664'', ''ѡ���ļ��б�'', ''single'', ''singleReport'', ''d3472'',''�ļ�����'',''common_orderby'',''string_1338-d3472'',''100'', ''20'');' where t.dataitem_id=1338;

/*���µ�ǰ��ű����*/
 update ws_sys set par_value='182', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
commit;
