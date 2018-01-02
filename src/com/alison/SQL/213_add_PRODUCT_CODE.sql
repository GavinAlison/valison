--产品代号 PAR_VALUE 取值范围：qmis、caaw、ciis 、pms、wpms 等
--各个系统根据实际填写产品代号
insert into ws_sys (PAR_NAME, COMMON_ORDERBY, COMMON_REMARK, COMMON_AUTHOR_ID, COMMON_AUTHOR_NAME, COMMON_CREATE_TIME, COMMON_MODIFYER_NAME, COMMON_MODIFIER_ID, COMMON_MODIFY_TIME, COMMON_DISPLAY, COMMON_EXTEND_1, COMMON_EXTEND_2, COMMON_DATA_SCOPE_ID, COMMON_RECORD_STATUS, COMMON_YEAR_ON, COMMON_MONTH_ON, PAR_VALUE, PAR_DESC, PAR_RW)
values ('PRODUCT_CODE', '', '', '', '', '', '', '', '', 1, '', '', 0, 1, '', '', '&本系统产品代号', '产品代号', 0);
--Update DB_VERSION
update ws_sys set par_value='213', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
commit;
