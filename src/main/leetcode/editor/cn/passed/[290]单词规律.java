package main.leetcode.editor.cn;//给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
//
// 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。 
//
// 
//
// 示例1: 
//
// 
//输入: pattern = "abba", s = "dog cat cat dog"
//输出: true 
//
// 示例 2: 
//
// 
//输入:pattern = "abba", s = "dog cat cat fish"
//输出: false 
//
// 示例 3: 
//
// 
//输入: pattern = "aaaa", s = "dog cat cat dog"
//输出: false 
//
// 
//
// 提示: 
//
// 
// 1 <= pattern.length <= 300 
// pattern 只包含小写英文字母 
// 1 <= s.length <= 3000 
// s 只包含小写英文字母和 ' ' 
// s 不包含 任何前导或尾随对空格 
// s 中每个单词都被 单个空格 分隔 
// 
//
// Related Topics 哈希表 字符串 👍 693 👎 0


import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean wordPattern(String pattern, String s) {
        char[] charArray = pattern.toCharArray();
        String[] strings = s.split(" ");
        if (charArray.length != strings.length) {
            return false;
        }
        HashMap<Character, String> map = new HashMap<>();
        for (int i = 0; i < charArray.length; i++) {
            if (map.containsKey(charArray[i])) {
                if (!map.get(charArray[i]).equals(strings[i])) {
                    return false;
                }
            } else {
                if (map.containsValue(strings[i])) {
                    return false;
                }
                map.put(charArray[i], strings[i]);
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

//  执行耗时:1 ms,击败了94.67% 的Java用户
//	内存消耗:40.6 MB,击败了68.73% 的Java用户
