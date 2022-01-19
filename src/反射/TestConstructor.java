package 反射;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 作者: lihui1
 * 日期: 2021/5/12 4:18 下午
 */
public class TestConstructor {

    public static void testConstructor() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        String className = "反射.Person";
        Class<?> clazz = Class.forName(className);

        //获取所有构造方法(公有的)
        System.out.println("获取所有构造方法(公有)");
        Constructor<?>[] constructors = clazz.getConstructors();
        for (Constructor<?> constructor : constructors){
            System.out.println(constructor);
        }

        //获取所有的构造方法(包括私有、受保护、默认、公有)
        System.out.println("获取所有的构造方法(包括私有、受保护、默认、公有)");
        Constructor<?>[] constructors1 = clazz.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors1){
            System.out.println(constructor);
        }

        //获取一个指定参数类型的构造方法(公有的)
        System.out.println("获取某一个Constructor对象【公有】");
        Constructor<?> constructor = clazz.getConstructor(int.class, String.class);
        System.out.println(constructor);

        //获取一个指定参数类型的"构造方法", 可以是私有的，或受保护、默认、公有
        System.out.println("获取某一个Constructor对象【私有的，或受保护、默认、公有】");
        Constructor<?> constructor1 = clazz.getDeclaredConstructor(int.class);
        constructor1.setAccessible(true);
        System.out.println(constructor1);

        //使用构造方法创建对象
        //如果需要调用类的带参构造函数、私有构造函数等, 就需要采用Constructor.newInstance()
        Person person = (Person) constructor1.newInstance(22);
        person.setAge(21);
        System.out.println(person.getAge());

    }
}
