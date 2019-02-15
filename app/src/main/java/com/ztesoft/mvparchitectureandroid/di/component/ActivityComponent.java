package com.ztesoft.mvparchitectureandroid.di.component;

import com.ztesoft.mvparchitectureandroid.di.ActivityScop;
import com.ztesoft.mvparchitectureandroid.di.module.ActivityModule;
import com.ztesoft.mvparchitectureandroid.ui.login.LoginActivity;
import com.ztesoft.mvparchitectureandroid.ui.main.MainActivity;

import dagger.Component;

/**
 * @author chenyx
 * @class describe
 * @time 2019/1/11 15:40
 * @chang time
 */
@ActivityScop
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(MainActivity activity);

    void inject(LoginActivity activity);
}
