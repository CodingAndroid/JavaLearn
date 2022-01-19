package lock.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 作者: lihui1
 * 日期: 2021/8/5 11:49 上午
 * 描述: 使用原子类, 不需要加锁, 也能保证线程安全;
 */
public class AtomicIntegerTest implements Runnable{

    private static final AtomicInteger atomicInteger = new AtomicInteger();

    public void incrementAtomic() {
        atomicInteger.getAndIncrement();
    }

    private static volatile int basicCount = 0;

    public synchronized void incrementBasic(){
        //basicCount++这并不是一个原子操作, 包含了三个步骤：1.读取变量basicCount的值; 2.对basicCount加一; 3.将新值赋值给变量basicCount
        basicCount++;
    }

    public static void main(String[] args) {
        AtomicIntegerTest r = new AtomicIntegerTest();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("原子类的结果:" + atomicInteger.get());
        System.out.println("普通变量的结果:" + basicCount);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++){
            incrementAtomic();
            incrementBasic();
        }
    }
}
