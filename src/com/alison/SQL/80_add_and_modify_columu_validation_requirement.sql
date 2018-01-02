/**表CAAW_VALIDATION_REQUIREMENT 增加字段，修改REQUIREMENT_ID类型*/
alter table CAAW_VALIDATION_REQUIREMENT add SPECIAL_CONDITION varchar2(32);
alter table CAAW_VALIDATION_REQUIREMENT add REQUIREMENT_TITLE varchar2(1024);
alter table CAAW_VALIDATION_REQUIREMENT add ATA_TITLE varchar2(1024);


/*更新当前库脚本编号*/
 update ws_sys set par_value='80', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';