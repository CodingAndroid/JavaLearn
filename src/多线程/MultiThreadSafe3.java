package 多线程;

import java.util.HashMap;

public class MultiThreadSafe3 {

    private HashMap<String, String> states;

    public MultiThreadSafe3(){
        states = new HashMap<>();
        states.put("1", "周一");
        states.put("2", "周二");
        states.put("3", "周三");
        states.put("4", "周四");
        states.put("5", "周五");
    }

    private HashMap<String, String> getStates(){
        return states;
    }

    public static void main(String[] args) {
        MultiThreadSafe3 instance = new MultiThreadSafe3();
        HashMap<String, String> states = instance.getStates();
        System.out.println(states.get("1"));
        states.remove("1");
        System.out.println(states.get("1"));
    }
}
