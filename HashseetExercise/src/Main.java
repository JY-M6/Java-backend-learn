import java.util.HashSet;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        HashSet set = new HashSet();
        set.add(new Employee("jack",18));
        set.add(new Employee("john",17));
        set.add(new Employee("jack",18));
        System.out.println(set);
    }
}
class Employee {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}