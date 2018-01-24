package com.rh.utilities.io;

/**
 * Created by robert.hanaway on 24/01/2018.
 */

public class IoStats {
    protected final IoStat read = new IoStat();
    protected final IoStat written = new IoStat();

    public IoStat getRead() {
        return read;
    }

    public IoStat getWritten() {
        return written;
    }

    public void reset() {
        read.reset();
        written.reset();
    }
}
