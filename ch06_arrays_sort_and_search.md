# 第6章 数组、排序和查找

## 数组介绍

数组可以存放多个同一类型的数据。数组也是一种数据类型，是引用类型。

## 数组的使用

#### 使用方式1-动态初始化数组的定义

数据类型数组名[]=new数据类型[大小]

```java
int a[] = new int[5];//创建了一个数组，名字a,存放5个int
```

说明: 这是定义数组的一种方法。

```java
import java.util.Scanner;
public class Array02 { 

    //编写一个main方法
    public static void main(String[] args) {
        //演示 数据类型 数组名[]=new 数据类型[大小]
        //循环输入5个成绩，保存到double数组,并输出

        //步骤
        //1. 创建一个 double 数组，大小 5

        //(1) 第一种动态分配方式
        //double scores[] = new double[5];
        //(2) 第2种动态分配方式， 先声明数组，再 new 分配空间
        double scores[] ; //声明数组， 这时 scores 是 null
        scores = new double[5]; // 分配内存空间，可以存放数据


        //2. 循环输入
        //   scores.length 表示数组的大小/长度
        //   
        Scanner myScanner = new Scanner(System.in);
        for( int i = 0; i < scores.length; i++) {
            System.out.println("请输入第"+ (i+1) +"个元素的值");
            scores[i] = myScanner.nextDouble();
        }

        //输出，遍历数组
        System.out.println("==数组的元素/值的情况如下:===");
        for( int i = 0; i < scores.length; i++) {
            System.out.println("第"+ (i+1) +"个元素的值=" + scores[i]);
        }
    }
}
```

#### 使用方式2-动态初始化

1.先声明数组

语法:数据类型数组名[]; 也可以数据类型[] 数组名;

int a[]; 或者int[] a;

2.创建数组

语法: 数组名=new 数据类型[大小];

a=new int[10];

#### 使用方式3-静态初始化

初始化数组

语法:

数据类型 数组名[]={元素值，元素值...}

`int a[]={2,5,6,7,8,89,90,34,56},`

## 数组使用注意事项和细节

1) 数组中的元素可以是任何数据类型，包括基本类型和引用类型，但是不能混用。

2) 数组创建后，如果没有赋值，有默认值
   int 0
   
   short 0
   
   byte 0
   
   long 0
   
   float 0.0
   
   double 0.0 
   
   char \u0000
   
   boolean false
   
   String null
3. 数组属引用类型，数组型数据是对象(object)

## 数组应用案例

创建一个char 类型的26 个元素的数组，分别放置'A'-'Z'。使用for 循环访问所有元素并打印出来。提示：char 类型数据运算'A'+2 -> 'C'

```java
public class ArrayExercise01 { 

    //编写一个main方法
    public static void main(String[] args) {

        /*
        创建一个char类型的26个元素的数组，分别 放置'A'-'Z'。
        使用for循环访问所有元素并打印出来。
        提示：char类型数据运算 'A'+1 -> 'B'  

        思路分析
        1. 定义一个 数组  char[] chars = new char[26]
        2. 因为 'A' + 1 = 'B' 类推，所以老师使用for来赋值
        3. 使用for循环访问所有元素
         */
        char[] chars = new char[26];
        for( int i = 0; i < chars.length; i++) {//循环26次
            //chars 是 char[] 
            //chars[i] 是 char
            chars[i] = (char)('A' + i); //'A' + i 是int , 需要强制转换
        }

        //循环输出
        System.out.println("===chars数组===");
        for( int i = 0; i < chars.length; i++) {//循环26次
            System.out.print(chars[i] + " ");
        }

    }
}
```

## 数组赋值机制

数组在默认情况下是引用传递，赋的值是地址。(相比：变量往往是值传递)

```java
int[] arr1 = {1,2,3};
int[] arr2 = arr1;
```

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/04/11-22-07-48-1681222067.png)

## 数组拷贝

编写代码实现数组拷贝(内容复制)

```java
int[] arr1 = {10,20,30};
int[] arr2 = new int[arr1.length];
for(int i = 0; i < arr1.length; i++) {
    arr2[i] = arr1[i];
}
```

## 数组添加/扩容

