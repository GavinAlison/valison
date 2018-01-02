alter table cnaec_task_children_process add out_id Integer default 0 not null;
alter table cnaec_task_children_process add process_type varchar2(10);
alter table ws_process_link add process_type varchar2(10);
update cnaec_task_children_process set process_type = 0;
update ws_process_link set process_type = 0;



/*更新当前库脚本编号*/
 update ws_sys set par_value='91', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';

   
   
   
   commit;