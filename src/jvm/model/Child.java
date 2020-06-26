package jvm.model;

public class Child extends Father{

    public static final int width = 100;

    /**
     * 静态初始化块
     */
    static {
        System.out.println("静态初始化子类A");
    }

    public Child(){
        System.out.println("子类构造方法创建子类的对象");
    }
}
