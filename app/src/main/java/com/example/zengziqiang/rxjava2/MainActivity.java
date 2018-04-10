package com.example.zengziqiang.rxjava2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.zengziqiang.rxjava2.login.LoginActivity;
import com.example.zengziqiang.rxjava2.test.MapActivity;
import com.example.zengziqiang.rxjava2.test.Test01Activity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView btn_test1, btn_login, btn_map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        btn_test1 = findViewById(R.id.btn_test1);
        btn_test1.setOnClickListener(this);
        btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);
        btn_map = findViewById(R.id.btn_map);
        btn_map.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_test1:
                startActivity(new Intent(MainActivity.this, Test01Activity.class));
                break;
            case R.id.btn_login:
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                break;
            case R.id.btn_map:
                startActivity(new Intent(MainActivity.this, MapActivity.class));
                break;
        }
    }
}
