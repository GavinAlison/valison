/*���ñ�����ģ���е����ļ��ĺ�׺����ȱʡΪ.xls*/
insert into ws_sys (PAR_NAME, COMMON_ORDERBY, COMMON_REMARK, COMMON_AUTHOR_ID, COMMON_AUTHOR_NAME, COMMON_CREATE_TIME, COMMON_MODIFYER_NAME, COMMON_MODIFIER_ID, COMMON_MODIFY_TIME, COMMON_DISPLAY, COMMON_EXTEND_1, COMMON_EXTEND_2, COMMON_DATA_SCOPE_ID, COMMON_RECORD_STATUS, COMMON_YEAR_ON, COMMON_MONTH_ON, PAR_VALUE, PAR_DESC, PAR_RW)
values ('DATA_IMP_EXT', '', '', '', '', '', '', '', '', 1, '', '', 0, 1, '', '', '.xls', '���ݵ����ļ���׺��,���ʱ�Զ�����������磺.xls,.xdb', null);
/*���µ�ǰ��ű����*/
update ws_sys set par_value='131', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
commit;

