package com.rh.utilities.io;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Created by robert.hanaway on 24/01/2018.
 */

public class TestIoStat {
    final int AMOUNT = 123;
    @Test
    public void testDefaultCtor() {
        Assert.assertEquals(0, new IoStat().getTotal());
    }

    @Test
    public void testAdd() {
        Assert.assertEquals(AMOUNT, new IoStat().add(AMOUNT));
    }

    @Test
    public void testMultipleAdd() {
        IoStat ioStat = new IoStat();
        Assert.assertEquals(AMOUNT, ioStat.add(AMOUNT));
        ioStat.add(AMOUNT);
        Assert.assertEquals(AMOUNT * 2, ioStat.getTotal());
    }

    @Test
    public void testCtorWithValue() {
        IoStat ioStat = new IoStat(AMOUNT);
        Assert.assertEquals(AMOUNT , ioStat.getTotal());
    }

    @Test
    public void testCtorWithObject() {
        IoStat ioStat = new IoStat(AMOUNT);
        Assert.assertEquals(AMOUNT , new IoStat(ioStat).getTotal());
    }

    @Test
    public void testReset() {
        IoStat ioStat = new IoStat(AMOUNT);
        Assert.assertEquals(AMOUNT , ioStat.getTotal());
        ioStat.reset();
        Assert.assertEquals(0 , ioStat.getTotal());
    }

    @Test
    public void testToString() {
        IoStat ioStat = new IoStat(AMOUNT);
        Assert.assertTrue(ioStat.toString().contains(String.valueOf(AMOUNT)));
    }
}
