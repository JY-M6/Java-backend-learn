import java.util.*;
public class Main {
    public static void main(String[] args) {
        List list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println("普通for循环遍历：");
        for(int i = 0; i< list.size(); i++){
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
        System.out.println("增强for循环遍历：");
        for(Object a:list){
            System.out.print(a);
        }
        System.out.println();
        System.out.println("iterator()循环遍历：");
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next());
        }
    }
}