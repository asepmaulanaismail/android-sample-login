package com.asepmaulanaismail.androidsamplelogin;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.asepmaulanaismail.androidsamplelogin.preferences.Session;

public class LoginActivity extends AppCompatActivity {
    Session session;
    LinearLayout layout;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        session = new Session(this);

        layout = findViewById(R.id.input_layout);
        progressBar = findViewById(R.id.progress_bar);
        Button btnSignin = findViewById(R.id.btn_sign_in);
        final EditText inputEmail = findViewById(R.id.input_email);
        final EditText inputPassword = findViewById(R.id.input_password);

        progressBar.setVisibility(View.GONE);
        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setLoading(true);
                String strEmail = inputEmail.getText().toString();
                String strPassword = inputPassword.getText().toString();

                if ("".equals(strEmail.trim())){
                    Toast.makeText(LoginActivity.this, "Email could'n be empty.", Toast.LENGTH_LONG).show();
                    setLoading(false);
                    inputEmail.requestFocus();
                    return;
                }

                if ("".equals(strPassword.trim())){
                    Toast.makeText(LoginActivity.this, "Password could'n be empty.", Toast.LENGTH_LONG).show();
                    setLoading(false);
                    inputPassword.requestFocus();
                    return;
                }else if (strPassword.length() < 8){
                    Toast.makeText(LoginActivity.this, "Password should be at least 8 characters.", Toast.LENGTH_LONG).show();
                    inputPassword.requestFocus();
                    return;
                }

                boolean isLoginSuccess = session.checkCredentials(strEmail, strPassword);
                if (isLoginSuccess){
                    // TODO: remove this delay if you have requested credentials to API
                    Handler h = new Handler();
                    h.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }, 1000);
                }else{
                    Toast.makeText(LoginActivity.this, "Invalid credentials.", Toast.LENGTH_LONG).show();
                    setLoading(false);
                    inputEmail.requestFocus();
                    return;
                }
            }
        });
    }

    public void setLoading(Boolean value){
        layout.setVisibility(value?View.GONE:View.VISIBLE);
        progressBar.setVisibility(!value?View.GONE:View.VISIBLE);
    }
}
