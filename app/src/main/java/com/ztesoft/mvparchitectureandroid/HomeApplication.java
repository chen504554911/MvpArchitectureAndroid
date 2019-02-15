package com.ztesoft.mvparchitectureandroid;

import android.app.Application;
import com.ztesoft.mvparchitectureandroid.di.component.ApplicationComponent;
import com.ztesoft.mvparchitectureandroid.di.component.DaggerApplicationComponent;
import com.ztesoft.mvparchitectureandroid.di.module.ApplicationModule;
import com.ztesoft.mvparchitectureandroid.di.module.HttpModule;

/**
 * @author chenyx
 * @class describe
 * @time 2019/1/11 16:07
 * @chang time
 */
public class HomeApplication extends Application {
    private static ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .httpModule(new HttpModule())
                .build();
        applicationComponent.inject(this);
    }

    public static ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

}
