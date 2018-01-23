package com.rh.skeleton;

import dagger.Component;

/**
 * Created by robert.hanaway on 23/01/2018.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(BaseActivity mainActivity);

}
