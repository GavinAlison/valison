/**112¿â*/

delete from PMS_BATCH;
drop table PMS_BATCH;
delete from PMS_ITEM;
drop table PMS_ITEM;
delete from PMS_PART;
drop table PMS_PART;
delete from PMS_PRODUCT;
drop table PMS_PRODUCT;
delete from QMIS_BATCH;
drop table QMIS_BATCH;
delete from QMIS_BATCH_SCHEDULE;
drop table QMIS_BATCH_SCHEDULE;
delete from QMIS_OBJECT;
drop table QMIS_OBJECT;
delete from QMIS_OBJECT_MATCH;
drop table QMIS_OBJECT_MATCH;
delete from PMS_ITEM_BOM;
drop table PMS_ITEM_BOM;
delete from PMS_SCHEDULE;
drop table PMS_SCHEDULE;
delete from PMS_SCHEDULE_LINE;
drop table PMS_SCHEDULE_LINE;
delete from QMIS_TREE_CATE;
drop table QMIS_TREE_CATE;
delete from QMIS_TREE_LEVEL;
drop table QMIS_TREE_LEVEL;
delete from QMIS_TREE_RESOURCE;
drop table QMIS_TREE_RESOURCE;


 DROP SEQUENCE SEQ_PMS_ITEM;
 DROP SEQUENCE SEQ_PMS_PART;
 DROP SEQUENCE SEQ_QMIS_BATCH;
 DROP SEQUENCE SEQ_QMIS_BATCH_SCHEDULE;
 DROP SEQUENCE SEQ_QMIS_OBJECT;
 DROP SEQUENCE SEQ_QMIS_OBJECT_MATCH;
 DROP SEQUENCE SEQ_QMIS_TREE_CATE;
 DROP SEQUENCE SEQ_QMIS_TREE_LEVEL;
 DROP SEQUENCE SEQ_QMIS_TREE_RESOURCE;         
 DROP SEQUENCE SEQ_PMS_ITEM_BOM;
 DROP SEQUENCE SEQ_PMS_PRODUCT;
 DROP SEQUENCE SEQ_PMS_PRODUCT_BOM;
 DROP SEQUENCE SEQ_QMIS_OBJECT_BOM;
 DROP SEQUENCE SEQ_PMS_BATCH;
 DROP SEQUENCE SEQ_Pms_Schedule;
 DROP SEQUENCE SEQ_Pms_Schedule_Line;



 create or replace synonym PMS_BATCH for iqs.PMS_BATCH;
 create or replace synonym PMS_ITEM for iqs.PMS_ITEM;
 create or replace synonym PMS_PART for iqs.PMS_PART;
 create or replace synonym QMIS_BATCH_SCHEDULE for iqs.QMIS_BATCH_SCHEDULE;
 create or replace synonym PMS_PRODUCT for iqs.PMS_PRODUCT;
 create or replace synonym QMIS_BATCH for iqs.QMIS_BATCH;
 create or replace synonym QMIS_OBJECT for iqs.QMIS_OBJECT;
 create or replace synonym QMIS_OBJECT_MATCH for iqs.QMIS_OBJECT_MATCH;
 create or replace synonym PMS_ITEM_BOM for iqs.PMS_ITEM_BOM;
 create or replace synonym PMS_SCHEDULE for iqs.PMS_SCHEDULE;
 create or replace synonym PMS_SCHEDULE_LINE for iqs.PMS_SCHEDULE_LINE;
 create or replace synonym QMIS_TREE_CATE for iqs.QMIS_TREE_CATE;
 create or replace synonym QMIS_TREE_LEVEL for iqs.QMIS_TREE_LEVEL;
 create or replace synonym QMIS_TREE_RESOURCE for iqs.QMIS_TREE_RESOURCE;
 
 create sequence SEQ_PMS_BATCH
minvalue 1
maxvalue 999999999999999999999999999
start with 6
increment by 1
nocache;


create sequence SEQ_PMS_ITEM
minvalue 1
maxvalue 999999999999999999999999999
start with 6
increment by 1
nocache;

