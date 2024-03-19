package main.leetcode.editor.cn;//编写一个函数来查找字符串数组中的最长公共前缀。
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
//
// Related Topics 字典树 字符串 👍 3078 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length < 2) return strs.length == 1 ? strs[0] : "";
        String ans = strs[0];
        char[] ansCharArray = ans.toCharArray();
        int endIndex = ansCharArray.length;
        for (String str : strs) {
            if (str.length() < endIndex)
                endIndex = str.length();
            for (int i = 0; i < endIndex; i++) {
                if (str.charAt(i) != ansCharArray[i]) {
                    endIndex = i;
                    break;
                }
            }
        }
        return ans.substring(0, endIndex);
        //	执行耗时:1 ms,击败了70.34% 的Java用户
        //	内存消耗:40.4 MB,击败了68.18% 的Java用户
        // 使用字符数组+下标，降低substring调用次数，能提升一点效率
        //	执行耗时:0 ms,击败了100.00% 的Java用户
        //	内存消耗:40.3 MB,击败了80.61% 的Java用户
    }
}
//leetcode submit region end(Prohibit modification and deletion)
