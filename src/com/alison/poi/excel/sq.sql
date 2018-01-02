merge into pms_assembly t using (
        select d.id,a.match_type,b.modifyer_id,b.modifyer_name,b.modify_time,b.current_workshop_id,b.batch_id,b.item_rec_id assembly_rec_id,b.item_code assembly_code
        ,a.item_rec_id,c.item_id,c.item_name,c.item_code,c.part_mode,nvl(a.match_amount,0)+nvl(a.spare_amount,0) match_amount
        ,b.ration_amount*nvl(d.match_amount,(nvl(a.match_amount,0)+nvl(a.spare_amount,0))) ration_amount
        from pms_item_bom a inner join pms_batch b on b.item_rec_id=a.parent_item_rec_id inner join pms_item c on c.id=a.item_rec_id
        left join pms_assembly d on d.batch_id=b.batch_id and d.item_rec_id=a.item_rec_id
        where b.batch_id= '402017050001' order by a.match_type,c.item_id
      ) s on (s.id=t.id   )  
      when matched then
        update set ration_amount=s.ration_amount
      when not matched then
        insert values(seq_pms_assembly.nextval,1,s.match_type,'','',s.modifyer_id,s.modifyer_name,s.modify_time,s.modifyer_id,s.modifyer_name,s.modify_time,s.current_workshop_id,'','','','',''
        ,s.batch_id,s.assembly_rec_id,s.assembly_code,s.item_rec_id,s.item_id,s.item_name,s.item_code,s.part_mode,s.match_amount,s.ration_amount,'')
    

/* */
select * from pms_assembly where batch_id = '402017050001';
