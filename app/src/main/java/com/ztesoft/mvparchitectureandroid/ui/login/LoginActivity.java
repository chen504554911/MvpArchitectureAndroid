package com.ztesoft.mvparchitectureandroid.ui.login;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import com.ztesoft.mvparchitectureandroid.R;
import com.ztesoft.mvparchitectureandroid.contract.LoginContract;
import com.ztesoft.mvparchitectureandroid.presenter.LoginPresenter;
import com.ztesoft.mvparchitectureandroid.ui.base.BaseActivity;
import com.ztesoft.mvparchitectureandroid.ui.main.MainActivity;
import com.ztesoft.mvparchitectureandroid.util.ZteSoftToast;
import javax.inject.Inject;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author chenyx
 * @class describe
 * @time 2019/1/11 15:48
 * @chang time
 */
public class LoginActivity extends BaseActivity implements LoginContract.View {
    @Inject
    LoginPresenter<LoginContract.View> loginPresenter;
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.et_pwd)
    EditText etPwd;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void init() {
        setCenterTitle("登录");
        getActivityComponent().inject(this);
        loginPresenter.onAttach(this);
    }

    @OnClick({R.id.btn_login})
    protected void onClickEvent(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                String etPhoneName=etPhone.getText().toString().trim();
                if ("".equals(etPhoneName)){
                    ZteSoftToast.show(this,"请输入用户名");
                    return;
                }
                loginPresenter.setSpLogin(etPhoneName);
                Intent intent=new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (loginPresenter != null) {
            loginPresenter.onDetach();
        }
    }
}
