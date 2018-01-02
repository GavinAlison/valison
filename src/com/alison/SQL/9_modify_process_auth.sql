--为旧系统批量增加流程类模块的创建和打印权限

update ws_module_user_group set creating=1,printing=1
where module_id in(select module_id from ws_module where childrentree_class='com.avicinfo.process.tree.impl.ProcessNodeJsonTreeImpl');
update ws_module_user set creating=1,printing=1
where module_id in(select module_id from ws_module where childrentree_class='com.avicinfo.process.tree.impl.ProcessNodeJsonTreeImpl');
commit;
