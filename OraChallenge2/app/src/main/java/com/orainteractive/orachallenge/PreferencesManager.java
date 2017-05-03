package com.orainteractive.orachallenge;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Jorge Vivas on 5/3/17.
 */

public class PreferencesManager {

    private static final String PREF_FILE_KEY = "com.orachallenge.PREFERENCE_FILE_KEY";
    private static final String KEY_USER_ID = "ora_user_id";

    private static SharedPreferences mSharedPreferences;
    private static PreferencesManager sInstance;

    private PreferencesManager(Context context) {
        mSharedPreferences = context.getSharedPreferences(PREF_FILE_KEY, Context.MODE_PRIVATE);
    }

    public static void init(Context context) {
        sInstance = new PreferencesManager(context);
    }

    public static void setUserId(int userId) {
        mSharedPreferences.edit().putInt(KEY_USER_ID, -1).apply();
    }

    public static int getUserId() {
        return mSharedPreferences.getInt(KEY_USER_ID, -1);
    }
}
