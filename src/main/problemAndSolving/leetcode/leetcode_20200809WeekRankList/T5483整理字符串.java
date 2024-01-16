package main.problemAndSolving.leetcode.leetcode_20200809WeekRankList;

//给你一个由大小写英文字母组成的字符串 s 。
//
//一个整理好的字符串中，两个相邻字符 s[i] 和 s[i + 1] 不会同时满足下述条件：
//
//0 <= i <= s.length - 2
//s[i] 是小写字符，但 s[i + 1] 是对应的大写字符；反之亦然 。
//请你将字符串整理好，每次你都可以从字符串中选出满足上述条件的 两个相邻 字符并删除，直到字符串整理好为止。
//
//请返回整理好的 字符串 。题目保证在给出的约束条件下，测试样例对应的答案是唯一的。
//
//注意：空字符串也属于整理好的字符串，尽管其中没有任何字符。
//
//
//
//示例 1：
//
//输入：s = "leEeetcode"
//输出："leetcode"
//解释：无论你第一次选的是 i = 1 还是 i = 2，都会使 "leEeetcode" 缩减为 "leetcode" 。
//示例 2：
//
//
//
//输入：s = "abBAcC"
//输出：""
//解释：存在多种不同情况，但所有的情况都会导致相同的结果。例如：
//"abBAcC" --> "aAcC" --> "cC" --> ""
//"abBAcC" --> "abBA" --> "aA" --> ""
//
//
//示例 3：
//
//输入：s = "s"
//输出："s"
//
//
//提示：
//
//1 <= s.length <= 100
//s 只包含小写和大写英文字母
public class T5483整理字符串 {
    public String makeGood(String s) {
        boolean tag = true;
        StringBuilder stringBuilder = new StringBuilder(s);
        char last;
        int diff = 'a' - 'A';
        int tempDiff;
        while (tag) {
            tag = false;
            if ((stringBuilder.length() >> 1) == 0) {
                return stringBuilder.toString();
            }
            last = stringBuilder.charAt(0);
            for (int i = 1; i < stringBuilder.length(); i++) {
                tempDiff = (last - stringBuilder.charAt(i));
                if (diff == (tempDiff < 0 ? -tempDiff : tempDiff)) {
                    stringBuilder.delete(i - 1, i + 1);
                    i -= 2;
                    tag = true;
                    if (i < 0) {
                        i = 0;
                    }
                }
                if (stringBuilder.length() != 0)
                    last = stringBuilder.charAt(i);
            }
        }
        return stringBuilder.toString();
    }
}
