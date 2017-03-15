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

7.查看所有表
show tables;
show tables like '%ta%';
8.查看某张表结构
desc samp_table;
show create table samp_table;
9.创建表
create table if not exists samp_table (id int primary key,name varchar(20));
11.删除表
drop table samp_table
12.修改表
alter table samp_table change column id table_id int auto_increment,
change column name name varchar(40),
add column gender enum('male','female');

rename table samp_table to my_table;

mysql 数据类型

13.插入记录
insert into my_table values(1,'001','male');
insert into my_table (name,gender) values('002','female'),('003','female');
14.删除记录
delete from my_table where name = '001';
15.修改记录
update my_table set gender='male' where table_id>6;
16.查询记录
select table_id,name from my_table order by name;//排序
select * from my_table limit 0,10;


添加索引
添加主键
...



查询记录

条件查询

分组查询

关联查询 左右内外

主外键

索引（唯一索引，组合索引）

引擎

用户权限