# 第10章 面向对象编程(高级部分)

## 类变量和类方法

### 类变量-提出问题

在main方法中定义一个变量count，当一个小孩加入游戏后count++，最后个count 就记录有多少小孩玩游戏 。

问题分析: 

count是一个独立于对象,很尴尬，以后我们访问count很麻烦,没有使用到OOP。因此,我们引出类变量/静态变量。

```java
package com.hspedu.static_;

public class ChildGame {

    public static void main(String[] args) {

        //定义一个变量 count, 统计有多少小孩加入了游戏
        int count = 0;

        Child child1 = new Child("白骨精");
        child1.join();
        //count++;
        child1.count++;

        Child child2 = new Child("狐狸精");
        child2.join();
        //count++;
        child2.count++;

        Child child3 = new Child("老鼠精");
        child3.join();
        //count++;
        child3.count++;

        //===========
        // 类变量，可以通过类名来访问
        System.out.println("共有" + Child.count  + " 小孩加入了游戏...");
        // 下面的代码输出什么?
        System.out.println("child1.count=" + child1.count);//3
        System.out.println("child2.count=" + child2.count);//3
        System.out.println("child3.count=" + child3.count);//3



    }
}

class Child { //类
    private String name;
    // 定义一个变量 count ,是一个类变量(静态变量) static 静态!!!
    // 该变量最大的特点就是会被 Child 类的所有的对象实例共享!!!
    public static int count = 0;
    public Child(String name) {
        this.name = name;
    }
    public void join() {
        System.out.println(name + " 加入了游戏..");
    }
}
```

### 类变量内存布局

https://blog.csdn.net/x_iya/article/details/81260154/

https://www.zhihu.com/question/59174759/answer/163207831

有些书说在方法区... jdk 版本有关系,记住两点：

(1) static变量是同一个类所有对象共享

(2) static类变量，在类加载的时候就生成了.静态变量是类加载的时候，就创建了,所以不用创建对象实例也能直接通过 `类名.类变量名` 访问。

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/04/15-22-21-58-1681568517.png)

### 什么是类变量

类变量也叫静态变量/静态属性，是该类的所有对象共享的变量,任何一个该类的对象去访问它时,取到的都是相同的值,同样任何一个该类的对象去修改它时,修改的也是同一个变量。这个从前面的图也可看出来。

### 如何定义类变量

定义语法:

**访问修饰符static数据类型变量名;[推荐]**

static访问修饰符数据类型变量名;

### 如何访问类变量

类名.类变量名

或者对象名.类变量名【静态变量的访问修饰符的访问权限和范围和普通属性是一样的】

推荐使用:类名.类变量名;

### 类变量使用注意事项

1.什么时候需要用类变量

当我们需要让某个类的所有对象都共享一个变量时，就可以考虑使用类变量(静态变量):比如:定义学生类，统计所有学生共交多少钱。Student (name, staticfee)

2.类变量与实例变量(普通属性)区别

类变量是该类的所有对象共享的,而实例变量是每个对象独享的。

3.加上static称为类变量或静态变量，否则称为实例变量/普通变量/非静态变量

4.类变量可以通过类名.类变量名或者对象名.类变量名来访问，但java设计者推荐我们使用类名.类变量名方式访问。【前提是满足访问修饰符的访问权限和范围】

5.实例变量不能通过类名.类变量名方式访问。

6.类变量是在类加载时就初始化了，也就是说，即使你没有创建对象，只要类加载了.就可以使用类变量了。

7.类变量的生命周期是随类的加载开始,随着类消亡而销毁。

### 类方法基本介绍

类方法也叫静态方法。形式如下:

**访问修饰符 static 数据返回类型 方法名(){}【推荐】**

static 访问修饰符 数据返回类型 方法名(){}

### 类方法的调用

使用方式:

类名.类方法名或者对象名.类方法名

```java
package com.hspedu.static_;

public class StaticMethod {
    public static void main(String[] args) {
        //创建2个学生对象，叫学费
        Stu tom = new Stu("tom");
        //tom.payFee(100);
        Stu.payFee(100);//对不对?对

        Stu mary = new Stu("mary");
        //mary.payFee(200);
        Stu.payFee(200);//对


        //输出当前收到的总学费
        Stu.showFee();//300

        //如果我们希望不创建实例，也可以调用某个方法(即当做工具来使用)
        //这时，把方法做成静态方法时非常合适
        System.out.println("9开平方的结果是=" + Math.sqrt(9));


        System.out.println(MyTools.calSum(10, 30));
    }
}
//开发自己的工具类时，可以将方法做成静态的，方便调用
class MyTools  {
    //求出两个数的和
    public static double calSum(double n1, double n2) {
        return  n1 + n2;
    }
    //可以写出很多这样的工具方法...
}
class Stu {
    private String name;//普通成员
    //定义一个静态变量，来累积学生的学费
    private static double fee = 0;

    public Stu(String name) {
        this.name = name;
    }
    // 说明
    // 1. 当方法使用了static修饰后，该方法就是静态方法
    // 2. 静态方法就可以访问静态属性/变量
    public static void payFee(double fee) {
        Stu.fee += fee;//累积到
    }
    public static void showFee() {
        System.out.println("总学费有:" + Stu.fee);
    }
}
```

### 类方法经典的使用场景

当方法中不涉及到任何和对象相关的成员，则可以将方法设计成静态方法, 提高开发效率。

比如:

工具类中的方法utils。Math类、Arrays类、Collections集合类看下源码可以发现都是static方法。

### 类方法使用注意事项和细节讨论

1. 类方法和普通方法都是随着类的加载而加载，将结构信息存储在方法区∶类方法中无this的参数。普通方法中隐含着this的参数。

2. 类方法可以通过类名调用，也可以通过对象名调用。普通方法和对象有关，需要通过对象名调用，比如对象名.方法名(参数)，不能通过类名调用。

3. **类方法中不允许使用和对象有关的关键字**，比如this和super。普通方法(成员方法)可以。

4. **类方法(静态方法)中只能访问静态变量或静态方法**。普通成员方法,既可以访问非静态成员,也可以访问静态成员!!

