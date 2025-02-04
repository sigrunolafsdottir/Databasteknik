

drop procedure if exists insertGift;
delimiter //
create procedure insertGift(in childName varchar(50), in presentName varchar(50))
begin
	declare presentId int default 0;
	declare childId int default 0;
	declare presentAmount int default -1;
	declare childAmount int default -1;
	
	-- set presentAmount = select count(id) from present where name like presentName;
	
	select count(id) from present where name like presentName into presentAmount;
	
	select count(id) from child where name like childName into childAmount;
	
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
end//
delimiter ;






delimiter //
create procedure insertGiftWithExists(in childName varchar(50), 
in presentName varchar(50))
begin
	declare presentId int default 0;
	declare childId int default 0;

	
	if EXISTS(SELECT * FROM child where name like childName) then
	
		if not EXISTS(SELECT * FROM present where name like presentName) then
			insert into present (name) values (presentName);
			SELECT LAST_INSERT_ID() INTO presentId;
		else	
			select id from present where name like presentname 
			limit 1 INTO presentId;
		end if;
		
		select id from child where name like childname limit 1 
			INTO childId;
		INSERT INTO gets (childId, presentId) VALUES (childId, presentId);

	end if;
end//
delimiter ;



