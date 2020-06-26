package mulThread;

/**
 * author: lihui1
 * date: 2019/7/19
 * email: 1316994947@qq.com
 * desc: 实现Runnable接口
 */

public class CustomRunnable implements Runnable{

    private int ticketCount = 100;

    @Override
    public void run() {
        System.out.println("实现Runnable接口");
    }
}
