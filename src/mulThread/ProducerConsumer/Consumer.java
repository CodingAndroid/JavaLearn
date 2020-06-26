package mulThread.ProducerConsumer;

import java.util.Queue;

/**
 * author: lihui1
 * date: 2020/1/11
 * email: 1316994947@qq.com
 * desc:
 */

public class Consumer<T> {

    private Queue<T> tasks;

    public Consumer(Queue<T> tasks) {
        this.tasks = tasks;
    }

    public T consume() throws InterruptedException{
        synchronized (tasks){
            while (tasks.size() == 0){
                System.out.println("消费者线程进入等待:" + Thread.currentThread().getName());
                tasks.wait();
            }
            T ret = tasks.poll();
            tasks.notifyAll();
            return ret;
        }
    }
}
