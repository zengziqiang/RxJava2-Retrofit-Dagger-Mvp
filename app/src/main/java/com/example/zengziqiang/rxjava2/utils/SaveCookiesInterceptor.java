package com.example.zengziqiang.rxjava2.utils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * @author zengziqiang
 * @e-mail iszengziqiang@163.com
 * @date on 2018/4/4
 * @desc
 */

public class SaveCookiesInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        if (chain == null) {
            //   Log.d("http", "Receivedchain == null");
            System.out.println("cookie为空");
        }
        Response originalResponse = chain.proceed(chain.request());
        // Log.d("http", "originalResponse" + originalResponse.toString());
        System.out.println("cookie携带的值有：" + originalResponse.toString());
        if (!originalResponse.headers("set-cookie").isEmpty()) {
            final StringBuffer cookieBuffer = new StringBuffer();
            Observable.from(originalResponse.headers("set-cookie"))
                    .map(new Func1<String, String>() {
                        @Override
                        public String call(String s) {
                            String[] cookieArray = s.split(";");
                            return cookieArray[0];
                        }
                    })
                    .subscribe(new Action1<String>() {
                        @Override
                        public void call(String cookie) {
                            cookieBuffer.append(cookie).append(";");
                            System.out.println("cookie====:" + cookieBuffer.toString());
                        }
                    });
        }

        return originalResponse;
    }
}
