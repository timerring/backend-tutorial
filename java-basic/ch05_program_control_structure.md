- [第5章 程序控制结构](#第5章-程序控制结构)
	- [程序流程控制介绍](#程序流程控制介绍)
	- [if 分支](#if-分支)
	- [switch 分支结构](#switch-分支结构)
	- [for 循环控制](#for-循环控制)
	- [while 循环控制](#while-循环控制)
	- [do..while 循环控制](#dowhile-循环控制)
	- [跳转控制语句-break](#跳转控制语句-break)
	- [跳转控制语句-continue](#跳转控制语句-continue)
	- [跳转控制语句-return](#跳转控制语句-return)


# 第5章 程序控制结构

## 程序流程控制介绍

1) 顺序控制
2) 分支控制
3) 循环控制

## if 分支

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/04/11-19-21-29-1681212087.png)

## switch 分支结构

```java
switch(表达式){
    case常量1;
    语句块1;
    break;
    case常量2;
    语句块2;
    break;
    ...
    case常量n;
    语句块n;
    break;

    default:
    default语句块;
    break;
}
```

1. 表达式数据类型，应和case后的常量类型一致，或者是可以自动转成可以相互比较的
   类型，比如输入的是字符,而常量是int

2. switch(表达式)中表达式的返回值必须是:(**byte,short,int,char,enum[枚举],String**)

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/04/11-19-28-46-1681212525.png)

3. case子句中的值必须是常量,而不能是变量

4. default子句是可选的，当没有匹配的case时，执行default

5. break语句用来在执行完一个case分支后使程序跳出switch语句块;如果没有写break，程序会顺序执行到switch结尾，除非遇到break;

## for 循环控制

```java
for (循环变量初始化;循环条件;循环变量迭代){
    循环操作(可以多条语句);
}
```

## while 循环控制

```java
while(循环条件){
    循环体(语句);
    循环变量迭代;
}
```

## do..while 循环控制

```java
do{
    循环体(语句);
    循环变量迭代;
}while(循环条件);
```

## 跳转控制语句-break

break 语句用于终止某个语句块的执行，一般使用在switch 或者循环[for , while , do-while]中。

break语句出现在多层嵌套的语句块中时，可以通过标签指明要终止的是哪一层语句块。如果没有指定break,默认退出最近的循环体

![](https://raw.githubusercontent.com/timerring/scratchpad2023/main/2023/04/11-19-39-30-1681213168.png)

例：实现登录验证，有3 次机会，如果用户名为"丁真" ,密码"666"提示登录成功，否则提示还有几次机会，请使用for+break

```java
import java.util.Scanner;
public class BreakExercise02 { 

	//编写一个main方法
	public static void main(String[] args) {

		//实现登录验证，有3次机会，如果用户名为"丁真" ,密码"666"提示登录成功，
		//否则提示还有几次机会，请使用for+break完成
		//
		// 思路分析
		// 1. 创建Scanner对象接收用户输入  
		// 2. 定义 String name ; String passwd; 保存用户名和密码
		// 3. 最多循环3次[登录3次]，如果 满足条件就提前退出
		// 4. 定义一般变量 int chance 记录还有几次登录机会
		// 
		// 代码实现
		
		Scanner myScanner  = new Scanner(System.in);
		String name = "";
		String passwd = "";
		int chance = 3; //登录一次 ，就减少一次
		for( int i = 1; i <= 3; i++) {//3次登录机会
			System.out.println("请输入名字");
			name = myScanner.next();
			System.out.println("请输入密码");
			passwd = myScanner.next();
			//比较输入的名字和密码是否正确
			//补充说明字符串 的内容 比较 使用的 方法 equals
            // 字符串比较推荐这种写法，可以有效避免空指针。相比于（"name".equals(丁真)）
			if("丁真".equals(name) && "666".equals(passwd)) {
				System.out.println("恭喜你，登录成功~");
				break;
			}
			//登录的机会就减少一次
			chance--;
			System.out.println("你还有" + chance + "次登录机会");
		}
	}
}
```

## 跳转控制语句-continue

continue 语句用于结束本次循环，继续执行下一次循环。

continue 语句出现在多层嵌套的循环语句体中时，可以通过标签指明要跳过的是哪一层循环, 这个和前面的标签的使用的规则一样.

## 跳转控制语句-return

return 使用在方法，表示跳出所在的方法。
