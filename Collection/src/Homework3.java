import java.util.*;

public class Homework3 {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("jack",650);
        map.put("tom",1200);
        map.put("smith",2900);
        map.put("jack",2600);
        System.out.println(map);
        for (Object key : map.keySet()) {
            System.out.print(key + ":" + ((Integer)map.get(key)+100)+"   ");
        }
        Set set = map.entrySet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        for(Object value:map.values()) {
            System.out.println(value);
        }
}
}