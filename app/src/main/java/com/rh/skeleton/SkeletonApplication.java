package com.rh.skeleton;

import android.app.Application;
import android.content.Context;

import com.rh.skeleton.logging.Logging;

import javax.inject.Inject;


/**
 * Created by robert.hanaway on 23/01/2018.
 */

public class SkeletonApplication extends Application {
    final static String TAG = SkeletonApplication.class.getSimpleName();


    protected ApplicationComponent applicationComponent;

    @Inject
    DataManager dataManager;

    @Inject
    Logging logging;
    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        applicationComponent.inject(this);

        logging.d(TAG, "onCreate");
    }


    public static SkeletonApplication get(Context context) {
        return (SkeletonApplication) context.getApplicationContext();
    }

    public ApplicationComponent getComponent(){
        return applicationComponent;
    }
}
