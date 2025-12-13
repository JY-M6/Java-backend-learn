//给定一个未排序的整数数组 nums ，
// 找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
//
//请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
//
//
//
//示例 1：
//
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
//示例 2：
//
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
//示例 3：
//
//输入：nums = [1,0,1,2]
//输出：3
package HashMap;

import java.util.*;

public class TheLongestContinuousSequence_128 {
    public static void main(String[] args) {
        Solution_128_1 s = new Solution_128_1();
        int[] nums = {-339,711,-497,-940,867,-703,654,-852,116,963,15,822,588,925,-501,-431,-412,191,77,-581,781,421,387,-458,-961,-886,915,-29,283,19,-967,-982,-270,-391,-923,-330,-95,803,-109,-905,839,978,916,428,903,-512,-930,-435,678,146,56,533,-359,-556,-925,-321,-443,-937,649,840,154,755,857,883,-636,933,-373,268,736,590,362,575,641,351,76,618,838,146,-817,517,-635,238,123,5,681,197,683,-688,259,406,-848,-513,234,-991,-630,597,-985,69,-62,823,-268,-626,471,-626,724,-379,991,636,839,-753,226,-796,557,-651,282,239,545,38,550,-123,-483,774,363,750,855,806,347,942,-52,-714,765,753,-341,309,-873,-544,929,-809,-908,768,-563,317,-954,993,665,400,305,283,-562,-72,-766,-45,-225,669,-295,-370,475,-874,-428,-503,-516,-590,-750,215,719,-551,670,721,-361,835,490,148,152,608,214,-109,8,-480,-753,445,520,-520,-527,-704,-850,178,-2,697,376,570,-733,859,979,-484,74,771,-36,-256,493,675,-421,-17,-177,804,-409,-962,-305,598,-370,-59,116,-777,494,589,-482,643,-160,589,413,-784,159,680,-925,211,-731,148,-17,233,964,-524};
        int sum = s.longestConsecutive(nums);
        System.out.println(sum);
    }
}
class Solution_128_1 {
    public int longestConsecutive(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);
        List<Integer> l = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            l.add(nums[i]);
        }
        for (int i = 1; i < l.size(); i++) {
            if (Objects.equals(l.get(i), l.get(i - 1))) {
                l.remove(i);
                i--;
            }
        }
        List list = new ArrayList();
        for (int i = 0; i < l.size(); i++) {
            if (i < l.size()-1 && l.get(i+1)- l.get(i) == 1 ) {
                sum++;
            } else if (i == l.size()-1) {
                sum++;
                list.add(sum);
            } else {
                sum++;
                list.add(sum);
                sum = 0;
            }
        }
        if (list.isEmpty()) {
            return 0 ;
        }
        // 核心代码：调用Collections.max()直接获取最大值
        Integer max = (Integer) Collections.max(list);
        return max;
    }
}
class Solution_128_2 {
//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/longest-consecutive-sequence/solutions/276931/zui-chang-lian-xu-xu-lie-by-leetcode-solution/

    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}
