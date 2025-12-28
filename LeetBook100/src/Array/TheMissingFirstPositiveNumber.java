package Array;

import java.util.*;

//力扣41
public class TheMissingFirstPositiveNumber {
    //暴力直接求解
    public int firstMissingPositive1(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        int[] sortedNums = Arrays.stream(nums)
                .sorted() // 中间操作：升序排序
                .toArray();
        for (int i = 0; i < n; i++) {
            set.add(sortedNums[i]);
        }
        for (int i = 0; i < n; i++) {
            if (!set.contains(i+1)) {
                return i+1;
            }
        }
        if(sortedNums[0]==0) return n;
        else return n+1;
    }

    //
    public int firstMissingPositive2(int[] nums) {
        //基本思路：如果所有正数都存在的话，会得到1-n的所有正数，
        //因此，将数组进行重排，得到最终结果缺失的第一个数的就是缺失的第一个正数。
        for(int i = 0;i < nums.length;i++) {
            while(nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                int tmp = nums[i];
                nums[i] = nums[tmp - 1];
                nums[tmp - 1] = tmp;
            }
        }

        for(int i = 0;i < nums.length;i++) {
            if(nums[i] != i + 1) return i + 1;
        }

        return nums.length + 1;
    }
}