create sequence SEQ_PMS_PART
minvalue 1
maxvalue 999999999999999999999999999
start with 6
increment by 1
nocache;

create sequence SEQ_PMS_PART
minvalue 1
maxvalue 999999999999999999999999999
start with 6
increment by 1
nocache;

create sequence SEQ_PMS_PRODUCT
minvalue 1
maxvalue 999999999999999999999999999
start with 6
increment by 1
nocache;

create sequence SEQ_QMIS_BATCH
minvalue 1
maxvalue 999999999999999999999999999
start with 6
increment by 1
nocache;

create sequence SEQ_QMIS_BATCH_SCHEDULE
minvalue 1
maxvalue 999999999999999999999999999
start with 6
increment by 1
nocache;

create sequence SEQ_QMIS_OBJECT
minvalue 1
maxvalue 999999999999999999999999999
start with 6
increment by 1
nocache;

create sequence SEQ_QMIS_OBJECT_MATCH
minvalue 1
maxvalue 999999999999999999999999999
start with 6
increment by 1
nocache;

create sequence SEQ_PMS_ITEM_BOM
minvalue 1
maxvalue 999999999999999999999999999
start with 6
increment by 1
nocache;

create sequence SEQ_PMS_SCHEDULE
minvalue 1
maxvalue 999999999999999999999999999
start with 6
increment by 1
nocache;

create sequence SEQ_PMS_SCHEDULE_LINE
minvalue 1
maxvalue 999999999999999999999999999
start with 6
increment by 1
nocache;

create sequence SEQ_QMIS_TREE_CATE
minvalue 1
maxvalue 999999999999999999999999999
start with 6
increment by 1
nocache;

create sequence SEQ_QMIS_TREE_RESOURCE
minvalue 1
maxvalue 999999999999999999999999999
start with 6
increment by 1
nocache;

create sequence SEQ_QMIS_TREE_LEVEL
minvalue 1
maxvalue 999999999999999999999999999
start with 6
increment by 1
nocache;


-- Create table
create table PMS_BATCH
(
  id                    NUMBER not null,
  version               NUMBER not null,
  orderby               VARCHAR2(1024),
  remark                VARCHAR2(1024),
  history               CLOB,
  author_id             NUMBER,
  author_name           VARCHAR2(1024),
  author_time           DATE,
  modifyer_id           NUMBER,
  modifyer_name         VARCHAR2(1024),
  modify_time           DATE,
  data_scope_id         NUMBER default 0,
  record_status         NUMBER default 0,
  display               NUMBER default 0,
  extend_1              VARCHAR2(1024),
  extend_2              VARCHAR2(1024),
  sheet_accessories     VARCHAR2(4000),
  batch_id              VARCHAR2(32),
  batch_status          VARCHAR2(32),
  product_rec_id        NUMBER(22),
  product_id            VARCHAR2(1024),
  product_name          VARCHAR2(1024),
  product_code          VARCHAR2(1024),
  item_rec_id           NUMBER(22),
  item_id               VARCHAR2(1024),
  item_name             VARCHAR2(1024),
  item_code             VARCHAR2(1024),
  develop_status        VARCHAR2(32),
  material_name         VARCHAR2(1024),
  material_number       VARCHAR2(1024),
  material_spec         VARCHAR2(1024),
  material_status       VARCHAR2(1024),
  material_supply_state VARCHAR2(1024),
  material_remark       VARCHAR2(1024),
  part_sort             VARCHAR2(32),
  part_mode             VARCHAR2(32),
  key_character         VARCHAR2(32),
  line_rec_id           NUMBER(22),
  line_id               VARCHAR2(32),
  total_id              VARCHAR2(1024),
  division_id           VARCHAR2(1024),
  start_workshop_id     NUMBER(22),
  start_workshop        VARCHAR2(1024),
  machining_unit_id     NUMBER(22),
  machining_unit        VARCHAR2(1024),
  ration_amount         NUMBER(22),
  plan_on               VARCHAR2(32),
  plan_by               VARCHAR2(1024),
  editor_name           VARCHAR2(1024),
  take_material_on      VARCHAR2(32),
  take_material_by      VARCHAR2(1024),
  material_batch        VARCHAR2(1024),
  material_check_number VARCHAR2(1024),
  produce_on            VARCHAR2(32),
  produce_by            VARCHAR2(1024),
  current_workshop_id   NUMBER(22),
  current_workshop      VARCHAR2(1024),
  current_amount        NUMBER(22),
  current_schedule_id   VARCHAR2(32),
  current_schedule_name VARCHAR2(1024),
  plan_over_on          VARCHAR2(32),
  over_on               VARCHAR2(32),
  plan_over_amount      NUMBER(22),
  over_amount           NUMBER(22),
  deliver_amount        NUMBER(22),
  follow_number         NUMBER(22)
)
;
-- Create/Recreate primary, unique and foreign key constraints 
alter table PMS_BATCH
  add constraint PK_PMS_BATCH primary key (ID)
