package main.leetcode.editor.cn;//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
//
// 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。 
//
// 
//
// 示例 1: 
//
// 
//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]] 
//
// 示例 2: 
//
// 
//输入: strs = [""]
//输出: [[""]]
// 
//
// 示例 3: 
//
// 
//输入: strs = ["a"]
//输出: [["a"]] 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 10⁴ 
// 0 <= strs[i].length <= 100 
// strs[i] 仅包含小写字母 
// 
//
// Related Topics 数组 哈希表 字符串 排序 👍 2139 👎 0


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ansList = new ArrayList<>();
        HashMap<Long, ArrayList<String>> map = new HashMap<>();
        for (String str : strs) {
            long l = valueOf(str);
            if (!map.containsKey(l)) {
                map.put(l, new ArrayList<>());
            }
            map.get(l).add(str);
        }
        for (ArrayList<String> strings : map.values()) {
            ansList.add(strings);
        }
        return ansList;
    }

    private long valueOf(String s) {
        int[] cache = new int[26];
        long answer = 0;
        for (char c : s.toCharArray()) {
            cache[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            answer *= 26;
            answer += cache[i];
        }
        return answer;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

// 	执行耗时:5 ms,击败了99.81% 的Java用户
//	内存消耗:47.2 MB,击败了15.93% 的Java用户

