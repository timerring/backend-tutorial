- [第13章 常用类](#第13章-常用类)
  - [包装类](#包装类)
    - [包装类的分类](#包装类的分类)
    - [包装类和基本数据的转换](#包装类和基本数据的转换)
    - [包装类型和String 类型的相互转换](#包装类型和string-类型的相互转换)
    - [Integer 类和Character 类的常用方法](#integer-类和character-类的常用方法)
    - [Integer 类面试题](#integer-类面试题)
  - [String 类](#string-类)
    - [String 类的理解和创建对象](#string-类的理解和创建对象)
    - [创建String 对象的两种方式](#创建string-对象的两种方式)
    - [两种创建String 对象的区别](#两种创建string-对象的区别)
    - [课堂测试题](#课堂测试题)
  - [字符串的特性](#字符串的特性)
    - [说明](#说明)
    - [面试题](#面试题)
  - [String 类的常见方法](#string-类的常见方法)
    - [说明](#说明-1)
    - [String 类的常见方法一览](#string-类的常见方法一览)
  - [StringBuffer 类](#stringbuffer-类)
    - [基本介绍](#基本介绍)
    - [String VS StringBuffer](#string-vs-stringbuffer)
    - [构造器](#构造器)
    - [String 和 StringBuffer 相互转换](#string-和-stringbuffer-相互转换)
    - [StringBuffer 类常见方法](#stringbuffer-类常见方法)
    - [StringBuffer 类测试](#stringbuffer-类测试)
    - [StringBuffer 类练习](#stringbuffer-类练习)
  - [StringBuilder 类](#stringbuilder-类)
    - [基本介绍](#基本介绍-1)
    - [String、StringBuffer 和StringBuilder 的比较](#stringstringbuffer-和stringbuilder-的比较)
    - [String、StringBuffer 和StringBuilder 的效率测试](#stringstringbuffer-和stringbuilder-的效率测试)
    - [String、StringBuffer 和 StringBuilder 的选择](#stringstringbuffer-和-stringbuilder-的选择)
  - [Math 类](#math-类)
    - [基本介绍](#基本介绍-2)
    - [方法一览(均为静态方法)](#方法一览均为静态方法)
    - [Math 类常见方法应用案例](#math-类常见方法应用案例)
  - [Arrays 类](#arrays-类)
    - [Arrays 类常见方法应用案例](#arrays-类常见方法应用案例)
  - [System 类](#system-类)
    - [System 类常见方法和案例](#system-类常见方法和案例)
  - [BigInteger 和BigDecimal 类](#biginteger-和bigdecimal-类)
    - [介绍](#介绍)
    - [BigInteger 和 BigDecimal 常见方法](#biginteger-和-bigdecimal-常见方法)
  - [日期类](#日期类)
    - [第一代日期类](#第一代日期类)
    - [第二代日期类](#第二代日期类)
    - [第三代日期类](#第三代日期类)
    - [DateTimeFormatter 格式日期类](#datetimeformatter-格式日期类)
    - [Instant 时间戳](#instant-时间戳)
    - [第三代日期类更多方法](#第三代日期类更多方法)
  - [本章作业](#本章作业)


# 第13章 常用类

## 包装类

### 包装类的分类

1) 针对八种基本数据类型相应的引用类型—包装类
2) 有了类的特点，就可以调用类中的方法。

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230420100846908.png)

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230420100901757.png)

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230420100923345.png)

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230420100945170.png)

### 包装类和基本数据的转换

演示包装类和基本数据类型的相互转换,这里以int和 Integer演示。

1) jdk5前的手动装箱和拆箱方式，装箱：**基本类型->包装类型**。反之拆箱。
2) jdk5以后(含jdk5)的自动装箱和拆箱方式。
3) 自动装箱底层调用的是valueOf方法，比如Integer.valueOf04)其它包装类的用法类似,不一一举例

```java
package com.hspedu.wrapper;

public class Integer01 {
    public static void main(String[] args) {
        //演示int <--> Integer 的装箱和拆箱
        //jdk5前是手动装箱和拆箱
        //手动装箱 int->Integer
        int n1 = 100;
        Integer integer = new Integer(n1);
        Integer integer1 = Integer.valueOf(n1);

        //手动拆箱
        //Integer -> int
        int i = integer.intValue();

        //jdk5后，就可以自动装箱和自动拆箱
        int n2 = 200;
        //自动装箱 int->Integer
        Integer integer2 = n2; //底层使用的是 Integer.valueOf(n2)
        //自动拆箱 Integer->int
        int n3 = integer2; //底层仍然使用的是 intValue()方法
    }
}
```

### 包装类型和String 类型的相互转换

```java
package com.hspedu.wrapper;

public class WrapperVSString {
    public static void main(String[] args) {
        //包装类(Integer)->String
        Integer i = 100;//自动装箱
        //方式1
        String str1 = i + "";
        //方式2
        String str2 = i.toString();
        //方式3
        String str3 = String.valueOf(i);

        //String -> 包装类(Integer)
        String str4 = "12345";
        Integer i2 = Integer.parseInt(str4);//使用到自动装箱
        Integer i3 = new Integer(str4);//构造器

        System.out.println("ok~~");

    }
}
```

### Integer 类和Character 类的常用方法

可以通过图查询到其含有的字段和方法，jump to source 可以查看到源码。

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230420102939244.png)

```java
package com.hspedu.wrapper;

public class WrapperMethod {
    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE); //返回最小值
        System.out.println(Integer.MAX_VALUE);//返回最大值

        System.out.println(Character.isDigit('a'));//判断是不是数字
        System.out.println(Character.isLetter('a'));//判断是不是字母
        System.out.println(Character.isUpperCase('a'));//判断是不是大写
        System.out.println(Character.isLowerCase('a'));//判断是不是小写

        System.out.println(Character.isWhitespace('a'));//判断是不是空格
        System.out.println(Character.toUpperCase('a'));//转成大写
        System.out.println(Character.toLowerCase('A'));//转成小写

    }
}

```

### Integer 类面试题

看看下面代码，输出什么结果? 为什么?

```java
package com.hspedu.wrapper;

public class WrapperExercise02 {
    public static void main(String[] args) {
        Integer i = new Integer(1);
        Integer j = new Integer(1);
        System.out.println(i == j);  //False
        //所以，这里主要是看范围 -128 ~ 127 就是直接返回
        /*
        //1. 如果i 在 IntegerCache.low(-128)~IntegerCache.high(127),就直接从缓存数组返回
        //2. 如果不在 -128~127,就直接 new Integer(i)
         public static Integer valueOf(int i) {
            if (i >= IntegerCache.low && i <= IntegerCache.high)
                return IntegerCache.cache[i + (-IntegerCache.low)];
            return new Integer(i);
        }
         */
        Integer m = 1; //底层 Integer.valueOf(1); -> 阅读源码
        Integer n = 1;//底层 Integer.valueOf(1);
        System.out.println(m == n); //T
        //所以，这里主要是看范围 -128 ~ 127 就是直接返回
        //，否则，就new Integer(xx);
        Integer x = 128;//底层Integer.valueOf(1);
        Integer y = 128;//底层Integer.valueOf(1);
        System.out.println(x == y);//False

        Integer i11=127;
        int i12=127;
        //只要有基本数据类型，判断的是
        //值是否相同
        System.out.println(i11==i12); //T

        Integer i13=128;
        int i14=128;
        System.out.println(i13==i14);//T
    }
}
```

## String 类

### String 类的理解和创建对象

1) String对象用于保存字符串,也就是一组字符序列

2) 字符串常量对象是用双引号括起的字符序列。例如:"你好"、"12.97"、"boy"等

3) 字符串的字符使用Unicode字符编码，一个字符(不区分字母还是汉字)占两个字节

4) String类较常用构造器(其它看手册);

   String s1 =new String();

   String s2 = new String(String original);

   String s3 = new String(char[] a);

   String s4 = new String(char[] a, int startIndex, int count)

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230420104424574.png)

实现Serializable，说明可以串行化，即可以在网络上传输。

实现接口Comparable  [String 对象可以比较大小]

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230420104918527.png)

```java
package com.hspedu.string_;

import java.io.Serializable;

public class String01 {
    public static void main(String[] args) {
//         1.String 对象用于保存字符串，也就是一组字符序列
//         2. "jack" 字符串常量, 双引号括起的字符序列
//         3. 字符串的字符使用Unicode字符编码，一个字符(不区分字母还是汉字)占两个字节
//         4. String 类有很多构造器，构造器的重载
//           常用的有 String  s1 = new String(); //
//                      String  s2 = new String(String original);
//                      String  s3 = new String(char[] a);
//                      String  s4 =  new String(char[] a,int startIndex,int count)
//                      String  s5 = new String(byte[] b)
//        5. String 类实现了接口 Serializable【String 可以串行化:可以在网络传输】
//                         接口 Comparable [String 对象可以比较大小]
//        6. String 是 final 类，不能被其他的类继承
//        7. String 有属性 private final char value[]; 用于存放字符串内容, 说明其本质还是char数组。
//        8. 一定要注意：value 是一个final类型，不可以修改(地址不能修改)：即value不能指向新的地址，但是单个字符内容是可以变化

        String name = "jack";
        name = "tom";
        final char[] value = {'a','b','c'};
        char[] v2 = {'t','o','m'};
        value[0] = 'H';
        //value = v2; 不可以修改 value地址
        System.out.println(name); //Tom
    }
}

```

### 创建String 对象的两种方式

1) 方式一: 直接赋值String s = "hspedu";
2) 方式二: 调用构造器 String s = new String("hspedu");

### 两种创建String 对象的区别

1. 方式一:先从常量池查看是否有"hsp”数据空间,如果有，直接指向;如果
   没有则重新创建,然后指向。**s最终指向的是常量池的空间地址**。

2. 方式二:先在堆中创建空间，里面维护了value属性，指向常量池的hsp空间。

   如果常量池没有"hsp"，重新创建，如果有，直接通过value指向。最终指向的是堆中的空间地址。

3. 画出两种方式的内存分布图

   ![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230420110053585.png)

### 课堂测试题

```java
package com.hspedu.string_;

public class StringExercise01 {
    public static void main(String[] args) {
        String a = "abc";
        String b ="abc";
        // equals在string中被重写，逐个比较，相同
        System.out.println(a.equals(b));//T
        System.out.println(a==b); //T
		// 这里指向的是同一个地址，故 == 也相同
    }
}
```

```java
package com.hspedu.string_;

public class StringExercise03 {
    public static void main(String[] args) {
        String a = "hsp"; //a 指向 常量池的 “hsp”
        String b =new String("hsp");//b 指向堆中对象
        System.out.println(a.equals(b)); //T
        System.out.println(a==b); //F
        //b.intern() 方法返回常量池地址
        System.out.println(a==b.intern()); //T intern方法查看API
        System.out.println(b==b.intern()); //F
        // b 指向的是堆地址，b.intern 返回的是常量池地址
    }
}
```

当调用intern方法时，如果池已经包含一个等于此 String对象的字符串(用equals(Object)方法确定)，则返回池中的字符串。否则，将此String 对象添加到池中，并返回此 String对象的引用

b.intern方法**最终返回的是常量池的地址(对象)**

## 字符串的特性

### 说明

1) String是一个final类，代表不可变的字符序列
2) 字符串是不可变的。一个字符串对象一旦被分配，其内容是不可变的.

例：以下语句创建了几个对象?

```java
String s1 = "hello";
s1 = "haha"; //创建了2个对象，从指向hello变为了指向haha（而不是修改hello为haha）
```

### 面试题

1)题1

```java
String a ="hello" +"abc";
```

创建了几个对象?只有1个对象
String a = "hello"+"abc"; ==> 优化等价 String a = "helloabc";

分析：编译器不傻，做一个优化，判断创建的常量池对象，是否有引用指向。

2)题2 

```java
String a ="hello";//创建a对象
String b ="abc";//创建b对象
String c = a + b;
```

创建了几个对象?画出内存图? 一共有3对象,如图。

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230420145913656.png)

底层是StringBuilder sb = new StringBuilder(); sb.append(a); sb.append(b); sb是在堆中，并且append是在原来字符串的基础上追加的。

重要规则：String c1 = "ab" + "cd";常量相加，看的是池。String c1 = a+b;变量相加,是在堆中

**综合练习**

```java
package com.hspedu.string_;

public class StringExercise10 {
    public static void main(String[] args) {

    }
}

class Test1 {
    String str = new String("hsp");
    final char[] ch = {'j', 'a', 'v', 'a'};

    public void change(String str, char ch[]) {
        str = "java";
        ch[0] = 'h';
    }

    public static void main(String[] args) {
        Test1 ex = new Test1();
        ex.change(ex.str, ex.ch);
        System.out.print(ex.str + " and ");
        System.out.println(ex.ch);
    }
}
```

数组默认情况下是在堆中的，

每次调方法都会产生对应的新栈，过程如下所示：

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230420151016848.png)

## String 类的常见方法

### 说明

String类是保存字符串常量的。每次更新都需要重新开辟空间，效率较低,因此java设计者还提供了`StringBuilder` 和 `StringBuffer`来增强String的功能,并提高效率。

### String 类的常见方法一览

+ equals //区分大小写，判断内容是否相等
+ equalsIgnoreCase //忽略大小写的判断内容是否相等length/获取字符的个数,字符串的长度
+ length 获取字符的个数，字符串的长度
+ indexOf //获取字符在字符串中第1次出现的索引索引从0开始,如果找不到,返回-1
+ lastIndexOf //获取字符在字符串中最后1次出现的索引,索引从0开始,如找不到,返回-1
+ substring //截取指定范围的子串
+ trim //去前后空格
+ charAt // 获取某索引处的字符, 注意不能使用Str[index]这种方式.

```java
package com.hspedu.string_;

public class StringMethod01 {
    public static void main(String[] args) {
        // 1. equals 前面已经讲过了. 比较内容是否相同，区分大小写
        String str1 = "hello";
        String str2 = "Hello";
        System.out.println(str1.equals(str2));//

        // 2.equalsIgnoreCase 忽略大小写的判断内容是否相等
        String username = "johN";
        if ("john".equalsIgnoreCase(username)) {
            System.out.println("Success!");
        } else {
            System.out.println("Failure!");
        }
        // 3.length 获取字符的个数，字符串的长度
        System.out.println("韩顺平".length());
        // 4.indexOf 获取字符在字符串对象中第一次出现的索引，索引从0开始，如果找不到，返回-1
        String s1 = "wer@terwe@g";
        int index = s1.indexOf('@');
        System.out.println(index);// 3
        System.out.println("weIndex=" + s1.indexOf("we"));//0
        // 5.lastIndexOf 获取字符在字符串中最后一次出现的索引，索引从0开始，如果找不到，返回-1
        s1 = "wer@terwe@g@";
        index = s1.lastIndexOf('@');
        System.out.println(index);//11
        System.out.println("ter的位置=" + s1.lastIndexOf("ter"));//4
        // 6.substring 截取指定范围的子串
        String name = "hello,张三";
        // 下面name.substring(6) 从索引6开始截取后面所有的内容
        System.out.println(name.substring(6));//截取后面的字符
        // name.substring(0,5)表示从索引0开始截取，截取到索引5 - 1 = 4位置
        System.out.println(name.substring(2,5));//llo
    }
}
```

+ toUpperCase

+ toLowerCase

+ concat

+ replace 替换字符串中的字符

+ split 分割字符串,对于某些分割字符，我们需要转义比如| \\\等

  案例: String poem="锄禾日当午,汗滴未下土,谁知盘中餐,粒粒皆辛苦";和文件路径.

+ compareTo //比较两个字符串的大小

+ toCharArray //转换成字符数组

+ format //格式字符串,%s字符串%c字符%d整型%.2f 浮点型案例，将一个人的信息格式化输出.

```java
package com.hspedu.string_;

public class StringMethod02 {
    public static void main(String[] args) {
        // 1.toUpperCase转换成大写
        String s = "heLLo";
        System.out.println(s.toUpperCase());//HELLO
        // 2.toLowerCase
        System.out.println(s.toLowerCase());//hello
        // 3.concat拼接字符串
        String s1 = "宝玉";
        s1 = s1.concat("林黛玉").concat("薛宝钗").concat("together");
        System.out.println(s1);//宝玉林黛玉薛宝钗together
        // 4.replace 替换字符串中的字符
        s1 = "宝玉 and 林黛玉 林黛玉 林黛玉";
        //在s1中，将 所有的 林黛玉 替换成薛宝钗
        // 老韩解读: s1.replace() 方法执行后，返回的结果才是替换过的.
        // 注意对 s1没有任何影响
        String s11 = s1.replace("宝玉", "jack");
        System.out.println(s1);//宝玉 and 林黛玉 林黛玉 林黛玉
        System.out.println(s11);//jack and 林黛玉 林黛玉 林黛玉
        // 5.split 分割字符串, 对于某些分割字符，我们需要 转义比如 | \\等
        String poem = "锄禾日当午,汗滴禾下土,谁知盘中餐,粒粒皆辛苦";
        // 1. 以 , 为标准对 poem 进行分割 , 返回一个数组
        // 2. 在对字符串进行分割时，如果有特殊字符，需要加入 转义符 \
        String[] split = poem.split(",");
        poem = "E:\\aaa\\bbb";
        split = poem.split("\\\\");
        System.out.println("==分割后内容===");
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
        }
        // 6.toCharArray 转换成字符数组
        s = "happy";
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            System.out.println(chs[i]);
        }
        // 7.compareTo 比较两个字符串的大小，如果前者大，
        // 则返回正数，后者大，则返回负数，如果相等，返回0
        // (1) 如果长度相同，并且每个字符也相同，就返回 0
        // (2) 如果长度相同或者不相同，但是在进行比较时，可以区分大小
        //     就返回 if (c1 != c2) {
        //                return c1 - c2;
        //            }
        // (3) 如果前面的部分都相同，就返回 str1.len - str2.len
        String a = "jcck";// len = 3
        String b = "jack";// len = 4
        System.out.println(a.compareTo(b)); // 返回值是 'c' - 'a' = 2的值
        // 8.format 格式字符串
        /* 占位符有:
         * %s 字符串 %c 字符 %d 整型 %.2f 浮点型
         */
        String name = "john";
        int age = 10;
        double score = 56.857;
        char gender = '男';
        //将所有的信息都拼接在一个字符串.
        String info =
                "我的姓名是" + name + "年龄是" + age + ",成绩是" + score + "性别是" + gender + "。希望大家喜欢我！";

        System.out.println(info);


        // 1. %s , %d , %.2f %c 称为占位符
        // 2. 这些占位符由后面变量来替换
        // 3. %s 表示后面由 字符串来替换
        // 4. %d 是整数来替换
        // 5. %.2f 表示使用小数来替换，替换后，只会保留小数点两位, 并且进行四舍五入的处理
        // 6. %c 使用char 类型来替换
        String formatStr = "我的姓名是%s 年龄是%d，成绩是%.2f 性别是%c.希望大家喜欢我！";

        String info2 = String.format(formatStr, name, age, score, gender);
        System.out.println("info2=" + info2);
    }
}
```

## StringBuffer 类

### 基本介绍

java.lang.StringBuffer代表可变的字符序列，可以对字符串内容进行增删.

很多方法与String相同，但StringBuffer是可变长度的。

StringBuffer是一个容器。

1. StringBuffer 的直接父类 是 AbstractStringBuilder
2. StringBuffer 实现了 Serializable, 即StringBuffer的对象可以串行化
3. 在父类中  AbstractStringBuilder 有属性 char[] value,不是final，该 value 数组存放 字符串内容，因此存放在堆中的。
4. StringBuffer 是一个 final类，不能被继承
5. **因为StringBuffer 字符内容是存在 char[] value, 所有在变化(增加/删除)不用每次都更换地址(即不是每次创建新对象)， 所以效率高于 String**。

### String VS StringBuffer

1. String保存的是字符串常量。里面的值不能更改，每次String类的更新实际上就是更改地址，效率较低 

   private final char value[];

2. StringBuffer保存的是字符串变量，里面的值可以更改，每次StringBuffer的更新实际上可以更新内容，不用每次更新地址（空间大小不够的时候才会进行扩展），效率较高。

  char[] value; 这个放在堆。

### 构造器

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230420155253011.png)

```java
package com.hspedu.stringbuffer_;

public class StringBuffer02 {
    public static void main(String[] args) {

        //构造器的使用
        //1. 创建一个 大小为 16的 char[] ,用于存放字符内容
        StringBuffer stringBuffer = new StringBuffer();

        //2 通过构造器指定 char[] 大小
        StringBuffer stringBuffer1 = new StringBuffer(100);
        //3. 通过 给一个String 创建 StringBuffer, char[] 大小就是 str.length() + 16

        StringBuffer hello = new StringBuffer("hello");
    }
}
```

### String 和 StringBuffer 相互转换

String ——> StringBuffer

+ 使用构造器
+ 使用的是 append 方法

StringBuffer ——> String

+ 使用 StringBuffer 提供的 toString 方法
+ 使用构造器来搞定

```java
package com.hspedu.stringbuffer_;

public class StringAndStringBuffer {
    public static void main(String[] args) {

        // String——>StringBuffer
        String str = "hello tom";
        //方式1 使用构造器
        //注意：返回的才是StringBuffer对象，对 str 本身没有影响
        StringBuffer stringBuffer = new StringBuffer(str);
        //方式2：使用的是append方法
        StringBuffer stringBuffer1 = new StringBuffer();
        stringBuffer1 = stringBuffer1.append(str);

        // StringBuffer ->String
        StringBuffer stringBuffer3 = new StringBuffer("timerring");
        //方式1：使用StringBuffer提供的 toString方法
        String s = stringBuffer3.toString();
        //方式2：使用构造器来搞定
        String s1 = new String(stringBuffer3);
    }
}
```

### StringBuffer 类常见方法

+ append
+ delete 删除索引为>=start && <end 处的字符
+ replace
+ insert 在索引为index的位置插入 ,原来索引为index的内容自动后移

+ length() 长度

```java
package com.hspedu.stringbuffer_;

public class StringBufferMethod {
    public static void main(String[] args) {

        StringBuffer s = new StringBuffer("hello");
        //增
        s.append(',');// "hello,"
        s.append("张三丰");//"hello,张三丰"
        s.append("赵敏").append(100).append(true).append(10.5);//"hello,张三丰赵敏100true10.5"
        System.out.println(s);//"hello,张三丰赵敏100true10.5"

        // 删
        /*
         * 删除索引为>=start && <end 处的字符
         * 解读: 删除 11~14的字符 [11, 14)
         */
        s.delete(11, 14);
        System.out.println(s);//"hello,张三丰赵敏true10.5"
        // 改
        // 使用 周芷若 替换 索引9-11的字符 [9,11)
        s.replace(9, 11, "周芷若");
        System.out.println(s);//"hello,张三丰周芷若true10.5"
        // 查找指定的子串在字符串第一次出现的索引，如果找不到返回-1
        int indexOf = s.indexOf("张三丰");
        System.out.println(indexOf);//6
        // 插
        // 在索引为9的位置插入 "赵敏",原来索引为9的内容自动后移
        s.insert(9, "赵敏");
        System.out.println(s);// "hello,张三丰赵敏周芷若true10.5"
        //长度
        System.out.println(s.length());//22
        System.out.println(s);
    }
}
```

### StringBuffer 类测试

```java
package com.hspedu.stringbuffer_;
// 分析以下代码
public class StringBufferExercise01 {
    public static void main(String[] args) {
        String str = null;// ok
        StringBuffer sb = new StringBuffer(); //ok
        sb.append(str);// 需要看源码 , 底层调用的是 AbstractStringBuilder 的 appendNull, 转为了一个字符数组。
        System.out.println(sb.length());// 4

        System.out.println(sb);// null 是一个字符数组
        //下面的构造器，会抛出 NullpointerException
        StringBuffer sb1 = new StringBuffer(str);// 看底层源码 super(str.length() + 16); 会抛出空指针异常
        System.out.println(sb1);
    }
}
```

### StringBuffer 类练习

```java
package com.hspedu.stringbuffer_;

import java.util.Scanner;

public class StringBufferExercise02 {
    public static void main(String[] args) {
        /*
        输入商品名称和商品价格，要求打印效果示例, 使用前面学习的方法完成：
        商品名	商品价格
        手机	123,564.59  //比如 价格 3,456,789.88
        要求：价格的小数点前面每三位用逗号隔开, 在输出。
        思路分析
        1. 定义一个Scanner 对象，接收用户输入的 价格(String)
        2. 希望使用到 StringBuffer的 insert ，需要将 String 转成 StringBuffer
        3. 然后使用相关方法进行字符串的处理
         */

        //new Scanner(System.in)
        String price = "8123564.59";
        StringBuffer sb = new StringBuffer(price);
        // 先完成一个最简单的实现123,564.59
        // 找到小数点的索引，然后在该位置的前3位，插入,即可
		//  int i = sb.lastIndexOf(".");
		//  sb = sb.insert(i - 3, ",");

        //上面的两步需要做一个循环处理,才是正确的
        for (int i = sb.lastIndexOf(".") - 3; i > 0; i -= 3) {
            sb = sb.insert(i, ",");
        }
        System.out.println(sb);//8,123,564.59
    }
}
```

## StringBuilder 类

### 基本介绍

1) 一个可变的字符序列。此类提供一个**与 StringBuffer兼容的API**，但不保证同步(StringBuilder不是线程安全)。该类被设计用作 StringBuffer的一个简易替换，用在字符串缓冲区被单个线程使用的时候。如果可能，建议优先采用该类。因为**在大多数实现中，它比 StringBuffer 要快**。
2) 在 StringBuilder上的主要操作是append 和 insert方法，可重载这些方法,
   以接受任意类型的数据。

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230420204712606.png)

1. StringBuilder 继承 AbstractStringBuilder 类
2. 实现了 Serializable ,说明StringBuilder对象是可以串行化(对象可以网络传输,可以保存到文件)
3. StringBuilder 是final类, 不能被继承
4. StringBuilder 对象字符序列仍然是存放在其父类 AbstractStringBuilder的 char[] value;因此，字符序列是堆中
5. StringBuilder 的方法，没有做互斥的处理，即没有synchronized 关键字,因此在单线程的情况下使用 StringBuilder

### String、StringBuffer 和StringBuilder 的比较

StringBuilder 和 StringBuffer 均代表可变的字符序列，方法是一样的，所以使用和StringBuffer一样。

1) StringBuilder和 StringBuffer非常类似，均代表可变的字符序列，而且方法也一样
2) String:不可变字符序列,效率低,但是复用率高（地址都指向它）。
3) StringBuffer:可变字符序列、效率较高(增删)、线程安全,看源码
3) StringBuilder:可变字符序列、效率最高、线程不安全
5) String使用注意说明:
string s="a";//创建了一个字符串
s +="b";//实际上原来的"a"字符串对象已经丢弃了，现在又产生了一个字符串s+"b”(也就是"ab")。如果多次执行这些改变串内容的操作，会导致大量副本字符串对象存留在内存中，降低效率。如果这样的操作放到循环中，会极大,影响程序的性能=>

**结论:如果我们对String做大量修改,不要使用String**

### String、StringBuffer 和StringBuilder 的效率测试

StringVsStringBufferVsStringBuilder.java 效率： StringBuilder > StringBuffer > String

```java
package com.hspedu.stringbuilder_;

public class StringVsStringBufferVsStringBuilder {
    public static void main(String[] args) {

        long startTime = 0L;
        long endTime = 0L;
        StringBuffer buffer = new StringBuffer("");

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 80000; i++) {//StringBuffer 拼接 20000次
            buffer.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer的执行时间：" + (endTime - startTime)); // 20

        StringBuilder builder = new StringBuilder("");
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 80000; i++) {//StringBuilder 拼接 20000次
            builder.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder的执行时间：" + (endTime - startTime)); // 11


        String text = "";
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 80000; i++) {//String 拼接 20000
            text = text + i;
        }
        endTime = System.currentTimeMillis();
        System.out.println("String的执行时间：" + (endTime - startTime)); // 5428

    }
}
```

### String、StringBuffer 和 StringBuilder 的选择

使用的原则,结论:

1. 如果字符串存在大量的修改操作，一般使用StringBuffer 或StringBuilder
2. 如果字符串存在大量的修改操作，并在单线程的情况, 使用 StringBuilder
3. 如果字符串存在大量的修改操作，并在多线程的情况，使用 StringBuffer
4. 如果我们字符串很少修改。被多个对象引用，使用String, 比如配置信息等

## Math 类

### 基本介绍

Math 类包含用于执行基本数学运算的方法，如初等指数、对数、平方根和三角函数。

### 方法一览(均为静态方法)

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230420210433318.png)

### Math 类常见方法应用案例

```java
package com.hspedu.math_;

public class MathMethod {
    public static void main(String[] args) {
        //看看Math常用的方法(静态方法)
        //1.abs 绝对值
        int abs = Math.abs(-9);
        System.out.println(abs);//9
        //2.pow 求幂
        double pow = Math.pow(2, 4);//2的4次方
        System.out.println(pow);//16
        //3.ceil 向上取整,返回>=该参数的最小整数(转成double);
        double ceil = Math.ceil(3.9);
        System.out.println(ceil);//4.0
        //4.floor 向下取整，返回<=该参数的最大整数(转成double)
        double floor = Math.floor(4.001);
        System.out.println(floor);//4.0
        //5.round 四舍五入  Math.floor(该参数+0.5)
        long round = Math.round(5.51);
        System.out.println(round); //6
        //6.sqrt 求开方
        double sqrt = Math.sqrt(9.0); // 当然，如果复数开方的话则NaN
        System.out.println(sqrt); //3.0

        //7.random 求随机数
        //  random 返回的是 0 <= x < 1 之间的一个随机小数
        // 思考：请写出获取 a-b之间的一个随机整数,a,b均为整数，比如 a = 2, b=7，即返回一个数 x  2 <= x <= 7
        // Math.random() * (b-a) 返回的就是 0  <= 数 <= b-a
        // (1) (int)(a) <= x <= (int)(a + Math.random() * (b-a +1) )
        // (2) 使用具体的数给小伙伴介绍 a = 2  b = 7
        //  (int)(a + Math.random() * (b-a +1)) = (int)( 2 + Math.random() * 6)
        //  2 + Math.random()*6 返回的就是 2<= x < 8 小数
        //  (int)(2 + Math.random()*6) = 2 <= x <= 7
        // (3) 公式就是  (int)(a + Math.random() * (b-a +1) )
        for(int i = 0; i < 100; i++) {
            System.out.println((int)(2 +  Math.random() * (7 - 2 + 1)));
        }

        //max , min 返回最大值和最小值
        int min = Math.min(1, 9);
        int max = Math.max(45, 90);
        System.out.println("min=" + min);
        System.out.println("max=" + max);

    }
}
```

## Arrays 类

### Arrays 类常见方法应用案例

Arrays里面包含了一系列静态方法，用于管理或操作数组(比如排序和搜索)。

1. toString返回数组的字符串形式 Arrays.toString(arr)

2. sort 排序(自然排序和定制排序) Integer arr[] = {1,-1,7,0,89}

  ```java
  package com.hspedu.arrays_;
  import java.util.Arrays;
  import java.util.Comparator;
  
  public class ArraysMethod01 {
      public static void main(String[] args) {
  
          Integer[] integers = {1, 20, 90};
          //遍历数组
  //        for(int i = 0; i < integers.length; i++) {
  //            System.out.println(integers[i]);
  //        }
          //直接使用Arrays.toString方法，显示数组
  //        System.out.println(Arrays.toString(integers));//
  
          //演示 sort方法的使用
  
          Integer arr[] = {1, -1, 7, 0, 89};
          //进行排序
          //老韩解读
          //1. 可以直接使用冒泡排序 , 也可以直接使用Arrays提供的sort方法排序
          //2. 因为数组是引用类型，所以通过sort排序后，会直接影响到 实参 arr
          //3. sort重载的，也可以通过传入一个接口 Comparator 实现定制排序
          //4. 调用 定制排序 时，传入两个参数 (1) 排序的数组 arr
          //   (2) 实现了Comparator接口的匿名内部类 , 要求实现  compare方法
          //5. 先演示效果，再解释
          //6. 这里体现了接口编程的方式 , 看看源码，就明白
          //   源码分析
          //(1) Arrays.sort(arr, new Comparator()
          //(2) 最终到 TimSort类的 private static <T> void binarySort(T[] a, int lo, int hi, int start,
          //                                       Comparator<? super T> c)()
          //(3) 执行到 binarySort方法的代码, 会根据动态绑定机制 c.compare()执行我们传入的
          //    匿名内部类的 compare ()
          //     while (left < right) {
          //                int mid = (left + right) >>> 1;
          //                if (c.compare(pivot, a[mid]) < 0)
          //                    right = mid;
          //                else
          //                    left = mid + 1;
          //            }
          //(4) new Comparator() {
          //            @Override
          //            public int compare(Object o1, Object o2) {
          //                Integer i1 = (Integer) o1;
          //                Integer i2 = (Integer) o2;
          //                return i2 - i1;
          //            }
          //        }
          //(5) public int compare(Object o1, Object o2) 返回的值>0 还是 <0
          //    会影响整个排序结果, 这就充分体现了 接口编程+动态绑定+匿名内部类的综合使用
          //    将来的底层框架和源码的使用方式，会非常常见
          //Arrays.sort(arr); // 默认排序方法
          //定制排序
          Arrays.sort(arr, new Comparator() {
              @Override
              public int compare(Object o1, Object o2) {
                  Integer i1 = (Integer) o1;
                  Integer i2 = (Integer) o2;
                  return i2 - i1;
              }
          });
          System.out.println("===排序后===");
          System.out.println(Arrays.toString(arr));//
  
  
  
      }
  }
  ```

  自定义实现排序顺序：

  ```java
  package com.hspedu.arrays_;
  
  import java.util.Arrays;
  import java.util.Comparator;
  
  public class ArraysSortCustom {
      public static void main(String[] args) {
  
          int[] arr = {1, -1, 8, 0, 20};
          //bubble01(arr);
  
          bubble02(arr, new Comparator() {
              @Override
              public int compare(Object o1, Object o2) {
                  int i1 = (Integer) o1;
                  int i2 = (Integer) o2;
                  return i2 - i1;// return i2 - i1;
              }
          });
  
          System.out.println("==定制排序后的情况==");
          System.out.println(Arrays.toString(arr));
  
      }
  
      //使用冒泡完成排序
      public static void bubble01(int[] arr) {
          int temp = 0;
          for (int i = 0; i < arr.length - 1; i++) {
              for (int j = 0; j < arr.length - 1 - i; j++) {
                  //从小到大
                  if (arr[j] > arr[j + 1]) {
                      temp = arr[j];
                      arr[j] = arr[j + 1];
                      arr[j + 1] = temp;
                  }
              }
          }
      }
  
      //结合冒泡 + 定制
      public static void bubble02(int[] arr, Comparator c) {
          int temp = 0;
          for (int i = 0; i < arr.length - 1; i++) {
              for (int j = 0; j < arr.length - 1 - i; j++) {
                  //数组排序由 c.compare(arr[j], arr[j + 1])返回的值决定
                  if (c.compare(arr[j], arr[j + 1]) > 0) {
                      temp = arr[j];
                      arr[j] = arr[j + 1];
                      arr[j + 1] = temp;
                  }
              }
          }
      }
  }
  ```

3. binarySearch通过二分搜索法进行查找，要求必须排好序。

4) copyOf 数组元素的复制

4) fill 数组元素的填充

4) equals比较两个数组元素内容是否完全一致

7. asList将一组值，转换成list

```java
package com.hspedu.arrays_;

import java.util.Arrays;
import java.util.List;

public class ArraysMethod02 {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 90, 123, 567};
        // binarySearch 通过二分搜索法进行查找，要求必须排好
        // 1. 使用 binarySearch 二叉查找
        // 2. 要求该数组是有序的. 如果该数组是无序的，不能使用binarySearch
        // 3. 如果数组中不存在该元素，就返回 return -(low + 1);  // key not found.
        int index = Arrays.binarySearch(arr, 567);
        System.out.println("index=" + index);

        // copyOf 数组元素的复制
        // 1. 从 arr 数组中，拷贝 arr.length 个元素到 newArr数组中
        // 2. 如果拷贝的长度 > arr.length 就在新数组的后面 增加 null
        // 3. 如果拷贝长度 < 0 就抛出异常 NegativeArraySizeException
        // 4. 该方法的底层使用的是 System.arraycopy()
        Integer[] newArr = Arrays.copyOf(arr, arr.length);
        System.out.println("==拷贝执行完毕后==");
        System.out.println(Arrays.toString(newArr));

        // fill 数组元素的填充
        Integer[] num = new Integer[]{9,3,2};
        // 1. 使用 99 去填充 num数组，可以理解成是全部替换原理的元素
        Arrays.fill(num, 99);
        System.out.println("==num数组填充后==");
        System.out.println(Arrays.toString(num));

        // equals 比较两个数组元素内容是否完全一致
        Integer[] arr2 = {1, 2, 90, 123};
        // 1. 如果arr 和 arr2 数组的元素一样，则方法true;
        // 2. 如果不是完全一样，就返回 false
        boolean equals = Arrays.equals(arr, arr2);
        System.out.println("equals=" + equals);

        // asList 将一组值，转换成list
        // 1. asList方法，会将 (2,3,4,5,6,1)数据转成一个List集合
        // 2. 返回的 asList 编译类型 List(接口)
        // 3. asList 运行类型 java.util.Arrays#ArrayList, 是Arrays类的
        //   静态内部类 private static class ArrayList<E> extends AbstractList<E>
        //  implements RandomAccess, java.io.Serializable
        List asList = Arrays.asList(2,3,4,5,6,1);
        System.out.println("asList=" + asList);
        System.out.println("asList的运行类型" + asList.getClass());
    }
}
```

## System 类

### System 类常见方法和案例

1) exit 退出当前程序，0 表示一个状态 , 正常的状态。
2) arraycopy :复制数组元素，比较适合底层调用，一般使用Arrays.copyOf完成复制数组。

3) currentTimeMillens: 返回当前时间距离1970-1-1的毫秒数。
3) gc:运行垃圾回收机制 System.gc();。

```java
package com.hspedu.system_;

import java.util.Arrays;

public class System_ {
    public static void main(String[] args) {

//        System.out.println("ok1");
//        //1. exit(0) 表示程序退出
//        //2. 0 表示一个状态 , 正常的状态
//        System.exit(0);//
//        System.out.println("ok2");

        //arraycopy ：复制数组元素，比较适合底层调用，
        // 一般使用Arrays.copyOf完成复制数组

        int[] src={1,2,3};
        int[] dest = new int[3];// dest 当前是 {0,0,0}

        //1. 主要是搞清楚这五个参数的含义
        //2.
        //     源数组
        //     * @param      src      the source array.
        //     srcPos： 从源数组的哪个索引位置开始拷贝
        //     * @param      srcPos   starting position in the source array.
        //     dest : 目标数组，即把源数组的数据拷贝到哪个数组
        //     * @param      dest     the destination array.
        //     destPos: 把源数组的数据拷贝到 目标数组的哪个索引
        //     * @param      destPos  starting position in the destination data.
        //     length: 从源数组拷贝多少个数据到目标数组
        //     * @param      length   the number of array elements to be copied.
        System.arraycopy(src, 0, dest, 0, src.length);
        // int[] src={1,2,3};
        System.out.println("dest=" + Arrays.toString(dest));//[1, 2, 3]

        //currentTimeMillens:返回当前时间距离1970-1-1 的毫秒数
        System.out.println(System.currentTimeMillis());


    }
}
```

## BigInteger 和BigDecimal 类

### 介绍

应用场景:
1) Biglnteger 适合保存比较大的整型
2) BigDecimal 适合保存精度更高的浮点型(小数)

### BigInteger 和 BigDecimal 常见方法

在对 `BigInteger` 进行加减乘除的时候，需要使用对应的方法，不能直接进行 + - * /

1) add 加
2) subtract 减
3) multiply 乘
4) divide 除

```java
package com.hspedu.bignum;

import java.math.BigInteger;

public class BigInteger_ {
    public static void main(String[] args) {

        //当我们编程中，需要处理很大的整数，long 不够用
        //可以使用BigInteger的类来搞定
//        long l = 23788888899999999999999999999l;
//        System.out.println("l=" + l);

        BigInteger bigInteger = new BigInteger("23788888899999999999999999999");
        BigInteger bigInteger2 = new BigInteger("10099999999999999999999999999999999999999999999999999999999999999999999999999999999");
        System.out.println(bigInteger);
        //1. 在对 BigInteger 进行加减乘除的时候，需要使用对应的方法，不能直接进行 + - * /
        //2. 可以创建一个 要操作的 BigInteger对象 然后进行相应操作
        BigInteger add = bigInteger.add(bigInteger2);
        System.out.println(add);//
        BigInteger subtract = bigInteger.subtract(bigInteger2);
        System.out.println(subtract);//减
        BigInteger multiply = bigInteger.multiply(bigInteger2);
        System.out.println(multiply);//乘
        BigInteger divide = bigInteger.divide(bigInteger2);
        System.out.println(divide);//除

    }
}
```

```java
package com.hspedu.bignum;

import java.math.BigDecimal;

public class BigDecimal_ {
    public static void main(String[] args) {
        // 当我们需要保存一个精度很高的数时，double 不够用
        // 可以是 BigDecimal
        // double d = 1999.11111111111999999999999977788d;
        // System.out.println(d);
        BigDecimal bigDecimal = new BigDecimal("1999.11");
        BigDecimal bigDecimal2 = new BigDecimal("3");
        System.out.println(bigDecimal);
        
        // 1. 如果对 BigDecimal进行运算，比如加减乘除，需要使用对应的方法
        // 2. 创建一个需要操作的 BigDecimal 然后调用相应的方法即可
        System.out.println(bigDecimal.add(bigDecimal2));
        System.out.println(bigDecimal.subtract(bigDecimal2));
        System.out.println(bigDecimal.multiply(bigDecimal2));
        // System.out.println(bigDecimal.divide(bigDecimal2));//可能抛出异常ArithmeticException 因为除不尽
        // 在调用 divide 方法时，指定精度即可. 加上BigDecimal.ROUND_CEILING
        // 如果有无限循环小数，就会保留 分子 的精度
        System.out.println(bigDecimal.divide(bigDecimal2, BigDecimal.ROUND_CEILING));
    }
}
```

## 日期类

### 第一代日期类

1) Date:精确到毫秒,代表特定的瞬间
2) SimpleDateFormat:格式和解析日期的类：它允许进行格式化(日期->文本)、解析(文本->日期)和规范化。

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230424134109914.png)

