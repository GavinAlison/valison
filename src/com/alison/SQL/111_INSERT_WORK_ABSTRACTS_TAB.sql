/*工作摘要标签系统开关*/
insert into ws_sys
  (PAR_NAME,
   COMMON_ORDERBY,
   COMMON_REMARK,
   COMMON_AUTHOR_ID,
   COMMON_AUTHOR_NAME,
   COMMON_CREATE_TIME,
   COMMON_MODIFYER_NAME,
   COMMON_MODIFIER_ID,
   COMMON_MODIFY_TIME,
   COMMON_DISPLAY,
   COMMON_EXTEND_1,
   COMMON_EXTEND_2,
   COMMON_DATA_SCOPE_ID,
   COMMON_RECORD_STATUS,
   COMMON_YEAR_ON,
   COMMON_MONTH_ON,
   PAR_VALUE,
   PAR_DESC,
   PAR_RW)
values
  ('WORK_ABSTRACTS_TAB',
   '',
   '',
   '',
   '',
   '',
   '',
   '',
   '',
   1,
   '',
   '',
   0,
   1,
   '',
   '',
   'yes',
   '点击模块时是否默认打开工作摘要标签',
   null);

/*更新当前库脚本编号*/
 update ws_sys set par_value='111', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
   commit;
