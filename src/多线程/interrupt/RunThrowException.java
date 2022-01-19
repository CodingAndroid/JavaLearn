package 多线程.interrupt;

/**
 * 作者: lihui1
 * 日期: 2021/5/21 2:59 下午
 * 描述: run无法check Exception, 只能用try/catch
 */
public class RunThrowException {

    public void run() throws Exception{
        throw new Exception();
    }

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    throw new Exception();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
