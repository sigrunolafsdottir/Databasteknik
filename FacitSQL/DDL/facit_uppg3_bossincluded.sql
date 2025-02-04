drop database if exists bigtomtedatabase;
create database bigtomtedatabase;
use bigtomtedatabase;

create table elf
(id int not null auto_increment primary key,
name varchar(30) not null , 
bosselfId int,
foreign key (bosselfId) references elf(id) on delete set null);

create table intelligenceelf
(id int not null auto_increment primary key,
elfId int not null,
securityLevel int not null,
foreign key (elfId) references elf(id) on delete cascade,
unique(elfId));

create table makerelf
(id int not null auto_increment primary key,
elfId int not null,
foreign key (elfId) references elf(id) on delete cascade,
unique(elfId));

create table bosself
(id int not null auto_increment primary key,
elfId int not null,
foreign key (elfId) references elf(id) on delete cascade,
unique(elfId));

create table country
(id int not null auto_increment primary key,
name varchar(30) not null,
accountableIntelligenceElfId int,
unique(name),
foreign key (accountableIntelligenceElfId) references intelligenceelf(id) on delete set null);

create table child
(id int not null auto_increment primary key,
name varchar(30) not null,
address varchar(30) not null,
countryId int not null,
accountableIntelligenceElfId int,
foreign key (countryId) references country(id),
foreign key (accountableIntelligenceElfId) references intelligenceelf(id) on delete set null);

create table present
(id int not null auto_increment primary key,
accountableMakerElfId int,
name varchar(50) not null,
foreign key (accountableMakerElfId) references makerelf(id) on delete set null);

create table wishes
(id int not null auto_increment primary key,
priority int not null,
childId int not null,
presentId int not null,
foreign key (childId) references child(id) on delete cascade,
foreign key (presentId) references present(id));

create table gets
(id int not null auto_increment primary key,
childId int not null,
presentId int,
foreign key (childId) references child(id) on delete cascade,
foreign key (presentId) references present(id) on delete set null);

create table report
(id int not null auto_increment primary key,
niceNumber int not null,
childId int not null,
reporterId int,
reviewerId int,
reportDate date not null,
foreign key (childId) references child(id) on delete cascade,
foreign key (reporterId) references intelligenceelf(id) on delete set null,
foreign key (reviewerId) references intelligenceelf(id) on delete set null);

insert into elf (name, bosselfId)  values
('Santa', null), ('Glader', 1),('Toker', 1),('Trotter', 1),('Prosit', 1),('Butter', 1)
,('Glader', 1),('Blyger', 1),('Blyger', 1),('Skumtomten', 2);

insert into intelligenceelf (elfId, securityLevel)  values
(1, 1), (2, 2),(3, 3),(4, 3);

insert into makerelf (elfId)  values
(5),(6),(7),(8),(9);

insert into country (name, accountableIntelligenceElfId) values
('Sweden', 1),('Iceland', 1),('England', 1),('France', 1),('USA', 1);

insert into present (name, accountableMakerElfId) values
('phone', 1),('laptop', 1),('doll', 2),('car', 3),('book', 4),
('pencils', 4),('skateboard', 3),('ball', 2),('cat', 5),('socks', 4);

insert into child (name, address, countryId, accountableIntelligenceElfId) values
('Ambrosia','Globen', 1, 4),
('Bertil','Stadshuset', 1, 4),
('Camelia','Perlan', 2, 4),
('Doris','Big Ben', 3, 4),
('Efraim','Madame Tusseaus', 3, 4),
('Finnegan','Eiffel Tower', 4, 4),
('Greger','White House', 5, 4),
('Hulken','Empire State Building', 5, 4);


insert into wishes (priority, childId, presentId) values
(1,1,4),(2,1,9),(1,2,9),(1,3,6),(2,3,7),(3,3,8),
(1,4,9),(1,5,4),(1,6,2),(1,7,2),(2,7,1),(3,7,5);

insert into gets (childId, presentId) values
(1,4),(2,9),(3,6),(4,9),(5,10),(6,2),(7,5);

insert into report (niceNumber, childId, reporterId, reviewerId, reportDate) values
(1,1,3,2, '2017-12-14'),(2,2,3,2, '2017-12-18'),
(1,3,3,2, '2017-12-16'),(2,4,3,2, '2017-12-21'),
(3,5,3,2, '2017-12-13'),(5,6,3,2, '2017-12-19'),
(1,7,3,2, '2017-12-14'),(2,8,3,2, '2017-12-13');


