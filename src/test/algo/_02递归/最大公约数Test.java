package test.algo._02递归;

import junit.framework.TestCase;
import main.algo._02查找排序上.最大公约数;
import org.junit.Assert;

public class 最大公约数Test extends TestCase {
    最大公约数 exam;

    public void setUp() throws Exception {
        super.setUp();
        exam=new 最大公约数();
    }

    public void tearDown() throws Exception {
    }

    public void testGreatestCommonDivisor() {
        Assert.assertEquals(3,exam.greatestCommonDivisor(21,24));
        Assert.assertEquals(3,exam.greatestCommonDivisor(21,27));
        Assert.assertEquals(9,exam.greatestCommonDivisor(36,27));
        Assert.assertEquals(1,exam.greatestCommonDivisor(28,27));
    }
}