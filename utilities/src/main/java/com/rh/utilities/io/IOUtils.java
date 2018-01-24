package com.rh.utilities.io;


import com.rh.utilities.logging.Loggable;
import com.rh.utilities.logging.Logging;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by robert.hanaway on 24/01/2018.
 */
@Singleton
public class IOUtils implements Loggable {
    final static String TAG  = IOUtils.class.getSimpleName();
    final IoStats read;
    final IoStats written;
    final Logging logging;

    @Inject
    public IOUtils(Logging logging) {
        this.logging = logging;
        read = new IoStats();
        written = new IoStats();
    }

    @Override
    public void log(String tag, Logging logging) {
        logging.d(tag, "%s:[read %d bytes], [wrote %d bytes]",
                TAG, read.getTotal(), written.getTotal());
    }
}
