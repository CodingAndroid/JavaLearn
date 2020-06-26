package String;

/**
 * author: lihui1
 * date: 2018/8/6
 * email: 1316994947@qq.com
 * desc:
 */

public class Main {

    public static void main(String[] args) {
        
        String s1 = "HelloWorld";
        String s2 = "HelloWorld";
        String s3 = new String("HelloWorld");
        String s4 = "Hello";
        String s5 = "World";
        String s6 = "Hello" + "World";
        String s7 = s4 + s5;

        System.out.println(s1 == s2);//1:输出为true

        System.out.println(s1 == s3);//2：输出为false

        System.out.println(s1 == s6);//3：输出为true

        System.out.println(s1 == s7);//4：输出为false

        System.out.println(s1 == s7.intern());//5：输出为true

        System.out.println(s3 == s3.intern());//6：输出为false

        System.out.println(s1.equals(s3)); //true
        System.out.println("HelloWorld".equals(s1));//推荐, s1=null不会报错
        System.out.println(s1.equals("HelloWorld"));//不推荐, s1=null是报错, 空指针异常

        String str = new String("1"); //生成2个对象, 常量池+堆空间, str指向堆空间中"1"的内存地址
        str.intern(); //已经在常量池中创建了"1", 什么也不做, 直接返回对象的引用
        String str2 = "1"; //指向常量池中的"1"对象
        System.out.println(str == str2);//false

        String str3 = new String("1") + new String("1");//生成4个对象, 3个堆("1","1","11")+1个常量池("1"), 指向堆内存中的"11"。注意: 此时常量池中是没有字符串"11"的
        str3.intern(); //堆中有该字符串而常量池中没有, 则直接在常量池中保存首次创建该对象的引用，而不会在常量池中重新创建对象
        String str4 = "11";//直接去常量池中创建, 创建的时候发现已经有这个对象了，此时str4就是指向str3引用对象的一个引用
        System.out.println(str3 == str4);//true

        String str5 = new StringBuilder().append("String").append("Test").toString();
        System.out.println(str5.intern() == str5);//true

        String str6 = new StringBuilder().append("php").append("va").toString();
        System.out.println(str6.intern() == str6);//false


    }

    /**
     * i = 0, h0 = 31 * 0 + val[0];
     * i = 1, h1 = 31 * (31 * 0 + val[0]) + val[1];
     *           = 31 * val[0] + val[1];
     * i = 2, h2 = 31 * (31 * (31 * 0 + val[0]) + val[1]) + val[2];
     *           = 31 * (31 * val[0] + val[1]) + val[2];
     *           = 31 * 31 * val[0] + 31 * val[1] + val[2];
     * ...
     * i = n-1, h(n) = val[0]*31^(n-1) + val[1]*31^(n-2) + ... + val[n-1]
     */
}