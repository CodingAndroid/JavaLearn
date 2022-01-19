package Generic.model;

/**
 * 作者: lihui1
 * 日期: 2020/11/1 9:07 下午
 * 描述:
 */
public class Person extends Human{

    private String name;
    private int age;

    /**
     * 泛型方法
     * @param t
     * @param <T>
     */
    public <T> Person(T t){

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
