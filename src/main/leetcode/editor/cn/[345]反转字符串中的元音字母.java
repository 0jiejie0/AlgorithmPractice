//给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。 
//
// 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现不止一次。 
//
// 
//
// 示例 1： 
//
// 
// 输入：s = "IceCreAm" 
// 
//
// 输出："AceCreIm" 
//
// 解释： 
//
// s 中的元音是 ['I', 'e', 'e', 'A']。反转这些元音，s 变为 "AceCreIm". 
//
// 示例 2： 
//
// 
// 输入：s = "leetcode" 
// 
//
// 输出："leotcede" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 10⁵ 
// s 由 可打印的 ASCII 字符组成 
// 
//
// Related Topics 双指针 字符串 👍 386 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int l = 0, r = chars.length - 1;
        while (l < r) {
            while (l < r && !needRvs(chars[l])) {
                l++;
            }
            while (l < r && !needRvs(chars[r])) {
                r--;
            }
            if (l < r) {
                chars[r] ^= chars[l];
                chars[l] ^= chars[r];
                chars[r--] ^= chars[l++];
            }
        }
        return new String(chars);
    }

    private static boolean needRvs(char c) {
        return c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' || c == 'I' ||
                c == 'o' || c == 'O' || c == 'u' || c == 'U';
    }
}
//leetcode submit region end(Prohibit modification and deletion)

// 	执行耗时:2 ms,击败了99.37% 的Java用户
//	内存消耗:45.6 MB,击败了51.22% 的Java用户
// 效率一般
