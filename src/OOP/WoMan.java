package OOP;

import java.lang.reflect.Modifier;

/**
 * 作者: lihui1
 * 日期: 2021/8/4 3:12 下午
 * 描述:
 */
public class WoMan extends CommonPerson{

    public WoMan(String name, int age, String personId, String address, String education) {
        super(name, age, personId, address, education);
    }

    @Override
    public void skill() {

    }

    public static void main(String[] args) {
        WoMan woMan = new WoMan("", 20, "", "", "大学本科");
        woMan.skill();
    }
}