```java
package com.hspedu.date_;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Date01 {
    public static void main(String[] args) throws ParseException {

        //1. 获取当前系统时间
        //2. 这里的Date 类是在java.util包
        //3. 默认输出的日期格式是国外的方式, 因此通常需要对格式进行转换
        Date d1 = new Date(); //获取当前系统时间
        System.out.println("当前日期=" + d1); // 当前日期=Mon Apr 24 13:40:14 CST 2023
        
        Date d2 = new Date(9234567); //通过指定毫秒数得到时间
        System.out.println("d2=" + d2); //获取某个时间对应的毫秒数 d2=Thu Jan 01 10:33:54 CST 1970

        //1. 创建 SimpleDateFormat对象，可以指定相应的格式
        //2. 这里的格式使用的字母是规定好，不能乱写
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss E");
        String format = sdf.format(d1); // format:将日期转换成指定格式的字符串
        System.out.println("当前日期=" + format); // 当前日期=2023年04月24日 01:40:14 星期一

        //1. 可以把一个格式化的String 转成对应的 Date
        //2. 得到Date 仍然在输出时，还是按照国外的形式，如果希望指定格式输出，需要转换
        //3. 在把String -> Date ， 使用的 sdf 格式需要和你给的String的格式一样，否则会抛出转换异常
        String s = "1996年01月01日 10:20:30 星期一";
        Date parse = sdf.parse(s);
        System.out.println("parse=" + sdf.format(parse)); // parse=1996年01月01日 10:20:30 星期一

    }
}
```

