package test.algo._01BitOperation;

import junit.framework.TestCase;
import main.algo._01BitOperation.k个数中出现1次的数;
import org.junit.Assert;

public class k个数中出现1次的数Test extends TestCase {
    k个数中出现1次的数 exam = new k个数中出现1次的数();

    public void setUp() throws Exception {
        super.setUp();
        exam = new k个数中出现1次的数();
    }

    public void tearDown() throws Exception {
    }

    public void testFind() {
        Assert.assertEquals(8,exam.find(new int[]{3,3,3,2,1,1,1,2,2,7,8,7,7},3));
        Assert.assertEquals(8,exam.find(new int[]{2,2,2,2,5,5,6,8,5,5,6,6,6},4));
    }
}