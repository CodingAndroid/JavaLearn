package 反射;

/**
 * 作者: lihui1
 * 日期: 2021/5/12 2:43 下午
 * 描述:
 */
public class Servant {

    public boolean service(String message){
        System.out.println(message + ","+ "java语言");
        return true;
    }

    @Override
    public String toString() {
        return "java基础知识";
    }
}
