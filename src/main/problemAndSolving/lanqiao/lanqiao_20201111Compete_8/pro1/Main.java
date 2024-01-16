package main.problemAndSolving.lanqiao.lanqiao_20201111Compete_8.pro1;

import java.util.HashSet;

public class Main {

    /**
     * 标题：平方十位数
     * <p>
     * 由0~9这10个数字不重复、不遗漏，可以组成很多10位数字。 这其中也有很多恰好是平方数（是某个数的平方）。
     * <p>
     * 比如：1026753849，就是其中最小的一个平方数。
     * <p>
     * 请你找出其中最大的一个平方数是多少？
     * <p>
     * 注意：你需要提交的是一个10位数字，不要填写任何多余内容。
     *
     * @param args
     */
    public static void main(String[] args) {
        // 从根下1 000 000 000=31622到根下9 999 999 999=100 000
        for (int i = 100000; i >= 31622; i--) {
            if (test(((long) i) * i)) {
                System.out.println(((long) i) * i);//9814072356
                return;
            }
        }
    }

    /**
     * 检查数字是否满足由0~9这10个数字不重复、不遗漏，组成的10位数字
     *
     * @param square
     * @return
     */
    private static boolean test(long square) {
        char[] chars = ("" + square).toCharArray();
        if (chars.length != 10) {// 检查数字长度
            return false;
        }
        HashSet<Character> set = new HashSet<Character>();
        for (char c : chars) {// 查重
            if (set.contains(c)) {
                return false;
            } else {
                set.add(c);
            }
        }
        return true;
    }
}
