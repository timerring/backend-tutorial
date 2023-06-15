- [第7章 面向对象编程(基础部分)](#第7章-面向对象编程基础部分)
  - [类与对象](#类与对象)
    - [类和对象的区别和联系](#类和对象的区别和联系)
    - [对象在内存中存在形式!](#对象在内存中存在形式)
    - [属性/成员变量/字段](#属性成员变量字段)
    - [如何创建对象](#如何创建对象)
    - [如何访问属性](#如何访问属性)
  - [成员方法](#成员方法)
    - [方法的调用机制原理!](#方法的调用机制原理)
    - [成员方法的好处](#成员方法的好处)
    - [成员方法的定义](#成员方法的定义)
  - [成员方法传参机制](#成员方法传参机制)
    - [引用数据类型的传参机制](#引用数据类型的传参机制)
    - [成员方法返回类型是引用类型应用实例](#成员方法返回类型是引用类型应用实例)
  - [方法递归调用](#方法递归调用)
    - [方法递归调用](#方法递归调用-1)
    - [递归重要规则](#递归重要规则)
    - [递归调用应用实例-汉诺塔](#递归调用应用实例-汉诺塔)
    - [递归调用应用实例-八皇后问题](#递归调用应用实例-八皇后问题)
  - [方法重载(OverLoad)](#方法重载overload)
    - [基本介绍](#基本介绍)
    - [重载的好处](#重载的好处)
    - [注意事项和使用细节](#注意事项和使用细节)
  - [可变参数](#可变参数)
    - [基本概念](#基本概念)
    - [基本语法](#基本语法)
    - [注意事项和使用细节](#注意事项和使用细节-1)
  - [作用域](#作用域)
    - [基本使用](#基本使用)
  - [构造方法/构造器](#构造方法构造器)
    - [基本介绍](#基本介绍-1)
    - [注意事项和使用细节](#注意事项和使用细节-2)
  - [javap的使用](#javap的使用)
  - [对象创建的流程分析](#对象创建的流程分析)
    - [流程分析!](#流程分析)
  - [this 关键字](#this-关键字)
    - [深入理解this](#深入理解this)
    - [this 的注意事项和使用细节](#this-的注意事项和使用细节)
    - [this 的案例](#this-的案例)


# 第7章 面向对象编程(基础部分)

## 类与对象

### 类和对象的区别和联系

1) 类是抽象的，概念的，代表一类事物,比如人类,猫类.., 即它是数据类型.
2) 对象是具体的，实际的，代表一个具体事物, 即是实例.
3) 类是对象的模板，对象是类的一个个体，对应一个实例

### 对象在内存中存在形式!

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/04/11-22-51-19-1681224677.png)

字符串本质上是一个引用类型，按照jvm的规则会把字符串放在方法区的常量池中间。

栈中的是对象引用（对象名），实际上的对象在堆中。

```java
// 创建Person 对象
// p1 是对象名(对象引用)
// new Person() 创建的对象空间(数据) 才是真正的对象
Person p1 = new Person();
// 对象的属性默认值，遵守数组规则:
```

### 属性/成员变量/字段

从概念或叫法上看： 成员变量 = 属性 = field(字段) （即成员变量是用来表示属性的，统一叫属性)

```java
class Car {
    String name;//属性, 成员变量, 字段field
    double price;
    String color;
    String[] master;//属性可以是基本数据类型，也可以是引用类型(对象，数组)
}
```

属性是类的一个组成部分，一般是基本数据类型, 也可是引用类型(对象，数组)。比如前面定义猫类的 int age 就是属性

注意事项和细节说明

1) 属性的定义语法同变量，示例：访问修饰符属性类型属性名;
   访问修饰符： 控制属性的访问范围
   有四种访问修饰符public, proctected, 默认, private ,后面我会详细介绍
2) 属性如果不赋值，有默认值，规则和数组一致。

### 如何创建对象

1) 先声明再创建
   Cat cat ; //声明对象cat
   cat = new Cat(); //创建
2) 直接创建
   Cat cat = new Cat();

### 如何访问属性

基本语法

对象名.属性名;

cat.name ;
cat.age;
cat.color;

```java
Person p1=new Person0;
p1.age=10;
p1.name="小明";
Person p2=p1;//把p1赋给了p2，让p2指向p1
System.out.println(p2.age);
```

请问:p2.age究竟是多少? 10 并画出内存图:

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/04/11-22-58-09-1681225088.png)

核心：引用传递传递的是地址。

## 成员方法

在某些情况下，我们要需要定义成员方法(简称方法)。

### 方法的调用机制原理!

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/04/12-10-11-39-1681265497.png)

### 成员方法的好处

1) 提高代码的复用性
2) 可以将实现的细节封装起来，然后供其他用户来调用即可

### 成员方法的定义

```java
访问修饰符 返回数据类型 方法名（形参列表..）{//方法体
    语句;
    return 返回值;
}
// 如果方法是void，则方法体中可以没有return 语句，或者只写return;
```

访问修饰符(作用是控制方法使用的范围)
如果不写默认访问，[有四种: public, protected, 默认, private]

方法不能嵌套定义!

## 成员方法传参机制

基本数据类型，传递的是值(值拷贝)，形参的任何改变不影响实参!

### 引用数据类型的传参机制

引用类型传递的是地址（**传递也是值，但是值是地址**），可以通过形参影响实参！

栈的值是地址，改的时候修改的是对应堆中的值。

例子：

```java
public class MethodParameter02 { 
    //编写一个main方法
    public static void main(String[] args) {
        //测试
        B b = new B();
        // int[] arr = {1, 2, 3};
        // b.test100(arr);//调用方法
        // System.out.println(" main的 arr数组 ");
        // //遍历数组
        // for(int i = 0; i < arr.length; i++) {
        //     System.out.print(arr[i] + "\t");
        // }
        // System.out.println();

        //测试
        Person p = new Person();
        p.name = "jack";
        p.age = 10;
        b.test200(p);
        //测试题, 如果 test200 执行的是 p = null ,下面的结果是 10
        //测试题, 如果 test200 执行的是 p = new Person();..., 下面输出的是10
        System.out.println("main 的p.age=" + p.age);//10000 
    }
}
class Person {
    String name;
    int age; 
}
class B {
    public void test200(Person p) {
        //p.age = 10000; //修改对象属性
        //思考
        p = new Person();
        p.name = "tom";
        p.age = 99;
        //思考
        //p = null; 
    }

    //B类中编写一个方法test100，
    //可以接收一个数组，在方法中修改该数组，看看原来的数组是否变化
    public void test100(int[] arr) {
        arr[0] = 200;//修改元素
        //遍历数组
        System.out.println(" test100的 arr数组 ");
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }
}
```

B 类中编写一个方法test100，可以接收一个数组，在方法中修改该数组，看看原来的数组是否变化？会变化

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/04/12-10-38-31-1681267109.png)

B 类中编写一个方法test200，可以接收一个Person(age,sal)对象，在方法中修改该对象属性，看看原来的对象是否变化？会变化.

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/04/12-10-42-40-1681267359.png)

p=null 和p = new Person(); 对应示意图

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/04/12-10-48-58-1681267736.png)

这里再对class B中的p进行修改，由于在Class B中重新new 了一个p，因此p的指针发生了改变，指向堆中的一个新空间，因此这时修改p的参数，不对main中对象造成影响。

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/04/12-10-51-42-1681267900.png)

### 成员方法返回类型是引用类型应用实例

通过这种方式可以编写方法复制对象。

```java
public class MethodExercise02 { 

    //编写一个main方法
    public static void main(String[] args) {

        Person p = new Person();
        p.name = "milan";
        p.age = 100;
        //创建tools
        MyTools tools = new MyTools();
        Person p2 = tools.copyPerson(p);

        //到此 p 和 p2是Person对象，但是是两个独立的对象，属性相同
        System.out.println("p的属性 age=" + p.age  + " 名字=" + p.name);
        System.out.println("p2的属性 age=" + p2.age  + " 名字=" + p2.name);
        //这里老师提示： 可以同 对象比较看看是否为同一个对象
        System.out.println(p == p2);//false


    }
}

class Person {
    String name;
    int age;
}

class MyTools {
    //编写一个方法copyPerson，可以复制一个Person对象，返回复制的对象。克隆对象， 
    //注意要求得到新对象和原来的对象是两个独立的对象，只是他们的属性相同
    //
    //编写方法的思路
    //1. 方法的返回类型 Person
    //2. 方法的名字 copyPerson
    //3. 方法的形参 (Person p)
    //4. 方法体, 创建一个新对象，并复制属性，返回即可

    public Person copyPerson(Person p) {
        //创建一个新的对象
        Person p2 = new Person();
        p2.name = p.name; //把原来对象的名字赋给p2.name
        p2.age = p.age; //把原来对象的年龄赋给p2.age
        return p2;
    }
}
```

## 方法递归调用

### 方法递归调用

列举两个小案例,来帮助大家理解递归调用机制

1) 打印问题
2) 阶乘问题

```java
public class Recursion01 { 

    //编写一个main方法
    public static void main(String[] args) {

        T t1 = new T();
        t1.test(4);//输出什么？ n=2 n=3 n=4
        int res = t1.factorial(5); 
        System.out.println("5的阶乘 res =" + res);
    }
}

class T {
    //分析
    public void test(int n) {
        if (n > 2) {
            test(n - 1);
        } 
        System.out.println("n=" + n);
    }

    //factorial 阶乘
    public int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return factorial(n - 1) * n;
        }
    }
}
```

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/04/12-10-58-56-1681268330.png)

### 递归重要规则

1.执行一个方法时，就创建一个新的受保护的独立空间(钱空间)

2.方法的局部变量是独立的,不会相互影响,比如n变量

3.如果方法中使用的是引用类型变量(比如数组，对象)，就会共享该引
用类型的数据。
4.递归必须向退出递归的条件逼近,否则就是无限递归,出现StackOverflowError
5.当一个方法执行完毕，或者遇到return，就会返回，遵守谁调用，就
将结果返回给谁，同时当方法执行完毕或者返回时，该方法也就执行完毕。

### 递归调用应用实例-汉诺塔

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/04/12-15-04-11-1681283048.png)

```java
public class HanoiTower { 

    //编写一个main方法
    public static void main(String[] args) {

        Tower tower = new Tower();
        tower.move(64, 'A', 'B', 'C');
    }
}

class Tower {

    //方法
    //num 表示要移动的个数, a, b, c 分别表示A塔，B 塔, C 塔
    public void move(int num , char a, char b ,char c) {
        //如果只有一个盘 num = 1
        if(num == 1) {
            System.out.println(a + "->" + c);
        } else {
            //如果有多个盘，可以看成两个 , 最下面的和上面的所有盘(num-1)
            //(1)先移动上面所有的盘到 b, 借助 c
            move(num - 1 , a, c, b);
            //(2)把最下面的这个盘，移动到 c
            System.out.println(a + "->" + c);
            //(3)再把 b塔的所有盘，移动到c ,借助a
            move(num - 1, b, a, c);
        }
    }
}
```

### 递归调用应用实例-八皇后问题

八皇后问题，是一个古老而著名的问题，是回溯算法的典型案例。该问题是国际西洋棋棋手马克斯·贝瑟尔于1848 年提出：在8×8 格的国际象棋上摆放八个皇后，使其不能互相攻击，即：任意两个皇后都不能处于同一行、同一列或同一斜线上，问有多少种摆法。

1) 第一个皇后先放第一行第一列

2) 第二个皇后放在第二行第一列、然后判断是否OK，如果不OK，继续放在第二列、第三列、依次把所有列都放完，找到一个合适

3) 继续第三个皇后,还是第一列、第二列...….直到第8个皇后也能放在一个不冲突的位置,算是找到了一个正确解

4) 当得到一个正确解时,在栈回退到上一个栈时，就会开始回溯，即将第一个皇后，放到第一列的所有正确解,全部得到.

5) 然后回头继续第一个皇后放第二列，后面继续循环执行1,2,3.4的步骤

6) 说明:理论上应该创建一个二维数组来表示棋盘，但是实际上可以通过算法，用一个一维数组即可解决问题. arr[8]={0,4,7,5.2, 6,1.3)//对应arr下标表示第几行，即第几个皇后，arr[i]= val , val表示第i+1个皇后，放在第i+1行的第val+1列

## 方法重载(OverLoad)

### 基本介绍

java 中允许同一个类中，多个同名方法的存在，但要求形参列表不一致！

### 重载的好处

1) 减轻了起名的麻烦
2) 减轻了记名的麻烦

### 注意事项和使用细节

1)方法名: **必须相同**

2)形参列表: **必须不同(形参类型或个数或顺序，至少有一样不同，参数名无要求)**

3)返回类型: 无要求

## 可变参数

### 基本概念

java 允许将同一个类中多个同名同功能但参数个数不同的方法，封装成一个方法。就可以通过可变参数实现

### 基本语法

```java
访问修饰符返回类型方法名(数据类型... 形参名) {
}
```

看一个案例类HspMethod，方法sum。

```java
public class VarParameter01 { 
    //编写一个main方法
    public static void main(String[] args) {
        HspMethod m = new HspMethod();
        System.out.println(m.sum(1, 5, 100)); //106
        System.out.println(m.sum(1,19)); //20
    }
}

class HspMethod {
    //可以计算 2个数的和，3个数的和 ， 4. 5， 。。
    //可以使用方法重载
    // public int sum(int n1, int n2) {//2个数的和
    //     return n1 + n2;
    // }
    // public int sum(int n1, int n2, int n3) {//3个数的和
    //     return n1 + n2 + n3;
    // }
    // public int sum(int n1, int n2, int n3, int n4) {//4个数的和
    //     return n1 + n2 + n3 + n4;
    // }
    //.....
    //上面的三个方法名称相同，功能相同, 参数个数不同-> 使用可变参数优化
    //老韩解读
    //1. int... 表示接受的是可变参数，类型是int ,即可以接收多个int(0-多) 
    //2. 使用可变参数时，可以当做数组来使用 即 nums 可以当做数组
    //3. 遍历 nums 求和即可
    public int sum(int... nums) {
        //System.out.println("接收的参数个数=" + nums.length);
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            res += nums[i];
        }
        return res;
    }
}
```

### 注意事项和使用细节

1)可变参数的实参可以为0个或任意多个。

2)可变参数的实参可以为数组。

3)**可变参数的本质就是数组。**

4)可变参数可以和普通类型的参数一起放在形参列表，但必须**保证可变参数在最后**。

5)**一个形参列表中只能出现一个可变参数**。

```java
public void f3(int... nums1, double... nums2) （X错误）
```

## 作用域

### 基本使用

1.在java编程中，主要的变量就是**属性(成员变量)** 和 **局部变量**。

2.我们说的**局部变量一般是指在成员方法中定义的变量**。

3.java中作用域的分类

全局变量：也就是属性，作用域为整个类体 （Cat类:cry eat等方法使用属性）

局部变量：也就是除了属性之外的其他变量，作用域为定义它的代码块中!

4.全局变量(属性)可以不赋值，直接使用，因为有默认值，局部变量必须赋值后，
才能使用，因为没有默认值。

```java
public class VarScope { 
    //编写一个main方法
    public static void main(String[] args) {
    }
}
class Cat {
    //全局变量：也就是属性，作用域为整个类体 Cat类：cry eat 等方法使用属性
    //属性在定义时，可以直接赋值
    int age = 10; //指定的值是 10

    //全局变量(属性)可以不赋值，直接使用，因为有默认值，
    double weight;  //默认值是0.0

    public void hi() {
        //局部变量必须赋值后，才能使用，因为没有默认值
        int num = 1;
        String address = "北京的猫";
        System.out.println("num=" + num);
        System.out.println("address=" + address);
        System.out.println("weight=" + weight);//属性
    }
    public void cry() {
        //1. 局部变量一般是指在成员方法中定义的变量
        //2. n 和  name 就是局部变量
        //3. n 和 name的作用域在 cry方法中
        int n = 10;
        String name = "jack";
        System.out.println("在cry中使用属性 age=" + age);
    }
    public void eat() {
        System.out.println("在eat中使用属性 age=" + age);
        //System.out.println("在eat中使用 cry的变量 name=" + name);//错误
    }
}
```

1.属性和局部变量可以重名,访问时遵循就近原则。

2.在同一个作用域中，比如在同一个成员方法中，两个局部变量，不能重名。

3.属性生命周期较长，伴随着对象的创建而创建，伴随着对象的销毁而销毁。局部变
量，生命周期较短，伴随着它的代码块的执行而创建，伴随着代码块的结束而销毁。

4.作用域范围不同

全局变量/属性：可以被本类使用，或其他类使用(通过对象调用)

局部变量:只能在本类中对应的方法中使用

5.修饰符不同

**全局变量/属性可以加修饰符**

**局部变量不可以加修饰符**

## 构造方法/构造器

```java
[修饰符] 方法名(形参列表){
    方法体;
}
```

1) 构造器的修饰符可以默认， 也可以是public protected private
2) 构造器没有返回值
3) **方法名和类名字必须一样**
4) 参数列表和成员方法一样的规则
5) 构造器的调用, 由**系统完成**

