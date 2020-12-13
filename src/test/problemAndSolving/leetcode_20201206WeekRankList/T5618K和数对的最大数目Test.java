package test.problemAndSolving.leetcode_20201206WeekRankList;

import junit.framework.TestCase;
import main.problemAndSolving.leetcode_20201206WeekRankList.T5618K和数对的最大数目;

public class T5618K和数对的最大数目Test extends TestCase {
    T5618K和数对的最大数目 exam;

    public void setUp() throws Exception {
        super.setUp();
        exam = new T5618K和数对的最大数目();
    }

    public void tearDown() throws Exception {
    }

    public void testMaxOperations() {
        assertEquals(4,
                exam.maxOperations(new int[]{2, 5, 4, 4, 1, 3, 4, 4, 1, 4, 4, 1, 2, 1, 2, 2, 3, 2, 4, 2}, 3));
    }
}