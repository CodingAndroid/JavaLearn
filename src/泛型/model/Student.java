package 泛型.model;

/**
 * 作者: lihui1
 * 日期: 2020/11/1 9:09 下午
 * 描述:
 */
public class Student extends Person{


    public Student(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                '}';
    }
}
