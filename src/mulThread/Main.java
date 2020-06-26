package mulThread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * author: lihui1
 * date: 2019/7/19
 * email: 1316994947@qq.com
 * desc:
 * 并行: 在同一时刻, 有多个指令在多个CPU同时执行;
 * 并发: 在同一时刻, 有多个指令在单个CPU交替执行;
 *
 * 线程与进程:
 *    进程:(是正在运行的软件)进程是一个独立运行的基本单位, 同时也是系统分配资源和调度的独立单位;
 *        进程的实质是程序的一次执行过程, 进程是动态产生，动态消亡的;
 *        任何进程都可以同其他进程一起并发执行;
 *    线程:是进程中的单个顺序控制流, 是一条执行路径;
 *        单线程:一个进程如果只有一条执行路径, 则称为单线程程序;
 *        多线程:一个进程如果有多条执行路径, 则称为多线程程序;
 *    区别:
 *
 * 多线程的创建方式
 *   1.继承Thread类, 实质上是实现了Runnable接口的一个实例
 *   2.实现Runnable接口
 *   3.实现Callable接口
 *   4.线程池
 * 线程的生命周期:
 *   新建: 使用new关键字和Thread类或其子类建立一个线程对象后, 该线程对象就处于新建状态, 它保持这个状态直到程序start()这个线程;
 *   就绪: 当线程对象调用了start()方法之后, 该线程就进入就绪状态。就绪状态的线程处于就绪队列中, 要等待JVM里线程调度器的调度。
 *   运行:
 *   阻塞:
 *   死亡:
 * 线程安全问题:
 *   同步代码块（synchronized）
 *   同步方法（synchronized）
 *   同步锁（ReenreantLock）
 *   特殊域变量（volatile）
 *   局部变量（ThreadLocal）
 *   阻塞队列（LinkedBlockingQueue）
 *   原子变量（Atomic*）
 *
 *  ThreadLocal类用来提供线程内部的局部变量。
 *  这种变量在多线程环境下访问(通过get或set方法访问)时能保证各个线程里的变量相对独立于其他线程内的变量。
 *  ThreadLocal实例通常来说都是private static类型的, 用于关联线程和线程的上下文。
 *  可以总结为一句话：ThreadLocal的作用是提供线程内的局部变量, 这种变量在线程的生命周期内起作用,
 *  减少同一个线程内多个函数或者组件之间一些公共变量的传递的复杂度。
 */

public class Main {

    private static final ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {

        /*获取当前线程对象*/
        System.out.println(Thread.currentThread());

        /*方式一 继承Thread类*/
        CustomThread customThread = new CustomThread();
        customThread.setName("线程名");
        customThread.start();

        /*方式二 实现Runnable接口*/
        CustomRunnable customRunnable = new CustomRunnable();
        Thread thread = new Thread(customRunnable);
        thread.start();

        /*方式三 实现Callable接口*/
        CustomCallable customCallable = new CustomCallable();
        FutureTask<String> futureTask = new FutureTask<>(customCallable);
        Thread t = new Thread(futureTask);
        t.start();
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        /*方式四 线程池*/
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit(customRunnable);
        executorService.shutdown();

        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++){
            int index = i;
            threads[i] = new Thread(() -> {
               threadLocal.set("java" + index);
                System.out.println(Thread.currentThread().getName() + ":" + threadLocal.get());
            }, "thread-" + index);
        }

        for (Thread tt : threads){
            tt.start();
        }
    }
}
