package OOP;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

/**
 * 作者: lihui1
 * 日期: 2021/9/12 12:46 下午
 * 描述: 创建对象的方式
 */
public class Person implements Cloneable, Serializable {

    @Override
    protected Object clone() {
        Object object = null;
        try {
            object = super.clone();
        } catch (Exception e){
            e.printStackTrace();
        }
        return object;
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, CloneNotSupportedException {
        Person person = new Person();

        try {
            Person p = (Person) Class.forName("OOP.Person").newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        Person p1 = Person.class.getConstructor().newInstance();

        Person p2 = (Person) person.clone();
    }
}
