/**加系统开关，包括发布人的删除功能和信息贴的翻页功能**/

delete from ws_sys where par_name='TOPIC_DELETE' or par_name='REPLY_DELETE' or par_name='TOP_PAGE';
insert into ws_sys (par_name,par_value,par_desc)values('TOPIC_DELETE','no','发布人可删除主题');
insert into ws_sys (par_name,par_value,par_desc)values('REPLY_DELETE','no','发布人可删除回复');
insert into ws_sys (par_name,par_value,par_desc)values('TOP_PAGE','yes','信息贴顶部有翻页');
