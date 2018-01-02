--同步新版首页工作摘要sql
--function FN_OPERATE_LIST
create or replace function FN_OPERATE_LIST(td_list varchar2,tabID   varchar2)
  return varchar2 is
  operateList varchar2(4000);
  v_list      varchar2(4000) := td_list||';';
  l_idx       Number;
begin
  loop
    --获取childList的位置
    l_idx := regexp_instr(v_list, 'childList[[:digit:]]*=' || tabID || ',');
    --dbms_output.put_line('位置:' || l_idx);
    if l_idx >= 0 then
      --如果有则截取
      v_list := substr(v_list,
                       regexp_instr(v_list,
                                    'childList[[:digit:]]*=' || tabID || ',') +
                       length(regexp_SUBSTR(v_list,
                                            'childList[[:digit:]]*=' || tabID || ',')) - 2);
      --dbms_output.put_line('v_list:' || v_list);
      operateList := operateList || substr(v_list, 1, instr(v_list, ';'));
      --dbms_output.put_line('operateList:' || operateList);
    else
      exit;
    end if;
  end loop;
  return operateList;
end FN_OPERATE_LIST;
/
--function FN_DATA_LIST
create or replace function FN_DATA_LIST(td_list varchar2) return varchar2 is
  dataList varchar2(4000);
  all_list varchar2(4000) := td_list || ';';
begin
  dataList := substr(all_list,
                     length(substr(all_list, 1, instr(all_list, '='))) + 1,
                     case
                       when instr(all_list, ';') = 0 then
                        length(all_list) - instr(all_list, '=')
                       when instr(all_list, ';') <> 0 then
                        instr(all_list, ';') - instr(all_list, '=') - 1
                     end);
  return dataList;
end FN_DATA_LIST;
/

--function FN_TABLE_ID
create or replace function FN_TABLE_ID(td_list varchar2) return varchar2 is
  tableId    varchar2(4000);
  table_list varchar2(4000) := FN_DATA_LIST(td_list);
begin
  tableId := substr(table_list, 1, instr(table_list, ',')-1);
  return tableId;
end FN_TABLE_ID;
/

--view VIEW_ALL_ACTIVE_PROCESSINSTACE
CREATE OR REPLACE VIEW VIEW_ALL_ACTIVE_PROCESSINSTACE AS
select (select s.par_value from ws_sys s where s.par_name = 'APP_ID') as APP_ID,
       t.td_name as TASK_NAME,
       u.input_processinstance as APPTASK_ID,
       (case
         when u.act_type = 0 and u.act_status = 0 and d.input_finish_flag=3 then
          3
         when u.act_type = 0 and u.act_status = 1 and d.input_finish_flag=2 and
              t.td_id != p.pd_starttask_id then
          2
         when u.act_type = 0 and u.act_status = 1 and d.input_finish_flag=2  and
              t.td_id = p.pd_starttask_id then
          4
         when u.act_type = 1 then
          0
       end) as TASK_TYPE,
       F.FLOWDESC_USER as APPSEND_UID,
       u.user_name as APPRECEIVE_UID,
       u.common_create_time as SEND_TIME,
       null as END_TIME,
       ('viewTheProcessAction.do?displayName=' || p.pd_name || '&' ||
       'inputinstance=' || u.input_processinstance || '&' ||
       'processinstanceid=' || u.input_processinstance || '&' ||
       'flowname=' || p.pd_nameeng || '&' || 'flag=' ||
       --flag
       (case
         when u.act_type = 0 and u.act_status = 0 and d.input_finish_flag=3 then
          'todo'
         when u.act_type = 0 and u.act_status = 1 and d.input_finish_flag=2 then
          'isnow'
         when u.act_type = 1 then
          'copy'
       end) || '&' || 'datatitle=' || fn_data_list(t.td_parm) || '&' ||
       'tdid=' || u.td_id || '&' || 'curtdid=' || u.td_id || '&' ||
       'listAllParam=' || t.td_parm || '&' || 'operateList=' ||
       FN_OPERATE_LIST(t.td_parm, FN_TABLE_ID(t.td_parm)) || '&' ||
       'viewFlag=' || (case
         when u.act_type = 1 then
          'view'
         else
          null
       end) || '&' || 'inputid=' || d.input_id || '&' || 'moduleid=' ||
       m.module_id || '&' || 'list=' || fn_data_list(t.td_parm)) as URL,
       (case
         when F.FLOWDESC_DETAIL is null then
          t.td_name
         else
          F.FLOWDESC_DETAIL
       end) as TASK_DESC,
       null as PRIORITY_ID
  from ws_input_node_user u
  left join cnaec_processdefinition p
    on p.pd_nameeng =
       substr(u.input_processinstance,
              1,
              instr(u.input_processinstance, '.') - 1)
  left join cnaec_taskdefinition t
    on p.pd_id = t.pd_id
   and u.td_id = t.td_id
  inner join  ws_input_desc   d
    on input_finish_flag !=1
   and d.input_processinstance = u.input_processinstance
   and d.rep_table_id = to_number(fn_table_id(t.td_parm))
  left join ws_module m
    on m.childrentree_param1 = p.pd_nameeng
  left join ws_user wu
    on u.user_name = wu.user_name
  left join (SELECT T1.FLOWDESC_INSTANCEID,
                    T1.FLOWDESC_TDID,
                    T1.FLOWDESC_DETAIL,
                    T1.FLOWDESC_USER
               FROM WS_FLOWDESC T1
              inner join (SELECT inu.input_processinstance,
                                MAX(w.FLOWDESC_ID) as FLOWDESC_ID
                           FROM WS_INPUT_NODE_USER INU
                           LEFT JOIN WS_FLOWDESC w
                             ON INU.TD_ID = w.FLOWDESC_TDID
                            and INU.Input_Processinstance =
                                w.flowdesc_instanceid
                          group by inu.input_processinstance) T2
                 on t1.flowdesc_id = t2.FLOWDESC_ID) F
    on u.input_processinstance = F.FLOWDESC_INSTANCEID
 where u.over != 1;
/


--procedure INSERT_UNNION_TASK
create or replace procedure INSERT_UNNION_TASK as
  cursor cs is
    select SEQ_UNIONTASK.NEXTVAL as UT_ID, v.*
      from view_ALL_Active_ProcessInstace v;
begin
  for T in cs loop
    BEGIN
      insert into WS_UNION_TASK
      values
        (t. UT_ID,
         t.APP_ID,
         t.TASK_NAME,
         t.APPTASK_ID,
         t.TASK_TYPE,
         t.APPSEND_UID,
         t.APPRECEIVE_UID,
         t.SEND_TIME,
         t.END_TIME,
         t.URL,
         t.TASK_DESC,
         t.PRIORITY_ID);
    END;
  end loop;
end INSERT_UNNION_TASK;
/

--需要同步时把下面sql注释去掉并在plsql中执行
--先清除新版工作摘要数据再同步
--delete from WS_UNION_TASK
--commit;
--调用同步存储过程
--call INSERT_UNNION_TASK();
--commit;

 