;




-- Create table
create table PMS_BATCH_SCHEDULE
(
  id                NUMBER not null,
  version           NUMBER not null,
  orderby           VARCHAR2(1024),
  remark            VARCHAR2(1024),
  history           CLOB,
  author_id         NUMBER,
  author_name       VARCHAR2(1024),
  author_time       DATE,
  modifyer_id       NUMBER,
  modifyer_name     VARCHAR2(1024),
  modify_time       DATE,
  data_scope_id     NUMBER default 0,
  record_status     NUMBER default 0,
  display           NUMBER default 0,
  extend_1          VARCHAR2(1024),
  extend_2          VARCHAR2(1024),
  batch_id          VARCHAR2(32),
  line_rec_id       NUMBER,
  line_id           VARCHAR2(32),
  schedule_id       VARCHAR2(32),
  schedule_name     VARCHAR2(1024),
  schedule_type     VARCHAR2(32),
  work_type         VARCHAR2(1024),
  equipment_sort    VARCHAR2(1024),
  equipment         VARCHAR2(1024),
  man_hour          NUMBER,
  prepare_man_hour  NUMBER,
  machining_amount  NUMBER(22),
  schedule_status   VARCHAR2(32),
  schedule_order    NUMBER(22),
  schedule_iskey    VARCHAR2(32),
  workshop_id       NUMBER(22),
  workshop_name     VARCHAR2(1024),
  current_dept_id   NUMBER(22),
  current_dept_name VARCHAR2(1024)
)
;
-- Create/Recreate primary, unique and foreign key constraints 
alter table PMS_BATCH_SCHEDULE
  add constraint PK_PMS_BATCH_SCHEDULE primary key (ID)
;


-- Create table
create table PMS_ITEM
(
  id             NUMBER not null,
  version        NUMBER not null,
  orderby        VARCHAR2(1024),
  remark         VARCHAR2(1024),
  history        CLOB,
  author_id      NUMBER,
  author_name    VARCHAR2(1024),
  author_time    DATE,
  modifyer_id    NUMBER,
  modifyer_name  VARCHAR2(1024),
  modify_time    DATE,
  data_scope_id  NUMBER default 0,
  record_status  NUMBER default 0,
  display        NUMBER default 0,
  extend_1       VARCHAR2(1024),
  extend_2       VARCHAR2(1024),
  item_id        VARCHAR2(1024),
  item_name      VARCHAR2(1024),
  item_code      VARCHAR2(1024),
  item_sort      VARCHAR2(1024),
  item_unit      VARCHAR2(1024),
  develop_status VARCHAR2(32)
)
;
-- Create/Recreate primary, unique and foreign key constraints 
alter table PMS_ITEM
  add constraint PK_PMS_ITEM primary key (ID)
;


