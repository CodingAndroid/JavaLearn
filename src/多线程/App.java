package 多线程;

import 多线程.saleTicket.TicketThread;

/**
 * author: lihui1
 * date: 2019/7/19
 * email: 1316994947@qq.com
 * desc:
 */

public class App {

    public static void main(String[] args) {

        TicketThread ticketThread = new TicketThread();

        Thread t1 = new Thread(ticketThread, "窗口1");
        t1.start();
        Thread t2 = new Thread(ticketThread, "窗口2");
        t2.start();
        Thread t3 = new Thread(ticketThread, "窗口3");
        t3.start();

    }
}
