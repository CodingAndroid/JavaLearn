package OOP.model;

/**
 * author: lihui1
 * date: 2019/8/25
 * email: 1316994947@qq.com
 * desc:
 */

public class Person {

    private String name;

    private int age;

    private boolean male;

    int num = 10;

    public Person() {
    }

    public Person(String name, int age, boolean male) {
        this.name = name;
        this.age = age;
        this.male = male;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public boolean isMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    public void setAge(int age) {
        if (age <=0){
            System.out.println("输入的数据不正确");
        }
        this.age = age;
    }

    public void method(){
        System.out.println("父类方法");
    }

    public void show(){
        System.out.println("姓名=" + name + "," + "年龄=" + age + "," + "男性=" + male);
    }

    public void study(){
        System.out.println("静态父类方法");
    }

    public void message(){
        System.out.println("final");
    }
}
