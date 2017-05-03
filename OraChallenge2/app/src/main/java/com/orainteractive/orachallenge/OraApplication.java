package com.orainteractive.orachallenge;

import android.app.Application;
import android.content.Context;
import android.support.v7.app.AppCompatDelegate;

/**
 * Created by Jorge Vivas on 5/2/17.
 */

public class OraApplication extends Application {

    private Context mContext;
    private static OraApplication sApplication;

    public static OraApplication getInstance() {
        return sApplication;
    }
    public Context getContext() {return  mContext; }


    @Override
    public void onCreate() {
        super.onCreate();
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        sApplication = this;
        mContext = getApplicationContext();
        PreferencesManager.init(this);
    }
}
