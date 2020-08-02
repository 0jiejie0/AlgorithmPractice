package test.problemAndSolving.leetcode_20200802WeekRankList;

import junit.framework.TestCase;
import main.problemAndSolving.leetcode_20200802WeekRankList.T5475统计好三元组;
import org.junit.Assert;

public class T5475统计好三元组Test extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
    }

    public void testCountGoodTriplets() {
        Assert.assertEquals(12,new T5475统计好三元组().countGoodTriplets(new int[]{7,3,7,3,12,1,12,2,3},5,8,1));
    }
}