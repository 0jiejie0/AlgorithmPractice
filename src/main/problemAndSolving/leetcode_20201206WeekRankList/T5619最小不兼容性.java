package main.problemAndSolving.leetcode_20201206WeekRankList;

public class T5619最小不兼容性 {
    public int minimumIncompatibility(int[] nums, int k) {
        int[] counts = new int[17];
        for (int n : nums) {
            counts[n]++;
            if (counts[n] > k) {
                return -1;
            }
        }
        int[][] groups = new int[k][nums.length / k];
        int res = 0, tempMax, tempMin;
        for (int[] group : groups) {
            for (int i = 0, j = 1; i < group.length && j < counts.length; j++) {
                if (counts[j] > 0) {
                    counts[j]--;
                    group[i++] = j;
                }
            }
            tempMin = tempMax = group[0];
            for (int i = 1; i < group.length; i++) {
                if (tempMin > group[i]) {
                    tempMin = group[i];
                } else if (tempMax < group[i]) {
                    tempMax = group[i];
                }
            }
            res += (tempMax - tempMin);
        }
        return res;
    }
}
