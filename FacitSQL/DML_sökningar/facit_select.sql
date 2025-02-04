select name from child where id=2;

select address from child where id=3;

select distinct name from present;

select name from child where nice;

select name from child where not nice;

select name from child where countryId = 1 and nice;

select name from child where address='Eiffel Tower';

select name from child where address like 'E%';

select address from child where name like 'a%';

select name as namn, id from child where address='Eiffel Tower' or address='Globen';