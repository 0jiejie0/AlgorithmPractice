package main.problemAndSolving.leetcode_20240428WeekRankList;

import java.util.*;

//给你两个整数数组 nums1 和 nums2。
//
//从 nums1 中移除两个元素，并且所有其他元素都与变量 x 所表示的整数相加。如果 x 为负数，则表现为元素值的减少。
//
//执行上述操作后，nums1 和 nums2 相等 。当两个数组中包含相同的整数，并且这些整数出现的频次相同时，两个数组 相等 。
//
//返回能够实现数组相等的 最小 整数 x 。
//
//
//
//示例 1:
//
//输入：nums1 = [4,20,16,12,8], nums2 = [14,18,10]
//
//输出：-2
//
//解释：
//
//移除 nums1 中下标为 [0,4] 的两个元素，并且每个元素与 -2 相加后，nums1 变为 [18,14,10] ，与 nums2 相等。
//
//示例 2:
//
//输入：nums1 = [3,5,5,3], nums2 = [7,7]
//
//输出：2
//
//解释：
//
//移除 nums1 中下标为 [0,3] 的两个元素，并且每个元素与 2 相加后，nums1 变为 [7,7] ，与 nums2 相等。
//
//
//
//提示：
//
//3 <= nums1.length <= 200
//nums2.length == nums1.length - 2
//0 <= nums1[i], nums2[i] <= 1000
//测试用例以这样的方式生成：存在一个整数 x，nums1 中的每个元素都与 x 相加后，再移除两个元素，nums1 可以与 nums2 相等。
public class T100287找出与数组相加的整数II {
    public int minimumAddedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            for (int j = i; j < i + nums2.length; j++) {
                if (!map.containsKey(nums2[j - i] - nums1[j])) {
                    map.put(nums2[j - i] - nums1[j], 1);
                } else {
                    map.put(nums2[j - i] - nums1[j], map.get(nums2[j - i] - nums1[j]) + 1);
                }
            }
        }
        map.forEach((integer, integer2) -> {
            for (int i = 0, j = 0; i < nums2.length && j < nums1.length; j++, i++) {
                while (j < nums1.length && (integer != nums2[i] - nums1[j])) {
                    j++;
                }
                if (j > i + 2) break;
                if (i == nums2.length - 1) list.add(integer);
            }
        });
        list.sort(Comparator.comparingInt(a -> a));
        return list.get(0);
    }
}
