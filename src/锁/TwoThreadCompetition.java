package 锁;

/**
 * 作者: lihui1
 * 日期: 2021/8/4 8:14 下午
 * 描述: 当两个线程去竞争CAS时, 其中一个成功, 另一个失败的情况。
 */
public class TwoThreadCompetition implements Runnable{

    private volatile int value;

    public synchronized int compareAndSwap(int expectedValue, int newValue){
        int oldValue = value;

        if (oldValue == expectedValue){
            value = newValue;
            System.out.println(Thread.currentThread().getName() + "执行成功!");
        }
        return oldValue;
    }

    public static void main(String[] args) throws InterruptedException{
        TwoThreadCompetition r = new TwoThreadCompetition();
        r.value = 0;
        Runnable target;
        Thread t1 = new Thread(r, "Thread 1");
        Thread t2 = new Thread(r, "Thread 2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(r.value);
    }

    @Override
    public void run() {
        compareAndSwap(0, 1);
    }
}
