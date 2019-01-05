package com.asepmaulanaismail.androidsamplelogin.core;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.asepmaulanaismail.androidsamplelogin.preferences.Session;

public class BaseActivity extends AppCompatActivity {
    protected Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        session = new Session(this);
    }

    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public void toastShort(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void toastLong(String message){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
