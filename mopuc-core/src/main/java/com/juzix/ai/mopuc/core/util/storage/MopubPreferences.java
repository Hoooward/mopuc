package com.juzix.ai.mopuc.core.util.storage;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.juzix.ai.mopuc.core.app.Mopuc;

public final class MopubPreferences {

    private static final SharedPreferences PERFERENCES =
            PreferenceManager.getDefaultSharedPreferences(Mopuc.getApplicationContext());
    private static final String APP_PREFERENCES_KEY = "profile";

    private static SharedPreferences getAppPreference() {
        return PERFERENCES;
    }

    public static void setAppProfile(String val) {
        getAppPreference().edit().putString(APP_PREFERENCES_KEY, val).apply();
    }

    public static String getAppProfile() {
        return getAppPreference().getString(APP_PREFERENCES_KEY, null);
    }

    public static JSONObject getAppProfileJson() {
        final String profile = getAppProfile();
        return JSON.parseObject(profile);
    }

    public static void removeAppProfile() {
        getAppPreference().edit().remove(APP_PREFERENCES_KEY).apply();
    }

    public static void clearAppPreferences() {
        getAppPreference().edit().clear().apply();
    }

    public static void setAppFlag(String key, boolean flag) {
        getAppPreference().edit().putBoolean(key, flag).apply();
    }

    public static boolean getAppFlag(String key) {
        return getAppPreference().getBoolean(key, false);
    }
}
