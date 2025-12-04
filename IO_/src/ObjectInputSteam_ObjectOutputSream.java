import java.io.*;

public class ObjectInputSteam_ObjectOutputSream {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String filepath = "d:\\java\\trial\\IO_\\mytemp\\hello4.txt";
        File file = new File(filepath);
        if(file.createNewFile()){
            System.out.println("File created");
        }else{
            System.out.println("File already exists");
        }
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filepath));
        Cat cat = new Cat("Tom",5);
        oos.writeObject(cat);
        oos.close();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filepath));
        Cat cat1 =(Cat)ois.readObject();
        System.out.println(cat1);
        ois.close();
    }
}
class Cat implements Serializable{
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Cat(String name, int age){
        this.name = name;
        this.age = age;
    }
}
