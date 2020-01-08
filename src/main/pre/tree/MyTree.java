package main.pre.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MyTree<E>implements ITree<E> {
    private int size;
    private TreeNode<E> root;

    public MyTree(TreeNode<E> root) {
        this.root = root;
        size=1;
    }

    public MyTree() {
        size=0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public TreeNode<E> getRoot() {
        return root;
    }

    @Override
    public TreeNode<E> getParent(TreeNode<E> x) {
        return x.parent;
    }

    @Override
    public TreeNode<E> getFirstChild(TreeNode<E> x) {
        return x.children.get(0);
    }
    /*获得兄弟节点*/
    @Override
    public TreeNode<E> getNextSibiling(TreeNode<E> x) {
        if (x==root)
            return null;
        List<TreeNode<E>> children=x.parent.children;//拿到子节点们
        int index=children.indexOf(x)+1;//拿到当前节点在列表中的位置，赠一得到下一位置
        if (index==children.size())//判断下标越界，返回空指针
            return null;
        return children.get(index);//返回下一个节点
    }
    /*得到传入节点高度*/
    @Override
    public int getHeight(TreeNode<E> x) {
        int h=0;
        if (x.children!=null){//传入节点有子节点
            for (int i = 0; i < x.children.size(); i++) {//遍历子节点最高高度
                int ch=getHeight(x.children.get(i))+1;
                if (h<ch)//h依次与每个子节点高度+1比较，取最大值更新
                    h=ch;
            }
        }
        return h;
    }
    /*插入子节点*/
    @Override
    public void incertChild(TreeNode<E> x, TreeNode<E> child) {
        if (x.children==null){//当x没有子节点，分配内存
            x.children=new ArrayList<>();
        }
        child.parent=x;//维护上行指针
        x.children.add(child);//增加节点
        size++;
    }
    /*删除节点*/
    @Override
    public void deleteChild(TreeNode<E> x, int i) {
//        int n=getHeight(x.children.get(i));//错误！！！只是得到最高子节点的节点高度数，并未得到所有子孙节点数量
//        if (x.children.size()>i&&i>=0){
//            x.children.remove(i);
//            size-=n;
//        }
        if (x.children!=null&&x.children.size()>i&&i>=0){//x存在子节点，i不越界
            TreeNode<E> child=x.children.get(i);//子节点
            if (child.children!=null){//若存在孙子节点
                while (child.children.size()>0) {//遍历孙子节点,永远从第一个孙子节点清空！！！
                    deleteChild(child,0);//清空孙子节点，此时子节点高度为0
                }
            }
            child.parent=null;//每删除一个节点都将其所有子孙结点解除父子节点间联系
            x.children.remove(i);
            size--;//递归维护size，删除高度为零的节点时size-1
        }
    }

    @Override
    public List<TreeNode<E>> preOrder(TreeNode<E> x) {
        return null;
    }

    @Override
    public List<TreeNode<E>> postOrder(TreeNode<E> x) {
        return null;
    }

    @Override
    public List<List<TreeNode<E>>> levelOrder(TreeNode<E> x) {
        List<List<TreeNode<E>>> res=new ArrayList<>();//list的list
        List<TreeNode<E>> line=new ArrayList<>();//一行的list
        res.add(line);
        Queue<TreeNode<E>> q=new LinkedList<>();
        TreeNode<E> last=x;//上一行最末节点
        TreeNode<E> next=null;//本行最末节点，即最新节点
        q.add(x);//初始化
        while (!q.isEmpty()){
            TreeNode<E> peek=q.peek();
            if (peek.children!=null){//即将出队节点的子节点依次进入对列
                for (TreeNode<E> node : peek.children) {
                    next = node;//最新节点
                    q.add(node);//进队
                }
            }
            line.add(q.poll());//出队
            if (peek==last&&!q.isEmpty()){//上一行最后结点标记被弹出，移动标记，新增一行列表
                last=next;
                line=new ArrayList<>();
                res.add(line);
            }
        }
        return res;
    }

    @Override
    public List<List<TreeNode<E>>> levelOrder() {
        return levelOrder(root);
    }
}