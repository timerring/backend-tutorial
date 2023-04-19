# 第11章 枚举和注解

## 先看一个需求

要求创建季节(Season) 对象，请设计并完成。

```java
class Season{//类
    private String name;
    private String desc;//描述
    //构造器
    //getXX
    //setXX
}
```

对于季节而已，他的对象(具体值)，是固定的四个，不会有更多。一般的类设计类的思路，不能体现季节是固定的四个对象。采用枚举类。

- 季节的值是有限的几个值(spring, summer, autumn, winter)
- 只读，不需要修改。

因为不能存在如下的情况：

```java
autumn.setName("XXX"); // 修改了秋天的名字
```

## 枚举

1) 枚举对应英文(enumeration, 简写enum)
2) 枚举是一组常量的集合。
3) 可以这里理解：枚举属于一种特殊的类，里面只包含一组有限的特定的对象。

### 枚举的二种实现方式

1) 自定义类实现枚举
2) 使用enum 关键字实现枚举

### 自定义类实现枚举-应用案例

1.不需要提供setXxx方法，因为枚举对象值通常为只读.

2.对枚举对象/属性使用 final + static共同修饰，实现底层优化.（final 和 static 搭配使用可以不导致类加载,效率更高）

3.枚举对象名通常使用全部大写，常量的命名规范.

4.枚举对象根据需要,也可以有多个属性

```java
package com.hspedu.enum_;

public class Enumeration02 {
    public static void main(String[] args) {
        System.out.println(Season.AUTUMN);
        System.out.println(Season.SPRING);
    }
}

//演示字定义枚举实现
class Season {//类
    private String name;
    private String desc;//描述

    //定义了四个对象, 固定.
    public static final Season SPRING = new Season("春天", "温暖");
    public static final Season WINTER = new Season("冬天", "寒冷");
    public static final Season AUTUMN = new Season("秋天", "凉爽");
    public static final Season SUMMER = new Season("夏天", "炎热");


    //1. 将构造器私有化,目的防止 直接 new
    //2. 去掉setXxx方法, 防止属性被修改
    //3. 在Season 内部，直接创建固定的对象
    //4. 优化，可以加入 final 修饰符（static会导致类加载，防止这种情况， final 和 static 搭配使用可以不导致类加载,效率更高）
    private Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
```

小结：

1) 构造器私有化
2) 本类内部创建一组对象[四个 春夏秋冬]
3) 对外暴露对象（通过为对象添加public final static 修饰符）
4) 可以提供get 方法，但是不要提供set

## enum 关键字实现枚举-快速入门

```java
package com.hspedu.enum_;

public class Enumeration03 {
    public static void main(String[] args) {
        System.out.println(Season2.AUTUMN);
        System.out.println(Season2.SUMMER);
    }
}
//演示使用enum关键字来实现枚举类
enum  Season2 {//类


    //定义了四个对象, 固定.
//    public static final Season SPRING = new Season("春天", "温暖");
//    public static final Season WINTER = new Season("冬天", "寒冷");
//    public static final Season AUTUMN = new Season("秋天", "凉爽");
//    public static final Season SUMMER = new Season("夏天", "炎热");
    //如果使用了enum 来实现枚举类
    //1. 使用关键字 enum 替代 class
    //2. public static final Season SPRING = new Season("春天", "温暖") 直接使用
    //   SPRING("春天", "温暖") 解读 常量名(实参列表)
    //3. 如果有多个常量(对象)， 使用 ,号间隔即可
    //4. 如果使用enum 来实现枚举，要求将定义常量对象，写在前面
    //5. 如果我们使用的是无参构造器，创建常量对象，则可以省略 ()
    SPRING("春天", "温暖"), WINTER("冬天", "寒冷"), AUTUMN("秋天", "凉爽"),
    SUMMER("夏天", "炎热"), What();

    private String name;
    private String desc;//描述

    private Season2() {//无参构造器

    }

    private Season2(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
```

### enum 关键字实现枚举注意事项

1) 当我们使用enum 关键字开发一个枚举类时，默认会继承Enum 类, 而且是一个final 类，使用 javap 工具来演示。
   
   ![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/04/18-10-31-36-1681785072.png)

