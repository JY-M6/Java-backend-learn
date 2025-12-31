package TwoPointers;
//力扣283
public class MoveZeroes {
    public void moveZeroes1(int[] nums) {
        int n = nums.length;
        int zeroCount = 0; // 记录已经找到的零的数量

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            } else if (zeroCount > 0) {
                // 如果前面有零，就把当前非零元素向前移动
                nums[i - zeroCount] = nums[i];
                nums[i] = 0; // 当前位置设为0
            }
        }
    }

    //双指针法
    public void moveZeroes2(int[] nums) {
        int n = nums.length;
        int nonZeroIndex = 0; // 非零元素应该放置的位置

        // 将非零元素移动到数组前面
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                // 交换位置，把非零元素放到前面
                if (i != nonZeroIndex) {
                    int temp = nums[nonZeroIndex];
                    nums[nonZeroIndex] = nums[i];
                    nums[i] = temp;
                }
                nonZeroIndex++;
            }
        }
    }

    //分两步的方法
    public void moveZeroes3(int[] nums) {
        int n = nums.length;
        int lastNonZeroIndex = 0;

        // 第一步：把所有非零元素移到前面
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[lastNonZeroIndex] = nums[i];
                lastNonZeroIndex++;
            }
        }

        // 第二步：剩余位置补零
        for (int i = lastNonZeroIndex; i < n; i++) {
            nums[i] = 0;
        }
    }
}
