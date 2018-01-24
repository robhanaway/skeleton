package com.rh.utilities.io;

/**
 * Created by robert.hanaway on 24/01/2018.
 */

public class IoStat {
    private long total;

    public IoStat(long total) {
        setTotal(total);
    }

    public IoStat() {
        this(0);
    }

    public IoStat(final IoStat ioStats) {
        this(ioStats.getTotal());
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public void reset() {
        this.total = 0;
    }

    public long add(long count) {
        total += count;
        return total;
    }

    @Override
    public String toString() {
        return "total:" + String.valueOf(total);
    }
}
