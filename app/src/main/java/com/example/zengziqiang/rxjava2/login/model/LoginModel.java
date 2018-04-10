package com.example.zengziqiang.rxjava2.login.model;

import com.example.zengziqiang.rxjava2.utils.OnListiner;

/**
 * @author zengziqiang
 * @e-mail iszengziqiang@163.com
 * @date on 2018/4/2
 * @desc
 */

public interface LoginModel<T> {


    void getDatas(OnListiner<T> onListiner);

    void toLogin(String username,String password,OnListiner<T> onListiner);
}
