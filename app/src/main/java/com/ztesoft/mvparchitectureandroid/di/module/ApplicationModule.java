package com.ztesoft.mvparchitectureandroid.di.module;

import android.app.Application;
import android.content.Context;
import com.ztesoft.mvparchitectureandroid.HomeApplication;
import com.ztesoft.mvparchitectureandroid.core.AppConstants;
import com.ztesoft.mvparchitectureandroid.data.DataManager;
import com.ztesoft.mvparchitectureandroid.data.db.AppDbHelper;
import com.ztesoft.mvparchitectureandroid.data.db.DbHelper;
import com.ztesoft.mvparchitectureandroid.data.network.AppHttpHelper;
import com.ztesoft.mvparchitectureandroid.data.network.HttpHelper;
import com.ztesoft.mvparchitectureandroid.data.prefs.AppPreferencesHelper;
import com.ztesoft.mvparchitectureandroid.data.prefs.PreferencesHelper;
import com.ztesoft.mvparchitectureandroid.di.ApplicationContext;
import com.ztesoft.mvparchitectureandroid.di.ApplicationScop;
import com.ztesoft.mvparchitectureandroid.di.DataBaseInfo;
import com.ztesoft.mvparchitectureandroid.di.PreferencesInfo;
import dagger.Module;
import dagger.Provides;

/**
 * @author chenyx
 * @class describe
 * @time 2019/1/11 15:41
 * @chang time
 */
@Module
public class ApplicationModule {
    private HomeApplication mApplication;


    public ApplicationModule(HomeApplication application) {
        this.mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context privideContext() {
        return mApplication;
    }

    @Provides
    @ApplicationScop
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @DataBaseInfo
    String provideDataBaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @PreferencesInfo
    String providePreferenceName(){
        return AppConstants.PREF_NAME;
    }

    @Provides
    @ApplicationScop
    DbHelper provideDbHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
    }

    @Provides
    @ApplicationScop
    PreferencesHelper providePreferences(AppPreferencesHelper preferencesHelper) {
        return preferencesHelper;
    }

    @Provides
    @ApplicationScop
    HttpHelper provideHttpHelper(AppHttpHelper appHttpHelper) {
        return appHttpHelper;
    }

    @Provides
    @ApplicationScop
    DataManager provideDataManager(HttpHelper httpHelper, DbHelper dbHelper, PreferencesHelper preferencesHelper) {
        return new DataManager(httpHelper, dbHelper, preferencesHelper);
    }

}
