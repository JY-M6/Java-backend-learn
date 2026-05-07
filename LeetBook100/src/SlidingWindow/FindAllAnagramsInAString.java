package SlidingWindow;

import java.util.ArrayList;
import java.util.List;

// 力扣438. 找到字符串中所有字母异位词
public class FindAllAnagramsInAString {
    /*public int[] cet = new int[256];


    public List<Integer> findAnagrams(String s, String p) {
        char[] chars = p.toCharArray();
        for (char aChar : chars) {
            cet[aChar]--;
        }

    }*/

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int sLen = s.length();
        int pLen = p.length();
        if (sLen < pLen) {
            return result;
        }

        int[] pCount = new int[26];
        int[] windowCount = new int[26];

        // 统计 p 中字符频率
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        // 初始化第一个窗口
        for (int i = 0; i < pLen; i++) {
            windowCount[s.charAt(i) - 'a']++;
        }

        // 检查第一个窗口
        if (matches(pCount, windowCount)) {
            result.add(0);
        }

        // 滑动窗口
        for (int i = pLen; i < sLen; i++) {
            // 移除左边界字符
            char leftChar = s.charAt(i - pLen);
            windowCount[leftChar - 'a']--;
            // 加入右边界字符
            char rightChar = s.charAt(i);
            windowCount[rightChar - 'a']++;
            // 检查当前窗口
            if (matches(pCount, windowCount)) {
                result.add(i - pLen + 1);
            }
        }

        return result;
    }

    // 辅助方法：比较两个频率数组是否相等
    private boolean matches(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
}
