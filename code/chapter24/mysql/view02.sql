-- 视图的课堂练习
-- 针对 emp ，dept , 和   salgrade 张三表.创建一个视图 emp_view03，
-- 可以显示雇员编号，雇员名，雇员部门名称和 薪水级别[即使用三张表，构建一个视图]

/*
	分析: 使用三表联合查询，得到结果
	将得到的结果，构建成视图
*/
CREATE VIEW emp_view03
	AS
	SELECT empno, ename, dname, grade
	FROM emp, dept, salgrade
	WHERE emp.deptno = dept.deptno AND 
	(sal BETWEEN losal AND hisal) 

DESC emp_view03
SELECT * FROM emp_view03
	