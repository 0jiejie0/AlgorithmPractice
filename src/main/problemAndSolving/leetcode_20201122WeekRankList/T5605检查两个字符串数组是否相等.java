package main.problemAndSolving.leetcode_20201122WeekRankList;

//给你两个字符串数组 word1 和 word2 。如果两个数组表示的字符串相同，返回 true ；否则，返回 false 。
//
//数组表示的字符串 是由数组中的所有元素 按顺序 连接形成的字符串。
//
//
//
//示例 1：
//
//输入：word1 = ["ab", "c"], word2 = ["a", "bc"]
//输出：true
//解释：
//word1 表示的字符串为 "ab" + "c" -> "abc"
//word2 表示的字符串为 "a" + "bc" -> "abc"
//两个字符串相同，返回 true
//示例 2：
//
//输入：word1 = ["a", "cb"], word2 = ["ab", "c"]
//输出：false
//示例 3：
//
//输入：word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
//输出：true
//
//
//提示：
//
//1 <= word1.length, word2.length <= 103
//1 <= word1[i].length, word2[i].length <= 103
//1 <= sum(word1[i].length), sum(word2[i].length) <= 103
//word1[i] 和 word2[i] 由小写字母组成
public class T5605检查两个字符串数组是否相等 {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int tagA = 1, tagB = 1, pA = 0, pB = 0;//tag数组中的待转位置，p串中字符的位置
        char[] charsA = word1[0].toCharArray(), charsB = word2[0].toCharArray();
        while (true) {
            //判定是否刷新chars数组
            if (pA == charsA.length) {
                if (tagA == word1.length) {//第一个字符数组走完
                    if (tagB == word2.length) {
                        break;
                    } else {//第一个数组搜完，第二个有剩余，长度不一
                        return false;
                    }
                }
                pA = 0;
                charsA = word1[tagA++].toCharArray();
            }
            if (pB == charsB.length) {
                if (tagB == word2.length) {//此处1数组走完，2数组未走完，说明长度不一
                    return false;
                }
                pB = 0;
                charsB = word2[tagB++].toCharArray();
            }
            //chars数组依次扫描到任一数组结尾处停止
            while (pA < charsA.length && pB < charsB.length) {
                if (charsA[pA++] != charsB[pB++]) {
                    return false;
                }
            }
        }
        //检查两个数组的最后元素中字符是否搜完
        return pA == charsA.length && pB == charsB.length;
    }
}