### 第二代日期类

1) 第二代日期类，主要就是Calendar类(日历)。
   `public abstract class Calendar extends Object implements Serialzable,Cloneable, Comparable<Calendar>`

2) Calendar类是一个抽象类，它为特定瞬间与一组诸如YEAR、MONTH、DAY_OF_MONTH、HOUR等日历定股之间的转换提供了一些方法，并为操作日历字段（例如获得下星期的日期)提供了一些方法。

```java
package com.hspedu.date_;

import java.util.Calendar;

public class Calendar_ {
    public static void main(String[] args) {
        // 1. Calendar是一个抽象类， 并且构造器是private
        // 2. 可以通过 getInstance() 来获取实例
        // 3. 提供大量的方法和字段提供给程序员
        // 4. Calendar没有提供对应的格式化的类，因此需要程序员自己组合来输出(灵活)
        // 5. 如果我们需要按照 24小时进制来获取时间， Calendar.HOUR ==改成=> Calendar.HOUR_OF_DAY
        Calendar c = Calendar.getInstance(); //创建日历类对象//比较简单，自由
        System.out.println("c=" + c);
        // 2.获取日历对象的某个日历字段
        System.out.println("年：" + c.get(Calendar.YEAR));
        // 这里为什么要 + 1, 因为Calendar 返回月时候，是按照 0 开始编号
        System.out.println("月：" + (c.get(Calendar.MONTH) + 1));
        System.out.println("日：" + c.get(Calendar.DAY_OF_MONTH));
        System.out.println("小时：" + c.get(Calendar.HOUR));
        System.out.println("分钟：" + c.get(Calendar.MINUTE));
        System.out.println("秒：" + c.get(Calendar.SECOND));
        // Calender 没有专门的格式化方法，所以需要程序员自己来组合显示
        System.out.println(c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH) + 1) + "-" + c.get(Calendar.DAY_OF_MONTH) +
                " " + c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND) );
    }
}
```