-- Create table
create table PMS_ITEM_BOM
(
  id                  NUMBER not null,
  version             NUMBER not null,
  orderby             VARCHAR2(1024),
  remark              VARCHAR2(1024),
  history             CLOB,
  author_id           NUMBER,
  author_name         VARCHAR2(1024),
  author_time         DATE,
  modifyer_id         NUMBER,
  modifyer_name       VARCHAR2(1024),
  modify_time         DATE,
  data_scope_id       NUMBER default 0,
  record_status       NUMBER default 0,
  display             NUMBER default 0,
  extend_1            VARCHAR2(1024),
  extend_2            VARCHAR2(1024),
  item_rec_id         NUMBER,
  item_code           VARCHAR2(1024),
  parent_item_rec_id  NUMBER,
  parent_item_code    VARCHAR2(1024),
  match_type          VARCHAR2(1024),
  match_method        VARCHAR2(1024),
  match_amount        NUMBER(22),
  spare_amount        NUMBER(22),
  single_spare_amount NUMBER(22),
  set_spare_amount    NUMBER(22),
  level_id            NUMBER(22),
  product_rec_id      VARCHAR2(100)
)
;
-- Create/Recreate primary, unique and foreign key constraints 
alter table PMS_ITEM_BOM
  add constraint PK_PMS_ITEM_BOM primary key (ID)
;
  
-- Create table
create table PMS_PART
(
  id                  NUMBER not null,
  version             NUMBER not null,
  orderby             VARCHAR2(1024),
  remark              VARCHAR2(1024),
  history             CLOB,
  author_id           NUMBER,
  author_name         VARCHAR2(1024),
  author_time         DATE,
  modifyer_id         NUMBER,
  modifyer_name       VARCHAR2(1024),
  modify_time         DATE,
  data_scope_id       NUMBER default 0,
  record_status       NUMBER default 0,
  display             NUMBER default 0,
  extend_1            VARCHAR2(1024),
  extend_2            VARCHAR2(1024),
  item_code           VARCHAR2(1024),
  item_rec_id         NUMBER,
  part_sort           VARCHAR2(1024),
  part_mode           VARCHAR2(1024),
  machining_sort      VARCHAR2(1024),
  primary_workshop_id NUMBER(22),
  primary_workshop    VARCHAR2(1024),
  sub_workshop_id     NUMBER(22),
  sub_workshop        VARCHAR2(1024),
  machining_unit_id   VARCHAR2(32),
  machining_unit      VARCHAR2(1024),
  waste_rate          NUMBER,
  store_sort          VARCHAR2(1024),
  store_prompt        VARCHAR2(1024),
  key_character       VARCHAR2(1024),
  match_sort          VARCHAR2(1024),
  plan_price          NUMBER,
  material_name       VARCHAR2(1024),
  material_number     VARCHAR2(1024),
  material_spec       VARCHAR2(1024),
  material_status     VARCHAR2(1024),
  sub_material_name   VARCHAR2(1024),
  sub_material_number VARCHAR2(1024),
  sub_material_spec   VARCHAR2(1024),
  sub_material_status VARCHAR2(1024)
)
;
-- Create/Recreate primary, unique and foreign key constraints 
alter table PMS_PART
  add constraint PK_PMS_PART primary key (ID)
;


-- Create table
create table PMS_PRODUCT
(
  id            NUMBER not null,
  version       NUMBER not null,
  orderby       VARCHAR2(1024),
  remark        VARCHAR2(1024),
  history       CLOB,
  author_id     NUMBER,
  author_name   VARCHAR2(1024),
  author_time   DATE,
  modifyer_id   NUMBER,
  modifyer_name VARCHAR2(1024),
  modify_time   DATE,
  data_scope_id NUMBER default 0,
  record_status NUMBER default 0,
  display       NUMBER default 0,
  extend_1      VARCHAR2(1024),
  extend_2      VARCHAR2(1024),
  item_code     VARCHAR2(1024),
  item_rec_id   NUMBER,
  item_grade    VARCHAR2(1024),
  user_type     VARCHAR2(1024),
  match_unit    VARCHAR2(1024),
  match_plane   VARCHAR2(1024),
  status_tag    VARCHAR2(1024),
  software_ver  VARCHAR2(1024)
)
;
-- Create/Recreate primary, unique and foreign key constraints 
alter table PMS_PRODUCT
  add constraint PK_PMS_PRODUCT primary key (ID)
;


