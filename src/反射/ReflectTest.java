package 反射;

import java.lang.reflect.Constructor;

/**
 * 作者: lihui1
 * 日期: 2021/5/12 2:42 下午
 * 描述:
 * 描述: 在运行时获取到类, 但是在运行时.java文件已经在编译阶段被编译成了.class文件,
 * 所以反射的原理就是: 运行时通过字节码文件获取到类的所有信息。
 * 反射拥有以下四大功能:
 * 在运行时(动态编译)获知任意一个对象所属的类。
 * 在运行时构造任意一个类的对象。
 * 在运行时获知任意一个类所具有的成员变量和方法。
 * 在运行时调用任意一个对象的方法和属性。
 * 上述这种「动态获取信息、动态调用对象的方法」的功能称为Java语言的反射机制。
 *
 * 优点: 比较灵活, 能够在运行时动态获取类的实例。
 * 缺点:
 * 1）性能瓶颈: 反射相当于一系列解释操作, 通知JVM要做的事情, 性能比直接的Java代码要慢很多。
 * 2）安全问题: 反射机制破坏了封装性, 因为通过反射可以获取并调用类的私有方法和字段。
 */
public class ReflectTest {

    public static void main(String[] args) throws Exception {

        //实例化对象的标准方法
        Servant servant = new Servant(); //先有类, 后有对象
        servant.service("hello");

        //运行时获取类的4中方式
        //1.知道具体类的情况下可以使用
        Class<Servant> servantClass1 = Servant.class; //类名.class
        //2.通过对象实例 instance.getClass() 获取：
        Class<?> servantClass2 = servant.getClass(); //对象.getClass()
        //3.通过Class.forName() 传入全类名获取：
        Class<?> servantClass3 = Class.forName("反射.Servant");
        //4.通过类加载器 xxxClassLoader.loadClass() 传入类路径获取
        Class<?> servantClass4 = ReflectTest.class.getClassLoader().loadClass("反射.Servant");
        System.out.println(servantClass1 + "," + servantClass2 + "," + servantClass3 + "," + servantClass4);

        //运行时创建对象
        //newInstance方法调用默认的构造函数(无参构造函数)初始化新创建的对象。
        //如果这个类没有默认的构造函数, 就会抛出一个异常。
        Servant servant1 = servantClass1.newInstance();
        servant1.service("ok");

        Constructor<Servant> constructor = servantClass1.getConstructor();
        Servant servant2 = constructor.newInstance();
        servant2.service("java---");

        new TestField().testField();
        System.out.println("-----------------");
        new TestMethod().testMethod();
        System.out.println("==================");
        TestConstructor.testConstructor();
    }
}
