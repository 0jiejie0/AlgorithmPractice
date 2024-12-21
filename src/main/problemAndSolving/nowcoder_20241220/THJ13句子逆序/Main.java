package main.problemAndSolving.nowcoder_20241220.THJ13句子逆序;

import java.util.Scanner;

// 简单  通过率：43.25%  时间限制：1秒  空间限制：32M
//知识点
//数组
//warning 校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
//描述
//对于给定的若干个单词组成的句子，每个单词均由大小写字母混合构成，单词间使用单个空格分隔。输出以单词为单位逆序排放的结果，即仅逆序单词间的相对顺序，不改变单词内部的字母顺序。
//输入描述：
//在一行上输入若干个字符串，每个字符串代表一个单词，组成给定的句子。
//除此之外，保证每个单词非空，由大小写字母混合构成，且总字符长度不超过
//1
//0
//3
//10
//3
//  。
//输出描述：
//在一行上输出一个句子，代表以单词为单位逆序排放的结果。
//示例1
//输入：
//Nowcoder Hello
//复制
//输出：
//Hello Nowcoder
//复制
//示例2
//输入：
//A b C d
//复制
//输出：
//d C b A
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        for (int i = split.length - 1; i >= 0; i--) {
            System.out.print(split[i]);
            if (i != 0) {
                System.out.print(" ");
            }
        }
    }
}
