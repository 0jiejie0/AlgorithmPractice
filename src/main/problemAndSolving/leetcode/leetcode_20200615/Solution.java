package main.problemAndSolving.leetcode.leetcode_20200615;
//罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
//
// 字符          数值
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000
//
// 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做 XXVII, 即为 XX + V + I
//I 。
//
// 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5
// 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
//
//
// I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
// X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
// C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
//
//
// 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
//
// 示例 1:
//
// 输入: "III"
//输出: 3
//
// 示例 2:
//
// 输入: "IV"
//输出: 4
//
// 示例 3:
//
// 输入: "IX"
//输出: 9
//
// 示例 4:
//
// 输入: "LVIII"
//输出: 58
//解释: L = 50, V= 5, III = 3.
//
//
// 示例 5:
//
// 输入: "MCMXCIV"
//输出: 1994
//解释: M = 1000, CM = 900, XC = 90, IV = 4.
// Related Topics 数学 字符串
//一遍过，测试时出现一条bug，用时85m

public class Solution {
    public int romanToInt(String s) {
        char last = 0;//存储上一个字符
        int res = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case 'M':
                    res += (last == 'C') ? -trans(last) : trans(last);//上一个字符为C时减掉对应数，否则加上上一字符对应数，清last
                    last = 0;
                    res += trans('M');
                    break;
                case 'D':
                    res += (last == 'C') ? -trans(last) : trans(last);
                    last = 0;
                    res += trans('D');
                    break;
                case 'C':
                    if (last == 'X') {//上一字符为X时，计算组合数，清last
                        res += trans('C') - trans(last);
                        last = 0;
                    } else {//上一字符不是X，计算last对应数，将C压入last
                        res += trans(last);
                        last = 'C';
                    }
                    break;
                case 'L':
                    res += (last == 'X') ? -trans(last) : trans(last);//上一个字符为X时减掉对应数，否则加上上一字符对应数，清last
                    last = 0;
                    res += trans('L');
                    break;
                case 'X':
                    if (last == 'I') {//上一字符为I时，计算组合数，清last
                        res += trans('X') - trans(last);
                        last = 0;
                    } else {//上一字符不是I，计算last对应数，将X压入last
                        res += trans(last);
                        last = 'X';
                    }
                    break;
                case 'V':
                    res += (last == 'I') ? -trans(last) : trans(last);//上一个字符为I时减掉对应数，否则加上上一字符对应数，清last
                    last = 0;
                    res += trans('V');
                    break;
                case 'I':
                    res += trans(last);
                    last = 'I';
                    break;
            }
        }
        res += trans(last);//last中可能残留字符，如I
        return res;
    }

    private int trans(char c) {
        switch (c) {
            case 'M':
                return 1000;
            case 'D':
                return 500;
            case 'C':
                return 100;
            case 'L':
                return 50;
            case 'X':
                return 10;
            case 'V':
                return 5;
            case 'I':
                return 1;
            case 0:
                return 0;
        }
        return 0;
    }
}
