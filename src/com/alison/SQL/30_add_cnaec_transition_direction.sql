/**流程出口分为正向和反向，0代表反向，1代表正向**/
alter table cnaec_transition  add direction number;
/**处理旧数据，默认为正方向，请根据需要在节点出口中手动修改**/
update cnaec_transition t set t.direction=1 ;