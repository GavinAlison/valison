-- Create table
create table WS_V2_REPTABLE_NUMBER
(
  ID                VARCHAR2(32) not null,
  REP_TABLE_ID      VARCHAR2(32),
  MODEL             VARCHAR2(4000),
  DATA_PATTERN      VARCHAR2(4000),
  DIGIT             NUMBER,
  TEMPLATE          VARCHAR2(4000),
  DATAITEM_ID       VARCHAR2(4000),
  PLANE_ID          VARCHAR2(1024),
  PLANE_DATAITEM_ID VARCHAR2(1024)
);
------更新当前库脚本编号
update ws_sys set par_value='195', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
commit;
