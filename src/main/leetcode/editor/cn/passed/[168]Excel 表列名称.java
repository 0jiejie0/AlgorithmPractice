package main.leetcode.editor.cn;//给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。
//
// 例如： 
//
// 
//A -> 1
//B -> 2
//C -> 3
//...
//Z -> 26
//AA -> 27
//AB -> 28 
//...
// 
//
// 
//
// 示例 1： 
//
// 
//输入：columnNumber = 1
//输出："A"
// 
//
// 示例 2： 
//
// 
//输入：columnNumber = 28
//输出："AB"
// 
//
// 示例 3： 
//
// 
//输入：columnNumber = 701
//输出："ZY"
// 
//
// 示例 4： 
//
// 
//输入：columnNumber = 2147483647
//输出："FXSHRXW"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= columnNumber <= 2³¹ - 1 
// 
//
// Related Topics 数学 字符串 👍 700 👎 0


import main.customUtil.AssertExample;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //    @AssertExample(expectResult = "ZY", params = "701")
    public String convertToTitle(int columnNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        int div = 26;
        while (columnNumber > 0) {
            columnNumber -= 1;
            int i = columnNumber % div;
            columnNumber /= div;
            stringBuilder.append((char) ('A' + i));
        }
        return stringBuilder.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
// 	执行耗时:0 ms,击败了100.00% 的Java用户
//	内存消耗:39.7 MB,击败了74.34% 的Java用户
