----------修改单报表刷新存储过程，加上了对视图的刷新，与更新库版本分开执行
CREATE OR REPLACE PROCEDURE "AVICINFO_REFRESH_S2T" (table_id in varchar2) Authid Current_User is
  cursor dataitem_cursor is
    select di.dataitem_id, di.uni_code
      from ws_dataitem di
      left join ws_domain d
        on d.domain_id = di.domain_id
     where d.rep_table_id = table_id order by di.dataitem_id desc;
  v_t_count     number;
  v_column_name varchar2(200);
  v_diid        ws_dataitem.dataitem_id%type;
  v_uc          ws_dataitem.uni_code%type;
  v_table_union_code varchar2(200);
  v_view_sql varchar2(4000);
  v_column_uni_code varchar2(200);
begin
  select UNI_CODE into v_table_union_code from ws_rep_table where rep_table_id=table_id;
  v_view_sql :='create or replace view V_WS_REPORT_'|| v_table_union_code ||' as
              select * from (
              select 
              INPUT_ID,
              ORG_CODE,
              REP_TABLE_ID,
              COMMON_ORDERBY,
              COMMON_REMARK,
              COMMON_AUTHOR_ID,
              COMMON_AUTHOR_NAME,
              COMMON_MODIFYER_NAME,
              COMMON_MODIFY_TIME,
              COMMON_DISPLAY,
              COMMON_EXTEND_1,
              COMMON_EXTEND_2,
              COMMON_DATA_SCOPE_ID,
              COMMON_RECORD_STATUS,
              COMMON_YEAR_ON,
              INPUT_DATE,
              INPUT_DATE_STR,
              INPUT_USER,
              INPUT_PROCESSINSTANCE,
              INPUT_PROCESSDEFINITION,
              INPUT_FINISH_FLAG,
              INPUT_CANCEL,
              INPUT_WARN,
              INPUT_PARANT,
              INPUT_SAVE_FLAG,
              INPUT_IMP_DATE,
              PARENT_INPUT_ID,
              ORIGIN_CHILD_PROCESS,';
  open dataitem_cursor;
  loop
    fetch dataitem_cursor
      into v_diid, v_uc;
    exit when dataitem_cursor%notfound;
    v_column_name := 'D' || v_diid;
    v_column_uni_code :=v_uc;
    v_view_sql := v_view_sql || v_column_name || ' as '|| v_column_uni_code ||',';
   select count(1)
      into v_t_count
      from user_Tab_Columns
     where table_name = 'WS_REPORT_INPUT_DESC_' || table_id
       and column_name = v_column_name;
     
    if v_t_count = 0 then
      --添加不存在的字段
      execute immediate 'alter table WS_REPORT_INPUT_DESC_' || table_Id ||
                        ' add ' || v_column_name || ' varchar2(4000)';
                         
    end if;
  end loop;
  
  close dataitem_cursor;
  
  v_view_sql:=v_view_sql||'	COMMON_MONTH_ON 	 	
	from WS_REPORT_INPUT_DESC_'||table_id||')';
  ---处理视图
  dbms_output.put_line(v_view_sql);
  execute immediate v_view_sql;
  
end avicinfo_refresh_s2t;
/
---------------
---------------
---------------
---------------注意！！！！！，请分步执行SQL语句
---------------
---------------
---------------
/*更新当前库脚本编号*/
 update ws_sys set par_value='209', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';

commit;
