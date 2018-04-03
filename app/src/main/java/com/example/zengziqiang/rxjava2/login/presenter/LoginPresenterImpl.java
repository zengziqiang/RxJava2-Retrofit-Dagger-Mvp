package com.example.zengziqiang.rxjava2.login.presenter;

import com.example.zengziqiang.rxjava2.login.model.LoginModel;
import com.example.zengziqiang.rxjava2.login.model.LoginModelImpl;
import com.example.zengziqiang.rxjava2.login.view.LoginView;
import com.example.zengziqiang.rxjava2.utils.OnListiner;

/**
 * @author zengziqiang
 * @e-mail iszengziqiang@163.com
 * @date on 2018/4/2
 * @desc
 */

public class LoginPresenterImpl implements LoginPresenter {

    private LoginView loginView;
    private LoginModel loginModel;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        this.loginModel = new LoginModelImpl();
    }

    @Override
    public void getDatas() {
        loginModel.getDatas(new OnListiner() {
            @Override
            public void onSuccess(Object o) {
                System.out.println("请求成功的数据" + o.toString());
            }

            @Override
            public void onFailure(Throwable throwable) {
                throwable.printStackTrace();
                System.out.println("请求失败的数据" + throwable.getMessage());
            }
        });
    }
}

