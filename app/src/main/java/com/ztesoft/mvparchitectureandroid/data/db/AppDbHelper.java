package com.ztesoft.mvparchitectureandroid.data.db;

import com.ztesoft.mvparchitectureandroid.data.db.greendao.DaoMaster;
import com.ztesoft.mvparchitectureandroid.data.db.greendao.DaoSession;
import com.ztesoft.mvparchitectureandroid.data.db.model.User;
import com.ztesoft.mvparchitectureandroid.di.ApplicationScop;
import java.util.List;
import javax.inject.Inject;

/**
 * @author chenyx
 * @class describe
 * @time 2019/1/12 17:58
 * @chang time
 */
@ApplicationScop
public class AppDbHelper implements DbHelper {
    private DaoSession mDaoSession;

    @Inject
    public AppDbHelper(DbOpenHelper openHelper) {
        mDaoSession = new DaoMaster(openHelper.getWritableDatabase()).newSession();
    }

    @Override
    public void insertUser(User user) {
        mDaoSession.getUserDao().insert(user);
    }

    @Override
    public List<User> queryUser() {
        return mDaoSession.getUserDao().loadAll();
    }
}
