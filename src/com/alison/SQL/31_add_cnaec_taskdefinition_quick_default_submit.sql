/*给流程节点添加快速提交和直接提交开关 0为不允许 1 为允许*/
alter table cnaec_taskdefinition add quick_submit number;
alter table cnaec_taskdefinition add default_submit number;
/*处理旧数据 默认为不允许*/
update cnaec_taskdefinition t set t.quick_submit=0,t.default_submit=0;
