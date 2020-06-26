#1.查看所有用户
select * from dba_users;
select * from all_users;
select * from user_users;
#2.查看用户或角色系统权限(直接赋值给用户或角色的系统权限)
select * from dba_sys_privs;
select * from user_sys_privs;
#3.查看角色(只能查看登陆用户拥有的角色)所包含的权限
select * from role_sys_privs;
#4.查看用户对象权限
select * from dba_tab_privs;
select * from all_tab_privs;
select * from user_tab_privs;
#5.查看所有角色
select * from dba_roles;
#6.查看用户或角色所拥有的角色
select * from dba_role_privs;
select * from user_role_privs;
#7.查看哪些用户有sysdba或sysoper系统权限(查询时需要相应权限)
select * from V$PWFILE_USERS
#8.SqlPlus中查看一个用户所拥有权限
select * from dba_sys_privs where grantee = 'USERNAME(大写)';
#9.Oracle删除指定用户所有表的方法
select 'Drop table ' || table_name || ';' from all_tables where owner = '要删除的用户名(注意要大写)';
#10.删除用户
drop user user_name cascade;
#11.获取当前用户下所有的表
select table_name from user_tables;
#12.删除某用户下所有的表数据:
select 'truncate table  ' || table_name from user_tables;
#13.禁止外键
启用外键约束的命令为
alter table table_name enable constraint constraint_name
禁用外键约束的命令为
alter table table_name disable constraint constraint_name
SQL查询外键的约束名,constraint_type='R'表示是外键约束
select 'alter table ' || table_name || ' enable constraint ' || constraint_name || ';' from user_constraints
where constraint_type = 'R'
select 'alter table ' || table_name || ' disable constraint ' || constraint_name || ';' from user_constraints
where constraint_type = 'R'
#优化
#1.SELECT子句中避免使用'*',用具体的字段列表代替"*"
#2.减少访问数据库的次数
#3.删除重复记录
#4.用TRUNCATE替代DELETE
#5.用Where子句替换HAVING子句
#6.
#7.用EXISTS替换DISTINCT
#8.用索引提高效率
#9.sql语句用大写的
#10.用>=替代>
#11.用UNION替换OR(适用于索引列),避免在where子句中使用or来连接条件
#12.避免在索引列上使用ISNULL和ISNOTNULL
#13.不要在列上进行运算,in和notin也要慎用,否则会导致全表扫描,用EXISTS替代IN
#14.避免在where子句中使用<>||+操作符,否则会导致全表扫描
#15.带有DISTINCT,UNION,MINUS,INTERSECT,ORDERBY的SQL语句会启动SQL引擎
#16.不需要的记录在GROUPBY之前过滤掉
#17.where及orderby涉及的列上建立索引,避免全表扫描
#18.避免在where子句中对字段进行null值判断
