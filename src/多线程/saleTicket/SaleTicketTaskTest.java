package 多线程.saleTicket;

/**
 * 作者: lihui1
 * 日期: 2021/5/21 1:19 下午
 * 描述:
 */
public class SaleTicketTaskTest {

    public static void main(String[] args) {
        // 创建2个售票窗口
        SaleTicketTask s1 = new SaleTicketTask("窗口1");
        SaleTicketTask s2 = new SaleTicketTask("窗口2");
        //开始售票
        s1.start();
        s2.start();
    }
}
