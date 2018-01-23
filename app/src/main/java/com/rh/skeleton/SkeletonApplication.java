package com.rh.skeleton;

import android.app.Application;
import android.content.Context;

import javax.inject.Inject;


/**
 * Created by robert.hanaway on 23/01/2018.
 */

public class SkeletonApplication extends Application{

    protected ApplicationComponent applicationComponent;

    @Inject
    DataManager dataManager;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        applicationComponent.inject(this);
    }


    public static SkeletonApplication get(Context context) {
        return (SkeletonApplication) context.getApplicationContext();
    }

    public ApplicationComponent getComponent(){
        return applicationComponent;
    }
}
