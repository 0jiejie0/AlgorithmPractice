package main.problemAndSolving.lanqiao_20201008;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    /**
     * 试题 入门训练 序列求和
     * <p>
     * 资源限制
     * 时间限制：1.0s   内存限制：256.0MB
     * 问题描述
     * 求1+2+3+...+n的值。
     * 输入格式
     * 输入包括一个整数n。
     * 输出格式
     * 输出一行，包括一个整数，表示1+2+3+...+n的值。
     * 样例输入
     * 4
     * 样例输出
     * 10
     * 样例输入
     * 100
     * 说明：有一些试题会给出多组样例输入输出以帮助你更好的做题。
     * <p>
     * 一般在提交之前所有这些样例都需要测试通过才行，但这不代表这几组样例数据都正确了你的程序就是完全正确的，潜在的错误可能仍然导致你的得分较低。
     * <p>
     * 样例输出
     * 5050
     * 数据规模与约定
     * 1 <= n <= 1,000,000,000。
     * 说明：请注意这里的数据规模。
     * <p>
     * 本题直接的想法是直接使用一个循环来累加，然而，当数据规模很大时，这种“暴力”的方法往往会导致超时。此时你需要想想其他方法。你可以试一试，如果使用1000000000作为你的程序的输入，你的程序是不是能在规定的上面规定的时限内运行出来。
     * <p>
     * 本题另一个要值得注意的地方是答案的大小不在你的语言默认的整型(int)范围内，如果使用整型来保存结果，会导致结果错误。
     * <p>
     * 如果你使用C++或C语言而且准备使用printf输出结果，则你的格式字符串应该写成%I64d以输出long long类型的整数。
     */
    public static final BigInteger sum(int n) {
        int m = n + 1;
        if ((n & 1) == 1) {
            m >>= 1;
        } else {
            n >>= 1;
        }
        return BigInteger.valueOf(n).multiply(BigInteger.valueOf(m));
    }

    /**
     * 试题 入门训练 Fibonacci数列
     * <p>
     * 资源限制
     * 时间限制：1.0s   内存限制：256.0MB
     * 问题描述
     * Fibonacci数列的递推公式为：Fn=Fn-1+Fn-2，其中F1=F2=1。
     * <p>
     * 当n比较大时，Fn也非常大，现在我们想知道，Fn除以10007的余数是多少。
     * <p>
     * 输入格式
     * 输入包含一个整数n。
     * 输出格式
     * 输出一行，包含一个整数，表示Fn除以10007的余数。
     * 说明：在本题中，答案是要求Fn除以10007的余数，因此我们只要能算出这个余数即可，而不需要先计算出Fn的准确值，再将计算的结果除以10007取余数，直接计算余数往往比先算出原数再取余简单。
     * <p>
     * 样例输入
     * 10
     * 样例输出
     * 55
     * 样例输入
     * 22
     * 样例输出
     * 7704
     * 数据规模与约定
     * 1 <= n <= 1,000,000。
     *
     * @param n
     * @return
     */
    public static final int fibo(int n) {
        int mod = 10007;
        int res = 1, last = 1;
        for (int i = 3; i <= n; i++) {
            res ^= last;
            last ^= res;
            res ^= last;
            res += last;
            if (res > mod) {
                res %= mod;
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(sum(new Scanner(System.in).nextInt()));
        System.out.println(fibo(new Scanner(System.in).nextInt()));
    }
}
