package String;

/**
 * author: lihui1
 * date: 2018/4/8
 * email: 1316994947@qq.com
 * desc: https://blog.csdn.net/zhongbeizhoujie/article/details/44549749?locationNum=3
 *       https://tech.meituan.com/2014/03/06/in-depth-understanding-string-intern.html
 *       https://www.cnblogs.com/aloenfs/p/9127353.html
 *       https://juejin.im/post/5b3197c4e51d4558b70cae46  我终于搞清楚了和String有关的那点事儿。
 */

public class StringTest {

    public static void main(String args[]){
        String s1 = "ShangHai"; // 1个对象, 常量池: "ShangHai"
        String s2 = "Shang"; // 1个对象, 常量池: "Shang"
        String s3 = "Hai";  // 1个对象, 常量池: "Hai"
        String s4 = "Shang" + "Hai"; // 1个对象, 常量池: "ShangHai"
        String s5 = s2 + s3; // 3个对象, 常量池: "Shang" "Hai"  堆: "ShangHai", 因为常量池要保存的是已确定的字面量值, 如果在字符串拼接中，有一个参数是非字面量，而是一个变量的话，整个拼接操作会被编译成StringBuilder.append，这种情况编译器是无法知道其确定值的。只有在运行期才能确定。
        String s6 = s5.intern(); // 1个对象, 常量池: "ShangHai"
        String s7 = "Shang" + s3; //3个对象, 常量池: "Shang" "Hai"  堆: "ShangHai"
        String s8 = s7.intern(); // 1个对象, 常量池: "ShangHai"

        String s9 = new String("ShangHai");//
        String s10 = s9.intern(); //
        String s11 = s1.intern(); //

        System.out.println(s1 == s4);// 1、true
        System.out.println(s1 == s5);// 2、false
        System.out.println(s1 == s6);// 3、true
        System.out.println(s1 == s7);// 4、false
        System.out.println(s1 == s8);// 5、true
        System.out.println(s1 == s9);// 6、false
        System.out.println(s1 == s10);// 7、true
        System.out.println(s1 == s11);// 8、true
        System.out.println(s1 == s1.intern());//true

        String str = new String("1"); //生成2个对象, 常量池+堆空间, str指向堆空间中的"1"
        String str2 = "1";// 指向常量池"1"的地址
        str.intern(); //常量池存在"1", 直接返回字符串的引用(堆内存中的地址)
        System.out.println(str == str2);//false

        String str3 = new String("1") + new String("1");//生成4个对象, 3个堆("1","1","11")+1个常量池("1"), 指向堆内存中的"11"。注意: 此时常量池中是没有字符串"11"的
        //str3.intern();//此时常量池不存在"11",  true
        String str4 = "11";
        str3.intern();//常量池已经存在"11", 直接返回字符串的引用(堆内存中的地址) false
        System.out.println(str3 == str4);//false
    }
}
