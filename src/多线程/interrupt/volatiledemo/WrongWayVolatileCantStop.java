package 多线程.interrupt.volatiledemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 作者: lihui1
 * 日期: 2021/5/21 4:29 下午
 * 描述: 演示 Volatile的局限
 * 陷入阻塞时, Volatile是无法中断线程的
 * 此例子中, 生产者的生产速度很快, 消费者的消费速度很慢, 所以出现阻塞队列满以后, 生产者会阻塞, 等待消费者进一步消费
 */
public class WrongWayVolatileCantStop {

    public static void main(String[] args) throws InterruptedException {

        ArrayBlockingQueue<Integer> storage = new ArrayBlockingQueue<>(10);

        Producer producer = new Producer(storage);
        Thread producerThread = new Thread(producer);
        producerThread.start();
        Thread.sleep(1000);

        Consumer consumer = new Consumer(storage);
        while (consumer.needMoreNums()){
            System.out.println(consumer.storage.take() + "被消费了");
            Thread.sleep(100);
        }
        System.out.println("消费者不需要更多数据了");
        //一旦消费者不需要更多数据了, 我们应该让生产者停下来
        producer.canceled = true;
        System.out.println(producer.canceled);
    }
}

class Producer implements Runnable{

    public volatile boolean canceled = false;

    BlockingQueue<Integer> storage;

    public Producer(BlockingQueue<Integer> storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        int num = 0;
        try{
            while (num <= 100000 && !canceled){
                if (num % 100 == 0){
                    storage.put(num);
                    System.out.println(num + "是100的倍数, 被放到仓库中");
                }
                num++;
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            System.out.println("生产者结束运行");
        }
    }
}

class Consumer{
    BlockingQueue<Integer> storage;

    public Consumer(BlockingQueue<Integer> storage) {
        this.storage = storage;
    }

    public boolean needMoreNums(){
        if (Math.random() > 0.95){
            return false;
        }
        return true;
    }
}
