package 集合;

import 集合.model.Student;

import java.util.*;

/**
 * author: lihui1
 * date: 2020/1/9
 * email: 1316994947@qq.com
 * desc:
 */

public class MapTest {

    public static void test(){
        HashMap<Integer, String> map = new HashMap<>();
        map.put(0, "java");
        map.put(1, "C++");
        map.put(2, "PHP");
        map.put(3, "Python");
        map.put(4, "Android");
        map.put(5, "Android");
        map.put(6, "c#");
        System.out.println(map);
        System.out.println("------------华丽的分割线------------");
        //获取key-value对(Entry)的set集合
        Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
        for (Map.Entry<Integer, String> entry : entrySet) {
            System.out.print(entry.getKey() + " ");
            System.out.println(entry.getValue());
        }
        System.out.println("------------华丽的分割线------------");
        Iterator<Map.Entry<Integer, String>> iterator = entrySet.iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, String> entry = iterator.next();
            System.out.print(entry.getKey() + " ");
            System.out.println(entry.getValue());
        }
        System.out.println("------------华丽的分割线------------");
        Set<Integer> set = map.keySet();
        for (Integer key : set) {
            System.out.print("key = " + key + " ");
            System.out.println("value = " + map.get(key));
        }
        System.out.println("------------华丽的分割线------------");
        Iterator<Integer> iterator1 = set.iterator();
        while (iterator1.hasNext()){
            Integer key = iterator1.next();
            System.out.print(key + " ");
            System.out.println(map.get(key));
        }
        System.out.println("------------华丽的分割线------------");
        Collection valueSet = map.values();
        Iterator<String> iterator2 = valueSet.iterator();
        while (iterator2.hasNext()){
            String value = iterator2.next();
            System.out.println("value = " + value);
        }
        System.out.println("------------华丽的分割线------------");
        System.out.println("是否包含指定的key:" + map.containsKey(0));
        System.out.println("是否包含指定的value:" + map.containsValue("android"));
        System.out.println("map size=" + map.size());
        System.out.println("map isEmpty=" + map.isEmpty());
        System.out.println("" + map.remove(0));
        System.out.println("" + map);

    }

    public static void test1(){
        HashMap<Student, Integer> map = new HashMap<>();
        Student stu = new Student("Java", 22, "高一", 10001);
        Student stu1 = new Student("C++", 25, "高一", 10001);
        Student stu2 = new Student("PHP", 28, "高一", 10001);
        Student stu3 = new Student("Python", 32, "高一", 10001);
        Student stu4 = new Student("Java", 22, "高一", 10001);
        map.put(stu, 0);
        map.put(stu1, 1);
        map.put(stu2, 2);
        map.put(stu3, 3);
        map.put(stu4, 4);
        map.put(null, null);
        map.put(null, null);
        map.put(stu1, null);
        System.out.println("" + map.get(stu));
        System.out.println(map);
    }

    public static void test2(){
        HashMap<Integer, String> hashMap = new HashMap<>();

    }
}
