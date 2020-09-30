package main.algo._01BitOperation;

public class _0107二进制表示浮点实数 {
    public static final String toBit(double num) {
        StringBuilder stringBuilder = new StringBuilder("0.");
        while (num > 0) {
            //乘二，挪整
            num *= 2;
            //判断整数部分
            if (1 <= num) {
                stringBuilder.append(1);
                //消掉整数部分
                num--;
            } else {
                stringBuilder.append(0);
            }

            if (stringBuilder.length() > 34) {
                return "ERROR";//异常情况的处理不能忘记！！
            }
        }
        return stringBuilder.toString();
    }
}
