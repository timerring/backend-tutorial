- [第19章 IO流](#第19章-io流)
  - [文件](#文件)
  - [常用的文件操作](#常用的文件操作)
    - [创建文件对象相关构造器和方法](#创建文件对象相关构造器和方法)
    - [获取文件的相关信息](#获取文件的相关信息)
    - [目录的操作和文件删除](#目录的操作和文件删除)
  - [IO 流原理及流的分类](#io-流原理及流的分类)
    - [Java IO 流原理](#java-io-流原理)
    - [流的分类](#流的分类)
  - [IO 流体系图-常用的类](#io-流体系图-常用的类)
    - [IO 流体系图](#io-流体系图)
    - [文件 VS 流](#文件-vs-流)
    - [FileInputStream 介绍](#fileinputstream-介绍)
    - [FileInputStream 应用实例](#fileinputstream-应用实例)
    - [FileOutputStream 介绍](#fileoutputstream-介绍)
    - [FileOutputStream 应用实例](#fileoutputstream-应用实例)
    - [FileOutputStream 应用实例2](#fileoutputstream-应用实例2)
    - [FileReader 和FileWriter 介绍](#filereader-和filewriter-介绍)
    - [FileReader 相关方法](#filereader-相关方法)
    - [FileWriter 相关方法](#filewriter-相关方法)
    - [FileReader 和FileWriter 应用案例](#filereader-和filewriter-应用案例)
  - [节点流和处理流](#节点流和处理流)
    - [基本介绍](#基本介绍)
    - [节点流和处理流一览图](#节点流和处理流一览图)
    - [节点流和处理流的区别和联系](#节点流和处理流的区别和联系)
    - [处理流的功能](#处理流的功能)
    - [处理流 BufferedReader 和BufferedWriter](#处理流-bufferedreader-和bufferedwriter)
      - [应用案例](#应用案例)
    - [处理流BufferedInputStream 和BufferedOutputStream](#处理流bufferedinputstream-和bufferedoutputstream)
      - [应用案例](#应用案例-1)
    - [对象流ObjectInputStream 和ObjectOutputStream](#对象流objectinputstream-和objectoutputstream)
    - [对象流介绍](#对象流介绍)
      - [应用案例](#应用案例-2)
    - [标准输入输出流](#标准输入输出流)
      - [介绍](#介绍)
      - [应用案例1](#应用案例1)
      - [应用案例2](#应用案例2)
    - [转换流InputStreamReader 和OutputStreamWriter](#转换流inputstreamreader-和outputstreamwriter)
      - [应用案例](#应用案例-3)
    - [打印流PrintStream 和PrintWriter](#打印流printstream-和printwriter)
  - [Properties 类](#properties-类)
    - [基本介绍](#基本介绍-1)
    - [应用案例](#应用案例-4)
  - [本章作业](#本章作业)


# 第19章 IO流

## 文件

文件，对我们并不陌生,文件是保存数据的地方。文件在程序中是以流的形式来操作的。

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230503160956655.png)

流：数据在数据源(文件)和程序(内存)之间经历的路径

输入流：数据从数据源(文件)到程序(内存)的路径

输出流：数据从程序(内存)到数据源(文件)的路径

## 常用的文件操作

### 创建文件对象相关构造器和方法

+ `new File(String pathname)` //根据路径构建一个File对象
+ `new File(File parent, String child)` //根据父目录文件+子路径构建new
+ `File(String parent, String child)` //根据父目录+子路径构建

```java
package com.hspedu.file;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * 演示创建文件
 */
public class FileCreate {
    public static void main(String[] args) {

    }

    //方式1 new File(String pathname)
    @Test
    public void create01() {
        String filePath = "e:\\news1.txt";
        File file = new File(filePath);

        try {
            file.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //方式2 new File(File parent,String child) //根据父目录文件+子路径构建
    //e:\\news2.txt
    @Test
    public  void create02() {
        File parentFile = new File("e:\\");
        String fileName = "news2.txt";
        //这里的file对象，在java程序中，只是一个对象
        //只有执行了createNewFile 方法，才会真正的，在磁盘创建该文件
        File file = new File(parentFile, fileName);

        try {
            file.createNewFile();
            System.out.println("创建成功~");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //方式3 new File(String parent,String child) //根据父目录+子路径构建
    @Test
    public void create03() {
        //String parentPath = "e:\\";
        String parentPath = "e:\\";
        String fileName = "news4.txt";
        File file = new File(parentPath, fileName);

        try {
            file.createNewFile();
            System.out.println("创建成功~");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //下面四个都是抽象类
    //InputStream
    //OutputStream
    //Reader //字符输入流
    //Writer  //字符输出流
}
```

### 获取文件的相关信息

`getName`、`getAbsolutePath`、`getParent`、`length`、`exists`、`isFile`、`isDirectory`

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230504203129053.png)

```java
package com.hspedu.file;

import org.junit.jupiter.api.Test;

import java.io.File;

public class FileInformation {
    public static void main(String[] args) {

    }

    // 获取文件的信息
    @Test
    public void info() {
        // 先创建文件对象
        File file = new File("e:\\news1.txt");

        // 调用相应的方法，得到对应信息
        System.out.println("文件名字=" + file.getName());
        // getName、getAbsolutePath、getParent、length、exists、isFile、isDirectory
        System.out.println("文件绝对路径=" + file.getAbsolutePath());
        System.out.println("文件父级目录=" + file.getParent());
        System.out.println("文件大小(字节)=" + file.length());
        System.out.println("文件是否存在=" + file.exists());//T
        System.out.println("是不是一个文件=" + file.isFile());//T
        System.out.println("是不是一个目录=" + file.isDirectory());//F
    }
}
```

### 目录的操作和文件删除

mkdir创建一级目录、mkdirs创建多级目录、delete删除空目录或文件

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230504203901097.png)

应用案例演示

1) 判断 `d:\\news1.txt`是否存在，如果存在就删除
2) 判断 `D:\\ldemo02`是否存在，存在就删除,否则提示不存在.
3) 判断 `D:\\demo\\a\\b\\c`目录是否存在，如果存在就提示已经存在，否则就创建

```java
package com.hspedu.file;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

public class Directory_ {
    public static void main(String[] args) {

        //
    }

    //判断 d:\\news1.txt 是否存在，如果存在就删除
    @Test
    public void m1() {

        String filePath = "e:\\news1.txt";
        File file = new File(filePath);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println(filePath + "删除成功");
            } else {
                System.out.println(filePath + "删除失败");
            }
        } else {
            System.out.println("该文件不存在...");
        }

    }

    //判断 D:\\demo02 是否存在，存在就删除，否则提示不存在
    //这里我们需要体会到，在java编程中，目录也被当做文件
    @Test
    public void m2() {

        String filePath = "D:\\demo02";
        File file = new File(filePath);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println(filePath + "删除成功");
            } else {
                System.out.println(filePath + "删除失败");
            }
        } else {
            System.out.println("该目录不存在...");
        }

    }

    //判断 D:\\demo\\a\\b\\c 目录是否存在，如果存在就提示已经存在，否则就创建
    @Test
    public void m3() {

        String directoryPath = "D:\\demo\\a\\b\\c";
        File file = new File(directoryPath);
        if (file.exists()) {
            System.out.println(directoryPath + "存在..");
        } else {
            if (file.mkdirs()) { //创建一级目录使用mkdir() ，创建多级目录使用mkdirs()
                System.out.println(directoryPath + "创建成功..");
            } else {
                System.out.println(directoryPath + "创建失败...");
            }
        }


    }
}
```

## IO 流原理及流的分类

### Java IO 流原理

1. I/O 是 Input/Output 的缩写，I/O技术是非常实用的技术，用于处理数据传输。
   如读/写文件,网络通讯等。

2. Java程序中，对于数据的输入/输出操作以”流(stream)”的方式进行。
3. java.io包下提供了各种“流”类和接口，用以获取不同种类的数据,并通过方法输入或输出数据

4. 输入input:读取外部数据(磁盘、光盘等存储设备的数据)到程序(内存)中。
5. 输出output:将程序(内存)数据输出到磁盘、光盘等存储设备中

### 流的分类

+ 按操作数据单位不同分为：字节流(8 bit)（二进制文件例如声音视频word等可以无损操作），字符流(按字符)（文本文件）。
+ 按数据流的流向不同分为：输入流，输出流。
+ 按流的角色的不同分为：节点流，处理流 / 包装流。

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230504204742152.png)

1) Java的IO流共涉及40多个类，实际上非常规则，都是从如上4个抽象基类派生的。
2) 由这四个类派生出来的子类名称都是以其父类名作为子类名后缀。

## IO 流体系图-常用的类

### IO 流体系图

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230504204925837.png)

### 文件 VS 流

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230504205021064.png)

### FileInputStream 介绍

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230504211101879.png)

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230504213404677.png)

### FileInputStream 应用实例

请使用FileInputStream 读取hello.txt 文件，并将文件内容显示到控制台.

当然，注意一个汉字通常是由3个bytes构成的，而read只会读取一个byte的数据，因此如果用read则会乱码，建议文本文件用字符流处理。

```java
package com.hspedu.inputstream_;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 演示FileInputStream的使用(字节输入流 文件--> 程序)
 */
public class FileInputStream_ {
    public static void main(String[] args) {

    }

    /**
     * 演示读取文件...
     * 单个字节的读取，效率比较低
     * -> 使用 read(byte[] b)
     */
    @Test
    public void readFile01() {
        String filePath = "e:\\hello.txt";
        int readData = 0;
        FileInputStream fileInputStream = null;
        try {
            //创建 FileInputStream 对象，用于读取 文件
            fileInputStream = new FileInputStream(filePath);
            //从该输入流读取一个字节的数据。 如果没有输入可用，此方法将阻止。
            //如果返回-1 , 表示读取完毕
            while ((readData = fileInputStream.read()) != -1) {
                System.out.print((char)readData);//转成char显示
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭文件流，释放资源.
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 使用 read(byte[] b) 读取文件，提高效率
     */
    @Test
    public void readFile02() {
        String filePath = "e:\\hello.txt";
        //字节数组
        byte[] buf = new byte[8]; //一次读取8个字节.
        int readLen = 0;
        FileInputStream fileInputStream = null;
        try {
            //创建 FileInputStream 对象，用于读取 文件
            fileInputStream = new FileInputStream(filePath);
            //从该输入流读取最多b.length字节的数据到字节数组。 此方法将阻塞，直到某些输入可用。
            //如果返回-1 , 表示读取完毕
            //如果读取正常, 返回实际读取的字节数
            while ((readLen = fileInputStream.read(buf)) != -1) {
                System.out.print(new String(buf, 0, readLen));//显示
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭文件流，释放资源.
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
```

### FileOutputStream 介绍

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230504213417029.png)

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230504213515594.png)

### FileOutputStream 应用实例

请使用FileOutputStream 在a.txt 文件，中写入“hello，world”. 如果文件不存在，会创建文件(注意：前提是目录已经存在.)

```java
package com.hspedu.outputstream_;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStream01 {
    public static void main(String[] args) {

    }

    /**
     * 演示使用 FileOutputStream 将数据写到文件中,
     * 如果该文件不存在，则创建该文件
     */
    @Test
    public void writeFile() {

        //创建 FileOutputStream对象
        String filePath = "e:\\a.txt";
        FileOutputStream fileOutputStream = null;
        try {
            //得到 FileOutputStream对象 对象
            //老师说明
            //1. new FileOutputStream(filePath) 创建方式，当写入内容是，会覆盖原来的内容
            //2. new FileOutputStream(filePath, true) 创建方式，当写入内容是，是追加到文件后面
            fileOutputStream = new FileOutputStream(filePath, true);
            //写入一个字节
            //fileOutputStream.write('H');//
            //写入字符串
            String str = "hello,world!";
            //str.getBytes() 可以把 字符串-> 字节数组
            //fileOutputStream.write(str.getBytes());
            /*
            write(byte[] b, int off, int len) 将 len字节从位于偏移量 off的指定字节数组写入此文件输出流
             */
            fileOutputStream.write(str.getBytes(), 0, 3);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
```

### FileOutputStream 应用实例2

编程完成图片/音乐的拷贝.

```java
package com.hspedu.outputstream_;

import com.hspedu.inputstream_.FileInputStream_;

import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        //完成 文件拷贝，将 e:\\Koala.jpg 拷贝 c:\\
        //思路分析
        //1. 创建文件的输入流 , 将文件读入到程序
        //2. 创建文件的输出流， 将读取到的文件数据，写入到指定的文件.
        String srcFilePath = "e:\\Koala.jpg";
        String destFilePath = "e:\\Koala3.jpg";
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {

            fileInputStream = new FileInputStream(srcFilePath);
            fileOutputStream = new FileOutputStream(destFilePath);
            //定义一个字节数组,提高读取效果
            byte[] buf = new byte[1024];
            int readLen = 0;
            while ((readLen = fileInputStream.read(buf)) != -1) {
                //读取到后，就写入到文件 通过 fileOutputStream
                //即，是一边读，一边写
                fileOutputStream.write(buf, 0, readLen);//一定要使用这个方法
                // 不能用 fileOutputStream.write(buf) 因为最后有可能读不够而出错
            }
            System.out.println("拷贝ok");


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭输入流和输出流，释放资源
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
```

### FileReader 和FileWriter 介绍

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230504214459469.png)

### FileReader 相关方法

1) new FileReader(File/String)
2) read: 每次读取**单个字符**，返回该字符，如果到文件末尾返回-1
3) read(charD): 批量读取多个字符到数组，返回读取到的字符数，如果到文件未尾返回-1

相关API:

1) new String(charD):将char[]转换成String
2) new String(charl,off,len):将char[]的指定部分转换成String

### FileWriter 相关方法

1) new FileWriter(File/String):覆盖模式，相当于流的指针在首端
2) new FileWriter(File/String,true):追加模式，相当于流的指针在尾端
2) write(int):写入单个字符
4) write(char):写入指定数组
5) write(charl.off,.len):写入指定数组的指定部分6) write (string):写入整个字符串
6) write(string,off,len):写入字符串的指定部分

相关APl:  String类: toCharArray:将String转换成char[]

注意: **FileWriter使用后，必须要关闭(close)或刷新(flush)，否则写入不到指定的文件!**因为仅仅到了Java程序内存中。

### FileReader 和FileWriter 应用案例

1) 使用FileReader 从story.txt 读取内容，并显示

```java
package com.hspedu.reader_;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReader_ {
    public static void main(String[] args) {


    }

    /**
     * 单个字符读取文件
     */
    @Test
    public void readFile01() {
        String filePath = "e:\\story.txt";
        FileReader fileReader = null;
        int data = 0;
        //1. 创建FileReader对象
        try {
            fileReader = new FileReader(filePath);
            //循环读取 使用read, 单个字符读取
            while ((data = fileReader.read()) != -1) {
                System.out.print((char) data);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 字符数组读取文件
     */
    @Test
    public void readFile02() {
        System.out.println("~~~readFile02 ~~~");
        String filePath = "e:\\story.txt";
        FileReader fileReader = null;

        int readLen = 0;
        char[] buf = new char[8];
        //1. 创建FileReader对象
        try {
            fileReader = new FileReader(filePath);
            //循环读取 使用read(buf), 返回的是实际读取到的字符数
            //如果返回-1, 说明到文件结束
            while ((readLen = fileReader.read(buf)) != -1) {
                System.out.print(new String(buf, 0, readLen));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
```

2) 使用FileWriter 将“风雨之后，定见彩虹” 写入到note.txt 文件中, 注意细节.

```java
package com.hspedu.writer_;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriter_ {
    public static void main(String[] args) {

        String filePath = "e:\\note.txt";
        //创建FileWriter对象
        FileWriter fileWriter = null;
        char[] chars = {'a', 'b', 'c'};
        try {
            fileWriter = new FileWriter(filePath);//默认是覆盖写入
//            3) write(int):写入单个字符
            fileWriter.write('H');
//            4) write(char[]):写入指定数组
            fileWriter.write(chars);
//            5) write(char[],off,len):写入指定数组的指定部分
            fileWriter.write("教育".toCharArray(), 0, 3);
//            6) write（string）：写入整个字符串
            fileWriter.write(" 你好北京~");
            fileWriter.write("风雨之后，定见彩虹");
//            7) write(string,off,len):写入字符串的指定部分
            fileWriter.write("上海天津", 0, 2); // 输出上海，因为从offset0开始，写入两个字符
            //在数据量大的情况下，可以使用循环操作.


        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            // 对应FileWriter , 一定要关闭流，或者flush才能真正的把数据写入到文件
            // 看源码就知道原因.
            /*
                看看代码
                private void writeBytes() throws IOException {
        this.bb.flip();
        int var1 = this.bb.limit();
        int var2 = this.bb.position();

        assert var2 <= var1;

        int var3 = var2 <= var1 ? var1 - var2 : 0;
        if (var3 > 0) {
            if (this.ch != null) {
                assert this.ch.write(this.bb) == var3 : var3;
            } else {
                this.out.write(this.bb.array(), this.bb.arrayOffset() + var2, var3);
            }
        }

        this.bb.clear();
    }
             */
            try {
                //fileWriter.flush();
                //关闭文件流，等价于 flush() + 关闭
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        System.out.println("程序结束...");
    }
}
```

## 节点流和处理流

### 基本介绍

1. 节点流可以从一个特定的数据源读写数据，如FileReader、FileWriter

   ![image-20230504222403139](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230504222403139.png)

2. 处理流(也叫包装流)是“连接”在已存在的流（节点流或处理流)之上，为程序提供更为强大的读写功能，也更加灵活,如BufferedReader、BufferedWriter

   ![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230504222431589.png)

### 节点流和处理流一览图

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230504223251852.png)

### 节点流和处理流的区别和联系

1. 节点流是底层流/低级流,直接跟数据源相接。
2. 处理流(**包装流**)包装节点流，既可以消除不同节点流的实现差异，也可以提供更方
   便的方法来完成输入输出。
3. 处理流(也叫包装流)对节点流进行包装，使用了修饰器设计模式，**不会直接与数据**
   **源相连[模拟修饰器设计模式]**

```java
package com.hspedu;

public class StringReader_ extends Reader_ {
    public void readString() {
        System.out.println("读取字符串..");
    }
}
```

```java
package com.hspedu;

public class FileReader_ extends Reader_ {
        public void readFile() {
        System.out.println("对文件进行读取...");
    }
}
```

```java
package com.hspedu;

public abstract class Reader_ { //抽象类
    public void readFile() {
    }
    public void readString() {
    }

    //在Reader_ 抽象类，使用read方法统一管理.
    //后面在调用时，利于对象动态绑定机制， 绑定到对应的实现子类即可.
    //public abstract void read();
}
```

```java
package com.hspedu;

/**
 * 做成处理流/包装流
 */
public class BufferedReader_ extends Reader_{

    private Reader_ reader_; //属性是 Reader_类型

    //接收Reader_ 子类对象
    public BufferedReader_(Reader_ reader_) {
        this.reader_ = reader_;
    }

    public void readFile() { //封装一层
        reader_.readFile();
    }

    //让方法更加灵活， 多次读取文件, 或者加缓冲byte[] ....
    public void readFiles(int num) {
        for(int i = 0; i < num; i++) {
            reader_.readFile();
        }
    }

    //扩展 readString, 批量处理字符串数据
    public void readStrings(int num) {
        for(int i = 0; i <num; i++) {
            reader_.readString();
        }
    }

}
```

```java
package com.hspedu;

import java.io.*;

public class Test_ {
    public static void main(String[] args) {


        BufferedReader_ bufferedReader_ = new BufferedReader_(new FileReader_());
        bufferedReader_.readFiles(10);
        //bufferedReader_.readFile();
        //Serializable
        //Externalizable
        //ObjectInputStream
        //ObjectOutputStream
        //这次希望通过 BufferedReader_ 多次读取字符串
        BufferedReader_ bufferedReader_2 = new BufferedReader_(new StringReader_());
        bufferedReader_2.readStrings(5);
    }
}
```

### 处理流的功能

1. 性能的提高:主要以增加缓冲的方式来提高输入输出的效率。
2. 操作的便捷:处理流可能提供了一系列便捷的方法来一次输入输出大批量的数据,使用更加灵活方便。

### 处理流 BufferedReader 和BufferedWriter

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230504224522000.png)

BufferedReader 和 BufferedWriter属于字符流，是按照字符来读取数据的

关闭时处理流，只需要关闭外层流即可（因为真正工作的是内层流，关闭时只需要关闭外层处理流，会自动关闭内层流）【源码】

#### 应用案例

1. 使用BufferedReader读取文本文件，并显示在控制台

```java
package com.hspedu.reader_;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * 演示bufferedReader 使用
 */
public class BufferedReader_ {
    public static void main(String[] args) throws Exception {

        String filePath = "e:\\a.java";
        //创建bufferedReader
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        //读取
        String line; //按行读取, 效率高
        //说明
        //1. bufferedReader.readLine() 是按行读取文件
        //2. 当返回null 时，表示文件读取完毕
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }

        //关闭流, 这里注意，只需要关闭 BufferedReader ，因为底层会自动的去关闭 节点流
        //FileReader。
        /*
            public void close() throws IOException {
                synchronized (lock) {
                    if (in == null)
                        return;
                    try {
                        in.close();//in 就是我们传入的 new FileReader(filePath), 关闭了.
                    } finally {
                        in = null;
                        cb = null;
                    }
                }
            }

         */
        bufferedReader.close();

    }
}
```

2. 使用BufferedWriter将” hello，教育”，写入到文件中

```java
package com.hspedu.writer_;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 演示BufferedWriter的使用
 */
public class BufferedWriter_ {
    public static void main(String[] args) throws IOException {
        String filePath = "e:\\ok.txt";
        //创建BufferedWriter
        //说明:
        //1. new FileWriter(filePath, true) 表示以追加的方式写入
        //2. new FileWriter(filePath) , 表示以覆盖的方式写入
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));
        bufferedWriter.write("hello, 教育!");
        bufferedWriter.newLine();//插入一个和系统相关的换行
        bufferedWriter.write("hello2, 教育!");
        bufferedWriter.newLine();
        bufferedWriter.write("hello3, 教育!");
        bufferedWriter.newLine();
        //说明：关闭外层流即可 ， 传入的 new FileWriter(filePath) ,会在底层关闭
        bufferedWriter.close();

    }
}
```

3) 综合使用BufferedReader和 BufferedWriter完成文本文件拷贝，注意文件编码。

```java
package com.hspedu.writer_;

import java.io.*;

public class BufferedCopy_ {

    public static void main(String[] args) {


        //1. BufferedReader 和 BufferedWriter 是按照字符操作
        //2. 不要去操作 二进制文件[声音，视频，doc, pdf ], 可能造成文件损坏
        //BufferedInputStream
        //BufferedOutputStream
        String srcFilePath = "e:\\a.java";
        String destFilePath = "e:\\a2.java";
//        String srcFilePath = "e:\\0245_零基础学Java_引出this.avi";
//        String destFilePath = "e:\\a2.avi";
        BufferedReader br = null;
        BufferedWriter bw = null;
        String line;
        try {
            br = new BufferedReader(new FileReader(srcFilePath));
            bw = new BufferedWriter(new FileWriter(destFilePath));

            //说明: readLine 读取一行内容，但是没有换行
            while ((line = br.readLine()) != null) {
                //每读取一行，就写入
                bw.write(line);
                //插入一个换行
                bw.newLine();
            }
            System.out.println("拷贝完毕...");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            try {
                if(br != null) {
                    br.close();
                }
                if(bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
```

### 处理流BufferedInputStream 和BufferedOutputStream

BufferedInputStream是字节流在创建BufferedInputStream时，会创建一个内部缓冲区数组。

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230504225727950.png)

BufferedOutputStream是字节流, 实现缓冲的输出流, 可以将多个字节写入底层输出流中，而不必对每次字节写入调用底层系统。

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230504225853597.png)

#### 应用案例

要求: 编程完成图片/音乐的拷贝(要求使用Buffered..流).

```java
package com.hspedu.outputstream_;

import java.io.*;

/**
 * 演示使用BufferedOutputStream 和 BufferedInputStream使用
 * 使用他们，可以完成二进制文件拷贝.
 * 思考：字节流可以操作二进制文件，可以操作文本文件吗？当然可以
 */
public class BufferedCopy02 {
    public static void main(String[] args) {

//        String srcFilePath = "e:\\Koala.jpg";
//        String destFilePath = "e:\\hsp.jpg";
//        String srcFilePath = "e:\\0245_零基础学Java_引出this.avi";
//        String destFilePath = "e:\\hsp.avi";
        String srcFilePath = "e:\\a.java";
        String destFilePath = "e:\\a3.java";

        //创建BufferedOutputStream对象BufferedInputStream对象
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            //因为 FileInputStream  是 InputStream 子类
            bis = new BufferedInputStream(new FileInputStream(srcFilePath));
            bos = new BufferedOutputStream(new FileOutputStream(destFilePath));

            //循环的读取文件，并写入到 destFilePath
            byte[] buff = new byte[1024];
            int readLen = 0;
            //当返回 -1 时，就表示文件读取完毕
            while ((readLen = bis.read(buff)) != -1) {
                bos.write(buff, 0, readLen);
            }

            System.out.println("文件拷贝完毕~~~");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            //关闭流 , 关闭外层的处理流即可，底层会去关闭节点流
            try {
                if(bis != null) {
                    bis.close();
                }
                if(bos != null) {
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
```

### 对象流ObjectInputStream 和ObjectOutputStream

看一个需求：不仅需要保存值，还需要保存数据类型。

1. 将int num = 100这个 int数据保存到文件中,注意不是100 数字，而是int 100，并且，能够从文件中直接恢复int 100
2. 将Dog dog = new Dog(“小黄”，3)这个 dog对象保存到文件中，并且能够从文件恢复.

3. 上面的要求，就是能够将基本数据类型或者对象进行序列化和反序列化操作

序列化和反序列化

1. 序列化就是在保存数据时，保存数据的值和数据类型
2. 反序列化就是在恢复数据时，恢复数据的值和数据类型
3. 需要让某个对象支持序列化机制，则必须让其类是可序列化的，为了让某个类是可序列化的，该类必须实现如下两个接口之一:
   + Serializable //这是一个标记接口,没有方法
   + Externalizable //该接口有方法需要实现，因此我们一般实现上面的接口

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230505105002683.png)

### 对象流介绍

功能：提供了对基本类型或对象类型的序列化和反序列化的方法

+ ObjectOutputStream 提供序列化功能
+ ObjectInputStream 提供反序列化功能

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230505105036115.png)

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230505105047930.png)

#### 应用案例

1. 使用ObjectOutputStream序列化基本数据类型和一个Dog对象(name, age),并
   保存到data.dat文件中。

```java
package com.hspedu.outputstream_;

import java.io.Serializable;

// 如果需要序列化某个类的对象，实现 Serializable
public class Dog implements Serializable {
    private String name;
    private int age;
    // 序列化对象时，默认将里面所有属性都进行序列化，但除了static或transient修饰的成员
    private static String nation;
    private transient String color;
    // 序列化对象时，要求里面属性的类型也需要实现序列化接口
    private Master master = new Master();

    //serialVersionUID 序列化的版本号，可以提高兼容性
    private static final long serialVersionUID = 1L;

    public Dog(String name, int age, String nation, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.nation = nation;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}' + nation + " " +master;
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

```java
package com.hspedu.outputstream_;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 演示ObjectOutputStream的使用, 完成数据的序列化
 */
public class ObjectOutStream_ {
    public static void main(String[] args) throws Exception {
        //序列化后，保存的文件格式，不是存文本，而是按照他的格式来保存
        String filePath = "e:\\data.dat";

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));

        //序列化数据到 e:\data.dat
        oos.writeInt(100);// int -> Integer (Integer 实现了 Serializable)
        oos.writeBoolean(true);// boolean -> Boolean (实现了 Serializable)
        oos.writeChar('a');// char -> Character (实现了 Serializable)
        oos.writeDouble(9.5);// double -> Double (实现了 Serializable)
        oos.writeUTF("教育");//String
        //保存一个dog对象
        oos.writeObject(new Dog("旺财", 10, "日本", "白色"));
        oos.close();
        System.out.println("数据保存完毕(序列化形式)");
    }
}
```

2. 使用ObjectlnputStream 读取data.dat 并反序列化恢复数据

```java
package com.hspedu.inputstream_;



import com.hspedu.outputstream_.Dog;

import java.io.*;

public class ObjectInputStream_ {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //指定反序列化的文件
        String filePath = "e:\\data.dat";

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));

        //读取
        //1. 读取(反序列化)的顺序需要和你保存数据(序列化)的顺序一致，因为保存按顺序保存什么样的类型，读取的时候也就要按照相应的类型。
        //2. 否则会出现异常

        System.out.println(ois.readInt());
        System.out.println(ois.readBoolean());

        System.out.println(ois.readChar());
        System.out.println(ois.readDouble());
        System.out.println(ois.readUTF());


        //dog 的编译类型是 Object , dog 的运行类型是 Dog
        Object dog = ois.readObject();
        System.out.println("运行类型=" + dog.getClass());
        System.out.println("dog信息=" + dog);//底层 Object -> Dog

        //这里是特别重要的细节:

        //1. 如果我们希望调用Dog的方法, 需要向下转型
        //2. 需要我们将Dog类的定义，放在到可以引用的位置
        Dog dog2 = (Dog)dog;
        System.out.println(dog2.getName()); //旺财..

        //关闭流, 关闭外层流即可，底层会关闭 FileInputStream 流
        ois.close();
    }
}
```

```java
package com.hspedu.outputstream_;

