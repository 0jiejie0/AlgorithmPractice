package main.problemAndSolving.leetcode_20240707WeekRankList;

import java.util.ArrayList;
import java.util.List;

//给你一个正整数 n。
//
//如果一个二进制字符串 x 的所有长度为 2 的子字符串中包含 至少 一个 "1"，则称 x 是一个 有效 字符串。
//
//返回所有长度为 n 的 有效 字符串，可以以任意顺序排列。
//
//
//
//示例 1：
//
//输入： n = 3
//
//输出： ["010","011","101","110","111"]
//
//解释：
//
//长度为 3 的有效字符串有："010"、"011"、"101"、"110" 和 "111"。
//
//示例 2：
//
//输入： n = 1
//
//输出： ["0","1"]
//
//解释：
//
//长度为 1 的有效字符串有："0" 和 "1"。
//
//
//
//提示：
//
//1 <= n <= 18
public class T100328生成不含相邻零的二进制字符串 {
    public List<String> validStrings(int n) {
        ArrayList<String> ans = new ArrayList<>();
        if (n == 1) {
            ans.add("0");
            ans.add("1");
            return ans;
        }
        List<String> list = validStrings(n - 1);
        for (String s : list) {
            ans.add("1" + s);
            if (s.charAt(0) == '1') ans.add("0" + s);
        }
        return ans;
    }
}
