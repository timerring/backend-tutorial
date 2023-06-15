-- 多表查询
-- ?显示雇员名,雇员工资及所在部门的名字 【笛卡尔集】
/*
	1. 雇员名,雇员工资 来自 emp表
	2. 部门的名字 来自 dept表
	3. 需求对 emp 和 dept查询  ename,sal,dname,deptno
	4. 当我们需要指定显示某个表的列是，需要 表.列表
*/
SELECT ename,sal,dname,emp.deptno
	FROM emp, dept 
	WHERE emp.deptno = dept.deptno
	
select * from emp;
select * from dept;
select * from salgrade;
-- 小技巧：多表查询的条件不能少于 表的个数-1, 否则会出现笛卡尔集
-- ?如何显示部门号为10的部门名、员工名和工资 
SELECT ename,sal,dname,emp.deptno
	FROM emp, dept 
	WHERE emp.deptno = dept.deptno and emp.deptno = 10

-- ?显示各个员工的姓名，工资，及其工资的级别

-- 思路 姓名，工资 来自 emp 13
--      工资级别 salgrade 5
-- 写sql , 先写一个简单，然后加入过滤条件...
select ename, sal, grade 
	from emp , salgrade
	where sal between losal and hisal; 
