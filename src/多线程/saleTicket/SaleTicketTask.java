package 多线程.saleTicket;

/**
 * 作者: lihui1
 * 日期: 2021/5/21 1:03 下午
 * 描述:
 */
public class SaleTicketTask extends Thread{

    private int ticketNumbers = 5;

    public SaleTicketTask(String name) {
        super(name);
    }

    @Override
    public void run() {
        super.run();
        while (ticketNumbers > 0){
            System.out.println(Thread.currentThread().getName() + "卖票：ticketNumbers=" + ticketNumbers--);
        }
    }
}
