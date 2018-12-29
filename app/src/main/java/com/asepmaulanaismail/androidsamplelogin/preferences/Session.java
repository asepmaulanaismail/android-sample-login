package com.asepmaulanaismail.androidsamplelogin.preferences;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;

public class Session {
    private Activity activity;
    private SharedPreferences sharedPref;
    private String prefName = "com.asepmaulanaismail.androidsamplelogin.a89u39da8921";
    private final String KEY_IS_LOGGED_IN = "isLoggedIn";

    public Session(Activity activity){
        this.activity = activity;
        sharedPref = this.activity.getSharedPreferences(prefName, Context.MODE_PRIVATE);
    }

    public boolean isLoggedIn(){
        return sharedPref.getBoolean(KEY_IS_LOGGED_IN, false);
    }

    public void setSessionString(String name, String value){
        sharedPref.edit().putString(name, value);
        sharedPref.edit().commit();
    }

    public void setSessionBoolean(String name, Boolean value){
        sharedPref.edit().putBoolean(name, value);
        sharedPref.edit().commit();
    }

    public void signOut(){
        sharedPref.edit().clear().commit();
    }

    public boolean checkCredentials(final String email, final String password){
        // TODO: Change this code to ajax request for login
        setSessionString("USR_EMAIL", email);
        setSessionBoolean(KEY_IS_LOGGED_IN, true);
        return true;
    }
}
