package OOP;


import OOP.model.Person;

/**
 * author: lihui1
 * date: 2019/9/8
 * email: 1316994947@qq.com
 * desc: 封装
 */

public class Encapsulation {

    public static void main(String[] args) {

        Person person = new Person();
        person.setName("java");
        person.setAge(20);
        person.setMale(true);
        person.show();
    }
}
