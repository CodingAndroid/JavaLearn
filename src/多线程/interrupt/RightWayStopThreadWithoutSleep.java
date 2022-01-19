package 多线程.interrupt;

/**
 * 作者: lihui1
 * 日期: 2021/5/19 4:47 下午
 * 描述: 普通情况下停止线程, 没有sleep的中断线程的写法
 */
public class RightWayStopThreadWithoutSleep implements Runnable{

    @Override
    public void run() {
        int num = 0;

        while (!Thread.currentThread().isInterrupted() && num <= Integer.MAX_VALUE / 2){
            if (num % 10000 == 0){
                System.out.println(num + "是10000的倍数");
            }
            num++;
        }
        System.out.println("任务运行结束了");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new RightWayStopThreadWithoutSleep());
        thread.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
