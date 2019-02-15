package com.ztesoft.mvparchitectureandroid.ui.base;

import com.ztesoft.mvparchitectureandroid.data.DataManager;
import javax.inject.Inject;
import io.reactivex.disposables.CompositeDisposable;

/**
 * @author chenyx
 * @class describe
 * @time 2019/1/15 16:27
 * @chang time
 */
public class AppBasePresenter<V extends BaseView> implements BasePresenter<V> {
    protected V view;
    private DataManager mDataManager;
    private CompositeDisposable mCompositeDisposable;

    @Inject
    public AppBasePresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        this.mDataManager = dataManager;
        this.mCompositeDisposable = compositeDisposable;
    }

    public DataManager getmDataManager() {
        return mDataManager;
    }

    public CompositeDisposable getmCompositeDisposable() {
        return mCompositeDisposable;
    }

    @Override
    public void onAttach(V baseView) {
        this.view = baseView;
    }

    @Override
    public void onDetach() {
        mCompositeDisposable.dispose();
        view = null;
    }
}