### 基本介绍

构造方法又叫构造器(constructor)，是类的一种特殊的方法，它的主要作用是完成对新对象的初始化。它有几个特点：

1) **方法名和类名**相同
2) 没有返回值
3) 在创建对象时，系统会自动的调用该类的构造器完成对象的初始化。

### 注意事项和使用细节

1.一个类可以定义多个不同的构造器,即构造器重载

> 比如：我们可以再给Person类定义一个构造器,用来创建对象的时候,只指定人名,不需要指定年龄。

2.构造器名和类名要相同

3.构造器没有返回值

4.**构造器是完成对象的初始化,并不是创建对象**

5.在创建对象时，系统自动的调用该类的构造方法

6.如果程序员没有定义构造器，**系统会自动给类生成一个默认无参构造器**(也
叫默认构造器). 比如Dog(){}, 使用javap指令反编译看看

> 可以使用javap Dog.class 查看

7.一旦定义了自己的构造器,默认的构造器就覆盖了，就不能再使用默认的无
参构造器，除非显式的定义一下,即:Dog(){}

## javap的使用

javap是JDK提供的一个命令行工具,javap能对给定的class文件提供的字节代码进行反编译。 通过它，可以对照源代码和字节码，从而了解很多编译器内部的工作。 

使用格式

```java
javap <options> <classes>
```

