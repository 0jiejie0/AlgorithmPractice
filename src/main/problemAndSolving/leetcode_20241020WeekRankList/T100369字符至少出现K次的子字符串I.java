package main.problemAndSolving.leetcode_20241020WeekRankList;

import main.customUtil.AssertExample;

import java.util.HashMap;

// 给你一个字符串 s 和一个整数 k，在 s 的所有子字符串中，请你统计并返回 至少有一个 字符 至少出现 k 次的子字符串总数。
//
//子字符串 是字符串中的一个连续、 非空 的字符序列。
//
//
//
//示例 1：
//
//输入： s = "abacb", k = 2
//
//输出： 4
//
//解释：
//
//符合条件的子字符串如下：
//
//"aba"（字符 'a' 出现 2 次）。
//"abac"（字符 'a' 出现 2 次）。
//"abacb"（字符 'a' 出现 2 次）。
//"bacb"（字符 'b' 出现 2 次）。
//示例 2：
//
//输入： s = "abcde", k = 1
//
//输出： 15
//
//解释：
//
//所有子字符串都有效，因为每个字符至少出现一次。
//
//
//
//提示：
//
//1 <= s.length <= 3000
//1 <= k <= s.length
//s 仅由小写英文字母组成。
public class T100369字符至少出现K次的子字符串I {
    //    @AssertExample(params = {"hxccgfp", "1"}, expectResult = "28")
//    @AssertExample(params = {"shlvvvx", "2"}, expectResult = "14")
    public int numberOfSubstrings(String s, int k) {
        int ans = 0;
        char[] charArray = s.toCharArray();
        int l = 0, r = 0, i = 0, max = 0;
        char mc = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (r < charArray.length) {
            char c = charArray[r++];
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
            if (map.get(c) > max) {
                max = map.get(c);
                if (max == k) {
                    mc = c;
                    break;
                }
            }
        }
        if (mc == 0) {
            return 0;
        }
        while (charArray[l] != mc) {
            map.put(charArray[l], map.get(charArray[l]) - 1);
            l++;
        }
        for (; r < charArray.length; r++) {
            ans += (l + 1);
            char c = charArray[r];
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
            if (map.get(c) >= k) {
                mc = c;
                while (charArray[l] != mc || map.get(mc) > k) {
                    map.put(charArray[l], map.get(charArray[l]) - 1);
                    l++;
                }
            }
        }
        ans += (l + 1);
        return ans;
    }
}
