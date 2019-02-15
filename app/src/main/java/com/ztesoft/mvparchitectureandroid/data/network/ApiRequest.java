package com.ztesoft.mvparchitectureandroid.data.network;

import com.ztesoft.mvparchitectureandroid.data.network.model.News;
import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author chenyx
 * @class describe
 * @time 2019/1/14 16:13
 * @chang time
 */
public interface ApiRequest {
    public static final String SERVER = "http://v.juhe.cn/toutiao/";

    /**
     * 获取新闻资讯
     */
    @GET("index")
    Flowable<NewsResponse<News>> getNews(@Query("type") String type, @Query("key") String key);
}