```java
package com.hspedu.static_;

public class StaticMethodDetail {
    public static void main(String[] args) {

        D.hi();//ok
        //非静态方法，不能通过类名调用
        //D.say();, 错误，需要先创建对象，再调用
        new D().say();//可以
    }
}
class D {

    private int n1 = 100;
    private static  int n2 = 200;
    public void say() {//非静态方法,普通方法

    }

    public static  void hi() {//静态方法,类方法
        //类方法中不允许使用和对象有关的关键字，
        //比如this和super。普通方法(成员方法)可以。
        //System.out.println(this.n1);
    }

    //类方法(静态方法)中 只能访问 静态变量 或静态方法
    //口诀:静态方法只能访问静态成员.
    public static void hello() {
        System.out.println(n2);
        System.out.println(D.n2);
        //System.out.println(this.n2);不能使用
        hi();//OK
        //say();//错误
    }
    //普通成员方法，既可以访问  非静态成员，也可以访问静态成员
    //小结: 非静态方法可以访问 静态成员和非静态成员
    public void ok() {
        //非静态成员
        System.out.println(n1);
        say();
        //静态成员
        System.out.println(n2);
        hello();

    }
}
```

练习：

```java
package com.hspedu.static_;

public class StaticExercise03 {
}

class Person {
    private int id;
    private static int total = 0;
    public static void setTotalPerson(int total){
        // this.total = total;//错误，因为在static方法中，不可以使用this 关键字

        Person.total = total;
    }
    public Person() {//构造器
        total++;
        id = total;
    }
    //编写一个方法，输出total的值
    public static void m() {
        System.out.println("total的值=" + total);
    }
}
class TestPerson {
    public static void main(String[] args) {

        Person.setTotalPerson(3); // 这里没有调用构造器
        new Person(); // new了之后调用构造器，count++
        Person.m();// 最后 total的值就是4
    }
}
```

注意：

Person.setTotalPerson(3); 调用静态方法 这里还没有调用构造器

new Person();  new了之后才调用构造器，count++

因为构造器是在创建对象时完成对对象的初始化。

## 理解main 方法语法

### 深入理解main 方法

解释main方法的形式: `public static void main(String[] args){}`

1.main方法时虚拟机调用

2.java虚拟机需要调用类的main()方法，所以该方法的访问权限必须是public

3.java虚拟机在执行main()方法时不必创建对象，所以该方法必须是static

4.该方法接收String类型的数组参数，该数组中保存执行java命令时传递给所运行的类的参数,案例演示，接收参数.

5.java执行的程序参数1参数2参数。

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/04/16-13-59-29-1681624767.png)

说明:在idea如何传递参数？

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/04/16-14-03-08-1681624986.png)

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/04/16-14-04-01-1681625037.png)

在Program arguments 中传入参数即可。

### 特别提示

在main()方法中，我们可以直接调用main 方法所在类的静态方法或静态属性。但是，不能直接访问该类中的非静态成员，必须创建该类的一个实例对象后，才能通过这个对象去访问类中的非静态成员。

## 代码块

### 基本介绍

代码化块又称为初始化块,属于类中的成员[即是类的一部分]，类似于方法，将逻辑语句封装在方法体中，通过包围起来。

但和方法不同，没有方法名，没有返回，没有参数，**只有方法体**，而且不用通过对象或类显式调用，而是**加载类时，或创建对象时隐式调用**。

### 基本语法

```java
[修饰符]{
   代码
};
```

说明注意;

1. 修饰符可选,要写的话,也只能写static

2. 代码块分为两类，使用static修饰的叫静态代码块，没有static修饰的，叫普通代码块/非静态代码块。

3. 逻辑语句可以为任何逻辑语句(输入、输出、方法调用、循环、判断等)

4. ；号可以写上,也可以省略。

### 代码块的好处和案例演示

1) 相当于另外一种形式的构造器(对构造器的补充机制)，可以做初始化的操作

2) 场景:如果多个构造器中都有重复的语句，可以抽取到初始化块中，提高代码的重用性

这样当我们不管调用哪个构造器，创建对象，都会先调用代码块的内容，代码块调用的顺序优先于构造器。

```java
package com.hspedu.codeblock_;

public class CodeBlock01 {
    public static void main(String[] args) {
        Movie movie = new Movie("你好，李焕英");
        System.out.println("===============");
        Movie movie2 = new Movie("唐探3", 100, "陈思诚");
    }
}

class Movie {
    private String name;
    private double price;
    private String director;

    // 3个构造器-》重载
    {
        System.out.println("电影屏幕打开...");
        System.out.println("广告开始...");
        System.out.println("电影正是开始...");
    };

    public Movie(String name) {
        System.out.println("Movie(String name) 被调用...");
        this.name = name;
    }

    public Movie(String name, double price) {

        this.name = name;
        this.price = price;
    }

    public Movie(String name, double price, String director) {

        System.out.println("Movie(String name, double price, String director) 被调用...");
        this.name = name;
        this.price = price;
        this.director = director;
    }
}
```

### 代码块使用注意事项和细节讨论!!!

1) static代码块也叫静态代码块，作用就是对类进行初始化，而且它随着**类的加载**而执行，并且只会执行一次。如果是普通代码块，每创建一个对象, 就执行一次。

2) **类什么时候被加载**
   
   + **创建对象实例时(new)**
   + **创建子类对象实例,父类也会被加载**
   + **使用类的静态成员时(静态属性,静态方法)**

3) 普通的代码块，**在创建对象实例**时，会被隐式的调用。被创建一次，就会调用一次。
   
   **如果只是使用类的静态成员时,普通代码块并不会执行。（没有创建对象实例）**

4) 创建一个对象时，在一个类调用顺序是 **(重点，难点)** ∶
   
   1. 调用静态代码块和静态属性初始化 (注意:静态代码块和静态属性初始化调用的优先级一样，如果有多个静态代码块和多个静态变量初始化，则按他们定义的先后顺序调用)
   
   2. 调用普通代码块和普通属性的初始化(注意:普通代码块和普通属性初始化调用的优先级一样,如果有多个普通代码块和多个普通属性初始化,则按定义先后顺序调用)
   
   3. 调用构造方法

5) 构造器的最前面其实隐含了**super()和调用普通代码块**, 静态相关的代码块，属性初始化，在类加载时，就执行完毕，因此是优先于构造器和普通代码块执行的。

