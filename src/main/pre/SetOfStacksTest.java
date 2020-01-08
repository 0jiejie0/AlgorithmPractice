package main.pre;

import junit.framework.TestCase;

public class SetOfStacksTest extends TestCase {
    SetOfStacks stacks=new SetOfStacks();
    int k=4;
    int [][]opeAndValue=new int[][]{
            {0,0},
            {1,2},
            {0,1},
            {1,9},
            {1,4},
            {1,3},
            {0,0},
            {1,8},
            {1,6},
            {1,28},
            {0,0}
    };
    public void setUp() throws Exception {
//        stacks.setStacks(opeAndValue,3);
    }

    public void tearDown() throws Exception {
        System.out.println(stacks.string(stacks.setStacks(opeAndValue,4)));
    }

    public void testSetStacks() {
    }
}