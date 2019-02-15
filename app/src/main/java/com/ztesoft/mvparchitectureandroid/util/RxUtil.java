package com.ztesoft.mvparchitectureandroid.util;

import org.reactivestreams.Publisher;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.FlowableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by codeest on 2016/8/3.
 */
public class RxUtil {

    /**
     * 统一线程处理
     *
     * @param <T>
     * @return
     */
    public static <T> FlowableTransformer<T, T> rxSchedulerHelper() {    //compose简化线程
        return new FlowableTransformer<T, T>() {
            @Override
            public Publisher<T> apply(Flowable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    /**
     * 统一返回结果处理
     *
     * @param <T>
     * @return
     */
//    public static <T> FlowableTransformer<NewsResponse<T>, T> handleResult() {   //compose判断结果
//
//        return new FlowableTransformer<NewsResponse<T>, T>() {
//            @Override
//            public Publisher<T> apply(Flowable<NewsResponse<T>> upstream) {
//                return upstream.flatMap(new Function<NewsResponse<T>, Publisher<T>>() {
//                    @Override
//                    public Publisher<T> apply(NewsResponse<T> tNewsResponse) throws Exception {
//                        if (tNewsResponse.error_code == 0) {
//                            return createData(tNewsResponse.getResult());
//                        } else {
//                            return Flowable.error(new ApiException("服务器返回error"));
//                        }
//                    }
//                });
//            }
//        };
//        return new FlowableTransformer<NewsResponse<T>, T>() {
//            @Override
//            public Flowable<T> apply(Flowable<NewsResponse<T>> httpResponseFlowable) {
//                return httpResponseFlowable.flatMap(new Function<NewsResponse<T>, Flowable<T>>() {
//                    @Override
//                    public Flowable<T> apply(NewsResponse<T> tGankHttpResponse) {
//                        if (tGankHttpResponse.error_code == 0) {
//                            return createData(tGankHttpResponse.getResult());
//                        } else {
//                            return Flowable.error(new ApiException("服务器返回error"));
//                        }
//                    }
//                });
//            }
//        };
//    }
//
//    /**
//     * 统一返回结果处理
//     * @param <T>
//     * @return
//     */
//    public static <T> FlowableTransformer<WXHttpResponse<T>, T> handleWXResult() {   //compose判断结果
//        return new FlowableTransformer<WXHttpResponse<T>, T>() {
//            @Override
//            public Flowable<T> apply(Flowable<WXHttpResponse<T>> httpResponseFlowable) {
//                return httpResponseFlowable.flatMap(new Function<WXHttpResponse<T>, Flowable<T>>() {
//                    @Override
//                    public Flowable<T> apply(WXHttpResponse<T> tWXHttpResponse) {
//                        if(tWXHttpResponse.getCode() == 200) {
//                            return createData(tWXHttpResponse.getNewslist());
//                        } else {
//                            return Flowable.error(new ApiException(tWXHttpResponse.getMsg(), tWXHttpResponse.getCode()));
//                        }
//                    }
//                });
//            }
//        };
//    }
//
//    /**
//     * 统一返回结果处理
//     * @param <T>
//     * @return
//     */
//    public static <T> FlowableTransformer<MyHttpResponse<T>, T> handleMyResult() {   //compose判断结果
//        return new FlowableTransformer<MyHttpResponse<T>, T>() {
//            @Override
//            public Flowable<T> apply(Flowable<MyHttpResponse<T>> httpResponseFlowable) {
//                return httpResponseFlowable.flatMap(new Function<MyHttpResponse<T>, Flowable<T>>() {
//                    @Override
//                    public Flowable<T> apply(MyHttpResponse<T> tMyHttpResponse) {
//                        if(tMyHttpResponse.getCode() == 200) {
//                            return createData(tMyHttpResponse.getData());
//                        } else {
//                            return Flowable.error(new ApiException(tMyHttpResponse.getMessage(), tMyHttpResponse.getCode()));
//                        }
//                    }
//                });
//            }
//        };
//    }
//
//    /**
//     * 统一返回结果处理
//     * @param <T>
//     * @return
//     */
//    public static <T> FlowableTransformer<GoldHttpResponse<T>, T> handleGoldResult() {   //compose判断结果
//        return new FlowableTransformer<GoldHttpResponse<T>, T>() {
//            @Override
//            public Flowable<T> apply(Flowable<GoldHttpResponse<T>> httpResponseFlowable) {
//                return httpResponseFlowable.flatMap(new Function<GoldHttpResponse<T>, Flowable<T>>() {
//                    @Override
//                    public Flowable<T> apply(GoldHttpResponse<T> tGoldHttpResponse) {
//                        if(tGoldHttpResponse.getResults() != null) {
//                            return createData(tGoldHttpResponse.getResults());
//                        } else {
//                            return Flowable.error(new ApiException("服务器返回error"));
//                        }
//                    }
//                });
//            }
//        };
//    }

    /**
     * 生成Flowable
     *
     * @param <T>
     * @return
     */
    public static <T> Flowable<T> createData(final T t) {
        return Flowable.create(new FlowableOnSubscribe<T>() {
            @Override
            public void subscribe(FlowableEmitter<T> emitter) throws Exception {
                try {
                    emitter.onNext(t);
                    emitter.onComplete();
                } catch (Exception e) {
                    emitter.onError(e);
                }
            }
        }, BackpressureStrategy.BUFFER);
    }
}
