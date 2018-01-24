package com.rh.utilities.io;

/**
 * Created by robert.hanaway on 24/01/2018.
 */

public class IoStats {
    private long total;

    public IoStats(long total) {
        setTotal(total);
    }

    public IoStats() {
        this(0);
    }

    public IoStats(final IoStats ioStats) {
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