import java.io.Serializable;

// 如果需要序列化某个类的对象，实现 Serializable
public class Dog implements Serializable {
    private String name;
    private int age;
    // 序列化对象时，默认将里面所有属性都进行序列化，但除了static或transient修饰的成员
    private static String nation;
    private transient String color;
    // 序列化对象时，要求里面属性的类型也需要实现序列化接口
    private Master master = new Master();

    //serialVersionUID 序列化的版本号，可以提高兼容性
    private static final long serialVersionUID = 1L;

    public Dog(String name, int age, String nation, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.nation = nation;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}' + nation + " " +master;
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

注意事项和细节说明

1) 读写顺序要一致。

2) 要求序列化或反序列化对象，需要实现`Serializable`。

3) 序列化的类中建议添加`SerialVersionUID`，为了提高版本的兼容性。当加入新属性时，序列化和反序列化会认为是原来的修改版，而不会认为是一个全新的类。

   ```java
   private static final long serialVersionUID = 1L;
   ```

4) 序列化对象时，默认将里面所有属性都进行序列化，但除了static或transient修饰的成员。也就是序列化并不保存`static`或`transient`修饰的信息。

5) 序列化对象时，**要求里面属性的类型也需要实现序列化接口**。

6) 序列化具备可继承性，也就是如果某类已经实现了序列化，则它的所有子类也已经默认实现了序列化。

