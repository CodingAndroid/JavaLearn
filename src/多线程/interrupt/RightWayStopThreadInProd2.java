package 多线程.interrupt;

/**
 * 作者: lihui1
 * 日期: 2021/5/21 3:07 下午
 * 描述: 最佳实践2: 在catch子语句中调用Thread.currentThread().isInterrupted()来恢复设置中断状态,以便在后续的执行中, 依然能够检查到刚才发生了中断;
 */
public class RightWayStopThreadInProd2 implements Runnable{

    @Override
    public void run() {
        while (true){
            if (Thread.currentThread().isInterrupted()){
                System.out.println("isInterrupted, 程序运行结束");
                break;
            }
            System.out.println("go");
            reInterrupt();
        }
    }

    //try/catch
    private void reInterrupt(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadInProd2());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
