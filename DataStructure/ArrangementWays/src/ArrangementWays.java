import java.util.Scanner;
import java.util.Arrays;
public class ArrangementWays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr =RandonNum(n,m);
        int[] arr1 = Selection(arr);
        int[] arr2 = Insertion(arr);
        int[] arr3 = Selection(arr);
        if(Check(arr1,arr2,arr3)){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }

    public static int[] change(int[] nums, int i, int j) {
        int temp =nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return nums;
    }

    public static int[] Selection(int[] arr) {
        try {
            for (int i = 0; i < arr.length; i++) {
                int min = i;
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[min] > arr[j]) {
                        change(arr, min, j);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("选择排序排列如下；");
        System.out.println(Arrays.toString(arr));
        return arr;
    }

    public static int[] Bubble(int[] arr) {
        try {
            for(int i = arr.length - 1; i > 0; i--) {
                for(int j = 0; j < i; j++) {
                    if(arr[j]>arr[j+1]) {
                        change(arr,j,j+1);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("冒泡排序排列如下；");
        System.out.println(Arrays.toString(arr));
             return arr;
    }

    public static int[] Insertion(int[] arr) {
        try {
            for(int i = 1; i < arr.length; i++) {
                for (int j = i; j > 0; j--) {
                    if(arr[j]<arr[j-1]) {
                        change(arr,j,j-1);
                    }
                    else{
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("插入排序排列如下；");
        System.out.println(Arrays.toString(arr));
        return arr;
    }

    public static int[] RandonNum(int n, int m) {
        int [] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int)(Math.random()*m+1);
        }
        return arr;
    }

    public static boolean Check(int[] arr1, int[] arr2, int[] arr3) {
        String str1 = Arrays.toString(arr1);
        String str2 = Arrays.toString(arr2);
        String str3 = Arrays.toString(arr3);
        return str1.equals(str2) && str2.equals(str3);
    }
}