-- Create table
create table PMS_PRODUCT_BOM
(
  id                NUMBER not null,
  version           NUMBER not null,
  orderby           VARCHAR2(1024),
  remark            VARCHAR2(1024),
  history           CLOB,
  author_id         NUMBER,
  author_name       VARCHAR2(1024),
  author_time       DATE,
  modifyer_id       NUMBER,
  modifyer_name     VARCHAR2(1024),
  modify_time       DATE,
  data_scope_id     NUMBER default 0,
  record_status     NUMBER default 0,
  display           NUMBER default 0,
  extend_1          VARCHAR2(1024),
  extend_2          VARCHAR2(1024),
  sheet_accessories VARCHAR2(4000),
  product_rec_id    NUMBER(22),
  product_code      VARCHAR2(1024),
  item_rec_id       NUMBER(22),
  item_code         VARCHAR2(1024),
  match_type        VARCHAR2(1024),
  match_amount      NUMBER(22),
  spare_amount      NUMBER(22),
  level_id          NUMBER(22)
);
-- Create/Recreate primary, unique and foreign key constraints 
alter table PMS_PRODUCT_BOM
  add constraint PK_PMS_PRODUCT_BOM primary key (ID)
;


-- Create table
create table QMIS_BATCH
(
  id                    NUMBER not null,
  version               NUMBER not null,
  orderby               VARCHAR2(1024),
  remark                VARCHAR2(1024),
  history               CLOB,
  author_id             NUMBER,
  author_name           VARCHAR2(1024),
  author_time           DATE,
  modifyer_id           NUMBER,
  modifyer_name         VARCHAR2(1024),
  modify_time           DATE,
  data_scope_id         NUMBER default 0,
  record_status         NUMBER default 0,
  display               NUMBER default 0,
  extend_1              VARCHAR2(1024),
  extend_2              VARCHAR2(1024),
  sheet_accessories     VARCHAR2(4000),
  batch_id              VARCHAR2(32),
  batch_status          VARCHAR2(32),
  product_rec_id        VARCHAR2(32),
  product_id            VARCHAR2(1024),
  product_name          VARCHAR2(1024),
  product_code          VARCHAR2(1024),
  item_rec_id           VARCHAR2(32),
  item_id               VARCHAR2(1024),
  item_name             VARCHAR2(1024),
  item_code             VARCHAR2(1024),
  develop_status        VARCHAR2(32),
  material_name         VARCHAR2(1024),
  material_number       VARCHAR2(1024),
  material_spec         VARCHAR2(1024),
  material_status       VARCHAR2(1024),
  material_supply_state VARCHAR2(1024),
  material_remark       VARCHAR2(1024),
  part_sort             VARCHAR2(32),
  part_mode             VARCHAR2(32),
  key_character         VARCHAR2(32),
  line_rec_id           VARCHAR2(32),
  line_id               VARCHAR2(32),
  total_id              VARCHAR2(1024),
  division_id           VARCHAR2(1024),
  start_workshop_id     VARCHAR2(1024),
  start_workshop        VARCHAR2(1024),
  machining_unit_id     NUMBER(22),
  machining_unit        VARCHAR2(1024),
  ration_amount         NUMBER(22),
  plan_on               VARCHAR2(32),
  plan_by               VARCHAR2(1024),
  editor_name           VARCHAR2(1024),
  take_material_on      VARCHAR2(32),
  take_material_by      VARCHAR2(1024),
  material_batch        VARCHAR2(1024),
  material_check_number VARCHAR2(1024),
  produce_on            VARCHAR2(32),
  produce_by            VARCHAR2(1024),
  current_workshop_id   NUMBER(22),
  current_workshop      VARCHAR2(1024),
  current_amount        NUMBER(22),
  current_schedule_id   VARCHAR2(32),
  current_schedule_name VARCHAR2(1024),
  plan_over_on          VARCHAR2(32),
  over_on               VARCHAR2(32),
  plan_over_amount      NUMBER(22),
  over_amount           NUMBER(22),
  deliver_amount        NUMBER(22),
  follow_number         NUMBER(22),
  mother_batch_id       VARCHAR2(1024),
  split_schedule_id     VARCHAR2(32),
  organize_end          VARCHAR2(32),
  grade                 NUMBER(22),
  year_on               VARCHAR2(32),
  month_on              VARCHAR2(32)
)
;
-- Create/Recreate primary, unique and foreign key constraints 
alter table QMIS_BATCH
  add constraint PK_QMIS_BATCH primary key (ID)
