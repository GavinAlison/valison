CREATE OR REPLACE FUNCTION fn_querystr(in_str       In Varchar2,
                                      in_key       varchar2,
                                      in_separator In Varchar2)
  RETURN varchar2 as
  v_keyindex Number := 0;
  v_sepindex number := 0;
  v_str      varchar2(32767);
begin
  /*
  从url中获取参数的值
  */
  v_str := in_str;
  IF in_str IS NOT NULL and in_key is not null AND in_separator IS NOT NULL and
     instr(v_str, in_key) <> 0 THEN
    if instr(v_str, in_key) <> 0 then
      v_keyindex := instr(v_str, in_key) + length(in_key) + 1; --KEY的长度加上等号的长度
    end if;
  
    --if in_key='cururl' then --特殊处理
    --  if instr(v_str,'ref',v_keyindex-1)<>0 then
    --     v_sepindex:=instr(v_str,'ref',v_keyindex-1)-1;
    --  else
    --    v_sepindex:=length(v_str)+1;
    -- end if;
    --els
    --if in_key<>'ref' then --特殊处理
    if instr(v_str, in_separator, v_keyindex - 1) <> 0 then
      v_sepindex := instr(v_str, in_separator, v_keyindex - 1);
    else
      v_sepindex := length(v_str) + 1;
    end if;
    -- else
    --    v_sepindex:=length(v_str)+1;
    -- end if;
  
    if v_keyindex = v_sepindex then
      return '';
    else
      -- if in_key='hot' then
      --  v_str:=substr(v_str,v_keyindex,v_sepindex-v_keyindex);
      --   v_sepindex:=instr(v_str,'_',1);
      --  if v_sepindex>0 then
      --     return substr(v_str,0,v_sepindex-1);
      --  else
      --     return v_str;
      --  end if;
      -- else
      return substr(v_str, v_keyindex, v_sepindex - v_keyindex);
      -- end if;
    end if;
  END IF;
  return '';
end;
