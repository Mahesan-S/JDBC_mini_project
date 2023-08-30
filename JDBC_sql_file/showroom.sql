create database showroom;
use showroom;
create table mobile(
serail_no int primary key,
mname varchar(30),
version double,
price int,
stocks int
);
insert into mobile values (1,"realme",12.3,250000,2);
insert into mobile values (2,"vivo",11.2,10000,15);
insert into mobile values (3,"redmi",13.5,11000,25);
insert into mobile values (4,"iphone",16.11,1149000,1);

select price from mobile where serail_no = 2 and mname = "vivo";
select * from mobile;

drop table  customer;

create table customer(
no_of_customer int primary key auto_increment ,
serail_no int,
mname varchar(20),
customername varchar(40),
bankname varchar(20),
paid varchar(10),
mobile_no int,
account_no int,
addar_no int
);

select count(serail_no) from customer where serail_no = 2;
select count(*) from customer;
select * from customer;