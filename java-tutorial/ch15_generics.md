- [第15章 泛型](#第15章-泛型)
  - [泛型的理解和好处](#泛型的理解和好处)
    - [看一个需求](#看一个需求)
    - [使用传统方法的问题分析](#使用传统方法的问题分析)
    - [泛型快速体验](#泛型快速体验)
    - [泛型的好处](#泛型的好处)
  - [泛型介绍](#泛型介绍)
  - [泛型的语法](#泛型的语法)
    - [泛型的声明](#泛型的声明)
    - [泛型的实例化](#泛型的实例化)
    - [泛型使用举例](#泛型使用举例)
    - [泛型使用的注意事项和细节](#泛型使用的注意事项和细节)
  - [泛型课堂类型](#泛型课堂类型)
    - [泛型课堂练习题](#泛型课堂练习题)
  - [自定义泛型](#自定义泛型)
    - [自定义泛型类](#自定义泛型类)
    - [自定义泛型接口](#自定义泛型接口)
    - [自定义泛型方法](#自定义泛型方法)
      - [自定义泛型方法练习](#自定义泛型方法练习)
  - [泛型的继承和通配符](#泛型的继承和通配符)
    - [泛型的继承和通配符说明](#泛型的继承和通配符说明)
  - [JUnit](#junit)
  - [本章作业](#本章作业)


# 第15章 泛型

## 泛型的理解和好处

### 看一个需求

请编写程序，在ArrayList 中，添加3个Dog对象

Dog对象含有name 和 age, 并输出name 和 age (要求使用getXxx())

```java
package com.hspedu.generic;

import java.util.ArrayList;

@SuppressWarnings({"all"})
public class Generic01 {
    public static void main(String[] args) {

        //使用传统的方法来解决
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Dog("旺财", 10));
        arrayList.add(new Dog("发财", 1));
        arrayList.add(new Dog("小黄", 5));

        //假如程序员，不小心，添加了一只猫
        arrayList.add(new Cat("招财猫", 8)); // 就会报类型转换的错误

        //遍历
        for (Object o : arrayList) {
            //向下转型Object ->Dog
            Dog dog = (Dog) o;
            System.out.println(dog.getName() + "-" + dog.getAge());
        }
    }
}
/*
请编写程序，在ArrayList 中，添加3个Dog对象
Dog对象含有name 和 age, 并输出name 和 age (要求使用getXxx())
 */
class Dog {
    private String name;
    private int age;
    public Dog(String name, int age) {
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
}

class Cat { //Cat类
    private String name;
    private int age;
    public Cat(String name, int age) {
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
}
```

### 使用传统方法的问题分析

1)不能对加入到集合ArrayList中的数据类型进行约束(不安全)

2)遍历的时候，需要进行类型转换,如果集合中的数据量较大，对效率有影响

### 泛型快速体验

```java
public class Generic02 {
    public static void main(String[] args) {

        // 使用传统的方法来解决===> 使用泛型
        // 1. 当我们 ArrayList<Dog> 表示存放到 ArrayList 集合中的元素是Dog类型
        // 2. 如果编译器发现添加的类型，不满足要求，就会报错
        // 3. 在遍历的时候，可以直接取出 Dog 类型而不是 Object
        // 4. public class ArrayList<E> {} E称为泛型,那么 Dog->E
        ArrayList<Dog> arrayList = new ArrayList<Dog>();
        arrayList.add(new Dog("旺财", 10));
        arrayList.add(new Dog("发财", 1));
        arrayList.add(new Dog("小黄", 5));
        // 假如我们的程序员，不小心，添加了一只猫
        // arrayList.add(new Cat("招财猫", 8));
        System.out.println("==== 使用泛型 ====");
        for (Dog dog : arrayList) {
            System.out.println(dog.getName() + "-" + dog.getAge());
        }
    }
}
```

### 泛型的好处

1)编译时，检查添加元素的类型,提高了安全性

2)减少了类型转换的次数,提高效率。

不使用泛型

+ Dog -加入-> Object -取出-> Dog //放入到ArrayList 会先转成Object,在取出时，还需要转换

使用泛型

+ Dog -> Dog -> Dog // 放入时，和取出时，不需要类型转换，提高效率

3)不再提示编译警告

## 泛型介绍

泛(广泛)型(类型)=> Integer,String,Dog

1) 泛型又称参数化类型，是Jdk5.0出现的新特性,解决数据类型的安全性问题
2) 在类声明或实例化时只要指定好需要的具体的类型即可。

3) Java泛型可以保证如果程序在编译时没有发出警告，运行时就不会产生ClassCastException异常。同时，代码更加简洁、健壮。
4) 泛型的作用是:可以在类声明时通过一个标识表示类中某个属性的类型，或者法的返回值的类型，或者是参数类型。

```java
package com.hspedu.generic;

import java.util.List;
public class Generic03 {
    public static void main(String[] args) {

        //注意，特别强调： E具体的数据类型在定义Person对象的时候指定,即在编译期间，就确定E是什么类型
        Person<String> person = new Person<String>("timerring");
        person.show(); //String

        /*
            你可以这样理解，上面的Person类
            class Person {
                String s ;//E表示 s的数据类型, 该数据类型在定义Person对象的时候指定,即在编译期间，就确定E是什么类型

                public Person(String s) {//E也可以是参数类型
                    this.s = s;
                }

                public String f() {//返回类型使用E
                    return s;
                }
            }
         */

        Person<Integer> person2 = new Person<Integer>(100);
        person2.show();//Integer

        /*
            class Person {
                Integer s ;//E表示 s的数据类型, 该数据类型在定义Person对象的时候指定,即在编译期间，就确定E是什么类型

                public Person(Integer s) {//E也可以是参数类型
                    this.s = s;
                }

                public Integer f() {//返回类型使用E
                    return s;
                }
            }
         */
    }
}

//泛型的作用是：可以在类声明时通过一个标识表示类中某个属性的类型，
// 或者是某个方法的返回值的类型，或者是参数类型

class Person<E> {
    E s ;//E表示 s的数据类型, 该数据类型在定义Person对象的时候指定,即在编译期间，就确定E是什么类型

    public Person(E s) {//E也可以是参数类型
        this.s = s;
    }

    public E f() {//返回类型使用E
        return s;
    }

    public void show() {
        System.out.println(s.getClass());//显示s的运行类型
    }
}
```

## 泛型的语法

### 泛型的声明

```java
interface 接口<T>{} 和 class 类 <K,V>{}
//比如:List , ArrayList
```

说明:

1) 其中，T,K,V不代表值,而是表示类型。
2) 任意字母都可以。常用T表示，是Type的缩写

### 泛型的实例化

要在类名后面指定类型参数的值(类型)。

```JAVA
List<String> strList = new ArrayList<String>();
Iterator<Customer> iterator = customers.iterator();
```

### 泛型使用举例

举例说明，泛型在HashSet,HashMap的使用情况

练习:

1. 创建3个学生对象
2. 放入到HashSet中学生对象,使用.
3. 放入到HashMap中，要求Key是String name, Value就是学生对象
4. 使用两种方式遍历

```java
package com.hspedu.generic;

import java.util.*;

@SuppressWarnings({"all"})
public class GenericExercise {
    public static void main(String[] args) {
        // 使用泛型方式给HashSet 放入3个学生对象
        HashSet<Student> students = new HashSet<Student>();
        students.add(new Student("jack", 18));
        students.add(new Student("tom", 28));
        students.add(new Student("mary", 19));

        // 遍历
        for (Student student : students) {
            System.out.println(student);
        }

        // 使用泛型方式给HashMap 放入3个学生对象
        // K -> String V->Student
        HashMap<String, Student> hm = new HashMap<String, Student>();
        /*
            public class HashMap<K,V>  {}
         */
        hm.put("milan", new Student("milan", 38));
        hm.put("smith", new Student("smith", 48));
        hm.put("hsp", new Student("hsp", 28));

        //迭代器 EntrySet
        /*
        public Set<Map.Entry<K,V>> entrySet() {
            Set<Map.Entry<K,V>> es;
            return (es = entrySet) == null ? (entrySet = new EntrySet()) : es;
        }
         */
        Set<Map.Entry<String, Student>> entries = hm.entrySet();
        /*
            public final Iterator<Map.Entry<K,V>> iterator() {
                return new EntryIterator();
            }
         */
        Iterator<Map.Entry<String, Student>> iterator = entries.iterator();
        System.out.println("==============================");
        while (iterator.hasNext()) {
            Map.Entry<String, Student> next =  iterator.next();
            System.out.println(next.getKey() + "-" + next.getValue());
        }
    }
}
/**
 * 创建 3 个学生对象
 * 放入到 HashSet 中学生对象, 使用.
 * 放入到  HashMap中，要求 Key 是 String name, Value 就是 学生对象
 * 使用两种方式遍历
 */
class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
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

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
```

### 泛型使用的注意事项和细节

interface List<T>{} , public class HashSet<E>{}..等等

说明:T,E只能是引用类型，看看下面语句是否正确?

```java
List<lnteger> list = new ArrayList<lnteger>()://OK
List<int> list2 = new ArrayList<int>();//错误
```

**在给泛型指定具体类型后，可以传入该类型或者其子类类型**

泛型使用形式

```java
List<lnteger> list1 =new ArrayList<lnteger>();
List<lnteger> list2 = new ArrayList<>(); // 推荐省略写法
```

如果我们这样写**List list3 = new ArrayList();默认给它的泛型是\<E> E就是Object。如果是这样写 泛型默认是 Object**

```java
package com.hspedu.generic;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"all"})
public class GenericDetail {
    public static void main(String[] args) {
        //1.给泛型指向数据类型是，要求是引用类型，不能是基本数据类型
        List<Integer> list = new ArrayList<Integer>(); //OK
        //List<int> list2 = new ArrayList<int>();//错误

        //2. 说明
        //因为 E 指定了 A 类型, 构造器传入了 new A()
        //在给泛型指定具体类型后，可以传入该类型或者其子类类型
        Pig<A> aPig = new Pig<A>(new A());
        aPig.f();
        Pig<A> aPig2 = new Pig<A>(new B());
        aPig2.f();

        //3. 泛型的使用形式
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        //在实际开发中，我们往往简写
        //编译器会进行类型推断, 老师推荐使用下面写法
        ArrayList<Integer> list3 = new ArrayList<>();
        List<Integer> list4 = new ArrayList<>();
        ArrayList<Pig> pigs = new ArrayList<>();

        //4. 如果是这样写 泛型默认是 Object
        ArrayList arrayList = new ArrayList();//等价 ArrayList<Object> arrayList = new ArrayList<Object>();

        /*
            public boolean add(Object e) {
                ensureCapacityInternal(size + 1);  // Increments modCount!!
                elementData[size++] = e;
                return true;
            }
         */
        Tiger tiger = new Tiger();
        /*

            class Tiger {//类
                Object e;

                public Tiger() {}

                public Tiger(Object e) {
                    this.e = e;
                }
            }

         */

    }
}
class Tiger<E> {//类
    E e;

    public Tiger() {}

    public Tiger(E e) {
        this.e = e;
    }
}

class A {}
class B extends A {}

class Pig<E> {//
    E e;

    public Pig(E e) {
        this.e = e;
    }

    public void f() {
        System.out.println(e.getClass()); //运行类型
    }
}
```

## 泛型课堂类型

### 泛型课堂练习题

定义Employee类

1) 该类包含: private成员变量name, sal, birthday，其中 birthday 为 MyDate 类的对象;
2) 为每一个属性定义getter, setter方法;
3) 重写toString方法输出name, sal, birthday
4) MyDate类包含:private成员变量month, day, year; 并为每一个属性定义 getter,setter方法;
5) 创建该类的3个对象，并把这些对象放入ArrayList集合中(ArrayList需使用泛型来定义),对集合中的元素进行排序，并遍历输出:
6) 排序方式:调用ArrayList的sort方法，传入 Comparator对象[使用泛型]，先按照name排序，如果name相同，则按生日日期的先后排序。【即:定制排序】

```java
package com.hspedu.generic;

public class MyDate implements Comparable<MyDate>{
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    @Override
    public int compareTo(MyDate o) { //把对year-month-day比较放在这里

        int yearMinus = year - o.getYear();
        if(yearMinus != 0) {
            return  yearMinus;
        }
        //如果year相同，就比较month
        int monthMinus = month - o.getMonth();
        if(monthMinus != 0) {
            return monthMinus;
        }
        //如果year 和 month
        return day - o.getDay();
    }
}
```

```java
package com.hspedu.generic;

public class Employee {
    private String name;
    private double sal;
    private MyDate birthday;

    public Employee(String name, double sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "\nEmployee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", birthday=" + birthday +
                '}';
    }
}
```

```java
package com.hspedu.generic;

import java.util.ArrayList;
import java.util.Comparator;

@SuppressWarnings({"all"})
public class GenericExercise02 {
    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("tom", 20000, new MyDate(1980,12,11)));
        employees.add(new Employee("jack", 12000, new MyDate(2001,12,12)));
        employees.add(new Employee("tom", 50000, new MyDate(1980,12,10)));

        System.out.println("employees=" + employees);


        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee emp1, Employee emp2) {
                //先按照name排序，如果name相同，则按生日日期的先后排序。【即：定制排序】
                //先对传入的参数进行验证
                if(!(emp1 instanceof  Employee && emp2 instanceof Employee)) {
                    System.out.println("类型不正确..");
                    return 0;
                }
                //比较name
                int i = emp1.getName().compareTo(emp2.getName());
                if(i != 0) {
                    return i;
                }

                //下面是对birthday的比较，因此，我们最好把这个比较，放在MyDate类完成
                //封装后，将来可维护性和复用性，就大大增强.
                return emp1.getBirthday().compareTo(emp2.getBirthday());
            }
        });

        System.out.println("==对雇员进行排序==");
        System.out.println(employees);

    }
}
/**
 * 定义Employee类
 * 1) 该类包含：private成员变量name,sal,birthday，其中 birthday 为 MyDate 类的对象；
 * 2) 为每一个属性定义 getter, setter 方法；
 * 3) 重写 toString 方法输出 name, sal, birthday
 * 4) MyDate类包含: private成员变量month,day,year；并为每一个属性定义 getter, setter 方法；
 * 5) 创建该类的 3 个对象，并把这些对象放入 ArrayList 集合中（ArrayList 需使用泛型来定义），对集合中的元素进行排序，并遍历输出：
 *
 * 排序方式： 调用ArrayList 的 sort 方法 ,
 * 传入 Comparator对象[使用泛型]，先按照name排序，如果name相同，则按生日日期的先后排序。【即：定制排序】
 */
```

## 自定义泛型

### 自定义泛型类

```java
class 类名 <T,R..> {//..表示可以有多个泛型
	成员
}
```

注意细节

1) 普通成员可以使用泛型(属性、方法)
2) 使用泛型的数组,不能初始化：因为没有确定类型，就不知道到底要开辟多大的空间。
3) 静态方法中不能使用类的泛型，因为静态是与类相关的，因此类的加载时对象还没有创建，因此无法指定静态方法/变量的类型。如果静态方法和静态属性使用了泛型，JVM就无法完成初始化。
4) 泛型类的类型，是在创建对象时确定的(因为创建对象时，需要指定确定类型
5) 如果在创建对象时,没有指定类型，默认为Object

```java
class Tiger<T, R, M>{
   	String name;
   	R r;
   	M m;
   	T t;
}
```

```java
package com.hspedu.customgeneric;

import java.util.Arrays;

@SuppressWarnings({"all"})
public class CustomGeneric_ {
    public static void main(String[] args) {

        //T=Double, R=String, M=Integer
        Tiger<Double,String,Integer> g = new Tiger<>("john");
        g.setT(10.9); //OK
        //g.setT("yy"); //错误，类型不对
        System.out.println(g);
        Tiger g2 = new Tiger("john~~");//OK T=Object R=Object M=Object
        g2.setT("yy"); //OK ,因为 T=Object "yy"=String 是Object子类
        System.out.println("g2=" + g2);

    }
}

//1. Tiger 后面泛型，所以我们把 Tiger 就称为自定义泛型类
//2, T, R, M 泛型的标识符, 一般是单个大写字母
//3. 泛型标识符可以有多个.
//4. 普通成员可以使用泛型 (属性、方法)
//5. 使用泛型的数组，不能初始化
//6. 静态方法中不能使用类的泛型
class Tiger<T, R, M> {
    String name;
    R r; //属性使用到泛型
    M m;
    T t;
    //因为数组在new 不能确定T的类型，就无法在内存开空间
    T[] ts;

    public Tiger(String name) {
        this.name = name;
    }

    public Tiger(R r, M m, T t) {//构造器使用泛型

        this.r = r;
        this.m = m;
        this.t = t;
    }

    public Tiger(String name, R r, M m, T t) {//构造器使用泛型
        this.name = name;
        this.r = r;
        this.m = m;
        this.t = t;
    }

    //因为静态是和类相关的，在类加载时，对象还没有创建
    //所以，如果静态方法和静态属性使用了泛型，JVM就无法完成初始化
//    static R r2;
//    public static void m1(M m) {
//
//    }

    //方法使用泛型

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public R getR() {
        return r;
    }

    public void setR(R r) {//方法使用到泛型
        this.r = r;
    }

    public M getM() {//返回类型可以使用泛型.
        return m;
    }

    public void setM(M m) {
        this.m = m;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "Tiger{" +
                "name='" + name + '\'' +
                ", r=" + r +
                ", m=" + m +
                ", t=" + t +
                ", ts=" + Arrays.toString(ts) +
                '}';
    }
}
```

### 自定义泛型接口

```java
interface 接口名 <T,R...> {
}
```

注意细节

1) 接口中，静态成员也不能使用泛型(这个和泛型类规定一样)
2) 泛型接口的类型,在**继承接口**或者**实现接口**时确定
3) 没有指定类型，默认为Object

