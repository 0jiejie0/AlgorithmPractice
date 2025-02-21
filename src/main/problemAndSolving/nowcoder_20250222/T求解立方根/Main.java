package main.problemAndSolving.nowcoder_20250222.T求解立方根;

import java.util.Scanner;

//  时间限制：1秒  空间限制：32M
//知识点
//基础数学
//二分
//warning 校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
//描述
//计算一个浮点数的立方根，不使用库函数。
//保留一位小数。
//
//数据范围：
//∣
//v
//a
//l
//∣
//≤
//20
//
//∣val∣≤20
//
//输入描述：
//待求解参数，为double类型（一个实数）
//
//输出描述：
//输出参数的立方根。保留一位小数。
//
//示例1
//输入：
//19.9
//复制
//输出：
//2.7
//复制
//示例2
//输入：
//2.7
//复制
//输出：
//1.4
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double n = scanner.nextDouble();
        double v = n / 3;
        double t = (2 * v + n / v / v) / 3;
        while (!String.format("%.1f", t).equals(String.format("%.1f", v))) {
            v = t;
            t = (2 * v + n / v / v) / 3;
        }
        System.out.println(String.format("%.1f", t));
    }
}

// 通过全部用例
//运行时间
//59ms
//占用内存
//12572KB

// 用了求解平方根的思路，一遍过