### 标准输入输出流

#### 介绍

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230505143954058.png)

#### 应用案例1

传统方法System.out.println("");是使用out 对象将数据输出到显示器

#### 应用案例2

传统的方法, Scanner是从标准输入键盘接收数据

```java
package com.hspedu.standard;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class InputAndOutput {
    public static void main(String[] args) {
        //System 类的 public final static InputStream in = null;
        // System.in 编译类型   InputStream
        // System.in 运行类型   BufferedInputStream
        // 表示的是标准输入 键盘
        System.out.println(System.in.getClass());

        //1. System.out public final static PrintStream out = null;
        //2. 编译类型 PrintStream
        //3. 运行类型 PrintStream
        //4. 表示标准输出 显示器
        System.out.println(System.out.getClass());

        System.out.println("hello, 教育");

        Scanner scanner = new Scanner(System.in);
        System.out.println("输入内容");
        String next = scanner.next();
        System.out.println("next=" + next);
    }
}
```

### 转换流InputStreamReader 和OutputStreamWriter

文件乱码问题，引出学习转换流必要性。

可以这么理解：相当于把InputStream转为Reader，把OutputStream转为Writer。

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230505150501094.png)

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230505150643496.png)

1. InputStreamReader:Reader的子类，可以将InputStream(字节流)包装成(转换)Reader(字符流)
1. OutputStreamWriter:Writer的子类，实现将OutputStream(字节流)
包装成Writer(字符流)
1. 当处理纯文本数据时，如果使用字符流效率更高，并且可以有效解决中文
问题,所以建议将字节流转换成字符流。
4. 可以在使用时指定编码格式(比如utf-8, gbk , gb2312,ISO8859-1等)

