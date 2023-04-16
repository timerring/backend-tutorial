- [第8章 面向对象编程(中级部分)](#第8章-面向对象编程中级部分)
  - [IDEA 常用快捷键](#idea-常用快捷键)
  - [包](#包)
    - [包的三大作用](#包的三大作用)
    - [包基本语法](#包基本语法)
    - [包的本质分析](#包的本质分析)
    - [包的命名](#包的命名)
    - [常用的包](#常用的包)
    - [如何引入包](#如何引入包)
    - [注意事项和使用细节](#注意事项和使用细节)
  - [访问修饰符](#访问修饰符)
    - [基本介绍](#基本介绍)
    - [访问修饰符的访问范围!](#访问修饰符的访问范围)
    - [使用的注意事项](#使用的注意事项)
  - [面向对象编程三大特征](#面向对象编程三大特征)
    - [基本介绍](#基本介绍-1)
    - [封装介绍](#封装介绍)
    - [封装的理解和好处](#封装的理解和好处)
    - [封装的实现步骤(三步)](#封装的实现步骤三步)
    - [快速入门案例](#快速入门案例)
    - [将构造器和setXxx 结合](#将构造器和setxxx-结合)
  - [面向对象编程-继承](#面向对象编程-继承)
    - [继承的基本语法](#继承的基本语法)
    - [继承的深入讨论/细节问题](#继承的深入讨论细节问题)
    - [继承的本质分析!](#继承的本质分析)
  - [super 关键字](#super-关键字)
    - [基本介绍](#基本介绍-2)
    - [基本语法](#基本语法)
    - [super 给编程带来的便利/细节](#super-给编程带来的便利细节)
    - [super 和this 的比较](#super-和this-的比较)
  - [方法重写/覆盖(override)](#方法重写覆盖override)
    - [注意事项和使用细节](#注意事项和使用细节-1)
    - [重写和重载比较!](#重写和重载比较)
  - [面向对象编程-多态](#面向对象编程-多态)
    - [多\[多种\]态\[状态\]基本介绍](#多多种态状态基本介绍)
    - [多态的具体体现](#多态的具体体现)
      - [方法的多态](#方法的多态)
      - [对象的多态!](#对象的多态)
    - [多态注意事项和细节讨论](#多态注意事项和细节讨论)
      - [多态的向上转型](#多态的向上转型)
      - [多态向下转型](#多态向下转型)
      - [属性没有重写之说](#属性没有重写之说)
      - [instanceOf 比较操作符](#instanceof-比较操作符)
    - [java 的动态绑定机制!!](#java-的动态绑定机制)
    - [多态的应用](#多态的应用)
      - [多态数组](#多态数组)
      - [多态参数](#多态参数)
  - [Object 类详解](#object-类详解)
    - [equals 方法](#equals-方法)
      - [==和equals 的对比!!!!!](#和equals-的对比)
    - [如何重写 equals 方法](#如何重写-equals-方法)
    - [hashCode 方法](#hashcode-方法)
      - [总结](#总结)
    - [toString 方法](#tostring-方法)
    - [finalize 方法](#finalize-方法)
    - [断点调试(debug)](#断点调试debug)
    - [断点调试介绍](#断点调试介绍)
    - [断点调试的快捷键](#断点调试的快捷键)
    - [Idea debug进入 Jdk源码](#idea-debug进入-jdk源码)
    - [项目-零钱通](#项目-零钱通)


# 第8章 面向对象编程(中级部分)

## IDEA 常用快捷键

1) 删除当前行, 默认是 `ctrl + Y` 自己配置 `ctrl + d`
2) 复制当前行, 自己配置 `ctrl + alt + 向下光标`
3) 补全代码 `alt + /`
4) 添加注释和取消注释 `ctrl + /`
5) 导入该行需要的类先配置auto import , 然后使用 `alt+enter` 即可
6) 快速格式化代码 `ctrl + alt + L`
7) 快速运行程序自己定义 `alt + R`
8) 生成构造器等 `alt + insert` [提高开发效率]
9) 查看一个类的层级关系 `ctrl + H`
10) 将光标放在一个方法上，输入 `ctrl + B` , 可以定位到方法
11) 自动的分配变量名, 通过在后面加`.var`

## 包

### 包的三大作用

区分相同名字的类

当类很多时,可以很好的管理类[看Java API文档]

控制访问范围

### 包基本语法

package com.hspedu;

说明:

package关键字,表示打包

com.hspedu:表示包名

### 包的本质分析

包的本质实际上就是创建不同的文件夹/目录来保存类文件

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/04/12-20-58-50-1681304329.png)

### 包的命名

命名规则

只能包含数字、字母、下划线、小圆点.，但不能用数字开头，不能是关键字或保留字。
命名规范

一般是小写字母+小圆点

一般是 `com.公司名.项目名.业务模块名`

例如：

com.sina.crm.user //用户模块

com.sina.crm.order //订单模块

com.sina.crm.utils //工具类

### 常用的包

一个包下,包含很多的类,java 中常用的包有:

1) java.lang.* //lang 包是基本包，默认引入，不需要再引入.
2) java.util.* //util 包，系统提供的工具包, 工具类，使用Scanner
3) java.net.* //网络包，网络开发
4) java.awt.* //是做java 的界面开发，GUI

### 如何引入包

语法: import 包;

我们引入一个包的主要目的是要使用该包下的类

比如

```java
import java.util.Scanner;  //就只是引入一个类

Scanner.import java.util.*;//表示将java.util包所有都引入
```

建议：我们需要使用到哪个类，就导入哪个类即可，不建议使用*导入

### 注意事项和使用细节

1. package的作用是声明当前类所在的包，需要放在类的最上面，一个类中最多只有一句package
2. import指令位置放在package的下面，在类定义前面,可以有多句且没有顺序要求。

```java
//package的作用是声明当前类所在的包，需要放在类(或者文件)的最上面，
// 一个类中最多只有一句package
package com.hspedu.pkg;

//import指令 位置放在package的下面，在类定义前面,可以有多句且没有顺序要求
import java.util.Scanner;
import java.util.Arrays;
```

## 访问修饰符

### 基本介绍

java 提供四种访问控制修饰符号，用于控制方法和属性(成员变量)的访问权限（范围）:

1) 公开级别: 用public 修饰,对外公开
2) 受保护级别: 用protected 修饰, 对子类和同一个包中的类公开
3) 默认级别: 没有修饰符号,向同一个包的类公开.
4) 私有级别: 用private修饰,只有类本身可以访问,不对外公开.

### 访问修饰符的访问范围!

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/04/12-21-06-41-1681304800.png)

### 使用的注意事项

1. 修饰符可以用来修饰类中的属性,成员方法以及类

2. 只有默认的和public才能修饰类!，并且遵循上述访问权限的特点。

3. 成员方法的访问规则和属性完全一样.

## 面向对象编程三大特征

### 基本介绍

面向对象编程有三大特征：封装、继承和多态。

### 封装介绍

封装(encapsulation)就是把抽象出的数据 **[属性]** 和对数据的操作 **[方法]** 封装在一起,数据被保护在内部,程序的其它部分只有通过被授权的操作 **[方法]** ,才能对数据进行操作。

### 封装的理解和好处

隐藏实现细节: 方法(连接数据库) <-- 调用(传入参数)

可以对数据进行验证，保证安全合理

```java
Person {name, age}
Person p = new Person();
p.name = "jack" ;
p.age= 1200;
```

### 封装的实现步骤(三步)

1. 将属性进行私有化private【不能直接修改属性】

2. 提供一个公共的(public)set方法，用于对属性判断并赋值
   
   ```java
   public void setXxx(类型参数名){//Xxx表示某个属性
       //加入数据验证的业务逻辑
       属性=参数名;
   }
   ```

3. 提供一个公共的 `(public)get` 方法，用于获取属性的值
   
   ```java
   public 数据类型 getXxx(){ //权限判断,Xxx某个属性
       return xx;
   }
   ```

### 快速入门案例

```java
package com.hspedu.encap;

public class Encapsulation01 {

    public static void main(String[] args) {
        //如果要使用快捷键alt+r, 需要先配置主类
        //第一次，我们使用鼠标点击形式运算程序，后面就可以用
        Person person = new Person();
        person.setName("韩顺平");
        person.setAge(30);
        person.setSalary(30000);
        System.out.println(person.info());
        System.out.println(person.getSalary());

        //如果我们自己使用构造器指定属性
        Person smith = new Person("smith", 80, 50000);
        System.out.println("====smith的信息======");
        System.out.println(smith.info());


    }
}
/*
那么在java中如何实现这种类似的控制呢?
请大家看一个小程序(com.hspedu.encap: Encapsulation01.java),
不能随便查看人的年龄,工资等隐私，并对设置的年龄进行合理的验证。年龄合理就设置，否则给默认
年龄, 必须在 1-120, 年龄， 工资不能直接查看 ， name的长度在 2-6字符 之间

 */
class Person {
    public  String name; //名字公开
    private int age; //age 私有化
    private double salary; //..

    public void say(int n,String name) {

    }
    //构造器 alt+insert
    public Person() {
    }
    //有三个属性的构造器
    public Person(String name, int age, double salary) {
//        this.name = name;
//        this.age = age;
//        this.salary = salary;
        //我们可以将set方法写在构造器中，这样仍然可以验证
        setName(name);
        setAge(age);
        setSalary(salary);
    }

    // 自己写setXxx 和 getXxx 太慢，我们使用快捷键 Generate --> Getter and Setter
    // 然后根据要求来完善我们的代码.
    public String getName() {
        return name;
    }
    public void setName(String name) {
        // 加入对数据的校验,相当于增加了业务逻辑
        if(name.length() >= 2 && name.length() <=6 ) {
            this.name = name;
        }else {
            System.out.println("名字的长度不对，需要(2-6)个字符，默认名字");
            this.name = "无名人";
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        //判断
        if(age >= 1 && age <= 120) {//如果是合理范围
            this.age = age;
        } else {
            System.out.println("你设置年龄不对，需要在 (1-120), 给默认年龄18 ");
            this.age = 18;//给一个默认年龄
        }
    }

    public double getSalary() {
        //可以这里增加对当前对象的权限判断
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    //写一个方法，返回属性信息
    public String info() {
        return "信息为 name=" + name  + " age=" + age + " 薪水=" + salary;
    }
}
```

### 将构造器和setXxx 结合

可以将set方法写在构造器中，这样可以保证验证。

```java
public Person(String name, int age, double salary) {
    // this.name = name;
    // this.age = age;
    // this.salary = salary;
    //我们可以将set 方法写在构造器中，这样仍然可以验证
    setName(name);
    setAge(age);
    setSalary(salary);
}
```

## 面向对象编程-继承

继承可以解决代码复用,让我们的编程更加靠近人类思维.当多个类存在相同的属性(变量)和方法时,可以从这些类中抽象出父类,在父类中定义这些相同的属性和方法，所有的子类不需要重新定义这些属性和方法，只需要通过extends 来声明继承父类即可。

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/04/12-22-16-35-1681308994.png)

### 继承的基本语法

```java
class 子类 extends 父类 {
}
```

1)子类就会自动拥有父类定义的属性和方法

2)父类又叫超类,基类。

3)子类又叫派生类。

### 继承的深入讨论/细节问题

1) 子类继承了所有的属性和方法，非私有的属性和方法可以在子类直接访问, 但是私有属性和方法不能在子类直接访问，要**通过父类提供公共的方法去访问**
2) 子类必须调用父类的构造器，完成父类的初始化。**先调用父类构造器，再调用子类构造器。**
3) 当创建子类对象时，不管使用子类的哪个构造器，默认情况下总会去调用父类的无参构造器，如果父类没有提供无参构造器，**则必须在子类的构造器中用super 去指定使用父类的哪个构造器完成对父类的初始化工作**，否则，编译不会通过.
4) 如果希望指定去调用父类的某个构造器，则显式的调用一下: `super(参数列表)`
5) super 在使用时，必须放在构造器第一行( **super 只能在构造器中使用** )
6) super() 和this() 都只能放在构造器第一行，因此这两个方法**不能共存在一个构造器**。
7) java 所有类都是Object 类的子类, Object 是所有类的基类.
8) 父类构造器的调用不限于直接父类！将一直往上追溯直到Object 类(顶级父类)
9) **子类最多只能继承一个父类**(指直接继承)，即java中是单继承机制。
   思考：如何让A 类继承B类和C类？ 方法：A 继承B， B 继承C。
10) 不能滥用继承，子类和父类之间必须满足is-a 的逻辑关系

```java
package com.hspedu.extend_;

import java.util.Arrays;

//输入ctrl + H 可以看到类的继承关系
public class Sub extends Base { //子类

    public Sub(String name, int age) {
        //1. 要调用父类的无参构造器, 如下或者什么都不写,默认就是调用super()
        //super();//父类的无参构造器
        //2. 要调用父类的 Base(String name) 构造器
        //super("hsp");
        //3. 要调用父类的 Base(String name, int age) 构造器
        super("king", 20);

        //细节：super在使用时，必须放在构造器第一行
        //细节: super() 和 this() 都只能放在构造器第一行，因此这两个方法不能共存在一个构造器
        //this() 不能再使用了
        System.out.println("子类Sub(String name, int age)构造器被调用....");


    }

    public Sub() {//无参构造器
        //super(); //默认调用父类的无参构造器
        super("smith", 10);
        System.out.println("子类Sub()构造器被调用....");
    }
    //当创建子类对象时，不管使用子类的哪个构造器，默认情况下总会去调用父类的无参构造器
    public Sub(String name) {
        super("tom", 30);
        //do nothing...
        System.out.println("子类Sub(String name)构造器被调用....");
    }

    public void sayOk() {//子类方法
        //非私有的属性和方法可以在子类直接访问
        //但是私有属性和方法不能在子类直接访问
        System.out.println(n1 + " " + n2 + " " + n3);
        test100();
        test200();
        test300();
        //test400();错误
        //要通过父类提供公共的方法去访问
        System.out.println("n4=" + getN4());
        callTest400();//
    }

}
```

### 继承的本质分析!

我们着一个案例来分析当子类继承父类，创建子类对象时，内存中到底发生了什么?

> 当子类对象创建好后，建立查找的关系

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/04/12-22-36-39-1681310186.png)

1. 最先加载父类，分别是Object类，然后加载Grandpa，再Father，最后Son。

2. 然后再分配堆空间：不同类的相同变量名不会冲突，堆中空间不同。

3. 最后Son对象（0x11都是）返回给main中的引用。

那么最后输出什么呢？（还是**就近原则**）

```java
package com.hspedu.extend_;

/**
 * 讲解继承的本质
 */
public class ExtendsTheory {
    public static void main(String[] args) {
        Son son = new Son();//内存的布局
        //?-> 这时请大家注意，要按照查找关系来返回信息
        //(1) 首先看子类是否有该属性
        //(2) 如果子类有这个属性，并且可以访问，则返回信息
        //(3) 如果子类没有这个属性，就看父类有没有这个属性(如果父类有该属性，并且可以访问，就返回信息..)
        //(4) 如果父类没有就按照(3)的规则，继续找上级父类，直到Object...
        System.out.println(son.name);//返回就是大头儿子
        //System.out.println(son.age);//返回的就是39
        //System.out.println(son.getAge());//返回的就是39
        System.out.println(son.hobby);//返回的就是旅游
    }
}

class GrandPa { //爷类
    String name = "大头爷爷";
    String hobby = "旅游";
}

class Father extends GrandPa {//父类
    String name = "大头爸爸";
    private int age = 39;

    public int getAge() {
        return age;
    }
}

class Son extends Father { //子类
    String name = "大头儿子";
}
```

## super 关键字

### 基本介绍

super 代表父类的引用，用于访问父类的属性、方法、构造器

### 基本语法

1.访问父类的属性，但不能访问父类的private属性[案例]
    super.属性名;
2.访问父类的方法,不能访问父类的private方法
    super.方法名(参数列表);
3.访问父类的构造器:
    super(参数列表);只能放在构造器的第一句，只能出现一句!

```java
package com.hspedu.super_;

public class A extends Base{
    //4个属性
    //public int n1 = 100;
    protected int n2 = 200;
    int 3 = 300;
    private int n4 = 400;

    public A() {}
    public A(String name) {}
    public A(String name, int age) {}

//    public void cal() {
//        System.out.println("A类的cal() 方法...");
//    }

    public void test100() {
    }

    protected void test200() {
    }

    void test300() {
    }

    private void test400() {
    }
}
```

cal() 和 this.cal() 相同，就近原则。
super.cal() 的顺序是直接查找父类，其他的规则一样

```java
package com.hspedu.super_;

public class B extends A {

    public int n1 = 888;

    //编写测试方法
    public void test() {
        //super的访问不限于直接父类，如果爷爷类和本类中有同名的成员，也可以使用super去访问爷爷类的成员；
        // 如果多个基类(上级类)中都有同名的成员，使用super访问遵循就近原则。A->B->C

        System.out.println("super.n1=" + super.n1);
        super.cal();
    }

    //访问父类的属性 , 但不能访问父类的private属性 [案例]super.属性名
    public void hi() {
        System.out.println(super.n1 + " " + super.n2 + " " + super.n3 );
    }
    public void cal() {
        System.out.println("B类的cal() 方法...");
    }
    public void sum() {
        System.out.println("B类的sum()");
        //希望调用父类-A 的cal方法
        //这时，因为子类B没有cal方法，因此我可以使用下面三种方式

        // !找cal方法时(cal() 和 this.cal())，顺序是:
        // (1)先找本类，如果有，则调用
        // (2)如果没有，则找父类(如果有，并可以调用，则调用)
        // (3)如果父类没有，则继续找父类的父类,整个规则，就是一样的,直到 Object类
        // 提示：如果查找方法的过程中，找到了，但是不能访问， 则报错, cannot access
        //      如果查找方法的过程中，没有找到，则提示方法不存在
        //cal();
        this.cal(); //等价 cal

        // !找cal方法(super.call()) 的顺序是直接查找父类，其他的规则一样
        //super.cal();

        //演示访问属性的规则
        // !n1 和 this.n1 查找的规则是
        //(1) 先找本类，如果有，则调用
        //(2) 如果没有，则找父类(如果有，并可以调用，则调用)
        //(3) 如果父类没有，则继续找父类的父类,整个规则，就是一样的,直到 Object类
        // 提示：如果查找属性的过程中，找到了，但是不能访问， 则报错, cannot access
        //      如果查找属性的过程中，没有找到，则提示属性不存在
        System.out.println(n1);
        System.out.println(this.n1);

        // !找n1 (super.n1) 的顺序是直接查找父类属性，其他的规则一样
        System.out.println(super.n1);

    }
    //访问父类的方法，不能访问父类的private方法 super.方法名(参数列表);
    public void ok() {
        super.test100();
        super.test200();
        super.test300();
        //super.test400();//不能访问父类private方法
    }
    //访问父类的构造器(这点前面用过)：super(参数列表);只能放在构造器的第一句，只能出现一句！
    public  B() {
        //super();
        //super("jack", 10);
        super("jack");
    }
}
```

### super 给编程带来的便利/细节

1. 调用父类的构造器的好处(分工明确,父类属性由父类初始化，子类的属性由子
   类初始化)

2. 当子类中有和父类中的成员(属性和方法)重名时，为了访问父类的成员，必须
   通过super。如果没有重名，使用super、this、直接访问是一样的效果!

3. super的访问不限于直接父类，如果爷爷类和本类中有同名的成员，也可以使用
   super去访问爷爷类的成员; 如果多个基类(上级类)中都有同名的成员，使用super访问遵循就近原则。A->B->C，当然也需要遵守访问权限的相关规则

### super 和this 的比较

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/04/12-22-59-59-1681311598.png)

## 方法重写/覆盖(override)

简单的说:方法覆盖(重写)就是子类有一个方法, **和父类的某个方法的名称、返回类型、参数一样**,那么我们就说子类的这个方法覆盖了父类的方法。

### 注意事项和使用细节

方法重写也叫方法覆盖，需要满足下面的条件

1. **子类的方法的形参列表,方法名称,要和父类方法的形参列表方法名称完全一样**。

2. 子类方法的返回类型和父类方法返回类型一样，或者是父类返回类型的子类
   
   比如交类返回类型是Object,子类方法返回类型是String
   public object getInfo()
   public String getInfo()

3. **子类方法不能缩小父类方法的访问权限**。最好大于等于父类的权限。
   
   public > protected > 默认>private

### 重写和重载比较!

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/04/13-09-39-17-1681349956.png)

## 面向对象编程-多态

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/04/13-09-57-34-1681351053.png)

传统的方法带来的问题是什么? 

代码的复用性不高，而且不利于代码维护

解决方案： 引出我们要讲解的多态

### 多[多种]态[状态]基本介绍

方法或对象具有多种形态。是面向对象的第三大特征，多态是建立在封装和继承基础之上的。

### 多态的具体体现

#### 方法的多态

重写和重载就体现多态

#### 对象的多态!

(1) 一个对象的**编译类型和运行类型可以不一致**

(2) 编译类型在定义对象时，就确定了，不能改变

(3) 运行类型是可以变化的.

(4) 编译类型看定义时 = 号的左边，运行类型看 = 号的右边

```java
Animal animal = new Dog() // animal编译类型是Animal，运行类型Dog
animal = new Cat();// animal的运行类型变成了Cat,编译类型仍然是 Animal
```

### 多态注意事项和细节讨论

多态的前提是：两个对象(类)存在继承关系

#### 多态的向上转型

1) 本质:父类的引用指向了子类的对象

2) 语法:`父类类型引用名=new子类类型();`

3) 特点:编译类型看左边,运行类型看右边。
   
   **可以调用父类中的所有成员(需遵守访问权限),不能调用子类中特有成员;
   最终运行效果看子类的具体实现!** （运行时看运行类型，例如找方法时就是采用就近原则）
   
   **因为在编译阶段，能调用哪些成员，是由编译类型决定的。**

#### 多态向下转型

语法: `子类类型 引用名 = (子类类型) 父类引用;`

1. **只能强转父类的引用，不能强转父类的对象**

2. 要求父类的引用必须指向的是当前目标类型的对象

3. 当向下转型后，可以调用子类类型中所有的成员

```java
package com.hspedu.poly_.detail_;

public class PolyDetail {
    public static void main(String[] args) {

        //向上转型: 父类的引用指向了子类的对象
        //语法：父类类型引用名 = new 子类类型();
        Animal animal = new Cat();
        Object obj = new Cat();//可以吗? 可以 Object 也是 Cat的父类

        //向上转型调用方法的规则如下:
        //(1)可以调用父类中的所有成员(需遵守访问权限)
        //(2)但是不能调用子类的特有的成员
        //(#)因为在编译阶段，能调用哪些成员,是由编译类型来决定的
        //animal.catchMouse();错误
        //(4)最终运行效果看子类(运行类型)的具体实现, 即调用方法时，按照从子类(运行类型)开始查找方法
        //，然后调用，规则我前面我们讲的方法调用规则一致。
        animal.eat();//猫吃鱼..
        animal.run();//跑
        animal.show();//hello,你好
        animal.sleep();//睡

        //老师希望，可以调用Cat的 catchMouse方法
        //多态的向下转型
        //(1)语法：子类类型 引用名 =（子类类型）父类引用;
        //问一个问题? cat 的编译类型 Cat,运行类型是 Cat
        Cat cat = (Cat) animal;

        cat.catchMouse();//猫抓老鼠
        //(2)要求父类的引用必须指向的是当前目标类型的对象
        // animal 本来创建时就指向 cat对象
        // 后面 animal 向下转型 cat 指向 cat对象
        Dog dog = (Dog) animal;//可以吗？ 错误!

        System.out.println("ok~~");
    }
}
```

#### 属性没有重写之说

属性没有重写之说！属性的值看编译类型

```java
package com.hspedu.poly_.detail_;

public class PolyDetail02 {
    public static void main(String[] args) {
        //属性没有重写之说！属性的值看编译类型
        Base base = new Sub();//向上转型
        System.out.println(base.count);// ？ 看编译类型 10
        Sub sub = new Sub();
        System.out.println(sub.count);//?  20
    }
}

class Base { //父类
    int count = 10;//属性
}
class Sub extends Base {//子类
    int count = 20;//属性
}
```

#### instanceOf 比较操作符

用于判断对象的 **运行类型** 是否为 **XX 类型 或 XX 类型的子类型**

```java
package com.hspedu.poly_.detail_;

public class PolyDetail03 {
    public static void main(String[] args) {
        BB bb = new BB();
        System.out.println(bb instanceof  BB);// true
        System.out.println(bb instanceof  AA);// true

        //aa 编译类型 AA, 运行类型是BB
        //BB是AA子类
        AA aa = new BB();
        System.out.println(aa instanceof AA); // true
        System.out.println(aa instanceof BB); // true

        Object obj = new Object();
        System.out.println(obj instanceof AA);//false
        String str = "hello";
        //System.out.println(str instanceof AA);
        System.out.println(str instanceof Object);//true
    }
}

class AA {} //父类
class BB extends AA {}//子类
```

### java 的动态绑定机制!!

**1.当调用对象方法的时候，该方法会和该对象的内存地址/运行类型绑定
2.当调用对象属性时，没有动态绑定机制，哪里声明，哪里使用**，找不到再去父类中寻找。

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/04/13-15-19-11-1681370344.png)

```java
package com.hspedu.poly_.dynamic_;

public class DynamicBinding {
    public static void main(String[] args) {
        //a 的编译类型 A, 运行类型 B
        A a = new B();//向上转型
        System.out.println(a.sum()); //?40 -> 30 (20 + 10)
        System.out.println(a.sum1());//?30 -> 20 (10 + 10)
    }
}

class A {//父类
    public int i = 10;
    //动态绑定机制:

    public int sum() {//父类sum()
        return getI() + 10;//20 + 10
    }

    public int sum1() {//父类sum1()
        return i + 10;//10 + 10
    }

    public int getI() {//父类getI
        return i;
    }
}

class B extends A {//子类
    public int i = 20;

//    public int sum() {
//        return i + 20;
//    }

    public int getI() {//子类getI()
        return i;
    }

//    public int sum1() {
//        return i + 10;
//    }
}
```

### 多态的应用

#### 多态数组

数组的定义类型为父类类型，里面保存的实际元素类型为子类类型。

应用实例:现有一个继承结构如下：要求创建1 个Person 对象、2 个Student 对象和2 个Teacher 对象, 统一放在数组中，并调用每个对象 say 方法.

应用实例升级：如何调用子类特有的方法，比如Teacher 有一个teach , Student 有一个study ，怎么调用？

```java
package com.hspedu.poly_.polyarr_;

public class PloyArray {
    public static void main(String[] args) {
        //应用实例:现有一个继承结构如下：要求创建1个Person对象、
        // 2个Student 对象和2个Teacher对象, 统一放在数组中，并调用每个对象say方法

        Person[] persons = new Person[5];
        persons[0] = new Person("jack", 20);
        persons[1] = new Student("mary", 18, 100);
        persons[2] = new Student("smith", 19, 30.1);
        persons[3] = new Teacher("scott", 30, 20000);
        persons[4] = new Teacher("king", 50, 25000);

        //循环遍历多态数组，调用say
        for (int i = 0; i < persons.length; i++) {
            //老师提示: person[i] 编译类型是 Person ,运行类型是是根据实际情况有JVM来判断
            System.out.println(persons[i].say());//动态绑定机制
            // 这里聪明. 使用 类型判断 + 向下转型.!!!!
            if(persons[i]  instanceof  Student) {//判断person[i] 的运行类型是不是Student
                Student student = (Student)persons[i];//向下转型
                student.study();
                //小伙伴也可以使用一条语句 ((Student)persons[i]).study();
            } else if(persons[i] instanceof  Teacher) {
                Teacher teacher = (Teacher)persons[i];
                teacher.teach();
            } else if(persons[i] instanceof  Person){
                //System.out.println("你的类型有误, 请自己检查...");
            } else {
                System.out.println("你的类型有误, 请自己检查...");
            }
        }
    }
}
```

#### 多态参数

方法定义的形参类型为父类类型，实参类型允许为子类类型应用实例

定义员工类Employee，包含姓名和月工资[private]，以及计算年工资getAnnual的方法。普通员工和经理继承了员工，经理类多了奖金bonus属性和管理manage方法，普通员工类多了work方法，普通员工和经理类要求分别重写getAnnual方法

测试类中添加一个方法showEmpAnnual(Employee e)，实现获取任何员工对象的年工资,并在main方法中调用该方法[e.getAnnual()]

测试类中添加一个方法，testWork,如果是普通员工，则调用work方法，如果是经理,则调用manage方法

```java
package com.hspedu.poly_.polyarr_;

public class Person {//父类
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String say() {//返回名字和年龄
        return name + "\t" + age;
    }
}
```

```java
package com.hspedu.poly_.polyarr_;

public class Student extends Person {
    private double score;

    public Student(String name, int age, double score) {
        super(name, age);
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
    //重写父类say

    @Override
    public String say() {
        return "学生 " + super.say() + " score=" + score;
    }
    //特有的方法
    public void study() {
        System.out.println("学生 " + getName() + " 正在学java...");
    }
}
```

```java
package com.hspedu.poly_.polyarr_;

public class Teacher extends Person {
    private double salary;

    public Teacher(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    //写重写父类的say方法

    @Override
    public String say() {
        return "老师 " + super.say() + " salary=" + salary;
    }
    //特有方法
    public void teach() {
        System.out.println("老师 " + getName() + " 正在讲java课程...");
    }
}
```

```java
package com.hspedu.poly_.polyarr_;

public class PloyArray {
    public static void main(String[] args) {
        //应用实例:现有一个继承结构如下：要求创建1个Person对象、
        // 2个Student 对象和2个Teacher对象, 统一放在数组中，并调用每个对象say方法

        Person[] persons = new Person[5];
        persons[0] = new Person("jack", 20);
        persons[1] = new Student("mary", 18, 100);
        persons[2] = new Student("smith", 19, 30.1);
        persons[3] = new Teacher("scott", 30, 20000);
        persons[4] = new Teacher("king", 50, 25000);

        //循环遍历多态数组，调用say
        for (int i = 0; i < persons.length; i++) {
            //老师提示: person[i] 编译类型是 Person ,运行类型是是根据实际情况有JVM来判断
            System.out.println(persons[i].say());//动态绑定机制
            //这里大家聪明. 使用 类型判断 + 向下转型.
            if(persons[i]  instanceof  Student) {//判断person[i] 的运行类型是不是Student
                Student student = (Student)persons[i];//向下转型
                student.study();
                //小伙伴也可以使用一条语句 ((Student)persons[i]).study();
            } else if(persons[i] instanceof  Teacher) {
                Teacher teacher = (Teacher)persons[i];
                teacher.teach();
            } else if(persons[i] instanceof  Person){
                //System.out.println("你的类型有误, 请自己检查...");
            } else {
                System.out.println("你的类型有误, 请自己检查...");
            }
        }
    }
}
```

## Object 类详解

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/04/13-16-01-30-1681372887.png)

### equals 方法

#### ==和equals 的对比!!!!!

==是一个比较运算符

==:既**可以判断基本类型，又可以判断引用类型**

+ ==:如果判断基本类型，判断的是**值是否相等**。示例: int i=10; double d=10.0;

+ ==:如果判断引用类型，判断的是地址是否相等，即**判定是不是同一个对象**

equals:是Object类中的方法，**只能判断引用类型**，看Jdk源码。（方法：光标放在方法上。然后按 `ctrl + B` 进行查看源码）

+ **默认判断的是地址是否相等，子类中往往重写该方法，用于判断内容是否相等**。比如 Integer,String【看看String和 Integer的equals源代码】

```java
package com.hspedu.object_;

public class Equals01 {

    public static void main(String[] args) {
        A a = new A();
        A b = a;
        A c = b;
        System.out.println(a == c);//true
        System.out.println(b == c);//true
        // 编译类型是B，但是本质上还是一个地址指向a
        B bObj = a;
        System.out.println(bObj == c);//true
        int num1 = 10;
        double num2 = 10.0;
        System.out.println(num1 == num2);// 基本数据类型，判断值是否相等

        //equals 方法，源码怎么查看.
        //把光标放在equals方法，直接输入ctrl+b
        //如果你使用不了. 自己配置. 即可使用.

        /*
        //带大家看看Jdk的源码 String类的 equals方法
        //把Object的equals方法重写了,变成了比较两个字符串值是否相同
        public boolean equals(Object anObject) {
        if (this == anObject) {//如果是同一个对象
            return true;//返回true
        }
        if (anObject instanceof String) {//判断类型
            String anotherString = (String)anObject;//向下转型
            int n = value.length;
            if (n == anotherString.value.length) {//如果长度相同
                char v1[] = value;
                char v2[] = anotherString.value;
                int i = 0;
                while (n-- != 0) {//然后一个一个的比较字符
                    if (v1[i] != v2[i])
                        return false;
                    i++;
                }
                return true;//如果两个字符串的所有字符都相等，则返回true
            }
        }
        return false;//如果比较的不是字符串，则直接返回false
    }
         */


        "hello".equals("abc");

        //看看Object类的 equals 是
        /*
        //即Object 的equals 方法默认就是比较对象地址是否相同
        //也就是判断两个对象是不是同一个对象.
         public boolean equals(Object obj) {
            return (this == obj);
        }
         */


        /*
        //从源码可以看到 Integer 也重写了Object的equals方法,
        //变成了判断两个值是否相同
        public boolean equals(Object obj) {
            if (obj instanceof Integer) {
                return value == ((Integer)obj).intValue();
            }
            return false;
        }
         */
        Integer integer1 = new Integer(1000);
        Integer integer2 = new Integer(1000);
        System.out.println(integer1 == integer2);//false
        System.out.println(integer1.equals(integer2));//true

        String str1 = new String("hspedu");
        String str2 = new String("hspedu");
        System.out.println(str1 == str2);//false
        System.out.println(str1.equals(str2));//true
    }
}

class B {}
class A extends B {}
```

### 如何重写 equals 方法

应用实例: 判断两个Person 对象的内容是否相等，如果两个Person 对象的各个属性值都一样，则返回true，反之false。

> 查看：com.hspedu.object_       EqualsExercise01

### hashCode 方法

public int **hashCode**()

返回该对象的哈希码值。支持此方法是为了提高哈希表（例如`java.util.Hashtable` 提供的哈希表）的性能。

`hashCode` 的常规协定是：

- 在 Java 应用程序执行期间，在对同一对象多次调用 hashCode 方法时，必须一致地返回相同的整数，前提是将对象进行 equals 比较时所用的信息没有被修改。从某一应用程序的一次执行到同一应用程序的另一次执行，该整数无需保持一致。
- 如果根据 equals(Object) 方法，两个对象是相等的，那么对这两个对象中的每个对象调用 `hashCode` 方法都必须生成相同的整数结果。
- 如果根据 [`equals(java.lang.Object)`](../../java/lang/Object.html#equals(java.lang.Object)) 
  方法，两个对象不相等，那么对这两个对象中的任一对象上调用 hashCode 方法*不* 
  要求一定生成不同的整数结果。但是，程序员应该意识到，为不相等的对象生成不同整数结果可以提高哈希表的性能。

实际上，由 Object 类定义的 hashCode 
方法确实会针对不同的对象返回不同的整数。（这一般是通过将该对象的内部地址转换成一个整数来实现的，但是 JavaTM 编程语言不需要这种实现技巧。）

**返回：**

此对象的一个哈希码值。

**另请参见：**

[`equals(java.lang.Object)`], [`Hashtable`]

#### 总结

1) 提高具有哈希结构的容器的效率！
2) 两个引用，如果指向的是同一个对象，则哈希值肯定是一样的！
3) 两个引用，如果指向的是不同对象，则哈希值是不一样的（当然也可能存在碰撞）
4) 哈希值主要根据地址号来的！ 不能完全将哈希值等价于地址。（java跑在JVM上，无法真正拿到其内部地址）。
5) 后面在集合，中hashCode 如果需要的话，也会重写, 在讲解集合时，具体看如何重写hashCode()代码。

### toString 方法

```java
public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }
```

1) 基本介绍
   默认返回：全类名+@+哈希值的十六进制，子类往往重写toString 方法，用于返回对象的属性信息（全类名就是包名 + 类名）

2) 重写toString 方法，打印对象或拼接对象时，都会自动调用该对象的toString 形式.

3) 当直接输出一个对象时， toString 方法会被默认的调用, 比如System.out.println(monster) ；// 就会默认调用monster.toString()

### finalize 方法

1) 当对象被回收时，系统自动调用该对象的finalize 方法。子类可以重写该方法，做一些**释放资源**（数据库的连接，打开或者关闭文件）的操作。
2) 什么时候被回收：当某个对象没有任何引用时，则jvm 就认为这个对象是一个垃圾对象，就会使用垃圾回收机制来销毁该对象，在销毁该对象前，会先调用finalize 方法。（当然并不是一有垃圾就立马回收，有对应的垃圾回收GC算法）。
3) 垃圾回收机制的调用，是由系统来决定(即有自己的GC算法), 也可以通过System.gc() 主动触发垃圾回收机制。
4) 我们在实际开发中，几乎不会运用finalize , 所以更多就是为了应付面试。

```java
package com.hspedu.object_;

//演示 Finalize的用法
public class Finalize_ {
    public static void main(String[] args) {

        Car bmw = new Car("宝马");
        //这时 car对象就是一个垃圾,垃圾回收器就会回收(销毁)对象, 在销毁对象前，会调用该对象的finalize方法
        //,程序员就可以在 finalize中，写自己的业务逻辑代码(比如释放资源：数据库连接,或者打开文件..)
        //,如果程序员不重写 finalize,那么就会调用 Object类的 finalize, 即默认处理
        //,如果程序员重写了 finalize, 就可以实现自己的逻辑
        bmw = null;
        System.gc();//主动调用垃圾回收器

        System.out.println("程序退出了....");
    }
}
class Car {
    private String name;
    //属性, 资源。。
    public Car(String name) {
        this.name = name;
    }
    //重写finalize
    @Override
    protected void finalize() throws Throwable {
        System.out.println("我们销毁 汽车" + name );
        System.out.println("释放了某些资源...");
    }
}

```

### 断点调试(debug)

在断点调试过程中，是运行状态，是以对象的运行类型来执行的.

`A extends B; Bb = new A(); b.xx();`

### 断点调试介绍

断点调试是指在程序的某一行设置一个断点，调试时，程序运行到这一行就会停住，然后你可以一步一步往下调试，调试过程中可以看各个变量当前的值，出错的话，调试到出错的代码行即显示错误，停下。进行分析从而找到这个Bug。

断点调试也能帮助我们查看java底层源代码的执行过程。

### 断点调试的快捷键

F7(跳入) F8(跳过) shift+F8(跳出) F9(resume,执行到下一个断点)

F7：跳入方法内

F8: 逐行执行代码.

shift+F8: 跳出方法

### Idea debug进入 Jdk源码

方法1：

使用force step into : 快捷键 alt + shift + F7

方法2：

这个配置一下就好了：点击Setting --> Build,Execution,Deployment --> Debugger --> Stepping 把Do not step into the classes中的java.*，javax.*取消勾选。

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/04/13-18-31-07-1681381866.png)

断点可以在debug 过程中，动态的下断点。（看复杂逻辑时常用）

### 项目-零钱通

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/04/13-18-59-31-1681383570.png)

```java
package com.hspedu.smallchange;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallChangeSys {

    //化繁为简
    //1. 先完成显示菜单，并可以选择菜单，给出对应提示
    //2. 完成零钱通明细
    //3. 完成收益入账
    //4. 消费
    //5. 退出
    //6. 用户输入4退出时，给出提示"你确定要退出吗? y/n"，必须输入正确的y/n ，否则循环输入指令，直到输入y 或者 n
    //7. 在收益入账和消费时，判断金额是否合理，并给出相应的提示
    public static void main(String[] args) {

        //定义相关的变量
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        String key = "";

        //2. 完成零钱通明细
        //老韩思路, (1) 可以把收益入账和消费，保存到数组 (2) 可以使用对象 (3) 简单的话可以使用String拼接
        String details = "-----------------零钱通明细------------------";

        //3. 完成收益入账  完成功能驱动程序员增加新的变化和代码
        //老韩思路, 定义新的变量
        double money = 0;
        double balance = 0;
        Date date = null; // date 是 java.util.Date 类型，表示日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm"); //可以用于日期格式化的

        //4. 消费
        //定义新变量，保存消费的原因
        String note = "";
        do {

            System.out.println("\n================零钱通菜单===============");
            System.out.println("\t\t\t1 零钱通明细");
            System.out.println("\t\t\t2 收益入账");
            System.out.println("\t\t\t3 消费");
            System.out.println("\t\t\t4 退     出");

            System.out.print("请选择(1-4): ");
            key = scanner.next();

            //使用switch 分支控制
            switch (key) {
                case "1":
                    System.out.println(details);
                    break;
                case "2":
                    System.out.print("收益入账金额:");
                    money = scanner.nextDouble();
                    //money 的值范围应该校验 -》 一会在完善
                    //老师思路, 编程思想
                    //找出不正确的金额条件，然后给出提示, 就直接break
                    if(money <= 0) {
                        System.out.println("收益入账金额 需要 大于 0");
                        break;
                    }
                    //找出正确金额的条件
                    balance += money;
                    //拼接收益入账信息到 details
                    date = new Date(); //获取当前日期
                    details += "\n收益入账\t+" + money + "\t" + sdf.format(date) + "\t" + balance;


                    break;
                case "3":
                    System.out.print("消费金额:");
                    money = scanner.nextDouble();
                    //money 的值范围应该校验 -》 一会在完善
                    //找出金额不正确的情况
                    //过关斩将 校验方式.
                    if(money <= 0 || money > balance) {
                        System.out.println("你的消费金额 应该在 0-" + balance);
                        break;
                    }
                    System.out.print("消费说明:");
                    note = scanner.next();
                    balance -= money;
                    //拼接消费信息到 details
                    date = new Date(); //获取当前日期
                    details += "\n" + note + "\t-" + money + "\t" + sdf.format(date) + "\t" + balance;
                    break;
                case "4":
                    //用户输入4退出时，给出提示"你确定要退出吗? y/n"，必须输入正确的y/n ，
                    // 否则循环输入指令，直到输入y 或者 n
                    // 老韩思路分析
                    // (1) 定义一个变量 choice, 接收用户的输入
                    // (2) 使用 while + break, 来处理接收到的输入时 y 或者 n
                    // (3) 退出while后，再判断choice是y还是n ,就可以决定是否退出
                    // (4) 建议一段代码，完成一个小功能，尽量不要混在一起
                    String choice = "";
                    while (true) { //要求用户必须输入y/n ,否则就一直循环
                        System.out.println("你确定要退出吗? y/n");
                        choice = scanner.next();
                        if ("y".equals(choice) || "n".equals(choice)) {
                            break;
                        }
                        //第二个方案
//                        if("y".equals(choice)) {
//                            loop = false;
//                            break;
//                        } else if ("n".equals(choice)) {
//                            break;
//                        }
                    }

                    //当用户退出while ,进行判断
                    if (choice.equals("y")) {
                        loop = false;
                    }
                    break;
                default:
                    System.out.println("选择有误，请重新选择");
            }

        } while (loop);

        System.out.println("-----退出了零钱通项目-----");

    }
}

```

改成OOP 版本，体会OOP 编程带来的好处

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/04/13-19-03-32-1681383810.png)

```java
package com.hspedu.smallchange.oop;

/**
 * 这里我们直接调用SmallChangeSysOOP 对象，显示主菜单即可
 */
public class SmallChangeSysApp {

    public static void main(String[] args) {
        System.out.println("====hello公司====");
        new SmallChangeSysOOP().mainMenu();
    }
}

```



```java
package com.hspedu.smallchange.oop;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 该类是完成零钱通的各个功能的类
 * 使用OOP(面向对象编程)
 * 将各个功能对应一个方法.
 */
public class SmallChangeSysOOP {

    //属性..
    //定义相关的变量
    boolean loop = true;
    Scanner scanner = new Scanner(System.in);
    String key = "";

    //2. 完成零钱通明细
    //老韩思路, (1) 可以把收益入账和消费，保存到数组 (2) 可以使用对象 (3) 简单的话可以使用String拼接
    String details = "-----------------零钱通明细------------------";

    //3. 完成收益入账  完成功能驱动程序员增加新的变化和代码
    //老韩思路, 定义新的变量
    double money = 0;
    double balance = 0;
    Date date = null; // date 是 java.util.Date 类型，表示日期
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm"); //可以用于日期格式化的

    //4. 消费
    //定义新变量，保存消费的原因
    String note = "";

    //先完成显示菜单，并可以选择
    public void mainMenu() {
        do {

            System.out.println("\n================零钱通菜单(OOP)===============");
            System.out.println("\t\t\t1 零钱通明细");
            System.out.println("\t\t\t2 收益入账");
            System.out.println("\t\t\t3 消费");
            System.out.println("\t\t\t4 退     出");

            System.out.print("请选择(1-4): ");
            key = scanner.next();

            //使用switch 分支控制
            switch (key) {
                case "1":
                    this.detail();
                    break;
                case "2":
                    this.income();
                    break;
                case "3":
                    this.pay();
                   break;
                case "4":
                    this.exit();
                    break;
                default:
                    System.out.println("选择有误，请重新选择");
            }

        } while (loop);
    }

    //完成零钱通明细
    public void detail() {
        System.out.println(details);
    }
    //完成收益入账
    public void income() {
        System.out.print("收益入账金额:");
        money = scanner.nextDouble();
        //money 的值范围应该校验 -》 一会在完善
        //老师思路, 编程思想
        //找出不正确的金额条件，然后给出提示, 就直接return
        if(money <= 0) {
            System.out.println("收益入账金额 需要 大于 0");
            return; //退出方法，不在执行后面的代码。
        }
        //找出正确金额的条件
        balance += money;
        //拼接收益入账信息到 details
        date = new Date(); //获取当前日期
        details += "\n收益入账\t+" + money + "\t" + sdf.format(date) + "\t" + balance;

    }
    //消费
    public void pay() {
        System.out.print("消费金额:");
        money = scanner.nextDouble();
        //money 的值范围应该校验 -》 一会在完善
        //找出金额不正确的情况
        //过关斩将 校验方式.
        if(money <= 0 || money > balance) {
            System.out.println("你的消费金额 应该在 0-" + balance);
            return;
        }
        System.out.print("消费说明:");
        note = scanner.next();
        balance -= money;
        //拼接消费信息到 details
        date = new Date(); //获取当前日期
        details += "\n" + note + "\t-" + money + "\t" + sdf.format(date) + "\t" + balance;
    }

    //退出
    public void exit() {
        //用户输入4退出时，给出提示"你确定要退出吗? y/n"，必须输入正确的y/n ，
        // 否则循环输入指令，直到输入y 或者 n
        // 老韩思路分析
        // (1) 定义一个变量 choice, 接收用户的输入
        // (2) 使用 while + break, 来处理接收到的输入时 y 或者 n
        // (3) 退出while后，再判断choice是y还是n ,就可以决定是否退出
        // (4) 建议一段代码，完成一个小功能，尽量不要混在一起
        String choice = "";
        while (true) { //要求用户必须输入y/n ,否则就一直循环
            System.out.println("你确定要退出吗? y/n");
            choice = scanner.next();
            if ("y".equals(choice) || "n".equals(choice)) {
                break;
            }
            //第二个方案
//                        if("y".equals(choice)) {
//                            loop = false;
//                            break;
//                        } else if ("n".equals(choice)) {
//                            break;
//                        }
        }

        //当用户退出while ,进行判断
        if (choice.equals("y")) {
            loop = false;
        }
    }
}

```
