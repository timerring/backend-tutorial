-- 查询加强
-- ■ 使用where子句
-- 	?如何查找1992.1.1后入职的员工
-- 老师说明： 在mysql中,日期类型可以直接比较, 需要注意格式
SELECT * FROM emp
	WHERE hiredate > '1992-01-01'
-- ■ 如何使用like操作符(模糊)
-- 	%: 表示0到多个任意字符 _: 表示单个任意字符
-- 	?如何显示首字符为S的员工姓名和工资
SELECT ename, sal FROM emp
	WHERE ename LIKE 'S%'
-- 	?如何显示第三个字符为大写O的所有员工的姓名和工资
SELECT ename, sal FROM emp
	WHERE ename LIKE '__O%'

-- ■ 如何显示没有上级的雇员的情况
SELECT * FROM emp
	WHERE mgr IS NULL;
-- ■ 查询表结构 
DESC emp 

-- 使用order by子句
--   ?如何按照工资的从低到高的顺序[升序]，显示雇员的信息
SELECT * FROM emp
	ORDER BY sal 
--   ?按照部门号升序而雇员的工资降序排列 , 显示雇员信息

SELECT * FROM emp
	ORDER BY deptno ASC , sal DESC;