### 第三代日期类

前面两代日期类的不足分析

JDK 1.0中包含了一个java.util.Date类，但是它的大多数方法已经在JDK 1.1引入Calendar类之后被弃用了。而Calendar也存在问题是:

1) 可变性:像日期和时间这样的类应该是不可变的。
2) 偏移性:Date中的年份是从1900开始的，而月份都从0开始。
3) 格式化:格式化只对Date有用，Calendar则不行。
4) 此外，它们也不是线程安全的;不能处理闰秒等(每隔2天，多出1s).

LocalDate(日期/年月日)、LocalTime(时间/时分秒)、LocalDateTime(日期时间/年月日时分秒) JDK8加入：

+ LocalDate只包含日期，可以获取日期字段

+ LocalTime只包含时间，可以获取时间字段

+ LocalDateTime包含目期+时间，可以获取日期和时间字段

  ```java
  LocalDateTime ldt = LocalDateTime.now(); //LocalDate.now();//LocalTime.now()
  System.out.println(ldt);
  ldt.getYear();
  ldt.getMonthValue();
  ldt.getMonth();
  ldt.getDayofMonth();
  ldt.getHour();
  ldt.getMinute();
  ldt.getSecond();
  ```

```java
package com.hspedu.date_;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;

public class LocalDate_ {
    public static void main(String[] args) {
        //第三代日期
        //1. 使用now() 返回表示当前日期时间的 对象
        LocalDateTime ldt = LocalDateTime.now(); //LocalDate.now();//LocalTime.now()
        System.out.println(ldt);

        //2. 使用DateTimeFormatter 对象来进行格式化
        // 创建 DateTimeFormatter对象
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = dateTimeFormatter.format(ldt);
        System.out.println("格式化的日期=" + format);

        System.out.println("年=" + ldt.getYear());
        System.out.println("月=" + ldt.getMonth());
        System.out.println("月=" + ldt.getMonthValue());
        System.out.println("日=" + ldt.getDayOfMonth());
        System.out.println("时=" + ldt.getHour());
        System.out.println("分=" + ldt.getMinute());
        System.out.println("秒=" + ldt.getSecond());

        LocalDate now = LocalDate.now(); //可以获取年月日
        LocalTime now2 = LocalTime.now();//获取到时分秒


        //提供 plus 和 minus 方法可以对当前时间进行加或者减
        //看看890天后，是什么时候 把 年月日-时分秒
        LocalDateTime localDateTime = ldt.plusDays(890);
        System.out.println("890天后=" + dateTimeFormatter.format(localDateTime));

        //看看在 3456分钟前是什么时候，把 年月日-时分秒输出
        LocalDateTime localDateTime2 = ldt.minusMinutes(3456);
        System.out.println("3456分钟前 日期=" + dateTimeFormatter.format(localDateTime2));
    }
}
```

