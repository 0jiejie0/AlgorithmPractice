select FirstName, LastName, City, State
from person
       left outer join address on person.personid = address.personid;
# 一道小小的题目，竟然复习了左连接知识点，真的是忘了很多了。。。