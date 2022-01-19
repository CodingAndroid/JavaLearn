package 关键字;


/**
 * author: lihui1
 * date: 2019/7/17
 * email: 1316994947@qq.com
 * desc: final关键字
 * final variable -> 创建常量
 * final method -> 阻止方法被重写(override)
 * final classes -> 阻止类被继承(inherit)
 * 当final修饰变量时, 被修饰的变量必须被初始化(赋值), 且后续不能修改其值, 实质上是常量;
 * 当final修饰方法时, 被修饰的方法无法被所在类的子类重写(覆写);
 * 当final修饰类时, 被修饰的类不能被继承, 并且final类中的所有成员方法都会被隐式地指定为final方法, 但成员变量则不会变;
 *
 * final关键字在效率上的作用
 * 缓存: final配合static关键字提高了代码性能, JVM和Java应用都会缓存final变量;
 * 同步: final变量或对象是只读的, 可以安全的在多线程环境下进行共享, 而不需要额外的同步开销;
 * 内联: 使用final关键字, JVM会显式地主动对方法、变量及类进行内联优化;
 * 保证内存同步
 */

public class FinalApp {

    //在类成员中final经常和static一起使用, 作为类常量使用,
    //其中类常量必须在声明时初始化(或者在静态代码块初始化),
    //final成员常量可以在构造函数初始化(或者在instance-initializer块初始化);
    //没有初始化会报错
    //对于类常量, JVM会缓存在常量池中，在读取该变量时不会加载这个类
    public final static int i = 100;

    final int THRESHOLD = 5; //可以在声明时初始化final变量

    static final double PI = 3.1415926; //静态final类常量

    private final String NAME = "java";

    private final int SIZE; //空的final成员变量

    private static final int CAPACITY; //空的静态final成员变量

    private final int COUNT; //空的final成员变量

    public FinalApp(){
        SIZE = 100; //构造函数初始化空的final变量
    }

    public FinalApp(int SIZE){
        this.SIZE = SIZE;
    }

    {
        COUNT = 10; //在instance-initializer块初始化空的final变量
    }

    static {
        CAPACITY = 100; //静态代码块初始化空的final静态变量
    }

    /**
     * 关键字 final 还可以用于修饰方法中的参数。在方法的参数列表中是可以把参数声明为 final 的，这意味着我们没有办法在方法内部对这个参数进行修改
     * @param a
     */
    public void study(final int a){
        int m = 100; //局部变量在使用以前必须显式初始化或赋值, 局部变量没有默认值, 否则编译报错;
        System.out.println(m + "," + a);
        //a = 100;  //编译错误, 不允许修改final参数的值
    }

    /**
     * final修饰的方法是不能够被子类重写(覆盖)的
     * 将方法声明为final, 在编译的时候就已经静态绑定了, 不需要在运行时动态绑定
     * final方法调用时使用的是invokespecial指令
     * 静态编译, 提高调用速度
     */
    public final void show(){
        System.out.println("show");
    }

    /**
     * final修饰的方法是可以被重载的
     * @param age
     */
    public final void show(int age){
        System.out.println(age);
    }

    public void buy(){
       final int p = 0; //等号右边直接赋值
    }

    public void foo(){
        final int f;
        f = 100; //使用前赋值
        System.out.println(f);
    }

    public void eat(){
        final int k; //这是允许的，因为a没有被使用
    }

    public static void main(String[] args) {
        int a; //声明变量, 内存开辟栈内存空间
        a = 10; //赋值, 常量区取得常量, 复制一份存入a空间
        a = 100; //改变变量的值
        final int age = 10; //final修饰的是一个基本数据类型的数据, 一旦赋值后就不能再次更改
        /*
        final修饰引用类型变量student, student仅仅保存对象的引用,
        final只保证这个引用类型变量所引用的内存地址不会发生改变, 不能指向其他对象;
        即一直引用这个对象, 但是这个对象的属性是可以改变的.
        */
        final Student student = new Student(10);
        student.age = 20;
        System.out.println("age="+student.age);
        System.out.println("student.goodStudent.name= " +
                "" + student.goodStudent.name);
        final int[] array = new int[]{1, 2, 3};
        array[0] = 10;
        System.out.println(array[0]);

        FinalApp app = new FinalApp();
        app.study(100);
        app.study(200);
        FinalApp finalApp = new FinalApp(300);
        System.out.println(finalApp.SIZE);
    }


    static class Person{

        public void buy(){

        }

        /**
         * 被final修饰的方法不可以被重写, 不能被override
         */
        public final void show(){
            System.out.println("show --");
        }

        /**
         * private修饰方法默认是final的, 即不可继承的
         */
        private void study(){

        }
    }
    static class Student extends Person{
        int age;
        final GoodStudent goodStudent = new GoodStudent("java");


        public Student(int age) {
            this.age = age;
        }

        @Override
        public void buy() {
            super.buy();
        }

        private void study(){
            System.out.println("study");
        }
    }

    static class GoodStudent{
        String name;

        GoodStudent(String name){
            this.name = name;
        }
    }
}
