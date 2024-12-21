package main.problemAndSolving.nowcoder_20241220.THJ80整型数组合并;

import java.util.Arrays;
import java.util.Scanner;

// 简单  通过率：35.12%  时间限制：1秒  空间限制：32M
//知识点
//排序
//数组
//哈希
//warning 校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
//描述
//题目标题：
//
//将两个整型数组按照升序合并，并且过滤掉重复数组元素。
//输出时相邻两数之间没有空格。
//
//
//
//
//
//输入描述：
//输入说明，按下列顺序输入：
//1 输入第一个数组的个数
//2 输入第一个数组的数值
//3 输入第二个数组的个数
//4 输入第二个数组的数值
//
//输出描述：
//输出合并之后的数组
//
//示例1
//输入：
//3
//1 2 5
//4
//-1 0 3 2
//复制
//输出：
//-101235
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int[] a = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = scanner.nextInt();
        }
        int n = scanner.nextInt();
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        Arrays.sort(a);
        Arrays.sort(b);
        int s = 0, t = 0;
        while (s < a.length && t < b.length) {
            if (a[s] == b[t]) {
                System.out.print(a[s]);
                while (s < a.length - 1 && a[s + 1] == a[s]) {
                    s++;
                }
                s++;
                while (t < b.length - 1 && b[t + 1] == b[t]) {
                    t++;
                }
                t++;
            } else if (a[s] <= b[t]) {
                System.out.print(a[s]);
                while (s < a.length - 1 && a[s + 1] == a[s]) {
                    s++;
                }
                s++;
            } else {
                System.out.print(b[t]);
                while (t < b.length - 1 && b[t + 1] == b[t]) {
                    t++;
                }
                t++;
            }
        }
        while (s < a.length) {
            System.out.print(a[s]);
            while (s < a.length - 1 && a[s + 1] == a[s]) {
                s++;
            }
            s++;
        }
        while (t < b.length) {
            System.out.print(b[t]);
            while (t < b.length - 1 && b[t + 1] == b[t]) {
                t++;
            }
            t++;
        }
    }
}
