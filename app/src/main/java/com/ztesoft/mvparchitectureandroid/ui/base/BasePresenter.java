package com.ztesoft.mvparchitectureandroid.ui.base;

/**
 * @author chenyx
 * @class describe
 * @time 2019/1/15 0:32
 * @chang time
 */
public interface BasePresenter<V extends BaseView> {
    void onAttach(V baseView);

    void onDetach();
}