```java
package com.hspedu.customgeneric;

public class CustomInterfaceGeneric {
    public static void main(String[] args) {

    }
}

/**
 *  泛型接口使用的说明
 *  1. 接口中，静态成员也不能使用泛型
 *  2. 泛型接口的类型, 在继承接口或者实现接口时确定
 *  3. 没有指定类型，默认为Object
 */

//在继承接口 指定泛型接口的类型
interface IA extends IUsb<String, Double> {

}
//当我们去实现IA接口时，因为IA在继承IUsb 接口时，指定了U 为String R为Double
//，在实现IUsb接口的方法时，使用String替换U, 是Double替换R
class AA implements IA {

    @Override
    public Double get(String s) {
        return null;
    }
    @Override
    public void hi(Double aDouble) {

    }
    @Override
    public void run(Double r1, Double r2, String u1, String u2) {

    }
}

//实现接口时，直接指定泛型接口的类型
//给U 指定Integer 给 R 指定了 Float
//所以，当我们实现IUsb方法时，会使用Integer替换U, 使用Float替换R
class BB implements IUsb<Integer, Float> {

    @Override
    public Float get(Integer integer) {
        return null;
    }

    @Override
    public void hi(Float aFloat) {

    }

    @Override
    public void run(Float r1, Float r2, Integer u1, Integer u2) {

    }
}
//没有指定类型，默认为Object
//建议直接写成 IUsb<Object,Object>
class CC implements IUsb { //等价 class CC implements IUsb<Object,Object> {
    @Override
    public Object get(Object o) {
        return null;
    }
    @Override
    public void hi(Object o) {
    }
    @Override
    public void run(Object r1, Object r2, Object u1, Object u2) {

    }

}

interface IUsb<U, R> {

    int n = 10;
    //U name; 不能这样使用

    //普通方法中，可以使用接口泛型
    R get(U u);

    void hi(R r);

    void run(R r1, R r2, U u1, U u2);

    //在jdk8 中，可以在接口中，使用默认方法, 也是可以使用泛型
    default R method(U u) {
        return null;
    }
}
```

