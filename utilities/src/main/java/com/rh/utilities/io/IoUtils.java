package com.rh.utilities.io;


import com.rh.utilities.logging.Loggable;
import com.rh.utilities.logging.Logging;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by robert.hanaway on 24/01/2018.
 */
@Singleton
public class IoUtils extends IoStats implements Loggable {
    final static String TAG  = IoUtils.class.getSimpleName();
    public final static long UNKNOWN = -1;
    final Logging logging;
    final Map<String,IoStats> ioStatsMap = new HashMap<>();

    @Inject
    public IoUtils(final Logging logging) {
        this.logging = logging;
    }

    @Override
    public void log(final String tag, final Logging logging) {
        logging.i(tag, "%s:[read %d bytes], [wrote %d bytes]",
                TAG, read.getTotal(), written.getTotal());
    }

    public int read(final InputStream inputStream, final byte[] buffer) throws IOException {
        int bytesRead = inputStream.read(buffer);
        read.add(bytesRead);
        return bytesRead;
    }

    public int read(final String tag, final InputStream inputStream, final byte[] buffer) throws IOException {
        int bytesRead = read(inputStream, buffer);
        getOrAddIoStats(tag).getRead().add(bytesRead);
        return bytesRead;
    }

    public void write(final OutputStream outputStream, final byte[] buffer) throws IOException {
        outputStream.write(buffer);
        written.add(buffer.length);
    }

    public void write(final String tag, final OutputStream outputStream, final byte[] buffer) throws IOException {
        write(outputStream, buffer);
        getOrAddIoStats(tag).getWritten().add(buffer.length);
    }

    public long getBytesRead() {
        return read.getTotal();
    }

    public long getBytesRead(final String tag) {
        return ioStatsMap.containsKey(tag) ?
                ioStatsMap.get(tag).getRead().getTotal() : UNKNOWN;
    }

    public long getBytesWritten() {
        return written.getTotal();
    }

    public long getBytesWritten(final String tag) {
        return ioStatsMap.containsKey(tag) ?
                ioStatsMap.get(tag).getWritten().getTotal() : UNKNOWN;
    }

    public void reset() {
        read.reset();
        written.reset();
        ioStatsMap.clear();
    }

    public void reset(final String tag) {
        if (ioStatsMap.containsKey(tag)) {
            ioStatsMap.remove(tag);
        }
    }

    private IoStats getOrAddIoStats(final String tag) {
        IoStats result;
        if (ioStatsMap.containsKey(tag)) {
            result = ioStatsMap.get(tag);
        } else {
            result = new IoStats();
            ioStatsMap.put(tag, result);
        }
        return result;

    }
}