6) **我们看一下创建一个子类对象时(继承关系)，他们的调用顺序如下**:
   
   1. 父类的静态代码块和静态属性(优先级一样,按定义顺序执行)（类加载）
   
   2. 子类的静态代码块和静态属性(优先级一样,按定义顺序执行)（类加载）
   
   3. 父类的普通代码块和普通属性初始化(优先级一样，按定义顺序执行)
   
   4. 父类的构造方法
   
   5. 子类的普通代码块和普通属性初始化(优先级一样，按定义顺序执行)
   
   6. 子类的构造方法

7) 静态代码块（本质上是静态方法）只能直接调用静态成员(静态属性和静态方法)，普通代码块（本质上是普通方法）可以调用任意成员。

```java
package com.hspedu.codeblock_;

public class CodeBlockDetail04 {
    public static void main(String[] args) {
        //老师说明
        //(1) 进行类的加载
        //1.1 先加载 父类 A02 1.2 再加载 B02
        //(2) 创建对象
        //2.1 从子类的构造器开始
        //new B02();//对象

        new C02();
    }
}

class A02 { //父类
    private static int n1 = getVal01();
    static {
        System.out.println("A02的一个静态代码块..");//(2)
    }
    {
        System.out.println("A02的第一个普通代码块..");//(5)
    }
    pulic int n3 = getVal02();//普通属性的初始化
    public static int getVal01() {
        System.out.println("getVal01");//(1)
        return 10;
    }

    public int getVal02() {
        System.out.println("getVal02");//(6)
        return 10;
    }

    public A02() {//构造器
        //隐藏
        //super()
        //普通代码和普通属性的初始化......
        System.out.println("A02的构造器");//(7)
    }

}

class C02 {
    private int n1 = 100;
    private static  int n2 = 200;

    private void m1() {

    }
    private static void m2() {

    }

    static {
        //静态代码块，只能调用静态成员
        //System.out.println(n1);错误
        System.out.println(n2);//ok
        //m1();//错误
        m2();
    }
    {
        //普通代码块，可以使用任意成员
        System.out.println(n1);
        System.out.println(n2);//ok
        m1();
        m2();
    }
}

class B02 extends A02 { //

    private static int n3 = getVal03();

    static {
        System.out.println("B02的一个静态代码块..");//(4)
    }
    public int n5 = getVal04();
    {
        System.out.println("B02的第一个普通代码块..");//(9)
    }

    public static int getVal03() {
        System.out.println("getVal03");//(3)
        return 10;
    }

    public int getVal04() {
        System.out.println("getVal04");//(8)
        return 10;
    }
    //一定要慢慢的去品..
    public B02() {//构造器
        //隐藏了
        //super()
        //普通代码块和普通属性的初始化...
        System.out.println("B02的构造器");//(10)
        // TODO Auto-generated constructor stub
    }
}
```

练习：

```java
package com.hspedu.codeblock_;

public class CodeBlockExercise02 {
}

class Sample
{
    Sample(String s)
    {
        System.out.println(s);
    }
    Sample()
    {
        System.out.println("Sample默认构造函数被调用");
    }
}
class Test{
    Sample sam1=new Sample("sam1成员初始化");//
    static Sample sam=new Sample("静态成员sam初始化 ");//
    static{
        System.out.println("static块执行");//
        if(sam==null)System.out.println("sam is null");
    }
    Test()//构造器
    {
        System.out.println("Test默认构造函数被调用");//
    }
    //主方法
    public static void  main(String  str[])
    {
        Test a=new Test();//无参构造器
    }

}

1. 静态成员sam 初始化
2. static 块执行
3. sam1 成员初始化
4. Test 默认构造函数被调用
```

## 单例设计模式

### 什么是设计模式

静态方法和属性的经典使用

设计模式是在大量的实践中总结和理论化之后优选的代码结构、编程风格、以及解决问题的思考方式。设计模式就像是经典的棋谱,不同的棋局,我们用不同的棋谱，免去我们自己再思考和摸索。

### 什么是单例模式

1. 所谓类的单例设计模式，就是采取一定的方法保证在整个的软件系统中，对**某个类只能存在一个对象实例**，并且该类只提供一个取得其对象实例的方法。

2. 单例模式有两种方式:1) 饿汉式 2) 懒汉式

#### 饿汉式

步骤如下:

1) 构造器私有化 =》防止直接new

2) 类的内部创建对象

3) 向外暴露一个静态的公共方法。getlnstance

饿汉式：有可能还没有用到这个对象，但是由于类的机制已经将对象创建好了。在线程还没出现之前就已经实例化了,因此饿汉式线程一定是安全的。

```java
package com.hspedu.single_;

public class SingleTon01 {

    public static void main(String[] args) {
//        GirlFriend xh = new GirlFriend("小红");
//        GirlFriend xb = new GirlFriend("小白");

        //通过方法可以获取对象
        GirlFriend instance = GirlFriend.getInstance();
        System.out.println(instance);
        // 都是同一个对象
        GirlFriend instance2 = GirlFriend.getInstance();
        System.out.println(instance2);

        System.out.println(instance == instance2);// T 同一个对象
        //System.out.println(GirlFriend.n1);
    }
}

// 有一个类， GirlFriend
// 只能有一个女朋友
class GirlFriend {

    private String name;
    // public static  int n1 = 100;
    // 为了能够在静态方法中，返回 gf对象，需要将其修饰为static
    // 對象，通常是重量級的對象, 餓漢式可能造成創建了對象，但是沒有使用.
    // 只要类加载了，就一定创建了gf对象
    private static GirlFriend gf = new GirlFriend("小红红");

    // 如何保障我们只能创建一个 GirlFriend 对象
    // 步骤[单例模式-饿汉式]
    // 1. 将构造器私有化
    // 2. 在类的内部直接创建对象(该对象是static)
    // 3. 提供一个公共的static方法，返回 gf 对象
    private GirlFriend(String name) {
        System.out.println("構造器被調用.");
        this.name = name;
    }

    // 用static的目的就是在不创建对象的前提下直接调用
    public static GirlFriend getInstance() {
        return gf;
    }

    @Override
    public String toString() {
        return "GirlFriend{" +
                "name='" + name + '\'' +
                '}';
    }
}
```

#### 懒汉式

懶漢式，只有當用戶使用getInstance時，才返回cat對象, 後面再次調用時，會返回上次創建的cat對象。

懒汉式可能会存在线程安全的问题。

