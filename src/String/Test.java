package String;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * author: lihui1
 * date: 2019/3/26
 * email: 1316994947@qq.com
 * desc: 拓展: Java和C++的一个不同点是, 在Java中不可能直接操作对象本身, 所有的对象都由一个引用指向,
 * 必须通过这个引用才能访问对象本身, 包括获取成员变量的值, 改变对象的成员变量, 调用对象的方法等。
 */

public class Test {

    /**
     * 通过反射改变value指向的数组
     * @param s
     */
    public static void testReflection(String s){

        Field valueFieldOfString = null;
        try {
            valueFieldOfString = String.class.getDeclaredField("value");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        valueFieldOfString.setAccessible(true);
        char[] value = new char[0];
        try {
            value = (char[]) valueFieldOfString.get(s);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        value[5] = '_';
        System.out.println("s="+s);
    }

    public static void main(String[] args) {

        String a = "java";

        String b = new String("php");

        String c = "c" + "c++"+"c#";//只会创建一个对象, 原因Java对String的+做了优化: 直接转换为一个字符串; 只在常量池中创建一个"cc++c#"对象

        String d = "python" + new String("kotlin");

        String e = new String("A" + "B");

        String f = new String("ABC") + "A"; //常量池: A, ABC; 堆: ABC, ABCA;

        String g = new String("PHP") + new String("Swift");//

        String s = "Hello Kotlin";//s只是保存String对象的引用, 引用只是一个4字节的数据, 里面存放了它所指向的对象的地址, 通过这个地址可以访问对象, 并不是对象本身;
        System.out.println("s="+s);

        s = "Hello Java";
        System.out.println("s="+s);

        testReflection(s);

        final char value[] = {'a', 'b', 'c'};
        value[2] = 'd';
        System.out.println(value);
    }
}

