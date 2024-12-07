package main.leetcode.editor.cn;//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的 字母异位词。
//
// 
//
// 示例 1: 
//
// 
//输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 
//输入: s = "rat", t = "car"
//输出: false 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, t.length <= 5 * 10⁴ 
// s 和 t 仅包含小写字母 
// 
//
// 
//
// 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
//
// Related Topics 哈希表 字符串 排序 👍 959 👎 0


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (!map.containsKey(c)) {
                return false;
            } else {
                if (map.get(c) == 0) {
                    return false;
                }
                map.put(c, map.get(c) - 1);
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

// 	执行耗时:18 ms,击败了9.75% 的Java用户
//	内存消耗:43.7 MB,击败了15.84% 的Java用户
// 效率怎么这么低？但是好像也没看见有什么更高效的解法啊？