### DateTimeFormatter 格式日期类

类似于 `SimpleDateFormat`

```java
DateTimeFormat dtf = DateTimeFormatter.ofPattern(格式);
String str = dtf.format(日期对象);
```

案例演示:

```java
LocalDateTime ldt = LocalDateTime.now();
//关于DateTimeFormatter的各个格式参数，需要看jdk8的文档.
DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日HH小时tmm分钟ss秒");
String strDate = dtf.format(ldt);
```

### Instant 时间戳

```java
package com.hspedu.date_;

import java.time.Instant;
import java.util.Date;

public class Instant_ {
    public static void main(String[] args) {

        //1.通过 静态方法 now() 获取表示当前时间戳的对象
        Instant now = Instant.now();
        System.out.println(now);
        //2. 通过 from 可以把 Instant 转成 Date
        Date date = Date.from(now);
        //3. 通过 date的 toInstant() 可以把 date 转成Instant对象
        Instant instant = date.toInstant();
    }
}
```

### 第三代日期类更多方法

+ `LocalDateTime`类
+ `MonthDay`类:检查重复事件
+ 是否是闰年
+ 增加日期的某个部分
+ 使用 `plus` 方法测试增加时间的某个部分
+ 使用 `minus` 方法测试查看一年前和一年后的日期
+ 使用的时候查看 `API` 即可

