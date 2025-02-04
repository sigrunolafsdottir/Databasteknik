

create table blacklist
(id int not null auto_increment primary key,
oldId int not null,
firedDate datetime not null DEFAULT CURRENT_TIMESTAMP,
formerEmployeeName varchar(30) not null );


DELIMITER //
CREATE TRIGGER before_elf_delete 
    BEFORE DELETE ON elf
    FOR EACH ROW 
BEGIN
	INSERT INTO blacklist (oldId, formerEmployeeName) 
	values (OLD.id, OLD.name);
	
END//
DELIMITER ;