package com.example.zengziqiang.rxjava2.service;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author zengziqiang
 * @e-mail iszengziqiang@163.com
 * @date on 2018/4/2
 * @desc
 */

public interface SerciceApi {

    //天气请求
    @GET("v1/weather/query")
    public Flowable<String> getWeather(@Query("key") String key,@Query("city") String city,@Query("province") String province);


}
