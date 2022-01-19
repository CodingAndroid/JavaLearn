package 多线程;

/**
 * 作者: lihui1
 * 日期: 2021/5/22 3:09 下午
 * 描述: 3个线程, 线程1和线程2首先被阻塞, 线程3唤醒它们,
 * start先执行不代表先启动
 */
public class WaitNotifyAll implements Runnable{

    private static final Object resourceA = new Object();

    @Override
    public void run() {
        synchronized (resourceA){
            System.out.println(Thread.currentThread().getName() + " got resourceA lock");
            try {
                System.out.println(Thread.currentThread().getName() + " wait to start");
                resourceA.wait();
                System.out.println(Thread.currentThread().getName() + " waiting to end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new WaitNotifyAll();
        Thread threadA = new Thread(runnable);
        threadA.setName("threadA");
        Thread threadB = new Thread(runnable);
        threadB.setName("threadB");
        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA){
                    resourceA.notifyAll();
                    System.out.println("ThreadC notified");
                }
            }
        });
        threadA.start();
        threadB.start();
        Thread.sleep(200);
        threadC.start();
    }
}