;

-- Create table
create table QMIS_BATCH_SCHEDULE
(
  id                NUMBER not null,
  version           NUMBER not null,
  orderby           VARCHAR2(1024),
  remark            VARCHAR2(1024),
  history           CLOB,
  author_id         NUMBER,
  author_name       VARCHAR2(1024),
  author_time       DATE,
  modifyer_id       NUMBER,
  modifyer_name     VARCHAR2(1024),
  modify_time       DATE,
  data_scope_id     NUMBER default 0,
  record_status     NUMBER default 0,
  display           NUMBER default 0,
  extend_1          VARCHAR2(1024),
  extend_2          VARCHAR2(1024),
  sheet_accessories VARCHAR2(4000),
  batch_id          VARCHAR2(32),
  line_rec_id       VARCHAR2(32),
  line_id           VARCHAR2(32),
  schedule_id       VARCHAR2(32),
  schedule_name     VARCHAR2(1024),
  schedule_type     VARCHAR2(32),
  work_type         VARCHAR2(1024),
  equipment_sort    VARCHAR2(1024),
  equipment         VARCHAR2(1024),
  man_hour          NUMBER,
  prepare_man_hour  NUMBER,
  machining_amount  NUMBER(22),
  schedule_status   VARCHAR2(32),
  schedule_order    NUMBER(22),
  schedule_iskey    VARCHAR2(32),
  workshop_id       NUMBER(22),
  workshop_name     VARCHAR2(1024),
  current_dept_id   NUMBER(22),
  current_dept_name VARCHAR2(1024)
)
;
-- Create/Recreate primary, unique and foreign key constraints 
alter table QMIS_BATCH_SCHEDULE
  add constraint PK_QMIS_BATCH_SCHEDULE primary key (ID)
;

-- Create table
create table QMIS_OBJECT
(
  id                NUMBER not null,
  version           NUMBER not null,
  orderby           VARCHAR2(1024),
  remark            VARCHAR2(1024),
  history           CLOB,
  author_id         NUMBER,
  author_name       VARCHAR2(1024),
  author_time       DATE,
  modifyer_id       NUMBER,
  modifyer_name     VARCHAR2(1024),
  modify_time       DATE,
  data_scope_id     NUMBER default 0,
  record_status     NUMBER default 0,
  display           NUMBER default 0,
  extend_1          VARCHAR2(1024),
  extend_2          VARCHAR2(1024),
  sheet_accessories VARCHAR2(4000),
  object_id         VARCHAR2(1024),
  object_batch_id   VARCHAR2(1024),
  object_follow_id  VARCHAR2(1024),
  object_number     VARCHAR2(100)
)
;
-- Create/Recreate primary, unique and foreign key constraints 
alter table QMIS_OBJECT
  add constraint PK_QMIS_OBJECT primary key (ID)
;

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
);
-- Create/Recreate primary, unique and foreign key constraints 
alter table QMIS_OBJECT_MATCH
  add constraint PK_QMIS_OBJECT_MATCH primary key (ID)
;


-- Create table
create table PMS_SCHEDULE
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
  item_code            VARCHAR2(1024),
  item_rec_id          NUMBER,
  line_rec_id          NUMBER,
  line_id              VARCHAR2(32),
  schedule_id          VARCHAR2(32),
  schedule_name        VARCHAR2(1024),
  schedule_type        VARCHAR2(1024),
  work_type            VARCHAR2(1024),
  equipment_sort       VARCHAR2(1024),
  equipment            VARCHAR2(1024),
  man_hour             NUMBER,
  prepare_man_hour     NUMBER,
  man_hour_modifyer_id NUMBER(22),
  man_hour_modifyer    VARCHAR2(1024),
  man_hour_modify_time DATE
);
-- Create/Recreate primary, unique and foreign key constraints 
alter table PMS_SCHEDULE
  add constraint PK_PMS_SCHEDULE primary key (ID)
;


