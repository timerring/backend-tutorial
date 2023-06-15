- [第21章 网络编程](#第21章-网络编程)
  - [网络的相关概念](#网络的相关概念)
    - [网络通信](#网络通信)
    - [网络](#网络)
    - [ip 地址](#ip-地址)
    - [ipv4 地址分类](#ipv4-地址分类)
    - [域名](#域名)
    - [网络通信协议](#网络通信协议)
    - [TCP 和 UDP](#tcp-和-udp)
  - [InetAddress 类](#inetaddress-类)
    - [相关方法](#相关方法)
    - [应用案例](#应用案例)
  - [Socket](#socket)
    - [基本介绍](#基本介绍)
  - [TCP 网络通信编程](#tcp-网络通信编程)
    - [基本介绍](#基本介绍-1)
    - [应用案例1(使用字节流)](#应用案例1使用字节流)
    - [应用案例2(使用字节流)](#应用案例2使用字节流)
    - [应用案例3(使用字符流)](#应用案例3使用字符流)
    - [应用案例4](#应用案例4)
    - [netstat 指令](#netstat-指令)
    - [TCP 网络通讯](#tcp-网络通讯)
  - [UDP 网络通信编程](#udp-网络通信编程)
    - [基本介绍](#基本介绍-2)
    - [基本流程](#基本流程)
    - [应用案例](#应用案例-1)
  - [本章作业](#本章作业)


# 第21章 网络编程

## 网络的相关概念

### 网络通信

1. 概念:两台设备之间通过网络实现数据传输
2. 网络通信:将数据通过网络从一台设备传输到另一台设备
3. java.net包下提供了一系列的类或接口，供程序员使用，完成网络通信

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230505183011731.png)

### 网络

1. 概念:两台或多台设备通过一定物理设备连接起来构成了网络
2. 根据网络的覆盖范围不同，对网络进行分类:

+ 局域网:覆盖范围最小,仅仅覆盖一个教室或一个机房
+ 城域网:覆盖范围较大，可以覆盖一个城市
+ 广域网:覆盖范围最大，可以覆盖全国,甚至全球,万维网是广域网的代表

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230505183139864.png)

### ip 地址

1. 概念:用于唯一标识网络中的每台计算机/主机
2. 查看ip地址: `ipconfig`

3. ip地址的表示形式: 点分十进制XX.XX.XX.XX
3. 每一个十进制数的范围:0~255
5. ip地址的组成=网络地址+主机地址，比如:192.168.16.69
6. iPv6是互联网工程任务组设计的用于替代IPv4的下一代IP协议，其地址数量号称可以为全世界的每一粒沙子编上一个地址。
7. 由于IPv4最大的问题在于网络地址资源有限，严重制约了互联网的应用和发展。IPv6的使用，不仅能解决网络地址资源数量的问题，而且也解决了多种接入设备连入互联网的障碍。

### ipv4 地址分类

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230505190722478.png)

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230505190735226.png)

特殊的：127.0.0.1表示本机地址

### 域名

1. www.baidu.com
2. 好处: 为了方便记忆，解决记`ip`的困难
3. 概念: 将`ip`地址映射成域名，这里怎么映射上——HTTP协议

端口号

1. 概念: **用于标识计算机上某个特定的网络程序**
2. 表示形式: 以整数形式，端口范围0~65535 [2个字节表示端口 0\~2^16-1]
3. 0\~1024已经被占用, 比如ssh 22, ftp 21, smtp 25 http 80
4. 常见的网络程序端口号
   + tomcat: 8080
   + mysql: 3306
   + oracle: 1521
   + sqlserver: 1433

### 网络通信协议

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230505201224378.png)

协议(tcp/ip)

TCP/IP (Transmission Control Protocol/Internet Protocol) 的简写,中文译名为传输控制协议/因特网互联协议,又叫网络通讯协议,这个协议是lnternet最基本的协议、Internet国际互联网络的基础,简单地说,就是由网络层的IP协议和传输层的TCP协议组成的。

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230505201705183.png)

### TCP 和 UDP

TCP协议:传输控制协议

1. 使用TCP协议前,须先建立TCP连接,形成传输数据通道
2. 传输前,采用“三次握手"方式,是可靠的
3. TCP协议进行通信的两个应用进程: 客户端、服务端
4. 在连接中可进行大数据量的传输
5. 传输完毕，**需释放已建立的连接, 效率低**

UDP协议:用户数据协议

1. 将数据、源、目的封装成数据包,不需要建立连接
2. 每个数据报的大小限制在64K内,不适合传输大量数据
3. 因无需连接,故是不可靠的
4. 发送数据结束时无需释放资源(因为不是面向连接的)，速度快

## InetAddress 类

### 相关方法

1. 获取本机InetAddress对象getLocalHost
2. 根据指定主机名/域名获取ip地址对象getByName
3. 获取InetAddress对象的主机名getHostName
4. 获取InetAddress对象的地址getHostAddress

### 应用案例

编写代码，获取计算机的主机名和IP 地址相关API

```java
package com.hspedu.api;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 演示InetAddress 类的使用
 */
public class API_ {
    public static void main(String[] args) throws UnknownHostException {

        //1. 获取本机的InetAddress 对象
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);//DESKTOP-S4MP84S/192.168.12.1

        //2. 根据指定主机名 获取 InetAddress对象
        InetAddress host1 = InetAddress.getByName("DESKTOP-S4MP84S");
        System.out.println("host1=" + host1);//DESKTOP-S4MP84S/192.168.12.1

        //3. 根据域名返回 InetAddress对象, 比如 www.baidu.com 对应
        InetAddress host2 = InetAddress.getByName("www.baidu.com");
        System.out.println("host2=" + host2);//www.baidu.com / 110.242.68.4

        //4. 通过 InetAddress 对象，获取对应的地址
        String hostAddress = host2.getHostAddress();//IP 110.242.68.4
        System.out.println("host2 对应的ip = " + hostAddress);//110.242.68.4

        //5. 通过 InetAddress 对象，获取对应的主机名/或者的域名
        String hostName = host2.getHostName();
        System.out.println("host2对应的主机名/域名=" + hostName); // www.baidu.com
    }
}
```

## Socket

### 基本介绍

1. 套接字(Socket)开发网络应用程序被广泛采用，以至于成为事实上的标准。
2. 通信的两端都要有Socket，是两台机器间通信的端点。
3. 网络通信其实就是Socket间的通信。
4. Socket允许程序把网络连接当成一个流，数据在两个Socket间通过IO传输。
5. 一般主动发起通信的应用程序属客户端,等待通信请求的为服务端。

示意图

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230505205108186.png)

## TCP 网络通信编程

### 基本介绍

1. 基于客户端—服务端的网络通信
2. 底层使用的是TCP/IP协议
3. 应用场景举例: 客户端发送数据，服务端接受并显示控制台
4. 基于Socket的TCP编程

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230505205253891.png)

最后需要关闭socket，不然链接太多会出现问题。

### 应用案例1(使用字节流)

1. 编写一个服务器端,和一个客户端
2. 服务器端在9999端口监听
3. 客户端连接到服务器端,发送"hello, server"，然后退出
4. 服务器端接收到客户端发送的信息，输出，并退出

ServerSocket 可以通过 accept() 返回多个Socket[多个客户端连接服务器的并发]

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230505205847772.png)

```java
package com.hspedu.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 客户端，发送 "hello, server" 给服务端
 */
public class SocketTCP01Client {
    public static void main(String[] args) throws IOException {
        //思路
        //1. 连接服务端 (ip , 端口）
        //解读: 连接本机的 9999端口, 如果连接成功，返回Socket对象
        // 如果链接网络，第一个参数可以改为IP
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端 socket返回=" + socket.getClass());
        //2. 连接上后，生成Socket, 通过socket.getOutputStream()
        //   得到 和 socket对象关联的输出流对象
        OutputStream outputStream = socket.getOutputStream();
        //3. 通过输出流，写入数据到 数据通道
        outputStream.write("hello, server".getBytes());
        //4. 关闭流对象和socket, 必须关闭
        outputStream.close();
        socket.close();
        System.out.println("客户端退出.....");
    }
}
```

```java
package com.hspedu.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 */
public class SocketTCP01Server {
    public static void main(String[] args) throws IOException {
        //思路
        //1. 在本机 的9999端口监听, 等待连接
        //   细节: 要求在本机没有其它服务在监听9999
        //   细节：这个 ServerSocket 可以通过 accept() 返回多个Socket[多个客户端连接服务器的并发]
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端，在9999端口监听，等待连接..");
        //2. 当没有客户端连接9999端口时，程序会 阻塞, 等待连接
        //   如果有客户端连接，则会返回Socket对象，程序继续

        Socket socket = serverSocket.accept();

        System.out.println("服务端 socket =" + socket.getClass());
        //
        //3. 通过socket.getInputStream() 读取客户端写入到数据通道的数据, 显示
        InputStream inputStream = socket.getInputStream();
        //4. IO读取
        byte[] buf = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(buf)) != -1) {
            System.out.println(new String(buf, 0, readLen));//根据读取到的实际长度，显示内容.
        }
        //5.关闭流和socket
        inputStream.close();
        socket.close();
        serverSocket.close();// 最后也需要关闭
    }
}
```

### 应用案例2(使用字节流)

1. 编写一个服务端,和一个客户端。
2. 服务器端在9999端口监听。
3. 客户端连接到服务端,发送"hello, server",并接收服务器端回发的"hello,client",再退出。
4. 服务器端接收到客户端发送的信息,输出，并发送"hello, client".再退出。

注意：设置结束标记。确保输出结束。

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230505211442135.png)

```java
package com.hspedu.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 */
@SuppressWarnings({"all"})
public class SocketTCP02Server {
    public static void main(String[] args) throws IOException {
        //思路
        //1. 在本机 的9999端口监听, 等待连接
        //   细节: 要求在本机没有其它服务在监听9999
        //   细节：这个 ServerSocket 可以通过 accept() 返回多个Socket[多个客户端连接服务器的并发]
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端，在9999端口监听，等待连接..");
        //2. 当没有客户端连接9999端口时，程序会 阻塞, 等待连接
        //   如果有客户端连接，则会返回Socket对象，程序继续

        Socket socket = serverSocket.accept();

        System.out.println("服务端 socket =" + socket.getClass());
        //
        //3. 通过socket.getInputStream() 读取客户端写入到数据通道的数据, 显示
        InputStream inputStream = socket.getInputStream();
        //4. IO读取
        byte[] buf = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(buf)) != -1) {
            System.out.println(new String(buf, 0, readLen));//根据读取到的实际长度，显示内容.
        }
        //5. 获取socket相关联的输出流
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello, client".getBytes());
        // 设置结束标记
        socket.shutdownOutput();

        //6.关闭流和socket
        outputStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();//关闭

    }
}
```

```java
package com.hspedu.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 客户端，发送 "hello, server" 给服务端
 */
@SuppressWarnings({"all"})
public class SocketTCP02Client {
    public static void main(String[] args) throws IOException {
        //思路
        //1. 连接服务端 (ip , 端口）
        //解读: 连接本机的 9999端口, 如果连接成功，返回Socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端 socket返回=" + socket.getClass());
        //2. 连接上后，生成Socket, 通过socket.getOutputStream()
        //   得到 和 socket对象关联的输出流对象
        OutputStream outputStream = socket.getOutputStream();
        //3. 通过输出流，写入数据到 数据通道
        outputStream.write("hello, server".getBytes());
        //   设置结束标记
        socket.shutdownOutput();

        //4. 获取和socket关联的输入流. 读取数据(字节)，并显示
        InputStream inputStream = socket.getInputStream();
        byte[] buf = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(buf)) != -1) {
            System.out.println(new String(buf, 0, readLen));
        }

        //5. 关闭流对象和socket, 必须关闭
        inputStream.close();
        outputStream.close();
        socket.close();
        System.out.println("客户端退出.....");
    }
}
```

### 应用案例3(使用字符流)

1. 编写一个服务端,和一个客户端
2. 服务端在9999端口监听
3. 客户端连接到服务端，发送"hello, server”,并接收服务端回发的“hello,client",，再退出
4. 服务端接收到客户端发送的信息，输出，并发送"hello, client"，再退出

**这里结束标记也可以采用 `writer.newLine();`，但是这要求对方读取必须使用 `readLine()` 。**

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230505213044045.png)

```java
package com.hspedu.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 客户端，发送 "hello, server" 给服务端， 使用字符流
 */
@SuppressWarnings({"all"})
public class SocketTCP03Client {
    public static void main(String[] args) throws IOException {
        //思路
        //1. 连接服务端 (ip , 端口）
        //解读: 连接本机的 9999端口, 如果连接成功，返回Socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端 socket返回=" + socket.getClass());
        //2. 连接上后，生成Socket, 通过socket.getOutputStream()
        //   得到 和 socket对象关联的输出流对象
        OutputStream outputStream = socket.getOutputStream();
        //3. 通过输出流，写入数据到 数据通道, 使用字符流
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello, server 字符流");
        bufferedWriter.newLine();//插入一个换行符，表示写入的内容结束, 注意，要求对方使用readLine()!!!!
        bufferedWriter.flush();// 如果使用的字符流，需要手动刷新，否则数据不会写入数据通道


        //4. 获取和socket关联的输入流. 读取数据(字符)，并显示
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);

        //5. 关闭流对象和socket, 必须关闭
        bufferedReader.close();//关闭外层流
        bufferedWriter.close();
        socket.close();
        System.out.println("客户端退出.....");
    }
}
```

```java
package com.hspedu.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端, 使用字符流方式读写
 */
@SuppressWarnings({"all"})
public class SocketTCP03Server {
    public static void main(String[] args) throws IOException {
        //思路
        //1. 在本机 的9999端口监听, 等待连接
        //   细节: 要求在本机没有其它服务在监听9999
        //   细节：这个 ServerSocket 可以通过 accept() 返回多个Socket[多个客户端连接服务器的并发]
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端，在9999端口监听，等待连接..");
        //2. 当没有客户端连接9999端口时，程序会 阻塞, 等待连接
        //   如果有客户端连接，则会返回Socket对象，程序继续

        Socket socket = serverSocket.accept();

        System.out.println("服务端 socket =" + socket.getClass());
        //
        //3. 通过socket.getInputStream() 读取客户端写入到数据通道的数据, 显示
        InputStream inputStream = socket.getInputStream();
        //4. IO读取, 使用字符流, 老师使用 InputStreamReader 将 inputStream 转成字符流
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);//输出

        //5. 获取socket相关联的输出流
        OutputStream outputStream = socket.getOutputStream();
       //    使用字符输出流的方式回复信息
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello client 字符流");
        bufferedWriter.newLine();// 插入一个换行符，表示回复内容的结束
        bufferedWriter.flush();//注意需要手动的flush

        //6.关闭流和socket
        bufferedWriter.close();
        bufferedReader.close();
        socket.close();
        serverSocket.close();//关闭
    }
}
```

### 应用案例4

1. 编写一个服务端,和一个客户端
2. 服务器端在8888端口监听
3. 客户端连接到服务端,发送一张图片e:llqie.png
4. 服务器端接收到客户端发送的图片，保存到src下,发送“收到图片"再退出
5. 客户端接收到服务端发送的“收到图片”，再退出
6. 该程序要求使用StreamUtils.java, 我们直接使用其中封装好的方法。

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230505215837515.png)

```java
package com.hspedu.upload;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;


/**
 * 文件上传的客户端
 */
public class TCPFileUploadClient {
    public static void main(String[] args) throws Exception {

        //客户端连接服务端 8888，得到Socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        //创建读取磁盘文件的输入流
        //String filePath = "e:\\qie.png";
        String filePath = "e:\\abc.mp4";
        BufferedInputStream bis  = new BufferedInputStream(new FileInputStream(filePath));

        // 把文件读到字符数组中!!!!!
        // bytes 就是filePath对应的字节数组
        byte[] bytes = StreamUtils.streamToByteArray(bis);

        //通过socket获取到输出流, 将bytes数据发送给服务端
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(bytes); //将文件对应的字节数组的内容，写入到数据通道
        bis.close();
        socket.shutdownOutput(); //设置写入数据的结束标记

        //=====接收从服务端回复的消息=====

        InputStream inputStream = socket.getInputStream();
        //使用StreamUtils 的方法，直接将 inputStream 读取到的内容 转成字符串
        String s = StreamUtils.streamToString(inputStream);
        System.out.println(s);


        //关闭相关的流
        inputStream.close();
        bos.close();
        socket.close();

    }
}
```

```java
package com.hspedu.upload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 文件上传的服务端
 */
public class TCPFileUploadServer {
    public static void main(String[] args) throws Exception {

        //1. 服务端在本机监听8888端口
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务端在8888端口监听....");
        //2. 等待连接
        Socket socket = serverSocket.accept();


        //3. 读取客户端发送的数据
        //   通过Socket得到输入流
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        byte[] bytes = StreamUtils.streamToByteArray(bis); // 已然读到数组中了
        //4. 将得到 bytes 数组，写入到指定的路径，就得到一个文件了
        String destFilePath = "src\\abc.mp4";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFilePath));
        bos.write(bytes);
        bos.close();

        // 向客户端回复 "收到图片"
        // 通过socket 获取到输出流(字符)
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        writer.write("收到图片");
        writer.flush();//把内容刷新到数据通道
        socket.shutdownOutput();//设置写入结束标记

        //关闭其他资源
        writer.close();
        bis.close();
        socket.close();
        serverSocket.close();
    }
}
```

```java
package com.hspedu.upload;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 此类用于演示关于流的读写方法
 *
 */
public class StreamUtils {
   /**
    * 功能：将输入流转换成byte[]
    * @param is
    * @return
    * @throws Exception
    */
   public static byte[] streamToByteArray(InputStream is) throws Exception{
      ByteArrayOutputStream bos = new ByteArrayOutputStream();//创建输出流对象
      byte[] b = new byte[1024];
      int len;
      while((len=is.read(b))!=-1){
         bos.write(b, 0, len);// 读取道德数据写入bos
      }
      byte[] array = bos.toByteArray();
      bos.close();
      return array;
   }
   /**
    * 功能：将InputStream转换成String
    * @param is
    * @return
    * @throws Exception
    */
   
   public static String streamToString(InputStream is) throws Exception{
      BufferedReader reader = new BufferedReader(new InputStreamReader(is));
      StringBuilder builder= new StringBuilder();
      String line;
      while((line=reader.readLine())!=null){ //当读取到 null时，就表示结束
         builder.append(line+"\r\n");
      }
      return builder.toString();
      
   }

}
```

### netstat 指令

1. `netstat -an` 可以查看当前主机网络情况，包括项口监听情况和网络连接情况
2. `netstat -an | more` 可以分页显示
3. `netstat -anb` （在管理员状态下运行）可以查看是哪些应用监听该端口。
4. 外部地址就是 连接 该本地地址和端口号的客户端的IP和端口号。

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230505220821322.png)

说明:

(1) Listening表示某个端口在监听 Established 表示连接已经建立

(2)如果有一个外部程序(客户端)连接到该端口，就会显示一条连接信息

### TCP 网络通讯

1. 当客户端连接到服务端后，实际上客户端也是通过一个端口和服务端进行通讯的，这个端口是TCP/IP来分配的，是不确定的，是随机的。（**客户端的端口**）
2. 程序验证+netstat

## UDP 网络通信编程

### 基本介绍

1. 类 `DatagramSocket` 和 `DatagramPacket`[数据包/数据报]实现了基于UDP
   协议网络程序。

2. UDP数据报通过数据报套接字`DatagramSocket` 发送和接收，系统不保证UDP数据报一定能够安全送到目的地，也不能确定什么时候可以抵达。
3. `DatagramPacket` 对象封装了UDP数据报，在数据报中包含了发送端的IP地址和
端口号以及接收端的IP地址和端口号。
3. UDP协议中每个数据报都给出了完整的地址信息，因此无须建立发送方和接收方
的连接

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230505222038743.png)

### 基本流程

1. 核心的两个类/对象 DatagramSocket与DatagramPacket
2. 建立发送端，接收端(没有服务端和客户端概念)
3. 发送数据前,建立数据包/报 DatagramPacket对象
4. 调用DatagramSocket的发送、接收方法
5. 关闭DatagramSocket

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230505221554505.png)

### 应用案例

1. 编写一个接收端A,和一个发送端B
2. 接收端 A在 9999端口等待接收数据(receive)
3. 发送端B向接收端A发送数据“hello，明天吃火锅~"
4. 接收端A接收到发送端B发送的数据，回复"好的,明天见"再退出
5. 发送端接收回复的数据,再退出

```java
package com.hspedu.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * UDP接收端
 */
public class UDPReceiverA {
    public static void main(String[] args) throws IOException {
        //1. 创建一个 DatagramSocket 对象，准备在9999接收数据
        DatagramSocket socket = new DatagramSocket(9999);
        //2. 构建一个 DatagramPacket 对象，准备接收数据
        //   在前面讲解UDP 协议时，老师说过一个数据包最大 64k
        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        //3. 调用 接收方法, 将通过网络传输的 DatagramPacket 对象
        //   填充到 packet对象
        //老师提示: 当有数据包发送到 本机的9999端口时，就会接收到数据
        //   如果没有数据包发送到 本机的9999端口, 就会阻塞等待.
        System.out.println("接收端A 等待接收数据..");
        socket.receive(packet);

        //4. 可以把packet 进行拆包，取出数据，并显示.
        int length = packet.getLength();//实际接收到的数据字节长度
        byte[] data = packet.getData();//接收到数据
        String s = new String(data, 0, length);
        System.out.println(s);


        //===回复信息给B端
        //将需要发送的数据，封装到 DatagramPacket对象
        data = "好的, 明天见".getBytes();
        //说明: 封装的 DatagramPacket对象 data 内容字节数组 , data.length , 主机(IP) , 端口
        packet =
                new DatagramPacket(data, data.length, InetAddress.getByName("192.168.12.1"), 9998);

        socket.send(packet);//发送

        //5. 关闭资源
        socket.close();
        System.out.println("A端退出...");

    }
}
```

```java
package com.hspedu.udp;

import java.io.IOException;
import java.net.*;

/**
 * 发送端B ====> 也可以接收数据
 */
@SuppressWarnings({"all"})
public class UDPSenderB {
    public static void main(String[] args) throws IOException {

        //1.创建 DatagramSocket 对象，准备在9998端口 接收数据
        DatagramSocket socket = new DatagramSocket(9998);

        //2. 将需要发送的数据，封装到 DatagramPacket对象
        byte[] data = "hello 明天吃火锅~".getBytes(); //

        //说明: 封装的 DatagramPacket对象 data 内容字节数组 , data.length , 主机(IP) , 端口
        DatagramPacket packet =
                new DatagramPacket(data, data.length, InetAddress.getByName("192.168.12.1"), 9999);

        socket.send(packet);

        //3.=== 接收从A端回复的信息
        //(1)   构建一个 DatagramPacket 对象，准备接收数据
        //   在前面讲解UDP 协议时，老师说过一个数据包最大 64k
        byte[] buf = new byte[1024];
        packet = new DatagramPacket(buf, buf.length);
        //(2)    调用 接收方法, 将通过网络传输的 DatagramPacket 对象
        //   填充到 packet对象
        //老师提示: 当有数据包发送到 本机的9998端口时，就会接收到数据
        //   如果没有数据包发送到 本机的9998端口, 就会阻塞等待.
        socket.receive(packet);

        //(3)  可以把packet 进行拆包，取出数据，并显示.
        int length = packet.getLength();//实际接收到的数据字节长度
        data = packet.getData();//接收到数据
        String s = new String(data, 0, length);
        System.out.println(s);

        //关闭资源
        socket.close();
        System.out.println("B端退出");
    }
}
```

## 本章作业

1.编程题

(1)使用字符流的方式,编写一个客户端程序和服务器端程序，

(2)客户端发送“name"服务器端接收到后，返回“我是nova ", nova是你自己的名字.

(3)客户端发送"hobby"，服务器端接收到后，返回“编写java程序”

(4)不是这两个问题，回复“你说啥呢"

问题:目前，我们只能问一次，就退出了，怎么可以问多次?->while ->聊天

```java
package com.hspedu.homework;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * 客户端，发送 "hello, server" 给服务端， 使用字符流
 */
@SuppressWarnings({"all"})
public class Homework01Client {
    public static void main(String[] args) throws IOException {
        //思路
        //1. 连接服务端 (ip , 端口）
        //解读: 连接本机的 9999端口, 如果连接成功，返回Socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

        //2. 连接上后，生成Socket, 通过socket.getOutputStream()
        //   得到 和 socket对象关联的输出流对象
        OutputStream outputStream = socket.getOutputStream();
        //3. 通过输出流，写入数据到 数据通道, 使用字符流
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));

        //从键盘读取用户的问题
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你的问题");
        String question = scanner.next();

        bufferedWriter.write(question);
        bufferedWriter.newLine();//插入一个换行符，表示写入的内容结束, 注意，要求对方使用readLine()!!!!
        bufferedWriter.flush();// 如果使用的字符流，需要手动刷新，否则数据不会写入数据通道


        //4. 获取和socket关联的输入流. 读取数据(字符)，并显示
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);

        //5. 关闭流对象和socket, 必须关闭
        bufferedReader.close();//关闭外层流
        bufferedWriter.close();
        socket.close();
        System.out.println("客户端退出.....");
    }
}
```

```java
package com.hspedu.homework;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端, 使用字符流方式读写
 */
@SuppressWarnings({"all"})
public class Homework01Server {
    public static void main(String[] args) throws IOException {
        //思路
        //1. 在本机 的9999端口监听, 等待连接
        //   细节: 要求在本机没有其它服务在监听9999
        //   细节：这个 ServerSocket 可以通过 accept() 返回多个Socket[多个客户端连接服务器的并发]
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端，在9999端口监听，等待连接..");
        //2. 当没有客户端连接9999端口时，程序会 阻塞, 等待连接
        //   如果有客户端连接，则会返回Socket对象，程序继续

        Socket socket = serverSocket.accept();

        //
        //3. 通过socket.getInputStream() 读取客户端写入到数据通道的数据, 显示
        InputStream inputStream = socket.getInputStream();
        //4. IO读取, 使用字符流, 老师使用 InputStreamReader 将 inputStream 转成字符流
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        String answer = "";
        if ("name".equals(s)) {
            answer = "我是韩顺平";
        } else if("hobby".equals(s)) {
            answer = "编写java程序";
        } else {
            answer = "你说的啥子";
        }


        //5. 获取socket相关联的输出流
        OutputStream outputStream = socket.getOutputStream();
        //    使用字符输出流的方式回复信息
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write(answer);
        bufferedWriter.newLine();// 插入一个换行符，表示回复内容的结束
        bufferedWriter.flush();//注意需要手动的flush


        //6.关闭流和socket
        bufferedWriter.close();
        bufferedReader.close();
        socket.close();
        serverSocket.close();//关闭

    }
}
```

2.编程题

(1)编写一个接收端A,和一个发送端B,使用UDP协议完成

(2)接收端在8888端口等待接收数据(receive)

(3)发送端向接收端发送数据“四大名著是哪些”

(4)接收端接收到发送端发送的问题后，返回“四大名著是<<红楼梦>>.…."，否则返回what?

(5)接收端和发送端程序退出

```java
package com.hspedu.homework;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * 发送端B ====> 也可以接收数据
 */
@SuppressWarnings({"all"})
public class Homework02SenderB {
    public static void main(String[] args) throws IOException {

        //1.创建 DatagramSocket 对象，准备在9998端口 接收数据
        DatagramSocket socket = new DatagramSocket(9998);

        //2. 将需要发送的数据，封装到 DatagramPacket对象
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你的问题: ");
        String question = scanner.next();
        byte[] data = question.getBytes(); //

        //说明: 封装的 DatagramPacket对象 data 内容字节数组 , data.length , 主机(IP) , 端口
        DatagramPacket packet =
                new DatagramPacket(data, data.length, InetAddress.getByName("192.168.12.1"), 8888);

        socket.send(packet);

        //3.=== 接收从A端回复的信息
        //(1)   构建一个 DatagramPacket 对象，准备接收数据
        //   在前面讲解UDP 协议时，老师说过一个数据包最大 64k
        byte[] buf = new byte[1024];
        packet = new DatagramPacket(buf, buf.length);
        //(2)    调用 接收方法, 将通过网络传输的 DatagramPacket 对象
        //   填充到 packet对象
        //老师提示: 当有数据包发送到 本机的9998端口时，就会接收到数据
        //   如果没有数据包发送到 本机的9998端口, 就会阻塞等待.
        socket.receive(packet);

        //(3)  可以把packet 进行拆包，取出数据，并显示.
        int length = packet.getLength();//实际接收到的数据字节长度
        data = packet.getData();//接收到数据
        String s = new String(data, 0, length);
        System.out.println(s);

        //关闭资源
        socket.close();
        System.out.println("B端退出");
    }
}
```

```java
package com.hspedu.homework;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP接收端
 */
@SuppressWarnings({"all"})
public class Homework02ReceiverA {
    public static void main(String[] args) throws IOException {
        //1. 创建一个 DatagramSocket 对象，准备在8888接收数据
        DatagramSocket socket = new DatagramSocket(8888);
        //2. 构建一个 DatagramPacket 对象，准备接收数据
        //   在前面讲解UDP 协议时，老师说过一个数据包最大 64k
        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        //3. 调用 接收方法, 将通过网络传输的 DatagramPacket 对象
        //   填充到 packet对象
        System.out.println("接收端 等待接收问题 ");
        socket.receive(packet);

        //4. 可以把packet 进行拆包，取出数据，并显示.
        int length = packet.getLength();//实际接收到的数据字节长度
        byte[] data = packet.getData();//接收到数据
        String s = new String(data, 0, length); // 将字节数组转为string!!!!
        //判断接收到的信息是什么
        String answer = "";
        if("四大名著是哪些".equals(s)) {
            answer = "四大名著 <<红楼梦>> <<三国演示>> <<西游记>> <<水浒传>>";
        } else {
            answer = "what?";
        }


        //===回复信息给B端
        //将需要发送的数据，封装到 DatagramPacket对象
        data = answer.getBytes();
        //说明: 封装的 DatagramPacket对象 data 内容字节数组 , data.length , 主机(IP) , 端口
        packet =
                new DatagramPacket(data, data.length, InetAddress.getByName("192.168.12.1"), 9998);

        socket.send(packet);//发送

        //5. 关闭资源
        socket.close();
        System.out.println("A端退出...");

    }
}
```

3.编程题

(1)编写客户端程序和服务器端程序

(2)客户端可以输入一个音乐文件名，比如高山流水, 服务端收到音乐名后，可以给客户端返回这个音乐文件，如果服务器没有这个文件，返回一个默认的音乐即可。

(3)客户端收到文件后，保存到本地e:\\\\

(4)提示:该程序可以使用 StreamUtils.java

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/image-20230505225607883.png)

```java
package com.hspedu.homework;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * 文件下载的客户端
 */
public class Homework03Client {
    public static void main(String[] args) throws Exception {


        //1. 接收用户输入，指定下载文件名
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入下载文件名");
        String downloadFileName = scanner.next();

        //2. 客户端连接服务端，准备发送
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        //3. 获取和Socket关联的输出流
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(downloadFileName.getBytes());
        //设置写入结束的标志
        socket.shutdownOutput();

        //4. 读取服务端返回的文件(字节数据)
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        byte[] bytes = StreamUtils.streamToByteArray(bis);
        //5. 得到一个输出流，准备将 bytes 写入到磁盘文件
        //比如你下载的是 高山流水 => 下载的就是 高山流水.mp3
        //    你下载的是 无名 => 下载的就是 无名.mp3
        String filePath = "e:\\" + downloadFileName + ".mp3";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
        bos.write(bytes);

        //6. 关闭相关的资源
        bos.close();
        bis.close();
        outputStream.close();
        socket.close();

        System.out.println("客户端下载完毕，正确退出..");


    }
}
```

```java
package com.hspedu.homework;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 先写文件下载的服务端
 */
public class Homework03Server {
    public static void main(String[] args) throws Exception {

        //1 监听 9999端口
        ServerSocket serverSocket = new ServerSocket(9999);
        //2.等待客户端连接
        System.out.println("服务端，在9999端口监听，等待下载文件");
        Socket socket = serverSocket.accept();
        //3.读取 客户端发送要下载的文件名
        //  这里老师使用了while读取文件名，时考虑将来客户端发送的数据较大的情况
        InputStream inputStream = socket.getInputStream();
        byte[] b = new byte[1024];
        int len = 0;
        String downLoadFileName = "";
        while ((len = inputStream.read(b)) != -1) {
            downLoadFileName += new String(b, 0 , len);
        }
        System.out.println("客户端希望下载文件名=" + downLoadFileName);

        //老师在服务器上有两个文件, 无名.mp3 高山流水.mp3
        //如果客户下载的是 高山流水 我们就返回该文件，否则一律返回 无名.mp3

        String resFileName = "";
        if("高山流水".equals(downLoadFileName)) {
            resFileName = "src\\高山流水.mp3";
        } else {
            resFileName = "src\\无名.mp3";
        }

        //4. 创建一个输入流，读取文件
        BufferedInputStream bis =
                new BufferedInputStream(new FileInputStream(resFileName));

        //5. 使用工具类StreamUtils ，读取文件到一个字节数组

        byte[] bytes = StreamUtils.streamToByteArray(bis);
        //6. 得到Socket关联的输出流
        BufferedOutputStream bos =
                new BufferedOutputStream(socket.getOutputStream());
        //7. 写入到数据通道，返回给客户端
        bos.write(bytes);
        socket.shutdownOutput();//很关键.

        //8 关闭相关的资源
        bis.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务端退出...");

    }
}
```

```java
package com.hspedu.homework;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 此类用于演示关于流的读写方法
 *
 */
public class StreamUtils {
   /**
    * 功能：将输入流转换成byte[]
    * @param is
    * @return
    * @throws Exception
    */
   public static byte[] streamToByteArray(InputStream is) throws Exception{
      ByteArrayOutputStream bos = new ByteArrayOutputStream();//创建输出流对象
      byte[] b = new byte[1024];
      int len;
      while((len=is.read(b))!=-1){
         bos.write(b, 0, len);  
      }
      byte[] array = bos.toByteArray();
      bos.close();
      return array;
   }
   /**
    * 功能：将InputStream转换成String
    * @param is
    * @return
    * @throws Exception
    */
   
   public static String streamToString(InputStream is) throws Exception{
      BufferedReader reader = new BufferedReader(new InputStreamReader(is));
      StringBuilder builder= new StringBuilder();
      String line;
      while((line=reader.readLine())!=null){
         builder.append(line+"\r\n");
      }
      return builder.toString();
   }
}
```