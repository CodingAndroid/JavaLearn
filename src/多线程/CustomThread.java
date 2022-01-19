package 多线程;

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
        System.out.println("继承Thread类-线程名:"+ Thread.currentThread().getName());
    }
}
