package jvm;

import java.text.DecimalFormat;

public class Main {

    public static void main(String[] args) {

        byte bytes1[] = new byte[1 * 1024 * 1024];
        System.out.println("分配1M");
        jvmInfo();

        byte bytes2[] = new byte[4 * 1024 * 1024];
        System.out.println("分配4M");
        jvmInfo();

        byte bytes3[] = new byte[20 * 1024 * 1024];
        System.out.println("分配20M");
        jvmInfo();
    }

    private static String toM(long maxMemory){
        float num = maxMemory / (1024 * 1024);
        DecimalFormat df = new DecimalFormat("0.00");
        String string = df.format(num);
        return string;
    }

    private static void jvmInfo(){

        long maxMemory = Runtime.getRuntime().maxMemory();
        System.out.println("maxMemory="+ maxMemory + "byte=" + toM(maxMemory)+"M");
        long freeMemory = Runtime.getRuntime().freeMemory();
        System.out.println("freeMemory="+ freeMemory + "byte=" + toM(freeMemory)+"M");
        long totalMemory = Runtime.getRuntime().totalMemory();
        System.out.println("totalMemory="+ totalMemory + "byte=" + toM(totalMemory)+"M");

    }
}
