 //TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
import java.util.*;
 public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Please input the employee's name:");
        String name = sc.nextLine();
        System.out.printf("\nPlease input the employee's age:");
        int age = sc.nextInt();
        System.out.printf("\nPlease input the employee's sarary:");
        double salary = sc.nextDouble();
        System.out.println("\nPlease input the employee's bonus:");
        double bonus = sc.nextDouble();
        Employee employee = new Employee(name, age, salary, bonus);
        employee.get();
    }
}
class Employee {
    private String name;
    private int age;
    private double salary;
    private double bonus;

    public Employee(String name, int age, double salary, double bonus) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.bonus = bonus;
    }
    public void get() {
        System.out.println("Employee's name: " + name);
        System.out.println("Employee's age: " + age);
        System.out.printf("Employee's income: %.1f", salary+bonus );
    }
}