```java
package com.hspedu.single_;

/**
 * 演示懶漢式的單例模式
 */
public class SingleTon02 {
    public static void main(String[] args) {
        //new Cat("大黃");
        //System.out.println(Cat.n1);
        Cat instance = Cat.getInstance();
        System.out.println(instance);


        //再次調用getInstance
        Cat instance2 = Cat.getInstance();
        System.out.println(instance2);

        System.out.println(instance == instance2);//T

    }
}


//希望在程序運行過程中，只能創建一個Cat對象
//使用單例模式
class Cat {
    private String name;
    public static  int n1 = 999;
    private static Cat cat ; //默認是null

    //步驟
    //1.仍然構造器私有化
    //2.定義一個static靜態屬性對象
    //3.提供一個public的static方法，可以返回一個Cat對象
    //4.懶漢式，只有當用戶使用getInstance時，才返回cat對象, 後面再次調用時，會返回上次創建的cat對象
    //  從而保證了單例
    private Cat(String name) {
        System.out.println("構造器調用...");
        this.name = name;
    }
    public static Cat getInstance() {

        if(cat == null) {//如果還沒有創建cat對象
            cat = new Cat("小可愛");
        }
        return cat;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}
```

#### 比较

1. 二者最主要的区别在于创建对象的时机不同:饿汉式是在类加载就创建了对象实例,而懒汉式是在使用时才创建。

2. 饿汉式不存在线程安全问题，懒汉式存在线程安全问题。(后面学习线程后，会完善一把)。

3. 饿汉式存在浪费资源的可能。因为如果程序员一个对象实例都没有使用，那么饿汉式创建的对象就浪费了，懒汉式是使用时才创建，就不存在这个问题。

4. 在我们javaSE标准类中，java.lang.Runtime就是经典的单例模式.

## final 关键字

### 基本介绍

final中文意思:最后的,最终的.

final可以修饰类、属性、方法和局部变量

在某些情况下,程序员可能有以下需求，就会使用到final:

1) 当不希望类被继承时,可以用final修饰.

2) 当不希望父类的某个方法被子类覆盖/重写(override)时,可以用final关键字修饰。【案例演示:访问修饰符final返回类型方法名】

3) 当不希望类的的某个属性的值被修改,可以用final修饰．（例如: public final double TAX RATE=0.08)

4) 当不希望某个局部变量被修改，可以使用final修饰（例如： final double TAX RATE=0.08）

### final 使用注意事项和细节讨论

1) final修饰的属性又叫常量,一般用 XX_XX_XX （大写）来命名

2) final修饰的属性在定义时,必须赋初值,并且以后不能再修改，赋值可以在如下位置之一:
   
   定义时:如public final double TAX_RATE=0.08;
   
   在构造器中
   
   在代码块中
   
   ```java
   class AA {
   /*
   1. 定义时：如public final double TAX_RATE=0.08;
   2. 在构造器中
   3. 在代码块中
   */
   public final double TAX_RATE = 0.08;//1.定义时赋值
   public final double TAX_RATE2 ;
   public final double TAX_RATE3 ;
   public AA() {//构造器中赋值
       TAX_RATE2 = 1.1;
       }
       {//在代码块赋值
           TAX_RATE3 = 8.8;
       }
   }
   ```

3) 如果final修饰的属性是静态的，则初始化的位置只能是
   
   ①定义时
   
   ②在静态代码块（不能在构造器中赋值。因为构造器是在对象创建的时候才会进行赋值）

4) final类不能继承,但是可以实例化对象。（实例化没问题）

5) 如果类不是final类，但是含有final方法，则该方法虽然不能重写，但是可以被继承。（子类用是没问题的，虽然不能重写）

6) 一般来说，如果一个类已经是final类了，就没有必要再将方法修饰成final方法。（因为类既然不能被继承，也就相应无法被重写）。

7) final不能修饰构造方法(即构造器)。

8) final和static 往往搭配使用，效率更高，因为**不会导致类加载**，底层编译器做了优化处理。

9) 包装类(Integer,Double,Float,Boolean等都是final),String也是final类。

## 抽象类

### 引出

当父类的某些方法，需要声明，但是又不确定如何实现时，可以将其声明为抽象方法,那么这个类就是抽象类。

所谓抽象方法就是没有实现的方法，所谓没有实现就是指，没有方法体。

**当一个类中存在抽象方法时，需要将该类声明为abstract 类**，一般来说，抽象类会被继承，由其子类来实现抽象方法。

```java
abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }
    public abstract void eat()  ;
}
```

### 抽象类的介绍

1)用abstract关键字来修饰一个类时,这个类就叫抽象类访问修饰符

2)用abstract关键字来修饰一个方法时,这个方法就是抽象方法

```java
访问修饰符 abstract 返回类型 方法名(参数列表);//没有方法体
```

3)抽象类的价值更多作用是在于设计,是设计者设计好后，让子类继承并实现抽象类。

4)抽象类是考官比较爱问的知识点，在框架和设计模式使用较多。

### 抽象类使用的注意事项和细节讨论

1)**抽象类不能被实例化**

2)抽象类不一定要包含abstract方法。也就是说, 抽象类可以没有abstract方法。

3)一旦类包含了abstract方法,则这个类必须声明为abstract。

4)**abstract只能修饰类和方法，不能修饰属性和其它的。**

5)抽象类可以有任意成员【抽象类本质还是类】，比如: 非抽象方法、构造器、静态属性等等。

6)**抽象方法不能有主体，即不能实现**。

7)**如果一个类继承了抽象类，则它必须实现抽象类的所有抽象方法，除非它自己也声明为abstract类。**

8)抽象方法不能使用private、final和 static来修饰，因为这些关键字都是和重写相违背的。

## 抽象类最佳实践-模板设计模式

### 基本介绍

抽象类体现的就是一种模板模式的设计，抽象类作为多个子类的通用模板，子类在抽象类的基础上进行扩展、改造，但子类总体上会保留抽象类的行为方式。

### 模板设计模式能解决的问题

1)当功能内部一部分实现是确定，一部分实现是不确定的。这时可以把不确定的部分暴露出去，让子类去实现。
2)编写一个抽象父类，父类提供了多个子类的通用方法，并把一个或多个方法留给其子类实现，就是一种模板模式.

### 最佳实践

需求：

有多个类，完成不同的任务job

要求统计得到各自完成任务的时间

