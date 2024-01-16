package main.problemAndSolving.leetcode.leetcode_20200712WeekRankList;

//5461. 仅含 1 的子串数 显示英文描述
//通过的用户数1176
//尝试过的用户数1621
//用户总通过次数1178
//用户总提交次数2612
//题目难度Medium
//给你一个二进制字符串 s（仅由 '0' 和 '1' 组成的字符串）。
//
//返回所有字符都为 1 的子字符串的数目。
//
//由于答案可能很大，请你将它对 10^9 + 7 取模后返回。
//
//
//
//示例 1：
//
//输入：s = "0110111"
//输出：9
//解释：共有 9 个子字符串仅由 '1' 组成
//"1" -> 5 次
//"11" -> 3 次
//"111" -> 1 次
//示例 2：
//
//输入：s = "101"
//输出：2
//解释：子字符串 "1" 在 s 中共出现 2 次
//示例 3：
//
//输入：s = "111111"
//输出：21
//解释：每个子字符串都仅由 '1' 组成
//示例 4：
//
//输入：s = "000"
//输出：0
//
//
//提示：
//
//s[i] == '0' 或 s[i] == '1'
//1 <= s.length <= 10^5
public class 仅含1的子串数 {
    public int numSub(String s) {
        //换用BigInteger提交错误，好像这个leetcode不支持还是这题目不让用BigInteger？
        int length = 0;
        int res = 0;
        int mod = 1000 * 1000 * 1000 + 7;
        for (int i = 0; i < s.length(); i++) {
            //好吧，是滑动窗口，是我愚钝了，只需要每次加一下长度就好
            //好像这里用乘法算起来更节约计算资源，乘法只需要每一段最后大量计算一次，而累加的形式需要频繁计算很多次（推测是这样）
            if ('1' == s.charAt(i)) {
//                res += ++length;//每块连续只含1串（长度n）的含1子串数=1+2+3+……+n
//                res %= mod;
                length++;
            } else if (length > 0) {
                res += (((long) length * (length + 1)) >> 1) % mod;
                res %= mod;
                length = 0;
            }
        }
        if (length != 0) {
            res += (((long) length * (length + 1)) >> 1) % mod;
            res %= mod;
        }
        return res;
    }
}
