package test.problemAndSolving.leetcode_20201129WeekRanklist;

import junit.framework.TestCase;
import main.problemAndSolving.leetcode_20201129WeekRanklist.T5615使数组互补的最少操作次数;

public class T5615使数组互补的最少操作次数Test extends TestCase {
    T5615使数组互补的最少操作次数 exam;

    public void setUp() throws Exception {
        super.setUp();
        exam=new T5615使数组互补的最少操作次数();
    }

    public void tearDown() throws Exception {
    }

    public void testMinMoves() {
        assertEquals(1,exam.minMoves(new int[]{1,2,4,3},4));
        assertEquals(2,exam.minMoves(new int[]{1,2,2,1},2));
        assertEquals(0,exam.minMoves(new int[]{1,2,1,2},2));
    }
}