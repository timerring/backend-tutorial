- [第3章 变量](#第3章-变量)
  - [程序中+号的使用](#程序中号的使用)
  - [数据类型](#数据类型)
  - [整数类型](#整数类型)
    - [整型的类型](#整型的类型)
    - [整型的使用细节IntDetail.java](#整型的使用细节intdetailjava)
  - [浮点类型](#浮点类型)
    - [浮点型的分类](#浮点型的分类)
    - [浮点型使用细节FloatDetail.java](#浮点型使用细节floatdetailjava)
  - [Java API 文档](#java-api-文档)
  - [字符类型(char)](#字符类型char)
    - [字符类型使用细节](#字符类型使用细节)
    - [字符本质探讨](#字符本质探讨)
  - [布尔类型：boolean](#布尔类型boolean)
  - [基本数据类型转换](#基本数据类型转换)
    - [自动类型转换](#自动类型转换)
    - [自动类型转换注意和细节](#自动类型转换注意和细节)
    - [强制类型转换](#强制类型转换)
  - [基本数据类型和String 类型的转换](#基本数据类型和string-类型的转换)
    - [介绍和使用](#介绍和使用)
    - [注意事项](#注意事项)


# 第3章 变量

## 程序中+号的使用

1.当左右两边都是数值型时，则做加法运算

2.当左右两边有一方为字符串，则做拼接运算

## 数据类型

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/04/11-15-20-34-1681197633.png)

1. java 数据类型分为两大类 
   
   基本数据类型 与 引用类型

2. 基本数据类型有8种
   
   + 数值型[byte , short , int , long , float ,double] 
   
   + char
   
   + boolean

3. 引用类型[类，接口， 数组]

## 整数类型

### 整型的类型

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/04/11-15-22-52-1681197769.png)

### 整型的使用细节IntDetail.java

Java各整数类型有固定的范围和字段长度，不受具体OS[操作系统]的影响，以保证java程序的可移植性。
Java的整型常量(具体值)默认为int型，声明long型常量须后加`l`或`L`

## 浮点类型

### 浮点型的分类

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/04/11-15-28-47-1681198125.png)

1) 关于浮点数在机器中存放形式的简单说明, 浮点数=符号位+指数位+尾数位
2) 尾数部分可能丢失，造成精度损失(小数都是近似值)。

### 浮点型使用细节FloatDetail.java

与整数类型类似，Java浮点类型也有固定的范围和字段长度，不受具体OS的影响。

Java的浮点型常量(具体值)默认为double型，声明float型常量，须后加‘f或‘F'

浮点型常量有两种表示形式

+ 十进制数形式:如:5.12    512.0f    .512(必须有小数点)

+ 科学计数法形式:如:5.12e2[5.12*10的2次方]5.12E-2[5.12/10的2次方]

通常情况下，应该使用double型，因为它比float型更精确。
  double num9 = 2.1234567851;
  float num10= 2.1234567851F;

浮点数使用陷阱:2.7和8.1/3比较

```java
public class FloatDetail { 

    //编写一个main方法
    public static void main(String[] args) {

        //Java 的浮点型常量(具体值)默认为double型，声明float型常量，须后加‘f’或‘F'
        //float num1 = 1.1; //对不对?错误
        float num2 = 1.1F; //对的
        double num3 = 1.1; //对
        double num4 = 1.1f; //对

        //十进制数形式：如：5.12       512.0f        .512   (必须有小数点）
        double num5 = .123; //等价 0.123
        System.out.println(num5);
        //科学计数法形式:如：5.12e2 [5.12 * 10的2次方 ]      5.12E-2   [] 
        System.out.println(5.12e2);//512.0
        System.out.println(5.12E-2);//0.0512


        //通常情况下，应该使用double型，因为它比float型更精确。
        //[举例说明]double num9 = 2.1234567851;float num10 =  2.1234567851F;
        double num9 =  2.1234567851;
        float num10 =  2.1234567851F;
        System.out.println(num9);
        System.out.println(num10);

        //浮点数使用陷阱: 2.7 和 8.1 / 3  比较
        //看看一段代码
        double num11 = 2.7;
        double num12 = 2.7;    //8.1 / 3; //2.7
        System.out.println(num11);//2.7
        System.out.println(num12);//接近2.7的一个小数，而不是2.7
        //得到一个重要的使用点: 当我们对运算结果是小数的进行相等判断时，要小心
        //应该是以两个数的差值的绝对值，在某个精度范围类判断
        if( num11 == num12) {
            System.out.println("num11 == num12 相等");
        }
        //正确的写法 , ctrl + / 注释快捷键, 再次输入就取消注释
        if(Math.abs(num11 - num12) < 0.000001 ) {
            System.out.println("差值非常小，到我的规定精度，认为相等...");
        }
        // 可以通过java API  来看 下一个视频介绍如何使用API
        System.out.println(Math.abs(num11 - num12));
        //细节:如果是直接查询得的的小数或者直接赋值，是可以判断相等
    }
}
```

当我们对运算结果是小数的进行相等判断时，要小心应该是以两个数的差值的绝对值，在某个精度范围类判断。

## Java API 文档

API (Application Programming Interface,应用程序编程接口)是Java提供的基本编程接口(java提供的类还有相关的方法)。中文在线文档: https://www.matools.com

Java语言提供了大量的基础类，因此 Oracle公司也为这些基础类提供了相应的API文档,用于告诉开发者如何使用这些类,以及这些类里包含的方法。

Java类的组织形式[图]

查询 ArrayList 类有哪些方法：

+ 包->类->方法

+ 直接索引 Math

## 字符类型(char)

字符类型可以表示单个字符,字符类型是char，char 是两个字节(可以存放汉字)，多个字符用字符串String

### 字符类型使用细节

字符常量是用单引号('')括起来的单个字符

Java中还允许使用转义字符来将其后的字符转变为特殊字符型常量。

> 例如:char c3 = '\n';  表示换行符

在java中,char的本质是一个整数，在输出时，是 unicode码对应的字符

http://tool.chinaz.com/Tools/Unicode.aspx

char类型是可以进行运算的，相当于一个整数，因为它都对应有Unicode码.

### 字符本质探讨

字符型存储到计算机中，需要将字符对应的码值(整数)找出来，比如'a'

+ 存储:`a'==>码值97 ==>二进制(110 0001) ==>存储

+ 读取:二进制(110 0001)=>97 ===> 'a'=>显示

字符和码值的对应关系是通过字符编码表决定的(是规定好)

介绍一下字符编码表

+ ASClI (ASCIl编码表一个字节表示，一个128个字符,实际上一个字节可以表示256个字符,只用128个)

+ Unicode ( Unicode 编码表固定大小的编码使用两个字节来表示字符，字母和汉字统一都是占用两个字节这样浪费空间 )
  
  + Unicode的好处: 一种编码，将世界上所有的符号都纳入其中。每一个符号都给予一个独一无二的编码，使用 Unicode 没有乱码的问题。
  
  + Unicode 的缺点: 一个英文字母和一个汉字都占用2个字节，这对于存储空间来说是浪费。
  
  + 2的16次方是65536,所以最多编码是65536个字符
  
  + 编码0-127的字符是与ASCII的编码一样.比如'a'在ASCII码是0x61，在unicode码是
    0x0061,都对应97.因此 Unicode码兼容ASCII码.

+ utf-8(编码表,大小可变的编码字母使用1个字节，汉字使用3个字节)gbk(可以表示汉字，而且范围广，字母使用1个字节,汉字2个字节)gb2312(可以表示汉字,gb2312 <gbk)
  
  + UTF-8是在互联网上使用最广的一种Unicode的实现方式(改进)
  
  + UTF-8是一种变长的编码方式。它可以使用1-6个字节表示一个符号，根据不同的符号而变化字节长度。
  
  + 使用大小可变的编码字母占1个字节，汉字占3个字节

+ big5码(繁体中文,台湾,香港)

## 布尔类型：boolean

布尔类型也叫boolean类型，booolean类型数据只允许取值true和false，无null

boolean类型占1个字节。

## 基本数据类型转换

### 自动类型转换

当java程序在进行赋值或者运算时，精度小的类型自动转换为精度大的数据类型,这个就是自动类型转换。

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/04/11-16-56-17-1681203376.png)

### 自动类型转换注意和细节

1. 有多种类型的数据混合运算时，系统首先自动将所有数据转换成容量最大的那种数据类型,然后再进行计算。

2. 当我们把精度(容量)大的数据类型赋值给精度(容量)小的数据类型时，就会报错，反之就会进行自动类型转换。

3. (byte, short)和char之间不会相互自动转换。**byte，short，char他们三者可以计算，在计算时首先转换为int类型。**

4. boolean不参与转换

5. 自动提升原则:表达式结果的类型自动提升为操作数中最大的类型

### 强制类型转换

自动类型转换的逆过程，将容量大的数据类型转换为容量小的数据类型。使用时要加上强制转换符( )，但可能造成精度降低或溢出,格外要注意。

char类型可以保存int的常量值，但不能保存int的变量值，需要强转

```java
public class ForceConvertDetail { 
    //编写一个main方法
    public static void main(String[] args) {

        //演示强制类型转换
        //强转符号只针对于最近的操作数有效，往往会使用小括号提升优先级
        //int x = (int)10*3.5+6*1.5;//编译错误： double -> int 
        int x = (int)(10*3.5+6*1.5);// (int)44.0 -> 44
        System.out.println(x);//44

        char c1 = 100; //ok
        int m = 100; //ok
        //char c2 = m; //错误
        char c3 = (char)m; //ok
        System.out.println(c3);//100对应的字符, d字符
    }
}
```

## 基本数据类型和String 类型的转换

### 介绍和使用

在程序开发中，我们经常需要将基本数据类型转成String类型。或者将String类型转成基本数据类型。

+ 基本类型转String类型
  
  语法:将基本类型的值+""即可

+ String类型转基本数据类型
  
  语法:通过基本类型的包装类调用parseXX方法即可

```java

public class StringToBasic { 

	//编写一个main方法
	public static void main(String[] args) {
		//String->对应的基本数据类型
		String s5 = "123";
		//会在 OOP 讲对象和方法的时候回详细
		//解读 使用 基本数据类型对应的包装类的相应方法，得到基本数据类型
		int num1 = Integer.parseInt(s5);
		double num2 = Double.parseDouble(s5);
		float num3 = Float.parseFloat(s5);
		long num4 = Long.parseLong(s5);
		byte num5 = Byte.parseByte(s5);
		boolean b = Boolean.parseBoolean("true");
		short num6 = Short.parseShort(s5);

		System.out.println("===================");
		System.out.println(num1);//123
		System.out.println(num2);//123.0
		System.out.println(num3);//123.0
		System.out.println(num4);//123
		System.out.println(num5);//123
		System.out.println(num6);//123
		System.out.println(b);//true
		//怎么把字符串转成字符char -> 含义是指 把字符串的第一个字符得到
		//解读  s5.charAt(0) 得到 s5字符串的第一个字符 '1'
		System.out.println(s5.charAt(0));
	}
}
```

### 注意事项

在将String 类型转成基本数据类型时，要确保String类型能够转成有效的数据 ，比如我们可以把"123" , 转成一个整数，但是不能把"hello" 转成一个整数。如果格式不正确，就会抛出异常，程序就会终止。


