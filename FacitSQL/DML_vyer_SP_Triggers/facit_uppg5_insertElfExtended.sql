drop procedure insertElfExtended;
delimiter //
create procedure insertElfExtended(in elfName varchar(50), in securityClass int)
begin
	declare lastId int default 0;
	
	INSERT INTO elf (name) VALUES (elfName);

    SELECT LAST_INSERT_ID() INTO lastId;

	if (securityClass is null) then
		insert into makerelf (elfId) VALUES (lastId);
	else 
		insert into intelligenceElf(elfId, securityLevel) 
		VALUES (lastId, securityClass);
	end if;
end//
delimiter ;



