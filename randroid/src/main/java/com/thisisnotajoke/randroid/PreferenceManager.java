package com.thisisnotajoke.randroid;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceManager {
    private static final String PREF_NAME = "Randroid";
    private static final String PREF_COINS = "PreferenceManager.coins";

    private SharedPreferences mPrefs;

    public PreferenceManager(Context context) {
        mPrefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public void setCoins(int coins) {
        mPrefs.edit().putInt(PREF_COINS, coins).commit();
    }

    public int getCoins() {
        return mPrefs.getInt(PREF_COINS, 1);
    }
}
