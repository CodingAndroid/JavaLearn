package 多线程;

/**
 * 作者: lihui1
 * 日期: 2021/5/22 3:50 下午
 * 描述: 证明wait只释放当前的那把锁
 */
public class WaitNotifyReleaseOwnMonitor {


    private static final Object resourceA = new Object();

    private static final Object resourceB = new Object();

    public static void main(String[] args) {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA){
                    System.out.println("ThreadA got resourceA lock");

                    synchronized (resourceB){
                        System.out.println("ThreadB got resourceB lock");
                        try {
                            System.out.println("ThreadA release resourceA lock");
                            resourceA.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (resourceA){
                    System.out.println("ThreadB got resourceA lock");

                    System.out.println("ThreadB try to resourceB lock");

                    synchronized (resourceB){
                        System.out.println("ThreadB got resourceB lock");
                    }
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
