package 反射;

/**
 * 作者: lihui1
 * 日期: 2021/5/12 4:13 下午
 * 描述:
 */
public class Person {

    public String gender;

    private int age;

    private String name;

    public Person() {
        super();
    }

    private Person(int age){
        super();
        this.age = age;
    }

    public Person(int age, String name) {
        super();
        this.age = age;
        this.name = name;
    }

    public Person(String gender, int age, String name) {
        this.gender = gender;
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        System.out.println("age=" + age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    private void work(){
        System.out.println("我是私有方法: do work");
    }

    protected void study() {
        System.out.println("我是protected方法: do study");
    }

    void show(){
        System.out.println("我是没有修饰符的方法: do show");
    }
}
