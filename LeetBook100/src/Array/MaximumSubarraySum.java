package Array;
//53
public class MaximumSubarraySum {

    public int maxSubArrayBruteForceOptimized(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxSum = Integer.MIN_VALUE;

        // 遍历所有可能的起始位置
        for (int start = 0; start < nums.length; start++) {
            int currentSum = 0;
            // 遍历所有可能的结束位置，并累加计算
            for (int end = start; end < nums.length; end++) {
                currentSum += nums[end];  // 在上一轮的基础上累加
                maxSum = Math.max(maxSum, currentSum);
            }
        }

        return maxSum;
    }


        public int maxSubArray(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            int currentSum = nums[0];
            int maxSum = nums[0];

            for (int i = 1; i < nums.length; i++) {
                // 决定是延续之前的子数组，还是从当前元素重新开始
                currentSum = Math.max(nums[i], currentSum + nums[i]);
                // 更新全局最大值
                maxSum = Math.max(maxSum, currentSum);
            }

            return maxSum;
        }
}