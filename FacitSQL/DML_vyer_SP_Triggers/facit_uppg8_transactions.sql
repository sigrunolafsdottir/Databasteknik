
drop procedure addManufacturingElf;
delimiter //
create procedure addManufacturingElf(in elfName varchar(50))
begin
	declare lastId int default 0;
    
	DECLARE EXIT HANDLER FOR SQLEXCEPTION 
    BEGIN
          ROLLBACK;
          select ('SQLEXCEPTION occurred, rollback done') as error;
    END;
	
	DECLARE EXIT HANDLER FOR SQLWARNING
    BEGIN
          ROLLBACK;
          select ('SQLWARNING occurred, rollback done') as error;
    END;
    
 	DECLARE EXIT HANDLER FOR 1062
 	begin
 		ROLLBACK;
 	 	select ('unique constraint broken, rollback done') as error;
 	END;
	
    start transaction;

		insert into elf (name) VALUES (elfName);
		SELECT LAST_INSERT_ID() INTO lastId;
		insert into makerelf (elfId) VALUES (lastId);
	commit;
end//
delimiter ;



drop procedure insertElfExtended;
delimiter //
create procedure insertElfExtended(in elfName varchar(50), in securityClass int)
begin
	declare lastId int default 0;
	
	DECLARE EXIT HANDLER FOR SQLEXCEPTION 
    BEGIN
          ROLLBACK;
          select ('SQLEXCEPTION occurred, rollback done');
    END;
    
    DECLARE EXIT HANDLER FOR SQLWARNING 
    BEGIN
          ROLLBACK;
          select ('SQLWARNING occurred, rollback done');
    END;
    
	DECLARE EXIT HANDLER FOR 1062
	begin
		ROLLBACK;
	 	select ('unique constraint broken, rollback done') as error;
	END;
	
	start transaction;
		INSERT INTO elf (name) VALUES (elfName);

		SELECT LAST_INSERT_ID() INTO lastId;

		if (securityClass is null) then
			insert into makerelf (elfId) VALUES (lastId);
		else 
			insert into intelligenceElf(elfId, securityLevel) VALUES (lastId, securityClass);
		end if;
	commit;
end//
delimiter ;


drop procedure if exists insertGift;
DELIMITER $$
CREATE PROCEDURE insertGift(in childName varchar(50), in presentName varchar(50))
begin

	declare presentId int default 0;
	declare childId int default 0;
	declare presentAmount int default -1;
	declare childAmount int default -1;
	
	DECLARE EXIT HANDLER FOR SQLEXCEPTION 
    BEGIN
          ROLLBACK;
          select ('SQLEXCEPTION occurred, rollback done');
    END;
    
    DECLARE EXIT HANDLER FOR SQLWARNING 
    BEGIN
          ROLLBACK;
          select ('SQLWARNING occurred, rollback done');
    END;
    
	DECLARE EXIT HANDLER FOR 1062
	begin
		ROLLBACK;
	 	select ('constraint broken, rollback done') as error;
	END;
	
	select count(id) from present where name like presentName into presentAmount;
	select count(id) from child where name like childName into childAmount;
    
    start transaction;
	
		if childAmount > 0 then
		
			if presentAmount = 0 then
				insert into present (name) values (presentName);
				SELECT LAST_INSERT_ID() INTO presentId;
			else	
				select id from present where name like presentname limit 1 INTO presentId;
			end if;
			
			select id from child where name like childname limit 1 INTO childId;
			INSERT INTO gets (childId, presentId) VALUES (childId, presentId);

		end if;
    commit;
end$$
DELIMITER ;





drop procedure if exists insertGiftWithSignal;
DELIMITER $$
CREATE PROCEDURE insertGiftWithSignal(in childName varchar(50), in presentName varchar(50))
begin

	declare presentId int default 0;
	declare childId int default 0;
	declare presentAmount int default -1;
	declare childAmount int default -1;
	
	DECLARE EXIT HANDLER FOR SQLEXCEPTION 
    BEGIN
          ROLLBACK;
          -- select ('SQLEXCEPTION occurred, rollback done');
		 RESIGNAL SET MESSAGE_TEXT = 'THere is no child in database with this name';
    END;
    
    DECLARE EXIT HANDLER FOR SQLWARNING 
    BEGIN
          ROLLBACK;
          select ('SQLWARNING occurred, rollback done');
    END;
    
	DECLARE EXIT HANDLER FOR 1062
	begin
		ROLLBACK;
	 	select ('constraint broken, rollback done') as error;
	END;
	
	
	select count(id) from present where name like presentName into presentAmount;
	select count(id) from child where name like childName into childAmount;
    
    start transaction;
	
		if childAmount > 0 then
		
			if presentAmount = 0 then
				insert into present (name) values (presentName);
				SELECT LAST_INSERT_ID() INTO presentId;
			else	
				select id from present where name like presentname limit 1 INTO presentId;
			end if;
			
			select id from child where name like childname limit 1 INTO childId;
			INSERT INTO gets (childId, presentId) VALUES (childId, presentId);

		else
			  SIGNAL SQLSTATE '45000';
		end if;
    commit;
end$$
DELIMITER ;