常用

```java
javap -c -v 类名
```

```text
  -help  --help  -?        输出此用法消息
  -version                 版本信息
  -v  -verbose             输出附加信息
  -l                       输出行号和本地变量表
  -public                  仅显示公共类和成员
  -protected               显示受保护的/公共类和成员
  -package                 显示程序包/受保护的/公共类
                           和成员 (默认)
  -p  -private             显示所有类和成员
  -c                       对代码进行反汇编
  -s                       输出内部类型签名
  -sysinfo                 显示正在处理的类的
                           系统信息 (路径, 大小, 日期, MD5 散列)
  -constants               显示最终常量
  -classpath <path>        指定查找用户类文件的位置
  -cp <path>               指定查找用户类文件的位置
  -bootclasspath <path>    覆盖引导类文件的位置
```

## 对象创建的流程分析

```java
class Person{//类Person
    int age=90;
    String name;
    Person(String n,int a){//构造器
    name=n;//给属性赋值
    age=a;//..
    }
}
Person p=new Person("TIMERRING",20);
```

### 流程分析!

1.加载Person类信息(Person.class) 到方法区，只会加载一次

2.在堆中分配空间(地址)

3.完成对象初始化[3.1默认初始化 age=0 name=null 3.2显式初始化age=90,name=null,3.3构造器的初始化 age =20, name=TIMERRING]

