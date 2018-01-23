package com.rh.skeleton;

import android.content.Context;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by robert.hanaway on 23/01/2018.
 */

@Singleton
public class DataManager {

    private Context mContext;
    private DbHelper mDbHelper;


    @Inject
    public DataManager(@ApplicationContext Context context,
                       DbHelper dbHelper) {
        mContext = context;
        mDbHelper = dbHelper;

    }


}
