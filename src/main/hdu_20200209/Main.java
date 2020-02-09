package main.hdu_20200209;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DistanceBetweenTwoPoints.figure(new Scanner(System.in));
    }
}

/**
 * Problem Description
 * 输入两点坐标（X1,Y1）,（X2,Y2）,计算并输出两点间的距离。
 * <p>
 * Input
 * 输入数据有多组，每组占一行，由4个实数组成，分别表示x1,y1,x2,y2,数据之间用空格隔开。
 * Output
 * 对于每组输入数据，输出一行，结果保留两位小数。
 * <p>
 * Sample Input
 * 0 0 0 1
 * 0 1 1 0
 * Sample Output
 * 1.00
 * 1.41
 * <p>
 * Time Limit: 2000/1000 MS (Java/Others)    Memory Limit: 65536/32768 K (Java/Others)
 * Total Submission(s): 349269    Accepted Submission(s): 118705
 * <p>
 * 32423631	2020-02-09 19:02:55	Accepted	2001	296MS	9756K	1249B	Java	解孔明
 */
class DistanceBetweenTwoPoints {
    public static final void figure(Scanner scanner) {
        while (scanner.hasNext()) {
            double xa = scanner.nextDouble();
            double ya = scanner.nextDouble();
            double x = scanner.nextDouble() - xa;
            double y = scanner.nextDouble() - ya;
            System.out.println(format(Math.pow(x * x + y * y, 0.5), 2));
        }
    }

    public static final String format(Double d, int len) {
        String res = new BigDecimal(d).setScale(len, BigDecimal.ROUND_HALF_UP).doubleValue() + "";
        while (res.split("\\.")[1].length() < len) {
            res += "0";
        }
        return res;
    }
}