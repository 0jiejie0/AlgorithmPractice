package test.problemAndSolving.leetcode_20201120;

import junit.framework.TestCase;
import main.problemAndSolving.leetcode.leetcode_20201120.T204计数质数;
import org.junit.Assert;

public class T204计数质数Test extends TestCase {
    T204计数质数 exam;

    public void setUp() throws Exception {
        super.setUp();
        exam = new T204计数质数();
    }

    public void tearDown() throws Exception {
    }

    public void testCountPrimes() {
        Assert.assertEquals(4, exam.countPrimes(10));
        Assert.assertEquals(0, exam.countPrimes(0));
        Assert.assertEquals(0, exam.countPrimes(1));
        Assert.assertEquals(0, exam.countPrimes(2));
        Assert.assertEquals(1, exam.countPrimes(3));
        Assert.assertEquals(2, exam.countPrimes(4));
        Assert.assertEquals(2, exam.countPrimes(5));
        Assert.assertEquals(3, exam.countPrimes(6));
        Assert.assertEquals(41537, exam.countPrimes(499979));
    }
}