```java
package com.hspedu.abstract_;

abstract public class Template { //抽象类-模板设计模式

    public abstract void job();//抽象方法

    public void calculateTime() {//实现方法，调用job方法
        //得到开始的时间
        long start = System.currentTimeMillis();
        job(); //动态绑定机制
        //得的结束的时间
        long end = System.currentTimeMillis();
        System.out.println("任务执行时间 " + (end - start));
    }
}
```

以上就是把不确定的部分暴露出去，让子类去实现。

## 接口

### 基本介绍

接口就是给出一些没有实现的方法，封装到一起，到某个类要使用的时候，在根据具体情况把这些方法写出来。语法：

```java
interface 接口名{
    //属性
    //抽象方法（接口中可以省略abstract关键字）（在jdk8后还可以有静态方法和默认方法）
}

class 类名 implements 接口 {
    // 自己属性;
    // 自己方法;
    // 必须实现的接口的抽象方法
}
```

小结:

接口是更加抽象的类。抽象类里的方法可以有方法体，接口里的所有方法都没有方法体(jdk7.0)。接口体现了程序设计的多态和高内聚低偶合的设计思想。

> 特别说明:Jdk8.0后接口类可以有静态方法（static），默认方法（default），也就是说接口中可以有方法的具体实现入。

### 深入讨论

说现在有一个项目经理(段玉),管理三个程序员,功能开发一个软件.为了控制和管理软件,项目经理可以定义一些接口，然后由程序员具体实现。

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/04/17-10-28-24-1681698502.png)

通过接口，不仅可以统一方法名，同时在调用时只需要根据接口识别即可。

```java
package com.hspedu.interface_;

public interface DBInterface { //项目经理

    public void connect();//连接方法
    public void close();//关闭连接
}
```

```java
package com.hspedu.interface_;
//A程序
public class MysqlDB implements DBInterface {
    @Override
    public void connect() {
        System.out.println("连接mysql");
    }

    @Override
    public void close() {
        System.out.println("关闭mysql");
    }
}
```

```java
package com.hspedu.interface_;

//B程序员连接Oracle
public class OracleDB implements DBInterface{

    @Override
    public void connect() {
        System.out.println("连接oracle");
    }

    @Override
    public void close() {
        System.out.println("关闭oracle");
    }
}
```

```java
package com.hspedu.interface_;

public class Interface03 {
    public static void main(String[] args) {

        MysqlDB mysqlDB = new MysqlDB();
        t(mysqlDB);
        OracleDB oracleDB = new OracleDB();
        t(oracleDB);
    }

    public static void t(DBInterface db) {
        db.connect();
        db.close();
    }
}
```

### 注意事项和细节

1) 接口不能被实例化（new）

2) 接口中所有的方法是public方法，接口中抽象方法，可以不用abstract修
   饰。void aaa(); 实际上是abstract void aa();（同理，不写public也是默认public方法，因此实现时该方法不写public会报错。）

3) 一个普通类实现接口,就必须将该接口的所有方法都实现。

4) 抽象类实现接口，可以不用实现接口的方法。

5) **一个类同时可以实现多个接口**。
   
   ```java
   class Timer implements IA, IB{ }
   ```

6) **接口中的属性，只能是final的，而且是 public static final修饰符**。比如:int a=1;实际上是public static final int a=1; (必须初始化)

7) 接口中属性的访问形式:接口名.属性名

8) 接口不能继承其它的类,但是可以继承多个别的接口。（接口无法实现接口）
   
   ```java
   interface A extends B,C{}
   ```

9) 接口的修饰符只能是public和默认，这点和类的修饰符是一样的。

### 实现接口VS继承类

当子类继承了父类，就自动的拥有父类的功能，如果子类需要扩展功能，可以通过实现接口的方式扩展。可以理解 实现接口 是对 java 单继承机制的一种补充。

1. 接口和继承解决的问题不同
   
   继承的价值主要在于:解决代码的复用性和可维护性。

2. 接口的价值主要在于:设计，设计好各种规范(方法)，让其它类去实现这些方法。即更加的灵活

接口比继承更加灵活：继承是满足is - a的关系，而接口只需满足 like - a的关系。

**接口在一定程度上实现代码解耦[即:接口规范性+动态绑定机制]**

### 接口的多态特性

1. 多态参数
   
   在前面的Usb接口案例，UsbInterface usb，既可以接收手机对象，又可以接收相机对象，就体现了接口多态(接口引用可以指向实现了接口的类的对象)。
   
   ```java
   package com.hspedu.interface_;
   
   public class InterfacePolyParameter {
       public static void main(String[] args) {
   
           //接口的多态体现
           //接口类型的变量 if01 可以指向 实现了IF接口类的对象实例
           IF if01 = new Monster();
           if01 = new Car();
   
           // 继承体现的多态
           // 父类类型的变量 a 可以指向 继承AAA的子类的对象实例
           AAA a = new BBB();
           a = new CCC();
       }
   }
   
   interface IF {}
   class Monster implements IF{}
   class Car implements  IF{}
   
   class AAA {
   
   }
   class BBB extends AAA {}
   class CCC extends AAA {}
   ```

```
2. 多态数组

演示一个案例:给**Usb数组中，存放 Phone 和相机对象**，Phone类还有一个特有的方法call()，请遍历Usb数组，如果是Phone对象，除了调用Usb接口定义的方法外，还需要调用Phone特有方法call。

```java
package com.hspedu.interface_;

public class InterfacePolyArr {
    public static void main(String[] args) {

        //多态数组 -> 接口类型数组
        Usb[] usbs = new Usb[2];
        usbs[0] = new Phone_();
        usbs[1] = new Camera_();
        /*
        给Usb数组中，存放 Phone 和 相机对象，Phone类还有一个特有的方法call（），
        请遍历Usb数组，如果是Phone对象，除了调用Usb 接口定义的方法外，
        还需要调用Phone 特有方法 call
         */
        for(int i = 0; i < usbs.length; i++) {
            usbs[i].work();//动态绑定..
            //和前面一样，我们仍然需要进行类型的向下转型
            if(usbs[i] instanceof Phone_) {//判断他的运行类型是 Phone_
                ((Phone_) usbs[i]).call();
            }
        }
    }
}

interface Usb{
    void work();
}
class Phone_ implements Usb {
    public void call() {
        System.out.println("手机可以打电话...");
    }

