select child.name, country.name from child
inner join country on child.countryId=country.id;

select child.name, present.name from child
inner join gets on gets.childId=child.id
inner join present on gets.presentId=present.id;

select distinct present.name from present
inner join gets on gets.presentId=present.id;

select child.name, present.name, priority from child
inner join wishes on wishes.childId=child.id
inner join present on wishes.presentId= present.id;

select child.name from child 
inner join gets on gets.childId=child.id
inner join present on present.id=gets.presentId
where present.name='car';

select country.name from child 
inner join gets on gets.childId=child.id
inner join present on present.id=gets.presentId
inner join country on country.id=child.countryId
where present.name='car';

select distinct country.name from child 
inner join gets on gets.childId=child.id
inner join present on present.id=gets.presentId
inner join country on country.id=child.countryId
where present.name='car';

select child.name from child
inner join gets on gets.childId=child.id
inner join wishes on wishes.childId=child.id
where gets.presentId=wishes.presentId;




