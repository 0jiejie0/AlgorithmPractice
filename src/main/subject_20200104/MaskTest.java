package main.subject_20200104;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaskTest {

    @Test
    public void buyMask() {
        Assert.assertEquals(4, Mask.buyMask(10, 10, 12));
        Assert.assertEquals(10, Mask.buyMask(10, 10, 30));
        Assert.assertEquals(0, Mask.buyMask(10, 10, 0));
    }
}