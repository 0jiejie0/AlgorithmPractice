package main.problemAndSolving.nowcoder_20241221.THJ10字符个数统计;

import java.util.HashSet;
import java.util.Scanner;

// 简单  通过率：50.18%  时间限制：1秒  空间限制：32M
//知识点
//字符串
//哈希
//warning 校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
//描述
//对于给定的字符串，统计其中的
//A
//S
//C
//I
//I
//ASCII 在
//0
//0 到
//127
//127 范围内的不同字符的个数。
//
//备注：受限于输入，本题实际输入字符集为
//A
//S
//C
//I
//I
//ASCII 码在
//33
//33 到
//126
//126 范围内的可见字符。您可以参阅下表获得其详细信息（您可能关注的内容是，这其中不包含空格、换行）。
//
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
//500
//1≦length(s)≦500 的字符串
//s
//s ，代表给定的字符串。
//输出描述：
//在一行上输出一个整数，代表给定字符串中
//A
//S
//C
//I
//I
//ASCII 在
//0
//0 到
//127
//127 范围内的不同字符的个数。
//示例1
//输入：
//[@A8aA].0
//复制
//输出：
//8
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] charArray = scanner.nextLine().toCharArray();
        HashSet<Character> set = new HashSet<>();
        for (char c : charArray) {
            set.add(c);
        }
        System.out.println(set.size());
    }
}
