package test.problemAndSolving.leetcode_20201115WeekRankList;

import junit.framework.TestCase;
import main.problemAndSolving.leetcode.leetcode_20201115WeekRankList.T5602将x减到0的最小操作数;
import org.junit.Assert;

public class T5602将x减到0的最小操作数Test extends TestCase {
    T5602将x减到0的最小操作数 exam;

    public void setUp() throws Exception {
        super.setUp();
        exam = new T5602将x减到0的最小操作数();
    }

    public void tearDown() throws Exception {
    }

    public void testMinOperations() {
        Assert.assertEquals(2, exam.minOperations(new int[]{1, 1, 4, 2, 3}, 5));
        Assert.assertEquals(-1, exam.minOperations(new int[]{5, 6, 7, 8, 9}, 4));
        Assert.assertEquals(5, exam.minOperations(new int[]{3, 2, 20, 1, 1, 3}, 10));
        Assert.assertEquals(1, exam.minOperations(new int[]{5, 2, 3, 1, 1}, 5));
    }
}