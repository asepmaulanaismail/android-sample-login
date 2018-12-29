package com.asepmaulanaismail.androidsamplelogin;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.asepmaulanaismail.androidsamplelogin.preferences.Session;

public class SplashActivity extends AppCompatActivity {
    private Session session;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        session =  new Session(this);
        context = this;
        Handler handler = new Handler();

        // delay 1000 ms
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (session.isLoggedIn()){
                    Intent intent = new Intent(context, MainActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Intent intent = new Intent(context, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        }, 1000);
    }
}
