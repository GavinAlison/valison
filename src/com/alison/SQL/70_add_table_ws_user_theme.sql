/** 用户主题表 */
/** drop and create table */
drop table ws_user_theme cascade constraints;
create table ws_user_theme (
	ID                NUMBER not null, /** pk */
	VERSION           NUMBER not null,
	ORDERBY           VARCHAR2(1024),
	REMARK            VARCHAR2(1024),
	HISTORY           CLOB,
	AUTHOR_ID         NUMBER,
	AUTHOR_NAME       VARCHAR2(1024),
	AUTHOR_TIME       DATE,
	MODIFYER_ID       NUMBER,
	MODIFYER_NAME     VARCHAR2(1024),
	MODIFY_TIME       DATE,
	DATA_SCOPE_ID     NUMBER default 0,
	RECORD_STATUS     NUMBER default 0,
	DISPLAY           NUMBER default 0,
	EXTEND_1          VARCHAR2(1024),
	EXTEND_2          VARCHAR2(1024),
	SHEET_ACCESSORIES VARCHAR2(4000),
	
	--表个性化字段：MAIN_ 开始
	USER_ID VARCHAR2(1024),
	USER_THEME VARCHAR2(1024),
	THEME_DESC VARCHAR2(1024),
	constraint PK_WS_USER_THEME primary key (ID)
);

/** create sequence */
drop sequence SEQ_WS_USER_THEME;
create sequence SEQ_WS_USER_THEME
start with 1
increment by 1
nominvalue
nomaxvalue
nocache;
