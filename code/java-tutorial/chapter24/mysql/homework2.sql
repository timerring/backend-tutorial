-- 2. 写出 查看DEPT表和EMP表的结构 的sql语句  homework02.sql   10min 自己先练习
-- 
	DESC dept
	DESC emp
-- 3. 使用简单查询语句完成:
-- (1) 显示所有部门名称。
SELECT dname 
	FROM dept;
-- (2) 显示所有雇员名及其全年收入 13月(工资+补助),并指定列别名"年收入"
SELECT ename, (sal + IFNULL(comm,0)) * 13 AS "年收入"
	FROM emp 
SELECT * FROM emp;


-- 
-- 4.限制查询数据。
-- (1) 显示工资超过2850的雇员姓名和工资。
SELECT ename, sal
	FROM emp 
	WHERE sal > 2850
-- (2) 显示工资不在1500到2850之间的所有雇员名及工资。
SELECT ename, sal
	FROM emp 
	WHERE sal < 1500 OR sal > 2850
	
SELECT ename, sal
	FROM emp 
	WHERE NOT (sal >= 1500 AND sal <= 2850)
-- (3) 显示编号为7566的雇员姓名及所在部门编号。
SELECT ename, deptno
	FROM emp 
	WHERE empno = 7566
-- (4) 显示部门10和30中工资超过1500的雇员名及工资。
SELECT ename, job
	FROM emp 
	WHERE (deptno = 10 OR deptno = 30) AND sal > 1500
-- (5) 显示无管理者的雇员名及岗位。
SELECT ename, job 
	FROM emp
	WHERE mgr IS NULL;
	
	
-- 
-- 5.排序数据。
-- (1) 显示在1991年2月1日到1991年5月1日之间雇用的雇员名,岗位及雇佣日期, 
-- 并以雇佣日期进行排序[默认]。
-- 思路 1. 先查询到对应结果 2. 考虑排序
SELECT ename, job, hiredate
	FROM emp
	WHERE hiredate >= '1991-02-01' AND hiredate <= '1991-05-01'
	ORDER BY hiredate

-- (2) 显示获得补助的所有雇员名,工资及补助,并以工资降序排序
SELECT ename, sal, comm
	FROM emp
	ORDER BY sal DESC
	
