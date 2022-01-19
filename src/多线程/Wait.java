package 多线程;

/**
 * 作者: lihui1
 * 日期: 2021/5/22 2:54 下午
 * 描述: 展示wait 和 notify的基本用法
 * 研究代码执行顺序
 * 证明wait释放锁
 */
public class Wait {

    public static Object object = new Object();

    static class Thread1 extends Thread {

        @Override
        public void run() {
            super.run();
            synchronized (object){
                System.out.println(Thread.currentThread().getName() + "开始执行了");
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程" + Thread.currentThread().getName() + "获取到了锁");
            }
        }
    }

    static class Thread2 extends Thread {

        @Override
        public void run() {
            super.run();
            synchronized (object){
                object.notify();
                System.out.println("线程" + Thread.currentThread().getName() + "调用了notify");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
        thread1.start();
        Thread.sleep(200);
        thread2.start();
    }
}
