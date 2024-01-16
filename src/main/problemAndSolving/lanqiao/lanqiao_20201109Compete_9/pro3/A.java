package main.problemAndSolving.lanqiao.lanqiao_20201109Compete_9.pro3;

/**
 * 标题：全排列
 * <p>
 * 对于某个串，比如：“1234”，求它的所有全排列。 并且要求这些全排列一定要按照字母的升序排列。 对于“1234”，应该输出(一共4!=24行)：
 * 1234 1243 1324 1342 1423 1432 2134 2143 2314 2341 2413 2431 3124 3142 3214
 * 3241 3412 3421 4123 4132 4213 4231 4312 4321
 * <p>
 * 下面是实现程序，请仔细分析程序逻辑，并填写划线部分缺少的代码。 请注意：只需要填写划线部分缺少的内容，不要抄写已有的代码或符号。
 *
 * @author O
 */
public class A {
    // 轮换前k个，再递归处理
    static void permu(char[] data, int cur) {// permu(x.toCharArray(), 0);
        if (cur == data.length - 1) {// 没有可调长度，输出字符串
            System.out.println(new String(data));
            return;
        }
        // cur<data.length-1时，
        for (int i = cur; i < data.length; i++) {// cur --> data.length-1
            // 轮换cur~i的字符
            char tmp = data[i];
            for (int j = i - 1; j >= cur; j--)
                // cur <-- i-1
                data[j + 1] = data[j];
            data[cur] = tmp;
            //
            permu(data, cur + 1);
            //
            tmp = data[cur];
            //虽然这里猜对了，但是原理并不是很清楚
            for (int j = cur + 1; j <= i; j++)
                data[j - 1] = data[j];
            // __________________________________________ ;
            data[i] = tmp;
        }
    }

    static void permu(String x) {// permu("1234");
        permu(x.toCharArray(), 0);
    }

    public static void main(String[] args) {
        permu("1234");
    }
}