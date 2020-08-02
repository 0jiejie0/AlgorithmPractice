package test.algo._01BitOperation;

import junit.framework.TestCase;
import main.algo._01BitOperation.交换奇偶位;
import org.junit.Assert;

public class 交换奇偶位Test extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
    }

    public void testSwap() {
        Assert.assertEquals(6, 交换奇偶位.swap(9));
        Assert.assertEquals(9, 交换奇偶位.swap(6));
        Assert.assertEquals(0b10000000_00000000_00000000_00000010, 交换奇偶位.swap(0b01000000_00000000_00000000_00000001));
        Assert.assertEquals(0b01100000_00000000_00000000_00000011, 交换奇偶位.swap(0b10010000_00000000_00000000_00000011));
    }
}