    @Override
    public void work() {
        System.out.println("手机工作中...");
    }
}
class Camera_ implements Usb {

    @Override
    public void work() {
        System.out.println("相机工作中...");
    }
}
```

3. 接口存在多态传递现象
   
   ```java
   package com.hspedu.interface_;
   
   /**
    * 演示多态传递现象
    */
   public class InterfacePolyPass {
       public static void main(String[] args) {
           //接口类型的变量可以指向，实现了该接口的类的对象实例
           IG ig = new Teacher();
           //如果IG 继承了 IH 接口，而Teacher 类实现了 IG接口
           //那么，实际上就相当于 Teacher 类也实现了 IH接口.
           //这就是所谓的 接口多态传递现象.
           IH ih = new Teacher();
       }
   }
   
   interface IH {
       void hi();
   }
   interface IG extends IH{ }
   class Teacher implements IG {
       @Override
       public void hi() {
       }
   }
   ```

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/04/17-12-01-10-1681704057.png)

## 内部类

如果定义类在局部位置(方法中/代码块) (1) 局部内部类 (2) 匿名内部类
定义在成员位置 (1) 成员内部类 (2) 静态内部类

### 基本介绍

一个类的内部又完整的嵌套了另一个类结构。被嵌套的类称为内部类(inner class),嵌套其他类的类称为外部类(outer class)。

是我们类的第五大成员（**类的五大成员：属性、方法、构造器、代码块、内部类**），内部类最大的特点就是可以直接访问私有属性，并且可以体现类与类之间的包含关系，注意：内部类是学习的难点，同时也是重点，后面看底层源码时,有大量的内部类。

### 基本语法

```java
class Outer{ // 外部类
    class Inner{
        // 内部类
        }
}
class Other{// 外部其他类
}
```

### 内部类的分类

定义在外部类局部位置上( 比如方法内 ):

1) 局部内部类 ( 有类名 )

2) 匿名内部类 ( 没有类名，重点!!!!!!!! )

定义在外部类的成员位置上:

1) 成员内部类 ( 没用 static 修饰 )

2) 静态内部类 ( 使用 static 修饰 )

### 局部内部类的使用

说明:**局部内部类是定义在外部类的局部位置，比如方法中，并且有类名**。

1.可以直接访问外部类的所有成员，包含私有的。

2.不能添加访问修饰符，因为它的地位就是一个局部变量。局部变量是不能使用修饰符的。但是可以使用final修饰，因为局部变量也可以使用final。

3.作用域：**仅仅在定义它的方法或代码块中**。

4.局部内部类访问外部类的成员[访问方式:直接访问]

5.外部类访问局部内部类的成员

访问方式: 创建对象，再访问 (注意:必须在作用域内)

小结：

(1)局部内部类定义在方法中/代码块
(2)作用域在方法体或者代码块中
(3)本质仍然是一个类

6.外部**其他**类不能访问局部内部类（因为局部内部类地位是一个局部变量)。

7.如果外部类和局部内部类的成员重名时，默认遵循就近原则，如果想访问外部类的成员，则可以使用(外部类名.this.成员)去访问。

这里 `外部类名.this` 本质上就是外部类的对象，即哪个对象调用了n2，那么 `外部类名.this` 就指向哪个对象。

```java
System.out.printin(""外部类的n2=”+外部类名.this.n2);
```

```java
package com.hspedu.innerclass;
/**
 * 演示局部内部类的使用
 */
public class LocalInnerClass {//
    public static void main(String[] args) {
        //演示一遍
        Outer02 outer02 = new Outer02();
        outer02.m1();
        System.out.println("outer02的hashcode=" + outer02);
    }
}


class Outer02 {//外部类
    private int n1 = 100;
    private void m2() {
        System.out.println("Outer02 m2()");
    }//私有方法
    public void m1() {//方法
        //1.局部内部类是定义在外部类的局部位置,通常在方法
        //3.不能添加访问修饰符,但是可以使用final 修饰
        //4.作用域 : 仅仅在定义它的方法或代码块中
        final class Inner02 {//局部内部类(本质仍然是一个类)
            //2.可以直接访问外部类的所有成员，包含私有的
            private int n1 = 800;
            public void f1() {
                //5. 局部内部类可以直接访问外部类的成员，比如下面 外部类n1 和 m2()
                //7. 如果外部类和局部内部类的成员重名时，默认遵循就近原则，如果想访问外部类的成员，
                //   使用 外部类名.this.成员）去访问
                //  Outer02.this 本质就是外部类的对象, 即哪个对象调用了m1, Outer02.this就是哪个对象
                System.out.println("n1=" + n1 + " 外部类的n1=" + Outer02.this.n1);
                System.out.println("Outer02.this hashcode=" + Outer02.this);
                m2();
            }
        }
        //6. 外部类在方法中，可以创建Inner02对象，然后调用方法即可
        Inner02 inner02 = new Inner02();
        inner02.f1();
    }
}
```

### 匿名内部类的使用!!!!!

(1)本质是类 (2) 内部类 (3) 该类没有名字 (4) 同时还是一个对象

说明: 匿名内部类是定义在外部类的局部位置, 比如方法中, 并且没有类名

1.匿名内部类的基本语法

```java
new 类或接口 (参数列表){
   类体
);
```

```java
package com.hspedu.innerclass;


/**
 * 演示匿名内部类的使用
 */
public class AnonymousInnerClass {
    public static void main(String[] args) {
        Outer04 outer04 = new Outer04();
        outer04.method();
    }
}

