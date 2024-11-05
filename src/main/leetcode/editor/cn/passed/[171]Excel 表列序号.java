package main.leetcode.editor.cn;//给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回 该列名称对应的列序号 。
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
// 示例 1: 
//
// 
//输入: columnTitle = "A"
//输出: 1
// 
//
// 示例 2: 
//
// 
//输入: columnTitle = "AB"
//输出: 28
// 
//
// 示例 3: 
//
// 
//输入: columnTitle = "ZY"
//输出: 701 
//
// 
//
// 提示： 
//
// 
// 1 <= columnTitle.length <= 7 
// columnTitle 仅由大写英文组成 
// columnTitle 在范围 ["A", "FXSHRXW"] 内 
// 
//
// Related Topics 数学 字符串 👍 415 👎 0


import main.customUtil.AssertExample;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //    @AssertExample(params = "A", expectResult = "1")
    public int titleToNumber(String columnTitle) {
        int ans = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            ans *= 26;
            ans += (columnTitle.charAt(i) - 'A' + 1);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
// 	执行耗时:0 ms,击败了100.00% 的Java用户
//	内存消耗:41.2 MB,击败了75.80% 的Java用户

// 代码不够熟练，脑子里想得挺好，代码写出来就调错了东西，还是很低级的错误，眼睛不够锐利