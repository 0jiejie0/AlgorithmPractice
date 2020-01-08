package main.hihoCoder20191120;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {//保证输入结束时正常退出（防止）
            System.out.println(AddAAndB.inputAndAdd(scanner));
        }
    }
}

class AddAAndB {
    public static int inputAndAdd(Scanner input) {
        return input.nextInt() + input.nextInt();
    }
}

//
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        try {
//            while (true) {
////                String s = scanner.nextLine();
////                System.out.println(AddAAndB.inputAndAdd(s.split(" ")[0], s.split(" ")[1]));
//                System.out.println(AddAAndB.inputAndAdd(scanner.nextInt(), scanner.nextInt()));
//            }
//        } catch (Exception e) {
//        }
//    }
//}
//
//class AddAAndB {
//    public static int inputAndAdd(int a, int b) {
//        return a + b;
//    }
//}
