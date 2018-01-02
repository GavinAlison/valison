alter table  cnaec_transition  add(opinion_necessary varchar2(200));
update ws_sys set par_value='214', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
   
commit;
