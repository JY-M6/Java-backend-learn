package Array;

import java.util.ArrayList;
import java.util.List;

public class RotatingArray {
}

class Solution_189 {
    //暴力算法arraylist
    public void rotate1(int[] nums, int k) {
        List list = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }

        k = k % nums.length;
        for (int i = 0; i < k; i++) {
            list.add(0, list.get(list.size() - 1));
            list.remove(list.size() - 1);
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) list.get(i);
        }
    }

    //反转数组
    public void rotate2(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return;
        k = k % n;
        if (k == 0) return;

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}