package main.hdu_20200207;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AscSort.start(new Scanner(System.in));
    }

}

/**
 * hdu 2000
 * Problem Description
 * 输入三个字符后，按各字符的ASCII码从小到大的顺序输出这三个字符。
 * <p>
 * Input
 * 输入数据有多组，每组占一行，有三个字符组成，之间无空格。
 * Output
 * 对于每组输入数据，输出一行，字符中间用一个空格分开。
 * <p>
 * Sample Input
 * qwe
 * asd
 * zxc
 * Sample Output
 * e q w
 * a d s
 * c x z
 */
class AscSort {
    public static final void start(Scanner scanner) {
        while (scanner.hasNext()) {
            char[] chars = scanner.nextLine().toCharArray();
            char[] res = sort(chars[0], chars[1], chars[2]);
            for (int i = 0; i < res.length; i++) {
                if (i != 0) {
                    System.out.print(" ");
                }
                System.out.print(res[i]);
            }
            System.out.println();
        }
    }

    private static final char[] sort(char a, char b, char c) {
        char temp;
        if (a > b) {
            a ^= b;
            b ^= a;
            a ^= b;
        }
        if (b > c) {
            b ^= c;
            c ^= b;
            b ^= c;
        }
        if (a > b) {
            a ^= b;
            b ^= a;
            a ^= b;
        }
        return new char[]{a, b, c};
    }
}