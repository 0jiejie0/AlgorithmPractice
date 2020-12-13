package main.problemAndSolving.leetcode_20201206WeekRankList;

import java.util.HashMap;
import java.util.Map;

public class T5618K和数对的最大数目 {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int n : nums) {
            if (map.containsKey(n) && map.get(n) > 0) {
                res++;
                map.put(n, map.get(n) - 1);
            } else {
                map.put(k - n, (map.get(k - n) == null ? 0 : map.get(k - n)) + 1);
            }
        }
        return res;
    }
}
