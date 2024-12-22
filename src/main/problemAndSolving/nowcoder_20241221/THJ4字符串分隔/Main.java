package main.problemAndSolving.nowcoder_20241221.THJ4字符串分隔;

import java.util.Scanner;

// 简单  通过率：26.87%  时间限制：1秒  空间限制：32M
//知识点
//字符串
//warning 校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
//描述
//对于给定的由小写字母和数字混合构成的字符串
//s
//s ，你需要按每
//8
//8 个字符换一行的方式书写它，具体地：
//∙
// 
//∙书写前
//8
//8 个字符，换行；
//∙
// 
//∙书写接下来的
//8
//8 个字符，换行；
//∙
// 
//∙……
//∙
// 
//∙重复上述过程，直到字符串被完全书写。
//特别地，如果最后一行不满
//8
//8 个字符，则需要在字符串末尾补充
//0
//0 ，直到长度为
//8
//8 。
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
//100
//1≦length(s)≦100 ，由小写字母和数字混合构成的字符串
//s
//s 。
//输出描述：
//输出若干行，每行输出
//8
//8 个字符，代表按题意书写的结果。
//示例1
//输入：
//hellonowcoder
//复制
//输出：
//hellonow
//coder000
//复制
//说明：
//在这个样例中，字符串长度为
//13
//13 ，因此需要在第二行末尾补充
//3
//3 个
//0
//0 。
//示例2
//输入：
//0
//复制
//输出：
//00000000
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] charArray = scanner.nextLine().toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if ((i % 8) == 0 && i != 0) {
                System.out.println();
            }
            System.out.print(charArray[i]);
        }
        if (charArray.length % 8 != 0) {
            for (int i = 0; i < 8 - charArray.length % 8; i++) {
                System.out.print("0");
            }
        }
    }
}
