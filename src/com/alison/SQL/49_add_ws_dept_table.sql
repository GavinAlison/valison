/** 在WS_DEPT表里扩展生产相关字段(部门编码、部门类型、定额工时) */
alter table WS_DEPT add DEPT_CODE varchar2(100);
alter table WS_DEPT add DEPT_TYPE varchar2(100);
alter table WS_DEPT add DEPT_QUOTA number(10);
