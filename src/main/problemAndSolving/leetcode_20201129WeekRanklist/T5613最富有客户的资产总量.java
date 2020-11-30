package main.problemAndSolving.leetcode_20201129WeekRanklist;

public class T5613最富有客户的资产总量 {
    public int maximumWealth(int[][] accounts) {
        int res = 0;
        int tempSum;
        for (int[] count : accounts) {
            tempSum = 0;
            for (int asset : count) {
                tempSum += asset;
            }
            if (tempSum > res) {
                res = tempSum;
            }
        }
        return res;
    }
}
