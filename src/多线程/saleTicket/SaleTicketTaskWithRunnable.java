package 多线程.saleTicket;

/**
 * 作者: lihui1
 * 日期: 2021/5/21 1:22 下午
 * 描述:
 */
public class SaleTicketTaskWithRunnable implements Runnable{

    private int ticketNumbers = 5; // 电影票数量

    @Override
    public void run() {
        while (ticketNumbers > 0) {
            System.out.println(Thread.currentThread().getName() + "卖票，ticketNumbers=" + ticketNumbers--);
        }
    }
}
