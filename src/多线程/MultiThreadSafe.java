package 多线程;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 多线程安全问题: a++
 */
public class MultiThreadSafe implements Runnable{

    final static MultiThreadSafe instance = new MultiThreadSafe();
    static AtomicInteger realIndex = new AtomicInteger();
    static AtomicInteger errorCount = new AtomicInteger();
    private static CyclicBarrier cyclicBarrier1 = new CyclicBarrier(2);
    private static CyclicBarrier cyclicBarrier2 = new CyclicBarrier(2);
    final boolean[] marked = new boolean[100000];
    int index = 0;//线程共享

    @Override
    public void run() {
        marked[0] = true;
        for (int i = 0; i < 10000; i++) {
            try {
                cyclicBarrier2.reset();
                cyclicBarrier1.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            index++;
            try {
                cyclicBarrier1.reset();
                cyclicBarrier2.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            realIndex.incrementAndGet();
            synchronized (instance){
                if (marked[index] && marked[index - 1]){
                    System.out.println("发生了错误..."+ index);
                    errorCount.incrementAndGet();
                }
                marked[index] = true;
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
            System.out.println("表面运行结果:" + instance.index);
            System.out.println("实际运行结果:" + realIndex);
            System.out.println("真正运行次数:" + realIndex.get());
            System.out.println("出错次数:" + errorCount.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
