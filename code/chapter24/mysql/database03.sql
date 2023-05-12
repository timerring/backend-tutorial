#练习 : database03.sql 备份db02 和 db03 库中的数据，并恢复

#备份, 要在Dos下执行mysqldump指令其实在mysql安装目录\bin
#这个备份的文件，就是对应的sql语句
mysqldump -u root -p -B db02 db03 > d:\\bak.sql

DROP DATABASE ecshop;

#恢复数据库(注意：进入Mysql命令行再执行)
source d:\\bak.sql
#第二个恢复方法， 直接将bak.sql的内容放到查询编辑器中，执行，相当于重新执行了一遍

