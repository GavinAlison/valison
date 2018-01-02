------部门领导表
create table  ws_dept_leader 
(
  ID                 INTEGER not null,
  USER_ID            INTEGER,
  DEPT_ID            INTEGER,
  DEPT_LEADER_POST   VARCHAR2(1024)
);
-- Create sequence 
create sequence SEQ_ws_dept_leader
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;
