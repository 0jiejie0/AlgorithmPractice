package main.leetcode.editor.cn;//如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
//
// 字母和数字都属于字母数字字符。 
//
// 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入: s = "A man, a plan, a canal: Panama"
//输出：true
//解释："amanaplanacanalpanama" 是回文串。
// 
//
// 示例 2： 
//
// 
//输入：s = "race a car"
//输出：false
//解释："raceacar" 不是回文串。
// 
//
// 示例 3： 
//
// 
//输入：s = " "
//输出：true
//解释：在移除非字母数字字符之后，s 是一个空字符串 "" 。
//由于空字符串正着反着读都一样，所以是回文串。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2 * 10⁵ 
// s 仅由可打印的 ASCII 字符组成 
// 
//
// Related Topics 双指针 字符串 👍 746 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() <= 1) {
            return true;
        }
        char[] chars = s.toLowerCase().toCharArray();
        int l = 0, h = 0;
        while (h < chars.length) {
            if (chars[h] >= 'a' && chars[h] <= 'z' || chars[h] >= '0' && chars[h] <= '9') {
                chars[l++] = chars[h++];
            } else {
                h++;
            }
        }
        h = 0;
        l--;
        while (h < l) {
            if (chars[h] != chars[l]) {
                return false;
            }
            h++;
            l--;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
//	解答成功:
//	执行耗时:2 ms,击败了96.89% 的Java用户
//	内存消耗:42.4 MB,击败了50.52% 的Java用户