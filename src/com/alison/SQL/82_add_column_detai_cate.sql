/*给报表定义添加字段 用来存储详细类型 暂时只用于知识库的表单*/
alter table ws_rep_table add detail_cate varchar2(2000);

/*更新当前库脚本编号*/
 update ws_sys set par_value='82', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';