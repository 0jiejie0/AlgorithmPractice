package main.hdu_20200212;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            NumStatis.put(scanner);
        }
    }
}

/**
 * 数值统计
 * Time Limit: 2000/1000 MS (Java/Others)    Memory Limit: 65536/32768 K (Java/Others)
 * Total Submission(s): 174930    Accepted Submission(s): 82202
 * Problem Description
 * 统计给定的n个数中，负数、零和正数的个数。
 * <p>
 * Input
 * 输入数据有多组，每组占一行，每行的第一个数是整数n（n<100），表示需要统计的数值的个数，然后是n个实数；如果n=0，则表示输入结束，该行不做处理。
 * Output
 * 对于每组输入数据，输出一行a,b和c，分别表示给定的数据中负数、零和正数的个数。
 * <p>
 * Sample Input
 * 6 0 1 2 3 -1 0
 * 5 1 2 3 4 0.5
 * 0
 * Sample Output
 * 1 2 3
 * 0 0 5
 */
class NumStatis {
    public static final void put(Scanner input) {
        double n = input.nextDouble();
        int negative = 0;
        int zero = 0;
        for (int i = 0; i < n; i++) {
            double temp = input.nextDouble();
            if (temp == 0) {
                zero++;
            } else if (temp < 0) {
                negative++;
            }
        }
        if (n > 0)
            System.out.println(negative + " " + zero + " " + (n - negative - zero));
    }
}