package ChapterSix;

import java.util.concurrent.atomic.*;
import java.util.function.IntBinaryOperator;

public class AtomicClass {
    public static void main(String[] args) {
        System.out.println("基本类型原子类");
        DoAtomicInteger();
        System.out.println("引用类型原子类");
        DoAtomicReference();
        System.out.println("数组原子类");
        DoAtomicIntegerArray();
    }
    public static void DoAtomicInteger() {
        AtomicInteger i = new AtomicInteger();
        //++i
        System.out.println(i.incrementAndGet());
        //i++
        System.out.println(i.getAndIncrement());
        //--i
        System.out.println(i.decrementAndGet());
        //i--
        System.out.println(i.getAndDecrement());
        //先返再i+5
        System.out.println(i.getAndAdd(5));
        //先加再返
        System.out.println(i.addAndGet(5));
        System.out.println(i.getAndSet(5));
        IntBinaryOperator customFunc = (current, x) -> current * 2 + x;
        System.out.println(i.getAndAccumulate(4, customFunc));
        System.out.println(i.get());
    }
    public static void DoAtomicReference() {
        // 原子更新引用
        AtomicReference<User> userRef = new AtomicReference<>();
        User user = new User("John");
        userRef.set(user);

// 原子更新引用字段
        AtomicReferenceFieldUpdater<Person, String> updater =
                AtomicReferenceFieldUpdater.newUpdater(Person.class, String.class, "name");
        Person person = new Person("John");
        updater.set(person, "Mike");
        System.out.println(updater.get(person));
        System.out.println(updater.compareAndSet(person, "Mike", "Ann"));
        System.out.println(updater.get(person));


// 解决ABA问题（带版本号）
        AtomicStampedReference<Integer> stampedRef =
                new AtomicStampedReference<>(100, 0);
        System.out.println(stampedRef.getReference());
        stampedRef.compareAndSet(100, 200, 0, 1);// 检查值和版本号
        System.out.println(stampedRef.getReference());
    }
    public static void DoAtomicIntegerArray() {
        AtomicIntegerArray array = new AtomicIntegerArray(3);

        for (int i = 0; i < array.length(); i++) {
            array.set(i, array.get(i) + 1);
        }
        System.out.println("数组设置值");
        for (int i = 0; i < array.length(); i++) {
            System.out.println(array.get(i));
        }
        System.out.println("用CAS改变值");
        System.out.println(array.compareAndSet(0, 1,3));
        System.out.println(array.get(0));
    }
}
class User {
    private String name;

    public User(String name) {
        this.name = name;
    }
}
class Person{
    volatile String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}