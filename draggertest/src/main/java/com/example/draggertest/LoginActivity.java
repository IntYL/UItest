package com.example.draggertest;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;

public class LoginActivity extends Activity implements ICommonView{

   Button btn_login;
    @Override
    public Context getContext() {
        return null;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dragger_layout);
        btn_login = findViewById(R.id.btn_login);

    }
}
