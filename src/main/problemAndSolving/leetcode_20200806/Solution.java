package main.problemAndSolving.leetcode_20200806;
//给定两个二叉树，编写一个函数来检验它们是否相同。
//
// 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
//
// 示例 1:
//
// 输入:       1         1
//          / \       / \
//         2   3     2   3
//
//        [1,2,3],   [1,2,3]
//
//输出: true
//
// 示例 2:
//
// 输入:      1          1
//          /           \
//         2             2
//
//        [1,2],     [1,null,2]
//
//输出: false
//
//
// 示例 3:
//
// 输入:       1         1
//          / \       / \
//         2   1     1   2
//
//        [1,2,1],   [1,1,2]
//
//输出: false
//
// Related Topics 树 深度优先搜索
//本来想做两道题，看来是不行了，
// 虽然标签提示用深搜，但是我想用宽搜用队列绕开递归，但是提交运行时报类型转换异常，看样子进队元素需要是Comparable子类
//java.lang.ClassCastException: class TreeNode cannot be cast to class java.lang.Comparable (TreeNode is in unnamed module of loader 'app'; java.lang.Comparable is in module java.base of loader 'bootstrap')
//###这里是因为使用了优先级队列PriorityQueue，这种队列要求入队元素满足一定可比要求（至少是Comparable子类对象），换用Linklist解决问题
//换到栈改用深搜，想尝试递推解决深搜问题，考虑到最后发现需要处理的情况很多，尤其是所有结点的值相同的情况，条件复杂，简单分析发现此法不如递归简洁高效，
// 最后改用递归解决
// 用时88m
//执行耗时:0 ms,击败了100.00% 的Java用户
//		内存消耗:37.1 MB,击败了79.25% 的Java用户

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return judgeUseQueue(p, q);
    }

    private boolean judgeUseStack(TreeNode p, TreeNode q) {
        if (p != null && q != null) {//pq均不为null，且值不相等时为不同树
            if (p.val != q.val) {
                return false;
            }
        } else if (p == q) {//pq均为null
            return true;
        } else {//pq有一个为null，不同树
            return false;
        }
        return judgeUseStack(p.left, q.left) & judgeUseStack(p.right, q.right);
    }

    /**
     * 原来的队列对象创建有问题，修改后可以实现
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:37.2 MB,击败了52.72% 的Java用户
     *
     * @param p
     * @param q
     * @return
     */
    private boolean judgeUseQueue(TreeNode p, TreeNode q) {
        Queue<TreeNode> l = new LinkedList<>();
        Queue<TreeNode> r = new LinkedList<>();
        while (p != null && q != null) {
            if (p.val != q.val) {//结点值不同，为不同树
                return false;
            }
            if (p.left != null && q.left != null) {//两个结点均有左子，入队
                l.add(p.left);
                r.add(q.left);
            } else if (p.left != q.left) {//只有一个结点有左子，为不同树
                return false;
            }
            if (p.right != null && q.right != null) {
                l.add(p.right);
                r.add(q.right);
            } else if (p.right != q.right) {
                return false;
            }
            p = l.poll();
            q = r.poll();
        }
        return p == q;
    }
}
