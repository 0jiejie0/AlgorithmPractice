package main.problemAndSolving.nowcoder_20241221.THJ2计算某字符出现次数;

import java.util.Scanner;

// 简单  通过率：30.25%  时间限制：1秒  空间限制：32M
//知识点
//字符串
//哈希
//warning 校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
//描述
//对于给定的由大小写字母、数字和空格混合构成的字符串
//s
//s ，统计字符
//c
//c 在其中出现的次数。具体来说：
//∙
// 
//∙若
//c
//c 为大写或者小写字母，统计其大小写形态出现的次数和；
//∙
// 
//∙若
//c
//c 为数字，统计其出现的次数。
//保证字符
//c
//c 仅为大小写字母或数字。
//输入描述：
//第一行输入一个长度
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
//1
//0
//3
//1≦length(s)≦10
//3
//  ，由大小写字母、数字和空格混合构成的字符串
//s
//s 。保证首尾不为空格。
//第二行输入一个字符
//c
//c ，代表需要统计的字符。
//输出描述：
//在一行上输出一个整数，代表字符
//c
//c 在字符串
//s
//s 中出现的次数。
//示例1
//输入：
//HELLONowcoder123
//o
//复制
//输出：
//3
//复制
//说明：
//由于
//o
//o 为小写字母，因此统计其小写形态出现的次数和，即
//3
//3 。
//示例2
//输入：
//H E L L O Nowcoder123
//1
//复制
//输出：
//1
public class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            char[] charArray = scanner.nextLine().toLowerCase().toCharArray();
            char c = scanner.nextLine().toLowerCase().charAt(0);
            int count = 0;
            for (char c1 : charArray) {
                if (c == c1) {
                    count++;
                }
            }
            System.out.println(count);
        }
}
