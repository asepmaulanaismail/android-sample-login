package com.asepmaulanaismail.androidsamplelogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.asepmaulanaismail.androidsamplelogin.core.StaticValues;
import com.asepmaulanaismail.androidsamplelogin.preferences.Session;

public class MainActivity extends AppCompatActivity {
    Session session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        session = new Session(this);

        Button btnSignOut = findViewById(R.id.btn_sign_out);
        btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                session.putBoolean(StaticValues.KEY_IS_LOGGED_IN, false);
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