## 本章作业

1.编程题

1. 将字符串中指定部分进行反转。比如将"abcdef"反转为"aedcbf"。

2) 编写方法 public static String reverse(String str, int start , int end)搞定。

```java
package com.hspedu.homework;

public class Homework01 {
    public static void main(String[] args) {
        //测试
        String str = "abcdef";
        System.out.println("===交换前===");
        System.out.println(str);
        try {
            str = reverse(str, 1, 4);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("===交换后===");
        System.out.println(str);
    }

    /**
     * (1) 将字符串中指定部分进行反转。比如将"abcdef"反转为"aedcbf"
     * (2) 编写方法 public static String reverse(String  str, int start , int end) 搞定
     * 思路分析
     * (1) 先把方法定义确定
     * (2) 把 String 转成 char[] ，因为char[] 的元素是可以交换的
     * (3) 画出分析示意图
     * (4) 代码实现
     */
    public static String reverse(String str, int start, int end) {
        //对输入的参数做一个验证
        //重要的编程技巧分享!!!
        //(1) 写出正确的情况
        //(2) 然后取反即可
        //(3) 这样写，你的思路就不乱
        if(!(str != null && start >= 0 && end > start && end < str.length())) {
            throw new RuntimeException("参数不正确");
        }

        char[] chars = str.toCharArray();
        char temp = ' '; //交换辅助变量
        for (int i = start, j = end; i < j; i++, j--) {
            temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        //使用chars 重新构建一个String 返回即可
        return new String(chars);

    }
}
```

