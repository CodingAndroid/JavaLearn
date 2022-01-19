package 多线程.interrupt;

/**
 * 作者: lihui1
 * 日期: 2021/5/19 7:41 下午
 * 描述: 最佳实践: catch了InterruptedException之后的优先选择: 在方法签名中抛异常
 * 在run()就会强制try/catch
 */
public class RightWayStopThreadInProd implements Runnable{

    @Override
    public void run() {
        while (true){
            System.out.println("go");
            try {
                throwInMethod();
            } catch (InterruptedException e) {
                //保存日志、停止程序
                System.out.println("保存日志");
                e.printStackTrace();
            }
        }
    }

    //优先选择: 添加方法签名
    private void throwInMethod() throws InterruptedException {
        Thread.sleep(2000);
    }

    //try/catch
    private void throwInMethodByTryCatch(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadInProd());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
