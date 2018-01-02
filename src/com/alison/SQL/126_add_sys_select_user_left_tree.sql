/*流程提交框左侧的部门树、角色树等做成开关 默认都有 值为dept-role-group-relation 可以根据需求做删减*/
insert into ws_sys (PAR_NAME,PAR_VALUE,PAR_DESC) values('PRO_SELECT_USER_LEFT_TREE','dept-role-group-relation','流程提交框左侧的树的显示（dept role group relation 分别代表部门 角色 系统用户分组 用户关系,用-分隔）');

/*更新当前库脚本编号*/
 update ws_sys set par_value='126', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
