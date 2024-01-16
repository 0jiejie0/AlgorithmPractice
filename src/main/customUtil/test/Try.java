package main.customUtil.test;

import java.util.LinkedList;
import java.util.List;

public class Try {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
        lowerEqualUpper();
    }

    public static void testSplit() {
        System.out.println("".split(""));
    }

    public static  void lowerEqualUpper() {
        System.out.println("asd".equalsIgnoreCase("asD"));
        System.out.println("asd".equals("asD"));
    }

    private static List tryCatch() {
        List<Integer> list = new LinkedList<>();
        try {
            list.add(1);
            System.out.println("try:" + list);
            return list;
        } catch (Exception e) {
            list.add(2);
            System.out.println("catch:" + list);
        } finally {
            list.add(3);
            System.out.println("final:" + list);
        }
        return list;
    }
}
