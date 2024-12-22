package main.problemAndSolving.nowcoder_20241221.THJ11数字颠倒;

import java.util.Scanner;

// 简单  通过率：59.38%  时间限制：1秒  空间限制：32M
//知识点
//字符串
//warning 校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
//描述
//对于给定的非负整数
//n
//n ，将其以字符串的形式颠倒后输出。这意味着，如果
//n
//n 的末尾含
//0
//0 ，那么返回的字符串开头也需要含
//0
//0 。
//输入描述：
//在一行上输入一个非负整数
//n
//(
//0
//≦
//n
//<
//2
//30
//)
//n(0≦n<2
//30
// ) 代表给定的整数。
//输出描述：
//在一行上输出一个字符串，代表颠倒后的数字。
//示例1
//输入：
//1516000
//复制
//输出：
//0006151
//复制
//示例2
//输入：
//0
//复制
//输出：
//0
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(new StringBuilder(scanner.nextLine()).reverse());
    }
}
