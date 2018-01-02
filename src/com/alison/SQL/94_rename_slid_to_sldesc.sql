--rename columns
ALTER TABLE ws_doc_info rename   column  SL_ID to SL_DESC;
ALTER TABLE ws_manage_doc_info rename   column  SL_ID to SL_DESC;
--update history data
update ws_doc_info t set t.sl_desc=(select sl_desc from ws_sl t2 where t2.sl_id=t.sl_desc);
update ws_manage_doc_info t set t.sl_desc=(select sl_desc from ws_sl t2 where t2.sl_id=t.sl_desc);
--update db version
update ws_sys set par_value='94', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')  where par_name='DB_VERSION';
commit;
