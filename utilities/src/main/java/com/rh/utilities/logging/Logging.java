package com.rh.utilities.logging;

import android.util.Log;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Logging {
    private boolean enabled;
    @Inject
    Logging() {

    }

    public void d(String tag, String format, Object... args) {
        if (enabled) {
            Log.d(tag, format(format,args));
        }
    }

    public void e(String tag, String format, Object... args) {
        if (enabled) {
            Log.e(tag, format(format,args));
        }
    }

    public void e(String tag, String format, Throwable throwable, Object... args) {
        if (enabled) {
            Log.e(tag,format(format, args), throwable);
        }
    }


    public void i(String tag, String format, Object... args) {
        if (enabled) {
            Log.i(tag, format(format,args));
        }
    }

    public void v(String tag, String format, Object... args) {
        if (enabled) {
            Log.v(tag, format(format,args));
        }
    }

    public void v(String tag, String format, Throwable throwable, Object... args) {
        if (enabled) {
            Log.v(tag,format(format, args), throwable);
        }
    }

    public void wtf(String tag, String format, Throwable throwable, Object... args) {
        if (enabled) {
            Log.wtf(tag,format(format, args), throwable);
        }
    }

    public void wtf(String tag, String format, Object... args) {
        if (enabled) {
            Log.wtf(tag,format(format, args));
        }
    }

    public void wtf(String tag, Throwable throwable) {
        if (enabled) {
            Log.wtf(tag,throwable);
        }
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }


    public String format(String format, Object... args) {
        if(args != null && args.length > 0 && format != null) {
            try {
                return String.format(format, args);
            } catch (OutOfMemoryError e) {
                e.printStackTrace();
            }
        }
        return format;
    }

    public void log(String tag, Loggable loggable) {
        if (enabled) {
            loggable.log(tag, this);
        }
    }
}