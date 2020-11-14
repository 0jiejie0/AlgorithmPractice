package main.problemAndSolving.lanqiao_20201109Compete_9.pro5;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    /**
     * 标题：版本分支 小明负责维护公司一个奇怪的项目。这个项目的代码一直在不断分支(branch)但是从未发生过合并(merge)。
     * 现在这个项目的代码一共有N个版本，编号1~N，其中1号版本是最初的版本。
     * 除了1号版本之外，其他版本的代码都恰好有一个直接的父版本；即这N个版本形成了一棵以1为根的树形结构。
     * <p>
     * 如下图就是一个可能的版本树： 1 / \ 2 3 | / \ 5 4 6 现在小明需要经常检查版本x是不是版本y的祖先版本。你能帮助小明吗？ 输入
     * ---- 第一行包含两个整数N和Q，代表版本总数和查询总数。 以下N-1行，每行包含2个整数u和v，代表版本u是版本v的直接父版本。
     * 再之后Q行，每行包含2个整数x和y，代表询问版本x是不是版本y的祖先版本。 对于30%的数据，1 <= N <= 1000 1 <= Q <=
     * 1000 对于100%的数据，1 <= N <= 100000 1 <= Q <= 100000 输出 ----
     * 对于每个询问，输出YES或NO代表x是否是y的祖先。
     * <p>
     * 【样例输入】 6 5 1 2 1 3 2 5 3 6 3 4 1 1 1 4 2 6 5 2 6 4 【样例输出】 YES YES NO NO
     * NO
     * <p>
     * 资源约定： 峰值内存消耗（含虚拟机） < 256M CPU消耗 < 1000ms 请严格按要求输出，不要画蛇添足地打印类似：“请您输入...”
     * 的多余内容。 所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。 不要使用package语句。不要使用jdk1.7及以上版本的特性。
     * 主类的名字必须是：Main，否则按无效代码处理。
     *
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner inputScanner = new Scanner(System.in);
        int n = inputScanner.nextInt();
        int q = inputScanner.nextInt();
        int temp;
        for (int i = 1; i < n; i++) {// 构建
            temp = inputScanner.nextInt();
            new TreeNode(inputScanner.nextInt()).parentIs(temp);
        }
        // 查询请求
        for (int i = 0; i < q; i++) {
            temp = inputScanner.nextInt();
            TreeNode node = map.get(inputScanner.nextInt());
            if (node != null && node.confirmParent(temp)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    static HashMap<Integer, TreeNode> map = new HashMap<Integer, TreeNode>();// 用以寻找节点
}

class TreeNode {
    int data;
    TreeNode parent;

    public void parentIs(int parentData) {
        this.parent = Main.map.get(parentData);
        if (this.parent == null) {
            this.parent = new TreeNode(parentData);
            Main.map.put(parentData, this.parent);
        }
    }

    public TreeNode(int data) {
        // TODO Auto-generated constructor stub
        this.data = data;
        Main.map.put(data, this);
    }

    public boolean confirmParent(int parentData) {
        return this.data == parentData
                || (parent != null && parent.confirmParent(parentData));
    }
}
