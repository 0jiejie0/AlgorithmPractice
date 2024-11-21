//表: Person 
//
// 
//+-------------+---------+
//| Column Name | Type    |
//+-------------+---------+
//| id          | int     |
//| email       | varchar |
//+-------------+---------+
//id 是该表的主键列(具有唯一值的列)。
//该表的每一行包含一封电子邮件。电子邮件将不包含大写字母。
// 
//
// 
//
// 编写解决方案 删除 所有重复的电子邮件，只保留一个具有最小 id 的唯一电子邮件。 
//
// （对于 SQL 用户，请注意你应该编写一个 DELETE 语句而不是 SELECT 语句。） 
//
// （对于 Pandas 用户，请注意你应该直接修改 Person 表。） 
//
// 运行脚本后，显示的答案是 Person 表。驱动程序将首先编译并运行您的代码片段，然后再显示 Person 表。Person 表的最终顺序 无关紧要 。 
//
//
// 返回结果格式如下示例所示。 
//
// 
//
// 示例 1: 
//
// 
//输入: 
//Person 表:
//+----+------------------+
//| id | email            |
//+----+------------------+
//| 1  | john@example.com |
//| 2  | bob@example.com  |
//| 3  | john@example.com |
//+----+------------------+
//输出: 
//+----+------------------+
//| id | email            |
//+----+------------------+
//| 1  | john@example.com |
//| 2  | bob@example.com  |
//+----+------------------+
//解释: john@example.com重复两次。我们保留最小的Id = 1。 
//
// Related Topics 数据库 👍 834 👎 0


//There is no code of Java type for this problem


/*
*
delete p from Person p
left join ( select min(id) id , email from Person group by email ) pp
on p.email = pp.email
where p.id != pp.id;
*
* 思路大概就是先用子查询先获取需要保留的信息，然后利用id-email不匹配去掉多余id
*
* 语法上要注意的一点是，关联表删除需要在 delete 后指明 哪个表 需要 删除记录
* */


// 执行用时分布
//796
//ms
//击败
//72.99%
