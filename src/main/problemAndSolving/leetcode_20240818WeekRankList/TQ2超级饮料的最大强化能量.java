package main.problemAndSolving.leetcode_20240818WeekRankList;

// 来自未来的体育科学家给你两个整数数组 energyDrinkA 和 energyDrinkB，数组长度都等于 n。这两个数组分别代表 A、B 两种不同能量饮料每小时所能提供的强化能量。
//
//你需要每小时饮用一种能量饮料来 最大化 你的总强化能量。然而，如果从一种能量饮料切换到另一种，你需要等待一小时来梳理身体的能量体系（在那个小时里你将不会获得任何强化能量）。
//
//返回在接下来的 n 小时内你能获得的 最大 总强化能量。
//
//注意 你可以选择从饮用任意一种能量饮料开始。
//
//
//
//示例 1：
//
//输入：energyDrinkA = [1,3,1], energyDrinkB = [3,1,1]
//
//输出：5
//
//解释：
//
//要想获得 5 点强化能量，需要选择只饮用能量饮料 A（或者只饮用 B）。
//
//示例 2：
//
//输入：energyDrinkA = [4,1,1], energyDrinkB = [1,1,3]
//
//输出：7
//
//解释：
//
//第一个小时饮用能量饮料 A。
//切换到能量饮料 B ，在第二个小时无法获得强化能量。
//第三个小时饮用能量饮料 B ，并获得强化能量。
//
//
//提示：
//
//n == energyDrinkA.length == energyDrinkB.length
//3 <= n <= 105
//1 <= energyDrinkA[i], energyDrinkB[i] <= 105
public class TQ2超级饮料的最大强化能量 {
    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
        long ans = 0;
        long t = 0;
        int n = energyDrinkA.length;
        boolean select = false;
        for (int i = 0; i < n; i++) {
            if (!select) {
                t += energyDrinkA[i];
                if (i < n - 2) {
                    int temp = -energyDrinkA[i + 1];
                    for (int j = i + 2; j < n && j < i + 5; j++) {
                        temp += energyDrinkB[j] - energyDrinkA[j];
                    }
                    if (temp > 0) {
                        select = true;
                        i++;
                        continue;
                    }
                }
            }
            if (select) {
                t += energyDrinkB[i];
                if (i < n - 2) {
                    int temp = -energyDrinkB[i + 1];
                    for (int j = i + 2; j < n && j < i + 5; j++) {
                        temp += energyDrinkA[j] - energyDrinkB[j];
                    }
                    if (temp > 0) {
                        select = true;
                        i++;
                    }
                }
            }
        }
        if (t > ans) {
            ans = t;
        }
        t = 0;
        select = true;
        for (int i = 0; i < n; i++) {
            if (!select) {
                t += energyDrinkA[i];
                if (i < n - 2) {
                    int temp = -energyDrinkA[i + 1];
                    for (int j = i + 2; j < n && j < i + 5; j++) {
                        temp += energyDrinkB[j] - energyDrinkA[j];
                    }
                    if (temp > 0) {
                        select = true;
                        i++;
                        continue;
                    }
                }
            }
            if (select) {
                t += energyDrinkB[i];
                if (i < n - 2) {
                    int temp = -energyDrinkB[i + 1];
                    for (int j = i + 2; j < n && j < i + 5; j++) {
                        temp += energyDrinkA[j] - energyDrinkB[j];
                    }
                    if (temp > 0) {
                        select = true;
                        i++;
                    }
                }
            }
        }
        if (t > ans) ans = t;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new TQ2超级饮料的最大强化能量().maxEnergyBoost(
                new int[]{4, 1, 1},
                new int[]{1, 1, 3}));
    }
}
// 解答错误
//501 / 563 个通过的测试用例
//输入
//energyDrinkA =
//[5,5,6,3,4,3,3,4]
//energyDrinkB =
//[5,3,3,4,4,6,6,3]
//添加到测试用例
//输出
//34
//预期结果
//35

// 解答错误
//501 / 563 个通过的测试用例
//输入
//energyDrinkA =
//[4,3,5,3,4,5,6,6,5]
//energyDrinkB =
//[5,5,4,5,6,3,3,4,3]
//添加到测试用例
//输出
//41
//预期结果
//42