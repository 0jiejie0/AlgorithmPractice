package main.problemAndSolving.lanqiao_20201111Compete_8.pro4;

/**
 * 标题：小计算器
 * <p>
 * 模拟程序型计算器，依次输入指令，可能包含的指令有 1. 数字：'NUM X'，X为一个只包含大写字母和数字的字符串，表示一个当前进制的数 2.
 * 运算指令：'ADD','SUB','MUL','DIV','MOD'，分别表示加减乘，除法取商，除法取余 3. 进制转换指令：'CHANGE
 * K'，将当前进制转换为K进制(2≤K≤36) 4. 输出指令：'EQUAL'，以当前进制输出结果 5. 重置指令：'CLEAR'，清除当前数字
 * <p>
 * 指令按照以下规则给出： 数字，运算指令不会连续给出，进制转换指令，输出指令，重置指令有可能连续给出
 * 运算指令后出现的第一个数字，表示参与运算的数字。且在该运算指令和该数字中间不会出现运算指令和输出指令
 * 重置指令后出现的第一个数字，表示基础值。且在重置指令和第一个数字中间不会出现运算指令和输出指令 进制转换指令可能出现在任何地方
 * 运算过程中中间变量均为非负整数，且小于2^63。 以大写的'A'~'Z'表示10~35
 * <p>
 * [输入格式] 第1行：1个n，表示指令数量 第2..n+1行：每行给出一条指令。指令序列一定以'CLEAR'作为开始，并且满足指令规则 [输出格式]
 * 依次给出每一次'EQUAL'得到的结果
 * <p>
 * [样例输入] 7 CLEAR NUM 1024 CHANGE 2 ADD NUM 100000 CHANGE 8 EQUAL [样例输出] 2040
 * <p>
 * 补充说明： 1. n 值范围: 1<= n < 50000 2. 初始默认的进制是十进制 资源约定： 峰值内存消耗 < 256M CPU消耗 <
 * 1000ms 请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。 所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
 * 注意：不要使用package语句。不要使用jdk1.7及以上版本的特性。 注意：主类的名字必须是：Main，否则按无效代码处理。
 *
 * @author O
 */
public class Main {
    static int k = 10;
    static long num = 0;//最后的因式
    static long sum = 0;//除最后一项所有项的和
    static boolean isInItem = false;//因式结束时（加减操作前）的标记，将该项结果计算到

    private static void clear() {
        k = 10;
        num = 0;
        sum = 0;
    }

    private static void changeK(String k) {
        Main.k = Integer.parseInt(k);
    }

    private static void setN(String nString) {
        num = Integer.parseInt(nString, k);
    }

    public static void main(String[] args) {

    }
}