2) 传统的public static final Season2 SPRING = new Season2("春天", "温暖"); 简化成SPRING("春天", "温暖")， 这里必须知道，它调用的是哪个构造器。

3) 如果使用无参构造器创建枚举对象，则实参列表和小括号都可以省略。

4) 当有多个枚举对象时，使用，间隔，最后有一个分号结尾。

5) 枚举对象必须放在枚举类的行首。

## enum 常用方法说明

说明：使用关键字enum 时，会隐式继承Enum 类, 这样我们就可以使用Enum 类相关的方法。

 ![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/04/18-10-39-51-1681785590.png)

## enum 常用方法应用实例

1) toString:Enum 类已经重写过了，返回的是当前对象名,子类可以重写该方法，用于返回对象的属性信息。
2) name：返回当前对象名（常量名），子类中不能重写。
3) ordinal：返回当前对象的位置号，默认从0 开始。
4) values：返回当前枚举类中所有的常量。
5) valueOf：将字符串转换成枚举对象，要求字符串必须为已有的常量名，否则报异常！
6) compareTo：比较两个枚举常量，比较的就是编号（前减后编号）！

```java
package com.hspedu.enum_;

public class EnumMethod {
    public static void main(String[] args) {
        //使用Season2 枚举类，来演示各种方法
        Season2 autumn = Season2.AUTUMN;

        //输出枚举对象的名字
        System.out.println(autumn.name());
        //ordinal() 输出的是该枚举对象的次序/编号，从0开始编号
        //AUTUMN 枚举对象是第三个，因此输出 2
        System.out.println(autumn.ordinal());
        //从反编译可以看出 values方法，返回 Season2[]
        //含有定义的所有枚举对象
        Season2[] values = Season2.values();
        System.out.println("===遍历取出枚举对象(增强for)====");
        for (Season2 season: values) {//增强for循环
            System.out.println(season);
        }

        //valueOf：将字符串转换成枚举对象，要求字符串必须为已有的常量名，否则报异常
        //执行流程
        //1. 根据你输入的 "AUTUMN" 到 Season2的枚举对象去查找
        //2. 如果找到了，就返回，如果没有找到，就报错
        Season2 autumn1 = Season2.valueOf("AUTUMN");
        System.out.println("autumn1=" + autumn1);
        System.out.println(autumn == autumn1); // T

        //compareTo：比较两个枚举常量，比较的就是编号
        //1. 就是把 Season2.AUTUMN 枚举对象的编号 和 Season2.SUMMER枚举对象的编号比较
        //2. 看看结果
        /*
        源码：
        public final int compareTo(E o) {

            return self.ordinal - other.ordinal;
        }
        Season2.AUTUMN的编号[2] - Season2.SUMMER的编号[3]
         */
        System.out.println(Season2.AUTUMN.compareTo(Season2.SUMMER));

        //补充了一个增强for
//        int[] nums = {1, 2, 9};
//        //普通的for循环
//        System.out.println("=====普通的for=====");
//        for (int i = 0; i < nums.length; i++) {
//            System.out.println(nums[i]);
//        }
//        System.out.println("=====增强的for=====");
//        //执行流程是 依次从nums数组中取出数据，赋给i, 如果取出完毕，则退出for
//        for(int i : nums) {
//            System.out.println("i=" + i);
//        }
    }
}
```

## enum 实现接口

1) 使用enum 关键字后，就不能再继承其它类了，因为enum 会隐式继承Enum，而 Java 是**单继承机制**。

2) 枚举类和普通类一样，可以实现接口，如下形式。
   
   ```java
   enum 类名 implements 接口1，接口2{}
   ```
   
   ```java
   package com.hspedu.enum_;
   
   public class EnumDetail {
       public static void main(String[] args) {
           Music.CLASSICMUSIC.playing();
       }
   }
   class A {
   
   }
   
   //1.使用enum关键字后，就不能再继承其它类了，因为enum会隐式继承Enum，而Java是单继承机制
   //enum Season3 extends A {
   //
   //}
   //2.enum实现的枚举类，仍然是一个类，所以还是可以实现接口的.
   interface IPlaying {
       public void playing();
   }
   enum Music implements IPlaying {
       // 枚举类，CLASSICMUSIC相当于一个对象
       CLASSICMUSIC;
       @Override
       public void playing() {
           System.out.println("播放好听的音乐...");
       }
   }
   ```

