package com.ztesoft.mvparchitectureandroid.data.db;

import com.ztesoft.mvparchitectureandroid.data.db.model.User;
import java.util.List;

/**
 * @author chenyx
 * @class describe
 * @time 2019/1/12 17:58
 * @chang time
 */
public interface DbHelper {
    void insertUser(User user);

    List<User> queryUser();
}
