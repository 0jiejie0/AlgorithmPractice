package main.problemAndSolving.nowcoder_20241220.THJ97记负均正;

import java.util.Scanner;

// 简单  通过率：19.69%  时间限制：1秒  空间限制：32M
//知识点
//数组
//思维
//warning 校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
//描述
//首先输入要输入的整数个数n，然后输入n个整数。输出为n个整数中负数的个数，和所有正整数的平均值，结果保留一位小数。
//0即不是正整数，也不是负数，不计入计算。如果没有正数，则平均值为0。
//
//数据范围：
//1
//≤
//n
//
//≤
//2000
//
//1≤n ≤2000  ，输入的整数都满足
//∣
//v
//a
//l
//∣
//≤
//1000
//
//∣val∣≤1000
//输入描述：
//首先输入一个正整数n，
//然后输入n个整数。
//
//输出描述：
//输出负数的个数，和所有正整数的平均值。
//
//示例1
//输入：
//11
//1 2 3 4 5 6 7 8 9 0 -1
//复制
//输出：
//1 5.0
//复制
//示例2
//输入：
//3
//0 0 0
//复制
//输出：
//0 0.0
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 0;
        int countb = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int anInt = scanner.nextInt();
            if (anInt < 0) {
                countb++;
            } else if (anInt > 0) {
                sum += anInt;
                count++;
            }
        }
        System.out.print(countb + " ");
        System.out.printf("%.1f", count == 0 ? 0.0 : (((double) sum) / count));
    }
}
