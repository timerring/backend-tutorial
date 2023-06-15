-- 演示order by使用
-- 对数学成绩排序后输出【升序】。
SELECT * FROM student 
	ORDER BY math;
-- 对总分按从高到低的顺序输出 [降序] -- 使用别名排序
SELECT `name` , (chinese + english + math) AS total_score FROM student 
	ORDER BY total_score DESC;
-- 对姓韩的学生成绩[总分]排序输出(升序) where + order by
SELECT `name`, (chinese + english + math) AS total_score FROM student
	WHERE `name` LIKE '韩%'
	ORDER BY total_score;

