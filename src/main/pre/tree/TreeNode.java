package main.pre.tree;

import java.util.List;

public class TreeNode<E> {
    public E key;//data
    public TreeNode<E> parent;
    public List<TreeNode<E>> children;

    public TreeNode(E key, TreeNode<E> parent) {
        this.key = key;
        this.parent = parent;
    }

    public TreeNode(E key) {
        this.key = key;
    }
    public TreeNode<E> child(int i){
        if (children==null)
            return null;
        return children.get(i);
    }
    @Override
    public String toString() {
        return key.toString();
    }
}
