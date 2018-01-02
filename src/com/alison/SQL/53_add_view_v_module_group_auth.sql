create or replace view v_module_group_auth as
select "ROWNUM",group_id,querying,creating,controlling,printing,exporting,modifying,module_id,data_scope,parent_module_id,module_name from(
select rownum as "ROWNUM",g.group_id,g.querying,g.creating,g.controlling,g.printing,g.exporting,g.modifying,m.module_id,g.data_scope ,m.parent_module_id,m.module_name
from ws_module_user_group g right join ws_module m on g.module_id=m.module_id
);

--����ͬ��� ���ڽ𺽼���ƽ̨�����ݿ���ʹ�� ��apps�û���¼ִ��
--create or replace synonym v_module_group_auth for iqs.v_module_group_auth ;
