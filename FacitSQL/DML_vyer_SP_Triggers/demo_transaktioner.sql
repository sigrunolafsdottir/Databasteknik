set autocommit = 0;

start transaction;

insert into country (name) values
('South Africa');

insert into child (name, address, countryId, nice) values
('Sixten','Cape Town', LAST_INSERTED_ID(), 1);

rollback;
-- commit;

set autocommit = 1;