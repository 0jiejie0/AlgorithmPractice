package main.problemAndSolving.nowcoder.HUAWEIod.HJ17坐标移动;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String[] opts = in.nextLine().split(";");
        int x = 0, y = 0;
        for (String opt : opts) {
            if ("".equals(opt) || opt.length() > 3) {
                continue;
            }
            int step = 0;
            for (int i = 1; i < opt.length(); i++) {
                int tmp = opt.charAt(i) - '0';
                if (tmp < 0 || tmp > 9) {
                    step = 0;
                    break;
                }
                step *= 10;
                step += tmp;
            }
            switch (opt.charAt(0)) {
                case 'A':
                    x -= step;
                    break;
                case 'S':
                    y -= step;
                    break;
                case 'D':
                    x += step;
                    break;
                case 'W':
                    y += step;
                    break;
            }
        }
        System.out.println(x + "," + y);
    }
}
