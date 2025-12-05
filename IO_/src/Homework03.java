import java.io.*;
import java.util.Properties;

public class Homework03 {
    public static void main(String[] args) throws IOException {
        Properties prop = new Properties();
        String path = "d:\\java\\trial\\IO_\\src\\dog.properties";
        prop.load(new FileReader(path));
        String name = prop.getProperty("name");
        int age = Integer.parseInt(prop.getProperty("age")+"");
        String color = prop.getProperty("color");
        Dog dog =new Dog(name,age,color);
        System.out.println(dog);
        String filepath = "d:\\java\\trial\\IO_\\Dog.dat";
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filepath));
        out.writeObject(dog);
        out.close();
}

}
class Dog implements Serializable {
    private String name;
    private int age;
    private String color;

    public Dog(String name, int age, String color) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}