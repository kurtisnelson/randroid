package com.thisisnotajoke.randroid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;

import com.google.android.glass.touchpad.Gesture;
import com.google.android.glass.touchpad.GestureDetector;
import com.google.android.glass.view.WindowUtils;
import com.kelsonprime.randroid.R;

public class FlipActivity extends SingleFragmentActivity{
    private static final String FLIP_COUNT = "FlipActivity.count";
    private static final String TAG = "FlipActivity";
    private int mCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(getIntent().hasExtra(FLIP_COUNT)){
            mCount = getIntent().getExtras().getInt(FLIP_COUNT);
        } else {
            mCount = new PreferenceManager(this).getCoins();
        }

        new PreferenceManager(this).setCoins(mCount);


        //FLIP_A_COIN for whatever stupid reason is available on the main menu but not contextually?
        //getWindow().requestFeature(WindowUtils.FEATURE_VOICE_COMMANDS);
        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.coin, menu);
        return true;
    }

    @Override
    public boolean onCreatePanelMenu(int featureId, Menu menu) {
        if (featureId == WindowUtils.FEATURE_VOICE_COMMANDS) {
            getMenuInflater().inflate(R.menu.coin_voice, menu);
            return true;
        }
        // Pass through to super to setup touch menu.
        return super.onCreatePanelMenu(featureId, menu);
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        if (featureId == WindowUtils.FEATURE_VOICE_COMMANDS) {
            switch (item.getItemId()) {
                case R.id.menu_coin_voice_flip:
                    newInstance(FlipActivity.this, mCount);
                    break;
                default:
                    return true;
            }
            return true;
        }
        // Good practice to pass through to super if not handled
        return super.onMenuItemSelected(featureId, item);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_coin_flip:
                newInstance(this, mCount);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected Fragment getFragment() {
        return FlipFragment.newInstance(mCount);
    }

    public static void newInstance(Context c, int count) {
        Intent i = new Intent(c, FlipActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        Bundle b = new Bundle();
        b.putInt(FLIP_COUNT, count);
        i.putExtras(b);
        c.startActivity(i);
    }
}

