import java.util.*;
@SuppressWarnings({"all"})
public class Main {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("1000",new Employee("leo",100000,"1000"));
        map.put("1001",new Employee("luce",10000,"1001"));
        map.put("1002",new Employee("james",20000,"1002"));
        System.out.println(map);
        System.out.println("第一种遍历如下：");
        Set set = map.keySet();
        for (Object key : set) {
            Employee employee = (Employee) map.get(key);
            if (employee.getSalary() > 18000) {
                System.out.println(employee);
            }
        }
        Iterator iterator = set.iterator();
            while (iterator.hasNext()) {
                Object key = iterator.next();
                //if (key.getSalary() > 18000) {
                    System.out.println(map.get(key));
                //}
            }
        System.out.println("第二种遍历如下：");
            Set set1 = map.entrySet();
            for (Object key : set1) {
                Map.Entry entry = (Map.Entry) key;
                Employee employee1 = (Employee) entry.getValue();
                if (employee1.getSalary() > 18000) {
                    System.out.println(employee1);
                }
            }
            Iterator iterator1 = set1.iterator();
            while (iterator1.hasNext()) {
                Map.Entry entry = (Map.Entry) iterator1.next();
                Employee employee1 = (Employee) entry.getValue();
                if (employee1.getSalary() > 18000) {
                    System.out.println(employee1);
                }
            }
    }
}
class Employee {
    private String name;
    private int salary;
    private String id;

    public Employee(String name, int salary, String id) {
        this.name = name;
        this.salary = salary;
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return salary == employee.salary && Objects.equals(name, employee.name) && Objects.equals(id, employee.id);
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public String getId() {
        return id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary, id);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", id='" + id + '\'' +
                '}';
    }
}