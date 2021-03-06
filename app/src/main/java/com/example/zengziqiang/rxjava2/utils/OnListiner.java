package com.example.zengziqiang.rxjava2.utils;

/**
 * @author zengziqiang
 * @e-mail iszengziqiang@163.com
 * @date on 2018/4/2
 * @desc
 */

public interface OnListiner<T> {

    public void onSuccess(T t);

    public void onFailure(Throwable throwable);

}
