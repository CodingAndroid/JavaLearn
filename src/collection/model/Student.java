package collection.model;

import java.util.Objects;

/**
 * author: lihui1
 * date: 2020/1/9
 * email: 1316994947@qq.com
 * desc:
 */

public class Student {

    private String name;

    private Integer age;

    private String grade;

    private Integer stuId;

    public Student(String name, Integer age, String grade, Integer stuId) {
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.stuId = stuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) &&
                Objects.equals(age, student.age) &&
                Objects.equals(grade, student.grade) &&
                Objects.equals(stuId, student.stuId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, grade, stuId);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", grade='" + grade + '\'' +
                ", stuId=" + stuId +
                '}';
    }
}
