package com.ztesoft.mvparchitectureandroid.di.module;

import android.support.v7.app.AppCompatActivity;
import com.ztesoft.mvparchitectureandroid.di.ActivityScop;
import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * @author chenyx
 * @class describe
 * @time 2019/1/11 15:40
 * @chang time
 */
@Module
public class ActivityModule {
    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityScop
    CompositeDisposable provideDisposable() {
        return new CompositeDisposable();
    }

}
