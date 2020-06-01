package test.leetcode_20200530;

import main.leetcode_20200530.Solution;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void twoSum() {
        Assert.assertArrayEquals(new int[]{0, 1}, new Solution().twoSum(new int[]{2, 7, 11, 15}, 9));
        Assert.assertArrayEquals(new int[]{0, 1}, new Solution().twoSum(new int[]{3, 3}, 6));
        Assert.assertArrayEquals(new int[]{0, 2}, new Solution().twoSum(new int[]{3, 2, 3}, 6));
        Assert.assertArrayEquals(new int[]{1, 2}, new Solution().twoSum(new int[]{3, 2, 4}, 6));
        Assert.assertArrayEquals(new int[]{0, 3}, new Solution().twoSum(new int[]{0, 4, 3, 0}, 0));
    }

    @Test
    public void sort() {
    }
}