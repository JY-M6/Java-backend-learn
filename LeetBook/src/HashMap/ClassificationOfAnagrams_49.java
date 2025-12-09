package HashMap;

//49.字母异位词分组
//给你一个字符串数组，请你将 字母异位词 组合在一起。
//可以按任意顺序返回结果列表。
//示例 1:
//输入: strs =["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
//解释：
//在 strs 中没有字符串可以通过重新排列来形成 "bat"。
//字符串 "nat" 和 "tan" 是字母异位词，因为它们可以重新排列以形成彼此。
//字符串 "ate" ，"eat" 和 "tea" 是字母异位词，因为它们可以重新排列以形成彼此。

//示例 2:
//输入: strs = [""]
//输出: [[""]]

//示例 3:
//输入: strs = ["a"]
//输出: [["a"]]

import java.util.*;

public class ClassificationOfAnagrams_49 {
    public static void main(String[] arg){
        Solution_49 sol = new Solution_49();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        sol.groupAnagrams(strs);
        System.out.println(strs);
    }
}
class Solution_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String s:strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key =new String(chars);
            map.putIfAbsent(key,new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}