package main.problemAndSolving.hdu.hdu_20200210;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            OddProduct.gather(input);
        }
    }
}

/**
 * 求奇数的乘积
 * Time Limit: 2000/1000 MS (Java/Others)    Memory Limit: 65536/32768 K (Java/Others)
 * Total Submission(s): 157485    Accepted Submission(s): 94208
 * 32440494	2020-02-10 22:57:10	Accepted	2006	312MS	9376K	1281 B	Java	解孔明
 * <p>
 * Problem Description
 * 给你n个整数，求他们中所有奇数的乘积。
 * <p>
 * Input
 * 输入数据包含多个测试实例，每个测试实例占一行，每行的第一个数为n，表示本组数据一共有n个，接着是n个整数，你可以假设每组数据必定至少存在一个奇数。
 * Output
 * 输出每组数中的所有奇数的乘积，对于测试实例，输出一行。
 * <p>
 * Sample Input
 * 3 1 2 3
 * 4 2 3 4 5
 * Sample Output
 * 3
 * 15
 */
class OddProduct {
    private static BigInteger temp;

    public static final void gather(Scanner input) {
        BigInteger integer = BigInteger.ONE;
        int n = input.nextInt();
        for (int i = 0; i < n; i++) {
            temp = input.nextBigInteger();
            if ((temp.toByteArray()[0] & 1) == 1)
                integer = integer.multiply(temp);
        }
        System.out.println(integer);
    }
}

/**
 * 第几天？
 * Time Limit: 2000/1000 MS (Java/Others)    Memory Limit: 65536/32768 K (Java/Others)
 * Total Submission(s): 253224    Accepted Submission(s): 87541
 * WA
 * Problem Description
 * 给定一个日期，输出这个日期是该年的第几天。
 * <p>
 * Input
 * 输入数据有多组，每组占一行，数据格式为YYYY/MM/DD组成，具体参见sample input ,另外，可以向你确保所有的输入数据是合法的。
 * Output
 * 对于每组输入数据，输出一行，表示该日期是该年的第几天。
 * <p>
 * Sample Input
 * 1985/1/20
 * 2006/3/12
 * Sample Output
 * 20
 * 71
 */
class DayOfYear {
    public static final void find(Scanner input) {
        Date date = new Date(input.nextLine());
        System.out.println(
                (date.getTime() - new Date(date.getYear() + 1900 + "/1/1").getTime()) / (1000 * 60 * 60 * 24) + 1
        );
    }
}

/**
 * 成绩转换
 * Time Limit: 2000/1000 MS (Java/Others)    Memory Limit: 65536/32768 K (Java/Others)
 * Total Submission(s): 238340    Accepted Submission(s): 102389
 * 32428784	2020-02-10 11:19:48	Accepted	2004	265MS	9320K	2890 B	Java	解孔明
 * <p>
 * Problem Description
 * 输入一个百分制的成绩t，将其转换成对应的等级，具体转换规则如下：
 * 90~100为A;
 * 80~89为B;
 * 70~79为C;
 * 60~69为D;
 * 0~59为E;
 * <p>
 * Input
 * 输入数据有多组，每组占一行，由一个整数组成。
 * Output
 * 对于每组输入数据，输出一行。如果输入数据不在0~100范围内，请输出一行：“Score is error!”。
 * <p>
 * Sample Input
 * 56
 * 67
 * 100
 * 123
 * Sample Output
 * E
 * D
 * A
 * Score is error!
 */
class Score {
    public static final void trans(Scanner input) {
        while (input.hasNext()) {
            System.out.println(reflect(input.nextInt()));
        }
    }

    public static final String reflect(int score) {
        String res = null;
        if (score < 0 || 100 < score) {
            return "Score is error!";
        }
        switch (score / 10) {
            case 10:
            case 9:
                res = "A";
                break;
            case 8:
                res = "B";
                break;
            case 7:
                res = "C";
                break;
            case 6:
                res = "D";
                break;
            default:
                res = "E";
                break;
        }
        return res;
    }
}

/**
 * 求绝对值
 * Time Limit: 2000/1000 MS (Java/Others)    Memory Limit: 65536/32768 K (Java/Others)
 * Total Submission(s): 216116    Accepted Submission(s): 104513
 * WA
 * Problem Description
 * 求实数的绝对值。
 * <p>
 * Input
 * 输入数据有多组，每组占一行，每行包含一个实数。
 * Output
 * 对于每组输入数据，输出它的绝对值，要求每组数据输出一行，结果保留两位小数。
 * <p>
 * Sample Input
 * 123
 * -234.00
 * Sample Output
 * 123.00
 * 234.00
 */
class Absolute {
    public static final void trans(Scanner input) {
        while (input.hasNext()) {
            BigDecimal bigDecimal = input.nextBigDecimal();
            if (bigDecimal.compareTo(BigDecimal.ZERO) < 0) {
                bigDecimal = bigDecimal.negate();
            }
            System.out.println(format(bigDecimal, 2));
        }
    }

    public static final String format(double d, int accuracy) {
        return format(new BigDecimal(d), accuracy);
    }

    public static final String format(BigDecimal bigDecimal, int accuracy) {
        String res = bigDecimal.setScale(accuracy, BigDecimal.ROUND_HALF_UP).doubleValue() + "";
        while (res.split("\\.")[1].length() < accuracy) {
            res += "0";
        }
        return res;
    }
}