4.在对象在堆中的地址,返回给p(p是对象名,也可以理解成是对象的引用)

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/04/12-16-30-59-1681288256.png)

## this 关键字

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/04/12-16-35-48-1681288546.png)

可以正常运行，但是是否可以将构造函数的形参改为属性值呢？可以用this。

```java
public class This01 { 

    //编写一个main方法
    public static void main(String[] args) {

        Dog dog1 = new Dog("大壮", 3);
        System.out.println("dog1的hashcode=" + dog1.hashCode());
        //dog1调用了 info()方法
        dog1.info(); 

        System.out.println("============");
        Dog dog2 = new Dog("大黄", 2);
        System.out.println("dog2的hashcode=" + dog2.hashCode());
        dog2.info();
    }
}

class Dog{ //类

    String name;
    int age;
    // public Dog(String dName, int  dAge){//构造器
    //     name = dName;
    //     age = dAge;
    // }
    //如果我们构造器的形参，能够直接写成属性名，就更好了
    //但是出现了一个问题，根据变量的作用域原则
    //构造器的 name 是局部变量，而不是属性
    //构造器的 age  是局部变量，而不是属性
    //==> 引出this关键字来解决
    public Dog(String name, int  age){//构造器
        //this.name 就是当前对象的属性name
        this.name = name;
        //this.age 就是当前对象的属性age
        this.age = age;
        System.out.println("this.hashCode=" + this.hashCode());
    }

    public void info(){//成员方法,输出属性x信息
        System.out.println("this.hashCode=" + this.hashCode());
        System.out.println(name + "\t" + age + "\t");
    }
}
```

