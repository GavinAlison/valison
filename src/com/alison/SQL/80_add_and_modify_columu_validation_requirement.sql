/**��CAAW_VALIDATION_REQUIREMENT �����ֶΣ��޸�REQUIREMENT_ID����*/
alter table CAAW_VALIDATION_REQUIREMENT add SPECIAL_CONDITION varchar2(32);
alter table CAAW_VALIDATION_REQUIREMENT add REQUIREMENT_TITLE varchar2(1024);
alter table CAAW_VALIDATION_REQUIREMENT add ATA_TITLE varchar2(1024);


/*���µ�ǰ��ű����*/
 update ws_sys set par_value='80', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';