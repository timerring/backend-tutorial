--  修改自己的密码, 没问题

SET PASSWORD = PASSWORD('abcdef')

-- 修改其他人的密码， 需要权限

SET PASSWORD FOR 'root'@'localhost' = PASSWORD('123456')
