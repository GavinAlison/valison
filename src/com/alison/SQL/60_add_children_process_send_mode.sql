/*添加列 会签子流程发送形式：send_mode 1为个人单发 0为部门内单发 默认为1*/
alter table CNAEC_TASK_CHILDREN_PROCESS add send_mode number default 1;
