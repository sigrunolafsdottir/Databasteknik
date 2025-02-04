drop database if exists tomtedatabaseDemo2;
create database tomtedatabaseDemo2;
use tomtedatabaseDemo2;

create table country
(id int not null auto_increment primary key,
name varchar(30) not null,
created timestamp DEFAULT CURRENT_TIMESTAMP,
updated timestamp default null ON UPDATE CURRENT_TIMESTAMP,
unique(name));

create table present
(id int not null auto_increment primary key,
name varchar(50) not null,
created timestamp default CURRENT_TIMESTAMP,
updated timestamp default 0 ON UPDATE CURRENT_TIMESTAMP);

create table child
(id int not null auto_increment primary key,
name varchar(30) not null,
address varchar(30) not null,
countryId int not null,
nice boolean not null,
created timestamp default CURRENT_TIMESTAMP,
updated timestamp default 0 ON UPDATE CURRENT_TIMESTAMP,
foreign key (countryId) references country(id));

create table wishes
(id int not null auto_increment primary key,
priority int not null,
childId int not null,
presentId int not null,
created timestamp default CURRENT_TIMESTAMP,
updated timestamp default 0 ON UPDATE CURRENT_TIMESTAMP,
foreign key (childId) references child(id),
foreign key (presentId) references present(id));

create table gets
(id int not null auto_increment primary key,
childId int not null,
presentId int not null,
created timestamp default CURRENT_TIMESTAMP,
updated timestamp default 0 ON UPDATE CURRENT_TIMESTAMP,
foreign key (childId) references child(id),
foreign key (presentId) references present(id));