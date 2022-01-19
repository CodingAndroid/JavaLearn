package OOP;

/**
 * author: lihui1
 * date: 2020/1/9
 * email: 1316994947@qq.com
 * desc: 接口 interface 关键字
 * 1.接口不能包含属性(成员变量)
 * 2.接口只能声明方法(抽象方法、类方法、默认方法), 方法不能包含代码实现
 * 3.子类通过implements实现接口时, 必须实现接口中声明的所有方法;
 * 4.接口只可以继承接口(一个或多个), 子类可以实现多个接口
 * 5.接口默认修饰符是public
 * 6.接口完全是抽象的, 没有构造方法, 且方法都是抽象的, 不存在方法的实现
 * 7.为了把程序模块进行固化的契约, 是为了降低耦合
 */

public interface Ability {

    //默认是public static final, 全局静态常量
    int age = 0;

    //默认是public static final, 全局静态常量
    String COUNTRY = "China";

    //抽象方法, 默认为public abstract
    void doWork();

    //抽象方法
    abstract void study();

    //默认方法, 默认是public
    default void foo(){
        System.out.println("interface.foo");
    }

    //类方法(静态方法), 默认是public
    static void play(){
        System.out.println("interface.play");
    }
}
