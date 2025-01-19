package main.problemAndSolving.nowcoder_20241223.T3数独;

import java.util.Scanner;

// 数独是一个我们都非常熟悉的经典游戏，运用计算机我们可以很快地解开数独难题，现在有一些简单的数独题目，请编写一个程序求解。
//如有多解，输出一个解
//时间限制：C/C++ 1秒，其他语言2秒
//空间限制：C/C++ 32M，其他语言64M
//输入描述：
//输入9行，每行为空格隔开的9个数字，为0的地方就是需要填充的。
//输出描述：
//输出九行，每行九个空格隔开的数字，为解出的答案。
public class Main {
    public static void main(String[] args) {
        int[][] nums = new int[9][9];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                nums[i][j] = scanner.nextInt();
            }
        }
        dep(nums);
        for (int i = 0; i < 9; i++) {
            if (i != 0) {
                System.out.println();
            }
            for (int j = 0; j < 9; j++) {
                if (j != 0) {
                    System.out.print(" ");
                }
                System.out.print(nums[i][j]);
            }
        }
    }

    private static boolean dep(int[][] nums) {
        int i = 0, j = 0;
        int c0 = 0;
        for (int ii = 0; ii < 9; ii++) {
            for (int jj = 0; jj < 9; jj++) {
                if (nums[ii][jj] == 0) {
                    int n = 0;
                    for (int k = 0; k < 9; k++) {
                        if (nums[ii][k] != 0) {
                            n++;
                        }
                    }
                    if (n > c0) {
                        c0 = n;
                        i = ii;
                        j = jj;
                    }
                    n = 0;
                    for (int k = 0; k < 9; k++) {
                        if (nums[k][jj] != 0) {
                            n++;
                        }
                    }
                    if (n > c0) {
                        c0 = n;
                        i = ii;
                        j = jj;
                    }
                } else if (ii == 8 && jj == 8 && c0 == 0) {
                    return true;
                }
            }
        }
        for (int k = 1; k < 10; k++) {
            boolean tag = true;
            for (int l = 0; l < 9 && tag; l++) {
                if (k == nums[i][l]) {
                    tag = false;
                }
            }
            for (int l = 0; l < 9 && tag; l++) {
                if (k == nums[l][j]) {
                    tag = false;
                }
            }
            for (int l = 0; l < 3 && tag; l++) {
                for (int m = 0; m < 3 && tag; m++) {
                    if (k == nums[(i / 3) * 3 + l][(j / 3) * 3 + m]) {
                        tag = false;
                    }
                }
            }
            if (tag) {
                nums[i][j] = k;
                if (dep(nums)) {
                    return true;
                }
                nums[i][j] = 0;
            }
        }
        return false;
    }
}
