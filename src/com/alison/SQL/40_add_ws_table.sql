alter table ws_dataitem add dataitem_formula clob;
alter table ws_rep_table add year_dataitem_id varchar2(1024);
alter table ws_rep_table add month_dataitem_id varchar2(1024);
alter table ws_rep_table add quarter_dataitem_id varchar2(1024);
alter table ws_rep_table add department_dataitem_id varchar2(1024);
alter table ws_rep_table add compute_button varchar2(1024);