-- Create �û����Ի����ñ���Ҫ���ͱ���˵�ϵͳ��Ҫ�˱�
create table WS_USER_PERSONAL
(
  ID             NUMBER not null,
  USER_ID        VARCHAR2(1024),
  PERSONAL_ID    VARCHAR2(1024),
  PERSONAL_VALUE VARCHAR2(1024),
  MODULE_ID      VARCHAR2(1024)
);

create sequence SEQ_WS_USER_PERSONAL
minvalue 1
maxvalue 999999999999999999999999999
start with 18
increment by 1
nocache;

/*���µ�ǰ��ű����*/
 update ws_sys set par_value='192', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
commit;