class Outer04 { //外部类
    private int n1 = 10;//属性
    public void method() {//方法
        //基于!!!接口!!!的匿名内部类
        //解读
        //1.需求：想使用IA接口,并创建对象
        //2.传统方式，是写一个类，实现该接口，并创建对象
        //3.需求是 Tiger/Dog 类只是使用一次，后面再不使用
        //4. 可以使用匿名内部类来简化开发
        //5. tiger的编译类型 ? IA
        //6. tiger的运行类型 ? 就是匿名内部类  Outer04$1
        /*
            我们看底层 会分配 类名 Outer04$1
            class Outer04$1 implements IA {
                @Override
                public void cry() {
                    System.out.println("老虎叫唤...");
                }
            }
         */
        //7. jdk底层在创建匿名内部类 Outer04$1,立即马上就创建了 Outer04$1实例，并且把地址
        //   返回给 tiger
        //8. 匿名内部类使用一次，就不能再使用, 但是tiger这个对象就没有限制了。
        IA tiger = new IA() {
            @Override
            public void cry() {
                System.out.println("老虎叫唤...");
            }
        };
        System.out.println("tiger的运行类型=" + tiger.getClass());
        tiger.cry();
        tiger.cry();
        tiger.cry();

//        IA tiger = new Tiger();
//        tiger.cry();

        // 演示基于!!!类!!!的匿名内部类
        //分析
        //1. father 编译类型 Father
        //2. father 运行类型 Outer04$2
        //3. 底层会创建匿名内部类
        /*
            具体的实现代码与注释中的代码近似等价
            class Outer04$2 extends Father{
                @Override
                public void test() {
                    System.out.println("匿名内部类重写了test方法");
                }
            }
         */
        //4. 同时也直接返回了 匿名内部类 Outer04$2的对象
        //5. 注意("jack") 参数列表会传递给 Father 构造器
        Father father = new Father("jack"){
            @Override
            public void test() {
                System.out.println("匿名内部类重写了test方法");
            }
        };
        System.out.println("father对象的运行类型=" + father.getClass());//Outer04$2
        father.test();

        //基于!!!抽象类!!!的匿名内部类
        Animal animal = new Animal(){
            @Override
            void eat() {
                System.out.println("小狗吃骨头...");
            }
        };
        animal.eat();
    }
}

interface IA {//接口
    public void cry();
}
//class Tiger implements IA {
//
//    @Override
//    public void cry() {
//        System.out.println("老虎叫唤...");
//    }
//}
//class Dog implements  IA{
//    @Override
//    public void cry() {
//        System.out.println("小狗汪汪...");
//    }
//}

class Father { //类
    public Father(String name) { //构造器
        System.out.println("接收到name=" + name);
    }
    public void test() { //方法
    }
}

abstract class Animal { //抽象类
    abstract void eat();
}
```

2.匿名内部类的语法比较奇特，因为匿名内部类既是一个类的定义.同时它本身也是一个对象，因此从语法上看，它既有定义类的特征，也有创建对象的特征，对前面代码分析可以看出这个特点，因此可以调用匿名内部类方法。

3．可以直接访问外部类的所有成员，包含私有的。

4、不能添加访问修饰符,因为它的地位就是一个局部变量。

5.作用域:仅仅在定义它的方法或代码块中。

6.匿名内部类---访问---->外部类成员[访问方式:直接访问]

7.外部其他类---不能访问----->匿名内部类(因为匿名内部类地位是一个局部变量)

8.如果外部类和匿名内部类的成员重名时，匿名内部类访问的话，默认遵循就近原则,如果想访问外部类的成员，则可以使用(外部类名.this.成员)去访问

```java
package com.hspedu.innerclass;

public class AnonymousInnerClassDetail {
    public static void main(String[] args) {

        Outer05 outer05 = new Outer05();
        outer05.f1();
        //外部其他类---不能访问----->匿名内部类
        System.out.println("main outer05 hashcode=" + outer05);
    }
}

class Outer05 {
    private int n1 = 99;

    public void f1() {
        //创建一个基于类的匿名内部类
        //不能添加访问修饰符,因为它的地位就是一个局部变量
        //作用域 : 仅仅在定义它的方法或代码块中
        Person p = new Person(){
            private int n1 = 88;
            @Override
            public void hi() {
                // 可以直接访问外部类的所有成员，包含私有的
                // 如果外部类和匿名内部类的成员重名时，匿名内部类访问的话，
                // 默认遵循就近原则，如果想访问外部类的成员，则可以使用 （外部类名.this.成员）去访问
                System.out.println("匿名内部类重写了 hi方法 n1=" + n1 +
                        " 外部内的n1=" + Outer05.this.n1 );
                // Outer05.this 就是调用 f1的 对象
                System.out.println("Outer05.this hashcode=" + Outer05.this);
            }
        };
        p.hi();//动态绑定, 运行类型是 Outer05$1

        //也可以直接调用, 匿名内部类本身也是返回对象
        // class 匿名内部类 extends Person {}
//        new Person(){
//            @Override
//            public void hi() {
//                System.out.println("匿名内部类重写了 hi方法,哈哈...");
//            }
//            @Override
//            public void ok(String str) {
//                super.ok(str);
//            }
//        }.ok("jack");


    }
}

class Person {//类
    public void hi() {
        System.out.println("Person hi()");
    }
    public void ok(String str) {
        System.out.println("Person ok() " + str);
    }
}
//抽象类/接口...
```

### 匿名内部类的最佳实践

当做实参直接传递，简洁高效。

```java
package com.hspedu.innerclass;

import com.hspedu.abstract_.AA;

public class InnerClassExercise01 {
    public static void main(String[] args) {

        //当做实参直接传递，简洁高效
        f1(new IL() {
            @Override
            public void show() {
                System.out.println("这是一副名画~~...");
            }
        });
        //传统方法
        f1(new Picture());
    }

    //静态方法,形参是接口类型
    public static void f1(IL il) {
        il.show();
    }
}

//接口
interface IL {
    void show();
}


//类->实现IL => 编程领域 (硬编码)
class Picture implements IL {

    @Override
    public void show() {
        System.out.println("这是一副名画XX...");
    }
}
```

有一个铃声接口Bell，里面有个ring方法。有一个手机类Cellphone，具有闹钟功能alarmclock,参数是Bell类型。测试手机类的闹钟功能,通过匿名内部类(对象)作为参数，打印:懒猪起床了。再传入另一个匿名内部类(对象)，打印:小伙伴上课了

```java
package com.hspedu.innerclass;

public class InnerClassExercise02 {
    public static void main(String[] args) {
        /*
        1.有一个铃声接口Bell，里面有个ring方法。(右图)
        2.有一个手机类Cellphone，具有闹钟功能alarmClock，参数是Bell类型(右图)
        3.测试手机类的闹钟功能，通过匿名内部类(对象)作为参数，打印：懒猪起床了
        4.再传入另一个匿名内部类(对象)，打印：小伙伴上课了
         */
        CellPhone cellPhone = new CellPhone();
        //老韩解读
        //1. 传递的是实现了 Bell接口的匿名内部类 InnerClassExercise02$1
        //2. 重写了 ring
        //3. Bell bell = new Bell() {
        //            @Override
        //            public void ring() {
        //                System.out.println("懒猪起床了");
        //            }
        //        }
        cellPhone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("懒猪起床了");
            }
        });

        cellPhone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("小伙伴上课了");
            }
        });
    }
}
interface Bell{ //接口
    void ring();//方法
}
class CellPhone{//类
    public void alarmClock(Bell bell){//形参是Bell接口类型
        System.out.println(bell.getClass());
        bell.ring();//动态绑定
    }
}

