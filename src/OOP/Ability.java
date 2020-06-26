package OOP;

/**
 * author: lihui1
 * date: 2020/1/9
 * email: 1316994947@qq.com
 * desc: 接口 interface 关键字
 * 1.接口不能包含属性(成员变量)
 * 2.接口只能声明方法, 方法不能包含代码实现
 * 3.子类通过implements实现接口时, 必须实现接口中声明的所有方法;
 * 4.接口只可以继承接口(一个或多个), 子类可以实现多个接口
 * 5.接口默认修饰符是public
 * 6.接口完全是抽象的, 没有构造方法, 且方法都是抽象的, 不存在方法的实现
 * 7.为了把程序模块进行固化的契约, 是为了降低耦合
 */

public interface Ability {

    void doWork();
}
