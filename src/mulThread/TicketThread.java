package mulThread;

import java.text.MessageFormat;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * author: lihui1
 * date: 2019/8/3
 * email: 1316994947@qq.com
 * desc:
 */

public class TicketThread extends Thread{

    private int ticketNum = 100;

    private Lock lock = new ReentrantLock(true);//是否是公平锁- true:公平锁,多个线程公平拥有执行权; false:独占锁, 默认值;

    @Override
    public void run() {
        super.run();
        while (true){
            /*
            方式1. 同步代码块
            synchronized (this){
                if (ticketNum > 0){
                    System.out.println(Thread.currentThread().getName() + MessageFormat.format("正在出售第{0}张票, 剩余{1}张票", 100-ticketNum+1, ticketNum-1));
                    ticketNum--;
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            */
            //sale();
            lock.lock();//方式 3
            try {
                ticketNumChange();
            } finally {
                lock.unlock();
            }
        }
    }

    /**
     * 方式2. 同步方法
     */
    private synchronized void sale(){
        ticketNumChange();
    }

    private void ticketNumChange(){
        if (ticketNum > 0){
            System.out.println(Thread.currentThread().getName() + MessageFormat.format("正在出售第{0}张票, 剩余{1}张票", 100-ticketNum+1, ticketNum-1));
            ticketNum--;
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
