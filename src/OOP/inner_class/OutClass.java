package OOP.inner_class;

/**
 * 作者: lihui1
 * 日期: 2021/8/28 3:10 下午
 * 描述:
 */
public class OutClass {

    class Content{

        private int i = 100;

        public int value(){
            return i;
        }
    }

    class Destination{
        private String label;

        public Destination(String label){
            this.label = label;
        }

        String getLabel(){
            return label;
        }
    }

    public void ship(){
        Content content = new Content();
        Destination destination = new Destination("Java");
        System.out.println(destination.getLabel());
        runnable.run();
    }

    class InnerRunnable implements Runnable{

        @Override
        public void run() {
            System.out.println("InnerRunnable run");
        }
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            System.out.println("匿名内部类");
        }
    };

    public static void main(String[] args) {
        OutClass outClass = new OutClass();
        outClass.ship();
    }
}
