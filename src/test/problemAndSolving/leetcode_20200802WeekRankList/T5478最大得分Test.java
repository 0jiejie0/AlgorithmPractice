package test.problemAndSolving.leetcode_20200802WeekRankList;

import junit.framework.TestCase;
import main.problemAndSolving.leetcode_20200802WeekRankList.T5478最大得分;
import org.junit.Assert;

public class T5478最大得分Test extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
    }

    public void testMaxSum() {
        Assert.assertEquals(30, new T5478最大得分().maxSum(new int[]{2, 4, 5, 8, 10}, new int[]{4, 6, 8, 9}));
        Assert.assertEquals(109, new T5478最大得分().maxSum(new int[]{1,3,5,7,9}, new int[]{3,5,100}));
        Assert.assertEquals(40, new T5478最大得分().maxSum(new int[]{1,2,3,4,5}, new int[]{6,7,8,9,10}));
        Assert.assertEquals(61, new T5478最大得分().maxSum(new int[]{1,4,5,8,9,11,19}, new int[]{2,3,4,11,12}));
//        Assert.assertEquals(212278171, new T5478最大得分().maxSum(new int[]{}, new int[]{}));
    }
}