package main.problemAndSolving.lanqiao_20201109Compete_9.pro2;

import java.util.HashSet;
import java.util.Set;

public class Main {

    /**
     * 标题：最大乘积
     * <p>
     * 把 1~9 这9个数字分成两组，中间插入乘号， 有的时候，它们的乘积也只包含1~9这9个数字，而且每个数字只出现1次。 比如： 984672 *
     * 351 = 345619872 98751 * 3462 = 341875962 9 * 87146325 = 784316925 ...
     * <p>
     * 符合这种规律的算式还有很多，请你计算在所有这些算式中，乘积最大是多少？ 注意，需要提交的是一个整数，表示那个最大的积，不要填写任何多余的内容。
     * （只提交乘积，不要提交整个算式）
     *
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        StringBuilder stringBuilder = new StringBuilder();
        long res = 0;
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 1; i < 10; i++) {// 1
            set.add(i);
            stringBuilder.append(i);
            for (int j = 1; j < 10; j++) {// 2
                if (set.contains(j)) {
                    continue;
                }
                set.add(j);
                stringBuilder.append(j);
                for (int j2 = 1; j2 < 10; j2++) {// 3
                    if (set.contains(j2)) {
                        continue;
                    }
                    set.add(j2);
                    stringBuilder.append(j2);
                    for (int k = 1; k < 10; k++) {// 4
                        if (set.contains(k)) {
                            continue;
                        }
                        set.add(k);
                        stringBuilder.append(k);
                        for (int k2 = 1; k2 < 10; k2++) {// 5
                            if (set.contains(k2)) {
                                continue;
                            }
                            set.add(k2);
                            stringBuilder.append(k2);
                            for (int l = 1; l < 10; l++) {// 6
                                if (set.contains(l)) {
                                    continue;
                                }
                                set.add(l);
                                stringBuilder.append(l);
                                for (int l2 = 1; l2 < 10; l2++) {// 7
                                    if (set.contains(l2)) {
                                        continue;
                                    }
                                    set.add(l2);
                                    stringBuilder.append(l2);
                                    for (int m = 1; m < 10; m++) {// 8
                                        if (set.contains(m)) {
                                            continue;
                                        }
                                        set.add(m);
                                        stringBuilder.append(m);
                                        for (int n = 1; n < 10; n++) {// 9
                                            if (set.contains(n)) {
                                                continue;
                                            }
                                            set.add(n);
                                            stringBuilder.append(n);
                                            long temp = figure(stringBuilder
                                                    .toString());
                                            if (temp > 0) {
                                                System.out.println(temp + ":"
                                                        + stringBuilder
                                                        .toString());
                                            }
                                            if (temp > res) {
                                                res = temp;
                                            }
                                            stringBuilder.deleteCharAt(8);
                                            set.remove(n);
                                        }
                                        stringBuilder.deleteCharAt(7);
                                        set.remove(m);
                                    }
                                    stringBuilder.deleteCharAt(6);
                                    set.remove(l2);
                                }
                                stringBuilder.deleteCharAt(5);
                                set.remove(l);
                            }
                            stringBuilder.deleteCharAt(4);
                            set.remove(k2);
                        }
                        stringBuilder.deleteCharAt(3);
                        set.remove(k);
                    }
                    stringBuilder.deleteCharAt(2);
                    set.remove(j2);
                }
                stringBuilder.deleteCharAt(1);
                set.remove(j);
            }
            stringBuilder.deleteCharAt(0);
            set.remove(i);
        }
        System.out.println(res);//839542176
    }

    /**
     * 从一定的排列组合中插入乘号，计算符合条件的极大结果并返回
     *
     * @param stringBuilder
     * @return
     */
    private static long figure(String string) {
        long res = 0, tempRes = 0, temp = 0;
        int a, b;
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 1; i < 9; i++) {
            // 根据乘号位置分割字符串并计算
            a = Integer.parseInt(string.substring(0, i));
            b = Integer.parseInt(string.substring(i, 9));
            tempRes = ((long) a) * b;
            // 检查合法性（1-9）均出现一次
            // 初始化set
            for (int j = 1; j < 10; j++) {
                set.add(j);
            }
            // 将数字逐位拆解，从set中移除，出现两次的数字不符合条件（或数字过长，应该不会出现）
            temp = tempRes;
            while (temp > 0) {
                if (set.contains((int) temp % 10)) {
                    set.remove((int) temp % 10);
                } else {
                    set.add(1);// 为防止过长时已排完全部数字，故此在set中添加一项防止后续出错
                    break;
                }
                temp /= 10;
            }
            // 检查set中所有数字是否全部移除，若否证明数字乘积短，不合条件
            if (!set.isEmpty()) {
                set.clear();
                continue;
            }
            if (tempRes > res) {// 记录极大值
                res = tempRes;
            }
        }
        return res;
    }
}
