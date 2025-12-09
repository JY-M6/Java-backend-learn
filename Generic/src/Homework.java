import org.junit.jupiter.api.Test;
import java.util.*;

@SuppressWarnings("all")
public class Homework {
    public static void main(String[] args) {
        DAO<User> userDAO = new DAO<>();
        userDAO.map.put("jack",new User("jack",10001,20));
        userDAO.map.put("Baby",new User("Baby",10002,20));
        userDAO.map.put("Ann",new User("Ann",10003,20));
        User user = new User("Candy",10004,20);
        userDAO.save("Candy",user);
        userDAO.update("Baby",user);
        System.out.println(userDAO.list());
        userDAO.delete("Baby");
        System.out.println(userDAO.list());


    }
}

class DAO<T> {
    public Map<String, T> map = new HashMap<>();

    public void save(String id, T entity) {
        map.put(id, entity);
    }

    public T get(String id) {
        return map.get(id);
    }

    public void update(String id, T entity) {
        map.put(id, entity);
    }

    public List<T> list() {
        return new ArrayList<>(map.values());
    }

    public void delete(String id) {
        map.remove(id);
    }
}

class User {
    private String name;
    private int age;
    private int id;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }

    public User(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}