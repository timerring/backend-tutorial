-- 多列子查询

-- 请思考如何查询与allen的部门和岗位完全相同的所有雇员(并且不含allen本人)
-- (字段1， 字段2 ...) = (select 字段 1，字段2 from 。。。。)

-- 分析: 1. 得到smith的部门和岗位

SELECT deptno , job
	FROM emp 
	WHERE ename = 'ALLEN'
	
-- 分析: 2  把上面的查询当做子查询来使用，并且使用多列子查询的语法进行匹配
SELECT * 
	FROM emp
	WHERE (deptno , job) = (
		SELECT deptno , job
		FROM emp 
		WHERE ename = 'ALLEN'
	) AND ename != 'ALLEN'



-- 请查询 和宋江数学，英语，语文   
-- 成绩 完全相同的学生
SELECT * 
	FROM student
	WHERE (math, english, chinese) = (
		SELECT math, english, chinese
		FROM student
		WHERE `name` = '宋江'
	)

SELECT * FROM student;


--
	
