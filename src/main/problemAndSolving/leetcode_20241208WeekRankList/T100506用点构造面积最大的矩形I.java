package main.problemAndSolving.leetcode_20241208WeekRankList;

import main.customUtil.AssertExample;

// 给你一个数组 points，其中 points[i] = [xi, yi] 表示无限平面上一点的坐标。
//
//你的任务是找出满足以下条件的矩形可能的 最大 面积：
//
//矩形的四个顶点必须是数组中的 四个 点。
//矩形的内部或边界上 不能 包含任何其他点。
//矩形的边与坐标轴 平行 。
//返回可以获得的 最大面积 ，如果无法形成这样的矩形，则返回 -1。
//
//
//
//示例 1：
//
//输入： points = [[1,1],[1,3],[3,1],[3,3]]
//
//输出：4
//
//解释：
//
//示例 1 图示
//
//我们可以用这 4 个点作为顶点构成一个矩形，并且矩形内部或边界上没有其他点。因此，最大面积为 4 。
//
//示例 2：
//
//输入： points = [[1,1],[1,3],[3,1],[3,3],[2,2]]
//
//输出：-1
//
//解释：
//
//示例 2 图示
//
//唯一一组可能构成矩形的点为 [1,1], [1,3], [3,1] 和 [3,3]，但点 [2,2] 总是位于矩形内部。因此，返回 -1 。
//
//示例 3：
//
//输入： points = [[1,1],[1,3],[3,1],[3,3],[1,2],[3,2]]
//
//输出：2
//
//解释：
//
//示例 3 图示
//
//点 [1,3], [1,2], [3,2], [3,3] 可以构成面积最大的矩形，面积为 2。此外，点 [1,1], [1,2], [3,1], [3,2] 也可以构成一个符合题目要求的矩形，面积相同。
//
//
//
//提示：
//
//1 <= points.length <= 10
//points[i].length == 2
//0 <= xi, yi <= 100
//给定的所有点都是 唯一 的。
public class T100506用点构造面积最大的矩形I {
    //    @AssertExample(params = "[[1,1],[1,3],[3,1],[3,3]]", expectResult = "4")
//    @AssertExample(params = "[[1,1],[1,3],[3,1],[3,3],[2,2]]", expectResult = "-1")
//    @AssertExample(params = "[[1,1],[1,3],[3,1],[3,3],[1,2],[3,2]]", expectResult = "2")
    public int maxRectangleArea(int[][] points) {
        int ans = 0;
        for (int i = 0; i < points.length; i++) {
            int[] pointA = points[i];
            for (int j = i + 1; j < points.length; j++) {
                int[] pointB = points[j];
                if (pointB[0] != pointA[0]) {
                    continue;
                }
                int b = Math.max(pointB[1], pointA[1]);
                int s = Math.min(pointB[1], pointA[1]);
                for (int k = i + 1; k < points.length; k++) {
                    if (k == j) {
                        continue;
                    }
                    int[] pointC = points[k];
                    if (pointC[1] != pointA[1]) {
                        continue;
                    }
                    int r = Math.max(pointC[0], pointA[0]);
                    int t = Math.min(pointC[0], pointA[0]);
                    for (int l = i + 1; l < points.length; l++) {
                        if (l == k || l == j) {
                            continue;
                        }
                        int[] pointD = points[l];
                        if (pointD[1] != pointB[1] || pointD[0] != pointC[0]) {
                            continue;
                        }
                        boolean pass = true;
                        for (int m = 0; m < points.length; m++) {
                            if (m == l || m == k || m == j || m == i) {
                                continue;
                            }
                            int[] e = points[m];
                            if ((e[0] >= t && r >= e[0]) && (e[1] >= s && e[1] <= b)) {
                                pass = false;
                            }
                        }
                        if (pass) {
                            int area = (b - s) * (r - t);
                            ans = ans > area ? ans : area;
                        }
                    }
                }
            }
        }
        return ans == 0 ? -1 : ans;
    }
}
