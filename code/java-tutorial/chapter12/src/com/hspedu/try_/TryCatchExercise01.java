package com.hspedu.try_;

public class TryCatchExercise01 {
}

class Exception01 {
    public static int method() {
        try {
            String[] names = new String[3];//String[]数组
            if (names[1].equals("tom")) {//NullPointerException
                System.out.println(names[1]);
            } else {
                names[3] = "hspedu";
            }
            return 1;
        } catch (ArrayIndexOutOfBoundsException e) {
            return 2;
        } catch (NullPointerException e) {//捕获
            return 3;
        } finally { //必须执行
            return 4; //返回4
        }
    }

    public static void main(String[] args) {
        System.out.println(method()); //4
    }
}
