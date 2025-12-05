import java.util.ArrayList;
import java.util.Comparator;

public class Exercise {
    public static void main(String[] args) {
        ArrayList<Employee> list = new ArrayList<>();
        list.add(new Employee("john",1000,new MyDate(2001,1,1)));
        list.add(new Employee("kane",2000,new MyDate(2002,2,2)));
        list.add(new Employee("sane",3000,new MyDate(2003,3,3)));
        list.sort(new Comparator<Employee>() {
            public int compare(Employee e1, Employee e2) {
                return e2.getBirthday().getYear()-e1.getBirthday().getYear();
            }
        });
        list.forEach(System.out::println);

    }
}
class Employee{
    private String name;
    private int sal;
    private MyDate birthday;

    public String getName() {
        return name;
    }

    public Employee(String name, int sal, MyDate birthday) {
        this.birthday = birthday;
        this.sal = sal;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", birthday=" + birthday +
                '}';
    }
}
class MyDate{
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}