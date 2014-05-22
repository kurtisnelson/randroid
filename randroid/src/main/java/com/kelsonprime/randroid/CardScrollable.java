package com.kelsonprime.randroid;

import android.view.View;
import android.view.ViewGroup;

public interface CardScrollable {
    int getItemViewType();

    View getView(View convertView, ViewGroup parent);
}
