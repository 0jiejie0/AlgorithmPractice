package main.problemAndSolving.leetcode_20240728WeekRankList;

//给你两个 正整数 l 和 r。对于任何数字 x，x 的所有正因数（除了 x 本身）被称为 x 的 真因数。
//
//如果一个数字恰好仅有两个 真因数，则称该数字为 特殊数字。例如：
//
//数字 4 是 特殊数字，因为它的真因数为 1 和 2。
//数字 6 不是 特殊数字，因为它的真因数为 1、2 和 3。
//返回区间 [l, r] 内 不是 特殊数字 的数字数量。
//
//
//
//示例 1：
//
//输入： l = 5, r = 7
//
//输出： 3
//
//解释：
//
//区间 [5, 7] 内不存在特殊数字。
//
//示例 2：
//
//输入： l = 4, r = 16
//
//输出： 11
//
//解释：
//
//区间 [4, 16] 内的特殊数字为 4 和 9。
//
//
//
//提示：
//
//1 <= l <= r <= 109
public class TQ2统计不是特殊数字的数字数量 {
    public int nonSpecialCount(int l, int r) {
        int res = 0;
        return res;
    }

    private int sqrt(int y) {
        double d = 0.5;
        double res = 0.25;
        while (y - res * res > 1.0) {
            d /= 2.0;
            res += d * d;
        }
        return (int) Math.floor(res);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(new TQ2统计不是特殊数字的数字数量().sqrt(i) + "^2 = " + i);
        }
    }
}
