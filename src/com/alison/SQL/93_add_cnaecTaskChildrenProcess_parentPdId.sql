alter table cnaec_task_children_process  add  parent_pd_id INTEGER;

alter table CNAEC_TASK_CHILDREN_PROCESS
  add constraint FK_CNAEC_TA_RELATIONS_CNAEC_P foreign key (PARENT_PD_ID)
  references CNAEC_PROCESSDEFINITION (PD_ID);
  
update cnaec_task_children_process t1
   set t1.parent_pd_id =
       (select t2.pd_id
          from cnaec_taskdefinition t2
         where t1.td_id = t2.td_id);
         
update ws_sys set par_value='93', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')  where par_name='DB_VERSION';

commit;
