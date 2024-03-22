package main.leetcode.editor.cn;//给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
//如果 needle 不是 haystack 的一部分，则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：haystack = "sadbutsad", needle = "sad"
//输出：0
//解释："sad" 在下标 0 和 6 处匹配。
//第一个匹配项的下标是 0 ，所以返回 0 。
// 
//
// 示例 2： 
//
// 
//输入：haystack = "leetcode", needle = "leeto"
//输出：-1
//解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= haystack.length, needle.length <= 10⁴ 
// haystack 和 needle 仅由小写英文字符组成 
// 
//
// Related Topics 双指针 字符串 字符串匹配 👍 2177 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack.length() <= needle.length()) {
            return haystack.equals(needle) ? 0 : -1;
        }
        // 太久不练差点没想起来，只记得个滑动窗口
        // 这个地方确实应该用滑动窗口，突然想起来可以通过哈希来比对
        int l = 0, r = needle.length();
        int hashStack = 0, hashNeed = 0;
        char[] needleCharArray = needle.toCharArray();
        char[] haystackCharArray = haystack.toCharArray();
        int p = 1;
        for (int i = 0; i < r; i++) { // 翻阅了一下String的hashcode算法
            hashStack = 31 * hashStack + haystackCharArray[i];
            hashNeed = 31 * hashNeed + needleCharArray[i];
            if (i > 0) p *= 31;
        }
        if (hashStack == hashNeed) return 0;
        while (r < haystack.length()) {
            hashStack -= (p * haystackCharArray[l++]);
            hashStack = 31 * hashStack + haystackCharArray[r++];
            if (hashStack == hashNeed) {
                return l;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
// 	执行耗时:0 ms,击败了100.00% 的Java用户
//	内存消耗:40.4 MB,击败了61.98% 的Java用户