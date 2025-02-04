
--mappa barn och antal önskningar
select child.name, count(child.name) as WishAmount from child
inner join wishes on wishes.childId = child.id
group by child.name;

--mappar antal barn och antal presenter de fick
select child.name, count(child.name) as GetAmount from child
inner join gets on gets.childId = child.id
group by child.name;

--ett av de barn som fick flest presenter 
select child.name, count(child.name) as GetAmount from child
inner join gets on gets.childId = child.id
group by child.name
order by GetAmount desc
limit 1;

-- ett av de barn som fick minst presenter 
select child.name, count(gets.id) as GetAmount from child
left join gets on gets.childId = child.id
group by child.name
order by GetAmount 
limit 1;

--mappar presenter och hur många gånger varje sak önskades
select present.name, count(wishes.id) as WishAmount from present
left join wishes on wishes.presentId = present.id
group by present.name;

--mappar presenter och hur många gånger varje sak gavs
select present.name, count(gets.id) as GetAmount from gets
right join present on gets.presentId = present.id
group by present.name;

--antal barn som fick det de önskade sig
select count(distinct(child.name)) from child
inner join gets on gets.childId=child.id
inner join wishes on wishes.childId=child.id
where gets.presentId=wishes.presentId;


--antal barn som önskade sig en katt och fick en katt
select count(child.name) from child
join gets on gets.childId = child.id
join wishes on wishes.childId = child.id
join present on gets.presentId = present.id
where gets.presentId=wishes.presentId and present.name = 'cat';








