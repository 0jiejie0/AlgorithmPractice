package main.pre.tree;

import junit.framework.TestCase;

import java.util.List;

public class MyTreeTest extends TestCase {
    MyTree<String> tree=new MyTree<>(new TreeNode("a"));

    public void setUp() throws Exception {
        testIncertChild();
    }

    public void testIncertChild() {
        TreeNode<String>root =tree.getRoot();
        TreeNode<String>b=new TreeNode<>("b");
        tree.incertChild(root,b);
        TreeNode<String>c=new TreeNode<>("c");
        tree.incertChild(root,c);
        TreeNode<String>d=new TreeNode<>("d");
        tree.incertChild(root,d);

        TreeNode<String>e=new TreeNode<>("e");
        tree.incertChild(b,e);
        TreeNode<String>f=new TreeNode<>("f");
        tree.incertChild(b,f);

        TreeNode<String>g=new TreeNode<>("g");
        tree.incertChild(c,g);
        TreeNode<String>h=new TreeNode<>("h");
        tree.incertChild(d,h);
        TreeNode<String>i=new TreeNode<>("i");
        tree.incertChild(e,i);
        TreeNode<String>j=new TreeNode<>("j");
        tree.incertChild(i,j);
        tree.incertChild(c,new TreeNode<>("k"));
    }

    public void testGetsize() {
        assertEquals(11,tree.getSize());
    }

    public void testGetRoot() {
        assertEquals(tree.getRoot().key,"a");
    }

    public void testGetParent() {
        assertEquals(tree.getRoot().parent,null);
        assertEquals(tree.getRoot().children.get(0).key,"b");
        assertEquals(tree.getRoot().children.get(1).key,"c");
        assertEquals(tree.getRoot().children.get(0).children.get(0).children.get(0).key,"i");
        assertEquals(tree.getRoot().children.get(0).children.get(0).children.get(0).children.get(0).key,"j");
        assertEquals(tree.getRoot().children.get(1).children.get(1).key,"k");
        assertEquals(tree.getRoot().children.get(2).children.get(0).key,"h");
        assertEquals(tree.getRoot().children.get(1).parent.key,"a");
    }

    public void testGetFirstChild() {
        assertEquals(tree.getFirstChild(tree.getRoot()).key,"b");
        assertEquals(tree.getFirstChild(tree.getRoot().children.get(0)).key,"e");
        assertEquals(tree.getFirstChild(tree.getRoot().children.get(0).children.get(0).children.get(0)).key,"j");
        assertEquals(tree.getFirstChild(tree.getRoot().children.get(1)).key,"g");
    }

    public void testGetNextSibiling() {
        assertEquals(tree.getNextSibiling(tree.getRoot()),null);
        assertEquals(tree.getNextSibiling(tree.getRoot().children.get(0)).toString(),"c");
        assertEquals(tree.getNextSibiling(tree.getRoot().children.get(2)),null);
        assertEquals(tree.getNextSibiling(tree.getRoot().children.get(0).children.get(0)).toString(),"f");
        assertEquals(tree.getNextSibiling(tree.getRoot().children.get(0).children.get(0).children.get(0)),null);
    }

    public void testGetHeight() {
        assertEquals(tree.getHeight(tree.getRoot()),4);
    }

    public void testDeleteChild() {
//        main.pre.tree.deleteChild(main.pre.tree.getRoot(),0);
//        assertEquals(main.pre.tree.getHeight(main.pre.tree.getRoot()),2);
//        assertEquals(main.pre.tree.getSize(),6);

//        main.pre.tree.deleteChild(main.pre.tree.getRoot(),1);
//        assertEquals(main.pre.tree.getHeight(main.pre.tree.getRoot()),4);
//        assertEquals(main.pre.tree.getSize(),8);

        tree.deleteChild(tree.getRoot(),2);
        assertEquals(tree.getHeight(tree.getRoot()),4);
        assertEquals(tree.getSize(),9);
        tree.deleteChild(tree.getRoot(),0);
        assertEquals(tree.getHeight(tree.getRoot()),2);
        assertEquals(tree.getSize(),4);


    }

    public void testPreOrder() {
    }

    public void testPostOrder() {
    }

    public void testLevelOrder() {
    }

    public void testLevelOrder1() {
        tree.incertChild(tree.getRoot().child(0).child(1),new TreeNode<>("l"));
        List<List<TreeNode<String>>> lists=tree.levelOrder();
        for (List<TreeNode<String>> list:
             lists) {
            for (TreeNode<String> node :
                    list) {
                System.out.print(node.key+"\t");
            }
            System.out.println();
        }
    }

    public void testLevelOrder2() {
        tree.incertChild(tree.getRoot().child(0).child(1),new TreeNode<>("l"));
        List<List<TreeNode<String>>> lists=tree.levelOrder(tree.getRoot().child(0));
        for (List<TreeNode<String>> list:
                lists) {
            for (TreeNode<String> node :
                    list) {
                System.out.print(node.key+"\t");
            }
            System.out.println();
        }
    }
}