## 注解的理解

1) 注解(Annotation)也被称为元数据(Metadata)，用于修饰解释包、类、方法、属性、构造器、局部变量等数据信息。
2) 和注释一样，注解不影响程序逻辑，但**注解可以被编译或运行**，相当于嵌入在代码中的补充信息。
3) 在JavaSE 中，注解的使用目的比较简单，例如标记过时的功能，忽略警告等。在JavaEE 中注解占据了更重要的角色，例如用来配置应用程序的任何切面，代替java EE 旧版中所遗留的繁冗代码和XML 配置等。

### 基本的Annotation 介绍

使用Annotation 时要在其前面增加 @ 符号, 并把该Annotation 当成一个修饰符使用。用于修饰它支持的程序元素。

三个基本的Annotation:

1) @Override: 限定某个方法，是重写父类方法, 该注解只能用于方法。
2) @Deprecated: 用于表示某个程序元素(类, 方法等)已过时。
3) @SuppressWarnings: 抑制编译器警告。

## 基本的Annotation 应用案例

### @Override

@Override:限定某个方法，是重写父类方法,该注解只能用于方法。

补充说明: 源码中@interface不是interface接口，是注解类是jdk5.0之后加入的，表示一个注解类。

1.`@ Override` 表示**指定重写父类的方法(从编译层面验证)，如果父类没有fly方法，则会报错。**

2.如果不写@Override注解,而父类仍有public void fly，仍然构成重写。

3.@Override**只能修饰方法**,不能修饰其它类，包，属性等等

4.查看@Override注解源码为@Target(ElementType.METHOD), 说明**只能修饰方法**

5.@Target是修饰注解的注解，称为元注解。

### @Deprecated

@Deprecated: 用于表示某个程序元素(类, 方法等)已过时

1.用于表示某个程序元素(类,方法等)已过时

2.可以修饰方法，类，字段，包，参数等等

3.@Target(value={CONSTRUCTOR, FIELD, LOCAL_VARIABLE, METHOD,
PACKAGE,PARAMETER. TYPE})

4.@Deprecated的作用可以做到新旧版本的兼容和过渡

### @SuppressWarnings

@SuppressWarnings: 抑制编译器警告

1) unchecked是忽略没有检查的警告
2) rawtypes是忽略没有指定泛型的警告(传参时没有指定泛型的警告错误)
3) unused是忽略没有使用某个变量的警告错误
4) @SuppressWarnings可以修饰的程序元素为,查看@Target
5) 生成@SupperssWarnings时，不用背，直接点击左侧的黄色提示，就
   可以选择(注意可以指定生成的位置)

#### 属性介绍以及说明

all，抑制所有警告
boxing，抑制与封装/拆装作业相关的警告
cast，抑制与强制转型作业相关的警告
dep-ann，抑制与淘汰注释相关的警告
deprecation，抑制与淘汰的相关警告
fallthrough，抑制与switch陈述式中遗漏break相关的警告
finally，抑制与未传回finally区块相关的警告
hiding，抑制与隐藏变数的区域变数相关的警告
incomplete-switch，抑制与switch陈述式(enum case)中遗漏项目相关的警告
javadoc，抑制与javadoc相关的警告
nls，抑制与非nls字串文字相关的警告
null，抑制与空值分析相关的警告
rawtypes，抑制与使用raw类型相关的警告
resource，抑制与使用Closeable类型的资源相关的警告
restriction，抑制与使用不建议或禁止参照相关的警告
serial，抑制与可序列化的类别遗漏serialVersionUID栏位相关的警告
static-access，抑制与静态存取不正确相关的警告
static-method，抑制与可能宣告为static的方法相关的警告
super，抑制与置换方法相关但不含super呼叫的警告
synthetic-access，抑制与内部类别的存取未最佳化相关的警告
sync-override，抑制因为置换同步方法而遗漏同步化的警告
unchecked，抑制与未检查的作业相关的警告
unqualified-field-access，抑制与栏位存取不合格相关的警告
unused，抑制与未用的程式码及停用的程式码相关的警告

