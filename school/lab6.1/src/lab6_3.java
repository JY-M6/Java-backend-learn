import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class lab6_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many students?");
        int num = sc.nextInt();

        List<String> names = null;
        if (num >0) {
            System.out.println("Please input the names of students:");
            names = new ArrayList<String>();
            for (int i = 0; i < num; i++) {
                names.add(sc.next());
            }
        }
        System.out.println("All the students bellow:");
        for (int i = 0; i < num; i++) {
            System.out.println(i+1 +":"+ names.get(i));
    }
}
}
