package main.problemAndSolving.leetcode_20240714WeekRankList;

//给你一个仅由数字组成的字符串 s，在最多交换一次 相邻 且具有相同 奇偶性 的数字后，返回可以得到的字典序最小的字符串。
//
//如果两个数字都是奇数或都是偶数，则它们具有相同的奇偶性。例如，5 和 9、2 和 4 奇偶性相同，而 6 和 9 奇偶性不同。
//
//
//
//示例 1：
//
//输入： s = "45320"
//
//输出： "43520"
//
//解释：
//
//s[1] == '5' 和 s[2] == '3' 都具有相同的奇偶性，交换它们可以得到字典序最小的字符串。
//
//示例 2：
//
//输入： s = "001"
//
//输出： "001"
//
//解释：
//
//无需进行交换，因为 s 已经是字典序最小的。
//
//
//
//提示：
//
//2 <= s.length <= 100
//s 仅由数字组成。
public class T100352交换后字典序最小的字符串 {
    public String getSmallestString(String s) {
        char[] charArray = s.toCharArray();
        int last = charArray[0] - '0';
        for (int i = 1; i < charArray.length; i++) {
            int cur = charArray[i] - '0';
            if (last > cur) {
                if ((last & 1) == (cur & 1)) {
                    charArray[i - 1] = charArray[i];
                    charArray[i] = (char) (last + '0');
                    break;
                }
            }
            last = cur;
        }
        return new String(charArray);
    }
}
