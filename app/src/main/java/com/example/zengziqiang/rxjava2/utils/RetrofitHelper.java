package com.example.zengziqiang.rxjava2.utils;

import com.example.zengziqiang.rxjava2.service.SerciceApi;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * @author zengziqiang
 * @e-mail iszengziqiang@163.com
 * @date on 2018/4/2
 * @desc
 */

public class RetrofitHelper {

    private static OkHttpClient client;
    private static SerciceApi api;

    static {
        //initOkHttp();
    }

    //    private static void initOkHttp() {
//        if (client == null) {
//            synchronized (OkHttpClient.class) {
//                if (client == null) {
//                    client = new OkHttpClient.Builder().build();
//
//                }
//            }
//        }
//    }
    private static void initOkHttp() {
        if (client == null) {
            synchronized (OkHttpClient.class) {
                if (client == null) {
                    client = new OkHttpClient();
                    //todo  加拦截器
                    client.interceptors().add(new SaveCookiesInterceptor());
                }
            }
        }
    }

    public static SerciceApi getApi() {
        if (api == null) {
            synchronized (SerciceApi.class) {
                if (api == null) {
                    api = RetrofitHelper.create(SerciceApi.class, URL_Constants.API_BASE);
                }
            }
        }
        return api;
    }

    private static <T> T create(Class<T> tClass, String baseUrl) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(new SaveCookiesInterceptor()).build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//将Callable接口转换成Observable接口
                .addConverterFactory(ScalarsConverterFactory.create())//string数据转换
                .build();
        return retrofit.create(tClass);
    }

}
