package com.ztesoft.mvparchitectureandroid.contract;

import com.ztesoft.mvparchitectureandroid.data.db.model.User;
import com.ztesoft.mvparchitectureandroid.data.network.model.News;
import com.ztesoft.mvparchitectureandroid.ui.base.BaseView;
import java.util.List;

/**
 * @author chenyx
 * @class describe
 * @time 2019/1/15 15:57
 * @chang time
 */
public interface MainContract {
    interface View extends BaseView {
        void showNews(List<News.DataBean> news);

        void showSpLogin(String name);

        void showDbUser(User user);
    }

    interface Presenter{
        void getNews();

        void getSpLogin();

        void setDbUser(User user);

        void getDbUser();
    }
}
