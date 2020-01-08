package main.pre.tree;

import junit.framework.TestCase;

public class BinarySearchTreeTest extends TestCase {
    BinarySearchTree<Integer,String> tree=new BinarySearchTree<>();

    public void setUp() throws Exception {
//        testInsert();
    }

    public void testInsert() {
        assertEquals(tree.getHeight(),-1);
        tree.insert(4,"four");
        assertEquals(tree.getHeight(),0);
        tree.insert(1);
        assertEquals(tree.getHeight(),1);
        tree.insert(10);
        assertEquals(tree.getHeight(),1);
        tree.insert(14,"shisi");
        assertEquals(tree.getSize(),4);
        assertEquals(tree.getHeight(),2);
        tree.insert(7,"banlan");
        assertEquals(tree.getSize(),5);
        assertEquals(tree.getHeight(),2);
        tree.insert(16);
        assertEquals(tree.getHeight(),3);
        tree.insert(9);
        assertEquals(tree.getSize(),7);
        assertEquals(tree.getHeight(),3);
        tree.insert(3);
        assertEquals(tree.getHeight(),3);
        tree.insert(5);
        assertEquals(tree.getSize(),9);
        assertEquals(tree.getHeight(),3);
        tree.insert(2);
        assertEquals(tree.getHeight(),3);
        tree.insert(20);
        assertEquals(tree.getHeight(),4);
        tree.insert(25,"erwu");
        assertEquals(tree.getSize(),12);
        assertEquals(tree.getHeight(),5);
    }

    public void testInorder() {
        tree.inorder(k->{
            System.out.println(k);
        });
    }

    public void testLookupValue() {
        assertEquals(tree.lookupValue(4),"four");
        assertEquals(tree.lookupValue(25),"erwu");
        assertEquals(tree.lookupValue(14),"shisi");
        assertEquals(tree.lookupValue(7),"banlan");
        tree.insert(25,"zuidazhi");
        assertEquals(tree.lookupValue(25),"zuidazhi");
    }

    public void testMin() {
        assertEquals(tree.min(),(Integer) 1);
        assertEquals(tree.max(),(Integer)25);
        tree.insert(26);
        tree.insert(0);
        assertEquals(tree.min(),(Integer) 0);
        assertEquals(tree.max(),(Integer)26);
    }

    public void testMax() {
    }

    public void testRemove() {
    }

    public void testSuccessor() {
    }

    public void testPredecessor() {
    }

    public void testIsBalance() {
    }

    public void testGetSize() {
    }

    public void testGetHeight() {
    }

    public void testLevelOrder() {
    }
}