package main.problemAndSolving.leetcode_20201025WeekRankList;

import java.util.LinkedList;
import java.util.List;

//你准备参加一场远足活动。给你一个二维 rows x columns 的地图 heights ，其中 heights[row][col] 表示格子 (row, col) 的高度。一开始你在最左上角的格子 (0, 0) ，且你希望去最右下角的格子 (rows-1, columns-1) （注意下标从 0 开始编号）。你每次可以往 上，下，左，右 四个方向之一移动，你想要找到耗费 体力 最小的一条路径。
//
//一条路径耗费的 体力值 是路径上相邻格子之间 高度差绝对值 的 最大值 决定的。
//
//请你返回从左上角走到右下角的最小 体力消耗值 。
//
//
//
//示例 1：
//
//
//
//输入：heights = [[1,2,2],[3,8,2],[5,3,5]]
//输出：2
//解释：路径 [1,3,5,3,5] 连续格子的差值绝对值最大为 2 。
//这条路径比路径 [1,2,2,2,5] 更优，因为另一条路劲差值最大值为 3 。
//示例 2：
//
//
//
//输入：heights = [[1,2,3],[3,8,4],[5,3,5]]
//输出：1
//解释：路径 [1,2,3,4,5] 的相邻格子差值绝对值最大为 1 ，比路径 [1,3,5,3,5] 更优。
//示例 3：
//
//
//输入：heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
//输出：0
//解释：上图所示路径不需要消耗任何体力。
//
//
//提示：
//
//rows == heights.length
//columns == heights[i].length
//1 <= rows, columns <= 100
//1 <= heights[i][j] <= 106

//未解决
public class T5548最小体力消耗路径 {
    int[][] hei;
    int lastMinDiff;

    public int minimumEffortPath(int[][] heights) {
        this.hei = heights;
        explore(0, 0);
        return lastMinDiff;
    }

    private int explore(int x, int y) {
        int[] steps = new int[4];//上右下左方向的高度差
        List<Integer> directs = new LinkedList<>();//要走的方向的顺序
        if (couldArriveTo(x - 1, y)) {
            //up
            steps[0] = Math.abs(hei[x - 1][y] - hei[x][y]);

        }
        return 0;
    }

    private boolean couldArriveTo(int x, int y) {
        if (x >= 0 && y >= 0 && x < hei[0].length && y < hei.length)
            return true;
        return false;
    }
}
