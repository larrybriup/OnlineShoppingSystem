create table t_user(
	id number(16) primary key,
	name varchar2(32) unique not null,
	password varchar2(25),
	age number(4)
);
create table person(
	id number primary key,
	name varchar2(12) unique not null,
	age number(4)
);
create sequence t_user_id_sequence
	increment by 1
	start with 1;
	
insert into t_user(id,name,password,age) 
	values(1,'choda',123,23);
	
drop table t_user;
drop table person;
drop sequence t_user_id_sequence;