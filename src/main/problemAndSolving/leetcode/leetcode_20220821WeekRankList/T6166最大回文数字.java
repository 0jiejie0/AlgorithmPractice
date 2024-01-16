package main.problemAndSolving.leetcode.leetcode_20220821WeekRankList;

//给你一个仅由数字（0 - 9）组成的字符串 num 。
//
//请你找出能够使用 num 中数字形成的 最大回文 整数，并以字符串形式返回。该整数不含 前导零 。
//
//注意：
//
//你 无需 使用 num 中的所有数字，但你必须使用 至少 一个数字。
//数字可以重新排序。
//
//
//示例 1：
//
//输入：num = "444947137"
//输出："7449447"
//解释：
//从 "444947137" 中选用数字 "4449477"，可以形成回文整数 "7449447" 。
//可以证明 "7449447" 是能够形成的最大回文整数。
//示例 2：
//
//输入：num = "00009"
//输出："9"
//解释：
//可以证明 "9" 能够形成的最大回文整数。
//注意返回的整数不应含前导零。
//
//
//提示：
//
//1 <= num.length <= 105
//num 由数字（0 - 9）组成
public class T6166最大回文数字 {
    public String largestPalindromic(String num) {
        StringBuilder res = new StringBuilder();
        StringBuilder rear = new StringBuilder();
//        String res = "";
//        String rear = "";
        int[] cache = new int[10];
//        boolean isOdd = false;
        for (char c : num.toCharArray()) {
            cache[c - '0']++;
        }
        for (int i = cache.length - 1; i >= 0; i--) {
            if ((cache[i] & 1) == 1 && res.length() == 0) {
                rear.append(i);
//                isOdd = true;
            }
            cache[i] >>= 1;
        }
        for (int i = cache.length - 1; i >= 0; i--) {
            int c = cache[i];
            while (c-- > 0) {
                res.append(i);
            }
        }
        res.append(rear.toString());
        for (int i = 0; i < cache.length; i++) {
            int c = cache[i];
            while (c-- > 0) {
                res.append(i);
//                rear.append(i);
            }
        }
        if ('0' == res.charAt(0)) {
            if (rear.length() > 0)
                return rear.charAt(0) + "";
            return res.charAt(0) + "";
        }
//        res.insert(0, rear.reverse());
//        if (isOdd) {
//            res.deleteCharAt(res.length() >> 1);
//        }
        return res.toString();
    }
}
