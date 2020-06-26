package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * author: lihui1
 * date: 2018/6/11
 * email: 1316994947@qq.com
 * desc:
 */

public class JVMTest {

    public static void main(String[] args) {
        String base = "hello";
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < Integer.MAX_VALUE; i++){
            String str = base + base;
            base = str;
            list.add(str.intern());
        }
    }
}
