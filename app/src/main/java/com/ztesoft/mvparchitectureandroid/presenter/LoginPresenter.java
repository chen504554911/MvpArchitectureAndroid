package com.ztesoft.mvparchitectureandroid.presenter;

import com.ztesoft.mvparchitectureandroid.contract.LoginContract;
import com.ztesoft.mvparchitectureandroid.data.DataManager;
import com.ztesoft.mvparchitectureandroid.ui.base.AppBasePresenter;
import javax.inject.Inject;
import io.reactivex.disposables.CompositeDisposable;

/**
 * @author chenyx
 * @class describe
 * @time 2019/1/16 18:38
 * @chang time
 */
public class LoginPresenter<V extends LoginContract.View> extends AppBasePresenter<V> implements LoginContract.Presenter{
    @Inject
    public LoginPresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

    @Override
    public void setSpLogin(String phone) {
        getmDataManager().setLoginName(phone);
    }
}