### 自定义泛型方法

```java
修饰符 <T,R..> 返回类型 方法名 (参数列表){}
```

注意细节

1. 泛型方法，可以定义在普通类中,也可以定义在泛型类中

2. 当泛型方法被调用时，类型会确定

3. public void eat(E e) {}.修 饰符后没有 <T,R..> 

   eat方法不是泛型方法,而是使用了泛型。泛型方法，可以使用类声明的泛型，也可以使用自己声明泛型。

```java
package com.hspedu.customgeneric;

import java.util.ArrayList;

@SuppressWarnings({"all"})
public class CustomMethodGeneric {
    public static void main(String[] args) {
        Car car = new Car();
        car.fly("宝马", 100);//当调用方法时，传入参数，编译器，就会确定类型
        System.out.println("=======");
        car.fly(300, 100.1);//当调用方法时，传入参数，编译器，就会确定类型

        //测试
        //T->String, R-> ArrayList
        Fish<String, ArrayList> fish = new Fish<>();
        fish.hello(new ArrayList(), 11.3f);
    }
}

//泛型方法，可以定义在普通类中, 也可以定义在泛型类中
class Car {//普通类

    public void run() {//普通方法
    }
    //说明 泛型方法
    //1. <T,R> 就是泛型
    //2. 是提供给 fly使用的
    public <T, R> void fly(T t, R r) {//泛型方法
        System.out.println(t.getClass());//String
        System.out.println(r.getClass());//Integer
    }
}

class Fish<T, R> {//泛型类
    public void run() {//普通方法
    }
    public<U,M> void eat(U u, M m) {//泛型方法

    }
    //说明
    //1. 下面hi方法不是泛型方法
    //2. 是hi方法使用了类声明的 泛型
    public void hi(T t) {
    }
    // 泛型方法，可以使用类声明的泛型，也可以使用自己声明泛型
    public<K> void hello(R r, K k) {
        System.out.println(r.getClass());//ArrayList
        System.out.println(k.getClass());//Float
    }
}
```

