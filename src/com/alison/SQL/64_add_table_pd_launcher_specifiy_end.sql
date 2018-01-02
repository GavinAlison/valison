/*在流程表中新增字段：launcher_end  发起人是否可终止 specifiy_end 全部节点处理人是否可终止 1为是0为否*/
alter table CNAEC_PROCESSDEFINITION add launcher_end INTEGER default 0;
alter table CNAEC_PROCESSDEFINITION add specifiy_end INTEGER default 0;
