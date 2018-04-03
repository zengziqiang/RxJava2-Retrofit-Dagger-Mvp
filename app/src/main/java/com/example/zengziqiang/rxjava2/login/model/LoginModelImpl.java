package com.example.zengziqiang.rxjava2.login.model;

import com.example.zengziqiang.rxjava2.service.SerciceApi;
import com.example.zengziqiang.rxjava2.utils.OnListiner;
import com.example.zengziqiang.rxjava2.utils.RetrofitHelper;

import org.reactivestreams.Subscription;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @author zengziqiang
 * @e-mail iszengziqiang@163.com
 * @date on 2018/4/2
 * @desc
 */

public class LoginModelImpl implements LoginModel {
    @Override
    public void getDatas(final OnListiner onListiner) {
        SerciceApi api = RetrofitHelper.getApi();
        Flowable<String> weather = api.getWeather("520520test", "南京", "江苏");
        weather.doOnSubscribe(new Consumer<Subscription>() {
            @Override
            public void accept(Subscription subscription) throws Exception {
                System.out.println("开始请求天气数据");
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        onListiner.onSuccess(s);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        onListiner.onFailure(throwable);
                    }
                });
    }
}
