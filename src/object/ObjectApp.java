package object;

import object.model.Person;

import java.util.HashMap;
import java.util.HashSet;

/**
 * author: lihui1
 * date: 2019/8/25
 * email: 1316994947@qq.com
 * desc: object的equals()默认比较对象的地址值
 */

public class ObjectApp {

    public static void main(String[] args) {
        HashMap<Person, String> map = new HashMap<>();
        Person p1 = new Person("java", 20);
        Person p2 = new Person("java", 20);
        map.put(p1, "0001");
        System.out.println(map.get(p2));
        System.out.println("-----------华丽的分割线------------");
        //p1 = p2;// p2的地址赋值给p1 引用传递
        System.out.println("比较p1和p2的内存地址是否相同:" + (p1 == p2));
        System.out.println("p1:" + p1 + "," + p1.hashCode());
        System.out.println("p2:" + p2 + "," + p2.hashCode());
        System.out.println("-----------华丽的分割线------------");
        System.out.println("p1和p2是同一个人吗?" + p1.equals(p2));
        System.out.println("p1.hashCode=" + p1.hashCode());
        System.out.println("p2.hashCode=" + p2.hashCode());
        System.out.println("-----------华丽的分割线------------");
        HashSet<Person> set = new HashSet<>();
        set.add(p1);
        set.add(p2);
        System.out.println("set长度="+ set.size());
    }
}
