package com.example.zengziqiang.rxjava2.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.zengziqiang.rxjava2.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * @author zengziqiang
 * @e-mail iszengziqiang@163.com
 * @date 2018/4/10
 * @desc map的用法：它的基本作用就是将一个observable通过某种函数关系，转换为另一种observable。
 */

public class MapActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_str, btn_list;

    private List<Integer> list_str = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        initView();
        initData();
    }

    private void initData() {
        list_str = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list_str.add(i);
        }
    }

    private void initView() {
        btn_str = findViewById(R.id.btn_str);
        btn_str.setOnClickListener(this);
        btn_list = findViewById(R.id.btn_list);
        btn_list.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_str:
                Observable.create(new ObservableOnSubscribe<Integer>() {
                    @Override
                    public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                        System.out.println("subscribe:" + 1);
                        emitter.onNext(1);
                        System.out.println("subscribe:" + 2);
                        emitter.onNext(2);
                        System.out.println("subscribe:" + 3);
                        emitter.onNext(3);
                    }
                }).map(new Function<Integer, String>() {
                    @Override
                    public String apply(Integer integer) throws Exception {
                        System.out.println("apply:" + integer);
                        return "改变后的值：" + integer;
                    }
                }).subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {
                        System.out.println("onNext:" + s);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
                break;
            case R.id.btn_list:
                Observable.fromIterable(list_str).map(new Function<Integer, String>() {
                    @Override
                    public String apply(Integer integer) throws Exception {
                        System.out.println("apply:" + integer);
                        return "改变后的值：" + integer;
                    }
                }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<String>() {
                            @Override
                            public void accept(String s) throws Exception {
                                System.out.println("accept:" + s);
                                btn_list.setText(String.valueOf(s));
                                Toast.makeText(MapActivity.this, s, Toast.LENGTH_LONG).show();
                            }
                        });

                Observable.concat(Observable.just(1, 2, 3), Observable.just("1")).subscribe(new Observer<Serializable>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Serializable serializable) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

                Single.create(new SingleOnSubscribe<String>() {
                    @Override
                    public void subscribe(SingleEmitter<String> emitter) throws Exception {

                    }
                }).subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        System.out.println("====Single:" + s);
                    }
                });
                break;
        }
    }
}
