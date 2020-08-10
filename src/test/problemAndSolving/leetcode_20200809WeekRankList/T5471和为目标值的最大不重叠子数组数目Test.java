package test.problemAndSolving.leetcode_20200809WeekRankList;

import junit.framework.TestCase;
import main.problemAndSolving.leetcode_20200809WeekRankList.T5471和为目标值的最大不重叠子数组数目;
import org.junit.Assert;

public class T5471和为目标值的最大不重叠子数组数目Test extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
    }

    public void testMaxNonOverlapping() {
        Assert.assertEquals(3, new T5471和为目标值的最大不重叠子数组数目().maxNonOverlapping(new int[]{-2, 6, 6, 3, 5, 4, 1, 2, 8}, 10));
        Assert.assertEquals(2, new T5471和为目标值的最大不重叠子数组数目().maxNonOverlapping(new int[]{1, 1, 1, 1, 1}, 2));
        Assert.assertEquals(2, new T5471和为目标值的最大不重叠子数组数目().maxNonOverlapping(new int[]{-1, 3, 5, 1, 4, 2, -9}, 6));
        Assert.assertEquals(3, new T5471和为目标值的最大不重叠子数组数目().maxNonOverlapping(new int[]{0, 0, 0}, 0));
    }
}