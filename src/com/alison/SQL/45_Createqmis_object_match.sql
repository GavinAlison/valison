/**创建实物关系表*/

-- Create table
create table QMIS_OBJECT_MATCH
(
  id                   NUMBER not null,
  version              NUMBER not null,
  orderby              VARCHAR2(1024),
  remark               VARCHAR2(1024),
  history              CLOB,
  author_id            NUMBER,
  author_name          VARCHAR2(1024),
  author_time          DATE,
  modifyer_id          NUMBER,
  modifyer_name        VARCHAR2(1024),
  modify_time          DATE,
  data_scope_id        NUMBER default 0,
  record_status        NUMBER default 0,
  display              NUMBER default 0,
  extend_1             VARCHAR2(1024),
  extend_2             VARCHAR2(1024),
  sheet_accessories    VARCHAR2(4000),
  object_rec_id        VARCHAR2(32),
  parent_object_rec_id VARCHAR2(32)
)
;
-- Create/Recreate primary, unique and foreign key constraints 
alter table QMIS_OBJECT_MATCH
  add constraint PK_QMIS_OBJECT_MATCH primary key (ID)
  ;
