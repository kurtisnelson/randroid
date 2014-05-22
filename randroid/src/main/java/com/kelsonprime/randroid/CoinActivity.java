package com.kelsonprime.randroid;

import android.os.Bundle;
import android.support.v4.app.Fragment;

public class CoinActivity extends SingleFragmentActivity {
    @Override
    protected Fragment getFragment() {
        return new CoinScrollFragment();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