#### 应用案例

1.编程将字节流FilelnputStream包装成(转换成)字符流InputStreamReader,对
文件进行读取(按照utf-8/gbk格式),进而包装成 BufferedReader

```java
package com.hspedu.transformation;

import java.io.*;

/**
 * 演示使用 InputStreamReader 转换流解决中文乱码问题
 * 将字节流 FileInputStream 转成字符流  InputStreamReader, 指定编码 gbk/utf-8
 */
public class InputStreamReader_ {
    public static void main(String[] args) throws IOException {

        String filePath = "e:\\a.txt";
        //解读
        //1. 把 FileInputStream 转成 InputStreamReader
        //2. 指定编码 gbk
        //InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath), "gbk");
        //3. 把 InputStreamReader 传入 BufferedReader
        //BufferedReader br = new BufferedReader(isr);

        //将2 和 3 合在一起
        BufferedReader br = new BufferedReader(new InputStreamReader(
                                                    new FileInputStream(filePath), "gbk"));

        //4. 读取
        String s = br.readLine();
        System.out.println("读取内容=" + s);
        //5. 关闭外层流
        br.close();
    }
}
```

2. 编程将字节流 FileOutputStream包装成(转换成)字符流OutputStreamWriter,对文件进行写入(按照gbk格式,可以指定其他，比如utf-8)

