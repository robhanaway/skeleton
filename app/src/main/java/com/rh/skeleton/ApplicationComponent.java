package com.rh.skeleton;

import android.app.Application;
import android.content.Context;

import com.rh.skeleton.logging.Logging;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Provides;

/**
 * Created by robert.hanaway on 23/01/2018.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(SkeletonApplication skeletonApplication);

    @ApplicationContext
    Context getContext();

    Application getApplication();

    DataManager getDataManager();

    DbHelper getDbHelper();

    Logging getLogging();
}
