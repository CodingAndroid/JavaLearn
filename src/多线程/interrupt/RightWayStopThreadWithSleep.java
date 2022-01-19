package 多线程.interrupt;

/**
 * 作者: lihui1
 * 日期: 2021/5/19 5:25 下午
 * 描述: 线程可能被阻塞: 带有sleep的中断线程的写法
 */
public class RightWayStopThreadWithSleep implements Runnable{

    @Override
    public void run() {
        int num = 0;

        try {
            while (!Thread.currentThread().isInterrupted() && num <= 300){
                if (num % 100 == 0){
                    System.out.println(num + "是100的倍数");
                }
                num++;
            }
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("任务运行结束了");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new RightWayStopThreadWithSleep());
        thread.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