```java
package com.hspedu.transformation;

import java.io.*;

/**
 * 演示 OutputStreamWriter 使用
 * 把FileOutputStream 字节流，转成字符流 OutputStreamWriter
 * 指定处理的编码 gbk/utf-8/utf8
 */
public class OutputStreamWriter_ {
    public static void main(String[] args) throws IOException {
        String filePath = "e:\\hsp.txt";
        String charSet = "utf-8";
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(filePath), charSet);
        osw.write("hi, 教育");
        osw.close();
        System.out.println("按照 " + charSet + " 保存文件成功~");
    }
}
```

### 打印流PrintStream 和PrintWriter

打印流只有输出流，没有输入流

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230505151904868.png)

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230505151913510.png)

```java
package com.hspedu.printstream;

import java.io.IOException;
import java.io.PrintStream;

/**
 * 演示PrintStream （字节打印流/输出流）
 */
public class PrintStream_ {
    public static void main(String[] args) throws IOException {

        PrintStream out = System.out;
        //在默认情况下，PrintStream 输出数据的位置是 标准输出，即显示器
        /*
             public void print(String s) {
                if (s == null) {
                    s = "null";
                }
                write(s); //!!!
            }

         */
        out.print("john, hello");
        // 因为print底层使用的是write , 所以我们可以直接调用write进行打印/输出
        out.write("你好".getBytes());
        out.close();

        //我们可以去修改打印流输出的位置/设备
        //1. 输出修改成到 "e:\\f1.txt"
        //2. "hello, 教育~" 就会输出到 e:\f1.txt
        //3. 源码：
        // public static void setOut(PrintStream out) {
        //        checkIO();
        //        setOut0(out); // native 方法，修改了out
        //   }
        System.setOut(new PrintStream("e:\\f1.txt"));
        System.out.println("hello, 教育~");
    }
}
```

