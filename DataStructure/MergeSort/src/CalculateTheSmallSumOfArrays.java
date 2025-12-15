public class CalculateTheSmallSumOfArrays {
    static int arr[] = {3, 4, 2, 6, 5};
    static int[] help = new int[arr.length];

    public static void main(String[] args) {
        System.out.println(smallSum(arr, 0, arr.length - 1));
    }

    public static long smallSum(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int m = (l + r) / 2;
        return smallSum(arr, l, m) + smallSum(arr, m + 1, r) + merge(l, m, r);
    }

    public static long merge(int l, int m, int r) {
        long ans = 0;
        for (int i = l, j = m + 1, sum = 0; j <= r; j++) {
            while (i <= m && arr[i] <= arr[j]) {
                sum += arr[i++];
            }
            ans += sum;
        }
        int i = l;
        int a = l;
        int b = m + 1;
        while (a <= m && b <= r) {
            help[i++] = arr[a] <= arr[b] ? arr[a++] : arr[b++];
        }
        while (a <= m) {
            help[i++] = arr[a++];
        }
        while (b <= r) {
            help[i++] = arr[b++];
        }
        for (i = l; i <= r; i++) {
            arr[i] = help[i];
        }
        return ans;
    }
}