-- Create table
create table PMS_SCHEDULE_LINE
(
  id                  NUMBER not null,
  version             NUMBER not null,
  orderby             VARCHAR2(1024),
  remark              VARCHAR2(1024),
  history             CLOB,
  author_id           NUMBER,
  author_name         VARCHAR2(1024),
  author_time         DATE,
  modifyer_id         NUMBER,
  modifyer_name       VARCHAR2(1024),
  modify_time         DATE,
  data_scope_id       NUMBER default 0,
  record_status       NUMBER default 0,
  display             NUMBER default 0,
  extend_1            VARCHAR2(1024),
  extend_2            VARCHAR2(1024),
  item_code           VARCHAR2(1024),
  item_rec_id         NUMBER,
  line_type           VARCHAR2(32),
  line_id             VARCHAR2(32),
  line_status         VARCHAR2(32),
  man_hour_status     VARCHAR2(32),
  use_dept_id         VARCHAR2(1024),
  use_dept            VARCHAR2(1024),
  material_name       VARCHAR2(1024),
  material_number     VARCHAR2(1024),
  material_spec       VARCHAR2(1024),
  material_status     VARCHAR2(1024),
  sub_material_name   VARCHAR2(1024),
  sub_material_number VARCHAR2(1024),
  sub_material_spec   VARCHAR2(1024),
  sub_material_status VARCHAR2(1024),
  tech_bill           VARCHAR2(1024)
)
;
-- Create/Recreate primary, unique and foreign key constraints 
alter table PMS_SCHEDULE_LINE
  add constraint PK_PMS_SCHEDULE_LINE primary key (ID)
 ;


-- Create table
create table QMIS_TREE_CATE
(
  cate_id   NUMBER not null,
  cate_name VARCHAR2(1024),
  cate_desc VARCHAR2(1024)
);
-- Create/Recreate primary, unique and foreign key constraints 
alter table QMIS_TREE_CATE
  add constraint PK_QMIS_TREE_CATE primary key (CATE_ID)
  ;
alter table QMIS_TREE_CATE
  add unique (CATE_NAME)
 ;


-- Create table
create table QMIS_TREE_LEVEL
(
  level_id NUMBER not null,
  level_no VARCHAR2(1024),
  cate_id  NUMBER
);
-- Create/Recreate primary, unique and foreign key constraints 
alter table QMIS_TREE_LEVEL
  add constraint PK_QMIS_TREE_LEVEL primary key (LEVEL_ID)
;

-- Create table
create table QMIS_TREE_RESOURCE
(
  resource_id   NUMBER not null,
  resource_url  VARCHAR2(1024),
  resource_name VARCHAR2(1024),
  level_id      NUMBER
);
-- Create/Recreate primary, unique and foreign key constraints 
alter table QMIS_TREE_RESOURCE
  add constraint PK_QMIS_TREE_RESOURCE primary key (RESOURCE_ID)
;


-- Create table
create table QMIS_CHECKUP_ORGANIZE
(
  id                NUMBER not null,
  version           NUMBER not null,
  orderby           VARCHAR2(1024),
  remark            VARCHAR2(1024),
  history           CLOB,
  author_id         NUMBER,
  author_name       VARCHAR2(1024),
  author_time       DATE,
  modifyer_id       NUMBER,
  modifyer_name     VARCHAR2(1024),
  modify_time       DATE,
  data_scope_id     NUMBER default 0,
  record_status     NUMBER default 0,
  display           NUMBER default 0,
  extend_1          VARCHAR2(1024),
  extend_2          VARCHAR2(1024),
  sheet_accessories VARCHAR2(4000),
  batch_id          VARCHAR2(32),
  schedule_id       VARCHAR2(32),
  schedule_name     VARCHAR2(1024),
  checker_name      VARCHAR2(1024),
  checker_id        VARCHAR2(1024),
  assign_on         VARCHAR2(32),
  assign_by         VARCHAR2(1024),
  prepare_work      VARCHAR2(32)
);
-- Create/Recreate primary, unique and foreign key constraints 
alter table QMIS_CHECKUP_ORGANIZE
  add constraint PK_QMIS_CHECKUP_ORGANIZE primary key (ID)
  ;
