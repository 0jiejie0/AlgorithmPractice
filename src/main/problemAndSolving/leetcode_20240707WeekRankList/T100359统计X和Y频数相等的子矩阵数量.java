package main.problemAndSolving.leetcode_20240707WeekRankList;

//给你一个二维字符矩阵 grid，其中 grid[i][j] 可能是 'X'、'Y' 或 '.'，返回满足以下条件的子矩阵数量：
//
//包含 grid[0][0]
//'X' 和 'Y' 的频数相等。
//至少包含一个 'X'。
//
//
//示例 1：
//
//输入： grid = [["X","Y","."],["Y",".","."]]
//
//输出： 3
//
//解释：
//
//
//
//示例 2：
//
//输入： grid = [["X","X"],["X","Y"]]
//
//输出： 0
//
//解释：
//
//不存在满足 'X' 和 'Y' 频数相等的子矩阵。
//
//示例 3：
//
//输入： grid = [[".","."],[".","."]]
//
//输出： 0
//
//解释：
//
//不存在满足至少包含一个 'X' 的子矩阵。
//
//
//
//提示：
//
//1 <= grid.length, grid[i].length <= 1000
//grid[i][j] 可能是 'X'、'Y' 或 '.'.
public class T100359统计X和Y频数相等的子矩阵数量 {
    public int numberOfSubmatrices(char[][] grid) {
        int[] add = new int[grid[0].length];
        int row = 0;
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < add.length; j++) {
                int temp = 'X' == grid[i][j] ? 2 : 'Y' == grid[i][j] ? -2 : 0;
                if (j == 0) {
                    row = temp;
                    add[j] += temp;
                } else {
                    row += temp;
                    add[j] += row - (1 & add[j] & row);
                }
                if (0 == (row & 1) && row != 0) row |= 1;
                if (0 == (add[j] & 1) && add[j] != 0) add[j] |= 1;
                if (1 == add[j]) ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new T100359统计X和Y频数相等的子矩阵数量().numberOfSubmatrices(new char[][]{{'.', 'X'}, {'.', 'Y'}}));
    }
}
