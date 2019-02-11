INSERT INTO student(Sno,Sname,Ssex,Clname,Sbirth,Scredit,Sage) VALUES('111','lh','men','CS4','1999','8','18')

INSERT INTO USER(username,PASSWORD,TYPE) VALUES('123','123','teacher')

INSERT INTO course (Cno,Cname,Credit)VALUES('06','计算机组成原理','2')

INSERT INTO stu_cour (Sno,Cno,grade)VALUES('111','03','30.0')

UPDATE course SET Cname='数据库'	   WHERE Cno='01'

UPDATE USER SET PASSWORD=''   WHERE  username=''

SELECT PASSWORD FROM USER WHERE username='1'

SELECT * FROM stu_cour WHERE Sno IN (SELECT Sno FROM student WHERE Clname='CS4')

SELECT stu_cour.`Cno` ,Cname,grade FROM course,stu_cour WHERE course.`Cno`=stu_cour.`Cno` AND Sno='1'

SELECT  * FROM stu_cour WHERE Cno IN (SELECT Cno FROM course WHERE Cname='数据结构')

`tb_score`
 
SELECT stu_cour.`Cno`,Clname, AVG(grade) '平均分',MAX(grade)  AS '最高分',MIN(grade) AS '最低分',SUM(CASE WHEN grade>=60 THEN 1 ELSE 0 END)/COUNT(*)   '及格率'
 FROM stu_cour,student
 WHERE  stu_cour.`Sno`=student.`Sno` AND  stu_cour.`Cno` IN
 (SELECT course.`Cno` FROM course,stu_cour WHERE  stu_cour.`Cno`=course.`Cno`  AND Cname='数据库') GROUP BY Clname
 
 SELECT Clname,Cno,AVG(grade) '平均分',MAX(grade)  AS '最高分',MIN(grade) AS '最低分',SUM(CASE WHEN grade>=60 THEN 1 ELSE 0 END)/COUNT(*)   '及格率'
 FROM stu_cour,student
 WHERE stu_cour.`Sno`=student.`Sno` AND student.`Sno`IN 
 (SELECT student.`Sno` FROM student WHERE Clname='CS7') GROUP BY stu_cour.`Cno`
 
 SELECT Clname,Cno,AVG(grade) '平均分',MAX(grade)  AS '最高分',MIN(grade) AS '最低分',SUM(CASE WHEN grade>=60 THEN 1 ELSE 0 END)/COUNT(*)   '及格率'
 FROM stu_cour,student
 WHERE stu_cour.`Sno`=student.`Sno` AND  stu_cour.`Cno`='01'  AND student.`Sno`IN 
 (SELECT student.`Sno` FROM student WHERE Clname='CS7') GROUP BY stu_cour.`Cno` 
 
 
 //按班级和课程查统计分数
 SELECT Clname,Cname,AVG(grade) '平均分',MAX(grade)  AS '最高分',MIN(grade) AS '最低分',SUM(CASE WHEN grade>=60 THEN 1 ELSE 0 END)/COUNT(*)   '及格率'
 FROM stu_cour,student,course
 WHERE stu_cour.`Sno`=student.`Sno` AND stu_cour.`Cno`=course.`Cno` AND Clname='CS4'  AND course.`Cname`='数据库'
 GROUP BY stu_cour.`Cno`
  
  //按班级查统计分数
 SELECT Clname,Cname,AVG(grade) '平均分',MAX(grade)  AS '最高分',MIN(grade) AS '最低分',SUM(CASE WHEN grade>=60 THEN 1 ELSE 0 END)/COUNT(*)   '及格率'
 FROM stu_cour,student,course
 WHERE stu_cour.`Sno`=student.`Sno` AND stu_cour.`Cno`=course.`Cno` AND Clname='CS7'
 GROUP BY stu_cour.`Cno`
 
 //按课程查统计分数
 SELECT  Cname,Clname,AVG(grade) '平均分',MAX(grade)  AS '最高分',MIN(grade) AS '最低分',SUM(CASE WHEN grade>=60 THEN 1 ELSE 0 END)/COUNT(*)   '及格率'
 FROM stu_cour,student,course
 WHERE stu_cour.`Sno`=student.`Sno` AND stu_cour.`Cno`=course.`Cno`   AND course.`Cname`='数据库'
 GROUP BY student.`Clname`
 
SELECT  stu_cour.`Cno`,student.`Clname`

INSERT INTO stu_cour VALUES('','01','50')
INSERT INTO stu_cour VALUES('','02','50')
INSERT INTO stu_cour VALUES('','03','50')
INSERT INTO stu_cour VALUES('','04','50')
INSERT INTO stu_cour VALUES('','05','50')
INSERT INTO stu_cour VALUES('','01','80')
INSERT INTO stu_cour VALUES('','02','80')
INSERT INTO stu_cour VALUES('','03','80')
INSERT INTO stu_cour VALUES('','04','80')
INSERT INTO stu_cour VALUES('','05','80')
SELECT * FROM stu_cour

SELECT * FROM course

SELECT * FROM student

SELECT * FROM USER

SELECT * FROM student,stu_cour ,course WHERE student.`Sno`=stu_cour.`Sno` AND stu_cour.`Cno`=course.`Cno`



SELECT Clname,Cname,AVG(grade) '平均分',MAX(grade)  AS '最高分',MIN(grade) AS '最低分',SUM(CASE WHEN grade>=60 THEN 1 ELSE 0 END)/COUNT(*)   '及格率'
				FROM stu_cour,student,course
				WHERE stu_cour.`Sno`=student.`Sno` AND stu_cour.`Cno`=course.`Cno` AND Clname='CS7' AND course.`Cname`='数据库'
				 GROUP BY stu_cour.`Cno`

 SELECT  Cname,Clname,AVG(grade) AS 'aver',MAX(grade)  AS 'max',MIN(grade) AS 'min',SUM(CASE WHEN grade>=60 THEN 1 ELSE 0 END)/COUNT(*)   'pass' FROM stu_cour,student,course WHERE stu_cour.`Sno`=student.`Sno` AND stu_cour.`Cno`=course.`Cno`   AND course.`Cname`='数据库' GROUP BY student.`Clname`


SELECT * FROM tb_class

SELECT * FROM tb_cource

SELECT * FROM tb_score

SELECT * FROM tb_spec

SELECT * FROM tb_student

SELECT * FROM tb_user
