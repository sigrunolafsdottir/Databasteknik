select child.name, child.address from child
inner join country on country.id=child.countryId
where country.name in ('Sweden','USA','Iceland');

select child.name, present.name from child 
inner join gets on gets.childId=child.id
inner join present on present.id=gets.presentId
order by present.name;

select child.name, present.name from child 
inner join gets on gets.childId=child.id
inner join present on present.id=gets.presentId
inner join country on country.id=child.countryId
order by country.name desc;

select child.name, present.name from child
inner join wishes on wishes.childId=child.id
inner join present on present.id=wishes.presentId
where wishes.id between 2 and 5;

select child.name, present.name from child
inner join wishes on wishes.childId=child.id
inner join present on present.id=wishes.presentId
limit 3;

