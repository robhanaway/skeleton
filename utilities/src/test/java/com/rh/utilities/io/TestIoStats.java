package com.rh.utilities.io;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Created by robert.hanaway on 24/01/2018.
 */

public class TestIoStats {
    final int AMOUNT = 123;
    @Test
    public void testDefaultCtor() {
        Assert.assertEquals(0, new IoStats().getTotal());
    }

    @Test
    public void testAdd() {
        Assert.assertEquals(AMOUNT, new IoStats().add(AMOUNT));
    }

    @Test
    public void testMultipleAdd() {
        IoStats ioStats = new IoStats();
        Assert.assertEquals(AMOUNT, ioStats.add(AMOUNT));
        ioStats.add(AMOUNT);
        Assert.assertEquals(AMOUNT * 2, ioStats.getTotal());
    }

    @Test
    public void testCtorWithValue() {
        IoStats ioStats = new IoStats(AMOUNT);
        Assert.assertEquals(AMOUNT , ioStats.getTotal());
    }

    @Test
    public void testCtorWithObject() {
        IoStats ioStats = new IoStats(AMOUNT);
        Assert.assertEquals(AMOUNT , new IoStats(ioStats).getTotal());
    }

    @Test
    public void testReset() {
        IoStats ioStats = new IoStats(AMOUNT);
        Assert.assertEquals(AMOUNT , ioStats.getTotal());
        ioStats.reset();
        Assert.assertEquals(0 , ioStats.getTotal());
    }

    @Test
    public void testToString() {
        IoStats ioStats = new IoStats(AMOUNT);
        Assert.assertTrue(ioStats.toString().contains(String.valueOf(AMOUNT)));
    }
}
