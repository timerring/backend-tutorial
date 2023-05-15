package com.hspedu.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 演示非捕获分组, 语法比较奇怪
 */
public class RegExp08 {
    public static void main(String[] args) {

        String content = "hello碳膜闰教育 jack碳膜闰老师 碳膜闰同学hello碳膜闰学生";

//        找到 碳膜闰教育 、碳膜闰老师、碳膜闰同学 子字符串
        //String regStr = "碳膜闰教育|碳膜闰老师|碳膜闰同学";
        //上面的写法可以等价非捕获分组, 注意：不能 matcher.group(1)，因为并不是分组，不能捕获
        //String regStr = "碳膜闰(?:教育|老师|同学)";

        //找到 碳膜闰 这个关键字,但是要求只是查找碳膜闰教育和 碳膜闰老师 中包含有的碳膜闰
        //下面也是非捕获分组，不能使用 matcher.group(1)
        //String regStr = "碳膜闰(?=教育|老师)";

        //找到 碳膜闰 这个关键字,但是要求只是查找 不是 (碳膜闰教育 和 碳膜闰老师) 中包含有的碳膜闰
        //下面也是非捕获分组，不能使用 matcher.group(1)
        String regStr = "碳膜闰(?!教育|老师)";

        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println("找到: " + matcher.group(0));
        }
    }
}