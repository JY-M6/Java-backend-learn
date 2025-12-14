public class Main {
    public static void main(String[] args) {
        int[] arr = {9,6,7,5,6,3,8 };
        MergeSort mergeSort = new MergeSort(arr);
        mergeSort.mergeSort1(0, arr.length - 1);
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        mergeSort.mergeSort2();
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

class MergeSort {
    static int[] arr ;
    static int[] help;
    int n;

    public MergeSort(int[] arr) {
        MergeSort.arr = arr;
        MergeSort.help = new int[arr.length];
        n = arr.length;
    }

    //递归实现
    public void mergeSort1(int l, int r) {
        if (l == r) {
            return;
        }
        int mid = (l + r) / 2;
        mergeSort1(l, mid);
        mergeSort1(mid + 1, r);
        merge(l, mid, r);
    }

    //非递归实现
    public void mergeSort2() {
        for(int l,m,r,step =  1;step<n;step<<=1){
            l = 0;
            while(l < n){
                m = l + step - 1;
                if(m + 1 >= n){
                    break;
                }
                r = Math.min(l + (step << 1) - 1, n - 1);
                merge(l, m, r);
                l = r + 1;
            }
        }
    }

    public void merge(int l, int m, int r){
        int i = l;
        int a = l;
        int b = m+1;
        while (a<=m && b<=r) {
            help[i++] = arr[a] <= arr[b] ? arr[a++] : arr[b++];
        }
        while(a<=m) {
            help[i++] = arr[a++];
        }
        while(b<=r) {
            help[i++] = arr[b++];
        }
        for(i=l; i<=r; i++){
                arr[i] = help[i];
            }
    }
}