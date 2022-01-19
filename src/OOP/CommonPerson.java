package OOP;

/**
 * author: lihui1
 * date: 2020/1/9
 * email: 1316994947@qq.com
 * desc: 抽象类 abstract class关键字
 * 1.抽象类不允许被实例化, 只能被继承, 不能new一个抽象类的对象
 *   CommonPerson commonPerson = new CommonPerson(...) 会编译报错,
 *   只有抽象类的非抽象子类可以创建对象
 * 2.抽象类可以包含属性和方法, 方法既可以是成员方法(实现方法), 也可以是抽象方法
 *   抽象类中不一定包含抽象方法, 但是有抽象方法的类必定是抽象类
 *   抽象类中的抽象方法只是声明, 不包含方法体, 就是不给出方法的具体实现也就是方法的具体功能
 * 3.子类通过extends继承抽象类, 必须实现抽象类中的所有抽象方法
 * 4.构造方法, 类方法(用static修饰的方法)不能声明为抽象方法
 * 5.抽象类的子类必须给出抽象类中的抽象方法的具体实现, 除非该子类也是抽象类
 *   抽象类可以继承一个类和实现多个接口, 子类只可以继承一个抽象类
 * 6.相同的东西提取, 即重用
 */

public abstract class CommonPerson {

    private String name;

    private int age;

    private String personId;

    private String address;

    private String education;

    public CommonPerson(String name, int age, String personId, String address, String education) {
        this.name = name;
        this.age = age;
        this.personId = personId;
        this.address = address;
        this.education = education;
    }

    public void eat(){
        System.out.println("人人都要吃饭");
    }

    public abstract void skill();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }
}
