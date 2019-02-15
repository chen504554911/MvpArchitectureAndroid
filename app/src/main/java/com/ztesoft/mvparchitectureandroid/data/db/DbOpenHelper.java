package com.ztesoft.mvparchitectureandroid.data.db;

import android.content.Context;
import com.ztesoft.mvparchitectureandroid.data.db.greendao.DaoMaster;
import com.ztesoft.mvparchitectureandroid.di.ApplicationContext;
import com.ztesoft.mvparchitectureandroid.di.ApplicationScop;
import com.ztesoft.mvparchitectureandroid.di.DataBaseInfo;
import org.greenrobot.greendao.database.Database;
import javax.inject.Inject;

/**
 * @author chenyx
 * @class describe
 * @time 2019/1/12 18:00
 * @chang time
 */
@ApplicationScop
public class DbOpenHelper extends DaoMaster.OpenHelper {

    @Inject
    public DbOpenHelper(@ApplicationContext Context context,@DataBaseInfo String name) {
        super(context, name);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);

    }
}
