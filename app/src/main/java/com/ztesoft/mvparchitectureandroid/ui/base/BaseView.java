package com.ztesoft.mvparchitectureandroid.ui.base;

/**
 * @author chenyx
 * @class describe
 * @time 2019/1/12 11:23
 * @chang time
 */
public interface BaseView {
    void onError(String msg);

    void showLoading();

    void dismissLoading();
}
