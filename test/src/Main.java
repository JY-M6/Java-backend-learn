import java.util.Comparator;
import java.util.Scanner;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        Integer[] arr = {10, -2, 3, -4, 5};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr,new Comparator(){
            public int compare(Object o1,Object o2){
                int a = (Integer)o1;
                int b = (Integer)o2;
                return b-a;
            }
        });
        System.out.println(Arrays.toString(arr));
        }
    }
