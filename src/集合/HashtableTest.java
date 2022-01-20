package 集合;

import java.util.Hashtable;

/**
 * 作者: lihui1
 * 日期: 2021/7/13 10:57 上午
 * 描述:
 */
public class HashtableTest {

    public static void main(String[] args) {
        Hashtable<String, String> hashtable = new Hashtable<>();
        hashtable.put("key", "80%");
        System.out.println(hashtable.get("key"));
    }
}
