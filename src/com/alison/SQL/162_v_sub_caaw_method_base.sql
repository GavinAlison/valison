create or replace view v_caaw_sub_method_base as
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
       d.id                   as plan_id
  from caaw_validation_requirement a left join caaw_sub_plan_requirement r on a.id=r.requirement_id
  left join caaw_rule b
    on a.requirement_id = b.id
  left join caaw_validate_plan d
  on d.id=r.plan_id
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
