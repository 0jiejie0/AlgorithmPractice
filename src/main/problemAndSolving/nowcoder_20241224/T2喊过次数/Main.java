package main.problemAndSolving.nowcoder_20241224.T2喊过次数;

import java.util.Scanner;

//  跳七，
//  从1开始，七的倍数或含7的喊过，
//  给出n个数字的乱序表示n个人喊过次数，
//  让你把n个人的喊过次数顺序排列

// 全部用例通过
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        int count = 0;
        while (scanner.hasNextInt()) {
            n++;
            count += scanner.nextInt();
        }
        int[] ints = new int[n];
        int dc = 0;
        for (int i = 1; i <= 200 && dc != count; i++) {
            if (i % 7 == 0 || i % 10 == 7 || (i / 10) % 10 == 7) {
                dc++;
                ints[(i - 1) % n]++;
            }
        }
        for (int i = 0; i < ints.length; i++) {
            if (i != 0) {
                System.out.print(" ");
            }
            System.out.print(ints[i]);
        }
    }
}
