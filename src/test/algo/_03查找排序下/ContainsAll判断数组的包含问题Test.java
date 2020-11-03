package test.algo._03查找排序下;

import junit.framework.TestCase;
import main.algo._03查找排序下.ContainsAll判断数组的包含问题;
import org.junit.Assert;

public class ContainsAll判断数组的包含问题Test extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
    }

    public void testCheck() {
        Assert.assertEquals(true, ContainsAll判断数组的包含问题.check("hol","hello"));
        Assert.assertEquals(false, ContainsAll判断数组的包含问题.check("hello","world"));
    }
}