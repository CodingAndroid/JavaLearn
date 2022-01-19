package 关键字;

/**
 * synchronized关键字解决的是多个线程之间访问资源的同步性, synchronized关键字可以保证被它
 * 修饰的方法或者代码块在任意时刻只能有一个线程执行。
 *
 * synchronized修饰代码块:
 *
 * synchronized修饰方法:
 *
 * synchronized修饰静态方法:
 *
 * 尽量不要使用synchronized(String a)因为JVM中, 字符串常量池具有缓存功能！
 *
 * synchronized与原子性:
 *
 * synchronized与可见性
 *
 * synchronized与有序性
 */
public class SynchronizedApp {

    final String lock = "lock";

    final Object object = new Object();//用final修饰object, 避免它在同步块中被重新赋值。

    public void show(){
        //class对象:被锁的是类对象
        synchronized (SynchronizedApp.class){
            System.out.println("同步代码块");
        }
    }

    public void code(){
        //实例对象:被锁的是类的实例对象
        synchronized (this){
            System.out.println("同步代码块");
        }
    }

    public void todo(){
        //任意实例对象Object:被锁的是配置的实例对象
        synchronized (lock){
            System.out.println("同步代码块");
        }
        //synchronized(object)锁的是object这个引用所指向的对象, 而不是锁引用。
        synchronized (object){
            System.out.println("同步代码块");
        }
    }

    /**
     * 被锁的是该类的实例对象
     */
    public synchronized void process(){
        System.out.println("同步方法");
    }

    /**
     * 被锁的是类对象
     */
    public static synchronized void method(){
        System.out.println("同步静态方法");
    }

    public static void main(String[] args) {
        SynchronizedApp app = new SynchronizedApp();
        app.show();
        app.code();
        app.todo();
        app.process();
        SynchronizedApp.method();
    }
}
