package 多线程.interrupt.volatiledemo;

/**
 * 作者: lihui1
 * 日期: 2021/5/21 3:50 下午
 * 描述: 用volatile 设置boolean 标志位
 */
public class WrongWayVolatile implements Runnable{

    private volatile boolean canceled = false;

    @Override
    public void run() {
        int num = 0;
        try{
            while (num <= 100000 && !canceled){
                if (num % 100 == 0){
                    System.out.println(num + "是100的倍数");
                }
                num++;
                Thread.sleep(1);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        WrongWayVolatile r = new WrongWayVolatile();
        Thread thread = new Thread(r);
        thread.start();
        Thread.sleep(5000);
        r.canceled = true;
    }
}
