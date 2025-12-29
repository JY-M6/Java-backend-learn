package TwoPointers;

//力扣11
public class TheContainerThatCanHoldTheMostWater {
    //运行太慢
    public int maxArea1(int[] height) {
        int n = height.length;
        if (n == 0 ||n == 1) return 0;
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                maxArea = maxArea< ((j-i)* Math.min(height[i],height[j])) ?((j-i)* Math.min(height[i],height[j])): maxArea;
            }
        }
        return maxArea;
    }

    //双指针
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            // 计算当前容器的面积
            int width = right - left;
            int h = Math.min(height[left], height[right]);
            int area = width * h;
            maxArea = Math.max(maxArea, area);

            // 移动较短的指针
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    //双指针简洁版1
    public int maxArea3(int[] height) {
        int n = height.length;
        int left = 0, right = n - 1;
        int ans = 0;
        while(left < right){
            int area = (right - left) * (height[left] > height[right] ? height[right--] : height[left++]);
            ans = Math.max(ans, area);
        }
        return ans;
    }
}