#### 自定义泛型方法练习

下面代码是否正确，如果有错误，修改正确，并说明输出什么?

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230501164805910.png)

```java
package com.hspedu.customgeneric;

public class CustomMethodGenericExercise {
    public static void main(String[] args) {
        //T->String, R->Integer, M->Double
        Apple<String, Integer, Double> apple = new Apple<>();
        apple.fly(10);//10 会被自动装箱 Integer10, 输出Integer
        apple.fly(new Dog());//Dog

    }
}

class Apple<T, R, M> {//自定义泛型类

    public <E> void fly(E e) {  //泛型方法
        System.out.println(e.getClass().getSimpleName());
    }

    //public void eat(U u) {}//错误，因为U没有声明
    public void run(M m) {
    } //ok
}

class Dog {
}
```

## 泛型的继承和通配符

### 泛型的继承和通配符说明

1) 泛型不具备继承性

```java
List <Object> list = new ArrayList<String>(); //错误
```

2) <?>:支持任意泛型类型

3) <? extends A>:支持A类以及A类的子类，规定了泛型的上限

4) <? super A>:支持A类以及A类的父类，不限于直接父类，规定了泛型的下限

```java
package com.hspedu;

import java.util.ArrayList;
import java.util.List;

public class GenericExtends {
    public static void main(String[] args) {

        Object o = new String("xx");

        //泛型没有继承性
        //List<Object> list = new ArrayList<String>();

        //举例说明下面三个方法的使用
        List<Object> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<AA> list3 = new ArrayList<>();
        List<BB> list4 = new ArrayList<>();
        List<CC> list5 = new ArrayList<>();

        //如果是 List<?> c ，可以接受任意的泛型类型
        printCollection1(list1);
        printCollection1(list2);
        printCollection1(list3);
        printCollection1(list4);
        printCollection1(list5);

        //List<? extends AA> c： 表示 上限，可以接受 AA或者AA子类
//        printCollection2(list1);//×
//        printCollection2(list2);//×
        printCollection2(list3);//√
        printCollection2(list4);//√
        printCollection2(list5);//√

        //List<? super AA> c: 支持AA类以及AA类的父类，不限于直接父类
        printCollection3(list1);//√
        //printCollection3(list2);//×
        printCollection3(list3);//√
        //printCollection3(list4);//×
        //printCollection3(list5);//×


    }
    // ? extends AA 表示 上限，可以接受 AA或者AA子类
    public static void printCollection2(List<? extends AA> c) {
        for (Object object : c) {
            System.out.println(object);
        }
    }

    //说明: List<?> 表示 任意的泛型类型都可以接受
    public static void printCollection1(List<?> c) {
        for (Object object : c) { // 通配符，取出时，就是Object
            System.out.println(object);
        }
    }



    // ? super 子类类名AA:支持AA类以及AA类的父类，不限于直接父类，
    //规定了泛型的下限
    public static void printCollection3(List<? super AA> c) {
        for (Object object : c) {
            System.out.println(object);
        }
    }

}

class AA {
}

class BB extends AA {
}

class CC extends BB {
}
```

