import java.util.Arrays;
import java.util.Comparator;

public class Bubblesort {
    public static void main(String[] args) {
        int[] arr = {1,4,2,6,5,2,6,7};
        Comparator c = new Comparator(){
            public int compare(Object o1, Object o2) {
                return ((Integer)o1).compareTo((Integer)o2);
            }
        };
        bubbleSort(arr,c);
        System.out.println(Arrays.toString(arr));
    }
    public static void bubbleSort(int[] arr,Comparator c) {
        for(int i = 0;i<arr.length-1;i++){
            for(int j = 0;j<arr.length-1-i;j++){
                if(c.compare(arr[j],arr[j+1])>0){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
