package com.hspedu.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 分组:
 */
public class RegExp07 {
    public static void main(String[] args) {

        String content = "hanshunping s7789 nn1189han";

        //下面就是非命名分组
        //说明
        // 1. matcher.group(0) 得到匹配到的字符串
        // 2. matcher.group(1) 得到匹配到的字符串的第1个分组内容
        // 3. matcher.group(2) 得到匹配到的字符串的第2个分组内容

        //String regStr = "(\\d\\d)(\\d\\d)";//匹配4个数字的字符串

        //命名分组： 即可以给分组取名
        String regStr = "(?<g1>\\d\\d)(?<g2>\\d\\d)";//匹配4个数字的字符串

        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()) {
            System.out.println("找到=" + matcher.group(0)); //7789    1189
            System.out.println("第1个分组内容=" + matcher.group(1)); // 77  11
            System.out.println("第1个分组内容[通过组名]=" + matcher.group("g1")); // 77  11
            System.out.println("第2个分组内容=" + matcher.group(2)); // 89 89
            System.out.println("第2个分组内容[通过组名]=" + matcher.group("g2")); // 89 89
        }
    }
}
