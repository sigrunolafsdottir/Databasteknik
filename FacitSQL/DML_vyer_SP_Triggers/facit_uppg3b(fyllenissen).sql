
DELIMITER //
CREATE TRIGGER after_gets_insert
    BEFORE INSERT ON gets
    FOR EACH ROW 
BEGIN
	IF (SELECT COUNT(*) 
		FROM wishes 
		WHERE childId = NEW.childId 
		AND presentId = NEW.presentId) = 0 THEN
	
		INSERT INTO wishes (priority, childId, presentId) 
		values (1, NEW.childId, NEW.presentId);
	end if;
END//

DELIMITER ;

