package Generic.model;

/**
 * 作者: lihui1
 * 日期: 2020/11/1 9:07 下午
 * 描述:
 */
public class Worker extends Person{


    public Worker(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                '}';
    }
}
