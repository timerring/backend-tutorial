#这是一个ecshop 的数据库，包括ecshop 所有的表，请导入到mysql数据库中[备份]
#进入到mysql命令行: source ecshop备份文件路径 
#再将ecshop整个数据库备份到你的 d:\\ecshop.sql到dos 下 : 
mysqldump -u root -p -B ecshop > d:\\ecshop.sql
#将mysql的ecshop数据库删除, 并通过备份的d:\\ecshop.sql恢复
#进入mysql命令行
source d:\\ecshop.sql