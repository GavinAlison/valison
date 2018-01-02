/**将有公式的数据项设置为只读**/
update ws_dataitem t set t.read_only='readonly' where t.dataitem_formula is not null;
commit;