package jvm.model;

public class Father {

    public static int num = 10;

    static {
        System.out.println("静态初始化父类Father");
    }

    {
        System.out.println("非静态初始化父类Father");
    }

    public Father(){
        System.out.println("父类构造方法创建父类的对象");
    }
}
