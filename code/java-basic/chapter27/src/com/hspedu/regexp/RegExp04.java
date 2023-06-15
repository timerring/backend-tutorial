package com.hspedu.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 选择匹配符
 */
public class RegExp04 {
    public static void main(String[] args) {

        String content = "hanshunping 韩 寒冷";
        String regStr = "han|韩|寒";

        Pattern pattern = Pattern.compile(regStr/*, Pattern.CASE_INSENSITIVE*/);
        Matcher matcher = pattern.matcher(content);


        while (matcher.find()) {
            System.out.println("找到 " + matcher.group(0));
        }
    }
}
