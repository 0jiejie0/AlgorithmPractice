package main.problemAndSolving.nowcoder_20241224.T3跳格子2;

import java.util.*;

// 给你一排首尾相连的非负数，
// 从中取一部分数，但是不能取相邻的两个数，
// 求取出的最大和

// 通过率63.3%
public class Main {
    private static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int last = 0;
        ArrayList<Integer> list = new ArrayList<>();
        last = scanner.nextInt();
        while (scanner.hasNextInt()) {
            list.add(last);
            last = scanner.nextInt();
        }
        System.out.println(search(list, 0));
    }

    private static int search(List<Integer> list, int index) {
        int max = 0;
        if (map.containsKey(index)) {
            return map.get(index);
        }
        if (index < list.size()) {
            max = list.get(index) + search(list, index + 2);
            if (index < list.size() - 1) {
                int t = list.get(index + 1) + search(list, index + 3);
                map.put(index, Math.max(t, max));
                return map.get(index);
            }
        }
        return max;
    }
}
