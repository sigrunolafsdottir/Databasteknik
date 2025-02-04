
--mappar de barn som fick exakt 1 present

select child.name from child
inner join gets on gets.childId = child.id
group by child.name
having count(child.name) = 1;

-------------mappar presenter som gavs exakt en gång

select present.name, count(gets.id) as GetAmount from gets
right join present on gets.presentId = present.id
group by present.name
having count(gets.id) = 1;

-- Vilka barn har fått samma presenter som andra barn (och vad)

select childTable.name, count(g2.presentId) as PresentGiftedAmountOfTimes , p.name
from child as childTable
inner join gets as g1 on g1.childId = childTable.id
inner join gets as g2 on g1.presentId = g2.presentId
inner join present p on g2.presentId = p.id
group by childTable.name
having PresentGiftedAmountOfTimes > 1;








