package main.problemAndSolving.leetcode_20210110WeekRanklist;

import java.util.*;
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
        int[] fullIndex = new int[source.length];//下标全集
        //用下标全集扣除swap内出现的所有下标
        //利用并查集将出现的各对下标划分为若干分区
        for (int[] allowedSwap : allowedSwaps) {
            fullIndex[allowedSwap[0]]++;
            fullIndex[allowedSwap[1]]++;
            CheckSet.checkPointAndMergeSet(allowedSwap[0], allowedSwap[1]);//合并两点或两个分区
        }
        Map<Integer, Set<Integer>> partitions = new HashMap<>();//<分区根节点，此分区内所有节点（下标）>
        for (int k : CheckSet.getMap().keySet()) {
            CheckSet set = CheckSet.getPoint(k);
            if (!partitions.containsKey(set.getPri().getValue())) {//新根，添加
                partitions.put(set.getPri().getValue(), new HashSet<>());
            }
            partitions.get(set.getPri().getValue()).add(set.getValue());
        }
        CheckSet.getMap().clear();//map完成使命，由于此是静态属性所以需要清除其内容
        //在各个分区内对各个下标位置出现的数字计数，累积不同元素个数/2
        int[] temp = new int[100001];
        int max = 0;//记录最大值，用以缩减计数区间的搜索长度
        Set<Integer> set;
        for (int k : partitions.keySet()) {
            set = partitions.get(k);
            //计数
            for (int i : set) {
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
        res >>= 1;//不同元素数量/2
        //全集内比较未出现的各个下标对应的两个元素（两个数组各一个），不同则计1
        for (int i = 0; i < fullIndex.length; i++) {
            if (fullIndex[i] == 0 && source[i] != target[i]) {
                res++;
            }
        }
        return res;
    }

    private static class CheckSet {
        private CheckSet pri;
        private Integer value;
        private static Map<Integer, CheckSet> map = new HashMap<>();

        private CheckSet(int value) {
            this(null, value);
        }

        private CheckSet(CheckSet pri, int value) {
            if (getPoint(value) != null) {//checkSet用来存放下标，下标唯一
                return;
            }
            this.pri = pri;
            this.value = value;
            map.put(value, this);
        }

        private CheckSet getPri() {
            return pri == null ? this : (pri = pri.getPri());//将每次查询点的pri 指向根节点（切忌把根节点指向自身），查询时执行移动缩小计算量
        }

        private void setPri(CheckSet pri) {
            this.pri = pri;
        }

        private int getValue() {
            return value;
        }

        private static CheckSet getPoint(int value) {
            return map.get(value);
        }

        /**
         * @param valueA
         * @param valueB
         * @return 合并后集合的根节点
         */
        private static CheckSet checkPointAndMergeSet(int valueA, int valueB) {
            //查找AB两点
            CheckSet pA = getPoint(valueA);
            if (pA == null) {
                pA = new CheckSet(valueA);
            }
            CheckSet pB = getPoint(valueB);
            if (pB == null) {
                pB = new CheckSet(valueB);
            }
            //检查是否同集合，并合并
            if (pA.getPri() != pB.getPri()) {
                //两点不在同一集合中，则合并
                if (pA.getPri() == pA) {//A为根点或游离点，将其挪动到B集合的根下
                    pA.setPri(pB.getPri());
                } else {//A为集合的非根点，将B集合挪动到A集合根下
                    pB.getPri().setPri(pA.getPri());//注意:挪动B集合的根
                }
            }
            return pA.getPri();
        }

        public static Map<Integer, CheckSet> getMap() {
            return map;
        }
    }
}