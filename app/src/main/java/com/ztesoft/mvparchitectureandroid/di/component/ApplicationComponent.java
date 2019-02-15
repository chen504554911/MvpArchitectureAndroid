package com.ztesoft.mvparchitectureandroid.di.component;

import com.ztesoft.mvparchitectureandroid.HomeApplication;
import com.ztesoft.mvparchitectureandroid.data.DataManager;
import com.ztesoft.mvparchitectureandroid.di.ApplicationScop;
import com.ztesoft.mvparchitectureandroid.di.module.ApplicationModule;
import com.ztesoft.mvparchitectureandroid.di.module.HttpModule;
import dagger.Component;

/**
 * @author chenyx
 * @class describe
 * @time 2019/1/11 15:40
 * @chang time
 */
@ApplicationScop
@Component(modules = {ApplicationModule.class, HttpModule.class})
public interface ApplicationComponent {
    void inject(HomeApplication application);

    DataManager getDataManager();
}
