import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Homework1 {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class clazz = PrivateTest.class;
        Object obj = clazz.newInstance();
        Method method = clazz.getMethod("getName");
        System.out.println("修改前的名字是"+method.invoke(obj));
        Field name =clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(obj,"tom");
        System.out.println("修改后的名字是"+name.get(obj));
    }
}
class PrivateTest{
    private String name = "hellokitty";
    public String getName() {
        return name;
    }
}