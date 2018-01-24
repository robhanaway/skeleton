package com.rh.skeleton;

import android.app.Application;
import android.content.Context;
import android.os.Build;

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

        initialise();

        logging.d(TAG, "onCreate");
    }

    void initialise() {
        logging.setEnabled(BuildConfig.DEBUG);
    }

    public static SkeletonApplication get(Context context) {
        return (SkeletonApplication) context.getApplicationContext();
    }

    public ApplicationComponent getComponent(){
        return applicationComponent;
    }
}
