package main.problemAndSolving.leetcode_20201115WeekRankList;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//如果可以使用以下操作从一个字符串得到另一个字符串，则认为两个字符串 接近 ：
//
//操作 1：交换任意两个 现有 字符。
//例如，abcde -> aecdb
//操作 2：将一个 现有 字符的每次出现转换为另一个 现有 字符，并对另一个字符执行相同的操作。
//例如，aacabb -> bbcbaa（所有 a 转化为 b ，而所有的 b 转换为 a ）
//你可以根据需要对任意一个字符串多次使用这两种操作。
//
//给你两个字符串，word1 和 word2 。如果 word1 和 word2 接近 ，就返回 true ；否则，返回 false 。
//
//
//
//示例 1：
//
//输入：word1 = "abc", word2 = "bca"
//输出：true
//解释：2 次操作从 word1 获得 word2 。
//执行操作 1："abc" -> "acb"
//执行操作 1："acb" -> "bca"
//示例 2：
//
//输入：word1 = "a", word2 = "aa"
//输出：false
//解释：不管执行多少次操作，都无法从 word1 得到 word2 ，反之亦然。
//示例 3：
//
//输入：word1 = "cabbba", word2 = "abbccc"
//输出：true
//解释：3 次操作从 word1 获得 word2 。
//执行操作 1："cabbba" -> "caabbb"
//执行操作 2："caabbb" -> "baaccc"
//执行操作 2："baaccc" -> "abbccc"
public class T5603确定两个字符串是否接近 {
    public boolean closeStrings(String word1, String word2) {
        int[] sA = statAndAnalySort(word1);
        int[] sB = statAndAnalySort(word2);
        for (int i = 0; i < sA.length; i++) {
            if (sA[i] != sB[i]) {
                return false;
            }
        }
        return charContain(word1, word2) && charContain(word2, word1);
    }

    private boolean charContain(String sA, String sB) {//判断sA是否包含sB的全部字符，判断字符集条件
        Set<Character> set = new HashSet<>();
        for (char c : sA.toCharArray()) {
            set.add(c);
        }
        for (char c : sB.toCharArray()) {
            if (!set.contains(c)) {
                return false;
            }
        }
        return true;
    }

    private int[] statAndAnalySort(String s) {//统计字符数量并排序，用以判断字符数量条件
        char[] chars = s.toCharArray();
        int[] res = new int[26];
        for (char c : chars) {
            res[c - 'a']++;
        }
        Arrays.sort(res);
        return res;
    }
}
