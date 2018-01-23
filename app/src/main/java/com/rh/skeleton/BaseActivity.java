package com.rh.skeleton;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

/**
 * Created by robert.hanaway on 23/01/2018.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Inject
    DataManager mDataManager;
    private ActivityComponent activityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivityComponent().inject(this);
    }
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