```java
package com.hspedu.transformation;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 演示 PrintWriter 使用方式
 */
public class PrintWriter_ {
    public static void main(String[] args) throws IOException {

        //PrintWriter printWriter = new PrintWriter(System.out); // 输出到显示器
        PrintWriter printWriter = new PrintWriter(new FileWriter("e:\\f2.txt"));
        printWriter.print("hi, 北京你好~~~~");
        printWriter.close();//flush + 关闭流, 才会将数据写入到文件..

    }
}
```

## Properties 类

看一个需求

如下一个配置文件mysql.properties

+ ip=192.168.0.13
+ user=root
+ pwd=12345

请问编程读取ip. user 和pwd的值是多少

分析

1. 传统的方法
2. 使用Properties类可以方便实现

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230505152730678.png)

```java
package com.hspedu.properties_;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Properties01 {
    public static void main(String[] args) throws IOException {


        //读取mysql.properties 文件，并得到ip, user 和 pwd
        BufferedReader br = new BufferedReader(new FileReader("src\\mysql.properties"));
        String line = "";
        while ((line = br.readLine()) != null) { //循环读取
            String[] split = line.split("=");
            //如果我们要求指定的ip值
            if("ip".equals(split[0])) {
                System.out.println(split[0] + "值是: " + split[1]);
            }
        }
        br.close();
    }
}
```

