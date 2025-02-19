package main.problemAndSolving.nowcoder_20241224.T1简单自动曝光;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

// 给你n个从0-255的数，把每个数加上k,使得整体平均数为128，
// 每个数调整后不会超过0-255,即负数会变成0，大的数再加也还是255，
// 让你求k

// 70%通过率
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        int sumDiff = 0;
        List<Integer> list = new ArrayList<>();
        String[] split = scanner.nextLine().split(" ");
        count = split.length;
        for (int i = 0; i < count; i++) {
            list.add(Integer.parseInt(split[i]));
        }
        sumDiff = dealAvg(list, 0)[0];
        list.sort(Comparator.comparingInt(a -> a));
        int diff = sumDiff / count;
        Thread hello = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        });
        hello.start();// start 是怎么启动线程的，入口在哪里？
        int[] a = dealAvg(list, diff);
        sumDiff = a[0];
        int c = count - a[1];
        while ((Math.abs(sumDiff)) > (c >> 1)) {
            if (sumDiff > 0) {
                diff++;
            } else {
                diff--;
            }
            a = dealAvg(list, diff);
            sumDiff = a[0];
            c = count - a[1];
        }
        System.out.println(diff);
    }

    private static int[] dealAvg(List<Integer> list, int diff) {
        int[] sum = new int[2];
        for (int i = 0; i < list.size(); i++) {
            int t = diff + list.get(i);
//            sum[0] += (128 - (t < 0 ? 0 : Math.min(t, 255)));
            if (t <= 0 || t >= 255) {
                sum[0] += t <= 0 ? 128 : 127;
                sum[1]++;
            } else {
                sum[0] += 128 - t;
            }
        }
        return sum;
    }
}
