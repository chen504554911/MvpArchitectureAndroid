package com.ztesoft.mvparchitectureandroid.contract;

import com.ztesoft.mvparchitectureandroid.ui.base.BaseView;

/**
 * @author chenyx
 * @class describe
 * @time 2019/1/16 18:38
 * @chang time
 */
public interface LoginContract {
    interface View extends BaseView{
    }

    interface Presenter{
        void setSpLogin(String phone);
    }

}
