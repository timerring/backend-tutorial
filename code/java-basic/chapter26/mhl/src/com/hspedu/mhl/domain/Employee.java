package com.hspedu.mhl.domain;

/**
 * 这是一个javabean 和 employee对应
 * id int primary key auto_increment, #自增
 * 	empId varchar(50) not null default '',#员工号
 * 	pwd char(32) not null default '',#密码md5
 * 	name varchar(50) not null default '',#姓名
 * 	job varchar(50) not null default '' #岗位
 */
public class Employee {
    private Integer id;
    private String empId;
    private String pwd;
    private String name;
    private String job;

    public Employee() { //无参构造器，底层apache-dbutils反射需要
    }

    public Employee(Integer id, String empId, String pwd, String name, String job) {
        this.id = id;
        this.empId = empId;
        this.pwd = pwd;
        this.name = name;
        this.job = job;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