### 基本介绍

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230505153142477.png)

1) 专门用于读写配置文件的集合类

   配置文件的格式:

   > 键=值
   >
   > 键=值

2) 注意:键值对不需要有空格，值不需要用引号一起来。默认类型是String

3. Properties的常见方法

+ load:加载配置文件的键值对到Properties对象
+ list:将数据显示到指定设备
+ getProperty(key):根据键获取值
+ setProperty(key,value):设置键值对到Properties对象
+ store:将Properties中的键值对存储到配置文件,在idea中，保存信息到配置文件，如果含有中文，会存储为unicode码
  http://tool.chinaz.com/tools/unicode.aspx  unicode码查询工具

### 应用案例

1.使用Properties类完成对mysql.properties的读取,看老师代码演示

```java
package com.hspedu.properties_;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Properties02 {
    public static void main(String[] args) throws IOException {
        //使用Properties 类来读取mysql.properties 文件

        //1. 创建Properties 对象
        Properties properties = new Properties();
        //2. 加载指定配置文件
        properties.load(new FileReader("src\\mysql.properties"));
        //3. 把k-v显示控制台
        properties.list(System.out);
        //4. 根据key 获取对应的值
        String user = properties.getProperty("user");
        String pwd = properties.getProperty("pwd");
        System.out.println("用户名=" + user);
        System.out.println("密码是=" + pwd);
    }
}
```

2.使用Properties类添加key-val 到新文件mysql2.properties中

3.使用Properties类完成对 mysq12.properties 的读取，并修改某个key-val

