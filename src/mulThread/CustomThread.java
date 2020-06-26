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
        try {
            sleep(3000);
        } catch (InterruptedException | IllegalArgumentException e){
            e.printStackTrace();
        }
        System.out.println("继承Thread类" + "," + getName() + "," + currentThread());
    }
}
