package main.problemAndSolving.nowcoder.HUAWEIod.HJ26字符串排序;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//编写一个程序，将输入字符串中的字符按如下规则排序。
//
//规则 1 ：英文字母从 A 到 Z 排列，不区分大小写。
//
//如，输入： Type 输出： epTy
//
//规则 2 ：同一个英文字母的大小写同时存在时，按照输入顺序排列。
//
//如，输入： BabA 输出： aABb
//
//规则 3 ：非英文字母的其它字符保持原来的位置。
//
//
//如，输入： By?e 输出： Be?y
//
//数据范围：输入的字符串长度满足 1 \le n \le 1000 \1≤n≤1000
//
//输入描述：
//输入字符串
//输出描述：
//输出字符串
//示例1
//输入：
//A Famous Saying: Much Ado About Nothing (2012/8).
//复制
//输出：
//A aaAAbc dFgghh: iimM nNn oooos Sttuuuy (2012/8).
// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] chars = in.nextLine().toCharArray();
        Queue<Character>[] queues = new Queue[26];
        for (int i = 0; i < 26; i++) {
            queues[i] = new LinkedList<Character>();
        }
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c >= 'a' && c <= 'z') {
                queues[c - 'a'].offer(c);
            } else if (c >= 'A' && c <= 'Z') {
                queues[c - 'A'].offer(c);
            } else {
                continue;
            }
            chars[i] = 'a';
        }
        int j = 0;
        for (int i = 0; i < queues.length; i++) {
            Queue<Character> queue = queues[i];
            while (!queue.isEmpty()) {
                while (chars[j] != 'a') j++;
                chars[j++] = queue.poll();

            }
        }
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i]);
        }
        System.out.println();
    }
}