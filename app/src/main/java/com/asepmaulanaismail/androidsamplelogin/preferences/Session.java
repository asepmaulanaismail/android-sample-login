package com.asepmaulanaismail.androidsamplelogin.preferences;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;

import com.asepmaulanaismail.androidsamplelogin.core.StaticValues;

import java.util.HashMap;

public class Session{
    private Context context;
    private SharedPreferences prefs;

    public Session(){

    }

    public Session(Activity activity){
        context = activity;
        prefs = this.context.getSharedPreferences(StaticValues.prefKey, Context.MODE_PRIVATE);
//        FuelManager.Companion.getInstance().setBasePath(StaticValues.basePath);
//        HashMap<String, String> headers = new HashMap<>();
//        headers.put("Content-Type", "application/json");
//        FuelManager.Companion.getInstance().setBaseHeaders(headers);
    }

    public void putString(String key, String value){
        prefs.edit().putString(key, value).commit();
    }

    public String getString(String key){
        return prefs.getString(key, "");
    }

    public void putBoolean(String key, Boolean value){
        prefs.edit().putBoolean(key, value).commit();
    }

    public Boolean getBoolean(String key){
        return prefs.getBoolean(key, false);
    }
}
