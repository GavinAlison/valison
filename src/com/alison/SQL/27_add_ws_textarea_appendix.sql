
/**新建表 用于储存带组件文本框中上传的附件**/
CREATE TABLE WS_TEXTAREA_APPENDIX(
  REC_APP_ID            INTEGER    not null,
  TABLE_ID    INTEGER    not null,
  INPUT_ID    INTEGER    not null,
  DATAITEM_ID    INTEGER    not null,
  REC_APP_CONTENT VARCHAR2(1024),
  constraint WS_REC_TEXTAREA_APPENDIX primary key (REC_APP_ID)
);

create sequence SEQ_TEXTAREA_APPENDIX
increment by 1
start with 1
 nominvalue
 nomaxvalue
;