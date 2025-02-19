package main.leetcode.editor.cn;//丑数 就是只包含质因数 2、3 和 5 的 正 整数。
//
// 给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 6
//输出：true
//解释：6 = 2 × 3 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：true
//解释：1 没有质因数。 
//
// 示例 3： 
//
// 
//输入：n = 14
//输出：false
//解释：14 不是丑数，因为它包含了另外一个质因数 7 。
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= n <= 2³¹ - 1 
// 
//
// Related Topics 数学 👍 464 👎 0


import main.customUtil.AssertExample;

import java.util.ArrayList;
import java.util.Collections;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //    @AssertExample(params = "1", expectResult = "true")
//    @AssertExample(params = "6", expectResult = "true")
//    @AssertExample(params = "14", expectResult = "false")
    public boolean isUgly(int n) {
        // 质因公倍真是叫人恐惧，说实话，我不熟
        // 暴力除尽235，直到剩下不能被235整除的因数
        int temp = div(n);
        while (temp != n) {
            n = temp;
            temp = div(n);
        }
        // 剩余因数不为1，说明存在其他因数
        return n == 1;
    }

    // 整除2、3、5其一一次，否则返回原数
    private int div(int n) {
        if (0 == (n % 2)) {
            return n >> 1;
        } else if (0 == (n % 3)) {
            return n / 3;
        } else if (0 == (n % 5)) {
            return n / 5;
        }
        return n;
    }

    // 开方求整根，总算是凭印象推出来了
    private int sqrt(int n) {
        double ans = (n + 1) / 2.0;
        double tmp = (ans + (n / ans)) / 2.0;
        while (((int) ans) != ((int) tmp)) {
            ans = tmp;
            tmp = (ans + (n / ans)) / 2.0;
        }
        return (int) ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

// 想不到开根的方法费心费力写了半天，用别的办法给绕过去了，性能还不错
// 解答成功:
//	执行耗时:0 ms,击败了100.00% 的Java用户
//	内存消耗:39.9 MB,击败了71.75% 的Java用户
