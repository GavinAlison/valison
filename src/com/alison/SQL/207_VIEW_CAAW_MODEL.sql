/*型别表 对应的单表 对不上的为''*/
CREATE OR REPLACE VIEW CAAW_MODEL AS
SELECT input_id as id,d2568 as PLANE_ID, d2570 as PLANE_NAME,
d2572 as model_NAME,
d2574 as three_face_graph,
d2576 as maximum_take_off_weight,
d2578 maximum_number_of_passengers,
d2580 as flight_rules,
d2736 as operation_type,
d2584 as engine_type,
d2588 as related_authorization,
d2590 as remarks,
d3868 as equipment_user_id,
d3866 as equipment_user_name,
d2586 as other,
t.common_orderby as orderby,
t.common_remark as remark,
t.common_author_id as author_Id,
t.common_author_id as author_name,
t.common_modifyer_name as MODIFYER_NAME,
t.common_modify_time as MODIFY_TIME,
t.common_data_scope_id as DATA_SCOPE_ID,
t.common_record_status as RECORD_STATUS,
t.common_display as DISPLAY,
t.common_extend_1 as EXTEND_1,
t.common_extend_2 as EXTEND_2,
'' as version,
'' as history,
'' as AUTHOR_TIME,
'' as MODIFYER_ID,
'' as SHEET_ACCESSORIES,
'' as model_id,
'' as model_code,
'' as model_type,
'' as model_version,
t.common_year_on as YEAR_ON,
t.common_month_on as MONTH_ON
 FROM WS_REPORT_INPUT_DESC_524 t;

/*更新当前库脚本编号*/
 update ws_sys set par_value='207', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';

commit;
