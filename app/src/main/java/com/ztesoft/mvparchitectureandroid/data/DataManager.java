package com.ztesoft.mvparchitectureandroid.data;

import com.ztesoft.mvparchitectureandroid.data.db.DbHelper;
import com.ztesoft.mvparchitectureandroid.data.db.model.User;
import com.ztesoft.mvparchitectureandroid.data.network.HttpHelper;
import com.ztesoft.mvparchitectureandroid.data.network.NewsResponse;
import com.ztesoft.mvparchitectureandroid.data.network.model.News;
import com.ztesoft.mvparchitectureandroid.data.prefs.PreferencesHelper;
import java.util.List;
import javax.inject.Inject;
import io.reactivex.Flowable;

/**
 * @author chenyx
 * @class describe
 * @time 2019/1/14 21:16
 * @chang time
 */
public class DataManager implements HttpHelper, DbHelper, PreferencesHelper {
    private HttpHelper httpHelper;
    private DbHelper dbHelper;
    private PreferencesHelper prefHelper;

    @Inject
    public DataManager(HttpHelper appHttpHelper, DbHelper appDbHelper, PreferencesHelper appPreferencesHelper) {
        this.httpHelper = appHttpHelper;
        this.dbHelper = appDbHelper;
        this.prefHelper = appPreferencesHelper;
    }

    @Override
    public Flowable<NewsResponse<News>> getNews() {
        return httpHelper.getNews();
    }

    @Override
    public void setLoginName(String name) {
        prefHelper.setLoginName(name);
    }

    @Override
    public String getLoginName() {
        return prefHelper.getLoginName();
    }

    @Override
    public void insertUser(User user) {
        dbHelper.insertUser(user);
    }

    @Override
    public List<User> queryUser() {
        return dbHelper.queryUser();
    }
}
