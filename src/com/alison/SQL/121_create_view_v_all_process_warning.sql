/*超期列表视图*/
create or replace view v_all_process_warning as(
select * from /*已接手未处理超期*/ 
 ( (select distinct 
                      operate_info.input_processinstance,
                      wid.input_finish_flag,
                      ct.td_Warn_Days as warn_days,
                      case
                        when td_warn_days != 0 and
                             ((sysdate -
                             to_date(operate_datetime,
                                       'yyyy-MM-dd hh24:mi:ss')) -
                             td_warn_days) > 0 then
                         1
                        else
                         0
                      end as timeout,
                      to_date(operate_datetime,
                              'yyyy-MM-dd hh24:mi:ss') +
                      td_warn_days as timeout_date,
                      (sysdate -
                      to_date(operate_datetime,
                               'yyyy-MM-dd hh24:mi:ss')) -
                      td_warn_days as timeout_days,
                     wut.url,
                      wut.task_name,
                      wut.module_id,
                      wut.send_time,
                      wut.appsend_uid,
                      u.user_realname as appreceive_uid
        from (select info_id,
                     td_id,
                     operate_way,
                     input_processinstance,
                     poi.operate_date || ' ' ||
                     poi.operate_time as operate_datetime
                from ws_process_operate_info poi
               where not exists
               (select 1
                        from ws_process_operate_info ipoi
                       where ipoi.input_processinstance =
                             poi.input_processinstance
                         and (poi.operate_date ||
                             poi.operate_time) <
                             (ipoi.operate_date ||
                             ipoi.operate_time))) operate_info
        left join ws_v2_input_desc wid
          on operate_info.input_processinstance =
             wid.input_processinstance
        left join cnaec_taskdefinition ct
          on ct.td_id = operate_info.td_id
        left join (select ut.apptask_id,ut.module_id,ut.task_name,ut.appsend_uid,max(ut.send_time) as send_time,max(url) as url,ut.appreceive_uid   from ws_union_task ut where ut.task_type=2 group by ut.apptask_id,ut.module_id,ut.task_name,ut.appsend_uid,ut.appreceive_uid)
        wut on wut.apptask_id=wid.input_processinstance
        left join ws_user u on u.user_name=wut.appreceive_uid
       where input_finish_flag = 2)
union all
/*未接手超期*/
 (select distinct 
                  wid.input_processinstance,
                  wid.input_finish_flag,
                  ct.td_no_takeover_warn_days as warn_days,
                  case
                    when td_no_takeover_warn_days != 0 and
                         ((sysdate -
                         to_date(wut.send_time,
                                   'yyyy-MM-dd hh24:mi:ss')) -
                         td_no_takeover_warn_days) > 0 then
                     1
                    else
                     0
                  end as timeout,
                  to_date(wut.send_time, 'yyyy-MM-dd hh24:mi:ss') +
                  td_no_takeover_warn_days as timeout_date,
                  (sysdate -
                  to_date(wut.send_time, 'yyyy-MM-dd hh24:mi:ss')) -
                  td_no_takeover_warn_days as timeout_days,
                  
                  wut.url,
                      wut.task_name,
                      wut.module_id,
                      wut.send_time,
                      wut.appsend_uid,
                      '' as appreceive_uid
    from ws_v2_input_desc wid
    left join ws_input_node_user winu
      on wid.input_processinstance = winu.input_processinstance
    left join cnaec_taskdefinition ct
      on ct.td_id = winu.td_id
      left join (select ut.apptask_id,ut.module_id,ut.task_name,ut.appsend_uid,max(ut.send_time) as send_time,max(url) as url from ws_union_task ut where ut.task_type=3 group by ut.apptask_id,ut.module_id,ut.task_name,ut.appsend_uid)
        wut on wut.apptask_id=wid.input_processinstance
       where input_finish_flag=3))all_sql where all_sql.timeout=1 and all_sql.module_id is not null);

	   /*更新当前库脚本编号*/
 update ws_sys set par_value='121', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';