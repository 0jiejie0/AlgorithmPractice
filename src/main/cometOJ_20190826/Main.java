package main.cometOJ_20190826;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UnknownMotherGoose.main(args);
    }
}

class UnknownMotherGoose {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] strings = input.nextLine().split(" ");
        BigInteger n = new BigInteger(strings[0]);
        System.out.println(num(n, toBigList(input.nextLine())));
    }

    private static List<BigInteger> toBigList(String s) {
        List<BigInteger> result = new LinkedList<>();
        String[] ss = s.split(" ");
        for (String str : ss) {
            result.add(new BigInteger(str));
        }
        return result;
    }

    private static BigInteger num(BigInteger n, List<BigInteger> s) {
        BigInteger result = new BigInteger("0");
        for (BigInteger b : s) {
            result.add(div(n, b.add(new BigInteger("2"))));
        }
        return result;
    }

    private static BigInteger div(BigInteger n, BigInteger s) {
        if (n.compareTo(s) == 0) {
            return new BigInteger("1");
        } else if (n.compareTo(s) < 0 && n.compareTo(s.add(new BigInteger("-3"))) > 0) {
            return div(n, s.add(new BigInteger("-1")));
        }
        return n.divide(s);
    }
}

class SumOfList {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println(add(new BigInteger(input.nextInt() + ""), new BigInteger(input.nextInt() + ""), new BigInteger(input.nextInt() + "")));
    }

    private static BigInteger add(BigInteger first, BigInteger second, BigInteger n) {
        BigInteger d = second.add(first.negate());
        BigInteger result = n.multiply(first.multiply(new BigInteger("2")).add(d.multiply(n.add(new BigInteger("-1"))))).divide(new BigInteger("2"));
        return result;
    }
}
