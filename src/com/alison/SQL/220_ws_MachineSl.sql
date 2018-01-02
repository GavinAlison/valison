/*机器密级*/
drop table ws_MachineSl;
create table ws_MachineSl
(
	/*pk*/
	ID              	    VARCHAR2(32) not null,
    VERSION                 NUMBER not null,
	COMMON_ORDERBY       	VARCHAR2(1024),
	COMMON_REMARK        	VARCHAR2(1024),
	COMMON_AUTHOR_ID     	VARCHAR2(1024),
	COMMON_AUTHOR_NAME   	VARCHAR2(1024),
	COMMON_MODIFYER_NAME 	VARCHAR2(1024),
	COMMON_MODIFY_TIME   	VARCHAR2(1024),
	COMMON_CREATE_TIME       VARCHAR2(100),
	COMMON_DISPLAY       	VARCHAR2(1024),
	COMMON_EXTEND_1      	VARCHAR2(1024),
	COMMON_EXTEND_2     	VARCHAR2(1024),
	COMMON_DATA_SCOPE_ID 	NUMBER default 0,
	COMMON_RECORD_STATUS 	NUMBER default 0,
	COMMON_YEAR_ON       	VARCHAR2(1024),
	COMMON_MONTH_ON      	VARCHAR2(1024),
	DATA_GROUP_ID        	VARCHAR2(1024),
	COMMON_DELETED       	NUMBER default 0,
	
	SHEET_ACCEPT_LIMIT   	DATE,
	SHEET_COMPLETE_LIMIT 	DATE,
  
	SHEET_ACCESSORIES 	 	VARCHAR2(4000),  
	ATTACHMENT_ID			NUMBER default 0,
    
	--表个性化字段：MAIN_ 开始
	MATHINE_NAME 	VARCHAR2(100),
	MACHINE_IP 	VARCHAR2(100),
	SL_LEVEL 	VARCHAR2(100),
	constraint WS_PK_ws_MachineSl_MAIN primary key (ID)
);

--view create
/**
CREATE or REPLACE view VIEW_MachineSl as
SELECT * FROM MachineSl 

*/

--create synonym for avicit user : apps
--create or replace synonym ws_MachineSl for iqs.ws_v2_MachineSl;
--更新数据库版本号
update ws_sys set par_value='220', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss') where par_name='DB_VERSION';
commit;