## JUnit

1. 一个类有很多功能代码需要测试，为了测试，就需要写入到main方法中

2. 如果有多个功能代码测试，就需要来回注销,切换很麻烦
3. 如果可以直接运行一个方法，就方便很多，并且可以给出相关信息，就好了，可以用 JUnit 测试框架

JUnit是一个Java语言的单元测试框架

多数Java的开发环境都已经集成了JUnit作为单元测试的工具，不用直接在main中实例对象再调用方法了，可以直接单独执行方法。

使用方法：先写 `@Test` ，然后 `Alt + Enter` 从Maven 添加 Junit 即可。

```java
package com.hspedu.junit_;

import org.junit.jupiter.api.Test;

public class JUnit_ {
    public static void main(String[] args) {
        //传统方式
        //new JUnit_().m1();
        //new JUnit_().m2();
    }

    @Test
    public void m1() {
        System.out.println("m1方法被调用");
    }

    @Test
    public void m2() {
        System.out.println("m2方法被调用");
    }

    @Test
    public void m3() {
        System.out.println("m3方法被调用");
    }
}
```

## 本章作业

1.编程题

定义个泛型类DAO<T>，在其中定义一个Map成员变量，Map的键为String 类型，值为T类型。

分别创建以下方法:
(1) public void save(String id,T entity):保存T类型的对象到Map成员变量

