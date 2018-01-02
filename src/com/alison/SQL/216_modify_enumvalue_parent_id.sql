/*是父子级联枚举项支持多个父的映射*/

alter table WS_ENUM_VALUE rename column PARENT_ENUM_VALUE_ID to PARENT_ENUM_VALUE_ID1;
alter table WS_ENUM_VALUE add PARENT_ENUM_VALUE_ID varchar2(1024);
update WS_ENUM_VALUE set PARENT_ENUM_VALUE_ID=PARENT_ENUM_VALUE_ID1;
alter table WS_ENUM_VALUE drop column PARENT_ENUM_VALUE_ID1;

update ws_sys set par_value='216', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss') where par_name='DB_VERSION';
commit;