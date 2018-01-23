package com.rh.skeleton.logging;

import android.util.Log;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Logging {

    @Inject
    Logging() {

    }

    public void d(String tag, String msg) {
        Log.d(tag, msg);
    }
}