package com.example.zengziqiang.rxjava2.utils;

import android.app.Application;
import android.content.Context;

/**
 * @author zengziqiang
 * @e-mail iszengziqiang@163.com
 * @date on 2018/4/3
 * @desc
 */

public class MyApp extends Application {

    public static Context appContext;

    @Override
    public void onCreate() {
        super.onCreate();
        if (appContext == null) {
            appContext = getApplicationContext();
        }
    }
}
