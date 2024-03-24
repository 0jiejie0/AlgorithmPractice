//给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。 
//
// 
//
// 示例 1： 
//
// 
//输入:a = "11", b = "1"
//输出："100" 
//
// 示例 2： 
//
// 
//输入：a = "1010", b = "1011"
//输出："10101" 
//
// 
//
// 提示： 
//
// 
// 1 <= a.length, b.length <= 10⁴ 
// a 和 b 仅由字符 '0' 或 '1' 组成 
// 字符串如果不是 "0" ，就不含前导零 
// 
//
// Related Topics 位运算 数学 字符串 模拟 👍 1179 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addBinary(String a, String b) {
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();
        StringBuilder ans = new StringBuilder();
        int remain = 0;
        for (int i = 0; i < (Math.max(a.length(), b.length())); i++) {
            if (i < a.length()) remain += a.charAt(i) - '0';
            if (i < b.length()) remain += b.charAt(i) - '0';
            ans.append(remain & 1);
            remain >>= 1;
        }
        if (remain > 0) ans.append(1);
        return ans.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
// 	执行耗时:1 ms,击败了99.55% 的Java用户
//	内存消耗:41.3 MB,击败了63.96% 的Java用户