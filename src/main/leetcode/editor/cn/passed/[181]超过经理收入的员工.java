//表：Employee 
//
// 
//+-------------+---------+
//| Column Name | Type    |
//+-------------+---------+
//| id          | int     |
//| name        | varchar |
//| salary      | int     |
//| managerId   | int     |
//+-------------+---------+
//id 是该表的主键（具有唯一值的列）。
//该表的每一行都表示雇员的ID、姓名、工资和经理的ID。
// 
//
// 
//
// 编写解决方案，找出收入比经理高的员工。 
//
// 以 任意顺序 返回结果表。 
//
// 结果格式如下所示。 
//
// 
//
// 示例 1: 
//
// 
//输入: 
//Employee 表:
//+----+-------+--------+-----------+
//| id | name  | salary | managerId |
//+----+-------+--------+-----------+
//| 1  | Joe   | 70000  | 3         |
//| 2  | Henry | 80000  | 4         |
//| 3  | Sam   | 60000  | Null      |
//| 4  | Max   | 90000  | Null      |
//+----+-------+--------+-----------+
//输出: 
//+----------+
//| Employee |
//+----------+
//| Joe      |
//+----------+
//解释: Joe 是唯一挣得比经理多的雇员。 
//
// Related Topics 数据库 👍 725 👎 0


//There is no code of Java type for this problem

select ea.name as employee from employee ea inner join employee eb on ea.managerId = eb.id and ea.salary > eb.salary;
执行用时排名有点靠后
看了一下排名靠前的，似乎也没什么特别的
        SELECT e1.name AS Employee
        FROM Employee e1
        LEFT JOIN Employee e2
        ON e1.managerId = e2.id
        WHERE e1.salary > e2.salary;

再调整一下
调整join方式似乎没有明显改观，把关键词全部调整为大写，有所改善

        SELECT ea.name AS employee FROM employee ea LEFT JOIN employee eb ON ea.managerId = eb.id WHERE ea.salary > eb.salary;

似乎大概就是这样最优了
