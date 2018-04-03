package com.example.zengziqiang.rxjava2.utils;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * @author zengziqiang
 * @e-mail iszengziqiang@163.com
 * @date on 2018/4/2
 * @desc
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        attachView();
        initView();
        fetchData();
    }

    protected abstract int getLayout();

    protected abstract void attachView();

    protected abstract void initView();

    protected abstract void fetchData();

}