2.编程题

输入用户名、密码、邮箱，如果信息录入正确，则提示注册成功，否则生成异常对象
要求:

(1) 用户名长度为2或3或4
(2) 密码的长度为6,要求全是数字isDigital
(3) 邮箱中包含@和。并且@在的前面

```java
package com.hspedu.homework;

public class Homework02 {
    public static void main(String[] args) {

        String name = "abc";
        String pwd = "123456";
        String email = "ti@i@sohu.com";

        try {
            userRegister(name,pwd,email);
            System.out.println("恭喜你，注册成功~");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * 输入用户名、密码、邮箱，如果信息录入正确，则提示注册成功，否则生成异常对象
     * 要求：
     * (1) 用户名长度为2或3或4
     * (2) 密码的长度为6，要求全是数字  isDigital
     * (3) 邮箱中包含@和.   并且@在.的前面
     * <p>
     * 思路分析
     * (1) 先编写方法 userRegister(String name, String pwd, String email) {}
     * (2) 针对 输入的内容进行校核，如果发现有问题，就抛出异常，给出提示
     * (3) 单独的写一个方法，判断 密码是否全部是数字字符 boolean
     */
    public static void userRegister(String name, String pwd, String email) {

        //再加入一些校验
        if(!(name != null && pwd != null && email != null)) {
            throw  new RuntimeException("参数不能为null");
        }

        //过关
        //第一关
        int userLength = name.length();
        if (!(userLength >= 2 && userLength <= 4)) {
            throw new RuntimeException("用户名长度为2或3或4");
        }

        //第二关
        if (!(pwd.length() == 6 && isDigital(pwd))) {
            throw new RuntimeException("密码的长度为6，要求全是数字");
        }

        //第三关
        int i = email.indexOf('@');
        int j = email.indexOf('.');
        if (!(i > 0 && j > i)) {
            throw new RuntimeException("邮箱中包含@和.   并且@在.的前面");
        }


    }

    //单独的写一个方法，判断 密码是否全部是数字字符 boolean
    public static boolean isDigital(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] < '0' || chars[i] > '9') {
                return false;
            }
        }
        return true;
    }

}
```

