- [第2章 Java概述与基础知识](#第2章-java概述与基础知识)
  - [Java 历史](#java-历史)
  - [Java技术体系平台](#java技术体系平台)
  - [Java 重要特点](#java-重要特点)
    - [Java 虚拟机\[JVM\]](#java-虚拟机jvm)
  - [JDK，JRE](#jdkjre)
    - [JDK 基本介绍](#jdk-基本介绍)
    - [JRE 基本介绍](#jre-基本介绍)
    - [JDK、JRE 和JVM 的包含关系](#jdkjre-和jvm-的包含关系)
  - [Java 快速入门](#java-快速入门)
  - [注意细节](#注意细节)
  - [Java 转义字符](#java-转义字符)
    - [Java 常用的转义字符](#java-常用的转义字符)
  - [注释(comment)](#注释comment)
    - [Java 中的注释类型](#java-中的注释类型)
    - [关于文档注释](#关于文档注释)
      - [javadoc 常见标签](#javadoc-常见标签)
  - [Java 代码规范](#java-代码规范)
  - [DOS 命令](#dos-命令)
    - [DOS 介绍](#dos-介绍)
    - [常用的dos 命令](#常用的dos-命令)
  - [环境变量path配置及其作用](#环境变量path配置及其作用)


# 第2章 Java概述与基础知识

## Java 历史

+ 1990 sun公司启动绿色计划

+ 1992创建oak(橡树)语言->java

+ 1994 gosling参加硅谷大会演示java功能震惊世界。1995 sun 正式发布java第1个版本。

+ 2009年，甲骨文公司宣布收购Sun 。

+ 2011，发布java7

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/04/10-19-15-03-1681125302.png)

## Java技术体系平台

+ Java SE (Java Standard Edition) 标准版
  支持面向桌面级应用(如Windows下的应用程序)的Java平台，提供了完整的Java核心API，此版本以前称为J2SE

+ Java EE(Java Enterprise Edition)企业版
  是为开发企业环境下的应用程序提供的一套解决方案。该技术体系中包含的技术如:Servlet、Jsp等，主要针对于Web应用程序开发。版本以前称为J2EE

+ Java ME(Java Micro Edition)小型版
  支持Java程序运行在移动终端(手机、PDA)上的平台，对Java API有所精简，并加入了键对移动终端的支持，此版本以前称为J2ME

## Java 重要特点

1) Java 语言是面向对象的(oop)

2) Java 语言是健壮的。Java 的强类型机制、异常处理、垃圾的自动收集等是Java 程序健壮性的重要保证

3) Java 语言是跨平台性的。[编译好的.class 文件可以在多个系统下运行，这种特性称为跨平台]

4) Java 语言是解释型的
   
   解释性语言：javascript,PHP, java 
   
   编译性语言: c / c++
   区别是：解释性语言，编译后的代码，不能直接被机器执行,需要解释器来执行, 编译性语言, 编译后的代码, 可以直接被机器执行。

### Java 虚拟机[JVM]

1) JVM 是一个虚拟的计算机，具有指令集并使用不同的存储区域。负责执行指令，管理数据、内存、寄存器，包含在JDK 中。
2) 对于不同的平台，有不同的虚拟机。
3) Java 虚拟机机制屏蔽了底层运行平台的差别，实现了“一次编译，到处运行”。

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/04/10-19-27-50-1681126068.png)

## JDK，JRE

### JDK 基本介绍

1) JDK 的全称(Java Development Kit Java 开发工具包)
   JDK = JRE + java 的开发工具[java, javac,javadoc,javap 等]
2) JDK 是提供给Java 开发人员使用的，其中包含了java 的开发工具，也包括了JRE。

### JRE 基本介绍

1) JRE(Java Runtime Environment Java 运行环境)
   JRE = JVM + Java 的核心类库[类]
2) 包括Java 虚拟机(JVM Java Virtual Machine)和Java 程序所需的核心类库等，如果想要运行一个开发好的Java 程序，计算机中只需要安装JRE 即可。

### JDK、JRE 和JVM 的包含关系

1) JDK = JRE + 开发工具集（例如Javac,java 编译工具等)
2) JRE = JVM + Java SE 标准类库（java 核心类库）
3) 如果只想运行开发好的.class 文件只需要JRE

## Java 快速入门

开发步骤

1) 将Java 代码编写到扩展名为Hello.java 的文件中。
2) 通过javac 命令对该java 文件进行编译，生成.class 文件。
3) 通过java 命令对生成的class 文件进行运行。

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/04/10-20-36-07-1681130166.png)

## 注意细节

Java源文件以.java 为扩展名。源文件的基本组成部分是类(class)，如本类中的Hello类。

Java应用程序的执行入口是main(方法。它有固定的书写格式:
public static void main(String[] args)

Java语言严格区分大小写。

**一个源文件中最多只能有一个public类。其它类的个数不限**。每个类对应一个class。

如果源文件包含一个public类，则文件名必须按该类名命名!

一个源文件中最多只能有一个public类。其它类的个数不限，也可以将main方法写在非public类中，然后指定运行非public类，这样入口方法就是非public 的main方法。

```java
//这是java的快速入门， 演示java的开发步骤
//对代码的相关说明
//1. public class Hello 表示Hello是一个类,是一个public公有的类
//2. Hello{ } 表示一个类的开始和结束
//3. public static void main(String[] args) 表示一个主方法,即我们程序的入口
//4. main() {} 表示方法的开始和结束
//5. System.out.println("hello,world~"); 表示输出"hello,world~"到屏幕
//6. ;表示语句结束
public class Hello {

    //编写一个main方法
    public static void main(String[] args) {
        System.out.println("timerring hello");
    }

}

//一个源文件中最多只能有一个public类。其它类的个数不限。[演示]
//Dog 是一个类
//编译后，每一个类，都对于一个.class
class Dog {

    //一个源文件中最多只能有一个public类。其它类的个数不限，也可以将main方法写在非public类中，
    //然后指定运行非public 类，这样入口方法就是非public 的main方法
    public static void main(String[] args) {
        System.out.println("hello, 狗狗");
    }
}

class Tiger {

    public static void main(String[] args) {
        System.out.println("hello, 老虎");
    }

}
```

## Java 转义字符

### Java 常用的转义字符

在控制台，输入tab 键，可以实现命令补全
\t ：一个制表位，实现对齐的功能
\n ：换行符
\\ ：一个\
\" :一个"
\' ：一个'
\r :一个回车System.out.println("timerring\r 北京"); 注意：回车不换行。

## 注释(comment)

### Java 中的注释类型

1) 单行注释//
2) 多行注释/* */ （多行注释里面不允许有多行注释嵌套）
3) 文档注释/** */

