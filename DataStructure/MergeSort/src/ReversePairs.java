public class ReversePairs {
    static int[] help;

    public static void main(String[] args) {
        int arr[] = {3, 4, 2, 6, 5};
        System.out.println(sort(arr, 0, arr.length - 1));
    }

    public static int sort(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int m = (l + r) / 2;
        return sort(arr, l, m) + sort(arr, m + 1, r) + merge(arr, l, m, r);
    }

    public static int merge(int[] arr, int l, int m, int r) {
        int ans = 0;
        for (int i = l, j = m + 1; i <= m; i++) {
            while (j <= r && (long) arr[i] > (long) arr[j] * 2) {
                j++;
            }
            ans += j - m - 1;
        }
        int i = l;
        int a = l;
        int b = m + 1;
        help = new int[arr.length];
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