3.编程题

(1) 编写java程序，输入形式为: Han shun Ping的人名，以Ping,Han .S的形式打印
出来。其中.S是中间单词的首字母。

(2) 例如输入“Willian Jefferson Clinton”，输出形式为:Clinton, Willian .J

```java
package com.hspedu.homework;

public class Homework03 {
    public static void main(String[] args) {
        String name = "Willian Jefferson Clinton";
        printName(name);
    }

    /**
     * 编写方法: 完成输出格式要求的字符串
     * 编写java程序，输入形式为： Han shun Ping的人名，以Ping,Han .S的形式打印
     *       出来    。其中.S是中间单词的首字母
     * 思路分析
     * (1) 对输入的字符串进行 分割split(" ")
     * (2) 对得到的String[] 进行格式化String.format（）
     * (3) 对输入的字符串进行校验即可
     */
    
    public static void printName(String str) {

        if(str == null) {
            System.out.println("str 不能为空");
            return;
        }

        String[] names = str.split(" ");
        if(names.length != 3) {
            System.out.println("输入的字符串格式不对");
            return;
        }

        String format = String.format("%s,%s .%c", names[2], names[0], names[1].toUpperCase().charAt(0));
        System.out.println(format);
    }
}
```

4.编程题

输入字符串，判断里面有多少个大写字母，多少个小写字母，多少个数字。

```java
package com.hspedu.homework;

public class Homework04 {
    public static void main(String[] args) {
            String str = "abcHsp U 1234";
            countStr(str);
    }

    /**
     * 输入字符串，判断里面有多少个大写字母，多少个小写字母，多少个数字
     * 思路分析
     * (1) 遍历字符串，如果 char 在 '0'~'9' 就是一个数字
     * (2) 如果 char 在 'a'~'z' 就是一个小写字母
     * (3) 如果 char 在 'A'~'Z' 就是一个大写字母
     * (4) 使用三个变量来记录 统计结果
     */
    public static void countStr(String str) {
        if (str == null) {
            System.out.println("输入不能为 null");
            return;
        }
        int strLen = str.length();
        int numCount = 0;
        int lowerCount = 0;
        int upperCount = 0;
        int otherCount = 0;
        for (int i = 0; i < strLen; i++) {
            if(str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                numCount++;
            } else if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                lowerCount++;
            } else if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                upperCount++;
            } else {
                otherCount++;
            }
        }

        System.out.println("数字有 " + numCount);
        System.out.println("小写字母有 " + lowerCount);
        System.out.println("大写字母有 " + upperCount);
        System.out.println("其他字符有 " + otherCount);
    }
}

```

5.分析题

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230424213254827.png)
