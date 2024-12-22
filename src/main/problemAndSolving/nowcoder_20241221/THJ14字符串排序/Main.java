package main.problemAndSolving.nowcoder_20241221.THJ14字符串排序;

import java.util.Arrays;
import java.util.Scanner;

// 简单  通过率：42.16%  时间限制：1秒  空间限制：32M
//知识点
//字符串
//排序
//warning 校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
//描述
//对于给定的由大小写字母混合构成的
//n
//n 个单词，输出按字典序从小到大排序后的结果。
//
//从字符串的第一个字符开始逐个比较，直到找到第一个不同的位置，通过比较这个位置字符对应的
//A
//s
//c
//i
//i
//Ascii 码（
//A
//<
//⋯
//<
//Z
//<
//a
//<
//⋯
//<
//z
//A<⋯<Z<a<⋯<z ）得出字符串的大小，称为字典序比较。
//1
//≤
//n
//≤
//1000
//
//1≤n≤1000
//1
//≤
//l
//e
//n
//≤
//100
//
//1≤len≤100
//输入描述：
//第一行输入一个整数
//n
//(
//1
//≦
//n
//≦
//1000
//)
//n(1≦n≦1000) 代表给定的单词个数。
//此后
//n
//n 行，每行输入一个长度
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
//100
//1≦length(s)≦100 ，由大小写字母混合构成的字符串
//s
//s ，代表一个单词。
//输出描述：
//输出
//n
//n 行，每行输出一个字符串，代表排序后的结果。第一行输出字典序最小的单词。
//示例1
//输入：
//11
//cap
//to
//cat
//card
//two
//too
//up
//boat
//boot
//AA
//Aa
//复制
//输出：
//AA
//Aa
//boat
//boot
//cap
//card
//cat
//to
//too
//two
//up
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = scanner.nextLine();
        }
        Arrays.sort(strings);
        for (int i = 0; i < n; i++) {
            System.out.println(strings[i]);
        }
    }
}
