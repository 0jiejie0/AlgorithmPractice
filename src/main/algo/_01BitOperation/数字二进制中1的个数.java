package main.algo._01BitOperation;

import java.util.Scanner;

public class 数字二进制中1的个数 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println(countRightShift(n));
        System.out.println(countANDOpr(n));
    }

    public static final int countRightShift(int n) {
        int res = 0;
        for (int i = 0; i < 32 && n >> i > 0; i++) {
            if (((n >> i) & 1) == 1) {
                res++;
            }
        }
        return res;
    }

    public static final int countANDOpr(int n) {
        int res = 0;
        while (n > 0) {
            n &= (n - 1);
            res++;
        }
        return res;
    }
}
