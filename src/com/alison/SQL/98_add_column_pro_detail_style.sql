/*流程表添加字段，存储详细表单展现的样式，默认为竖版*/
alter table cnaec_processdefinition add pro_detail_style number default 1;

/*更新当前库脚本编号*/
 update ws_sys set par_value='98', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION'; 
   commit
