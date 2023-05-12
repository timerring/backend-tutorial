-- 子查询练习

-- 请思考：查找每个部门工资高于本部门平均工资的人的资料
-- 这里要用到数据查询的小技巧，把一个子查询当作一个临时表使用

-- 1. 先得到每个部门的 部门号和 对应的平均工资

SELECT deptno, AVG(sal) AS avg_sal
	FROM emp GROUP BY deptno
	
-- 2. 把上面的结果当做子查询, 和 emp 进行多表查询
--    
SELECT ename, sal, temp.avg_sal, emp.deptno
	FROM emp, (
		SELECT deptno, AVG(sal) AS avg_sal
		FROM emp 
		GROUP BY deptno
	) temp 
	where emp.deptno = temp.deptno and emp.sal > temp.avg_sal
	
-- 查找每个部门工资最高的人的详细资料

SELECT ename, sal, temp.max_sal, emp.deptno
	FROM emp, (
		SELECT deptno, max(sal) AS max_sal
		FROM emp 
		GROUP BY deptno
	) temp 
	WHERE emp.deptno = temp.deptno AND emp.sal = temp.max_sal
	

-- 查询每个部门的信息(包括：部门名,编号,地址)和人员数量,我们一起完成。

-- 1. 部门名,编号,地址 来自 dept表
-- 2. 各个部门的人员数量 -》 构建一个临时表

select count(*), deptno 
	from emp
	group by deptno;
	

select dname, dept.deptno, loc , tmp.per_num as '人数'
	from dept, (
		SELECT COUNT(*) as per_num, deptno 
		FROM emp
		GROUP BY deptno
	) tmp 
	where tmp.deptno = dept.deptno

-- 还有一种写法 表.* 表示将该表所有列都显示出来, 可以简化sql语句
-- 在多表查询中，当多个表的列不重复时，才可以直接写列名

SELECT tmp.* , dname, loc
	FROM dept, (
		SELECT COUNT(*) AS per_num, deptno 
		FROM emp
		GROUP BY deptno
	) tmp 
	WHERE tmp.deptno = dept.deptno
	
