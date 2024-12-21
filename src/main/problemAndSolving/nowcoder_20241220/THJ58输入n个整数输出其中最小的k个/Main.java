package main.problemAndSolving.nowcoder_20241220.THJ58输入n个整数输出其中最小的k个;

import java.util.Arrays;
import java.util.Scanner;

// 入门  通过率：34.61%  时间限制：1秒  空间限制：32M
//知识点
//数组
//排序
//warning 校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
//描述
//输入n个整数，找出其中最小的k个整数并按升序输出
//
//本题有多组输入样例
//
//数据范围：
//1
//≤
//n
//≤
//1000
//
//1≤n≤1000  ，输入的整数满足
//1
//≤
//v
//a
//l
//≤
//10000
//
//1≤val≤10000
//输入描述：
//第一行输入两个整数n和k
//第二行输入一个整数数组
//
//输出描述：
//从小到大输出最小的k个整数，用空格分开。
//
//示例1
//输入：
//5 2
//1 3 5 7 2
//复制
//输出：
//1 2
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = scanner.nextInt();
        }
        Arrays.sort(ints);
        for (int i = 0; i < k; i++) {
            if (i != 0) {
                System.out.print(" ");
            }
            System.out.print(ints[i]);
        }
    }
}
