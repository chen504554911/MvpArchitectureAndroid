package com.ztesoft.mvparchitectureandroid.presenter;

import com.ztesoft.mvparchitectureandroid.contract.MainContract;
import com.ztesoft.mvparchitectureandroid.data.DataManager;
import com.ztesoft.mvparchitectureandroid.data.db.model.User;
import com.ztesoft.mvparchitectureandroid.data.network.NewsResponse;
import com.ztesoft.mvparchitectureandroid.data.network.model.News;
import com.ztesoft.mvparchitectureandroid.ui.base.AppBasePresenter;
import com.ztesoft.mvparchitectureandroid.util.RxUtil;
import java.util.List;
import javax.inject.Inject;
import io.reactivex.disposables.CompositeDisposable;

/**
 * @author chenyx
 * @class describe
 * @time 2019/1/15 16:06
 * @chang time
 */
public class MainPresenter<V extends MainContract.View> extends AppBasePresenter<V> implements MainContract.Presenter {

    @Inject
    public MainPresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

    @Override
    public void getNews() {
        view.showLoading();
        getmCompositeDisposable().add(getmDataManager()
                .getNews()
                .compose(RxUtil.<NewsResponse<News>>rxSchedulerHelper())
                .subscribe(newsNewsResponse -> {
                        view.dismissLoading();
                        view.showNews(newsNewsResponse.result.getData());
                }, throwable -> {
                        view.dismissLoading();
                        view.onError(throwable.getMessage());
                })
        );
    }

    @Override
    public void getSpLogin() {
        String name = getmDataManager().getLoginName();
        view.showSpLogin(name);
    }

    @Override
    public void setDbUser(User user) {
        getmDataManager().insertUser(user);
    }

    @Override
    public void getDbUser() {
        List<User> users = getmDataManager().queryUser();
        view.showDbUser(users.get(0));
    }
}
