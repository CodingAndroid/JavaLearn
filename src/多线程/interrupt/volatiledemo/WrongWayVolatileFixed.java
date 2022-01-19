package 多线程.interrupt.volatiledemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 作者: lihui1
 * 日期: 2021/5/21 5:00 下午
 * 描述: 用中断修复无尽等待的问题
 */
public class WrongWayVolatileFixed {

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
        producerThread.interrupt();
    }

    static class Producer implements Runnable{

        BlockingQueue<Integer> storage;

        public Producer(BlockingQueue<Integer> storage) {
            this.storage = storage;
        }

        @Override
        public void run() {
            int num = 0;
            try{
                while (num <= 100000 && !Thread.currentThread().isInterrupted()){
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

    static class Consumer{
        BlockingQueue<Integer> storage;

        public Consumer(BlockingQueue<Integer> storage) {
            this.storage = storage;
        }

        public boolean needMoreNums(){
            return !(Math.random() > 0.95);
        }
    }
}
