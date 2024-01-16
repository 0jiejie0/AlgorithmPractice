package main.problemAndSolving.leetcode.leetcode_20210110WeekRanklist;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//给你两个整数数组 source 和 target ，长度都是 n 。还有一个数组 allowedSwaps ，其中每个 allowedSwaps[i] = [ai, bi] 表示你可以交换数组 source 中下标为 ai 和 bi（下标从 0 开始）的两个元素。注意，你可以按 任意 顺序 多次 交换一对特定下标指向的元素。
//
//相同长度的两个数组 source 和 target 间的 汉明距离 是元素不同的下标数量。形式上，其值等于满足 source[i] != target[i] （下标从 0 开始）的下标 i（0 <= i <= n-1）的数量。
//
//在对数组 source 执行 任意 数量的交换操作后，返回 source 和 target 间的 最小汉明距离 。
//
// 
//
//示例 1：
//
//输入：source = [1,2,3,4], target = [2,1,4,5], allowedSwaps = [[0,1],[2,3]]
//输出：1
//解释：source 可以按下述方式转换：
//- 交换下标 0 和 1 指向的元素：source = [2,1,3,4]
//- 交换下标 2 和 3 指向的元素：source = [2,1,4,3]
//source 和 target 间的汉明距离是 1 ，二者有 1 处元素不同，在下标 3 。
//示例 2：
//
//输入：source = [1,2,3,4], target = [1,3,2,4], allowedSwaps = []
//输出：2
//解释：不能对 source 执行交换操作。
//source 和 target 间的汉明距离是 2 ，二者有 2 处元素不同，在下标 1 和下标 2 。
//示例 3：
//
//输入：source = [5,1,2,4,3], target = [1,5,4,2,3], allowedSwaps = [[0,4],[4,2],[1,3],[1,4]]
//输出：0
// 
//
//提示：
//
//n == source.length == target.length
//1 <= n <= 105
//1 <= source[i], target[i] <= 105
//0 <= allowedSwaps.length <= 105
//allowedSwaps[i].length == 2
//0 <= ai, bi <= n - 1
//ai != bi
public class T5650执行交换操作后的最小汉明距离 {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int res = 0;
        CheckSet checkSet = new CheckSet(source.length, allowedSwaps);
        //利用并查集将出现的各对下标划分为若干分区
        for (int[] allowedSwap : allowedSwaps) {
            checkSet.checkPointAndMergeSet(allowedSwap[0], allowedSwap[1]);//合并两点或两个分区
        }
        Map<Integer, Set<Integer>> partitions = new HashMap<>();//<分区根节点，此分区内所有节点（下标）>
        for (int k = 1; k <= source.length; k++) {
            if (!partitions.containsKey(checkSet.getPri(k))) {//新根，添加
                Set<Integer> set = new HashSet<>();
                set.add(k);
                partitions.put(checkSet.getPri(k), set);
            } else {
                partitions.get(checkSet.getPri(k)).add(k);
            }
        }
        //在各个分区内对各个下标位置出现的数字计数，累积不同元素个数/2
        int[] temp = new int[100001];
        int max;//记录最大值，用以缩减计数区间的搜索长度
        for (Map.Entry<Integer,Set<Integer>> entry: partitions.entrySet()) {
            max = 0;
            //计数
            for (int i : entry.getValue()) {
                if (source.length == i) {
                    i = 0;
                }
                temp[source[i]]++;
                temp[target[i]]--;
                if (max < source[i]) {
                    max = source[i];
                }
                if (max < target[i]) {
                    max = target[i];
                }
            }
            //记录不同元素个数
            for (int i = 1; i <= max; i++) {
                if (temp[i] != 0) {
                    res += Math.abs(temp[i]);
                    temp[i] = 0;
                }
            }
        }
        return res >> 1;//不同元素数量/2
    }

    private class CheckSet {
        private int[] map;//int数组即可满足本题目

        private CheckSet(int n, int[][] swaps) {
            map = new int[n + 1];
            for (int[] swap : swaps) {
                if (0 == swap[0]) {//屏蔽第0个元素，默认值0代表该点为根
                    swap[0] = n;
                }
                if (0 == swap[1]) {
                    swap[1] = n;
                }
            }
        }

        private int getPri(int index) {
            //将每次查询点的pri 指向根节点（切忌把根节点指向自身），查询时执行移动缩小计算量
            return isRoot(index) ? index : (getMap()[index] = getPri(getMap()[index]));
        }

        private void setPri(int index, int pri) {
            getMap()[index] = pri;
        }

        private boolean isRoot(int index) {
            return 0 == getMap()[index];
        }

        private void checkPointAndMergeSet(int indexA, int indexB) {
            if (getPri(indexA) != getPri(indexB)) {
                //两点不在同一集合中，则合并
                if (isRoot(indexA)) {//A为根点或游离点，将其挪动到B集合的根下
                    setPri(indexA, getPri(indexB));
                } else {//A为集合的非根点，将B集合挪动到A集合根下
                    setPri(getPri(indexB), getPri(indexA));//注意:挪动B集合的根
                }
            }
        }

        private int[] getMap() {
            return map;
        }
    }
}