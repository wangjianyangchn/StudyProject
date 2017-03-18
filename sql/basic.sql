1.链接数据库
mysql -h localhost -P 3306 -u root -p
2.查看数据库
show  databases;
3.创建数据库
create database samp_db character set utf-8;
create database if not exists samp_db default charset utf8 collate utf8_general_ci;
4.删除数据库
drop database samp_db;
5.修改数据库
alter database samp_db character set utf-8;
rename database samp_db to mydatabase;//5.1.23版本后丢弃
6.使用数据库
use samp_db;

编码集
show variables like 'character%' 
– character_set_server：默认的内部操作字符集
– character_set_client：客户端来源数据使用的字符集
– character_set_connection：连接层字符集
– character_set_results：查询结果字符集
– character_set_database：当前选中数据库的默认字符集
– character_set_system：系统元数据(字段名等)字符集

7.查看所有表
show tables;
show tables like '%ta%';
8.查看某张表结构
desc samp_table;
show create table samp_table;
9.创建表
create table if not exists samp_table (id int primary key,name varchar(20));

mysql 数据类型

11.删除表
drop table samp_table
12.修改表
alter table samp_table change column id table_id int auto_increment,
change column name name varchar(40),
add column gender enum('male','female');

rename table samp_table to my_table;
13.插入记录
insert into my_table values(1,'001','male');
insert into my_table (name,gender) values('002','female'),('003','female');
14.删除记录
delete from my_table where name = '001';
15.修改记录
update my_table set gender='male' where table_id>6;
16.查询记录
select * from my_table limit 0,10;
条件查询
select * from stu where id =1;
分组查询
select cid,count(cid) from stu group by cid with rollup;
select cid,count(cid) from stu group by cid with rollup having cid is not NULL;
排序
select table_id,name from my_table order by name asc;//default
select table_id,name from my_table order by name desc;
关联查询 左右内外
inner join 
select stu.*,cla.* from stu join cla on stu.cid=cla.id;
select stu.*,cla.* from stu inner join cla on stu.cid=cla.id;

outer join  
	right join
	select stu.*,cla.* from stu right outer join cla on stu.cid=cla.id;
	select stu.*,cla.* from stu right join cla on stu.cid=cla.id;
	left join
	select stu.*,cla.* from stu left outer join cla on stu.cid=cla.id;
	select stu.*,cla.* from stu left outer join cla on stu.cid=cla.id;
	full join
	select stu.*,cla.* from stu left outer join cla on stu.cid=cla.id union 
	select stu.*,cla.* from stu right outer join cla on stu.cid=cla.id;//mysql not support full join
cross join
	select * from stu,cla;
	select * from stu cross join cla;


添加主键

union
select country from Websites
union
select country from apps;

select country from Websites
union all
select country from apps;

null
is null
is not null

like
select * from stu where name like '%rose' or 'rose%';

主外键

索引（唯一索引，组合索引）
create index index1 on stu (id);
alter table stu add index index_id(id);
alter table stu drop index index1;

create unique index index1 on stu (id);
alter table stu add unique index_id(id);
