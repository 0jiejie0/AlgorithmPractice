package main.problemAndSolving.leetcode_20200927WeekRankList;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

//ThroneInheritance
//一个王国里住着国王、他的孩子们、他的孙子们等等。每一个时间点，这个家庭里有人出生也有人死亡。
//
//这个王国有一个明确规定的皇位继承顺序，第一继承人总是国王自己。我们定义递归函数 Successor(x, curOrder) ，给定一个人 x 和当前的继承顺序，该函数返回 x 的下一继承人。
//
//Successor(x, curOrder):
//    如果 x 没有孩子或者所有 x 的孩子都在 curOrder 中：
//        如果 x 是国王，那么返回 null
//        否则，返回 Successor(x 的父亲, curOrder)
//    否则，返回 x 不在 curOrder 中最年长的孩子
//比方说，假设王国由国王，他的孩子 Alice 和 Bob （Alice 比 Bob 年长）和 Alice 的孩子 Jack 组成。
//
//一开始， curOrder 为 ["king"].
//调用 Successor(king, curOrder) ，返回 Alice ，所以我们将 Alice 放入 curOrder 中，得到 ["king", "Alice"] 。
//调用 Successor(Alice, curOrder) ，返回 Jack ，所以我们将 Jack 放入 curOrder 中，得到 ["king", "Alice", "Jack"] 。
//调用 Successor(Jack, curOrder) ，返回 Bob ，所以我们将 Bob 放入 curOrder 中，得到 ["king", "Alice", "Jack", "Bob"] 。
//调用 Successor(Bob, curOrder) ，返回 null 。最终得到继承顺序为 ["king", "Alice", "Jack", "Bob"] 。
//通过以上的函数，我们总是能得到一个唯一的继承顺序。
//
//请你实现 ThroneInheritance 类：
//
//ThroneInheritance(string kingName) 初始化一个 ThroneInheritance 类的对象。国王的名字作为构造函数的参数传入。
//void birth(string parentName, string childName) 表示 parentName 新拥有了一个名为 childName 的孩子。
//void death(string name) 表示名为 name 的人死亡。一个人的死亡不会影响 Successor 函数，也不会影响当前的继承顺序。你可以只将这个人标记为死亡状态。
//string[] getInheritanceOrder() 返回 除去 死亡人员的当前继承顺序列表。
//
//
//示例：
//
//输入：
//["ThroneInheritance", "birth", "birth", "birth", "birth", "birth", "birth", "getInheritanceOrder", "death", "getInheritanceOrder"]
//[["king"], ["king", "andy"], ["king", "bob"], ["king", "catherine"], ["andy", "matthew"], ["bob", "alex"], ["bob", "asha"], [null], ["bob"], [null]]
//输出：
//[null, null, null, null, null, null, null, ["king", "andy", "matthew", "bob", "alex", "asha", "catherine"], null, ["king", "andy", "matthew", "alex", "asha", "catherine"]]
//
//解释：
//ThroneInheritance t= new ThroneInheritance("king"); // 继承顺序：king
//t.birth("king", "andy"); // 继承顺序：king > andy
//t.birth("king", "bob"); // 继承顺序：king > andy > bob
//t.birth("king", "catherine"); // 继承顺序：king > andy > bob > catherine
//t.birth("andy", "matthew"); // 继承顺序：king > andy > matthew > bob > catherine
//t.birth("bob", "alex"); // 继承顺序：king > andy > matthew > bob > alex > catherine
//t.birth("bob", "asha"); // 继承顺序：king > andy > matthew > bob > alex > asha > catherine
//t.getInheritanceOrder(); // 返回 ["king", "andy", "matthew", "bob", "alex", "asha", "catherine"]
//t.death("bob"); // 继承顺序：king > andy > matthew > bob（已经去世）> alex > asha > catherine
//t.getInheritanceOrder(); // 返回 ["king", "andy", "matthew", "alex", "asha", "catherine"]
//
//
//提示：
//
//1 <= kingName.length, parentName.length, childName.length, name.length <= 15
//kingName，parentName， childName 和 name 仅包含小写英文字母。
//所有的参数 childName 和 kingName 互不相同。
//所有 death 函数中的死亡名字 name 要么是国王，要么是已经出生了的人员名字。
//每次调用 birth(parentName, childName) 时，测试用例都保证 parentName 对应的人员是活着的。
//最多调用 105 次birth 和 death 。
//最多调用 10 次 getInheritanceOrder
public class ThroneInheritance {
    //这是一个简单的多叉树遍历问题，由于问题规模比较小，可以采用hashmap映射提高查找结点的效率
    String parent;
    boolean parentIsDeath;
    List<ThroneInheritance> childs;//多叉树，仅在输出继承顺序时起作用
    public static HashMap<String, ThroneInheritance> placeOfParent = new HashMap<>();//每个结点，用hashmap做映射，加速标记出生孩子和死亡

    public ThroneInheritance(String kingName) {
        childs = new LinkedList<>();
        parent = kingName;
        placeOfParent.put(parent, this);//将当前节点加入映射
    }

    public void birth(String parentName, String childName) {
        //在parent结点的 子节点列表中添加一个 新建结点
        placeOfParent.get(parentName).childs.add(new ThroneInheritance(childName));
    }

    public void death(String name) {
        placeOfParent.get(name).parentIsDeath = true;
    }

    public List<String> getInheritanceOrder() {
        //利用栈和递推似乎是不可行的，极端情况下如果国王有10万个孩子，最后几次审查继承顺序的时间是不可忍受的（查找兄弟节点的累计时间耗费高）
        List<String> res = new LinkedList<>();
//        Stack<ThroneInheritance> stack = new Stack<>();
//        stack.push(this);
//        ThroneInheritance p;
//        while (!stack.isEmpty()) {
//            p=stack.peek();
//            if (p.childs.size()==0){
//
//            }
//        }
        this.getCustomOrder(res);
        return res;
    }

    public void getCustomOrder(List<String> order) {
        if (!this.parentIsDeath) {
            order.add(this.parent);
        }
        for (ThroneInheritance child : childs) {
            child.getCustomOrder(order);
        }
    }
}
