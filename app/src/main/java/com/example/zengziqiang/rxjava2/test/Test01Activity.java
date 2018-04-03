package com.example.zengziqiang.rxjava2.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.zengziqiang.rxjava2.R;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import okhttp3.OkHttpClient;

public class Test01Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test01);
        initView();
        initData();
    }

    private void initData() {
        // 第一步：初始化Observable被观察着
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                System.out.println("subscribe====1");
                emitter.onNext(2);
                System.out.println("subscribe====2");
                emitter.onNext(3);
                System.out.println("subscribe====3");
                emitter.onNext(4);
                System.out.println("subscribe====4");
            }
        }).subscribe(new Observer<Integer>() { // 第二步：初始化Observer观察者
            // 第三步：订阅
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("onSubscribe====" + d);
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("onNext====" + integer);
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete====");
            }
        });




    }

    private void initView() {

    }

}
