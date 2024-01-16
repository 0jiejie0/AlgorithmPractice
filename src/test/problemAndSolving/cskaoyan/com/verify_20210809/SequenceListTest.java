package test.problemAndSolving.cskaoyan.com.verify_20210809;

import junit.framework.TestCase;
import main.problemAndSolving.cskaoyan.com.verify_20210809.SequenceList;
import main.problemAndSolving.cskaoyan.com.verify_20210809.SqList;

public class SequenceListTest extends TestCase {
    SequenceList list;
    SqList l;
    int s = 3, t = 500;

    public void setUp() throws Exception {
        super.setUp();
        list = new SequenceList();
        l = new SqList(new int[]{2, 233, 2, 53, 3, 6, 3, 26, 13, 56, 3, 546, 47, 23, 5, 546, 34, 132, 4, 675, 90, 7, 8, 1});
        System.out.println(l);
    }

    public void tearDown() throws Exception {
        System.out.println(l);
    }

    public void testDelST() {
        list.delST(l, s, t);
    }

    public void testDeleteBetween() {
        list.deleteBetween(l, s, t);
    }
}