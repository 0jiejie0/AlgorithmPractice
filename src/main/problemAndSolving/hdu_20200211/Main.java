package main.problemAndSolving.hdu_20200211;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext())
            SquareAndCube.calculate(scanner);
    }
}

/**
 * 平方和与立方和
 * Time Limit: 2000/1000 MS (Java/Others)    Memory Limit: 65536/32768 K (Java/Others)
 * Total Submission(s): 274001    Accepted Submission(s): 86723
 * Problem Description
 * 给定一段连续的整数，求出他们中所有偶数的平方和以及所有奇数的立方和。
 * <p>
 * Input
 * 输入数据包含多组测试实例，每组测试实例包含一行，由两个整数m和n组成。
 * Output
 * 对于每组输入数据，输出一行，应包括两个整数x和y，分别表示该段连续的整数中所有偶数的平方和以及所有奇数的立方和。
 * 你可以认为32位整数足以保存结果。
 * <p>
 * Sample Input
 * 1 3
 * 2 5
 * Sample Output
 * 4 28
 * 20 152
 */
class SquareAndCube {
    public static final void calculate(Scanner input) {
        int start = input.nextInt();
        int end = input.nextInt();
        int square = 0;
        int cube = 0;
        for (int i = start; i <= end; i++) {
            if ((i & 1) == 0) {
                square += (i * i);
            } else {
                cube += (int) Math.pow(i, 3);
            }
        }
        System.out.println(square + " " + cube);
    }
}
