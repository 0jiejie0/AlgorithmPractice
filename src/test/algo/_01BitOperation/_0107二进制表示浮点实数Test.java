package test.algo._01BitOperation;

import junit.framework.TestCase;
import main.algo._01BitOperation._0107二进制表示浮点实数;
import org.junit.Assert;

public class _0107二进制表示浮点实数Test extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
    }

    public void testToBit() {
        Assert.assertEquals("0.101", _0107二进制表示浮点实数.toBit(0.625));
    }
}