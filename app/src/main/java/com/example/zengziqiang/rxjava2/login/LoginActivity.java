package com.example.zengziqiang.rxjava2.login;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.zengziqiang.rxjava2.R;
import com.example.zengziqiang.rxjava2.login.presenter.LoginPresenter;
import com.example.zengziqiang.rxjava2.login.presenter.LoginPresenterImpl;
import com.example.zengziqiang.rxjava2.login.view.LoginView;
import com.example.zengziqiang.rxjava2.utils.BaseActivity;

public class LoginActivity extends BaseActivity implements View.OnClickListener, LoginView {


    private Button button_login, button_cookie;
    private EditText et_name, et_password;
//http://apicloud.mob.com/v1/weather/query?key=520520test&city=南京&province=江苏   get

    private LoginPresenter loginPresenter;

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void attachView() {
        loginPresenter = new LoginPresenterImpl(this);
    }

    @Override
    protected void initView() {
        button_login = findViewById(R.id.button_login);
        button_login.setOnClickListener(this);
        button_cookie = findViewById(R.id.button_cookie);
        button_cookie.setOnClickListener(this);
        et_name = findViewById(R.id.et_name);
        et_password = findViewById(R.id.et_password);
    }

    @Override
    protected void fetchData() {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_login:
                loginPresenter.getDatas();
                break;
            case R.id.button_cookie:
                loginPresenter.toLogin("13545280346", "1");
                break;
        }
    }
}
