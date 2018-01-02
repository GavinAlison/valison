drop table WS_FLOW_CHART;
create table WS_FLOW_CHART(
	ID 			INTEGER  not null,
	X_COORDINATE 		INTEGER default 0,
	Y_COORDINATE		INTEGER default 0,
	LEFT			INTEGER default 0, 
	TOP			INTEGER default 0,
	WIDTH			INTEGER default 0,
	HEIGHT			INTEGER default 0,
	BOTTOM			INTEGER default 0,
	RIGHT			INTEGER default 0,
	PD_ID			VARCHAR2(100),
	TD_ID			VARCHAR2(100),
	TASK_TEXT		VARCHAR2(100),
	TASK_NUMBER		VARCHAR2(100),
	constraint PK_WS_FLOW_CHART primary key(ID)
);


create sequence SEQ_FLOW_CHART
increment by 1
start with 1
 nominvalue
 nomaxvalue
;

