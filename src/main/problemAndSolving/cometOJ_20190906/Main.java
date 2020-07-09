package main.problemAndSolving.cometOJ_20190906;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new TCJumpDoor().main();
//        BigInteger a=new BigInteger("1024");
//        BigInteger b=BigInteger.ZERO;
//        System.out.println(a);
//        for (int i = 0; i < a.bitLength(); i++) {
//            if (!a.or(BigInteger.ONE.shiftLeft(i)).equals(BigInteger.ZERO)){
//                b=
//            }
//        }
    }
}

class TCJumpDoor {
    public void main() {
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        input.nextLine();
        for (int i = 0; i < m; i++) {
            System.out.println(getX(new BigInteger(input.nextLine())));
        }
    }

    private BigInteger getX(BigInteger n) {
        for (BigInteger k = BigInteger.ONE; ; k = k.add(BigInteger.ONE)) {
            BigInteger kn = k.multiply(n);
            BigInteger x = kn.shiftLeft(3).add(BigInteger.ONE).sqrt()
                    .add(BigInteger.ONE.negate()).shiftRight(1);
//            for (BigInteger x =kn.shiftRight(kn.bitLength()>>1); ; x = x.add(BigInteger.ONE)) {
            BigInteger s = x.multiply(x.add(BigInteger.ONE));
//            System.out.println(k + "===" + x);
            if (s.equals(kn.shiftLeft(1))) {
                return x;
            } else continue;
//                if (s.divide(kn).equals(BigInteger.ONE)) {
//                    if (s.equals(kn)) {
//                        return x;
//                    } else break;
////                    if (kn.divide(s).equals(BigInteger.ONE)) {
////                        return x;
////                    } else {
////                        break;
////                    }
//                }
//            }
        }
    }
}

class TAMulti {
    public void sum() {
        Scanner input = new Scanner(System.in);
        int res = 0;
        int n = input.nextInt();
        input.nextLine();
        for (int i = 0; i < n; i++) {
            res += is(input.nextLine());
        }
        System.out.println(res);
    }

    private int is(String s) {
        if (s.endsWith("acpty")) {
            return 1;
        }
        return 0;
    }
}
