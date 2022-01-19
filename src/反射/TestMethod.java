package 反射;

import java.lang.reflect.Method;

/**
 * 作者: lihui1
 * 日期: 2021/5/12 4:18 下午
 * 描述:
 */
public class TestMethod {

    public void testMethod() throws Exception {
        Class<?> clazz = Class.forName("反射.Person");
        System.out.println("获取clazz对应类中的所有公共方法, 不能获取私有方法, 且获取从父类继承来的所有方法");
        Method[] methods = clazz.getMethods();
        for (Method method : methods){
            System.out.println(method.getName() + "()");
        }
        System.out.println("获取方法包括公共方法、私有方法、受保护的方法, 不能获取从父类继承来的方法");
        methods = clazz.getDeclaredMethods();
        for (Method method : methods){
            System.out.println(method.getName() + "()");
        }
        System.out.print("执行公共方法: ");
        Method method = clazz.getDeclaredMethod("setAge", int.class);
        System.out.println(method);
        Person person = (Person) clazz.newInstance();
        method.invoke(person, 18);

        method = clazz.getDeclaredMethod("work");
        System.out.println("执行私有方法: " + method);
        method.setAccessible(true);
        method.invoke(person);

        method = clazz.getDeclaredMethod("study");
        System.out.println("执行protected方法: " + method);
        method.invoke(person);

        method = clazz.getDeclaredMethod("show");
        System.out.println("执行默认方法: " + method);
        method.invoke(person);

        method = clazz.getMethod("setAge", int.class);
        System.out.println("执行公共成员方法: " + method);
        method.invoke(person, 18);

    }
}
