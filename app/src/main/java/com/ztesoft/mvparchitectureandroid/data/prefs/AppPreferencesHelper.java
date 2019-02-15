package com.ztesoft.mvparchitectureandroid.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import com.ztesoft.mvparchitectureandroid.di.ApplicationContext;
import com.ztesoft.mvparchitectureandroid.di.PreferencesInfo;
import javax.inject.Inject;

/**
 * @author chenyx
 * @class describe
 * @time 2019/1/14 12:14
 * @chang time
 */
public class AppPreferencesHelper implements PreferencesHelper {
    private SharedPreferences pref;
    private static String PREF_LOGIN_NAME = "pref_login_name";

    @Inject
    public AppPreferencesHelper(@ApplicationContext Context context, @PreferencesInfo String prefFileName) {
        pref = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE);
    }

    @Override
    public void setLoginName(String name) {
        pref.edit().putString(PREF_LOGIN_NAME, name).apply();
    }

    @Override
    public String getLoginName() {
        return pref.getString(PREF_LOGIN_NAME, null);
    }
}
