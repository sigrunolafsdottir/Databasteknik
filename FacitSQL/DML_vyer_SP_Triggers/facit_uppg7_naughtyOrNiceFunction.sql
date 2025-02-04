
drop function if exists getNaughtyOrNiceById;
DELIMITER //
CREATE FUNCTION `getNaughtyOrNiceById`(childId int) RETURNS varchar(20)
BEGIN

declare naughtyOrNice varchar(50) default '';
select 
	case when report.nicenumber >= 2 then 'Nice'
		when report.nicenumber < 2 then 'Naughty'
	end 
    from child
	inner join report 
	on report.childId = child.id
	where child.id = childId
    into naughtyOrNice;

RETURN naughtyOrNice;
END//
DELIMITER ;


drop view if exists naughtyOrNiceCallingFunction;
create view naughtyOrNiceCallingFunction as
select name, getNaughtyOrNiceById(child.id) as NaughtyOrNice
    from child
inner join report 
on report.childId = child.id;



create view naughtyOrNiceHigherClassCallingFunction as
select child.name as Name, address as Address, country.name as Country,
	getNaughtyOrNiceById(child.id) as NaughtyOrNice
    from child
inner join report on report.childId = child.id
inner join country on country.id = child.countryId;