(2) public T get(String id):从map中获取id对应的对象

(3) public void update(String id,T entity):替换 map 中key为id的内容,改为entity对象

(4) public List<T> list):返回map中存放的所有T对象

(5) public void delete(String id):删除指定id对象

定义一个 User类:

该类包含:private成员变量(int类型) id,age; (String类型)name。

创建 DAO 类的对象，分别调用其save、get、update、list、delete方法来操作User对象，使用 Junit 单元测试类进行测试。

```java
package com.hspedu.homework;

/**
 * 该类包含：private成员变量（int类型） id，age；（String 类型）name
 */
public class User {
    private int id;
    private int age;
    private String name;

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
```

```java
package com.hspedu.homework;

import java.util.*;

/**
 * 定义个泛型类 DAO<T>，在其中定义一个Map 成员变量，Map 的键为 String 类型，值为 T 类型。
 *  *
 *  * 分别创建以下方法：
 *  * (1) public void save(String id,T entity)： 保存 T 类型的对象到 Map 成员变量中
 *  * (2) public T get(String id)：从 map 中获取 id 对应的对象
 *  * (3) public void update(String id,T entity)：替换 map 中key为id的内容,改为 entity 对象
 *  * (4) public List<T> list()：返回 map 中存放的所有 T 对象
 *  * (5) public void delete(String id)：删除指定 id 对象
 */
public class DAO<T> {//泛型类
    private Map<String, T> map = new HashMap<>();

    public T get(String id) {
        return map.get(id);
    }
    public void update(String id,T entity) {
        map.put(id, entity);
    }
    //返回 map 中存放的所有 T 对象
    //遍历map [k-v],将map的 所有value(T entity),封装到ArrayList返回即可
    public List<T> list() {
        //创建 Arraylist
        List<T> list = new ArrayList<>();

        //遍历map
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            //map.get(key) 返回就是 User对象->ArrayList
            list.add(map.get(key)); //也可以直接使用本类的 get(String id)
        }

        return list;
    }
    public void delete(String id) {
        map.remove(id);
    }
    public void save(String id,T entity) {//把entity保存到map
        map.put(id, entity);
    }
}
```