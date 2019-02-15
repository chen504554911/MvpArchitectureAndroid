package com.ztesoft.mvparchitectureandroid.data.network;

import com.ztesoft.mvparchitectureandroid.data.network.model.News;
import javax.inject.Inject;
import io.reactivex.Flowable;

/**
 * @author chenyx
 * @class describe
 * @time 2019/1/14 18:58
 * @chang time
 */
public class AppHttpHelper implements HttpHelper {
    private ApiRequest mApiRequest;

    @Inject
    public AppHttpHelper(ApiRequest apiRequest) {
        this.mApiRequest = apiRequest;
    }

    @Override
    public Flowable<NewsResponse<News>> getNews() {
        return mApiRequest.getNews("top", "c1f646b699352b695a35dc81a52fc996");
    }
}
