package virtual.camera.camera;

import android.content.Context;
import android.content.SharedPreferences;

public class MultiPreferences {
    private static volatile MultiPreferences sInstance;
    private SharedPreferences mPrefs;

    private MultiPreferences() {
        try {
            Context context = virtual.camera.app.app.App.Companion.getApp();
            if (context != null) {
                mPrefs = context.getSharedPreferences("vcamera_prefs", Context.MODE_PRIVATE);
            }
        } catch (Throwable ignored) {
        }
    }

    public static MultiPreferences getInstance() {
        if (sInstance == null) {
            synchronized (MultiPreferences.class) {
                if (sInstance == null) {
                    sInstance = new MultiPreferences();
                }
            }
        }
        return sInstance;
    }

    public boolean getBoolean(String key, boolean defValue) {
        if (mPrefs != null) return mPrefs.getBoolean(key, defValue);
        return defValue;
    }

    public void setBoolean(String key, boolean value) {
        if (mPrefs != null) mPrefs.edit().putBoolean(key, value).apply();
    }

    public int getInt(String key, int defValue) {
        if (mPrefs != null) return mPrefs.getInt(key, defValue);
        return defValue;
    }

    public void setInt(String key, int value) {
        if (mPrefs != null) mPrefs.edit().putInt(key, value).apply();
    }

    public String getString(String key, String defValue) {
        if (mPrefs != null) return mPrefs.getString(key, defValue);
        return defValue;
    }

    public void setString(String key, String value) {
        if (mPrefs != null) mPrefs.edit().putString(key, value).apply();
    }
}
