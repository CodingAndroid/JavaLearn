package 反射;

import java.lang.reflect.Field;

/**
 * 作者: lihui1
 * 日期: 2021/5/12 4:16 下午
 * 描述:
 */
public class TestField {


    public void testField() throws Exception{

        String className = "反射.Person";
        Class<?> clazz = Class.forName(className);
        Field[] fields0 = clazz.getFields();
        //获取所有公有的字段
        for (Field field : fields0){
            System.out.println("公有字段:" + field.getName());
        }
        //获取所有的字段(包括私有、受保护、默认的), 不能获取父类字段
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields){
            System.out.println("所有字段:" + field.getName());
        }

        //获取指定字段
        Field fieldPublic = clazz.getField("gender");
        System.out.println(fieldPublic.getName());

        //获取指定字段
        Field field = clazz.getDeclaredField("name");
        System.out.println(field.getName());
        //私有字段, 不管读还是写, 都应设置setAccessible(true)
        field.setAccessible(true);

        Person person = new Person(20, "C++");
        System.out.println(field.getName() + "=" +field.get(person));
        field.set(person, "PHP");
        System.out.println(field.getName() + person.getName());
    }
}
