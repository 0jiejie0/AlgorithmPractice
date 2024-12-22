package main.problemAndSolving.nowcoder_20241221.THJ12字符串反转;

import java.util.Scanner;

// 简单  通过率：61.75%  时间限制：1秒  空间限制：32M
//知识点
//字符串
//warning 校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
//描述
//对于给定的仅由小写字母构成的字符串
//s
//s ，将其颠倒后输出。
//输入描述：
//在一行上输入一个长度
//1
//≦
//l
//e
//n
//g
//t
//h
//(
//s
//)
//≦
//1000
//1≦length(s)≦1000 ，仅由小写字母构成的字符串
//s
//s 。
//输出描述：
//在一行上输出一个字符串，代表颠倒后的字符串。
//示例1
//输入：
//redocwonolleh
//复制
//输出：
//hellonowcoder
//复制
//示例2
//输入：
//a
//复制
//输出：
//a
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(new StringBuilder(scanner.nextLine()).reverse());
    }
}
