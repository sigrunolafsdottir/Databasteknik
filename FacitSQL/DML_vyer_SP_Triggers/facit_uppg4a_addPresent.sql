
drop procedure addPresent;
delimiter //

create procedure addPresent(in presentName varchar(50))
begin
	insert into present (name) VALUES (presentName);
end//

delimiter ;

