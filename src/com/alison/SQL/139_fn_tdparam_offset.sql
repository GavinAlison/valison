--节点list串偏移函数
CREATE OR REPLACE TYPE "TY_STR_SPLIT" 
IS TABLE OF VARCHAR2 (4000);


create or replace function tdparam_offset(td_param  in varchar2,
                                          t_offset  in number,
                                          d_offset  in number,
                                          di_offset in number)
  return varchar2 is
  str_split ty_str_split;
  t_split   ty_str_split;
  d_split   ty_str_split;
  t_str     varchar2(4000);
  Result    varchar2(32767);
begin
  --DBMS_OUTPUT.PUT_LINE('---------');
  --拆分每个list
  str_split := fn_split(td_param, ';');
  for i in 1 .. str_split.count loop
    if length(result) > 0 then
      Result := Result || ';';
    end if;
    --获取list=后面的东东
    t_str := fn_split(str_split(i), '=') (2);
    --DBMS_OUTPUT.PUT_LINE(t_str);
    --拆分 表 域 数据项
    t_split := fn_split(t_str, ',');
    --表
    Result := Result || 'list' || i || '=' || (t_split(1) + t_offset) || ',';
    --域
    --DBMS_OUTPUT.PUT_LINE(t_split(2)||'---------');
    if str_split.count = 3 then
      if t_split(2) = '0' then
        Result := Result || t_split(2);
      else
        d_split := fn_split(t_split(2), '-');
        for j in 1 .. d_split.count loop
          if j <> 1 then
            Result := Result || '-';
          end if;
          Result := Result || (d_split(j) + d_offset);
        end loop;
      end if;
      Result := Result || ',';
    end if;
    --数据项
    if str_split.count = 3 then
      d_split := fn_split(t_split(3), '-');
    else
      d_split := fn_split(t_split(2), '-');
    end if;
    for j in 1 .. d_split.count loop
      if j <> 1 then
        Result := Result || '-';
      end if;
      Result := Result || (d_split(j) + di_offset);
    end loop;
  end loop;
  --Result:=td_param;
  --DBMS_OUTPUT.PUT_LINE('---------');
  return(Result);
end tdparam_offset;
/
/*更新当前库脚本编号*/
 update ws_sys set par_value='139', common_modify_time=to_char(sysdate,'yyyy-MM-dd HH24:mi:ss')
   where par_name='DB_VERSION';