java虚拟机会给每个对象分配this, 代表当前对象。

this.name 就是**当前对象**的**属性**name。

### 深入理解this

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/04/12-16-45-37-1681289136.png)

隐藏的this指向自己的堆地址。

### this 的注意事项和使用细节

1) this 关键字可以用来**访问本类的属性、方法、构造器**

2) this 用于区分当前类的属性和局部变量

3) 访问成员方法的语法：this.方法名(参数列表);

4) 访问构造器语法：this(参数列表); **注意只能在构造器中使用**(即只能在构造器中访问另外一个构造器, **必须放在第一条语句**)
   
   ```java
   public class ThisDetail { 
   
       //编写一个main方法
       public static void main(String[] args) {
   
           // T t1 = new T();
           // t1.f2();
           T t2 = new T();
           t2.f3();
   
       }
   }
   
   class T {
   
       String name = "jack";
       int num = 100;
   
       /*
       细节: 访问构造器语法：this(参数列表); 
       注意只能在构造器中使用(即只能在构造器中访问另外一个构造器)
       注意： 访问构造器语法：this(参数列表); 必须放置第一条语句!!!
        */
       public T() {
           //这里去访问 T(String name, int age) 构造器
           this("jack", 100);
           System.out.println("T() 构造器");
       }
   
       public T(String name, int age) {
           System.out.println("T(String name, int age) 构造器");
       }
   
       //this关键字可以用来访问本类的属性
       public void f3() {
           String name = "smith";
           //传统方式（按照就近原则，有局部变量先访问局部变量）
           System.out.println("name=" + name + " num=" + num);//smith  100
           //也可以使用this访问属性（准确地就访问属性）
           System.out.println("name=" + this.name + " num=" + this.num);//jack 100
       }
       //细节: 访问成员方法的语法：this.方法名(参数列表);
       public void f1() {
   
           System.out.println("f1() 方法..");
       }
   
       public void f2() {
           System.out.println("f2() 方法..");
           //调用本类的 f1
           //第一种方式
           f1();
           //第二种方式
           this.f1();
       }
   
   }
   ```

5) this 不能在类定义的外部使用，**只能在类定义的方法中使用**。

### this 的案例

```java
public class TestPerson { 

    //编写一个main方法
    public static void main(String[] args) {

        Person p1 = new Person("mary", 20);
        Person p2 = new Person("mary", 20);
        System.out.println("p1和p2比较的结果=" + p1.compareTo(p2));
    }
}

/*
定义Person类，里面有name、age属性，并提供compareTo比较方法，
用于判断是否和另一个人相等，提供测试类TestPerson用于测试, 
名字和年龄完全一样，就返回true, 否则返回false

 */
class Person {
    String name;
    int age;
    //构造器
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    //compareTo比较方法
    public boolean compareTo(Person p) {
        return this.name.equals(p.name) && this.age == p.age;
    }
}
```


