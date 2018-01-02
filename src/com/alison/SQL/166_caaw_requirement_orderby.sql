/*符合性检查清单 树的排序字段不能为空 赋默认值为9999*/
update caaw_validation_requirement t set t.orderby='9999' where t.orderby is null;



