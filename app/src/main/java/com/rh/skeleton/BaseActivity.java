package com.rh.skeleton;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.rh.utilities.io.IOUtils;
import com.rh.utilities.logging.Logging;

import javax.inject.Inject;

/**
 * Created by robert.hanaway on 23/01/2018.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Inject
    Logging logging;

    @Inject
    IOUtils ioUtils;

    @Inject
    DataManager mDataManager;
    private ActivityComponent activityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivityComponent().inject(this);
        logging.d(getTag(), "onCreate");
    }

    protected abstract String getTag();

    public ActivityComponent getActivityComponent() {
        if (activityComponent == null) {
            activityComponent = DaggerActivityComponent.builder()
                    .activityModule(new ActivityModule(this))
                    .applicationComponent(SkeletonApplication.get(this).getComponent())
                    .build();
        }
        return activityComponent;
    }
}
