package Array;
//力扣238
public class TheProductOfArraysOtherThanItself {
    //空间复杂度为O(n)
    public int[] productExceptSelf1(int[] nums) {
        int n  = nums.length;
        if (n == 0) return nums;
        int[] light = new int[n];
        light[0] = 1;
        for(int i =1; i < n; i++){
            light[i] = nums[i-1] * light[i-1];
        }
        int[] right = new int[n];
        right[n-1] = 1;
        for(int i = n-2; i >= 0; i--){
            right[i] = nums[i+1] * right[i+1];
        }
        int[] ans = new int[n];
        for(int i = 0; i <n; i++){
            ans[i] =right[i]*light[i];
        }
        return ans;
    }

    //空间复杂度为O(1)
    public int[] productExceptSelf2(int[] nums) {
        int[] answer = new int[nums.length];
        int tmp = 1;
        for(int i = 0;i < nums.length;i++){
            answer[i] = tmp;
            tmp = tmp * nums[i];
        }
        tmp = 1;
        for(int i = nums.length - 1;i >= 0;i--){
            answer[i] = answer[i] * tmp;
            tmp = tmp * nums[i];
        }
        return answer;
    }
}
