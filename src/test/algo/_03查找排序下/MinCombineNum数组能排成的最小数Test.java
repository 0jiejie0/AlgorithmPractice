package test.algo._03查找排序下;

import junit.framework.TestCase;
import main.algo._03查找排序下.MinCombineNum数组能排成的最小数;
import org.junit.Assert;

public class MinCombineNum数组能排成的最小数Test extends TestCase {
    MinCombineNum数组能排成的最小数 exam = new MinCombineNum数组能排成的最小数();

    public void setUp() throws Exception {
        super.setUp();
        exam = new MinCombineNum数组能排成的最小数();
    }

    public void tearDown() throws Exception {
    }

    public void testFindMinNum() {
        Assert.assertEquals(321323, exam.findMinNum(new Integer[]{32, 3, 321}));
    }
}