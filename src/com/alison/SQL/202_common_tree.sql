-- Create table
create table COMMON_TREE
(
  NODE_ID        VARCHAR2(1024) not null,
  NODE_NAME      VARCHAR2(1024),
  PARENT_NODE_ID VARCHAR2(32),
  NODE_URL       VARCHAR2(4000),
  ORDERBY        VARCHAR2(1024),
  REMARK         VARCHAR2(4000),
  AUTHOR_ID      VARCHAR2(1024),
  AUTHOR_NAME    VARCHAR2(1024),
  CREATE_TIME    VARCHAR2(1024),
  MODIFYER_ID    VARCHAR2(1024),
  MODIFYER_NAME  VARCHAR2(1024),
  MODIFY_TIME    VARCHAR2(1024),
  DATA_SCOPE_ID  VARCHAR2(1024),
  RECORD_STATUS  VARCHAR2(1024),
  YEAR_ON        VARCHAR2(1024),
  MONTH_ON       VARCHAR2(1024),
  DISPLAY        VARCHAR2(1024),
  EXTEND_1       VARCHAR2(1024),
  EXTEND_2       VARCHAR2(1024),
  MODULE_ID      VARCHAR2(1024)
);
-- Create sequence 
create sequence SEQ_COMMON_TREE
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;

---------COMMON_TREE��ڵ㼶��ɾ������������
create or replace trigger "tri_common_tree_node_del" after delete on common_tree for each row
declare  --�����ǹؼ��ĵط����ڱ��������ĵط���ָ���Զ���������   
    pragma autonomous_transaction;  
begin
    delete from common_tree where parent_node_id=:old.node_id;
    --������Ҫ��ʾ�ύ����   
    commit; 
end tri_common_tree_node_del;

/*���µ�ǰ��ű����*/
 update ws_sys set par_value='202', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';

commit;
