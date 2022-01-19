package 多线程.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalDemo {

    public static ExecutorService threadPool = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {

        for (int i = 0; i < 1000; i++){
            int k = i;
            threadPool.submit(() -> {
                String date = new ThreadLocalDemo().date(k);
                System.out.println(date);
            });
        }
        threadPool.shutdown();
    }

    public String date(int seconds){
        Date date = new Date(1000 * seconds);
//        String d;
//        synchronized (ThreadLocalDemo.class){
//            d = simpleDateFormat.format(date);
//        }

        SimpleDateFormat dateFormat = ThreadSafeFormatter.dateFormatThreadLocal.get();
        return dateFormat.format(date);
    }
}

class ThreadSafeFormatter{

    public static ThreadLocal<SimpleDateFormat> dateFormatThreadLocal =
            ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"));
 }
