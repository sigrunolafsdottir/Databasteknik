
create view niceKids as
select name, address from child
inner join report 
on report.childId = child.id
 where report.niceNumber >= 2;
 
 
create view Present_Top5 as 
select present.name, count(present.name) as count from present
inner join wishes
on wishes.presentId = present.id
group by present.name
order by count desc
limit 5;


create view allPresents as 
select present.name from present;

insert into allPresents (name) values ('diskborste');


create view naughtyOrNice as
select name, 
	case when report.nicenumber >= 2 then 'Nice'
		when report.nicenumber < 2 then 'Naughty'
	end as 'Naughty or Nice'
    from child
inner join report 
on report.childId = child.id;


create view naughtyOrNiceHigherClass as
select child.name as Name, address as Address, country.name as Country,
	case when report.nicenumber >= 2 then 'Nice'
		when report.nicenumber < 2 then 'Naughty'
	end as 'Naughty or Nice'
    from child
inner join report on report.childId = child.id
inner join country on country.id = child.countryId;


 
 