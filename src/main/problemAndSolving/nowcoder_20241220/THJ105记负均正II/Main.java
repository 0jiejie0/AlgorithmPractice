package main.problemAndSolving.nowcoder_20241220.THJ105记负均正II;

import java.util.Scanner;

// 简单  通过率：26.87%  时间限制：1秒  空间限制：32M
//知识点
//数组
//思维
//warning 校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
//描述
//输入 n 个整型数，统计其中的负数个数并求所有非负数的平均值，结果保留一位小数，如果没有非负数，则平均值为0
//本题有多组输入数据，输入到文件末尾。
//
//数据范围：
//1
//≤
//n
//≤
//50000
//
//1≤n≤50000  ，其中每个数都满足
//∣
//v
//a
//l
//∣
//≤
//1
//0
//6
//
//∣val∣≤10
//6
//
//输入描述：
//输入任意个整数，每行输入一个。
//
//输出描述：
//输出负数个数以及所有非负数的平均值
//
//示例1
//输入：
//-13
//-4
//-7
//复制
//输出：
//3
//0.0
//复制
//示例2
//输入：
//-12
//1
//2
//复制
//输出：
//1
//1.5
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        int countb = 0;
        long sum = 0;
        while (scanner.hasNextInt()) {
            int a = scanner.nextInt();
            if (a < 0) {
                countb++;
            } else {
                count++;
                sum += a;
            }
        }
        System.out.println(countb);
        System.out.printf("%.1f", count == 0 ? 0.0 : (((double) sum) / count));
    }
}
