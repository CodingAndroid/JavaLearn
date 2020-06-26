package object.model;

/**
 * author: lihui1
 * date: 2019/8/25
 * email: 1316994947@qq.com
 * desc:
 */

public class Person {

    private String name;

    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this){
            return true;
        }
        if (obj == null){
            return false;
        }
        //if (getClass() == obj.getClass())使用反射机制  等价于obj instanceof Person
        if (obj instanceof Person){
            Person p = (Person) obj;
            return this.name.equals(p.name) && this.age.equals(p.age);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (name == null ? 0 : name.hashCode());
        result = 31 * result + (age == null ? 0 : age.hashCode());
        return result;
    }
}
