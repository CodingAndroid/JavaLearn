package DataType;

/**
 * author: lihui1
 * date: 2019/8/16
 * email: 1316994947@qq.com
 * desc:
 */

public class Main {

    public static void main(String[] args) {

        Integer i = 127; //java在编译Integer i = 127时, 会翻译成Integer i = Integer.valueOf(127), 而valueOf()会对-128~127之间的数进行缓存
        Integer j = 127;
        Integer a = new Integer(127);

        Integer b = 128;
        Integer c = 128;
        int d = 128;
        Integer e = new Integer(128);

        Integer f = new Integer(d);
        Integer g = d;//装箱 Integer.valueOf()
        int h = f.intValue();

        /**
         *java会将[-128,127]之间的数进行缓存。Integer i = 127时, 会将127缓存,
         * Integer j = 127时, 就直接从缓存中取, 不会new了, 所以结果为true。
         */
        System.out.println(i == j); //true
        System.out.println(i == a); //false
        /**
         * Integer b = 128时, 不会将128缓存,
         * Integer c = 128时, 会return new Integer(128), 所以结果为false。
         */
        System.out.println(b == c); //false

        /**
         * 包装类Integer变量在与基本数据类型int变量比较时,
         * Integer会自动拆包装为int, 然后进行比较, 实际上就是两个int变量进行比较, 值相等, 所以为true。
         */
        System.out.println(d == c);
        System.out.println(d == e);
    }
}
