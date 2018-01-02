create or replace view v_caaw_method_base as
select a.id                   as validation_requirement_id,
       a.requirement_id,
       a.requirement_title,
       a.ata_id,
       a.ata_title,
       a.validation_status,
       a.validation_statement,
       a.requirement_charger,
       nvl(b.rule_title,a.rule_title) rule_title,
       nvl(b.part_no,a.requirement_title) part_no,
       c.method_no,
       c.method_title,
       --c.plan_id              as s,
       d.id                   as plan_id,
       a.orderby as orderby
  from caaw_validation_requirement a
  left join caaw_rule b
    on a.requirement_id = b.id
  left join caaw_validate_plan d
  --  on d.validation_id = a.validation_id
  on d.id=a.plan_id
  left join (select q.plan_id,
                    q.validation_requirement_id,
                    wm_concat(w.id) as method_no,
                    wm_concat(w.method_no) as method_title
               from Caaw_Valiation_Method q
               left join caaw_method_compliance w
                 on q.method_id = w.id
              group by q.plan_id, q.validation_requirement_id) c
    on c.validation_requirement_id = a.id
    and c.plan_id = d.id
 order by ata_title;
