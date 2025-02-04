DELIMITER //
CREATE TRIGGER after_gets_insert
    AFTER INSERT ON gets
    FOR EACH ROW 
BEGIN
	IF (SELECT COUNT(*) 
	FROM wishes 
	where child.id = OLD.childId AND presentId = OLD.presentId) = 0 THEN
	
	INSERT INTO wishes (childId, presentId) values (OLD.childId, OLD.presentId);
	
END//
DELIMITER ;


