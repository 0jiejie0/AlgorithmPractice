package main.pre.tree;

import java.util.List;

public interface ITree<E> {
    int getSize();//节点数
    TreeNode<E> getRoot();//根
    TreeNode<E> getParent(TreeNode<E> x);//获得父节点
    TreeNode<E> getFirstChild(TreeNode<E> x);//获得子节点
    TreeNode<E> getNextSibiling(TreeNode<E> x);//兄弟节点
    int getHeight(TreeNode<E>x);//传入节点的高度
    void incertChild(TreeNode<E>x,TreeNode<E>child);//插入节点
    void deleteChild(TreeNode<E>x,int i);//删除节点
    List<TreeNode<E>> preOrder(TreeNode<E>x);//前序遍历
    List<TreeNode<E>> postOrder(TreeNode<E>x);//后序遍历
    List<List<TreeNode<E>>> levelOrder(TreeNode<E>x);//中序(中根)遍历
    List<List<TreeNode<E>>> levelOrder();
}
