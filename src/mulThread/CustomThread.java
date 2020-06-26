package mulThread;

/**
 * author: lihui1
 * date: 2019/7/19
 * email: 1316994947@qq.com
 * desc: 继承Thread
 */

public class CustomThread extends Thread{

    @Override
    public void run() {
        super.run();
        System.out.println("线程状态:" + Thread.currentThread().getState());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
