insert into country (name) values
('Sweden'),('Iceland'),('England'),('France'),('USA');

insert into present (name) values
('phone'),('laptop'),('doll'),('car'),('book'),
('pencils'),('skateboard'),('ball'),('cat'),('socks');

insert into child (name, address, countryId, nice) values
('Ambrosia','Globen', 1, 1),
('Bertil','Stadshuset', 1, 1),
('Camelia','Perlan', 2, 1),
('Doris','Big Ben', 3, 1),
('Efraim','Madame Tusseaus', 3, 0),
('Finnegan','Eiffel Tower', 4, 1),
('Greger','White House', 5, 1),
('Hulken','Empire State Building', 5, 0);

insert into wishes (priority, childId, presentId) values
(1,1,4),(2,1,9),(1,2,9),(1,3,6),(2,3,7),(3,3,8),
(1,4,9),(1,5,4),(1,6,2),(1,7,2),(2,7,1),(3,7,5);

insert into gets (childId, presentId) values
(1,4),(2,4),(2,9),(3,6),(4,9),(5,10),(6,2),(7,5);


