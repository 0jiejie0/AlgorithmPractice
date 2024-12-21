package main.problemAndSolving.nowcoder_20241220.THJ9提取不重复的整数;

import java.util.LinkedList;
import java.util.Scanner;

// 入门  通过率：46.63%  时间限制：1秒  空间限制：32M
//知识点
//数组
//哈希
//warning 校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
//描述
//对于给定的正整数
//n
//n ，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
//输入描述：
//在一行上输入一个正整数
//n
//(
//1
//≦
//n
//≦
//1
//0
//8
//)
//n(1≦n≦10
//8
// ) 代表给定的整数。
//保证
//n
//n 的最后一位不为
//0
//0 。
//输出描述：
//在一行上输出一个整数，代表处理后的数字。
//示例1
//输入：
//9876673
//复制
//输出：
//37689
//复制
//说明：
//在这个样例中，先将数字倒序，得到
//3766789
//3766789 ，然后去除重复数字，得到
//37689
//37689 。
//示例2
//输入：
//12345678
//复制
//输出：
//87654321
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Character> characters = new LinkedList<>();
        char[] charArray = scanner.next().toCharArray();
        for (int i = charArray.length - 1; i >= 0; i--) {
            if (!characters.contains(charArray[i])) {
                characters.offer(charArray[i]);
            }
        }
        while (!characters.isEmpty()) {
            System.out.print(characters.pop());
        }
    }
}
