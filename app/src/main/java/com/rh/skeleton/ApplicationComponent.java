package com.rh.skeleton;

import android.app.Application;
import android.content.Context;

import com.rh.utilities.io.IOUtils;
import com.rh.utilities.logging.Logging;

import javax.inject.Singleton;

import dagger.Component;

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

    IOUtils getIOUtils();
}
