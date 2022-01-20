package 锁;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 作者: lihui1
 * 日期: 2021/8/4 8:28 下午
 * 描述: 基于CAS线程安全的计数器
 */
public class Counter {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    private int i = 0;

    public static void main(String[] args) {
        final Counter counter = new Counter();
        List<Thread> ts = new ArrayList<>(600);
        long start = System.currentTimeMillis();
        for (int j = 0; j < 100; j++){
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10000; i++){
                        counter.safeCount();
                    }
                }
            });
            ts.add(t);
        }

        for (Thread t : ts){
            t.start();
        }

        //等待所有线程执行完毕
        for (Thread t : ts){
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(counter.i);

        System.out.println(counter.atomicInteger.get());

        System.out.println(System.currentTimeMillis() - start);
    }

    private void safeCount(){
        for (;;){
            int i = atomicInteger.get();
            boolean suc = atomicInteger.compareAndSet(i, ++i);
            if (suc){
                break;
            }
        }
    }
}
