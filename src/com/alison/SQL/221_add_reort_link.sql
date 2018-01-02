/**��ӵ������ϵ��**/
drop table ws_report_link;
create table ws_report_link
(
    id                    int not null,
    resource_rep_id       VARCHAR2(1024),
    resource_input_id     VARCHAR2(1024),
    target_rep_id         VARCHAR2(1024),
    target_input_id       VARCHAR2(1024),
    syn_param             VARCHAR2(4000)
 
)
/**�ֿ�ִ�д����������**/
create sequence SEQ_ws_report_link
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
nocache;

--�������ݿ�汾��
update ws_sys set par_value='221', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss') where par_name='DB_VERSION';
commit;
