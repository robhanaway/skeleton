package com.rh.utilities.io;


import com.rh.utilities.logging.Loggable;
import com.rh.utilities.logging.Logging;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by robert.hanaway on 24/01/2018.
 */
@Singleton
public class IoUtils implements Loggable {
    final static String TAG  = IoUtils.class.getSimpleName();
    final IoStats read;
    final IoStats written;
    final Logging logging;

    @Inject
    public IoUtils(Logging logging) {
        this.logging = logging;
        read = new IoStats();
        written = new IoStats();
    }

    @Override
    public void log(String tag, Logging logging) {
        logging.i(tag, "%s:[read %d bytes], [wrote %d bytes]",
                TAG, read.getTotal(), written.getTotal());
    }

    public int read(InputStream inputStream, byte[] buffer) throws IOException {
        int bytesRead = inputStream.read(buffer);
        read.add(bytesRead);
        return bytesRead;
    }

    public void write(OutputStream outputStream, byte[] buffer) throws IOException {
        outputStream.write(buffer);
        written.add(buffer.length);
    }

    public long getBytesRead() {
        return read.getTotal();
    }

    public long getBytesWritten() {
        return written.getTotal();
    }

    public void reset() {
        read.reset();
        written.reset();
    }
}
