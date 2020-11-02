package main.algo._02递归;

public class 最大公约数 {
    /**
     * 辗转相除法求
     *
     * @param m
     * @param n
     * @return
     */
    public int greatestCommonDivisor(int m, int n) {
        if (m % n == 0) {
            return n;
        }
        return greatestCommonDivisor(n, m % n);
    }
}
