package Generic;

import Generic.model.*;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;

public class GenericType {

    /**
     * 通配符上限
     * ArrayList存的是Person本身以及Person的子类
     * 存在上界通配符, 因为具体类型不确定, 也是只能读不能写的
     * @param arrayList
     */
    public static void printUpper(ArrayList<? extends Person> arrayList){
        Iterator<Person> iterator = (Iterator<Person>) arrayList.iterator();
        while (iterator.hasNext()){
            Person person = iterator.next();
            System.out.println(person);
        }
    }

    /**
     * 通配符下限
     * ArrayList存的是Person本身以及Person的父类
     * @param arrayList
     */
    public static void printLower(ArrayList<? super Person> arrayList){
        Iterator<Person> iterator = (Iterator<Person>) arrayList.iterator();
        while (iterator.hasNext()){
            Person person = iterator.next();
            System.out.println(person);
        }
    }

    public static void test(ArrayList<?> list){

    }

    static class  GenericTest<T>{

        public void show(T t){
            System.out.println("t=" + t);
        }

        public <E> void study(E e){
            System.out.println("e=" + e);
        }

        public <T> void method(T t){
            System.out.println("t=" + t);
        }
    }

    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        arrayList.add("Java");
        integerArrayList.add(1000);
        System.out.println(arrayList.size() + integerArrayList.size());
        System.out.println(arrayList.getClass() == integerArrayList.getClass()); //true
        System.out.println(arrayList.getClass().getName()); //java.util.ArrayList
        System.out.println(integerArrayList.getClass().getName()); //java.util.ArrayList


        Person person = new<String, Integer> Person("", 1);
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Java", 30));
        students.add(new Student("C++", 20));

        ArrayList<Worker> workers = new ArrayList<>();
        workers.add(new Worker("PHP", 55));
        workers.add(new Worker("Kotlin", 60));

        printUpper(students);
        printUpper(workers);

        ArrayList<?> list = new ArrayList<Student>();
        list = new ArrayList<Worker>();
        test(list);

        ArrayList<? super Worker> workList = new ArrayList<>();
        workList.add(new Worker("", 10));
        System.out.println(workList.size());

        ArrayList<? extends Person> personList = new ArrayList<>();
        //personList.add(new Worker("", 10));  //报红, 不能写

        ArrayList<? super Person> pList = new ArrayList<>();
        pList.add(0, new Worker("", 10)); //只能设置Person的子类
        //pList.add(1, new Human()); //报红

        Teacher<String> teacher = new Teacher<>();
        teacher.setTeacherName("掌小萌");
        try {
            Field value = teacher.getClass().getDeclaredField("teacherName");
            Class<?> type = value.getType();
            String name = type.getName();
            System.out.println("type:" + name);

            Method getTeacherName = teacher.getClass().getDeclaredMethod("getTeacherName");
            Object invoke = getTeacherName.invoke(teacher);
            String methodName = invoke.getClass().getName();
            System.out.println("methodName:" + methodName);
        } catch (NoSuchFieldException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            e.printStackTrace();
        }

        Worker worker = new Worker("java", 50);

        GenericTest<Person> genericTest = new GenericTest<>();
        genericTest.show(worker);
        //genericTest.show(teacher); //报红 teacher 和 Person没有关系
        genericTest.study(worker);
        genericTest.study(teacher);
        genericTest.method(teacher);
        genericTest.method(teacher);
    }
}
