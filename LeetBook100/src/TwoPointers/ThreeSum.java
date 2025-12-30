package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//力扣15
public class ThreeSum {
    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        // 如果数组长度小于3，直接返回空列表
        if (n < 3) {
            return result;
        }

        // 先对数组排序
        Arrays.sort(nums);

        // 遍历数组，固定第一个元素
        for (int i = 0; i < n - 2; i++) {
            // 如果当前元素大于0，后面的元素都大于0，不可能有三数之和为0
            if (nums[i] > 0) {
                break;
            }

            // 跳过重复的第一个元素，避免重复的三元组
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 使用双指针查找后两个元素
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    // 找到符合条件的三元组
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // 跳过重复的left元素
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    // 跳过重复的right元素
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    // 移动指针继续寻找
                    left++;
                    right--;
                } else if (sum < 0) {
                    // 和太小，移动left指针
                    left++;
                } else {
                    // 和太大，移动right指针
                    right--;
                }
            }
        }

        return result;
    }
}
