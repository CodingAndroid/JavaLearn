package 多线程;

/**
 * 多线程安全问题: 死锁
 */
public class MultiThreadSafe2 implements Runnable{

    int flag = 1;
    final static Object object1 = new Object();
    final static Object object2 = new Object();

    @Override
    public void run() {
        System.out.println("flag = " + flag);
        if (flag == 1){
            synchronized (object1){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (object2){
                    System.out.println("1");
                }
            }
        }
        if (flag == 0){
            synchronized (object2){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (object1){
                    System.out.println("0");
                }
            }
        }
    }

    public static void main(String[] args) {
        MultiThreadSafe2 instance1 = new MultiThreadSafe2();
        MultiThreadSafe2 instance2 = new MultiThreadSafe2();
        instance1.flag = 1;
        instance2.flag = 0;
        new Thread(instance1).start();
        new Thread(instance2).start();
    }
}
