package main.pre.tree;

import java.util.List;
import java.util.function.Consumer;

public interface IBinarySearchTree<K,V> {
    /*新增节点*/
    BinarySearchTree<K,V>.Node<K,V> insert(K key,V value);
    BinarySearchTree<K,V>.Node<K,V> insert(K key);
    /*中序遍历*/
    void inorder(Consumer<K> consumer);
    /*查找元素*/
    V lookupValue(K key);
    /*获取最小关键字*/
    K min();
    /*最大关键字*/
    K max();
    /*移除关键字对应节点*/
    void remove(K key);
    /**
     * x的后继比x大的第一个元素
     * 1、是其右子树的最小值
     * 2、没有右子树则向上追溯，直到每个祖先节点是左孩子，返回这个祖先节点的父节点，他就是x的后继
     */
    K successor(K x);
    /*前驱*/
    K predecessor(K x);
    boolean isBalance();
    int getSize();
    int getHeight();
    int getHeight(BinarySearchTree<K,V>.Node<K,V> node);
    List<List<BinarySearchTree<K,V>.Node<K,V>>> levelOrder();
}
