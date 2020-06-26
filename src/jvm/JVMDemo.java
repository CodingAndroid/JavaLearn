package jvm;

/**
 * author: lihui1
 * date: 2018/6/12
 * email: 1316994947@qq.com
 * desc:
 */

import jvm.model.Child;

/**
 * 类的主动引用:
 * 
 * 类的被动引用:
 */
public class JVMDemo {

    static {
        System.out.println("静态初始JVMDemo");
    }

    public static void main(String[] args) {
        Child child = new Child();
        System.out.println(child.width+"");
        System.out.println(Child.num+"");
        System.out.println(Child.width+"");
    }
}

/*静态代码块 --> 非静态代码块 --> 默认构造方法 --> 普通方法中的代码块 */
