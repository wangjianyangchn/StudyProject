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

alter table samp_table drop gender;

rename table samp_table to my_table;

mysql 数据类型

13.插入记录
insert into my_table values(1,'001','male');
insert into my_table (name,gender) values('002','female'),('003','female');
14.删除记录
delete from my_table where name = '001';
truncate my_table;

delete 逐条删除
truncate 删除表后重建表

15.修改记录
update my_table set gender='male' where table_id>6;
16.查询记录
select table_id,name from my_table order by name;
select * from my_table limit 0,10;
select * from my_table where id > 6;
select distinct english from student;
select name,math from student where math in(89,90,91);
select name,english+chinese+math as sum from student;
select sum(math) from student;

select * from department,employee;//笛卡尔集
select * from department,employee where employee.departmentid=department.id;

函数
select sum(math) from student;
select avg(chinese) from student;
select max(chinese) from student;//min
select count(*) from student;

约束
create table users
(
id int primary key auto_increment=10, //主键
username varchar(20) unique,//唯一
password varchar(20) not null,//非空
pid int,
constraint pid_FK foreign key(pid) references partment(id)//外键
)auto_increment=10;//自增

alter table users add primary key(id);
alter table users drop primary key;
alter table users auto_increment=100;



分组查询

关联查询 左右内外


索引（唯一索引，组合索引）

引擎

用户权限

SQL 注入