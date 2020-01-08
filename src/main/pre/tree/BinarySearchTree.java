package main.pre.tree;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;


public class BinarySearchTree<K,V>implements IBinarySearchTree<K,V> {
    protected Node<K,V> root;
    private int size=0;
    private Comparator comparator;

    public BinarySearchTree() {
        comparator=new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
//                System.out.println(o1.toString()+" "+o2.toString());
                //相等返回0，o1大返回1，否则返回-1
                return o1.equals(o2)?0:Integer.parseInt(o1.toString())<Integer.parseInt(o2.toString())?-1:1;
            }
        };
    }

    public BinarySearchTree(Comparator comparator) {
        this.comparator = comparator;
    }

    @Override
    public Node<K, V> insert(K key) {
        return insert(key,null);
    }

    @Override
    public Node<K, V> insert(K key, V value) {
//        if (!(key instanceof Comparator)){//判断类型可比较    不能正常执行？！
//            throw new ClassCastException();
//        }
        Node<K,V> parent=null;
        Node<K,V> current=root;
        int comp=-1;
        while (current!=null){//current指向插入位置，parent指向父节点
            parent=current;
            comp = compare(key,current.key);
            if (comp<0){//current左下移
                current=current.left;
            }else if (comp>0){//右下移
                current=current.right;
            }else {//更新节点
                current.value=value;
                return current;
            }
        }
        current=new Node<>(key,value,null,null,null);
        current.parent=parent;//上行指针
        if (root==null){//树为空
            root=current;
        }else if (comp>0){//右支
            parent.right=current;
            current.isLeftChild=false;
        }else {//左支
            parent.left=current;
            current.isLeftChild=true;
        }
        current.num=size;
        size++;
        updateHeight(current);//更新节点高度
        return current;
    }

    private void updateHeight(Node<K,V> current) {
        while (current!=root){//根节点不回溯
            if (current.height!=current.parent.height)//父子节点高度不相等，则子节点高度一定小于父节点，祖节点都不更新，否则更新父节点高度
                break;
            current=current.parent;
            current.height++;
        }
    }

    private int compare(K key, K key1) {
        return comparator.compare(key,key1);
    }

    @Override
    public void inorder(Consumer<K> consumer) {
        inorder(root,consumer);
    }
    private void inorder(Node<K,V>p, Consumer<K> consumer) {
        if (p!=null){
            inorder(p.left,consumer);
            consumer.accept(p.key);
            inorder(p.right,consumer);
        }
    }

    @Override
    public V lookupValue(K key) {
        Node<K,V> node=lookupNode(key);
        return node==null?null:node.value;
    }

    protected Node<K,V> lookupNode(K key){
        Node<K,V> p=root;
        while (p!=null&&compare(key,p.key)!=0){//p为空则没有找到，比较key相等则找到结点，返回
            if (compare(key,p.key)>0)//比较key不相等，大于节点则key可能存在于右子树
                p=p.right;
            else//否则可能存在于左子树
                p=p.left;
        }
        return p;
    }

    @Override
    public K min() {
        return minNode().key;
    }
    protected Node<K,V> minNode(){
        return minNode(root);
    }
    protected Node<K,V> minNode(Node<K,V>p){
        while (p.left!=null)
            p=p.left;//二叉树中最左端节点最小
        return p;
    }
    @Override
    public K max() {
        return maxNode().key;
    }
    protected Node<K,V> maxNode(){
        return maxNode(root);
    }
    protected Node<K,V> maxNode(Node<K,V>p){
        while (p.right!=null)
            p=p.right;//最右端节点最大
        return p;
    }

    @Override
    public void remove(K key) {
    }

    @Override
    public K successor(K x) {
        return null;
    }

    @Override
    public K predecessor(K x) {
        return null;
    }

    @Override
    public boolean isBalance() {
        return false;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int getHeight() {
        return getHeight(root);
    }

    @Override
    public int getHeight(Node<K, V> node) {
        return node==null?-1:node.height;
    }

    @Override
    public List<List<Node<K, V>>> levelOrder() {
        return null;
    }

    protected class Node<K,V>{
        public K key;
        public V value;
        public Node<K,V> left;
        public Node<K,V> right;
        public Node<K,V> parent;
        public boolean isLeftChild;
        public int height=0;
        public  int num;

        public Node() {
        }

        public Node(K key, V value, Node<K, V> left, Node<K, V> right, Node<K, V> parent) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }

        public void setLeft() {
            isLeftChild = true;
        }
        public void setRight() {
            isLeftChild = false;
        }

        public boolean isLeft(){
            return root!=null&&root.key!=key&&isLeftChild;
        }
        public boolean isRight(){
            return root!=null&&root.key!=key&&!isLeftChild;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    '}';
        }
    }
}