```java
package com.hspedu.annotation_;

import java.util.ArrayList;
import java.util.List;
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
public class SuppressWarnings_ {
    
    //1. 当我们不希望看到这些警告的时候，可以使用 SuppressWarnings注解来抑制警告信息
    //2. 在{""} 中，可以写入你希望抑制(不显示)警告信息
    //3. 关于SuppressWarnings 作用范围是和你放置的位置相关
    //   比如 @SuppressWarnings放置在 main方法，那么抑制警告的范围就是 main
    //   通常我们可以放置具体的语句, 方法, 类.
    
    //4.  看看 @SuppressWarnings 源码
    //(1) 放置的位置就是 TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE
    //(2) 该注解类有数组 String[] values() 设置一个数组比如 {"rawtypes", "unchecked", "unused"}
    /*
        @Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
            @Retention(RetentionPolicy.SOURCE)
            public @interface SuppressWarnings {

                String[] value();
        }
     */
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("jack");
        list.add("tom");
        list.add("mary");
        int i;
        System.out.println(list.get(1));

    }

    public void f1() {
//        @SuppressWarnings({"rawtypes"})
        List list = new ArrayList();


        list.add("jack");
        list.add("tom");
        list.add("mary");
//        @SuppressWarnings({"unused"})
        int i;
        System.out.println(list.get(1));
    }
}

```

## JDK 的元Annotation(元注解)

JDK 的元Annotation 用于修饰其他 Annotation。

### 元注解的种类

1) Retention //指定注解的作用范围，三种SOURCE,CLASS,RUNTIME
2) Target // 指定注解可以在哪些地方使用
3) Documented //指定该注解是否会在javadoc 体现
4) Inherited //子类会继承父类注解

### @Retention

只能用于修饰一个Annotation 定义, 用于指定该Annotation 可以保留多长时间, @Rentention 包含一个RetentionPolicy类型的成员变量, 使用@Rentention 时必须为该value 成员变量指定值: @Retention 的三种值

1) RetentionPolicy.SOURCE: 编译器使用后，直接丢弃这种策略的注释
2) RetentionPolicy.CLASS: 编译器将把注解记录在class 文件中. 当运行Java 程序时, JVM 不会保留注解。这是默认值
3) RetentionPolicy.RUNTIME:编译器将把注解记录在class 文件中. 当运行Java 程序时, JVM 会保留注解. 程序可以通过反射获取该注解。

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/04/18-13-41-16-1681796473.png)

```java
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE) // 编译器编译时生效，不会写入到class文件中
public @interface Override {
}
```

### @Target

用于修饰 Annotation定义,用于指定被修饰的Annotation能用于修饰哪些程序元素.@Target 也包含一个名为value的成员变量。

```java
@Documented
@Retention(RetentionPolicy.RUNTIME) // 作用范围RUNTIME
@Target(ElementType.ANNOTATION_TYPE) // 只能修饰注解
public @interface Target { // 说明它是注解
    /**
     * Returns an array of the kinds of elements an annotation type
     * can be applied to.
     * @return an array of the kinds of elements an annotation type
     * can be applied to
     */
    ElementType[] value(); // 这里深入源码再看一下ElementType的取值
}
```

```java
public enum ElementType {
    /** Class, interface (including annotation type), or enum declaration */
    TYPE,

    /** Field declaration (includes enum constants) */
    FIELD,

    /** Method declaration */
    METHOD,

    /** Formal parameter declaration */
    PARAMETER,

    /** Constructor declaration */
    CONSTRUCTOR,

    /** Local variable declaration */
    LOCAL_VARIABLE,

    /** Annotation type declaration */
    ANNOTATION_TYPE,

    /** Package declaration */
    PACKAGE,

    /**
     * Type parameter declaration
     *
     * @since 1.8
     */
    TYPE_PARAMETER,

    /**
     * Use of a type
     *
     * @since 1.8
     */
    TYPE_USE
}
```

### @Documented

@Documented:用于指定被该元 Annotation修饰的Annotation类将被javadoc工具提取成文档,即在生成文档时，可以看到该注解。

说明：**定义为 Documented 的注解必须设置 Retention 值为 RUNTIME**。

### @Inherited

被它修饰的Annotation将具有继承性。如果某个类使用了被@Inherited修饰的Annotation,则其子类将自动具有该注解。



