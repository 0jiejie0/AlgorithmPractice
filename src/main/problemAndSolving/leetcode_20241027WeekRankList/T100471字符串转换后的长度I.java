package main.problemAndSolving.leetcode_20241027WeekRankList;

import main.customUtil.AssertExample;

import java.util.HashMap;
import java.util.Map;

// 给你一个字符串 s 和一个整数 t，表示要执行的 转换 次数。每次 转换 需要根据以下规则替换字符串 s 中的每个字符：
//
//如果字符是 'z'，则将其替换为字符串 "ab"。
//否则，将其替换为字母表中的下一个字符。例如，'a' 替换为 'b'，'b' 替换为 'c'，依此类推。
//返回 恰好 执行 t 次转换后得到的字符串的 长度。
//
//由于答案可能非常大，返回其对 109 + 7 取余的结果。
//
//
//
//示例 1：
//
//输入： s = "abcyy", t = 2
//
//输出： 7
//
//解释：
//
//第一次转换 (t = 1)
//'a' 变为 'b'
//'b' 变为 'c'
//'c' 变为 'd'
//'y' 变为 'z'
//'y' 变为 'z'
//第一次转换后的字符串为："bcdzz"
//第二次转换 (t = 2)
//'b' 变为 'c'
//'c' 变为 'd'
//'d' 变为 'e'
//'z' 变为 "ab"
//'z' 变为 "ab"
//第二次转换后的字符串为："cdeabab"
//最终字符串长度：字符串为 "cdeabab"，长度为 7 个字符。
//示例 2：
//
//输入： s = "azbk", t = 1
//
//输出： 5
//
//解释：
//
//第一次转换 (t = 1)
//'a' 变为 'b'
//'z' 变为 "ab"
//'b' 变为 'c'
//'k' 变为 'l'
//第一次转换后的字符串为："babcl"
//最终字符串长度：字符串为 "babcl"，长度为 5 个字符。
//
//
//提示：
//
//1 <= s.length <= 105
//s 仅由小写英文字母组成。
//1 <= t <= 105
public class T100471字符串转换后的长度I {
//    @AssertExample(params = {"jqktcurgdvlibczdsvnsg", "7517"}, expectResult = "79033769")
    public int lengthAfterTransformations(String s, int t) {
        long ans = 0;
        for (char c : s.toCharArray()) {
            ans += calculate(c, t);
            ans %= 1000_000_007;
        }
        return (int) ans;
    }

    private Map<Character, Map<Integer, Integer>> m = new HashMap<>();

    private int calculate(char c, int t) {
        if (m.containsKey(c)) {
            Map<Integer, Integer> integerMap = m.get(c);
            if (integerMap.containsKey(t)) {
                return integerMap.get(t);
            }
        } else {
            m.put(c, new HashMap<>());
        }
        long ans = 0;
        int d = 'z' - c;
        if (t <= d) {
            ans = 1;
        } else {
            ans += calculate('a', t - d - 1);
            ans += calculate('b', t - d - 1); // 注意这里和a剩余步数相等，并无二致，不会因为这是b就少转换一次
            ans %= 1000_000_007;
        }
        m.get(c).put(t, (int) ans);
        return (int) ans;
    }
}
