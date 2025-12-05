import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static java.lang.Class.forName;

public class Homework2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Class clazz = forName("java.io.File");
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        Constructor constructor = clazz.getConstructor(String.class);
        Object obj =constructor.newInstance("d:\\java\\a.txt");
        Method m = clazz.getMethod("createNewFile");
        m.invoke(obj);
        System.out.println("创建成功");
    }
}
