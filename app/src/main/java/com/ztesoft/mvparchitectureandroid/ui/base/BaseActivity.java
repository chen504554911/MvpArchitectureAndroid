package com.ztesoft.mvparchitectureandroid.ui.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ztesoft.mvparchitectureandroid.HomeApplication;
import com.ztesoft.mvparchitectureandroid.R;
import com.ztesoft.mvparchitectureandroid.di.component.ActivityComponent;
import com.ztesoft.mvparchitectureandroid.di.component.DaggerActivityComponent;
import com.ztesoft.mvparchitectureandroid.di.module.ActivityModule;
import com.ztesoft.mvparchitectureandroid.util.CommonUtils;
import com.ztesoft.mvparchitectureandroid.util.ZteSoftToast;
import butterknife.ButterKnife;

/**
 * @author chenyx
 * @class describe
 * @time 2019/1/11 15:58
 * @chang time
 */
public abstract class BaseActivity extends AppCompatActivity implements BaseView {
    private View contentView;
    private Toolbar toolbar;
    private TextView tvTitle;
    protected boolean isBack = true;
    private ActivityComponent activityComponent;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView = LayoutInflater.from(this).inflate(getLayoutId(), null);
        setContentView(contentView);
        ButterKnife.bind(this);
        activityComponent = DaggerActivityComponent.builder().applicationComponent(HomeApplication.getApplicationComponent())
                .activityModule(new ActivityModule(this)).build();
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tvTitle = (TextView) findViewById(R.id.tv_activity_title);

        //点击箭头返回
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBack) {
                    finish();
                }
            }
        });
        init();
    }

    public ActivityComponent getActivityComponent() {
        return activityComponent;
    }

    @Override
    public void setContentView(View contentView) {
        ViewGroup superContentView = (ViewGroup) LayoutInflater.from(this)
                .inflate(R.layout.activity_base, null);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        RelativeLayout rootView = (RelativeLayout) superContentView.findViewById(R.id.content);
        rootView.addView(contentView, params);
//        rootView.setFitsSystemWindows(true);
//        rootView.setLayoutParams(params);
//        StatusBarCompat.compat(this, rootView, getStatusBar());
        super.setContentView(superContentView);
    }

    protected abstract int getLayoutId();

    protected abstract void init();

    /**
     * 设置标题（居中标题）
     *
     * @param title
     */
    public void setCenterTitle(String title) {

        if (tvTitle == null) {
            tvTitle = (TextView) findViewById(R.id.tv_activity_title);
        }
        tvTitle.setText(title);
    }

    @Override
    public void onError(String msg) {
        ZteSoftToast.show(this, msg);
    }

    @Override
    public void showLoading() {
        dismissLoading();
        progressDialog = CommonUtils.showLoadingDialog(this);
    }

    @Override
    public void dismissLoading() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.cancel();
        }
    }
}
