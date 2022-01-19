package OOP;

/**
 * author: lihui1
 * date: 2020/1/9
 * email: 1316994947@qq.com
 * desc:
 */

public class Man extends CommonPerson implements Ability{

    public Man(String name, int age, String personId, String address, String education) {
        super(name, age, personId, address, education);
    }

    //可以不实现
    @Override
    public void eat() {
        super.eat();
        System.out.println("大部分男人都喝酒...");
    }

    @Override
    public void skill() {
        System.out.println("男人要有一门技术活");
    }

    @Override
    public void doWork() {
        System.out.println("挣钱养家");
    }

    @Override
    public void foo() {
        System.out.println("default foo");
    }

    @Override
    public void study() {
        System.out.println("学习学习再学习...");
    }

    public static void main(String[] args) {
        Man man = new Man("", 30, "", "", "大学");
        man.eat();
        man.skill();
        man.doWork();
        man.study();
        man.foo();
        Ability.play();
    }
}