```JAVA
package com.hspedu.properties_;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Properties03 {
    public static void main(String[] args) throws IOException {
        //使用Properties 类来创建 配置文件, 修改配置文件内容

        Properties properties = new Properties();
        //创建
        //1. 如果该文件没有key 就是创建!!
        //2. 如果该文件有key ,就是修改!!
        /*
            Properties 父类是 Hashtable ， 底层就是Hashtable 核心方法
            public synchronized V put(K key, V value) {
                // Make sure the value is not null
                if (value == null) {
                    throw new NullPointerException();
                }

                // Makes sure the key is not already in the hashtable.
                Entry<?,?> tab[] = table;
                int hash = key.hashCode();
                int index = (hash & 0x7FFFFFFF) % tab.length;
                @SuppressWarnings("unchecked")
                Entry<K,V> entry = (Entry<K,V>)tab[index];
                for(; entry != null ; entry = entry.next) {
                    if ((entry.hash == hash) && entry.key.equals(key)) {
                        V old = entry.value;
                        entry.value = value;//如果key 存在，就替换
                        return old;
                    }
                }

                addEntry(hash, key, value, index);//如果是新k, 就addEntry
                return null;
            }

         */
        properties.setProperty("charset", "utf8");
        properties.setProperty("user", "汤姆");//注意保存时，是中文的 unicode码值
        properties.setProperty("pwd", "888888");

        //将k-v 存储文件中即可
        properties.store(new FileOutputStream("src\\mysql2.properties"), null);
        System.out.println("保存配置文件成功~");

    }
}
```

## 本章作业

1.编程题

(1)在判断e盘下是否有文件夹mytemp ,如果没有就创建mytemp

(2)在e:llmytemp目录下，创建文件hello.txt

(3)如果hello.txt已经存在，提示该文件已经存在,就不要再重复创建了

(4)并且在hello.txt文件中，写入hello,world~

```java
package com.hspedu.homework;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Homework01 {
    public static void main(String[] args) throws IOException {
        /**
         *(1) 在判断 e 盘下是否有文件夹mytemp ,如果没有就创建mytemp
         *(2) 在e:\\mytemp 目录下, 创建文件 hello.txt
         *(3) 如果hello.txt 已经存在，提示该文件已经存在，就不要再重复创建了
         *(4) 并且在hello.txt 文件中，写入 hello,world~
         */

        String directoryPath = "e:\\mytemp";
        File file = new File(directoryPath);
        if(!file.exists()) {
            //创建
            if(file.mkdirs()) {
                System.out.println("创建 " + directoryPath + " 创建成功" );
            }else {
                System.out.println("创建 " + directoryPath + " 创建失败");
            }
        }

        String filePath  = directoryPath + "\\hello.txt";// e:\mytemp\hello.txt
        file = new File(filePath);
        if(!file.exists()) {
            //创建文件
            if(file.createNewFile()) {
                System.out.println(filePath + " 创建成功~");

                //如果文件存在，我们就使用BufferedWriter 字符输入流写入内容
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
                bufferedWriter.write("hello, world~~ 教育");
                bufferedWriter.close();

            } else {
                System.out.println(filePath + " 创建失败~");
            }
        } else {
            //如果文件已经存在，给出提示信息
            System.out.println(filePath + " 已经存在，不在重复创建...");
        }
    }
}
```

2.编程题
要求:使用BufferedReader读取一个文本文件，为每行加上行号，再连同内容一并输出到屏幕上。

//如果把文件的编码改成了 gbk，出现中文乱码，大家思考如何解决

//1.默认是按照utf-8处理,开始没有乱码

//2.提示:使用我们的转换流，将FilelnputStream -> InputStreamReader[可以指定编码]- >BufferedReader ...

```java
package com.hspedu.homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Homework02 {
    public static void main(String[] args) {
        /**
         * 要求:  使用BufferedReader读取一个文本文件，为每行加上行号，
         * 再连同内容一并输出到屏幕上。
         */
        String filePath = "e:\\a.txt";
        BufferedReader br = null;
        String line = "";
        int lineNum = 0;
        try {
            br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null) { //循环读取
                System.out.println(++lineNum + line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if(br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
```

3.编程题
(1)要编写一个dog.properties

+ name=tom
+ age=5
+ color=red

(2)编写Dog 类(name,age,color)创建一个dog对象，读取dog.properties用相应的内容完成属性初始化,并输出

(3)将创建的Dog对象,序列化到文件dog.dat 文件

```java
package com.hspedu.homework;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Properties;

public class Homework03 {
    public static void main(String[] args) throws IOException {
        /**
         * (1) 要编写一个dog.properties   name=tom age=5 color=red
         * (2) 编写 Dog 类(name,age,color)  创建一个dog对象，读取dog.properties 用相应的内容完成属性初始化, 并输出
         * (3) 将创建的Dog 对象 ，序列化到 文件 e:\\dog.dat 文件
         */
        String filePath = "src\\dog.properties";
        Properties properties = new Properties();
        properties.load(new FileReader(filePath));
        String name = properties.get("name") + ""; //Object -> String
        int age = Integer.parseInt(properties.get("age") + "");// Object -> int
        String color = properties.get("color") + "";//Object -> String

        Dog dog = new Dog(name, age, color);
        System.out.println("===dog对象信息====");
        System.out.println(dog);

        //将创建的Dog 对象 ，序列化到 文件 dog.dat 文件
        String serFilePath = "e:\\dog.dat";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(serFilePath));
        oos.writeObject(dog);

        //关闭流
        oos.close();
        System.out.println("dog对象，序列化完成...");
    }

    //在编写一个方法，反序列化dog
    @Test
    public void m1() throws IOException, ClassNotFoundException {
        String serFilePath = "e:\\dog.dat";
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(serFilePath));
        Dog dog = (Dog)ois.readObject();

        System.out.println("===反序列化后 dog====");
        System.out.println(dog);

        ois.close();

    }
}

class Dog implements  Serializable{
    private String name;
    private int age;
    private String color;

    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}
```