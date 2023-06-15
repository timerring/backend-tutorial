- [第23章 反射(reflection)](#第23章-反射reflection)
  - [一个需求引出反射](#一个需求引出反射)
  - [反射机制](#反射机制)
    - [Java Reflection](#java-reflection)
    - [Java 反射机制原理示意图](#java-反射机制原理示意图)
    - [Java 反射机制可以完成](#java-反射机制可以完成)
    - [反射相关的主要类](#反射相关的主要类)
    - [反射优点和缺点](#反射优点和缺点)
    - [反射调用优化-关闭访问检查](#反射调用优化-关闭访问检查)
  - [Class 类](#class-类)
    - [基本介绍](#基本介绍)
    - [Class 类的常用方法](#class-类的常用方法)
    - [获取Class 类对象](#获取class-类对象)
  - [哪些类型有Class 对象](#哪些类型有class-对象)
    - [如下类型有Class 对象](#如下类型有class-对象)
  - [类加载](#类加载)
    - [基本说明](#基本说明)
    - [类加载时机](#类加载时机)
    - [类加载过程图](#类加载过程图)
    - [类加载各阶段完成任务](#类加载各阶段完成任务)
    - [加载阶段](#加载阶段)
    - [连接阶段-验证](#连接阶段-验证)
    - [连接阶段-准备](#连接阶段-准备)
    - [连接阶段-解析](#连接阶段-解析)
    - [Initialization初始化](#initialization初始化)
  - [通过反射获取类的结构信息](#通过反射获取类的结构信息)
    - [第一组: java.lang.Class 类](#第一组-javalangclass-类)
    - [第二组: java.lang.reflect.Field 类](#第二组-javalangreflectfield-类)
    - [第三组: java.lang.reflect.Method 类](#第三组-javalangreflectmethod-类)
    - [第四组: java.lang.reflect.Constructor 类](#第四组-javalangreflectconstructor-类)
  - [通过反射创建对象](#通过反射创建对象)
    - [案例演示](#案例演示)
  - [通过反射访问类中的成员](#通过反射访问类中的成员)
    - [访问属性](#访问属性)
    - [访问方法](#访问方法)
  - [本章作业](#本章作业)


# 第23章 反射(reflection)

## 一个需求引出反射

1. 根据配置文件 re.properties 指定信息,创建Cat对象并调用方法hi

   ```properties
   classfullpath = com.hspedu.Cat
   method = hi
   ```

2. 这样的需求在学习框架时特别多，即通过外部文件配置，在不修改源码情况下。来控制程序，也符合设计模式的ocp原则(开闭原则:不修改源码，扩容功能)。

```java
package com.hspedu.reflection.question;

import com.hspedu.Cat;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 反射问题的引入
 */
@SuppressWarnings({"all"})
public class ReflectionQuestion {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {

        //根据配置文件 re.properties 指定信息, 创建Cat对象并调用方法hi
        //传统的方式 new 对象 -》 调用方法
//        Cat cat = new Cat();
//        cat.hi(); ===> cat.cry() 修改源码.

        //我们尝试做一做 -> 明白反射

        //1. 使用Properties 类, 可以读写配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\re.properties"));
        String classfullpath = properties.get("classfullpath").toString();//"com.hspedu.Cat"
        String methodName = properties.get("method").toString();//"hi"
        System.out.println("classfullpath=" + classfullpath);
        System.out.println("method=" + methodName);

        //2. 创建对象 , 传统的方法，行不通 =》 反射机制
        //new classfullpath(); // classfullpath 这是一个字符串，而正规应该new 类名()

        //3. 使用反射机制解决
        //(1) 加载类, 返回Class类型的对象cls
        Class cls = Class.forName(classfullpath);
        //(2) 通过 cls 得到你加载的类 com.hspedu.Cat 的对象实例
        Object o = cls.newInstance();
        System.out.println("o的运行类型=" + o.getClass()); //运行类型
        //(3) 通过 cls 得到你加载的类 com.hspedu.Cat 的 methodName"hi"  的方法对象
        //    即：在反射中，可以把方法视为对象（万物皆对象）
        Method method1 = cls.getMethod(methodName);
        //(4) 通过method1 调用方法: 即通过方法对象来实现调用方法
        System.out.println("=============================");
        method1.invoke(o); //传统方法 对象.方法() , 反射机制 方法.invoke(对象)
    }
}
```

## 反射机制

### Java Reflection

1. 反射机制允许程序在执行期借助于 `Reflection API` 取得任何类的内部信息(比如成员变量，构造器，成员方法等等)，并能操作对象的属性及方法。反射在设计模式和框架底层都会用到。

2. 加载完类之后，在堆中就产生了一个Class类型的对象( 一个类只有一个Class对象)，这个对象包含了类的完整结构信息。通过这个对象得到类的结构。这个Class对象就像一面镜子,透过这个镜子看到类的结构,所以,形象的称之为：反射。

类比：

p对象 ---> 类型Person类

Class对象cls ---> 类型Class类

### Java 反射机制原理示意图

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230509145140396.png)

### Java 反射机制可以完成

1. 在运行时判断任意一个对象所属的类

2. 在运行时构造任意一个类的对象

3. 在运行时得到任意一个类所具有的成员变量和方法

4. 在运行时调用任意一个对象的成员变量和方法

5. 生成动态代理

### 反射相关的主要类

1. java.lang.Class:代表一个类，Class对象表示某个类加载后在堆中的对
2. java.lang.reflect.Method:代表类的方法, Method对象表示某个类的方法
3. java.lang.reflect.Field:代表类的成员变量,Field对象表示某个类的成员变量
1. java.lang.reflect.Constructor:代表类的构造方法,Constructor对象表示
构造器

这些类在java.lang.reflection

```java
package com.hspedu.reflection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

public class Reflection01 {

    public static void main(String[] args) throws Exception {

        //1. 使用Properties 类, 可以读写配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\re.properties"));
        String classfullpath = properties.get("classfullpath").toString();//"com.hspedu.Cat"
        String methodName = properties.get("method").toString();//"hi"

        //2. 使用反射机制解决
        //(1) 加载类, 返回Class类型的对象cls
        Class cls = Class.forName(classfullpath);
        //(2) 通过 cls 得到你加载的类 com.hspedu.Cat 的对象实例
        Object o = cls.newInstance();
        System.out.println("o的运行类型=" + o.getClass()); //运行类型
        //(3) 通过 cls 得到你加载的类 com.hspedu.Cat 的 methodName"hi"  的方法对象
        //    即：在反射中，可以把方法视为对象（万物皆对象）
        Method method1 = cls.getMethod(methodName);
        //(4) 通过method1 调用方法: 即通过方法对象来实现调用方法
        System.out.println("=============================");
        method1.invoke(o); //传统方法 对象.方法() , 反射机制 方法.invoke(对象)

        // java.lang.reflect.Field: 代表类的成员变量, Field对象表示某个类的成员变量
        // getField不能得到私有的属性
        Field nameField = cls.getField("age"); //
        System.out.println(nameField.get(o)); // 传统写法 对象.成员变量 , 反射: 成员变量对象.get(对象)

        //java.lang.reflect.Constructor: 代表类的构造方法, Constructor对象表示构造器
        //()中可以指定构造器参数类型, 返回无参构造器
        Constructor constructor = cls.getConstructor();
        System.out.println(constructor);//Cat()


        Constructor constructor2 = cls.getConstructor(String.class); //这里老师传入的 String.class 就是String类的Class对象
        System.out.println(constructor2);//Cat(String name)
    }
}
```

### 反射优点和缺点

1. 优点:可以动态的创建和使用对象(也是框架底层核心),使用灵活,没有反射机制,框架技术就失去底层支撑。
2. 缺点:使用反射基本是解释执行,对执行速度有影响.

### 反射调用优化-关闭访问检查

1. Method 和 Field、Constructor对象都有 setAccessible() 方法
2. setAccessible作用是启动和禁用访问安全检查的开关
3. 参数值为true表示反射的对象在使用时取消访问检查，提高反射的效率。参数值为false则表示反射的对象执行访问检查。

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230509151736484.png)

```java
package com.hspedu.reflection;

import com.hspedu.Cat;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 测试反射调用的性能，和优化方案
 */
public class Reflection02 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        m1();
        m2();
        m3();
    }

    //传统方法来调用hi
    public static void m1() {

        Cat cat = new Cat();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 90; i++) {
            cat.hi();
        }
        long end = System.currentTimeMillis();
        System.out.println("m1() 耗时=" + (end - start));
    }

    //反射机制调用方法hi
    public static void m2() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        Class cls = Class.forName("com.hspedu.Cat");
        Object o = cls.newInstance();
        Method hi = cls.getMethod("hi");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 900000000; i++) {
            hi.invoke(o);//反射调用方法
        }
        long end = System.currentTimeMillis();
        System.out.println("m2() 耗时=" + (end - start));
    }

    //反射调用优化 + 关闭访问检查

    public static void m3() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        Class cls = Class.forName("com.hspedu.Cat");
        Object o = cls.newInstance();
        Method hi = cls.getMethod("hi");
        hi.setAccessible(true);//在反射调用方法时，取消访问检查
        long start = System.currentTimeMillis();
        for (int i = 0; i < 900000000; i++) {
            hi.invoke(o);//反射调用方法
        }
        long end = System.currentTimeMillis();
        System.out.println("m3() 耗时=" + (end - start));
    }
}
```

## Class 类

### 基本介绍

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230509151951743.png)

1. Class也是类，因此也继承Object类[类图]
2. Class类对象不是new出来的，而是系统创建的[演示]
3. 对于某个类的Class类对象,在内存中只有一份，因为类只加载一次[演示]
4. 每个类的实例都会记得自己是由哪个Class 实例所生成
5. 通过Class对象可以完整地得到一个类的完整结构,通过一系列API
6. Class对象是存放在堆的
7. 类的字节码二进制数据，是放在方法区的，有的地方称为类的元数据(包括方法代码, 变量名，方法名，访问权限等等) https://www.zhihu.com/question/38496907【示意图】

```java
package com.hspedu.reflection.class_;

import com.hspedu.Cat;

import java.util.ArrayList;

/**
 * 对Class类特点的梳理
 */
public class Class01 {
    public static void main(String[] args) throws ClassNotFoundException {
        //看看Class类图
        //1. Class也是类，因此也继承Object类
        //Class
        //2. Class类对象不是new出来的，而是系统创建的
        //(1) 传统new对象
        /*  ClassLoader类
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                return loadClass(name, false);
            }
         */
        //Cat cat = new Cat();
        //(2) 反射方式, 刚才老师没有debug到 ClassLoader类的 loadClass, 原因是，我没有注销Cat cat = new Cat(); 而类只会加载一次，刚刚加载过下面就不会再次加载
        /*
            ClassLoader类, 仍然是通过 ClassLoader类加载Cat类的 Class对象
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                return loadClass(name, false);
            }
         */
        Class cls1 = Class.forName("com.hspedu.Cat");

        //3. 对于某个类的Class类对象，在内存中只有一份，因为类只加载一次!!!!!!!!!!
        Class cls2 = Class.forName("com.hspedu.Cat");
        System.out.println(cls1.hashCode());
        System.out.println(cls2.hashCode()); // 相等
        Class cls3 = Class.forName("com.hspedu.Dog");
        System.out.println(cls3.hashCode());
    }
}
```

### Class 类的常用方法

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230509155511997.png)

```java
package com.hspedu.reflection.class_;

import com.hspedu.Car;

import java.lang.reflect.Field;

/**
 * 演示Class类的常用方法
 */
public class Class02 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {

        String classAllPath = "com.hspedu.Car";
        //1 . 获取到Car类 对应的 Class对象
        //<?> 表示不确定的Java类型
        Class<?> cls = Class.forName(classAllPath);
        //2. 输出cls
        System.out.println(cls); //显示cls对象, 是哪个类的Class对象 com.hspedu.Car
        System.out.println(cls.getClass());//输出cls运行类型 java.lang.Class
        //3. 得到包名
        System.out.println(cls.getPackage().getName());//包名 com.hspedu
        //4. 得到全类名
        System.out.println(cls.getName()); // com.hspedu.Car
        //5. 通过cls创建对象实例
        Car car = (Car) cls.newInstance();
        System.out.println(car);//car.toString()
        //6. 通过反射获取属性 brand
        Field brand = cls.getField("brand");
        System.out.println(brand.get(car));//宝马
        //7. 通过反射给属性赋值
        brand.set(car, "奔驰");
        System.out.println(brand.get(car));//奔驰
        //8 我希望大家可以得到所有的属性(字段)
        System.out.println("=======所有的字段属性====");
        Field[] fields = cls.getFields();
        for (Field f : fields) {
            System.out.println(f.getName());//名称
        }
    }
}
```

### 获取Class 类对象

1.前提：已知一个类的全类名，且该类在类路径下，可通过Class类的静态方法 `forName()` 获取，可能抛出 `ClassNotFoundException`，实例:

```java
Class cls1 = Class.forName("java.lang.Cat");
```

应用场景：多用于配置文件,读取类全路径,加载类.

2.前提：若已知具体的类，通过类的 class 获取，该方式最为安全可靠，程序性能最高，实例：

```java
Class cls2 = Cat.class
```

应用场景:多用于参数传递，比如通过反射得到对应构造器对象.

3.前提:已知某个类的实例，调用该实例的 getClass() 方法获取Class对象，实例:

```java
Class clazz =对象.getClass();//运行类型
```

应用场景:通过创建好的对象，获取Class对象.

4.其他方式

```java
ClassLoader cls =对象.getClass(.getClassLoaderO;
Class clazz4 = cl.loadClass(“类的全类名”);
```

5.基本数据 (int, char,boolean.float,double,byte,long,short) 按如下方式得到Class类对象：

```java
Class cls =基本数据类型.class
```

6.基本数据类型对应的包装类,可以通过.TYPE得到Class类对象：

```java
Class cls = 包装类.TYPE
```

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230509161817270.png)

```java
package com.hspedu.reflection.class_;

import com.hspedu.Car;

/**
 * 演示得到Class对象的各种方式(6)
 */
public class GetClass_ {
    public static void main(String[] args) throws ClassNotFoundException {

        //1. Class.forName
        String classAllPath = "com.hspedu.Car"; //通过读取配置文件获取
        Class<?> cls1 = Class.forName(classAllPath);
        System.out.println(cls1);

        //2. 类名.class , 应用场景: 用于参数传递（例如前面通过反射得到构造器对象 传入参数就是 类名.class）
        Class cls2 = Car.class;
        System.out.println(cls2);

        //3. 对象.getClass(), 应用场景，有对象实例
        Car car = new Car();
        Class cls3 = car.getClass();
        System.out.println(cls3);

        //4. 通过类加载器【有4种类加载器】来获取到类的Class对象
        //(1)先得到类加载器 car
        ClassLoader classLoader = car.getClass().getClassLoader();
        //(2)通过类加载器得到Class对象
        Class cls4 = classLoader.loadClass(classAllPath);
        System.out.println(cls4);

        //cls1 , cls2 , cls3 , cls4 其实是同一个对象，因为一个类只能有一个class对象
        System.out.println(cls1.hashCode());
        System.out.println(cls2.hashCode());
        System.out.println(cls3.hashCode());
        System.out.println(cls4.hashCode());

        //5. 基本数据(int, char,boolean,float,double,byte,long,short) 按如下方式得到Class类对象
        Class<Integer> integerClass = int.class;
        Class<Character> characterClass = char.class;
        Class<Boolean> booleanClass = boolean.class;
        System.out.println(integerClass);//int

        //6. 基本数据类型对应的包装类，可以通过 .TYPE 得到Class类对象
        Class<Integer> type1 = Integer.TYPE;
        Class<Character> type2 = Character.TYPE; //其它包装类BOOLEAN, DOUBLE, LONG,BYTE类似
        System.out.println(type1);

        System.out.println(integerClass.hashCode());// 是同一个
        System.out.println(type1.hashCode());// 是同一个
    }
}
```

## 哪些类型有Class 对象

### 如下类型有Class 对象

1. 外部类，成员内部类，静态内部类,局部内部类，匿名内部类
2. interface:接口
3. 数组
4. enum:枚举
5. annotation:注解
6. 基本数据类型
7. void

```java
package com.hspedu.reflection.class_;

import java.io.Serializable;

/**
 * 演示哪些类型有Class对象
 */
public class AllTypeClass {
    public static void main(String[] args) {

        Class<String> cls1 = String.class;//外部类
        Class<Serializable> cls2 = Serializable.class;//接口
        Class<Integer[]> cls3 = Integer[].class;//数组
        Class<float[][]> cls4 = float[][].class;//二维数组
        Class<Deprecated> cls5 = Deprecated.class;//注解
        Class<Thread.State> cls6 = Thread.State.class;//枚举
        Class<Long> cls7 = long.class;//基本数据类型
        Class<Void> cls8 = void.class;//void数据类型
        Class<Class> cls9 = Class.class;//

        System.out.println(cls1);
        System.out.println(cls2);
        System.out.println(cls3);
        System.out.println(cls4);
        System.out.println(cls5);
        System.out.println(cls6);
        System.out.println(cls7);
        System.out.println(cls8);
        System.out.println(cls9);
    }
}
```

## 类加载

### 基本说明

反射机制是java实现动态语言的关键，也就是通过**反射实现类动态加载**。

1. 静态加载:编译时加载相关的类，如果没有则报错，依赖性太强。
2. 动态加载:运行时加载需要的类，如果运行时不用该类，即使不存在该类，也不报错，降低了依赖性。

### 类加载时机

1. 当创建对象时(new) //静态加载

2. 当子类被加载时，父类也加载 //静态加载

3. 调用类中的静态成员时 //静态加载

4. 通过反射 //动态加载

Class.forName("com.test.Cat");

### 类加载过程图

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230509163956778.png)

加载后方法区存储的是类的字节码二进制文件，而堆区就创建了相应的类的Class对象。

### 类加载各阶段完成任务

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230509164018419.png)

注意：这里是针对类的加载阶段，并不是new的阶段，因此是针对静态成员。

### 加载阶段

JVM在该阶段的主要目的是将字节码从不同的数据源(可能是class文件、也可能是jar包，甚至网络）转化为**二进制字节流加载到内存中**，并**生成一个代表该类的java.lang.Class对象**。

### 连接阶段-验证

1. 目的是为了确保 Class文件的字节流中包含的信息符合当前虚拟机的要求，并且不会危害虚拟机自身的安全。
2. 包括:文件格式验证(是否以魔数oxcafebabe开头)、元数据验证、字节码验证和符号引用验证[举例说明]。
3. 可以考虑使用 `-Xverify:none` 参数来关闭大部分的类验证措施，缩短虚拟机类加载的时间。

### 连接阶段-准备

1. JVM会在该阶段对静态变量，分配内存并默认初始化（对应数据类型的默认初始值，如0、OL、null、false等)。这些变量所使用的内存都将在方法区中进行分配。

```java
package com.hspedu.reflection.classload_;

public class ClassLoad02 {
    public static void main(String[] args) {

    }
}
class A {
    //属性-成员变量-字段
    //分析类加载的链接阶段-准备 属性是如何处理
    //1. n1 是实例属性, 不是静态变量，因此在准备阶段，是不会分配内存
    //2. n2 是静态变量，分配内存 n2 是默认初始化 0 ,而不是20。初始化子阶段才会是20。
    //3. n3 是 static final 是 常量, 他和静态变量不一样, 因为一旦赋值就不变 因此n3 = 30
    public int n1 = 10;
    public static  int n2 = 20;
    public static final  int n3 = 30;
}
```

### 连接阶段-解析

虚拟机将常量池内的**符号引用**替换为**直接引用**的过程。这个过程是由jvm机自动完成的。

### Initialization初始化

1. 到初始化阶段，才真正开始执行类中定义的Java程序代码，此阶段是执行<clinit>()方法的过程。

2. <clinit>()方法是由编译器按语句在源文件中出现的顺序，依次自动收集类中的所有**静态变量**的赋值动作和**静态代码块**中的语句,并进行合并。

3. 虚拟机会保证一个类的<clinit>()方法在多线程环境中被正确地加锁、同步，如果多个线程同时去初始化一个类，那么只会有一个线程去执行这个类的<clinit>0)方法，其他线程都需要阻塞等待，直到活动线程执行<clinit>()方法完毕

  正因为有这个机制，才能保证某个类在内存中, 只有一份Class对象。

```java
package com.hspedu.reflection.classload_;

/**
 * 演示类加载-初始化阶段
 */
public class ClassLoad03 {
    public static void main(String[] args) throws ClassNotFoundException {
        //1. 加载B类，并生成 B的class对象
        //2. 链接 num = 0
        //3. 初始化阶段
        //    依次自动收集类中的所有静态变量的赋值动作和静态代码块中的语句,并合并
        /*
                clinit() {
                // 按照顺序合并
                    System.out.println("B 静态代码块被执行");
                    //num = 300;
                    num = 100;
                }
                合并: num = 100

         */

        //new B();//类加载
        //System.out.println(B.num);//100, 如果直接使用类的静态属性，也会导致类的加载

        //看看加载类的时候，是有同步机制控制
        /*
        protected Class<?> loadClass(String name, boolean resolve)
        throws ClassNotFoundException
        {
            //正因为有这个机制，才能保证某个类在内存中, 只有一份Class对象
            synchronized (getClassLoadingLock(name)) {
            //....
            }
            }
         */
        B b = new B();
    }
}

class B {
    static {
        System.out.println("B 静态代码块被执行");
        num = 300;
    }

    static int num = 100;

    //如果直接调用类的静态变量，而没有new对象，则构造器不会被执行
    public B() {//构造器
        System.out.println("B() 构造器被执行");
    }
}
```

## 通过反射获取类的结构信息

### 第一组: java.lang.Class 类

1. getName:获取全类名

2. getSimpleName:获取简单类名
3. getFields:获取所有public修饰的属性，包含本类以及父类的
4. getDeclared Fields:获取本类中所有属性
5. getMethods:获取所有public修饰的方法，包含本类以及父类的
6. getDeclaredMethods:获取本类中所有方法
7. getConstructors:获取本类所有public修饰的构造器
8. getDeclaredConstructors:获取本类中所有构造器
9. getPackage:以Package形式返回包信息
10. getSuperClass:以Class形式返回父类信息
11. getlnterfaces:以Class[形式返回接口信息
12. getAnnotations:以Annotation0形式返回注解信息

### 第二组: java.lang.reflect.Field 类

1. getModifiers: 以int形式返回修饰符
   [说明:默认修饰符是0，public是1，private是2，protected是4，static是8, final是16], public(1) + static (8) =9
2. getType:以Class形式返回类型（属性对应类的class对象）
3. getName:返回属性名

### 第三组: java.lang.reflect.Method 类

1. getModifiers: 以int形式返回修饰符
[说明:默认修饰符是0，public是1，private是2，protected是4,static是8, final是16]
2. getReturnType: 以Class形式获取返回类型
3. getName: 返回方法名
4. getParameterTypes: 以Class[]返回参数类型数组

### 第四组: java.lang.reflect.Constructor 类

1. getModifiers: 以int形式返回修饰符
1. getName: 返回构造器名(全类名)
3. getParameterTypes: 以Class[]返回参数类型数组

```java
package com.hspedu.reflection;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 演示如何通过反射获取类的结构信息
 */
public class ReflectionUtils {
    public static void main(String[] args) {

    }

    @Test
    public void api_02() throws ClassNotFoundException, NoSuchMethodException {
        //得到Class对象
        Class<?> personCls = Class.forName("com.hspedu.reflection.Person");
        //getDeclaredFields:获取本类中所有属性
        //规定 说明: 默认修饰符 是0 ， public  是1 ，private 是 2 ，protected 是 4 , static 是 8 ，final 是 16
        Field[] declaredFields = personCls.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("本类中所有属性=" + declaredField.getName()
                    + " 该属性的修饰符值=" + declaredField.getModifiers()
                    + " 该属性的类型=" + declaredField.getType());
        }

        //getDeclaredMethods:获取本类中所有方法
        Method[] declaredMethods = personCls.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("本类中所有方法=" + declaredMethod.getName()
                    + " 该方法的访问修饰符值=" + declaredMethod.getModifiers()
                    + " 该方法返回类型" + declaredMethod.getReturnType());

            //输出当前这个方法的形参数组情况
            Class<?>[] parameterTypes = declaredMethod.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.println("该方法的形参类型=" + parameterType);
            }
        }

        //getDeclaredConstructors:获取本类中所有构造器
        Constructor<?>[] declaredConstructors = personCls.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println("====================");
            System.out.println("本类中所有构造器=" + declaredConstructor.getName());//这里老师只是输出名

            Class<?>[] parameterTypes = declaredConstructor.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.println("该构造器的形参类型=" + parameterType);
            }
        }
    }

    // 第一组方法API
    @Test
    public void api_01() throws ClassNotFoundException, NoSuchMethodException {

        //得到Class对象
        Class<?> personCls = Class.forName("com.hspedu.reflection.Person");
        //getName:获取全类名
        System.out.println(personCls.getName());//com.hspedu.reflection.Person
        //getSimpleName:获取简单类名
        System.out.println(personCls.getSimpleName());//Person
        //getFields: 获取所有public修饰的属性，包含本类以及父类的
        Field[] fields = personCls.getFields();
        for (Field field : fields) {//增强for
            System.out.println("本类以及父类的属性=" + field.getName());
        }
        //getDeclaredFields: 获取本类中所有属性
        Field[] declaredFields = personCls.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("本类中所有属性=" + declaredField.getName());
        }
        //getMethods: 获取所有public修饰的方法，包含本类以及父类的
        Method[] methods = personCls.getMethods();
        for (Method method : methods) {
            System.out.println("本类以及父类的方法=" + method.getName());
        }
        //getDeclaredMethods:获取本类中所有方法
        Method[] declaredMethods = personCls.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("本类中所有方法=" + declaredMethod.getName());
        }
        //getConstructors: 获取所有public修饰的构造器，包含本类
        Constructor<?>[] constructors = personCls.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println("本类的构造器=" + constructor.getName());
        }
        //getDeclaredConstructors:获取本类中所有构造器
        Constructor<?>[] declaredConstructors = personCls.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println("本类中所有构造器=" + declaredConstructor.getName());//这里老师只是输出名
        }
        //getPackage:以Package形式返回 包信息
        System.out.println(personCls.getPackage());//com.hspedu.reflection
        //getSuperClass:以Class形式返回父类信息
        Class<?> superclass = personCls.getSuperclass();
        System.out.println("父类的class对象=" + superclass);//
        //getInterfaces:以Class[]形式返回接口信息
        Class<?>[] interfaces = personCls.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println("接口信息=" + anInterface);
        }
        //getAnnotations:以Annotation[] 形式返回注解信息
        Annotation[] annotations = personCls.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("注解信息=" + annotation);//注解
        }


    }
}

class A {
    public String hobby;

    public void hi() {

    }

    public A() {
    }

    public A(String name) {
    }
}

interface IA {
}

interface IB {

}

@Deprecated
class Person extends A implements IA, IB {
    //属性
    public String name;
    protected static int age; // 4 + 8 = 12
    String job;
    private double sal;

    //构造器
    public Person() {
    }

    public Person(String name) {
    }

    //私有的
    private Person(String name, int age) {

    }

    //方法
    public void m1(String name, int age, double sal) {

    }

    protected String m2() {
        return null;
    }

    void m3() {

    }

    private void m4() {

    }
}
```

## 通过反射创建对象

1. 方式一:调用类中的public修饰的无参构造器

2. 方式二:调用类中的指定构造器

3. Class类相关方法
   + newlnstance:调用类中的无参构造器,获取对应类的对象
   + getConstructor(Class..clazz):根据参数列表，获取对应的public构造器对象
   + getDecalaredConstructor(Class..clazz):根据参数列表，获取对应的所有构造器对象

4. Constructor类相关方法

   + setAccessible:暴破 （**使用反射可以访问private构造器/方法/属性**, 反射面前，都是纸老虎）

     ```java
     constructor1.setAccessible(true);
     ```

   + newlnstance(Object...obj):调用构造器

### 案例演示

测试1：通过反射创建某类的对象，要求该类中必须有public 的无参构造

测试2：通过调用某个特定构造器的方式，实现创建某类的对象

```java
package com.hspedu.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 演示通过反射机制创建实例
 */
public class ReflecCreateInstance {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        //1. 先获取到User类的Class对象
        Class<?> userClass = Class.forName("com.hspedu.reflection.User");
        //2. 通过public的无参构造器创建实例
        Object o = userClass.newInstance();
        System.out.println(o);
        //3. 通过public的有参构造器创建实例
        /*
            constructor 对象就是
            public User(String name) {//public的有参构造器
                this.name = name;
            }
         */
        //3.1 先得到对应构造器
        Constructor<?> constructor = userClass.getConstructor(String.class);
        //3.2 创建实例，并传入实参
        Object hsp = constructor.newInstance("hsp");
        System.out.println("hsp=" + hsp);

        //4. 通过非public的有参构造器创建实例
        //4.1 得到private的构造器对象
        Constructor<?> constructor1 = userClass.getDeclaredConstructor(int.class, String.class);
        //4.2 创建实例
        //暴破【暴力破解】 , 使用反射可以访问private构造器/方法/属性, 反射面前，都是纸老虎
        constructor1.setAccessible(true);

        Object user2 = constructor1.newInstance(100, "张三丰");
        System.out.println("user2=" + user2);
    }
}

class User { //User类
    private int age = 10;
    private String name = "教育";

    public User() {//无参 public
    }

    public User(String name) {//public的有参构造器
        this.name = name;
    }

    private User(int age, String name) {//private 有参构造器
        this.age = age;
        this.name = name;
    }

    public String toString() {
        return "User [age=" + age + ", name=" + name + "]";
    }
}
```

## 通过反射访问类中的成员

### 访问属性

1. 根据属性名获取Field对象
   Field f = clazz对象.getDeclaredField(属性名);

2. 暴破:`f.setAccessible(true);` //f是Field

3. 访问

   ```java
   f.set(o, 值);//o表示对象
   syso(f.get(o));//o表示对象
   ```

4. 注意:如果是静态属性，则set和get中的参数o，可以写成null

```java
package com.hspedu.reflection;

import java.lang.reflect.Field;

/**
 * 演示反射操作属性
 */
public class ReflecAccessProperty {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {

        //1. 得到Student类对应的 Class对象
        Class<?> stuClass = Class.forName("com.hspedu.reflection.Student");
        //2. 创建对象
        Object o = stuClass.newInstance();//o 的运行类型就是Student
        System.out.println(o.getClass());//Student
        //3. 使用反射得到 age 属性对象
        Field age = stuClass.getField("age");
        age.set(o, 88);//通过反射来操作属性
        System.out.println(o);//
        System.out.println(age.get(o));//返回age属性的值

        //4. 使用反射操作name 属性
        Field name = stuClass.getDeclaredField("name");
        //对name 进行暴破, 可以操作private 属性
        name.setAccessible(true);
        //name.set(o, "老");
        name.set(null, "老~");// 因为name是static属性，在类加载的时候就已经有了，因此 o 也可以写出null
        System.out.println(o);
        System.out.println(name.get(o)); // 获取属性值
        System.out.println(name.get(null));// 获取属性值, 必须要求name是static
    }
}

class Student {//类
    public int age;
    private static String name;

    public Student() {//构造器
    }
    public String toString() {
        return "Student [age=" + age + ", name=" + name + "]";
    }
}
```

### 访问方法

1. 根据方法名和参数列表获取Method方法对象: 

   ```java
   Method m = clazz.getDeclaredMethod(方法名, X.class);//得到本类的所有方法
   ```

2. 获取对象:`Object o=clazz.newlnstance();`

3. 暴破:`m.setAccessible(true);`

4. 访问:`Object returnValue = m.invoke(o,实参列表);//o就是对象`

5. 注意:如果是静态方法，则invoke的参数o，可以写成null!

```java
package com.hspedu.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 演示通过反射调用方法
 */
public class ReflecAccessMethod {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {

        //1. 得到Boss类对应的Class对象
        Class<?> bossCls = Class.forName("com.hspedu.reflection.Boss");
        //2. 创建对象
        Object o = bossCls.newInstance();
        //3. 调用public的hi方法
        //Method hi = bossCls.getMethod("hi", String.class);//OK
        //3.1 得到hi方法对象
        Method hi = bossCls.getDeclaredMethod("hi", String.class);//OK
        //3.2 调用
        hi.invoke(o, "教育~");

        //4. 调用private static 方法
        //4.1 得到 say 方法对象
        Method say = bossCls.getDeclaredMethod("say", int.class, String.class, char.class);
        //4.2 因为say方法是private, 所以需要暴破，原理和前面讲的构造器和属性一样
        say.setAccessible(true);
        System.out.println(say.invoke(o, 100, "张三", '男'));
        //4.3 因为say方法是static的，还可以这样调用 ，可以传入null
        System.out.println(say.invoke(null, 200, "李四", '女'));

        //5. 在反射中，如果方法有返回值，统一返回Object , 但是他运行类型和方法定义的返回类型一致
        Object reVal = say.invoke(null, 300, "王五", '男');
        System.out.println("reVal 的运行类型=" + reVal.getClass());//String


        //在演示一个返回的案例
        Method m1 = bossCls.getDeclaredMethod("m1");
        Object reVal2 = m1.invoke(o);
        System.out.println("reVal2的运行类型=" + reVal2.getClass());//Monster


    }
}

class Monster {}
class Boss {//类
    public int age;
    private static String name;

    public Boss() {//构造器
    }

    public Monster m1() {
        return new Monster();
    }

    private static String say(int n, String s, char c) {//静态方法
        return n + " " + s + " " + c;
    }

    public void hi(String s) {//普通public方法
        System.out.println("hi " + s);
    }
}
```

## 本章作业

练习1 ：通过反射修改私有成员变量

1. 定义PrivateTest类，有私有name属性，并且属性值为hellokitty

2. 提供getName的公有方法

3. 创建PrivateTest的类，利用Class类得到私有的name属性，修改私有的name属性值,并调用getName()的方法打印name属性值

   ```java
   class PrivateTest{
   private String name = "hellokitty";
   public String getName(){
   return name;
   }}
   ```

```java
package com.hspedu.reflection.homework;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Homework01 {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        /**
         * 定义PrivateTest类，有私有name属性，并且属性值为hellokitty
         * 提供getName的公有方法
         * 创建PrivateTest的类，利用Class类得到私有的name属性，修改私有的name属性值，并调用getName()的方法打印name属性值
         */
        //1. 得到 PrivateTest类对应的Class对象
        Class<PrivateTest> privateTestClass = PrivateTest.class;
        //2. 创建对象实例
        PrivateTest privateTestObj = privateTestClass.newInstance();
        //3. 得到name属性对象
        Field name = privateTestClass.getDeclaredField("name");//name属性是private
        //4. 暴破name
        name.setAccessible(true);
        name.set(privateTestObj, "天龙八部");
        //5. 得到getName方法对象
        Method getName = privateTestClass.getMethod("getName");
        //6. 因为getName() 是public，所有直接调用
        Object invoke = getName.invoke(privateTestObj);
        System.out.println("name属性值=" + invoke);//天龙八部

    }
}

class PrivateTest {
    private String name = "hellokitty";
    //默认无参构造器
    public String getName() {
        return name;
    }
}
```

练习2 ：利用反射和File完成以下功能

1. 利用Class类的forName方法得到File类的class对象
2. 在控制台打印File类的所有构造器
3. 通过newlnstance的方法创建File对象，并创建E:\mynew.txt文件
   提示:创建文件的正常写法如下:
   File file = new File("d:1laa.txt");//内存
   file.createNewFile0;//方法，才能真正的创建文件

```java
package com.hspedu.reflection.homework;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Homework02 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        /**
         * 利用Class类的forName方法得到File类的class 对象
         * 在控制台打印File类的所有构造器
         * 通过newInstance的方法创建File对象，并创建E:\mynew.txt文件
         */
        //1. Class类的forName方法得到File类的class 对象
        Class<?> fileCls = Class.forName("java.io.File");
        //2. 得到所有的构造器
        Constructor<?>[] declaredConstructors = fileCls.getDeclaredConstructors();
        //遍历输出
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println("File构造器=" + declaredConstructor);
        }
        //3. 指定的得到 public java.io.File(java.lang.String)
        Constructor<?> declaredConstructor = fileCls.getDeclaredConstructor(String.class);
        String fileAllPath = "e:\\mynew.txt";
        Object file = declaredConstructor.newInstance(fileAllPath);//创建File对象

        //4. 得到createNewFile 的方法对象
        Method createNewFile = fileCls.getMethod("createNewFile");
        createNewFile.invoke(file);//创建文件，调用的是 createNewFile
        //file的运行类型就是File
        System.out.println(file.getClass());
        System.out.println("创建文件成功" + fileAllPath);
    }
}
```