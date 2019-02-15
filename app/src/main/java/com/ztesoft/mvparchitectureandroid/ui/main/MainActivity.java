package com.ztesoft.mvparchitectureandroid.ui.main;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ztesoft.mvparchitectureandroid.R;
import com.ztesoft.mvparchitectureandroid.contract.MainContract;
import com.ztesoft.mvparchitectureandroid.data.db.model.User;
import com.ztesoft.mvparchitectureandroid.data.network.model.News;
import com.ztesoft.mvparchitectureandroid.presenter.MainPresenter;
import com.ztesoft.mvparchitectureandroid.ui.base.BaseActivity;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends BaseActivity implements MainContract.View {
    @Inject
    MainPresenter<MainContract.View> mainPresenter;
    @BindView(R.id.btn_get_news)
    Button btnGetNews;
    @BindView(R.id.tv_show_news)
    TextView tvShowNews;
    @BindView(R.id.btn_get_sp_login)
    Button btnSpLogin;
    @BindView(R.id.tv_show_sp_login)
    TextView tvSpLogin;
    @BindView(R.id.tv_show_db_user)
    TextView tvDbUser;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        getActivityComponent().inject(this);
        mainPresenter.onAttach(this);
    }

    @OnClick({R.id.btn_get_news, R.id.btn_get_sp_login, R.id.btn_set_db_user, R.id.btn_get_db_user})
    protected void onClickEvent(View view) {
        switch (view.getId()) {
            case R.id.btn_get_news:
                mainPresenter.getNews();
                break;
            case R.id.btn_get_sp_login:
                mainPresenter.getSpLogin();
                break;
            case R.id.btn_set_db_user:
                mainPresenter.setDbUser(new User(null, "cc"));
                break;
            case R.id.btn_get_db_user:
                mainPresenter.getDbUser();
                break;
        }
    }

    @Override
    public void showNews(List<News.DataBean> news) {
        if (news.size() == 0) return;
        tvShowNews.setText(news.get(0).getTitle());
    }

    @Override
    public void showSpLogin(String name) {
        tvSpLogin.setText(name);
    }

    @Override
    public void showDbUser(User user) {
        tvDbUser.setText(user.getName());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mainPresenter != null) {
            mainPresenter.onDetach();
        }
    }

    private final OkHttpClient client = new OkHttpClient();

    public void readSource() throws Exception {
        Request request = new Request.Builder()
                .url("https://publicobject.com/helloworld.txt")
                .build();

//        try (Response response = client.newCall(request).execute()) {
//            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
//
//            Headers responseHeaders = response.headers();
//            for (int i = 0; i < responseHeaders.size(); i++) {
//                System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
//            }
//
//            System.out.println(response.body().string());
//        }

//        client.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//
//            }
//        });
    }
}
