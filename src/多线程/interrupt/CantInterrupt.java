package 多线程.interrupt;

/**
 * 作者: lihui1
 * 日期: 2021/5/19 5:42 下午
 * 描述: 如果while里面放try/catch, 会导致中断失效
 */
public class CantInterrupt {

    public static void main(String[] args) {

        Runnable runnable = () -> {
            int num = 0;
            while (num <= 10000 && !Thread.currentThread().isInterrupted()){
                if (num % 100 ==0){
                    System.out.println(num + "是100的倍数");
                }
                num++;
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
