package 多线程.interrupt;

/**
 * 作者: lihui1
 * 日期: 2021/5/19 5:32 下午
 * 描述: 如果在执行过程中每次循环都会调用sleep或者wait方法, 那么不需要每次迭代都检查是否已经中断;
 */
public class RightWayStopThreadWithSleepEveryLoop implements Runnable{

    @Override
    public void run() {
        int num = 0;

        try {
            while (num <= 10000){
                if (num % 100 == 0){
                    System.out.println(num + "是100的倍数");
                }
                num++;
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("任务运行结束了");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new RightWayStopThreadWithSleepEveryLoop());
        thread.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
