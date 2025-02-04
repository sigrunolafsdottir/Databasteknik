

drop procedure addManufacturingElf;
delimiter //
create procedure addManufacturingElf(in elfName varchar(50))
begin
	declare lastId int default 0;
	
	insert into elf (name) VALUES (elfName);
    SELECT LAST_INSERT_ID() INTO lastId;
	insert into makerelf (elfId) VALUES (lastId);
end//
delimiter ;



drop procedure addManufacturingElf2;
delimiter //
create procedure addManufacturingElf2(in elfName varchar(50))
begin
	insert into elf (name) VALUES (elfName);
	insert into makerelf (elfId) VALUES (LAST_INSERT_ID());
end//
delimiter ;


