package main.problemAndSolving.leetcode.leetcode_20220619WeekRankList;

//给你一个由英文字母组成的字符串 s ，请你找出并返回 s 中的 最好 英文字母。返回的字母必须为大写形式。如果不存在满足条件的字母，则返回一个空字符串。
//
//最好 英文字母的大写和小写形式必须 都 在 s 中出现。
//
//英文字母 b 比另一个英文字母 a 更好 的前提是：英文字母表中，b 在 a 之 后 出现。
//
//
//
//示例 1：
//
//输入：s = "lEeTcOdE"
//输出："E"
//解释：
//字母 'E' 是唯一一个大写和小写形式都出现的字母。
//示例 2：
//
//输入：s = "arRAzFif"
//输出："R"
//解释：
//字母 'R' 是大写和小写形式都出现的最好英文字母。
//注意 'A' 和 'F' 的大写和小写形式也都出现了，但是 'R' 比 'F' 和 'A' 更好。
//示例 3：
//
//输入：s = "AbCdEfGhIjK"
//输出：""
//解释：
//不存在大写和小写形式都出现的字母。
//
//
//提示：
//
//1 <= s.length <= 1000
//s 由小写和大写英文字母组成
public class T5242兼具大小写的最好英文字母 {
    public String greatestLetter(String s) {
        int startS = 'a';
        int startL = 'A';
        char res = 0;
        int[] cache = new int[26];
        int temp = 0;
        for (char c : s.toCharArray()) {
            if (c < startS) {//大写字母
                temp = c - startL;
                if (cache[temp] != 1) {//没有出现小写字母
                    cache[temp] = 2;//标记大写
                } else {//已出现小写字母
                    if (temp + startL > res) {
                        res = (char) (temp + startL);
                    }
                }
            } else {//小写字母
                temp = c - startS;
                if (cache[temp] != 2) {//没有出现大写字母
                    cache[temp] = 1;//标记小写
                } else {//已出现大写字母，记录结果
                    if (temp + startL > res) {
                        res = (char) (temp + startL);
                    }
                }
            }
        }
        return res == 0 ? "" : "" + res;
    }
}