要求：实现动态的给数组添加元素效果，实现对数组扩容。

1) 原始数组使用静态分配 int[] arr = {1,2,3}
2) 增加的元素4，直接放在数组的最后arr = {1,2,3,4}
3) 用户可以通过如下方法来决定是否继续添加，添加成功，是否继续？y/n

```java
1. 定义初始数组int[] arr = {1,2,3}//下标0-2
2. 定义一个新的数组int[] arrNew = new int[arr.length+1];
3. 遍历arr 数组，依次将arr 的元素拷贝到arrNew 数组
4. 将4 赋给arrNew[arrNew.length - 1] = 4;把4 赋给arrNew 最后一个元素
5. 让arr 指向arrNew ; arr = arrNew; 那么原来arr 数组就被销毁
6. 创建一个Scanner可以接受用户输入
7. 因为用户什么时候退出，不确定，使用do-while + break 来控制
```

## 多维数组 二维数组

### 动态初始化1

1) 语法: 类型[][] 数组名=new 类型[大小][大小]
2) 比如: int a[][]=new int[2][3]
3) 二维数组在内存的存在形式(!!画图)

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/04/11-22-16-31-1681222588.png)

### 动态初始化2

先声明：类型数组名[][]; 

再定义(开辟空间) 数组名= new 类型[大小][大小]

赋值(有默认值，比如int 类型的就是0)

### 静态初始化

定义类型数组名[][] = {{值1,值2..},{值1,值2..},{值1,值2..}}
int[][] arr = {{1,1,1}, {8,8,9}, {100}};

## 二维数组的应用案例

使用二维数组打印一个10 行杨辉三角

1

1 1

1 2 1

1 3 3 1

1 4 6 4 1

1 5 10 10 5 1

1.第一行有1个元素,第n行有n个元素

2.每一行的第一个元素和最后一个元素都是1

3.从第三行开始,对于非第一个元素和最后一个元素的元素的值.

arr[i][j] = arr[i-1][j] + arr[i-1][j-1];

```java
public class YangHui { 

    //编写一个main方法
    public static void main(String[] args) {
        /*
        使用二维数组打印一个 10 行杨辉三角
        1
        1 1
        1 2 1
        1 3 3  1
        1 4 6  4  1
        1 5 10 10 5 1

        规律
         1.第一行有 1 个元素, 第 n 行有 n 个元素
         2. 每一行的第一个元素和最后一个元素都是 1
         3. 从第三行开始, 对于非第一个元素和最后一个元素的元素的值. arr[i][j] 
          arr[i][j]  =  arr[i-1][j] + arr[i-1][j-1]; //必须找到这个规律

         */
        int[][] yangHui = new int[12][];
        for(int i = 0; i < yangHui.length; i++) {//遍历yangHui的每个元素

            //给每个一维数组(行) 开空间
            yangHui[i] = new int[i+1];
            //给每个一维数组(行) 赋值
            for(int j = 0; j < yangHui[i].length; j++){
                //每一行的第一个元素和最后一个元素都是1
                if(j == 0 || j == yangHui[i].length - 1) {
                    yangHui[i][j] = 1;
                } else {//中间的元素
                    yangHui[i][j]  =  yangHui[i-1][j] + yangHui[i-1][j-1];
                }
            }
        }
        //输出杨辉三角
        for(int i = 0; i < yangHui.length; i++) {
            for(int j = 0; j < yangHui[i].length; j++) {//遍历输出该行
                System.out.print(yangHui[i][j] + "\t");
            }
            System.out.println();//换行.
        }
    }
}
```

## 二维数组使用细节和注意事项

1) 一维数组的声明方式有:
   
   ```java
   int[] x 或者int x[]
   ```

2) 二维数组的声明方式有:
   
   ```java
   int[][] y 或者int[] y[] 或者int y[][]
   ```

3) 二维数组实际上是由多个一维数组组成的，它的各个一维数组的长度可以相同，也可以不相同。比如： map[][] 是一个二维数组
   
   ```java
   int map [][] = {{1,2},{3,4,5}}
   ```
   
   由map[0] 是一个含有两个元素的一维数组，map[1] 是一个含有三个元素的一维数组构成，我们也称为列数不等的二维数组
