package main.problemAndSolving.lanqiao_20201109Compete_9.pro1;

public class Main {

    /**
     * 标题：三角形面积
     * <p>
     * 已知三角形三个顶点在直角坐标系下的坐标分别为： (2.3, 2.5) (6.4, 3.1) (5.1, 7.2) 求该三角形的面积。
     * 注意，要提交的是一个小数形式表示的浮点数。 要求精确到小数后3位，如不足3位，需要补零。
     *
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        double xa = 2.3, ya = 2.5, xb = 6.4, yb = 3.1, xc = 5.1, yc = 7.2;
        double a = (xb - xa);
        double b = (yc - ya);
        double aa = xc - xa;
        double ab = xb - xc;
        double ba = yb - ya;
        double bb = yc - yb;
        System.out.println(String.format("%.3f", (a * b - (b * aa + a * ba + ab * bb) / 2)));//8.795

    }
}
