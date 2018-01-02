
--功能：记录数据库升级信息
--－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－ 
--说明：
--1、执行下面的SQL脚本，在ws_sys表中创建一条数据库升级记录
   insert into ws_sys(par_name, par_value, par_desc, common_modify_time)
   values('DB_VERSION', '75', '数据库版本记录', to_char(sysdate,'yyyy-MM-dd HH24:mi:ss'));
--2、以后在进行数据库修改时，在每个SQL脚本文件后添加如下语句，记录本次执行的脚本编号
 --  update ws_sys set par_value=[替换为本次脚本编号], common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
 --  where par_name='DB_VERSION';
--－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－ 
