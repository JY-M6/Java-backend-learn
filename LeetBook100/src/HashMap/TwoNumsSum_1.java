package HashMap;

import java.util.Scanner;

//1.两数之和
// 给定一个整数数组 nums 和一个整数目标值 target，
//请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
//你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
public class TwoNumsSum_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String stringnums = sc.nextLine();
        String[] numstr = stringnums.split(",");
        int[] nums = new int[numstr.length];
        for (int i = 0; i < numstr.length; i++) {
            nums[i] = Integer.parseInt(numstr[i]);
        }
        //获取整数数组
        int[] label = new int[nums.length];
        //标记是否用过的整数
        int target = sc.nextInt();
        //输入目标值
        StringBuffer ans = new StringBuffer();
        //存储条件整数下标
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(label[i] != 1&&label[j] != 1) {
                    if (nums[i] + nums[j] == target) {
                        ans.append("[").append(i).append(" ").append(j).append("]").append(";");
                        //存储条件整数下标
                        label[i] = 1;
                        label[j] = 1;
                        //标记已用过的整数
                        break;
                    }
                }
            }
        }
        System.out.println(ans);
//        String[] targetnumstr = ans.toString().split(" ");
//        int[] targetnums = new int[targetnumstr.length];
//        for (int i = 0; i < targetnums.length; i++) {
//            targetnums[i] = Integer.parseInt(targetnumstr[i]);
//        }
//        System.out.println(targetnums);
    }
}