### 关于文档注释

```java
/**
 * @author  timerring
 * @version  1.0
 */

// 其中author  version  是javadoc的标签
public class Comment02 { 

    //编写一个main方法
    public static void main(String[] args) {
    }
}
```

注释内容可以被JDK提供的工具javadoc所解析，生成一套以网页文件形式体现的该程序的说明文档,一般写在类

`javadoc -d 生成的doc所存的文件夹名 -author -version Comment02.java`

#### javadoc 常见标签

| **标签**            | **描述**                                          | **示例**                                                               |
| ----------------- | ----------------------------------------------- | -------------------------------------------------------------------- |
| **@author**       | **标识一个类的作者**                                    | **@author description**                                              |
| **@deprecated**   | **指名一个过期的类或成员**                                 | **@deprecated description**                                          |
| **{@docRoot}**    | **指明当前文档根目录的路径**                                | **Directory Path**                                                   |
| **@exception**    | **标志一个类抛出的异常**                                  | **@exception exception-name explanation**                            |
| **{@inheritDoc}** | **从直接父类继承的注释**                                  | **Inherits a comment from the immediate surperclass.**               |
| **{@link}**       | **插入一个到另一个主题的链接**                               | **{@link name text}**                                                |
| **{@linkplain}**  | **插入一个到另一个主题的链接，但是该链接显示纯文本字体**                  | **Inserts an  in-line link to another topic.**                       |
| **@param**        | **说明一个方法的参数**                                   | **@param  parameter-name explanation**                               |
| **@return**       | **说明返回值类型**                                     | **@return explanation**                                              |
| **@see**          | **指定一个到另一个主题的链接**                               | **@see  anchor**                                                     |
| **@serial**       | **说明一个序列化属性**                                   | **@serial  description**                                             |
| **@serialData**   | **说明通过writeObject( ) 和 writeExternal( )方法写的数据** | **@serialData  description**                                         |
| **@serialField**  | **说明一个ObjectStreamField组件**                     | **@serialField  name type description**                              |
| **@since**        | **标记当引入一个特定的变化时**                               | **@since  release**                                                  |
| **@throws**       | **和 @exception标签一样.**                           | **The  @throws tag has the same meaning as the @exception tag.**     |
| **{@value}**      | **显示常量的值，该常量必须是static属性。**                      | **Displays  the value of a constant, which must be a static field.** |
| **@version**      | **指定类的版本**                                      | **@version  info**                                                   |

## Java 代码规范

1. 类、方法的注释,要以javadoc的方式来写。

2. 非Java Doc的注释，往往是给代码的维护者看的，着重告述读者为什么这样写,如何修改,注意什么问题等

3. 使用tab操作，实现缩进，默认**整体向右边移动**，时候用**shift+tab整体向左移**

4. 运算符和=两边习惯性各加一个空格。

5. 源文件使用utf-8编码

6. 行宽度不要超过80字符

7. 代码编写次行风格和行尾风格(!) 推荐行尾风格。

## DOS 命令

### DOS 介绍

Dos：Disk Operating System 磁盘操作系统, 简单说一下windows 的目录结构。

### 常用的dos 命令

1) 查看当前目录是有什么内容 dir
   `dir d:\abc2\test200`

2) 切换到其他盘下：盘符号cd : change directory

3) 切换到当前盘的其他目录下(使用相对路径和绝对路径演示), ..\表示上一级目录

4) 切换到上一级：
   案例演示： cd ..

5) 切换到根目录：cd \
   案例演示：cd \

6) 查看指定的目录下所有的子级目录tree

7) 清屏cls

8) 退出DOS `exit`

9) (md[创建目录],rd[删除目录],copy[拷贝文件],del[删除文件],echo[输入内容到文件],type,move[剪切])
   
   `echo ok > pic.txt`

## 环境变量path配置及其作用

1. 环境变量的作用是为了在dos的任意目录，可以去使用java 和 javac命令
2. 先配置 JAVA_HOME = 指向jdk安装的主目录
3. 编辑path环境变量，增加 %JAVA_HOME%\bin 
