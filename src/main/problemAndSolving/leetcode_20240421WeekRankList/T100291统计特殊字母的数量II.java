package main.problemAndSolving.leetcode_20240421WeekRankList;

import java.util.HashMap;

// 给你一个字符串 word。如果 word 中同时出现某个字母 c 的小写形式和大写形式，并且 每个 小写形式的 c 都出现在第一个大写形式的 c 之前，则称字母 c 是一个 特殊字母 。
//
//返回 word 中 特殊字母 的数量。
//
//
//
//示例 1:
//
//输入：word = "aaAbcBC"
//
//输出：3
//
//解释：
//
//特殊字母是 'a'、'b' 和 'c'。
//
//示例 2:
//
//输入：word = "abc"
//
//输出：0
//
//解释：
//
//word 中不存在特殊字母。
//
//示例 3:
//
//输入：word = "AbBCab"
//
//输出：0
//
//解释：
//
//word 中不存在特殊字母。
//提示：
//
//1 <= word.length <= 2 * 105
//word 仅由小写和大写英文字母组成。
public class T100291统计特殊字母的数量II {
    public int numberOfSpecialChars(String word) {
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : word.toCharArray()) {
            if (map.containsKey(c)) {
                if (map.get(c) == 0) {
                    ans++;
                }
                if (map.get(c) >= 0) {
                    map.put(c, map.get(c) + 1);
                }
            } else {
                if (map.containsKey((char) (c ^ 32))) {
                    if (map.get((char) (c ^ 32)) > 0) {
                        if (ans == 0) ans = 0;
                        else ans--;
                        map.put((char) (c ^ 32), -1);
                    }
                } else if (c >= 'a' && c <= 'z') {
                    map.put((char) (c ^ 32), 0);
                } else {
                    map.put(c, -1);
                }
            }
        }
        return ans;
    }
}