```

### 成员内部类的使用

说明: **成员内部类是定义在外部类的成员位置,并且没有static修饰。**

1.可以直接访问外部类的所有成员，包含私有的。

2.可以添加任意访问修饰符(public、protected、默认、private), 因为它的地
位就是一个成员。

3.作用域和外部类的其他成员一样，为整个类体比如前面案例，在外部类的成员方法中创建成员内部类对象，再调用方法。

4.成员内部类---访问---->外部类成员(比如:属性) 访问方式:直接访问

5.外部类---访问------>成员内部类(说明) 访问方式:创建对象,再访问

6.外部其他类---访问---->成员内部类

7.如果外部类和内部类的成员重名时，内部类访问的话，默认遵循就近原则，如果想访问外部类的成员，则可以使用(外部类名.this.成员)去访问

```java
package com.hspedu.innerclass;

public class MemberInnerClass01 {
    public static void main(String[] args) {
        Outer08 outer08 = new Outer08();
        outer08.t1();

        //外部其他类，使用成员内部类的三种方式
        // 第一种方式
        // outer08.new Inner08(); 相当于把 new Inner08()当做是outer08成员
        // 这就是一个语法，不要特别的纠结.
        Outer08.Inner08 inner08 = outer08.new Inner08();
        inner08.say();
        // 第二方式 在外部类中，编写一个方法，可以返回 Inner08对象
        Outer08.Inner08 inner08Instance = outer08.getInner08Instance();
        inner08Instance.say();


    }
}

class Outer08 { //外部类
    private int n1 = 10;
    public String name = "张三";

    private void hi() {
        System.out.println("hi()方法...");
    }

    //1.注意: 成员内部类，是定义在外部内的成员位置上
    //2.可以添加任意访问修饰符(public、protected 、默认、private),因为它的地位就是一个成员
    public class Inner08 {//成员内部类
        private double sal = 99.8;
        private int n1 = 66;
        public void say() {
            //可以直接访问外部类的所有成员，包含私有的
            //如果成员内部类的成员和外部类的成员重名，会遵守就近原则.
            //，可以通过  外部类名.this.属性 来访问外部类的成员
            System.out.println("n1 = " + n1 + " name = " + name + " 外部类的n1=" + Outer08.this.n1);
            hi();
        }
    }
    //方法，返回一个Inner08实例
    public Inner08 getInner08Instance(){
        return new Inner08();
    }


    //写方法
    public void t1() {
        //使用成员内部类
        //创建成员内部类的对象，然后使用相关的方法
        Inner08 inner08 = new Inner08();
        inner08.say();
        System.out.println(inner08.sal);
    }
}


```



### 静态内部类的使用

说明:静态内部类是定义在外部类的成员位置, 并且**有static修饰**

1.可以直接访问外部类的所有静态成员，包含私有的，但不能直接访问非静态成员。

2.可以添加任意访问修饰符(public. protected、默认、private),因为它的地位就是一个成员。

3.作用域:同其他的成员，为整个类体。

4.静态内部类---访问---->外部类(比如:静态属性)[访问方式:直接访问所有静态成员]。

5．外部类---访问------>静态内部类 访问方式:创建对象，再访问。

6．外部其他类---访问----->静态内部类。

7.如果外部类和静态内部类的成员重名时，静态内部类访问的时，默认遵循就近原则，如果想访问外部类的成员，则可以使用(外部类名.成员)去访向。

```java
package com.hspedu.innerclass;

public class StaticInnerClass01 {
    public static void main(String[] args) {
        Outer10 outer10 = new Outer10();
        outer10.m1();

        //外部其他类 使用静态内部类
        //方式1
        //因为静态内部类，是可以通过类名直接访问(前提是满足访问权限)
        Outer10.Inner10 inner10 = new Outer10.Inner10();
        inner10.say();
        //方式2
        //编写一个方法，可以返回静态内部类的对象实例.
        Outer10.Inner10 inner101 = outer10.getInner10();
        System.out.println("============");
        inner101.say();

        Outer10.Inner10 inner10_ = Outer10.getInner10_();
        System.out.println("************");
        inner10_.say();
    }
}

class Outer10 { //外部类
    private int n1 = 10;
    private static String name = "张三";
    private static void cry() {}
    //Inner10就是静态内部类
    //1. 放在外部类的成员位置
    //2. 使用static 修饰
    //3. 可以直接访问外部类的所有静态成员，包含私有的，但不能直接访问非静态成员
    //4. 可以添加任意访问修饰符(public、protected 、默认、private),因为它的地位就是一个成员
    //5. 作用域 ：同其他的成员，为整个类体
    static class Inner10 {
        private static String name = "Timerring";
        public void say() {
            //如果外部类和静态内部类的成员重名时，静态内部类访问的时，
            //默认遵循就近原则，如果想访问外部类的成员，则可以使用 （外部类名.成员）
            System.out.println(name + " 外部类name= " + Outer10.name);
            cry();
        }
    }

    public void m1() { //外部类---访问------>静态内部类 访问方式：创建对象，再访问
        Inner10 inner10 = new Inner10();
        inner10.say();
    }

    public Inner10 getInner10() {
        return new Inner10();
    }

    public static Inner10 getInner10_() {
        return new Inner10();
    }
}


```

### 课堂测试题

判断输出：

```java
package com.hspedu.innerclass;

public class InnerClassExercise {
    public static void main(String[] args) {

    }
}

class Test {//外部类

    public Test() {//构造器
        Inner s1 = new Inner();
        s1.a = 10;
        Inner s2 = new Inner();
        System.out.println(s2.a);
    }

    class Inner { //内部类，成员内部类
        public int a = 5;
    }

    public static void main(String[] args) {
        Test t = new Test();
        Inner r = t.new Inner();//5
        System.out.println(r.a);//5
    }
}

```
