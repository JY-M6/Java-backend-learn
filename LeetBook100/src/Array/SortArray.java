package Array;
//912.排序数组
public class SortArray {
    static int[] arr = new int[10];
    static int first = 0;
    static int last = 0;

    //基础版
    public static void quickSort1(int l, int r) {
        if(l >= r) return;
        int x = arr[ l +(int)(Math.random() * (r-l +1))];
        int mid = partition1(l , r, x);
        quickSort1(l, mid-1);
        quickSort1(mid+1, r);
    }

    public static int partition1(int l, int r, int x) {
        int a = l;
        int xi = 0;
        for(int i = l; i <= r; i++) {
            if(arr[i] <= x) {
                swap(a,i);
                if(arr[a] == x) xi = a;
                a++;
            }
        }
        swap(xi,a-1);
        return a-1;
    }

    //进阶版
    public static void quickSort2(int l, int r) {
        if(l >= r) return;
        int x = arr[ l +(int)(Math.random() * (r-l +1))];
        partition2(l , r, x);
        int left =first;
        int right = last;
        quickSort2(l, left-1);
        quickSort2(right+1, r);
    }

    public static void partition2(int l, int r, int x) {
        first = l;
        last = r;
        int i = l;
        while(i <= last) {
            if(arr[i] == x) {
                i++;
            } else if (arr[i] < x) {
                swap(first++,i++);
            }else{
                swap(i,last--);
            }
        }
    }

    public static void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
