package 泛型.model;

/**
 * 作者: lihui1
 * 日期: 2021/1/4 7:57 下午
 * 描述:
 */
public class Teacher<T> {

    private T teacherName;
    private T age;
    private T address;

    public T getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(T teacherName) {
        this.teacherName = teacherName;
    }

    public T getAge() {
        return age;
    }

    public void setAge(T age) {
        this.age = age;
    }

    public T getAddress() {
        return address;
    }

    public void setAddress(T address) {
        this.address = address;
    }

    public static void main(String[] args) {
        Teacher<String> teacher = new Teacher<>();
        teacher.setTeacherName("Java");
        String param = teacher.getTeacherName();
    }
}
