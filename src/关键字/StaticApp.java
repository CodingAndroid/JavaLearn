package 关键字;

/**
 * author: lihui1
 * date: 2019/7/9
 * email: 1316994947@qq.com
 * desc: static关键字
 * 修饰属性、修饰方法、修饰代码块、修饰类(内部类)
 * 特点: 1.静态元素在类加载时就初始化, 静态元素优先于对象存在;
 *      2.静态元素存储在静态元素区
 *      3.静态元素只加载一次
 *      4.由于静态元素区加载的时候, 有可能没有创建对象, 可以直接通过类名直接访问
 *      5.静态元素不属于任何一个对象, 属于类
 * (一)静态变量与成员变量的区别:
 *      1.生命周期不同
 *        静态变量随着类的加载而存在, 随着类的消失而消失,
 *        成员变量随着对象的创建而存在, 随着对象的回收而消失
 *      2.调用方式不同
 *        静态变量可以被对象调用, 也可以被类调用(推荐类名调用)
 *        成员变量只能被对象调用
 *      3.别名不同
 *        静态变量-类变量(static)
 *        成员变量-实例变量
 *      4.数据存储位置不同
 *        静态变量数据存储在方法区(静态数据共享区), 而且只会存在一份数据
 *        成员变量数据存储在堆内存的对象中, 对象的特有数据, 有n个对象就有n份数据
 *      5.作用上的区别
 *        静态的成员变量的作用共享一个 数据给所有的对象使用。
 *        非静态的成员变量的作用是描述一类事物的公共属性。
 * 注意事项:
 *       1.静态函数不能出现this或者super关键字
 *         原因: 因为静态的函数是可以使用类名调用的,一旦使用类名调用这时候不存在对象,
 *              而this关键字是代表了一个函数的调用者对象, 这时候产生了冲突
 * 静态代码块: 随着类的加载或创建实例而执行, 而且只执行一次, 作用: 用于给类进行初始化
 *
 * (二)成员变量与局部变量的区别:
 * 成员变量:全局变量或者字段, 直接定义在类中, 方法的外面;
 *         1.类成员变量: 使用static修饰的字段
 *         2.实例成员变量:没有使用static修饰的字段
 *         3.方法内不能定义static变量, static属于类的, 方法属于对象;
 *         4.默认有初始值的
 *         5.在整个类中有效
 *         6.存储在堆中
 *         7.随着对象的创建而存在, 随着对象的消失而消失
 * 局部变量:
 *         1.方法内部的变量;
 *         2.方法的参数;
 *         3.代码块中的变量;
 *         4.没有初始值, 所以必须先初始化才能使用;
 *         5.只在它定义的大括号内生效中
 *         6.存储在栈
 *         7.随着方法的调用而存在, 随着方法的调用完毕而消失
 *
 * 参考资料: https://www.cnblogs.com/cciejh/p/final-in-java.html
 *         https://www.geeksforgeeks.org/
 *         https://www.jianshu.com/p/322cd788cee2
 */

public class StaticApp {

    private String name;//成员变量

    private static int age; //修饰成员变量(类成员变量), 该成员变量的数据是一个共享的数据 StaticApp对象不再拥有age属性, age由StaticApp类处理, 存储在方法区(静态数据共享区)

    private static int i = 0;

    private int id;

    {
        System.out.println("代码块");
    }

    static {
        System.out.println("静态代码块");
    }

    public StaticApp(){
        id = i++;
        System.out.println("无参构造方法");
    }

    public void study(){
        System.out.println("好好学习..." + this);
    }

    public static void sleep(){
        StaticApp app = new StaticApp();
        app.name = "app";
        System.out.println(app.name + "休息...");
    }

    @Override
    public String toString() {
        return this.name;
    }

    public static void main(String[] args) {

        StaticApp p1 = new StaticApp();
        p1.name = "java";
        p1.age = 18;
        p1.study();
        System.out.println("-------------------------");
        StaticApp p2 = new StaticApp();
        p2.name = "C++";
        p2.age = 20;
        System.out.println("-------------------------");
        StaticApp p3 = new StaticApp();
        p3.name = "php";
        p3.age = 30;
        System.out.println("-------------------------");
        System.out.println("p1.name = "+p1.name+",p1.age="+p1.age);
        System.out.println("p2.name = "+p2.name+",p2.age="+p2.age);
        System.out.println("p3.name = "+p3.name+",p3.age="+p3.age);
        System.out.println(p1.id + "," + p2.id + "," + p3.id);
        StaticApp.sleep();

        Student.method(); //子类调用父类method(), 静态的方法可以被继承, 但是不能重写
        Teacher.method();
    }

    static class Person{

        public static void method(){
            System.out.println("父类method()方法");
        }
    }

    static class Student extends Person{


    }

    static class Teacher extends Person{

        //如果父类中有一个静态的方法, 子类也有一个与其方法名、参数类型、参数个数都一样的方法, 并且也有static关键字修饰, 那么该子类的方法会把原来继承过来的父类的方法隐藏, 而不是重写。
        //通俗的讲就是父类的方法和子类的方法是两个没有关系的方法, 具体调用哪一个方法是看是哪个对象的引用; 这种父子类方法不在存在多态的性质。
        //思考: 为什么abstract修饰的方法是不可同时是static修饰的呢?
        public static void method(){
            System.out.println("子类method()方法");
        }
    }
}
