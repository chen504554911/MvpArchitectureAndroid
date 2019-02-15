package com.ztesoft.mvparchitectureandroid.data.network;

import com.ztesoft.mvparchitectureandroid.data.network.model.News;
import io.reactivex.Flowable;

/**
 * @author chenyx
 * @class describe
 * @time 2019/1/14 18:57
 * @chang time
 */
public interface HttpHelper {
    Flowable<NewsResponse<News>> getNews();
}
