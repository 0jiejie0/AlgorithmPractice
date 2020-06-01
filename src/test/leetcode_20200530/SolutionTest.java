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
//        Assert.assertEquals(new int[]{0, 1}.toString(), new Solution().twoSum(new int[]{2, 7, 11, 15}, 9).toString());
//        Assert.assertEquals(new int[]{0, 1}.toString(), new Solution().twoSum(new int[]{3, 3}, 6).toString());
        Assert.assertEquals(new int[]{0, 2}.toString(), new Solution().twoSum(new int[]{3, 2, 3}, 6).toString());
    }

    @Test
    public void sort() {
    }
}