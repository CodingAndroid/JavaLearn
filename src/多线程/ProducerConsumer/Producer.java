package 多线程.ProducerConsumer;

import java.util.Queue;

/**
 * author: lihui1
 * date: 2020/1/11
 * email: 1316994947@qq.com
 * desc:
 */

public class Producer<T> {

    private Queue<T> tasks;

    private int maxTaskCount = 0;

    public Producer(Queue<T> tasks, int maxTaskCount) {
        this.tasks = tasks;
        this.maxTaskCount = maxTaskCount;
    }

    public void produce(T task) throws InterruptedException{
        synchronized (tasks){
            while (tasks.size() >= maxTaskCount){
                System.out.println("生产者线程进入等待:" + Thread.currentThread().getName());
                tasks.wait();
            }
            tasks.add(task);
            tasks.notifyAll();
        }
    }
}
