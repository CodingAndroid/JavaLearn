package OOP.model;

/**
 * author: lihui1
 * date: 2019/8/25
 * email: 1316994947@qq.com
 * desc:继承的特点
 * 1.Java支持单继承
 * 2.
 */

public class Student extends Person{

    int num = 20;

    @Override
    public void method() {
        super.method();
        System.out.println("子类方法");
    }

    @Override
    public void show() {
        super.show();
        int num = 30;
        System.out.println(num); //30

        System.out.println(this.num);//20

        System.out.println(super.num);//10
    }

    @Override
    public void study() {
        super.study();
    }

    @Override
    public void message() {
        super.message();
    }
}
