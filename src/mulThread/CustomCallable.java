package mulThread;

import java.util.concurrent.Callable;

/**
 * author: lihui1
 * date: 2019/7/19
 * email: 1316994947@qq.com
 * desc:实现Callable接口
 */

public class CustomCallable implements Callable<String> {

    //实现call()方法, 该call()方法将作为线程执行体, 并且有返回值
    @Override
    public String call() {
        for (int i = 0; i < 10; i++) {
            System.out.println("实现Callable接口" + i);
        }
        return "finished";
    }
}
